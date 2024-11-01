package Service;


import Persistence.DatabaseConnectionLite;
import RideShareService.grpcspringbootexample.*;
import io.grpc.stub.StreamObserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RideShareService extends RideShareServiceGrpc.RideShareServiceImplBase {
    //dbconn contains connection to database with parameters - Switch for Live database later
    DatabaseConnectionLite dbconn = new DatabaseConnectionLite();
    @Override
    public void OfferRide(OfferRideRequest request, StreamObserver<OfferRideResponse> responseStreamObserver){
        OfferRideResponse responseObj=null;

        int uniqueID=1;
        //Create Unique ID (Created as get row count in table + 1)
        //TODO: refactor this into DTO or other remake for getting unique ID
        try (Connection conn = dbconn.getConnection()) {
            java.sql.Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS tableCount FROM available_rideshare");
            rs.next();
            uniqueID = rs.getInt("tableCount")+1;
            rs.close();
        }catch (Exception e) {
            e.printStackTrace();  //TODO: Insert logger
        }

        //Insert statement
        try (   Connection conn = dbconn.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO available_rideshare (bookingid, availablespaces, status, startdato, starttime, startlocation, enddate, endtime,endlocation,price,bookingref) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?) RETURNING bookingref")) {

            pstmt.setString(1, Integer.toString(uniqueID));
            pstmt.setInt(2, request.getAvailablespaces());
            pstmt.setString(3, "Active");
            pstmt.setString(4, request.getStartdate());
            pstmt.setString(5, request.getStarttime());
            pstmt.setString(6, request.getStartlocation());
            pstmt.setString(7, request.getEnddate());
            pstmt.setString(8, request.getEndtime());
            pstmt.setString(9, request.getEndlocation());
            pstmt.setFloat(10, request.getPrice());
            pstmt.setString(11, request.getBookingref());

            // Execute the insert statement and retrieve the generated ID
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Build the created Farm object with the generated ID
                responseObj = OfferRideResponse.newBuilder()
                        .setMessage("SUCCESS - New Rideshare added based on Booking ref: " + rs.getString("bookingref") + ", with ID: " + uniqueID)
                        .setSuccess(true)
                        .build();
            }
            else{
                // Build the created Farm object with the generated ID
                responseObj = OfferRideResponse.newBuilder()
                        .setMessage("FAILED - Tried to add Rideshare based on Booking ref: " + request.getBookingref() + ", with ID: " + uniqueID)
                        .setSuccess(false)
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Consider logging this instead
        }
        responseStreamObserver.onNext(responseObj);
        responseStreamObserver.onCompleted();
    }
    @Override
    public void BookSeat(BookSeatRequest request, StreamObserver<BookSeatResponse> responseStreamObserver){
        BookSeatResponse responseObj=null;

        int uniqueID=1;
        //Create Unique ID (Created as get row count in table + 1)
        //TODO: refactor this into DTO or other remake for getting unique ID
        try (Connection conn = dbconn.getConnection()) {
            java.sql.Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS tableCount FROM booking_rideshare");
            rs.next();
            uniqueID = rs.getInt("tableCount")+1;
            rs.close();
        }catch (Exception e) {
            e.printStackTrace();  //TODO: Insert logger
        }

        //Insert statement
        try (   Connection conn = dbconn.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(
                        "INSERT INTO available_rideshare (bookingid, status, startdato, startlocation, enddate, endlocation, price, customerid,bookingref) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING bookingref")) {

            pstmt.setString(1, Integer.toString(uniqueID));
            pstmt.setString(2, "Active");
            pstmt.setString(3, null);
            pstmt.setString(4, request.getStartlocation());
            pstmt.setString(5, null);
            pstmt.setString(6, request.getEndlocation());
            pstmt.setString(7, request.getPrice());
            pstmt.setString(8, request.getCustomerid());
            pstmt.setString(9, request.getRideId());

            // Execute the insert statement and retrieve the generated ID
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Build the created Farm object with the generated ID
                responseObj = OfferRideResponse.newBuilder()
                        .setMessage("SUCCESS - New Rideshare added based on Booking ref: " + rs.getString("bookingref") + ", with ID: " + uniqueID)
                        .setSuccess(true)
                        .build();
            }
            else{
                // Build the created Farm object with the generated ID
                responseObj = OfferRideResponse.newBuilder()
                        .setMessage("FAILED - Tried to add Rideshare based on Booking ref: " + request.getRideId() + ", with ID: " + uniqueID)
                        .setSuccess(false)
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Consider logging this instead
        }
        responseStreamObserver.onNext(responseObj);
        responseStreamObserver.onCompleted();
    }
    @Override
    public void getClosestSuggestionsResults(TimePlace request, StreamObserver<AvailableRideshare> responseStreamObserver){
        AvailableRideshareList.Builder responseList = AvailableRideshareList.newBuilder();

        try (Connection conn = dbconn.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM available_rideshare ORDER BY id LIMIT 5;")) {

            //TODO: add more sorting and more business logic should be added to returning most relevant entries
            while (rs.next()) {
                AvailableRideshare responseItem = AvailableRideshare.newBuilder()
                        .setBookingid(rs.getString("bookingid"))
                        .setAvailablespaces(rs.getInt("availablespaces"))
                        .setStatus(rs.getString("status"))
                        .setStartdate(rs.getString("startdato"))
                        .setStarttime(rs.getString("starttime"))
                        .setStartlocation(rs.getString("startlocation"))
                        .setEnddate(rs.getString("enddate"))
                        .setEndtime(rs.getString("endtime"))
                        .setEndlocation(rs.getString("endlocation"))
                        .setPrice(rs.getString("price"))
                        .setBookingref(rs.getString("bookingref"))
                        .build();
                responseList.addResultList(responseItem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        responseStreamObserver.onNext(responseList.build());
        responseStreamObserver.onCompleted();


    }

}

package Repository;

import Model.RideShareRequest;
import Persistence.RideShareRequestDAOInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RideShareRequestHibernateImpl implements RideShareRequestDAOInterface {
    private final SessionFactory sessionFactory;

    public RideShareRequestHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RideShareRequest create(RideShareRequest request) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(request);  // Save the RideShareRequest entity
            transaction.commit();      // Commit the transaction
            return request;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error creating RideShareRequest", e);
        }
    }

    @Override
    public RideShareRequest create(int rideId, String status, String startDate, String startTime, String startLocation, String endDate, String endTime, String endLocation, float price, int customerId, int bookingRef) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            RideShareRequest request = new RideShareRequest(rideId, status, startDate, startTime, startLocation,
                    endDate, endTime, endLocation, price, customerId, bookingRef);
            session.persist(request);  // Save the RideShareRequest entity
            transaction.commit();      // Commit the transaction
            return request;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error creating RideShareRequest", e);
        }
    }

    @Override
    public List<RideShareRequest> readAll() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM RideShareRequest", RideShareRequest.class).list();  // List all requests
        } catch (Exception e) {
            throw new SQLException("Error reading all RideShareRequests", e);
        }
    }

    @Override
    public void update(RideShareRequest request) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(request);  // Update the RideShareRequest entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error updating RideShareRequest", e);
        }
    }

    @Override
    public void delete(int registrationNumber) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            RideShareRequest request = session.get(RideShareRequest.class, registrationNumber);  // Retrieve by registration number
            if (request != null) {
                session.delete(request);  // Delete the RideShareRequest entity
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error deleting RideShareRequest", e);
        }
    }

    @Override
    public RideShareRequest read(int registrationNumber) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(RideShareRequest.class, registrationNumber);  // Retrieve by registration number
        } catch (Exception e) {
            throw new SQLException("Error reading RideShareRequest", e);
        }
    }

    @Override
    public List<RideShareRequest> ReadAllByCustomerId(int customerId) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM RideShareRequest WHERE customerId = :inputNumber", RideShareRequest.class)
                    .setParameter("inputNumber", customerId)
                    .list();  // List all RideShareRequests for a specific customerId
        } catch (Exception e) {
            throw new SQLException("Error reading RideShareRequests by CustomerId", e);
        }
    }

    @Override
    public List<RideShareRequest> ReadAllByRideShareRequest(int carBookingRef) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT * FROM RideShareRequest WHERE carBookingRef = :inputNumber", RideShareRequest.class)
                    .setParameter("inputNumber", carBookingRef)
                    .list();  // List all RideShareRequests for a specific carBookingRef
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SQLException("Error reading RideShareRequests by CarBookingRef", e);
        }
    }
}

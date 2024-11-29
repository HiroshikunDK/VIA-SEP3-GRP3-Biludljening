//Resource used for making the test Suite
//https://stackoverflow.com/questions/37552468/how-to-unit-test-grpc-java-server-implementation-functions

import Model.RideShareOffer;
import Repository.RideShareOfferHibernateImpl;
import RideShareService.grpc.RideShareServiceGrpc;
import RideShareService.grpc.Rideshare;
import RideShareService.grpc.Rideshare.RideshareOffer;
import Service.RideshareService;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.inprocess.InProcessChannelBuilder;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InProcessServerTest {
    private static final Logger logger = Logger.getLogger(InProcessServerTest.class.getName());
    private RideShareOfferHibernateImpl rso = new RideShareOfferHibernateImpl(new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
    private InProcessServer<RideshareService> inprocessServer;
    private ManagedChannel channel;

    private RideShareServiceGrpc.RideShareServiceBlockingStub blockingStub;
    private RideShareServiceGrpc.RideShareServiceStub asyncStub;

    public InProcessServerTest() {
        super();
    }

    @Before
    public void init() {
        //Get test objects and add them if they dont exits
        List<RideshareOffer> testObjects = makeTestObjectsRideShareOffers();
        for(RideshareOffer r : testObjects){
            try{
            RideShareOffer rt = rso.read(r.getRideId());
                //if the entry doesn't exist
                if(rt.getRideId()==null){
                    //create it
                    rso.create(convertToRideShareOffer(r));
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Test
    public void CreateRideShareOfferTestInProcessServer() throws InterruptedException{
        try {
            RideshareOffer offerTest = RideshareOffer.newBuilder()
                    .setRideId("RIDETEST")
                    .setAvailablespaces(3)
                    .setStatus("partially booked")
                    .setStartdate("2024-12-01")
                    .setStarttime("08:30:00")
                    .setStartlocation("123 Main St, Cityville")
                    .setEnddate("2024-12-01")
                    .setEndtime("09:00:00")
                    .setEndlocation("456 Elm St, Townville")
                    .setPrice(15.50f)
                    .setCustomerid("USER1001")
                    .setBookingref("BOOK1234")
                    .build();

            //Rideshare blockingStub.createRideShareOffer(offerTest);
            List<RideShareOffer> offers = rso.readAll();
            ArrayList<String> resultString = new ArrayList<>();
            for (Animal item : animals.getAnimalsList()) {
                resultString.add(item.getName());
            }
            Assert.assertArrayEquals(testString.toArray(),resultString.toArray());
        }catch (Exception e){
            System.out.println();
        }
        finally {
            shutdown();
        }
    }

    @Test
    public void getProductsFromAnimalTestInProcessServer() throws InterruptedException{
        try {
            List<Integer> testString = new ArrayList<>();
            testString.add(100001);
            testString.add(100002);

            AniProRegistrationList products = getProductsFromAnimalTest();
            List<Integer> resultString = new ArrayList<>();
            for (AniProRegistration item : products.getResultListList()) {
                resultString.add(item.getRegNr());
            }

            Assert.assertArrayEquals(testString.toArray(),resultString.toArray());

        } finally {
            shutdown();
        }
    }


    /** Tracking Service GRPC getAnimalFromProductRegistation*/
    public AnimalList getAnimalFromProductRegistationTest() {
        AnimalList response;
        //GRPC version of new object
        AniProRegistration searchObj = AniProRegistration.newBuilder()
                .setId(1)
                .setRegNr(100001)
                .setProductionDate("")
                .setWeight(1)
                .setAnimalRegNr(1)
                .setProductRegNr(1)
                .build();

        try {
            response = blockingStub.getAnimalFromProductRegistation(searchObj);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            fail();
            return null;
        }
        return response;
    }

    /** Tracking Service GRPC getAnimalFromProductRegistation*/
    public AniProRegistrationList getProductsFromAnimalTest() {
        AniProRegistrationList response;
        //GRPC version of new object
        Animal searchObj = Animal.newBuilder()
                .setId(1)
                .setRegNr(101)
                .setName("Gurli")
                .setSpecies("Gris")
                .setSubSpecies("Protest Svin")
                .setBirthday("")
                .setWeight(0)
                .setFarmRegNr(1)
                .build();

        try {
            response = blockingStub.getProductsFromAnimal(searchObj);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            fail();
            return null;
        }
        return response;
    }


    @Before
    public void beforeEachTest() throws InstantiationException, IllegalAccessException, IOException {
        inprocessServer = new InProcessServer<RideshareService>(RideshareService.class);
        inprocessServer.start();
        channel = InProcessChannelBuilder
                .forName("test")
                .directExecutor()
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        blockingStub = RideShareServiceGrpc.newBlockingStub(channel);
        asyncStub = RideShareServiceGrpc.newStub(channel);
    }

    @After
    public void afterEachTest(){
        channel.shutdownNow();
        inprocessServer.stop();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private RideShareOffer convertToRideShareOffer(RideshareOffer offerProto) {
        return new RideShareOffer(
                offerProto.getRideId(),
                offerProto.getAvailablespaces(),
                offerProto.getStatus(),
                offerProto.getStartdate(),
                offerProto.getStarttime(),
                offerProto.getStartlocation(),
                offerProto.getEnddate(),
                offerProto.getEndtime(),
                offerProto.getEndlocation(),
                offerProto.getPrice(),
                offerProto.getCustomerid(),
                offerProto.getBookingref()
        );
    }

    public List<RideshareOffer> makeTestObjectsRideShareOffers() {
        List<RideshareOffer> rideshareOffers = new ArrayList<>();

        // Adding 10 RideshareOffer examples using gRPC generated setters
        RideshareOffer offer1 = RideshareOffer.newBuilder()
                .setRideId("RIDE12345")
                .setAvailablespaces(3)
                .setStatus("partially booked")
                .setStartdate("2024-12-01")
                .setStarttime("08:30:00")
                .setStartlocation("123 Main St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("09:00:00")
                .setEndlocation("456 Elm St, Townville")
                .setPrice(15.50f)
                .setCustomerid("USER1001")
                .setBookingref("BOOK1234")
                .build();
        rideshareOffers.add(offer1);

        RideshareOffer offer2 = RideshareOffer.newBuilder()
                .setRideId("RIDE12346")
                .setAvailablespaces(1)
                .setStatus("full")
                .setStartdate("2024-12-01")
                .setStarttime("09:00:00")
                .setStartlocation("789 Oak St, Cityville")
                .setEnddate("2024-12-01")
                .setEndtime("09:30:00")
                .setEndlocation("101 Pine St, Village")
                .setPrice(12.00f)
                .setCustomerid("USER1002")
                .setBookingref("BOOK1235")
                .build();
        rideshareOffers.add(offer2);

        RideshareOffer offer3 = RideshareOffer.newBuilder()
                .setRideId("RIDE12347")
                .setAvailablespaces(2)
                .setStatus("partially booked")
                .setStartdate("2024-12-02")
                .setStarttime("10:00:00")
                .setStartlocation("321 Maple Ave, Cityville")
                .setEnddate("2024-12-02")
                .setEndtime("10:30:00")
                .setEndlocation("654 Birch Rd, Townsville")
                .setPrice(10.25f)
                .setCustomerid("USER1003")
                .setBookingref("BOOK1236")
                .build();
        rideshareOffers.add(offer3);

        RideshareOffer offer4 = RideshareOffer.newBuilder()
                .setRideId("RIDE12348")
                .setAvailablespaces(0)
                .setStatus("full")
                .setStartdate("2024-12-02")
                .setStarttime("15:30:00")
                .setStartlocation("222 Cedar Ln, Cityville")
                .setEnddate("2024-12-02")
                .setEndtime("16:00:00")
                .setEndlocation("555 Willow St, Greenfield")
                .setPrice(20.00f)
                .setCustomerid("USER1004")
                .setBookingref("BOOK1237")
                .build();
        rideshareOffers.add(offer4);

        RideshareOffer offer5 = RideshareOffer.newBuilder()
                .setRideId("RIDE12349")
                .setAvailablespaces(4)
                .setStatus("partially booked")
                .setStartdate("2024-12-03")
                .setStarttime("07:45:00")
                .setStartlocation("123 Birch Ave, Downtown")
                .setEnddate("2024-12-03")
                .setEndtime("08:15:00")
                .setEndlocation("789 Maple Rd, Suburbia")
                .setPrice(8.75f)
                .setCustomerid("USER1005")
                .setBookingref("BOOK1238")
                .build();
        rideshareOffers.add(offer5);

        RideshareOffer offer6 = RideshareOffer.newBuilder()
                .setRideId("RIDE12350")
                .setAvailablespaces(5)
                .setStatus("partially booked")
                .setStartdate("2024-12-04")
                .setStarttime("11:00:00")
                .setStartlocation("567 Oak Ave, Uptown")
                .setEnddate("2024-12-04")
                .setEndtime("11:45:00")
                .setEndlocation("432 Pine St, Downtown")
                .setPrice(13.00f)
                .setCustomerid("USER1006")
                .setBookingref("BOOK1239")
                .build();
        rideshareOffers.add(offer6);

        RideshareOffer offer7 = RideshareOffer.newBuilder()
                .setRideId("RIDE12351")
                .setAvailablespaces(3)
                .setStatus("cancelled")
                .setStartdate("2024-12-05")
                .setStarttime("18:00:00")
                .setStartlocation("890 Cedar Ave, City Center")
                .setEnddate("2024-12-05")
                .setEndtime("18:30:00")
                .setEndlocation("345 Willow St, Lakeside")
                .setPrice(10.00f)
                .setCustomerid("USER1007")
                .setBookingref("BOOK1240")
                .build();
        rideshareOffers.add(offer7);

        RideshareOffer offer8 = RideshareOffer.newBuilder()
                .setRideId("RIDE12352")
                .setAvailablespaces(2)
                .setStatus("partially booked")
                .setStartdate("2024-12-06")
                .setStarttime("13:00:00")
                .setStartlocation("100 Pine Blvd, Seaside")
                .setEnddate("2024-12-06")
                .setEndtime("13:30:00")
                .setEndlocation("200 Oak Dr, Riverside")
                .setPrice(18.50f)
                .setCustomerid("USER1008")
                .setBookingref("BOOK1241")
                .build();
        rideshareOffers.add(offer8);

        RideshareOffer offer9 = RideshareOffer.newBuilder()
                .setRideId("RIDE12353")
                .setAvailablespaces(6)
                .setStatus("partially booked")
                .setStartdate("2024-12-07")
                .setStarttime("14:30:00")
                .setStartlocation("600 Maple St, Hilltop")
                .setEnddate("2024-12-07")
                .setEndtime("15:00:00")
                .setEndlocation("800 Elm Ave, Valleyview")
                .setPrice(22.00f)
                .setCustomerid("USER1009")
                .setBookingref("BOOK1242")
                .build();
        rideshareOffers.add(offer9);

        RideshareOffer offer10 = RideshareOffer.newBuilder()
                .setRideId("RIDE12354")
                .setAvailablespaces(0)
                .setStatus("full")
                .setStartdate("2024-12-07")
                .setStarttime("17:00:00")
                .setStartlocation("50 Willow Way, Oldtown")
                .setEnddate("2024-12-07")
                .setEndtime("17:45:00")
                .setEndlocation("150 Birch Ln, Newtown")
                .setPrice(25.00f)
                .setCustomerid("USER1010")
                .setBookingref("BOOK1243")
                .build();
        rideshareOffers.add(offer10);

        return rideshareOffers;
    }

}

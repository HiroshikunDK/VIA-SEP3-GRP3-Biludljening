package Repository;

import Model.RideShareOffer;
import Persistence.RideShareOfferDAOInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RideShareOfferHibernateImpl implements RideShareOfferDAOInterface {
    private final SessionFactory sessionFactory;

    public RideShareOfferHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RideShareOffer create(RideShareOffer offer) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(offer);  // Save the RideShareOffer entity
            transaction.commit();    // Commit the transaction
            return offer;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error creating RideShareOffer", e);
        }
    }

    @Override
    public RideShareOffer create(String rideId, int availableSpaces, String status, String startDate,
                                 String startTime, String startLocation, String endDate, String endTime,
                                 String endLocation, float price, String customerId, String bookingRef) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            RideShareOffer offer = new RideShareOffer(rideId, availableSpaces, status, startDate, startTime, startLocation, endDate, endTime, endLocation, price, customerId, bookingRef);
            session.persist(offer);  // Save the RideShareOffer entity
            transaction.commit();    // Commit the transaction
            return offer;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error creating RideShareOffer", e);
        }
    }

    @Override
    public RideShareOffer read(String id) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(RideShareOffer.class, id);  // Retrieve by id
        } catch (Exception e) {
            throw new SQLException("Error reading RideShareOffer", e);
        }
    }

    @Override
    public List<RideShareOffer> readAll() throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM RideShareOffer", RideShareOffer.class).list();  // Retrieve all RideShareOffers
        } catch (Exception e) {
            throw new SQLException("Error reading all RideShareOffers", e);
        }
    }

    @Override
    public void update(RideShareOffer offer) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(offer);  // Update the RideShareOffer entity
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error updating RideShareOffer", e);
        }
    }

    @Override
    public void delete(String id) throws SQLException {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            RideShareOffer offer = session.get(RideShareOffer.class, id);  // Retrieve by id
            if (offer != null) {
                session.delete(offer);  // Delete the RideShareOffer entity
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new SQLException("Error deleting RideShareOffer", e);
        }
    }

    @Override
    public List<RideShareOffer> ReadAllByCustomerId(String registrationNumber) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM RideShareOffer WHERE customerId = :registrationNumber", RideShareOffer.class)
                    .setParameter("registrationNumber", registrationNumber)
                    .list();  // Retrieve RideShareOffers by customerId
        } catch (Exception e) {
            throw new SQLException("Error reading RideShareOffers by CustomerId", e);
        }
    }

    @Override
    public List<RideShareOffer> ReadAllByCarBookingRef(String registrationNumber) throws SQLException {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM RideShareOffer WHERE carBookingRef = :registrationNumber", RideShareOffer.class)
                    .setParameter("registrationNumber", registrationNumber)
                    .list();  // Retrieve RideShareOffers by carBookingRef
        } catch (Exception e) {
            throw new SQLException("Error reading RideShareOffers by CarBookingRef", e);
        }
    }
}

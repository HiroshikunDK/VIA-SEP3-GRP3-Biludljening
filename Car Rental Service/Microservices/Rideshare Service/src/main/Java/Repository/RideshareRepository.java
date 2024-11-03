package Repository;

import Model.Rideshare;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class RideshareRepository implements IRideshareRepository {
    private final SessionFactory sessionFactory;

    public RideshareRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Rideshare createRideshare(Rideshare rideshare) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(rideshare);
            transaction.commit();
            return rideshare;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error creating Rideshare", e);
        }
    }

    @Override
    public Optional<Rideshare> getRideshareById(int rideId) {
        try (Session session = sessionFactory.openSession()) {
            Rideshare rideshare = session.get(Rideshare.class, rideId);
            return Optional.ofNullable(rideshare);
        }
    }

    @Override
    public List<Rideshare> listRideshares(int carId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Rideshare WHERE carId = :carId", Rideshare.class)
                    .setParameter("carId", carId)
                    .list();
        }
    }

    @Override
    public void addPassenger(int rideId, String passengerUsername) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Rideshare rideshare = session.get(Rideshare.class, rideId);
            if (rideshare != null && rideshare.getAvailableSeats() > 0) {
                rideshare.addPassenger(passengerUsername);
                session.merge(rideshare);  // Update the entity
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException("Error adding passenger to Rideshare", e);
        }
    }
}

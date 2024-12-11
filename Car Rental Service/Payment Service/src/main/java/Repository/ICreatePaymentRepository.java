package Repository;

import Model.Payment;

public interface ICreatePaymentRepository {
    Boolean createPayment(Payment payment);
}


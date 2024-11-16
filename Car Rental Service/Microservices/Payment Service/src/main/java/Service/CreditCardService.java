package Service;

import Model.CreditCard;
import PaymentService.grpc.PaymentServiceGrpc;
import Persistance.PasswordHelper;
import Repository.ICreditCardRepository;

public class CreditCardService extends PaymentServiceGrpc.PaymentServiceImplBase {

    private final ICreditCardRepository creditCardRepository;

    public CreditCardService(ICreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public void addCreditCard(CreditCard creditCard) {
        String hashedCreditCardNr = PasswordHelper.hashSensitiveData(creditCard.getCreditcardnr());
        String hashedCcv = PasswordHelper.hashSensitiveData(creditCard.getCcv());

        creditCard.setCreditcardnr(hashedCreditCardNr);
        creditCard.setCcv(hashedCcv);

        creditCardRepository.addCreditcard(creditCard);
    }
}

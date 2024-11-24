 package Repository;

import Model.CreditCard;

import java.util.List;

public interface ICreditCardRepository
{
    void addCreditcard(CreditCard creditcard);
    CreditCard getCreditcardById(long id);
    List<CreditCard> getallCreditcards();
    void deleteCreditcard(long id);
    void updateCreditcard(CreditCard creditcard);
}

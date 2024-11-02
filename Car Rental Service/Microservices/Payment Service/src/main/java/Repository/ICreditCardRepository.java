package Repository;

import Model.CreditCard;

import java.util.List;

public interface ICreditCardRepository
{
    void addCreditcard(CreditCard creditcard);
    List<CreditCard> getallCreditcards();
}
package Repository;

import Model.Creditcard;

import java.util.List;

public interface ICreditcardRepository
{
  void addCreditcard(Creditcard creditcard);
  List<Creditcard> getallCreditcards();
}

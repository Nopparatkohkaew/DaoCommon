package main.java;

import main.java.dao.customer.superAppTli.TransactionTypeDao;

public class MainTest {
  public static void main(String[] args) throws Exception {
    TransactionTypeDao transactionTypeDao = new TransactionTypeDao();
    System.out.println("args = " + transactionTypeDao.findIdByTransactionType("epayment"));
    //
  }
}

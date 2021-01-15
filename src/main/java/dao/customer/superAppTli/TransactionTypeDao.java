package main.java.dao.customer.superAppTli;

import main.java.model.customer.superAppTli.TransactionDto;
import main.java.utils.ConnectDBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionTypeDao {
  public Long findIdByTransactionType(String type) throws Exception {
    try (Connection con = ConnectDBUtils.getConnectionCustomer()) {
      StringBuilder sql = new StringBuilder();
      sql.append("select transection_id from ");
      sql.append(" superapp_tli.transection_type ");
      sql.append(" where upper(transection_type) = upper(?)");
      Object[] param = new Object[] {type};
      try (ResultSet rs = ConnectDBUtils.getResultSet(sql.toString(), param, con)) {
        return rs.next() ? rs.getLong("transection_id") : null;
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Long insertTransactionType(TransactionDto transaction) throws Exception {
    System.out.println(
        (String.format("[Start] InsertTransectionType param : %s", transaction.toString())));
    try (Connection con = ConnectDBUtils.getConnectionCustomer()) {
      StringBuilder sql = new StringBuilder();
      sql.append(" INSERT INTO superapp_tli.transection_type ");
      sql.append(" (transection_type) ");
      sql.append(" values(?) ");
      Object[] param = new Object[] {transaction.getTransactionType()};
      try (ResultSet rs = ConnectDBUtils.insertResultSet(sql.toString(), param, con)) {
        if (rs.next()) {
          return rs.getLong("transection_id");
        }
      }

    } catch (Exception e) {
      System.out.printf("Error InsertTransectionType : %s%n", e.getMessage());
      throw e;
    }
    return null;
  }
}

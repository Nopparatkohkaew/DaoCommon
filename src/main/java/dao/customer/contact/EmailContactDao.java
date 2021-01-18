package main.java.dao.customer.contact;
import main.java.utils.ConnectDBUtils;

import java.sql.Connection;

public class EmailContactDao {
  private final String EMAIL = "contact.email";

  public boolean insertEmailContact(String addressLine, String createUserCode, String systemId)
      throws Exception {
    try (Connection con = ConnectDBUtils.getConnectionCustomer()) {
      String sql = " INSERT INTO " + EMAIL +
              " (addr_line, create_user_code, create_time, " +
              " update_user_code, last_update, system_id, system_key) " +
              " VALUES( ?, ?, now(), ?, ''); ";
      Object[] param = new Object[] {addressLine, createUserCode, systemId};
      int rowNum = ConnectDBUtils.updateResultSet(sql, param, con);
      return !(rowNum == 0);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }

}

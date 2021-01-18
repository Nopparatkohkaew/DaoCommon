package main.java.utils;

import utility.database.ConnectionBean;
import utility.database.DBConnectionFile;

import java.io.File;
import java.sql.*;

public class ConnectDBUtils {

  public static Connection getConnection(String dataBase) throws Exception {
    Connection conn;
    try {
      File fileEncrypted = new File(Contains.pathConfigLinux);
      File EncryptKey = new File(Contains.pathKeyLinux);
      conn = getConnection(dataBase, fileEncrypted, EncryptKey);
      //          	conn = SecuredConnect.createConnection(dataBase);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    return conn;
  }

  public static Connection getConnectionByType(String type, String database) throws Exception {
    File fileEncrypted = null;
    File encryptKey = null;
    try {
      switch (type) {
        case "mac":
          fileEncrypted = new File(Contains.pathConfigMac);
          encryptKey = new File(Contains.pathKeyMac);
          break;
        case "window":
          fileEncrypted = new File(Contains.pathWindowConfig);
          encryptKey = new File(Contains.pathWindowKey);
          break;
        default:
          fileEncrypted = new File(Contains.pathConfigLinux);
          encryptKey = new File(Contains.pathKeyLinux);
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    return getConnection(database, fileEncrypted, encryptKey);
  }

  private static Connection getConnection(String database, File fileEncrypted, File encryptKey)
      throws ClassNotFoundException, SQLException {
    Connection conn;
    try {
      DBConnectionFile fileDB = new DBConnectionFile(fileEncrypted, encryptKey, database);
      ConnectionBean con = fileDB.getConnectionBean();
      String password = con.getPassword();
      String user = con.getUserName();
      String url =
          "jdbc:postgresql://"
              + con.getHostName()
              + ":"
              + con.getPortNo()
              + "/"
              + con.getDatabaseName()
              + "?stringtype=unspecified";
      if (con.getVendor().equals("postgresql")) Class.forName("org.postgresql.Driver");
      else Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    return conn;
  }

  public static Connection getCustomConnection(
      String hostName, String port, String dbName, String username, String password)
      throws Exception {
    Connection conn;
    try {
      String url =
          "jdbc:postgresql://" + hostName + ":" + port + "/" + dbName + "?stringtype=unspecified";
      System.out.printf("url : %s%n username :%s%n password %s%n", url, username, password);
      conn = DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
    return conn;
  }

  public static Connection getConnectionPolicy() throws Exception {
    return getConnection(Contains.policy);
  }

  public static Connection getConnectionCustomer() throws Exception {
    return getConnection(Contains.customer);
  }

  public static ResultSet getResultSet(String query, Object[] param, Connection con)
      throws Exception {
    try (PreparedStatement st = con.prepareStatement(query)) {
      if (param != null) {
        for (int i = 0; i < param.length; i++) {
          System.out.printf("index => %s | param => %s%n", i + 1, param[i]);
          st.setObject(i + 1, param[i]);
        }
      }
      System.out.printf("sql get => %s%n", st);
      return st.executeQuery();
    } catch (Exception e) {
      System.out.printf("Error GetSelectResultSet => %s%n", e.getMessage());
      throw e;
    }
  }

  public static int updateResultSet(String query, Object[] param, Connection con) throws Exception {
    try {
      try (PreparedStatement st = con.prepareStatement(query)) {
        for (int i = 0; i < param.length; i++) {
          System.out.printf("index => %s | param => %s%n", i + 1, param[i]);
          st.setObject(i + 1, param[i]);
        }
        System.out.printf("sql update => %s%n", st);
        return st.executeUpdate();
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.printf("Error UpdateResultSet => %s%n", e.getMessage());
      throw e;
    }
  }

  public static ResultSet insertResultSet(String query, Object[] param, Connection con)
      throws Exception {
    try {
      try (PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
        for (int i = 0; i < param.length; i++) {
          System.out.printf("index => %s | param => %s%n", i + 1, param[i]);
          st.setObject(i + 1, param[i]);
        }
        System.out.printf("sql insert => %s%n", st);
        return st.getGeneratedKeys();
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.printf("Error UpdateResultSet => %s%n", e.getMessage());
      throw e;
    }
  }

  public static void main(String[] args) throws Exception {
    Connection con = ConnectDBUtils.getConnection(Contains.customer);
//    Connection con = ConnectDBUtils.getConnectionByType(Contains.TYPE_MAC, Contains.customer);
    System.out.println("con.isClosed() = " + con.isClosed());
    con.close();
  }
}

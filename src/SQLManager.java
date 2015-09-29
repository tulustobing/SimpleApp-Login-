/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tulus
 */
public class SQLManager {

  private String driver;
  private String database;
  private String username;
  private String password;
  private String url;
  private Connection con;

  public SQLManager() {
    this.driver = "com.mysql.jdbc.Driver";
    this.database = "login";
    this.username = "root";
    this.password = "";
    this.url = "jdbc:mysql://localhost:3306/" + this.database;
  }

  public boolean isConnect() throws SQLException {
    try {
      Class.forName(this.driver);
      System.out.println("Sukses koneksi");
      this.con = DriverManager.getConnection(this.url, this.username, this.password);

      return true;
    } catch (SQLException ex) {
      System.out.println("Gagal maning");
      return false;
    } catch (ClassNotFoundException ex) {
      System.out.println("Gagal");
      return false;
    }
  }

  public ResultSet execute(String Sql) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeQuery(Sql);
    } catch (Exception e) {
      System.out.println(e);
      return null;
    }
  }

  public void executeUpdate(String sql) throws SQLException {
    Statement stmt = con.createStatement();
    stmt.executeUpdate(sql);
  }

}

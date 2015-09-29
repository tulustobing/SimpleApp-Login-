/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tulus
 */
public class SipmpleAppLogin {

  public static void main(String[] args) throws SQLException {
    // TODO code application logic here
    ResultSet rs = null;
    SQLManager sqlManager = new SQLManager();
    Account ac1 = new Account("jaka", "sableng");
    Account ac2 = new Account("wiro", "sembung");
    String sql = "";
    try {
      if (sqlManager.isConnect()) {
        sql = "DELETE FROM `account` WHERE 1";
        sqlManager.executeUpdate(sql);

        sql = "INSERT INTO `account`(`id`, `username`, `password`) VALUES ('1','" + ac1.getUsername() + "','" + ac1.getPassword() + "')";
        sqlManager.executeUpdate(sql);

        sql = "INSERT INTO `account`(`id`, `username`, `password`) VALUES ('2','" + ac2.getUsername() + "','" + ac2.getPassword() + "')";
        sqlManager.executeUpdate(sql);

        sql = "select * from account";
        rs = sqlManager.execute(sql);
        while (rs.next()) {
          System.out.print(rs.getString("username"));
          System.out.println(rs.getString("password"));
        }

        sql = "UPDATE `account` SET `password`=\"sembung\" WHERE `username` like 'jaka'";

        sqlManager.executeUpdate(sql);
        sql = "UPDATE `account` SET `password`='" + ac1.getPassword() + "' WHERE `username` LIKE '" + ac2.getUsername() + "'";
        sqlManager.executeUpdate(sql);

        sql = "select * from account where `username` like 'asd'";
        rs = sqlManager.execute(sql);
        if (!rs.isBeforeFirst()) {
          System.out.println("No data");
        }
        while (rs.next()) {
          System.out.print(rs.getString("username"));
          System.out.println(rs.getString("password"));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

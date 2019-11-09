package com.jdbc;

import java.sql.*;

public class MyDBconn {

      static  String  driver="com.mysql.cj.jdbc.Driver" ;
      static  String  url="jdbc:mysql://192.168.0.103:3306/lpp" ;
      static  String  user ="root";
      static  String  password="admin" ;
    public  static Connection getMyDBconn() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        System.out.println("Class.forName(driver);");
        Connection connection = DriverManager.getConnection(url,user,password);
        return  connection;
    }

    public static void  executeSQL(String SQL)  {
        Connection connection = null;
        try {
            connection = MyDBconn.getMyDBconn();
            PreparedStatement statement =connection.prepareStatement(SQL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+
                        rs.getInt(2)+
                        rs.getInt(3));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            }
        }


}

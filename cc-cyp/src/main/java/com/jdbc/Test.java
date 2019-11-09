package com.jdbc;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String sql ="select *  from t_amount;";
        MyDBconn.executeSQL(sql);
    }
}

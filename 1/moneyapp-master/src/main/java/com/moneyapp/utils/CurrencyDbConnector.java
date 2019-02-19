package com.moneyapp.utils;

import java.sql.*;
import java.util.Properties;


public class CurrencyDbConnector {
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    private static final String CONNECTION = "jdbc:mysql://127.0.0.1/Bank";

    public void connectToDbAndPrintContent() throws ClassNotFoundException, SQLException {

        Properties p = new Properties();
        p.put("user","root");
        p.put("password","q");
        Connection conn = DriverManager.getConnection(CONNECTION,p);
        Statement stmt = conn.createStatement();

        String strSelect = "select id, name, converterToDolar, code from Concurrency";
        System.out.println("The SQL query is: " + strSelect);
        System.out.println();

        ResultSet rset = stmt.executeQuery(strSelect);

        System.out.println("The records selected are:");
        int rowCount = 0;
        while(rset.next()) {
            double id = rset.getDouble("id");
            String name = rset.getString("name");
            double converterToDolar = rset.getDouble("converterToDolar");
            String code = rset.getString("code");
            System.out.println(id + " " + name + " " + converterToDolar + " " + code);
            ++rowCount;
        }
        System.out.println("Total number of records = " + rowCount);

    }
    /*Test case, example of use:
    public void connectToDbAndPrintContent() {
        Properties p = new Properties();
        p.put("user","root");
        p.put("password","q");
        Connection conn = DriverManager.getConnection(CONNECTION,p);
        Statement stmt = conn.createStatement();
        String strSelect = "select id, name, converterToDolar, code from Concurrency";
        ResultSet rset = stmt.executeQuery(strSelect);
        int rowCount = 0;
        while(rset.next()) {
            ++rowCount;
        }
        assertEquals(4, rowCount);
    }
    */

}
/*

*/


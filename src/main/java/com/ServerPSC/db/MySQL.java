package com.ServerPSC.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySQL
{
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/psctowns";
    private String userName = "root";
    String password = "";

    public List<String> getCity(String city) throws SQLException {
        List<String> list = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);
            String query = "SELECT PSC from towns where Town like  '" + city + "'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String result = rs.getString("PSC");

                list.add(result);

                System.out.println(result);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list;

    }

    public List<String> getCityByPSC(String psc) throws SQLException {
        List<String> list2 = new ArrayList<String>();
        try {
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection(url, userName, password);

            String query = "SELECT town from towns where psc like '" +psc+ "'";
            System.out.println(query);
            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String result2 = rs.getString("town");

                list2.add(result2);

                System.out.println(result2);
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return list2;

    }
}

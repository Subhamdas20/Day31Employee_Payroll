package com.bridgelabz;

import java.sql.*;

public class ConnectSQL {

    public static void main(String[] args) {
        String jdbcurl="jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName="root";
        String password="SubhamDas@20";
        Connection con;
        Statement statement ;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            con= DriverManager.getConnection(jdbcurl,userName,password);
            statement= con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from employee_payroll");
            while(resultSet.next()) {
            String name = resultSet.getString("name");
            System.out.println(name);
            int salary = resultSet.getInt("salary");
            System.out.println(salary);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

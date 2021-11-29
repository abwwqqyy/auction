package com.DBProject.auctionSystem.model.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.DBProject.auctionSystem.model.dvo.Data;

public class DataDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/auction";
    private static final String USER = "root";
    private static final String PASS = "*******";

    public String getQuery(String query){
        try {
            Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Successful...!");
            Statement stmt = myConn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            // column names and count
            ResultSetMetaData rsMetaData = res.getMetaData();
            //Retrieving the list of column names
            int count = rsMetaData.getColumnCount();
            List<String> colNames = new ArrayList<>();
            for(int i = 1; i<=count; i++) {
                colNames.add(rsMetaData.getColumnName(i));
            }
            // get result
            StringBuilder ret = new StringBuilder();
            while(res.next()){
                for(String s : colNames){
                    ret.append(s + ": " + res.getString(s)+", ");
                }
                ret.append(System.getProperty("line.separator"));
            }
//            Data resData = new Data();
//            resData.setContent(ret.toString());
//            return resData;
            return ret.toString();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

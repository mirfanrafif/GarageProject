/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author irfan
 */
public class DBHelper {
    private static Connection connection;
    
    public static void bukaKoneksi(){
        if (connection == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/bengkeldb?serverTimezone=UTC&autoReconnect=true&useSSL=false";
                String user = "admin";
                String password = "irfanRAFI";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                System.out.println("Error Koneksi : " + e);
            }
        }
    }
    
    public static int insertQueryGetId(String query){
        bukaKoneksi();
        int num = 0;
        int result = -1;
        
        try {
            Statement statement = connection.createStatement();
            num = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        
        return result;
    }
    
    public static boolean executeQuery(String query){
        bukaKoneksi();
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            
            result = true;
            
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static ResultSet selectQuery(String query){
        bukaKoneksi();
        ResultSet resultSet = null;
        
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultSet;
    }
}

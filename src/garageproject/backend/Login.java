/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject.backend;

import java.sql.ResultSet;

/**
 *
 * @author Irfan Rafif
 */
public class Login {
    public static void main(String[] args) {
        String username = "admin";
        String password = "user";
        
        try {
            String sql = "SELECT * FROM admin WHERE username = '" + username + "'";
            ResultSet rs = DBHelper.selectQuery(sql);
            
            while(rs.next()){
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {
                    System.out.println("Berhasil Login");
                }else{
                    System.out.println("Pasword Salah");
                }
            }
        } catch (Exception e) {
        }
    }
}

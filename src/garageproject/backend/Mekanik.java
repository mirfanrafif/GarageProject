/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject.backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author irfan
 */
public class Mekanik implements Transaction{
    private int id;
    private String nama;
    private String alamat;
    private String noHP;

    public Mekanik(String nama, String alamat, String noHP) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHP = noHP;
    }

    public Mekanik() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
    
    public ArrayList<Mekanik> getAll() {
        ArrayList<Mekanik> listMekanik = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Mekanik");
        
        try {
            while (rs.next()) {
                Mekanik mekanik = new Mekanik();
                mekanik.setId(Integer.valueOf(rs.getString("id_mekanik")));
                mekanik.setNama(rs.getString("nama_mekanik"));
                mekanik.setAlamat(rs.getString("alamat"));
                mekanik.setNoHP(rs.getString("no_hp"));
                listMekanik.add(mekanik);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMekanik;
    }
    
    public void getById(int id){
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Mekanik where id_mekanik = " + id);
        
        try {
            while (rs.next()) {
                this.setId(Integer.valueOf(rs.getString("id_mekanik")));
                this.setNama(rs.getString("nama_mekanik"));
                this.setAlamat(rs.getString("alamat"));
                this.setNoHP(rs.getString("no_hp"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void save() {
        if (this.id == 0) {
            String SQL = "INSERT INTO Mekanik(nama_mekanik, alamat, no_hp) VALUES ('" 
                    + this.nama + "', '" 
                    + this.alamat + "', '" 
                    + this.noHP + "')";
            this.id = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Mekanik SET nama_mekanik = '" + this.nama 
                    + "', alamat = '" + this.alamat 
                    + "', no_hp = '" + this.noHP
                    + "' WHERE id_mekanik = " + this.id + ";";
            DBHelper.executeQuery(SQL);
        }
    }

    
    public void delete() {
        String SQL = "DELETE FROM Mekanik WHERE id_mekanik = " + this.id;
        DBHelper.executeQuery(SQL);
    }
}

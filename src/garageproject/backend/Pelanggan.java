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
public class Pelanggan implements Transaction{

    private int id;
    private String nama;
    private String alamat;
    private String no_hp;

    public Pelanggan(String nama, String alamat, String no_hp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_hp = no_hp;
    }

    public Pelanggan() {
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

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    /**
     *
     * @return
     */
    
    public ArrayList<Pelanggan> getAll() {
        ArrayList<Pelanggan> listPelanggan = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Pelanggan");
        
        try {
            while (rs.next()) {
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.setId(Integer.valueOf(rs.getString("id_pelanggan")));
                pelanggan.setNama(rs.getString("nama_pelanggan"));
                pelanggan.setAlamat(rs.getString("alamat"));
                pelanggan.setNo_hp(rs.getString("no_hp"));
                listPelanggan.add(pelanggan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPelanggan;
    }
    
    public void getById(int id){
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Pelanggan where id_pelanggan = " + id);
        
        try {
            while (rs.next()) {
                this.setId(Integer.valueOf(rs.getString("id_pelanggan")));
                this.setNama(rs.getString("nama_pelanggan"));
                this.setAlamat(rs.getString("alamat"));
                this.setNo_hp(rs.getString("no_hp"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void save() {
        if (this.id == 0) {
            String SQL = "INSERT INTO Pelanggan(nama_pelanggan, alamat, no_hp) VALUES ('" 
                    + this.nama + "', '" 
                    + this.alamat + "', '" 
                    + this.no_hp + "')";
            this.id = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Pelanggan SET nama_pelanggan = '" + this.nama 
                    + "', alamat = '" + this.alamat 
                    + "', no_hp = '" + this.no_hp
                    + "' WHERE id_pelanggan = " + this.id + ";";
            DBHelper.executeQuery(SQL);
        }
    }

    
    public void delete() {
        String SQL = "DELETE FROM Pelanggan WHERE id_pelanggan = " + this.id;
        DBHelper.executeQuery(SQL);
    }
    
    
    
    
}

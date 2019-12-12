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
public class Kendaraan implements Transaction{
    private int id;
    private String nama;
    private String jenis;
    private String merk;
    private Pelanggan pelanggan;

    public Kendaraan(String nama, String jenis, String merk, Pelanggan pelanggan) {
        this.nama = nama;
        this.jenis = jenis;
        this.merk = merk;
        this.pelanggan = pelanggan;
    }

    public Kendaraan() {
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

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }
    
    public ArrayList<Kendaraan> getAll() {
        ArrayList<Kendaraan> listKendaraan = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Kendaraan");
        
        try {
            while (rs.next()) {
                Kendaraan kendaraan = new Kendaraan();
                kendaraan.setId(Integer.valueOf(rs.getString("id_kendaraan")));
                kendaraan.setNama(rs.getString("nama_kendaraan"));
                kendaraan.setJenis(rs.getString("jenis_kendaraan"));
                kendaraan.setMerk(rs.getString("merk_kendaraan"));
                
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.getById(Integer.valueOf(rs.getString("id_pelanggan")));
                
                kendaraan.setPelanggan(pelanggan);
                listKendaraan.add(kendaraan);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKendaraan;
    }
    
    public void save() {
        if (this.id == 0) {
            String SQL = "INSERT INTO Kendaraan(nama_kendaraan, jenis_kendaraan, "
                    + "merk_kendaraan, id_pelanggan) VALUES ('" 
                    + this.nama + "', '" 
                    + this.jenis + "', '" 
                    + this.merk + "', '" 
                    + this.pelanggan.getId() + "')";
            this.id = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Kendaraan SET nama_kendaraan = '" + this.nama 
                    + "', jenis_kendaraan = '" + this.jenis 
                    + "', merk_kendaraan = '" + this.merk
                    + "', id_pelanggan = '" + this.pelanggan.getId()
                    + "' WHERE id_kendaraan = " + this.id + ";";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM Kendaraan WHERE id_kendaraan = " + this.id;
        DBHelper.executeQuery(SQL);
    }

    @Override
    public void getById(int id) {
        Kendaraan kendaraan = new Kendaraan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Kendaraan where id_kendaraan = " + id);
        
        try {
            while (rs.next()) {
                this.setId(Integer.valueOf(rs.getString("id_kendaraan")));
                this.setNama(rs.getString("nama_kendaraan"));
                this.setJenis(rs.getString("jenis_kendaraan"));
                this.setMerk(rs.getString("nama_kendaraan"));
                Pelanggan pelanggan = new Pelanggan();
                pelanggan.getById(Integer.valueOf(rs.getString("id_pelanggan")));
                this.setPelanggan(pelanggan);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

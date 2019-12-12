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
public class Pelayanan implements Transaction{
    private int id;
    private String tanggal;
    private int biaya;
    private Kendaraan kendaraan;
    private Mekanik mekanik;

    public Pelayanan(String tanggal, int biaya, Kendaraan kendaraan, Mekanik mekanik) {
        this.tanggal = tanggal;
        this.biaya = biaya;
        this.kendaraan = kendaraan;
        this.mekanik = mekanik;
    }

    public Pelayanan() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Mekanik getMekanik() {
        return mekanik;
    }

    public void setMekanik(Mekanik mekanik) {
        this.mekanik = mekanik;
    }
    
    @Override
    public ArrayList<Pelayanan> getAll() {
        ArrayList<Pelayanan> listPelayanan = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Pelayanan");
        
        try {
            while (rs.next()) {
                Pelayanan pelayanan = new Pelayanan();
                pelayanan.setId(Integer.valueOf(rs.getString("id_pelayanan")));
                pelayanan.setTanggal(rs.getString("tanggal"));
                pelayanan.setBiaya(Integer.valueOf(rs.getString("biaya")));
                Kendaraan kendaraan = new Kendaraan();
                
                kendaraan.getById(Integer.valueOf(rs.getString("id_kendaraan")));
                pelayanan.setKendaraan(kendaraan);
                
                Mekanik mekanik = new Mekanik();
                mekanik.getById(Integer.valueOf(rs.getString("id_mekanik")));
                pelayanan.setMekanik(mekanik);
                listPelayanan.add(pelayanan);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPelayanan;
    }
    
    public void getById(int id){
        Pelayanan pelayanan = new Pelayanan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Pelayanan where id_pelayanan = " + id);
        
        try {
            while (rs.next()) {
                this.setId(Integer.valueOf(rs.getString("id_pelayanan")));
                this.setTanggal(rs.getString("tanggal"));
                this.setBiaya(Integer.valueOf(rs.getString("biaya")));
                
                Kendaraan kendaraan = new Kendaraan();
                kendaraan.getById(Integer.valueOf(rs.getString("id_kendaraan")));
                pelayanan.setKendaraan(kendaraan);
                
                Mekanik mekanik = new Mekanik();
                mekanik.getById(Integer.valueOf(rs.getString("id_mekanik")));
                pelayanan.setMekanik(mekanik);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void save() {
        if (this.id == 0) {
            String SQL = "INSERT INTO Pelayanan(tanggal, biaya, "
                    + "id_kendaraan, id_mekanik) VALUES (NOW(), '" 
                    + this.biaya + "', '" 
                    + this.kendaraan.getId() + "', '" 
                    + this.mekanik.getId()+ "')";
            this.id = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Pelayanan SET biaya = '" + this.biaya 
                    + "', id_kendaraan = '" + this.kendaraan.getId()
                    + "', id_mekanik = '" + this.mekanik.getId()
                    + "' WHERE id_pelayanan = " + this.id + ";";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM Pelayanan WHERE id_pelayanan = " + this.id;
        DBHelper.executeQuery(SQL);
    }
}

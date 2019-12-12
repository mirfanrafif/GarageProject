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
public class Pelayanan {
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
    
    public ArrayList<Pelayanan> getAll() {
        ArrayList<Pelayanan> listPelayanan = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Pelayanan");
        
        try {
            while (rs.next()) {
                Pelayanan pelayanan = new Pelayanan();
                pelayanan.setId(Integer.valueOf(rs.getString("id_pelayanan")));
                pelayanan.setTanggal(rs.getString("tanggal"));
                pelayanan.setBiaya(Integer.valueOf(rs.getString("biaya")));
                pelayanan.setKendaraan(
                        new Kendaraan().getById(
                                Integer.valueOf(rs.getString("id_kendaraan")
                                )
                        )
                );
                pelayanan.setMekanik(
                        new Mekanik().getById(
                                Integer.valueOf(rs.getString("id_mekanik"))
                        )
                );
                listPelayanan.add(pelayanan);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPelayanan;
    }
    
    public Pelayanan getById(int id){
        Pelayanan pelayanan = new Pelayanan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Pelayanan where id_pelayanan = " + id);
        
        try {
            while (rs.next()) {
                pelayanan.setId(Integer.valueOf(rs.getString("id_pelayanan")));
                pelayanan.setTanggal(rs.getString("tanggal"));
                pelayanan.setBiaya(Integer.valueOf(rs.getString("biaya")));
                pelayanan.setKendaraan(
                        new Kendaraan().getById(
                                Integer.valueOf(rs.getString("id_kendaraan")
                                )
                        )
                );
                pelayanan.setMekanik(
                        new Mekanik().getById(
                                Integer.valueOf(rs.getString("id_mekanik"))
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pelayanan;
    }
    
    public void save() {
        if (getById(id).getId() == 0) {
            String SQL = "INSERT INTO Pelayanan(tanggal, biaya, "
                    + "id_kendaraan, id_mekanik) VALUES ('" 
                    + this.tanggal + "', '" 
                    + this.biaya + "', '" 
                    + this.kendaraan.getId() + "', '" 
                    + this.mekanik.getId()+ "')";
            this.id = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Kendaraan SET tanggal = '" + this.tanggal 
                    + "', biaya = '" + this.biaya 
                    + "', id_kendaraan = '" + this.kendaraan.getId()
                    + "', id_mekanik = '" + this.mekanik.getId()
                    + "' WHERE id_pelayanan = " + this.id + ";";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete() {
        String SQL = "DELETE FROM Pelayanan WHERE pelayanan = " + this.id;
        DBHelper.executeQuery(SQL);
    }
}

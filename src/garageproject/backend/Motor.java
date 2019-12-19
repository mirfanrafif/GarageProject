/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject.backend;

/**
 *
 * @author Irfan Rafif
 */
public class Motor extends Kendaraan {

    private String[] servis = {
        "Pembersihan karburator",
        "Penyetelan karburator",
        "Pembersihan saringan udara",
        "Pemeriksaan dan penggantian oli",
        "Pembersihan busi",
        "Penyetelan dan pelumasan rantai roda",
        "Penyetelan rem depan dan belakang",
        "Pemeriksaan dan penambahan air aki",
        "Pemeriksaan lampu dan klakson"
    };

    public Motor() {
        super.setJenis("Motor");
    }

    public String[] getServis() {
        return servis;
    }

    public void setServis(String[] servis) {
        this.servis = servis;
    }
    
    
}

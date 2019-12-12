/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject.backend;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author irfan
 */
public class test {
    public static void main(String[] args) {
        DBHelper.bukaKoneksi();
        Pelanggan pelanggan1 = new Pelanggan("Irfan", "Malang", "1234");
        Pelanggan pelanggan2 = new Pelanggan("Rafif", "Malang", "1234");
        Pelanggan pelanggan3 = new Pelanggan("Moch.", "Malang", "1234");
        
        pelanggan1.save();
        pelanggan2.save();
        pelanggan3.save();
        
        pelanggan1.setNama("Eko");
        pelanggan1.save();
        
        ArrayList<Pelanggan> listPelanggan = pelanggan1.getAll();
        
        Iterator<Pelanggan> i = listPelanggan.iterator();
        
        while (i.hasNext()) {
            Pelanggan p = i.next();
            System.out.println(p.getNama());
            System.out.println(p.getAlamat());
            System.out.println(p.getNo_hp());
            System.out.println("");
            
        }
        
        Kendaraan k1 = new Kendaraan("Jupiter MX", "Motor", "Yamaha", pelanggan1);
        Kendaraan k2 = new Kendaraan("CBR 150", "Motor", "Honda", pelanggan2);
        Kendaraan k3 = new Kendaraan("Revo", "Motor", "Honda", pelanggan1);
        
        k1.save();
        k2.save();
        k3.save();
        
        k1.setNama("Jupiter Z");
        k1.save();
        
        System.out.println(new Kendaraan().getById(1).getNama());
        
    }
}

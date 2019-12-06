/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject;

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
        
    }
}

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
        
        Kendaraan k1 = new Kendaraan("Jupiter MX", "Motor", "Yamaha", pelanggan1);
        Kendaraan k2 = new Kendaraan("CBR 150", "Motor", "Honda", pelanggan2);
        Kendaraan k3 = new Kendaraan("Revo", "Motor", "Honda", pelanggan1);
        
        k1.save();
        k2.save();
        k3.save();
        
        k1.setNama("Jupiter Z");
        k1.save();
        
        Mekanik mekanik1 = new Mekanik("Irfan", "Malang", "08128301238");
        Mekanik mekanik2 = new Mekanik("Rafif", "Malang", "08128301238");
        Mekanik mekanik3 = new Mekanik("Moch.", "Malang", "08128301238");
        
        mekanik1.save();
        mekanik2.save();
        mekanik3.save();
        
        Pelayanan pelayanan1 = new Pelayanan("2019/12/10", 300000, k3, mekanik3);
        Pelayanan pelayanan2 = new Pelayanan("2019/12/11", 500000, k2, mekanik3);
        Pelayanan pelayanan3 = new Pelayanan("2019/12/12", 200000, k3, mekanik1);
        
        pelayanan1.save();
        pelayanan2.save();
        pelayanan3.save();  
        
        pelanggan1.delete();
        pelanggan2.delete();
        pelanggan3.delete();
        
        mekanik1.delete();
        mekanik2.delete();
        mekanik3.delete();
        
        k1.delete();
        k2.delete();
        k3.delete();
        
        pelanggan1.delete();
        pelanggan2.delete();
        pelanggan3.delete();
        
    }
}

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
        
        ArrayList<Pelayanan> listPelayanans = new Pelayanan().getAll();
        
        for (Iterator<Pelayanan> iterator = listPelayanans.iterator(); iterator.hasNext();) {
            Pelayanan next = iterator.next();
            System.out.println(next.getId());
            System.out.println(next.getKendaraan().getNama());
        }
    }
}

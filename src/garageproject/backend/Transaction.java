/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garageproject.backend;

import java.util.ArrayList;

/**
 *
 * @author Irfan Rafif
 */
public interface Transaction {
    public abstract void save();
    public abstract void delete();
    public abstract ArrayList getAll();
    public abstract void getById(int id);
    
}

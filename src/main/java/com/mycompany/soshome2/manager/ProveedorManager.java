/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.manager;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Proveedor;
import com.mycompany.soshome2.persistance.ProveedorDAO;
import java.util.ArrayList;

/**
 *
 * @author manga
 */
public class ProveedorManager {
    public static String insertProveedor(Proveedor p){
        ProveedorDAO pd = new ProveedorDAO();
        pd.insertObject(p);
        return "insert success";
    }
    
    public static Proveedor pedirProveedor(String cedulap){
        ProveedorDAO pd = new ProveedorDAO();
        Proveedor p=pd.getProveedor(cedulap);
        return p;
    }
    public static ArrayList pedirProveedores(String profesion){
        ProveedorDAO pd = new ProveedorDAO();
        ArrayList<Proveedor> p=pd.getProveedores(profesion);
        return p;
    }
    

}

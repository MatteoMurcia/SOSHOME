/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.manager;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Servicio;
import com.mycompany.soshome2.persistance.ClienteDAO;
import com.mycompany.soshome2.persistance.ServicioDAO;

/**
 *
 * @author manga
 */
public class ServicioManager {
    public static String insertServicio(Servicio cli){
        ServicioDAO cd =new ServicioDAO ();
        cd.insertObject(cli);
        return "insert success";
    }
}

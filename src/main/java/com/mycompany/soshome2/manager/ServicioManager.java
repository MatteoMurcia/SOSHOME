/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.manager;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Listaenviados;
import com.mycompany.soshome2.Servicio;
import com.mycompany.soshome2.persistance.ClienteDAO;
import com.mycompany.soshome2.persistance.ServicioDAO;

/**
 *
 * @author manga
 */
public class ServicioManager {
    public static String insertServicio(Servicio s){
        ServicioDAO sd =new ServicioDAO ();
        sd.insertObject(s);
        return "insert success";
    }
    
    public static String insertListaEnviados(Listaenviados le){
        ServicioDAO sd =new ServicioDAO ();
        sd.insertListaEnviados(le);
        return "insert success";
    }
}

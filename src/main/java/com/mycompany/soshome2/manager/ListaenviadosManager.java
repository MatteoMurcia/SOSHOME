/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.manager;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Listaenviados;
import com.mycompany.soshome2.persistance.ClienteDAO;
import com.mycompany.soshome2.persistance.ListaenviadosDAO;

/**
 *
 * @author manga
 */
public class ListaenviadosManager {
    public static String insertenviado(Listaenviados cli){
        ListaenviadosDAO cd =new ListaenviadosDAO();
        cd.insertObject(cli);
        return "insert success";
    }
}

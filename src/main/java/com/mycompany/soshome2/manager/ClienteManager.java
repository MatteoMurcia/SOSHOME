/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.manager;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.persistance.ClienteDAO;

/**
 *
 * @author manga
 */
public class ClienteManager {
    public static String insertCliente(Cliente cli){
        ClienteDAO cd =new ClienteDAO ();
        cd.insertObject(cli);
        return "insert success";
    }

}

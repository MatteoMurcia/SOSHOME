/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.manager;

import com.mycompany.soshome2.Persona;
import com.mycompany.soshome2.persistance.PersonaDAO;

/**
 *
 * @author manga
 */
public class PersonaManager {
    public static String insertPersona(Persona p){
        PersonaDAO pd = new PersonaDAO();
        pd.insertObject(p);
        return "insert success";
    }
    
    public static Persona pedirPersona(String cedula){
        PersonaDAO pd = new PersonaDAO();
        Persona p=pd.getPersona(cedula);
        return p;
    }
    

}

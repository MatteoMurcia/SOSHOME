/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.persistance;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author manga
 */
public class Factory {
    private static final EntityManagerFactory factoryInstance = Persistence.createEntityManagerFactory("com.mycompany_soshome2_war_1.0-SNAPSHOTPU");
    
    private Factory(){}
    public static EntityManagerFactory get(){
        return factoryInstance;
    }

}

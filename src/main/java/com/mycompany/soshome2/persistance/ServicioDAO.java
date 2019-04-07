/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.persistance;

import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Listaenviados;
import com.mycompany.soshome2.Servicio;
import javax.persistence.EntityManager;

/**
 *
 * @author manga
 */
public class ServicioDAO {
    public EntityManager em=null;
    
    public boolean insertObject(Servicio s){
        try{
            em = Factory.get().createEntityManager();
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
            em.refresh(s);
            em.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
            if(em != null && em.isOpen()){
                em.close();
            }
        }
    }
    
    public boolean insertListaEnviados(Listaenviados s){
        try{
            em = Factory.get().createEntityManager();
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
            em.refresh(s);
            em.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
            if(em != null && em.isOpen()){
                em.close();
            }
        }
    }
}

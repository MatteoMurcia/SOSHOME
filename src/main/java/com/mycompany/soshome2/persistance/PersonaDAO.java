/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.persistance;

import com.mycompany.soshome2.Persona;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author manga
 */

public class PersonaDAO {
    
    public EntityManager em=null;
    
    public boolean insertObject(Persona p){
        try{
            em = Factory.get().createEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            em.refresh(p);
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
   
    public Persona getPersona(String cedula){
        try{
            em =Factory.get().createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Persona> query = (TypedQuery<Persona>) em.createQuery("SELECT e FROM Persona e WHERE e.cedula=:myParameter",Persona.class);
            query.setParameter("myParameter", cedula);
            em.getTransaction().commit();
            return (Persona) query.getResultList().get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Persona();
        }finally{
            if(em!=null && em.isOpen()){
                em.close();
            }
        }
    }
    
    

}

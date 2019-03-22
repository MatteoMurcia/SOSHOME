/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.persistance;


import com.mycompany.soshome2.Proveedor;
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

public class ProveedorDAO {
    
    public EntityManager em=null;
    
    public boolean insertObject(Proveedor p){
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
   
    public Proveedor getProveedor(String cedulap){
        try{
            em =Factory.get().createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Proveedor> query = (TypedQuery<Proveedor>) em.createQuery("SELECT p FROM Proveedor p WHERE p.cedulap = :cedulap",Proveedor.class);
            query.setParameter("cedulap", cedulap);
            em.getTransaction().commit();
            return (Proveedor) query.getResultList().get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Proveedor();
        }finally{
            if(em!=null && em.isOpen()){
                em.close();
            }
        }
    }
    
    

}

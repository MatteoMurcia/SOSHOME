/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.persistance;

import com.mycompany.soshome2.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author manga
 */
public class ClienteDAO {
    public EntityManager em=null;
    
    public boolean insertObject(Cliente cli){
        try{
            em = Factory.get().createEntityManager();
            em.getTransaction().begin();
            em.persist(cli);
            em.getTransaction().commit();
            em.refresh(cli);
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
    
    public Cliente getCliente(String cedulac){
        try{
            em =Factory.get().createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Cliente> query = (TypedQuery<Cliente>) em.createQuery("SELECT e FROM Cliente e WHERE e.cedulac=:myParameter",Cliente.class);
            query.setParameter("myParameter", cedulac);
            em.getTransaction().commit();
            return (Cliente) query.getResultList().get(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new Cliente();
        }finally{
            if(em!=null && em.isOpen()){
                em.close();
            }
        }
    }
}

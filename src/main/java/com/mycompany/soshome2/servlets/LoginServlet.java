/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.servlets;


import com.mycompany.soshome2.Cliente;
import com.mycompany.soshome2.Proveedor;
import com.mycompany.soshome2.manager.ClienteManager;
import com.mycompany.soshome2.manager.ProveedorManager;
import com.mycompany.soshome2.utils.Utils;
import com.mycompany.soshome2.utils.login;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manga
 */
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login l = (login) Utils.fromJson(Utils.readParams(request), login.class );
        Proveedor p= ProveedorManager.pedirProveedor(l.getCedula());
        Cliente cli = ClienteManager.pedirCliente(l.getCedula());
        response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            if(p.getClave()!=null && p.getClave().equals(l.getClave())){
                response.getWriter().write(Utils.toJson("proveedor"));
            }
            else if(cli.getClave()!=null && cli.getClave().equals(l.getClave())){
                response.getWriter().write(Utils.toJson("cliente"));
            }
            else{
                response.getWriter().write(Utils.toJson("error"));
            }   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

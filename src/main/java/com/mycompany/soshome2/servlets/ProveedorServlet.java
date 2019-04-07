/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.servlets;

import com.mycompany.soshome2.Proveedor;
import com.mycompany.soshome2.manager.ProveedorManager;
import com.mycompany.soshome2.utils.Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manga
 */
public class ProveedorServlet extends HttpServlet {

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
         Cookie [] cookies = null;
        Cookie cookie = null;
        String token= null;
        cookies=request.getCookies();
        for(int i=0;i< cookies.length;i++){
            cookie = cookies[i];
            if(cookie.getName().compareTo("token")==0){
               token = cookie.getValue();
            }
        }
        String cedula = parseJWT(token);
        
        String profesion = (String) Utils.fromJson(Utils.readParams(request),String.class);
        
        List<Proveedor> listProveedor =  ProveedorManager.pedirListaProveedor(profesion);
        response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(Utils.toJson(listProveedor));
    }
    
    private String parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey("token")
                .parseClaimsJws(jwt).getBody();
        return (String) claims.get("cedula");
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

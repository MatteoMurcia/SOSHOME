/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soshome2.servlets;

import com.mycompany.soshome2.Servicio;
import com.mycompany.soshome2.manager.ServicioManager;
import com.mycompany.soshome2.utils.Utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author manga
 */
public class ServicioServlet extends HttpServlet {

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
        String cedulac =parseJWT(token);
        Servicio ser = (Servicio) Utils.fromJson(Utils.readParams(request), Servicio.class);
        ser.setCedulac(cedulac);
        ServicioManager.insertServicio(ser);
    }
    
    private String parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey("token")
                .parseClaimsJws(jwt).getBody();
        return claims.get("cedula", String.class);
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

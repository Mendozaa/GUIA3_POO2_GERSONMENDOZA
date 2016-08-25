/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.TipoDocuCtrl;
import com.sv.udb.modelo.TipoDocu;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gersonfrancisco
 */
@WebServlet(name = "TipoDocuServ", urlPatterns = {"/TipoDocuServ"})
public class TipoDocuServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        byte esta = 1;
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("docuBton");
            if(CRUD.equals("Guardar"))
            {
                TipoDocu obje = new TipoDocu();
                obje.setNombTipoDocu(request.getParameter("nombTipoDocu"));
                obje.setFechAlta(new Date());
                obje.setEsta(1);
                mens = new TipoDocuCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
            }
            else if(CRUD.equals("Consultar"))
            {
                Long CodiLuga = Long.parseLong(request.getParameter("codiPersRadio") == null ? 
                        "0" : request.getParameter("codiPersRadio"));
                TipoDocu obje = new TipoDocuCtrl().get(CodiLuga);
                if(obje != null)
                {
                    request.setAttribute("codiTipoDocu", obje.getCodiTipoDocu());
                    request.setAttribute("nombTipoDocu", obje.getNombTipoDocu());
                }
            }
            else if(CRUD.equals("Modificar"))
            {
                TipoDocu obje = new TipoDocu();
                obje.setNombTipoDocu(request.getParameter("nombTipoDocu"));
                obje.setEsta(1);
                obje.setCodiTipoDocu(Long.parseLong(request.getParameter("codiTipoDocu")));
                mens = new TipoDocuCtrl().modi(obje) ? "Datos modificados" : "Datos no modificados";
            }
            else if(CRUD.equals("Eliminar"))
            {
                TipoDocu obje = new TipoDocu();
                obje.setNombTipoDocu(request.getParameter("nombTipoDocu"));
                obje.setEsta(0);
                obje.setCodiTipoDocu(Long.parseLong(request.getParameter("codiTipoDocu")));
                mens = new TipoDocuCtrl().elimin(obje) ? "Datos Eliminados" : "Datos no eliminados"; 
            }
        request.setAttribute("mensAler", mens);
        request.getRequestDispatcher("/documento.jsp").forward(request, response);
        }
        else{
            response.sendRedirect(request.getContextPath() + "/documento.jsp");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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

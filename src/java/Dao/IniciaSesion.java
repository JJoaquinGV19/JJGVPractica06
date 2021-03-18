/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author magda
 */
@WebServlet(name = "IniciaSesion", urlPatterns = {"/IniciaSesion"})
public class IniciaSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre=request.getParameter("nombre");
        String pass=request.getParameter("contrasena");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IniciaSesion</title>");            
            out.println("<script src=\"JavaScript.js\"></script>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session=request.getSession();
            session.setAttribute("iniciada", false);
            
            if(!Consultas.iniciaSesion(nombre, pass).isEmpty()){
            session.setAttribute("iniciada", true);
            session.setAttribute("nombre", nombre);
            session.setAttribute("pass", pass);
            session.setAttribute("dniValidar",Consultas.iniciaSesion((String)session.getAttribute("nombre"), (String)session.getAttribute("pass")).get(0).getDni());
            response.sendRedirect("MostrarBoD");
            }
            else
            {
                out.println("<div id=\"popup\" class=\"popup\">");
                    out.println("<a onclick=\"closeDialog('popup');\" class=\"close\"></a>");
                    out.println("<div>");
                        out.println("No existe ese usuario o contraseña");
                out.println("</div>");
                
                out.println("Error al iniciar sesion <a href='index.jsp'>Continuar</a>");
                                
            }
            
            out.println("</body>");
            out.println("</html>");
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

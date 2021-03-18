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

/**
 *
 * @author magda
 */
@WebServlet(name = "ValidacionServlet", urlPatterns = {"/ValidacionServlet"})
public class ValidacionServlet extends HttpServlet {

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
        
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"estilos.css\" type=\"text/css\"><link>");
            out.println("<title>Iniciar Sesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1 class=\"titulo\">Iniciar Sesion</h1>");
            out.println("<ul>");
            out.println("<li><a href=\"index.jsp\">Pagina Principal</a></li>");    
            out.println("<li><a href=\"ValidacionServlet\">Iniciar Sesion</a></li>");       
            out.println("</ul>");
            out.println("</header>");
                        
            out.println("<form action=\"IniciaSesion\" method=\"post\" id=\"FormNombrePost\" name=\"FormNombrePost\" >");
            out.println("<p><label for=\"nombre\">Inicio de sesion: </label><br></p>");
            out.println("Usuario: <input type=\"text\" id=\"nombre\" name=\"nombre\"/><br>");
            out.println("<p>Contraseña: <input type=\"password\" id=\"contrasena\" name=\"contrasena\"/></p>");
            out.println("<p><input type=\"submit\" id=\"enviar\" name=\"enviar\" value=\"Enviar\" /> </p>");
            out.println("</form>");
          
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

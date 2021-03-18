/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Juegos;
import Model.Partidas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "MostrarC", urlPatterns = {"/MostrarC"})
public class MostrarC extends HttpServlet {

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
        String id = request.getParameter("id");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"estilos.css\" type=\"text/css\"><link>");
            out.println("<title>Partidas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1 class=\"titulo\">Partidas</h1>");
            out.println("<ul>");
            out.println("<li><a href=\"MostrarB\">Mostrar Juegos</a></li>");    
            out.println("<li><a href=\"MostrarD\">Mostrar Campeonatos</a></li>");    
            out.println("<li><a href=\"DestruyeSesion\">Cerrar Sesion</a></li>");     
            out.println("<li><a href=\"MostrarB\">Volver</a></li>");  
            out.println("</ul>");
            out.println("</header>");
            
            out.println("<section>");
            
            HttpSession session=request.getSession(false);
            ArrayList<Partidas> x = Consultas.devuelvePartidas(id);
           
            for(int i=0; i < x.size(); i++)
            {
                
            out.println("<article>");
              
                out.println("<center><h3 class=\"titulo\">Partida Nº: "+(i+1)+"</h3></center>");
                out.println("<center><p class=\"titulo\">Puntos: "+x.get(i).getPtos()+"</p></center>");
                           
            out.println("</article>");
                
            }
            out.println("</section>");
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

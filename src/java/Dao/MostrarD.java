/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Campeonatos;
import Model.Juegos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "MostrarD", urlPatterns = {"/MostrarD"})
public class MostrarD extends HttpServlet {

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
        String fecha=request.getParameter("fecha");
        Date a=new Date();
      
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"estilos.css\" type=\"text/css\"><link>");
            out.println("<title>Juegos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<header>");
            out.println("<h1 class=\"titulo\">Campeonatos</h1>");
            out.println("<ul>");
            out.println("<li><a href=\"MostrarB\">Mostrar Juegos</a></li>");    
            out.println("<li><a href=\"MostrarD\">Mostrar Campeonatos</a></li>");    
            out.println("<li><a href=\"DestruyeSesion\">Cerrar Sesion</a></li>");     
            out.println("<li><a href=\"MostrarBoD\">Volver</a></li>");        
            out.println("<li><a href=\"MostrarBoD\">"+(a.getMonth())+"</a></li>");        
            out.println("</ul>");
            out.println("</header>");
            
            out.println("<section>");
            
            HttpSession session=request.getSession(false);
            
            ArrayList<Campeonatos> x;
            if(fecha==null || fecha.isEmpty())
                x = Consultas.devuelveCampeonatos((String)session.getAttribute("dniValidar"));
            else
                x = Consultas.devuelveCampeonatosFiltrados((String)session.getAttribute("dniValidar"), fecha);
                
            for(int i=0; i < x.size(); i++)
            {
                
            out.println("<article style=\"float:left\">");
                
                out.println("<figure><center><img class=\"imagen\" src=\""+x.get(i).getImagen()+"\"></center></figure>");
                out.println("<center><h3 class=\"titulo\">"+x.get(i).getNombre()+"</h3></center>");
                out.println("<center><p class=\"titulo\">Fecha: "+x.get(i).getFecha()+"</p></center>");
                           
            out.println("</article>");
                
            }
            out.println("</section>");
            
            out.println("<section>");
                out.println("<form action=\"MostrarD\" method=\"post\" id=\"FormNombrePost\" name=\"FormNombrePost\" >");
                out.println("<p><label for=\"nombre\">Filtrado por Fecha: </label><br></p>");
                out.println("<input type=\"text\" id=\"fecha\" name=\"fecha\"/><br>");
                out.println("<p><input type=\"submit\" id=\"enviar\" name=\"enviar\" value=\"Filtrar / Restaurar filtro\" /> </p>");
                out.println("</form>");
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

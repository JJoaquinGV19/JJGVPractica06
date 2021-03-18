/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Juegos;
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
@WebServlet(name = "MostrarB", urlPatterns = {"/MostrarB"})
public class MostrarB extends HttpServlet {

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
            out.println("<h1 class=\"titulo\">Juegos</h1>");
            out.println("<ul>");
            out.println("<li><a href=\"MostrarB\">Mostrar Juegos</a></li>");    
            out.println("<li><a href=\"MostrarD\">Mostrar Campeonatos</a></li>");    
            out.println("<li><a href=\"InsertarB\">Insertar Objetos</a></li>");    
            out.println("<li><a href=\"DestruyeSesion\">Cerrar Sesion</a></li>");     
            out.println("<li><a href=\"MostrarBoD\">Volver</a></li>");        
            out.println("</ul>");
            out.println("</header>");
            
            out.println("<section>");
            
            HttpSession session=request.getSession(false);
            ArrayList<Juegos> x;
            if(nombre==null || nombre.isEmpty())
                x = Consultas.devuelveJuegos((String)session.getAttribute("dniValidar"));
            else
                x = Consultas.devuelveJuegosFiltrados((String)session.getAttribute("dniValidar"), nombre);
                
            for(int i=0; i < x.size(); i++)
            {
                
            out.println("<article style=\"float:left\">");
              
                out.println("<center><h3 class=\"titulo\">"+x.get(i).getNombre()+"</h3></center>");
                out.println("<center><p class=\"titulo\">Precio: "+x.get(i).getPrecio()+"</p></center>");
                out.println("<center><p class=\"titulo\">Puntos Totales: "+x.get(i).getTotalPtos()+"</p></center>");
                out.println("<center><p class=\"titulo\"><a href='MostrarC?id="+x.get(i).getId()+"'>Ver Partidas</a></p></center>");
                           
            out.println("</article>");
                
            }
            out.println("</section>");
            
            out.println("<section>");
                out.println("<form action=\"Insertarlo\" method=\"post\" id=\"FormNombrePost\" name=\"FormNombrePost\" >");
                out.println("<p><label for=\"nombre\">Filtrado por Nombre: </label><br></p>");
                out.println("<input type=\"text\" id=\"nombre\" name=\"nombre\"/><br>");
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

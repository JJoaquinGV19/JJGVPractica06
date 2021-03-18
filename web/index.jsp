<%-- 
    Document   : index
    Created on : 11-mar-2021, 21:10:06
    Author     : magda
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Dao.Datos"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina Principal</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="estilos.css" type="text/css"><link>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%
            Date a=new Date();
        %>
        
        <header>
        <h1 class="titulo">Pagina Principal</h1>
        <ul>
            <li><a href="index.jsp">Pagina Principal</a></li>
            <li><a href="ValidacionServlet">Iniciar Sesion</a></li>
            <li><a><%=a%></a></li>
        </ul>
    </header>
    </body>
</html>

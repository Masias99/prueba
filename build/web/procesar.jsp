<%-- 
    Document   : procesar
    Created on : 19 nov. 2025, 20:49:09
    Author     : christianruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Procesando Datos</title>
    </head>
    <body>
        <h1>Hola, <%= request.getParameter("nombre")%></h1>
        <%
            int edad = Integer.parseInt(request.getParameter("edad"));
            if (edad >= 18) {
        %>
        <p>Eres Mayor de Edad. </p>
        <% } else {%>
        <p>Eres menor de edad</p>
        <% }%>

    </body>
</html>

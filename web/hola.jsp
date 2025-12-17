<%-- 
    Document   : hola
    Created on : 19 nov. 2025, 19:46:01
    Author     : christianruiz
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- 
Elementos de scripting para JSP

-->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Uso de elementos de Scripting</h1>
        <%! String mensaje = "Hola desde mi scripting";%>
        <p>El mensaje es: <%= mensaje  %> </p>
        <%! 
            public String getSaludo(String nombre){
                return "Hola, "+nombre+"!";

            }
        %>
        <p>Llamando al metodo getSaludo: <%= getSaludo("Christian") %> </p>
        <h2>Lista Cursos</h2>
        <ul>
            <%
                List<String> cursos =new ArrayList<>();
                cursos.add("Java");
                cursos.add("Base de Datos");
                cursos.add("Introduccion a la Algoritmia");
                
                for (String curso : cursos) {
                
                 out.println("<li>"+curso+"</li>");
                }
                
            %>
            
        </ul>
    </body>
</html>

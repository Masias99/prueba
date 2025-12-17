<%-- 
    Document   : procesar
    Created on : 19 nov. 2025, 20:45:27
    Author     : christianruiz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulario de Saludo</h1>
        <form action="procesar.jsp" method="post">
            Ingresar tu nombre: <input type="text" name="nombre" >
            <br><!-- comment -->
            <br><!-- comment -->
            Ingresar tu edad <input type="number" name="edad" >
            <br><!-- comment -->
            <br><!-- comment -->
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>

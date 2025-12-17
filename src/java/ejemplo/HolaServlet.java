/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author christianruiz
 */
@WebServlet(name="HolaServlet", urlPatterns={"/HolaServlet"})
public class HolaServlet extends HttpServlet {
    //Verbos HTTP, Metodos HTTP: GET, POST ,PUT,PATCH,OPTION,DELETE
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
    //Todos los metodos HTTP Requieren siempre de dos cosas
    // Request!!!!! y Response!!!
     System.out.println("Se ejecuto mi Servlet");
     //response.getWriter().println("Esta es la respuesta desde mi Servlet");
     response.setContentType("text/html");
     response.getWriter().println("<html>");
     response.getWriter().println("<body>");
     response.getWriter().println("<h1> Hola Mundo desde un Servlet!!! </h1>");
     response.getWriter().println("</body>");
     response.getWriter().println("</html>");

    } 
}
//Tarea: Crea un Servlet llamado ProcesarFormularioServlet
// ruta name y urlpatters: ProcesarFormulario
// Soescribir un doPost
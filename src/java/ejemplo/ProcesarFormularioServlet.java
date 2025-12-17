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
@WebServlet(name="ProcesarFormulario", urlPatterns={"/ProcesarFormulario"})
public class ProcesarFormularioServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
     String nombre = request.getParameter("nombreUsuario");
     System.out.println("El nombre que recibi es: "+nombre);
  
     response.setContentType("text/html");
     response.getWriter().println("<html>");
     response.getWriter().println("<body>");
     response.getWriter().println("<h1> Bienvenido,  "+nombre+"!!! </h1>");
     response.getWriter().println("</body>");
     response.getWriter().println("</html>");
    }
    
}

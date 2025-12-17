/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EstudianteDAO;
import dao.EstudianteDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Estudiante;

/**
 *
 * @author christianruiz
 */
//API REST
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

    private static final List<Estudiante> lista = new ArrayList<>();
    private static int idCounter = 1;
    
    //Metodo HTTP, Listamos : GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Se ejecuto el GET");
        EstudianteDAO dao = new EstudianteDAOImpl();
        request.setAttribute("listaEstudiantes", dao.listar());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    //Metodo HTTP Creamos : POST 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Se ejecuto el POST");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String carrera = request.getParameter("carrera");
        Estudiante nuevo = new Estudiante(nombre, email, carrera);
        EstudianteDAO dao = new EstudianteDAOImpl();
        dao.agregar(nuevo);
        response.sendRedirect("EstudianteServlet");
    }

    //Metodo HTTP Actualizar: PUT (Total) / PATCH (Parcial)
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String carrera = request.getParameter("carrera");
        System.out.println("id:" + id);
        System.out.println("nombre:" + nombre);
        System.out.println("email:" + email);
        System.out.println("carrera:" + carrera);
        Estudiante estudiante = lista.stream().filter(e -> e.getId() == Integer.parseInt(id)).findFirst().orElse(null);
        estudiante.setNombre(nombre);
        estudiante.setEmail(email);
        estudiante.setCarrera(carrera);
        response.sendRedirect("EstudianteServlet");

    }

    //Metodo HTTP Eliminados: DELETE 
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        lista.remove(Integer.parseInt(id));
        response.sendRedirect("EstudianteServlet");
    }

}

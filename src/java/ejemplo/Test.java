/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo;

import dao.EstudianteDAO;
import dao.EstudianteDAOImpl;
import java.util.List;
import modelo.Estudiante;

/**
 *
 * @author christianruiz
 */
public class Test {

    public static void main(String[] args) {
        
        EstudianteDAO dao = new EstudianteDAOImpl();
        dao.agregar(new Estudiante("Fabian","fabi@gmail","Sistemas"));
        //dao.listar();
        //Crea un recorrido para esta lista
        //dao.listar().forEach(System.out::println);
        System.out.println("El estudiante encontrado es: "+dao.buscar(1));

    }
}

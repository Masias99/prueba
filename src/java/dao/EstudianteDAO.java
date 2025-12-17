/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Estudiante;

/**
 *
 * @author christianruiz
 */
public interface EstudianteDAO {

    boolean agregar(Estudiante e);
    List<Estudiante> listar();
    Estudiante buscar(int id);
    boolean actualizar(Estudiante e);
    boolean eliminar(int id); 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Estudiante;
import util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christianruiz
 */
public class EstudianteDAOImpl implements EstudianteDAO {

    @Override
    public boolean agregar(Estudiante e) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            //alumnos
            String sql = "insert into estudiantes (nombre, email, carrera) values (?,?,?)";
            con = Conexion.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getCarrera());
            return ps.execute();
        } catch (Exception ex) {
            System.out.println("Ocurrio un error al agregar: " + ex.getMessage());
        } finally {
            try {
                // SIEMPRE SIEMPRE SIEMPRE SIEMPREEEEEEEEEEEEEEEEE SE EJECUTA
                con.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setEmail(rs.getString("email"));
                e.setCarrera(rs.getString("carrera"));
                lista.add(e);
            }

        } catch (Exception e) {
            System.out.println("Error al Listar estudiantes: " + e.getMessage());
        }
        return lista;

    }

    @Override
    public Estudiante buscar(int id) {
        String sql = "select * from estudiantes where id =?";
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Estudiante(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("carrera")
                );
            }

        } catch (Exception e) {
            System.out.println("Error al buscar estudiantes: " + e.getMessage());

        }
        return null;

    }

    @Override
    public boolean actualizar(Estudiante e) {
        if (buscar(e.getId()) == null) {
            return false;
        }
        String sql = "update estudiantes set nombre=?, email=?, carrera=? where id=?";

        try {

            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, e.getNombre());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getCarrera());
            ps.setInt(4, e.getId());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception ex) {
            System.out.println("Ocurrió un error al actualizar al estudiante: " + ex.getMessage());
        }

        return false;

    }

    @Override
    public boolean eliminar(int id) {
        // Tarea Implementar El Eliminar
        try {

            String sql = "delete from estudiantes  where id = ?";
            Connection conn = Conexion.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.execute();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al eliminar " + e.getMessage());
        }

        return false;
    }

}

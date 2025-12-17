/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import java.sql.Connection;
import java.sql.DriverManager;


/**//* NOS PERMITE CONECTAR A LA BASE DE DATOS
 *
 * @author raulm
 */ 
public class Conexion {
    
    //URL , USUARIO , PASSWORD 
    private static final String URL ="jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:5432/postgres?sslmode=require";
    private static final String USER = "postgres.lgfeltlbwzfpdfypbjps";
    private static final String PASSWORD = "WHvNJLz97LX09zUO";
    
    
    public static Connection getConnection(){
        Connection con = null ;
        try {
            
            
            Class.forName("org.postgresql.Driver");
            
            con=DriverManager.getConnection(URL, USER, PASSWORD);
            
            System.out.println("Se conecto a la base de datos ");
            
        } catch (Exception ex) {
            System.out.println("Error de conexion:" + ex.getMessage());
        }
        return con ;
        
    }
            
    
}
    
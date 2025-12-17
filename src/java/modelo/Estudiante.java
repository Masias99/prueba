/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author christianruiz
 */
//Java Bean
// Para que sea un Java Bean
// 1. Constructor Vacio
// 2. Atributos Privados
// 3. Implementar Getter and Setters
// 4. (Opcional) Implemente Serializable
public class Estudiante {

    private int id;
    private String nombre;
    private String email;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, String email, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.carrera = carrera;
    }
    
    public Estudiante(String nombre, String email, String carrera) {
        this.nombre = nombre;
        this.email = email;
        this.carrera = carrera;
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString(){
        return id + " | " +nombre +" | "+email+" | "+carrera;
    }
    
}

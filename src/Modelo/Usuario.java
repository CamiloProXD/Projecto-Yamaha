/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Usuario extends Persona {
    
    public Usuario(int id, String nombres, String apellidos, String numeroTelefonico, String email, String direccion) {
        super(id, nombres, apellidos, numeroTelefonico, email, direccion);
    }
    
    private int idUsuario;
    private String username;
    private String password;
    private float salario;
    private Venta[] venta;
    private String rol;
    private int idSede;

   
    
    
    
}
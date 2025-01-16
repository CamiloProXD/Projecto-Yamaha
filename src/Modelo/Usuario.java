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
     
    
    private int idUsuario;
    private String username;
    private String password;
    private String rol;
    private double salario;
    private Venta[] venta;
    private int idSede;

    public Usuario(int idUsuario, String username, String password, String rol, double salario, Venta[] venta, int idSede, int id, String nombres, String apellidos, String numeroTelefonico, String email, String direccion) {
        super(id, nombres, apellidos, numeroTelefonico, email, direccion);
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.salario = salario;
        this.venta = venta;
        this.idSede = idSede;
    }
    
    public Usuario() {
       }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Venta[] getVenta() {
        return venta;
    }

    public void setVenta(Venta[] venta) {
        this.venta = venta;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }

   
    
    
    
}
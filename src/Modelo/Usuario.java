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
    
    private int  idUsuario;
    private float salario;
    private Venta[] venta;
    private String rol;
    private int idSede;

    public Usuario(int idUsuario, float salario, Venta[] venta, String rol, int idSede, int id, String nombres, String apellidos, String numeroTelefonico, String email, String direccion) {
        super(id, nombres, apellidos, numeroTelefonico, email, direccion);
        this.idUsuario = idUsuario;
        this.salario = salario;
        this.venta = venta;
        this.rol = rol;
        this.idSede = idSede;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Venta[] getVenta() {
        return venta;
    }

    public void setVenta(Venta[] venta) {
        this.venta = venta;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdSede() {
        return idSede;
    }

    public void setIdSede(int idSede) {
        this.idSede = idSede;
    }
    
    
    
}

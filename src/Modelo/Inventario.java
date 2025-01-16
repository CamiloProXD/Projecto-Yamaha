/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Inventario {
    private Moto[] producto;

    public Inventario(Moto[] producto) {
        this.producto = producto;
    }

    public Inventario() {
    }

    public Moto[] getProducto() {
        return producto;
    }

    public void setProducto(Moto[] producto) {
        this.producto = producto;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Moto {
    private String serialMoto;
    private String color;
    private int cilindraje;
    private String modelo;
    private double precioUnitario;
    private String tipoMoto;

    public Moto(String serialMoto, String color, int cilindraje, String modelo, double precioUnitario, String tipoMoto) {
        this.serialMoto = serialMoto;
        this.color = color;
        this.cilindraje = cilindraje;
        this.modelo = modelo;
        this.precioUnitario = precioUnitario;
        this.tipoMoto = tipoMoto;
    }

    public String getSerialMoto() {
        return serialMoto;
    }

    public void setSerialMoto(String serialMoto) {
        this.serialMoto = serialMoto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }

    public void setTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
    }

    
}

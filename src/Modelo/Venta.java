/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author User
 */
public class Venta {
    private int numero_factura;
    private Date fecha;
    private Usuario quienCompro;
    private Usuario quienAtendio;
    private Moto[] motosVenta;

    public Venta(int numeroFactura, Date fecha, Usuario quienCompro, Usuario quienAtendio, Moto[] motosVenta) {
        this.numero_factura = numeroFactura;
        this.fecha = fecha;
        this.quienCompro = quienCompro;
        this.quienAtendio = quienAtendio;
        this.motosVenta = motosVenta;
    }

    public int getNumeroFactura() {
        return numero_factura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numero_factura = numeroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getQuienCompro() {
        return quienCompro;
    }

    public void setQuienCompro(Usuario quienCompro) {
        this.quienCompro = quienCompro;
    }

    public Usuario getQuienAtendio() {
        return quienAtendio;
    }

    public void setQuienAtendio(Usuario quienAtendio) {
        this.quienAtendio = quienAtendio;
    }

    public Moto[] getMotosVenta() {
        return motosVenta;
    }

    public void setMotosVenta(Moto[] motosVenta) {
        this.motosVenta = motosVenta;
    }
    
    
            
    
}

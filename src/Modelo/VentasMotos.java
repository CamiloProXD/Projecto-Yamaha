/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class VentasMotos {
    private int ventaId;
    private String motoId;

    public VentasMotos() {
    }

    public VentasMotos(int ventaId, String motoId) {
        this.ventaId = ventaId;
        this.motoId = motoId;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public String getMotoId() {
        return motoId;
    }

    public void setMotoId(String motoId) {
        this.motoId = motoId;
    }
}

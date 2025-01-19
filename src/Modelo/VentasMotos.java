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
    private int motoId;

    public VentasMotos() {
    }

    public VentasMotos(int ventaId, int motoId) {
        this.ventaId = ventaId;
        this.motoId = motoId;
    }

    public int getVentaId() {
        return ventaId;
    }

    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }

    public int getMotoId() {
        return motoId;
    }

    public void setMotoId(int motoId) {
        this.motoId = motoId;
    }
}

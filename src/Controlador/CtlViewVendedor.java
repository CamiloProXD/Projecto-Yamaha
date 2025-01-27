/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewCerrarSesionEmpleado;
import Vista.ViewSucursalEmpleado;
import Vista.ViewRealizarVenta;
import Vista.ViewRegistrarpago;
import Vista.ViewVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewVendedor implements ActionListener {
    private ViewRealizarVenta vxRealizarVenta;
    private ViewSucursalEmpleado vxSucursal;
    private ViewVendedor vxVendedor;
    private ViewCerrarSesionEmpleado vxCerrarSesion;
    private ViewRegistrarpago vxRegistrarPago;
    
    public CtlViewVendedor(ViewRealizarVenta vxRealizarVenta, ViewSucursalEmpleado vxSucursal, ViewVendedor vxVendedor, ViewCerrarSesionEmpleado vxCerrarSesion, ViewRegistrarpago vxRegistrarPago) {
        this.vxRealizarVenta = vxRealizarVenta;
        this.vxSucursal = vxSucursal;
        this.vxVendedor = vxVendedor;
        this.vxCerrarSesion = vxCerrarSesion;
        this.vxRegistrarPago = vxRegistrarPago;
       
        this.vxVendedor.btnConsultarinv.addActionListener(this);
        this.vxVendedor.btnRealizarven.addActionListener(this);
        this.vxVendedor.btnCerrarSesion.addActionListener(this);
        this.vxVendedor.btnPagos.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(vxVendedor.btnConsultarinv)){
            vxSucursal.setVisible(true);
            this.vxVendedor.dispose();
        }
        if(ev.getSource().equals(vxVendedor.btnRealizarven)){
            vxRealizarVenta.setVisible(true);
            this.vxVendedor.dispose();
        }
        if(ev.getSource().equals(vxVendedor.btnCerrarSesion)){
            vxCerrarSesion.setVisible(true);
            this.vxVendedor.dispose();
        }
        if(ev.getSource().equals(vxVendedor.btnPagos)){
            vxRegistrarPago.setVisible(true);
            this.vxVendedor.dispose();
        }
       
    }
}
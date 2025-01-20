/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewCerrarSesionAdmin;
import Vista.ViewSucursal;
import Vista.ViewRealizarVenta;
import Vista.ViewVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewVendedor implements ActionListener {
    private ViewRealizarVenta vxRealizarVenta;
    private ViewSucursal vxSucursal;
    private ViewVendedor vxVendedor;
    private ViewCerrarSesionAdmin vxCerrarSesion;
    
    public CtlViewVendedor(ViewRealizarVenta vxRealizarVenta, ViewSucursal vxSucursal, ViewVendedor vxVendedor, ViewCerrarSesionAdmin vxCerrarSesion) {
        this.vxRealizarVenta = vxRealizarVenta;
        this.vxSucursal = vxSucursal;
        this.vxVendedor = vxVendedor;
        this.vxCerrarSesion = vxCerrarSesion;
        
       
        this.vxVendedor.btnConsultarinv.addActionListener(this);
        this.vxVendedor.btnRealizarven.addActionListener(this);
        this.vxVendedor.btnCerrarSesion.addActionListener(this);
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
       
    }
}
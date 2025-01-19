/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.ViewCerrarSesion;
import Vista.ViewFiltrarinventario;
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
    private ViewFiltrarinventario vxFiltrarInventario;
    private ViewVendedor vxVendedor;
    private ViewCerrarSesion vxCerrarSesion;
    
    public CtlViewVendedor(ViewRealizarVenta vxRealizarVenta, ViewFiltrarinventario vxFiltrarInventario, ViewVendedor vxVendedor, ViewCerrarSesion vxCerrarSesion) {
        this.vxRealizarVenta = vxRealizarVenta;
        this.vxFiltrarInventario = vxFiltrarInventario;
        this.vxVendedor = vxVendedor;
        this.vxCerrarSesion = vxCerrarSesion;
        this.vxRealizarVenta.btnGenerarFactura.addActionListener(this);
        this.vxFiltrarInventario.btnFiltrar.addActionListener(this);
        this.vxVendedor.btnConsultarinv.addActionListener(this);
        this.vxVendedor.btnRealizarven.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev){
        if(ev.getSource().equals(vxCerrarSesion)){
            vxCerrarSesion.setVisible(true);
            this.vxVendedor.dispose();
        }
        if(ev.getSource().equals(vxFiltrarInventario)){
            vxFiltrarInventario.setVisible(true);
            this.vxVendedor.dispose();
        }
        if(ev.getSource().equals(vxVendedor)){
            vxVendedor.setVisible(true);
            this.vxVendedor.dispose();
        }
        if(ev.getSource().equals(vxRealizarVenta)){
            vxRealizarVenta.setVisible(true);
            this.vxVendedor.dispose();
        }
    }
}
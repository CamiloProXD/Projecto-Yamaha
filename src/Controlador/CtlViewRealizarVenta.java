/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Moto;
import Vista.ViewRealizarVenta;
import Vista.ViewRegistrarpago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.DaoMoto;
import Modelo.DaoVenta;
import Modelo.Venta;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRealizarVenta implements ActionListener {

    //gabriel
    ViewRegistrarpago vrp;
    ViewRealizarVenta vrv;

    public CtlViewRealizarVenta(ViewRegistrarpago vrp, ViewRealizarVenta vrv) {
        this.vrp = vrp;
        this.vrv = vrv;
        vrv.btnGenerarFactura.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vrv)) {
            vrp.setVisible(true);
            vrv.dispose();
        }
    }

    public void venderMoto(Moto moto, Venta venta) {
        DaoMoto dMoto = new DaoMoto();
        DaoVenta dVenta = new DaoVenta();
        dVenta.agregar(venta);
        dMoto.eliminar(moto);
    }
}
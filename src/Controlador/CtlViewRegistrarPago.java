/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoPago;
import Modelo.Pago;
import Vista.ViewCerrarSesionEmpleado;
import Vista.ViewRegistrarpago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRegistrarPago implements ActionListener {

    private ViewRegistrarpago vrp;
    private ViewCerrarSesionEmpleado vcs;

    public CtlViewRegistrarPago(ViewRegistrarpago vrp, ViewCerrarSesionEmpleado vcs) {
        this.vrp = vrp;
        this.vcs = vcs;
        vrp.btnConfirmarpago.addActionListener(this);
        vrp.btnRegresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vrp)) {
            JOptionPane.showMessageDialog(null, "pago " + vrp.txtNumfactura + " registrado exitosamente", "confirmacion registro pago", 4);
            DaoPago dPago = new DaoPago();
            Pago pago = new Pago();
            pago.setNumeroFactura(Integer.parseInt(vrp.txtNumfactura.getText()));
            pago.setMontoPago(Double.parseDouble(vrp.txtMontopago.getText()));
            pago.setPagado(true);
            dPago.agregar(pago);
        }
        if (ev.getSource().equals(vcs)) {
            vcs.setVisible(true);
            vrp.dispose();
            
        }
    }
}

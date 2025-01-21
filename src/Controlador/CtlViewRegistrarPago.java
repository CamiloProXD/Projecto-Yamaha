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
        if (ev.getSource().equals(vrp.btnConfirmarpago)) {
            
            JOptionPane.showMessageDialog(null, "Pago " + vrp.txtNumfactura.getText() + " registrado exitosamente", "Confirmación de Registro de Pago", JOptionPane.INFORMATION_MESSAGE);

           
            DaoPago dPago = new DaoPago();
            Pago pago = new Pago();

            
            pago.setNumeroFactura(Integer.parseInt(vrp.txtNumfactura.getText()));
            pago.setMontoPago(Double.parseDouble(vrp.txtMontopago.getText()));
            pago.setPagado(1);

            if (dPago.agregar(pago)) {
                JOptionPane.showMessageDialog(null, "Pago registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar el pago", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (ev.getSource().equals(vrp.btnRegresar)) {
            vcs.setVisible(true);
            vrp.dispose();
        }

    }
}

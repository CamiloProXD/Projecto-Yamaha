/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DaoPago;
import Modelo.DaoVenta;
import Modelo.Pago;
import Vista.ViewCerrarSesionEmpleado;
import Vista.ViewRegistrarpago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRegistrarPago implements ActionListener {
    
    private ViewRegistrarpago vrp;
    private ViewCerrarSesionEmpleado vcs;
    private DaoVenta daoVenta;
    private DaoPago daoPago;
    private Pago pago;
    
    public CtlViewRegistrarPago(ViewRegistrarpago vrp, ViewCerrarSesionEmpleado vcs, DaoVenta daoVenta, DaoPago daoPago, Pago pago) {
        this.vrp = vrp;
        this.vcs = vcs;
        this.daoVenta = daoVenta;
        this.daoPago = daoPago;
        this.pago = pago;
        vrp.btnConfirmarpago.addActionListener(this);
        vrp.btnRegresar.addActionListener(this);
        vrp.btnVerPagoRestante.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vrp.btnConfirmarpago)) {
            try {
                int numeroFactura = Integer.parseInt(vrp.txtNumfactura.getText());
                double montoPago = Double.parseDouble(vrp.txtMontopago.getText());
                double totalRestante = daoPago.obtenerTotalRestantePorVenta(numeroFactura);
                if (montoPago > totalRestante) {
                    DecimalFormat df = new DecimalFormat("#.00");
                    mensaje("El monto a pagar no puede ser mayor que el restante: " + df.format(totalRestante), "ERROR");
                    return;
                }
                if (daoVenta.existeVenta(numeroFactura)) {
                    if (daoPago.existePago(numeroFactura)) {
                        if (daoPago.procesarPago(numeroFactura, montoPago)) {
                            DecimalFormat df = new DecimalFormat("#.00");
                            mensaje("Pago registrado exitosamente, restante por pagar: " + df.format(totalRestante - montoPago), "Éxito");
                        } else {
                            mensaje("Error al procesar el pago", "ERROR");
                        }
                    } else {
                        if (daoPago.crearPagoSiNoExiste(numeroFactura, montoPago)) {
                            mensaje("Pago creado exitosamente", "Éxito");
                        } else {
                            mensaje("Error al crear el pago", "ERROR");
                        }
                    }
                } else {
                    mensaje("Venta no existente", "ERROR");
                }
            } catch (NumberFormatException e) {
                mensaje("Por favor, ingrese un número válido para la factura y el monto.", "ERROR");
            }
        }
        if (ev.getSource().equals(vrp.btnVerPagoRestante)) {
            DecimalFormat df = new DecimalFormat("#.00");
            int numeroFactura = Integer.parseInt(vrp.txtNumfactura.getText());
            double totalRestante = daoPago.obtenerTotalRestantePorVenta(numeroFactura);
            mensaje("El monto a pagar restante: " + df.format(totalRestante), "ERROR");
        }
        if (ev.getSource().equals(vrp.btnRegresar)) {
            vcs.setVisible(true);
            vrp.dispose();
        }
    }
    
    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}

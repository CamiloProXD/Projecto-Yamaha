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
import Modelo.DaoUsuario;
import Modelo.DaoVenta;
import Modelo.DaoVentasMotos;
import Modelo.Usuario;
import Modelo.Venta;
import Modelo.VentasMotos;
import Vista.ViewCerrarSesionEmpleado;
import javax.swing.JOptionPane;

/**
 *
 * @author grabieloX19X
 */
public class CtlViewRealizarVenta implements ActionListener {

    //gabriel
    private ViewRegistrarpago vrp;
    private ViewRealizarVenta vrv;
    private ViewCerrarSesionEmpleado vcs;
    private DaoUsuario dUsuario;

    public CtlViewRealizarVenta(ViewRegistrarpago vrp, ViewRealizarVenta vrv, ViewCerrarSesionEmpleado vcs, DaoUsuario dUsuario) {
        this.vrp = vrp;
        this.vrv = vrv;
        this.vcs = vcs;
        this.dUsuario = dUsuario;
        vrv.btnAnadirMoto.addActionListener(this);
        vrv.btnAnadirMoto.addActionListener(this);
        vrv.botonRegresar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vrv.btnAnadirMoto)) {
            Usuario nuevo = new Usuario(Integer.parseInt(vrv.txtIDVenta.getText()), null, null, "Cliente", 0, null, 0, Integer.parseInt(vrv.TxtCedula.getText()), vrv.TxtNombre.getText(), vrv.txtApellido.getText(), vrv.TxtTelefono.getText(), null, vrv.txtDirec.getText());
            dUsuario.agregar(nuevo);
            JOptionPane.showMessageDialog(null, "cliente " + vrv.TxtNombre.getText() +" agregado correctamente");
            vrp.setVisible(true);
            vrv.dispose();
        }
        if (e.getSource().equals(vrv.btnAnadirMoto)) {
            vrp.setVisible(true);
            vrv.dispose();
        }
        if(e.getSource().equals(vrv.botonRegresar)){
            vcs.setVisible(true);
            vrv.dispose();
        }
    }

    public void venderMoto(Moto moto, Venta venta) {
        DaoMoto dMoto = new DaoMoto();
        DaoVenta dVenta = new DaoVenta();
        DaoVentasMotos dvm = new DaoVentasMotos();
        
        VentasMotos vm = new VentasMotos();
        vm.setMotoId(Integer.parseInt(vrv.txtSerial.getText()));
        vm.setVentaId(Integer.parseInt(vrv.txtIDVenta.getText()));
        venta.setNumeroFactura(Integer.parseInt(vrv.txtIDVenta.getText()));
        dvm.agregar(vm);
        dVenta.agregar(venta);
        dMoto.eliminar(moto);
    }
}
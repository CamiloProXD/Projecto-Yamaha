package Controlador;

import Modelo.DaoInventario;
import Vista.ViewCerrarSesionAdmin;
import Vista.ViewVerInventarioSucursalAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtlViewVerInventarioSucursalAdmin implements ActionListener {

    private ViewVerInventarioSucursalAdmin vvisa;
    private DaoInventario daoInventario;
    private int idSucursal;
    private ViewCerrarSesionAdmin vcs;
    private DefaultTableModel modeloTabla;

    public CtlViewVerInventarioSucursalAdmin(ViewVerInventarioSucursalAdmin vvisa, ViewCerrarSesionAdmin vcs, int idSucursal) {
        this.vvisa = vvisa;
        this.daoInventario = new DaoInventario();
        this.vcs = vcs;
        this.idSucursal = idSucursal;

        this.vvisa.btnCerrarSesion.addActionListener(this);
        inicializarTabla();
        cargarInventario();
    }


    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Cantidad");

        vvisa.tablaInventarioSucursal.setModel(modeloTabla);
    }

    private void cargarInventario() {
        modeloTabla.setRowCount(0);

        List<Object[]> inventario = daoInventario.obtenerInventarioPorSucursal(idSucursal);

        if (inventario.isEmpty()) {

        } else {

            for (Object[] fila : inventario) {
                modeloTabla.addRow(fila);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vvisa.btnCerrarSesion)) {
            vcs.setVisible(true);
            this.vvisa.dispose();
        }
    }

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}

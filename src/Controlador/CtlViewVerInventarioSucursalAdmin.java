package Controlador;

import Modelo.DaoInventario;
import Modelo.DaoVenta;
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
    private DaoVenta daoVenta;
    private int idSucursal;
    private ViewCerrarSesionAdmin vcs;
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTablaVentas;

    public CtlViewVerInventarioSucursalAdmin(ViewVerInventarioSucursalAdmin vvisa, ViewCerrarSesionAdmin vcs, int idSucursal) {
        this.vvisa = vvisa;
        this.daoInventario = new DaoInventario();
        this.daoVenta = new DaoVenta();
        this.vcs = vcs;
        this.idSucursal = idSucursal;

        this.vvisa.btnCerrarSesion.addActionListener(this);
        inicializarTabla();
        cargarInventario();

        inicializarTablaVentas();
        cargarVentas();
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

    private void inicializarTablaVentas() {
        modeloTablaVentas = new DefaultTableModel();
        modeloTablaVentas.addColumn("Vendedor");
        modeloTablaVentas.addColumn("Cantidad de Ventas");
        modeloTablaVentas.addColumn("Valor Total de Ventas");
        modeloTablaVentas.addColumn("Cantidad Total de Motos Vendidas");

        vvisa.tablaVentasSucursal.setModel(modeloTablaVentas);
    }

    private void cargarVentas() {
        modeloTablaVentas.setRowCount(0);

        List<Object[]> ventas = daoVenta.obtenerVentasPorSucursal(idSucursal); 

        if (ventas.isEmpty()) {
            mensaje("No hay ventas registradas para esta sucursal.", "Información");
        } else {
            for (Object[] fila : ventas) {
                
                float valorTotalVentas = ((Double) fila[2]).floatValue(); 
                modeloTablaVentas.addRow(new Object[]{
                    fila[0], 
                    fila[1], 
                    String.format("%.2f", valorTotalVentas), 
                    fila[3],
                    fila[4] 
                });
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

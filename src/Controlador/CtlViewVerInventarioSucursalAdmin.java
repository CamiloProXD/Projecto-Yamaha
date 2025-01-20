package Controlador;

import Modelo.DaoInventario;
import Vista.ViewVerInventarioSucursalAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CtlViewVerInventarioSucursalAdmin implements ActionListener {

    private ViewVerInventarioSucursalAdmin vvisa;
    private DaoInventario daoInventario;
    private int idSucursal;
    private DefaultTableModel modeloTabla;

    public CtlViewVerInventarioSucursalAdmin(ViewVerInventarioSucursalAdmin vvisa, int idSucursal) {
        this.vvisa = vvisa;
        this.daoInventario = new DaoInventario();
        this.idSucursal = idSucursal;

        inicializarTabla(); // Inicializa la tabla al crear el controlador
        cargarInventario(); // Carga los datos del inventario en la tabla
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
        modeloTabla.setRowCount(0); // Limpia los datos existentes en la tabla

        // Obtener el inventario de la sucursal desde el DAO
        List<Object[]> inventario = daoInventario.obtenerInventarioPorSucursal(idSucursal);

        // Agregar los datos al modelo de la tabla
        for (Object[] fila : inventario) {
            modeloTabla.addRow(fila);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Manejar eventos adicionales si es necesario
    }
}
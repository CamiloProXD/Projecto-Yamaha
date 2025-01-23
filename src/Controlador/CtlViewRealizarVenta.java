/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Moto;
import Modelo.DaoMoto;
import Modelo.DaoUsuario;
import Modelo.DaoVenta;
import Modelo.DaoVentasMotos;
import Modelo.Usuario;
import Modelo.Venta;
import Modelo.VentasMotos;
import Vista.ViewRealizarVenta;
import Vista.ViewRegistrarpago;
import Vista.ViewCerrarSesionEmpleado;

import Modelo.Conexion;
import Modelo.DaoInventario;
import Modelo.DaoPersona;
import Modelo.Persona;
import Vista.ViewAgregarCliente;
import Vista.ViewAgregarMotos;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author grabieloX19X
 */
public class CtlViewRealizarVenta implements ActionListener {

    private ViewRegistrarpago vrp;
    private ViewRealizarVenta vrv;
    private ViewCerrarSesionEmpleado vcs;
    private DaoUsuario dUsuario;
    private DaoPersona dPersona;
    private DaoVenta dVenta;
    private DaoInventario dInventario;
    private DaoVentasMotos dVentasMotos;
    private DaoMoto dMoto;
    private Venta venta;
    private Moto moto;
    private VentasMotos ventasMotos;
    ViewAgregarCliente vac = new ViewAgregarCliente();
    ViewAgregarMotos vam = new ViewAgregarMotos();
    private DefaultTableModel modeloTabla;

    public CtlViewRealizarVenta(ViewRegistrarpago vrp, ViewRealizarVenta vrv, ViewCerrarSesionEmpleado vcs, DaoUsuario dUsuario, DaoPersona dPersona, DaoVenta dVenta, DaoInventario dInventario, DaoVentasMotos dVentasMotos, DaoMoto dMoto) {
        this.vrp = vrp;
        this.vrv = vrv;
        this.vcs = vcs;
        this.dUsuario = dUsuario;
        this.dPersona = dPersona;
        this.dVenta = dVenta;
        this.dInventario = dInventario;
        this.dVentasMotos = dVentasMotos;
        this.dMoto = dMoto;

        vam.btnAnadirMoto.addActionListener(this);
        vrv.btnGenerarFactura.addActionListener(this);
        vrv.botonRegresar.addActionListener(this);
        vrv.btnCrearPedido.addActionListener(this);
        vac.btnRegistrarCliente.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vrv.btnCrearPedido)) {
            Persona p = new Persona();
            p.setId(Integer.parseInt(vrv.txtCedulaCliente.getText()));

            if (dPersona.existenciaCliente(p)) {
                mensaje("Cliente Encontrado ", "Correcto");
                Venta pedido = new Venta();
                pedido.setCliente(dPersona.buscarPorId(Integer.parseInt(vrv.txtCedulaCliente.getText())));

                int idVendedor = Integer.parseInt(vrv.txtIdVendedor.getText());
                Usuario vendedor = dUsuario.consultarTrabajadorPorId(idVendedor);

                if (vendedor != null) {
                    pedido.setVendedor(vendedor);
                    pedido.setSucursal(vendedor.getIdSede());
                    pedido.setFecha(new Date());

                    if (dVenta.agregar(pedido)) {
                        mensaje("Pedido agregado correctamente", "Éxito");
                    } else {
                        mensaje("Error al agregar el pedido", "Error");
                    }

                    vrv.EscritorioAgregarMotos.add(vam);
                    vam.setVisible(true);

                    inicializarTabla();
                    cargarInventario(vendedor.getIdSede());
                } else {
                    mensaje("Vendedor no encontrado", "Error");
                }
            } else {
                mensaje("Cliente No Encontrado ", "Nuevo Cliente");
                vrv.EscritorioAgregarMotos.add(vac);
                vac.setVisible(true);
            }
        }
        if (e.getSource().equals(vac.btnRegistrarCliente)) {
            Persona clienteNuevo = new Persona(
                    Integer.parseInt(vrv.txtCedulaCliente.getText()),
                    vac.txtNombres.getText(),
                    vac.txtApellidos.getText(),
                    vac.txtTelefono.getText(),
                    vac.txtEmail.getText(),
                    vac.txtDireccion.getText()
            );
            dPersona.agregar(clienteNuevo);
            mensaje("Cliente Nuevo Agregado Correctamente ", "EXITO!!!!!");
            this.vac.dispose();
        }
        if (e.getSource().equals(vam.btnAnadirMoto)) {
            
            vam.txtSerialMotoVenta.getText();
            VentasMotos nuevamoto = new VentasMotos();
            nuevamoto.setMotoId(vam.txtSerialMotoVenta.getText());
            nuevamoto.setVentaId(dVenta.obtenerUltimoNumeroFactura());
            dMoto.actualizarEstadoVendida(vam.txtSerialMotoVenta.getText());
            dVentasMotos.agregar(nuevamoto);
            vam.txtSerialMotoVenta.setText(null);
        }

        if (e.getSource().equals(vrv.btnGenerarFactura)) {
            generarFactura(dVenta.obtenerUltimoNumeroFactura());
        }

        if (e.getSource().equals(vrv.botonRegresar)) {
            vcs.setVisible(true);
            vrv.dispose();
        }
    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Color");
        modeloTabla.addColumn("Serial");

        vam.tablaInventarioSucursal.setModel(modeloTabla);
    }

    private void cargarInventario(int idSede) {
        modeloTabla.setRowCount(0);

        List<Object[]> inventario = dInventario.obtenerInventarioDetallesPorSucursal(idSede);
        if (inventario.isEmpty()) {
        } else {
            for (Object[] fila : inventario) {
                modeloTabla.addRow(fila);
            }
        }
    }

public void generarFactura(int idVenta) {
    Connection conexion = new Conexion().getConexion();
    String query = "SELECT v.numero_factura, p.nombres, p.persona_id, p.direccion, p.numero_telefonico, " +
                   "m.modelo, m.precio_unitario, v.fecha, m.nombre " +
                   "FROM ventas v " +
                   "JOIN personas p ON v.cliente_id = p.persona_id " +
                   "JOIN ventas_motos vm ON v.numero_factura = vm.venta_id " +
                   "JOIN motos m ON vm.moto_id = m.serial_moto " +
                   "WHERE v.numero_factura = ?";

    try (PreparedStatement ps = conexion.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
        ps.setInt(1, idVenta);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) { 
            String ruta = "D:\\universidad\\3er semestre\\proyecto Yamaha\\" + "Factura de la venta " + idVenta + ".pdf";

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta));
            document.open();

            String fuenteRuta = "fuentes\\OpenSans-Regular.ttf"; 
            BaseFont baseFont = BaseFont.createFont(fuenteRuta, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            com.itextpdf.text.Font fuenteTitulo = new com.itextpdf.text.Font(baseFont, 18, com.itextpdf.text.Font.BOLD);
            com.itextpdf.text.Font fuenteTexto = new com.itextpdf.text.Font(baseFont, 12, com.itextpdf.text.Font.NORMAL);
            com.itextpdf.text.Font fuenteNegrita = new com.itextpdf.text.Font(baseFont, 12, com.itextpdf.text.Font.BOLD);

            Image logo = Image.getInstance(getClass().getResource("/imagenes/png-transparent-yamaha-logo-yamaha-motor-company-logo-yamaha-corporation-decal-yamaha-emblem-company-motorcycle-thumbnail-removebg-preview.png"));
            logo.scaleToFit(120, 120);  
            logo.setAlignment(Element.ALIGN_CENTER);
            document.add(logo);

            document.add(new Paragraph("\n"));

            Paragraph titulo = new Paragraph("Factura de Venta", fuenteTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph("\n"));

            PdfPTable encabezadoTabla = new PdfPTable(2);
            encabezadoTabla.setWidthPercentage(100); 
            encabezadoTabla.setSpacingBefore(10f);   
            encabezadoTabla.setSpacingAfter(10f);    

            encabezadoTabla.addCell(new PdfPCell(new Paragraph("Número de Factura:", fuenteNegrita)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph(String.valueOf(rs.getInt("numero_factura")), fuenteTexto)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph("Fecha:", fuenteNegrita)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph(String.valueOf(rs.getDate("fecha")), fuenteTexto)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph("Cliente:", fuenteNegrita)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph(rs.getString("nombres"), fuenteTexto)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph("Cédula:", fuenteNegrita)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph(rs.getString("persona_id"), fuenteTexto)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph("Dirección:", fuenteNegrita)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph(rs.getString("direccion"), fuenteTexto)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph("Teléfono:", fuenteNegrita)));
            encabezadoTabla.addCell(new PdfPCell(new Paragraph(rs.getString("numero_telefonico"), fuenteTexto)));

            document.add(encabezadoTabla);

            Paragraph detalleTitulo = new Paragraph("Detalle de la Compra", fuenteTitulo);
            detalleTitulo.setAlignment(Element.ALIGN_CENTER);
            document.add(detalleTitulo);

            document.add(new Paragraph("\n"));
  
            PdfPTable detalleTabla = new PdfPTable(3);
            detalleTabla.setWidthPercentage(100);
            detalleTabla.setSpacingBefore(10f);
            detalleTabla.setSpacingAfter(10f);

            detalleTabla.addCell(new PdfPCell(new Paragraph("Nombre de la Moto", fuenteNegrita)));
            detalleTabla.addCell(new PdfPCell(new Paragraph("Modelo", fuenteNegrita)));
            detalleTabla.addCell(new PdfPCell(new Paragraph("Precio", fuenteNegrita)));

            do {
                detalleTabla.addCell(new PdfPCell(new Paragraph(rs.getString("nombre"), fuenteTexto)));
                detalleTabla.addCell(new PdfPCell(new Paragraph(rs.getString("modelo"), fuenteTexto)));
                detalleTabla.addCell(new PdfPCell(new Paragraph("$" + String.format("%.2f", rs.getDouble("precio_unitario")), fuenteTexto)));
            } while (rs.next());

            document.add(detalleTabla);

            Paragraph gracias = new Paragraph("Gracias por su compra", fuenteTitulo);
            gracias.setAlignment(Element.ALIGN_CENTER);
            document.add(gracias);

            document.close();

            Desktop.getDesktop().open(new File(ruta));

            JOptionPane.showMessageDialog(null, "Factura generada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para la factura " + idVenta, "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al generar la factura: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void mensaje(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, 1);
    }
}

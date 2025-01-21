/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProyectoYamaha;

import Controlador.CtlViewAdministrador;
import Controlador.CtlViewAgregarVendedor;
import Controlador.CtlViewCatalogoPrincipal;
import Controlador.CtlViewCerrarSesionAdministrado;
import Controlador.CtlViewCerrarSesionEmpleado;
import Controlador.CtlViewConsultarVentas;
import Controlador.CtlViewPrincipal;
import Controlador.CtlViewRealizarVenta;
import Controlador.CtlViewRegistrarMoto;
import Controlador.CtlViewRegistrarPago;
import Controlador.CtlViewRegresarAutomaticas;
import Controlador.CtlViewRegresarDeportivas;
import Controlador.CtlViewRegresarEnduro;
import Controlador.CtlViewRegresarSuperD;
import Controlador.CtlViewRegresarTodoterreno;
import Controlador.CtlViewRegresarUrbanas;
import Controlador.CtlViewSucursalAdministrador;
import Controlador.CtlViewSucursalEmpleado;
import Controlador.CtlViewVendedor;
import Controlador.CtlViewVerInventarioSucursalAdmin;
import Controlador.CtlViewVerinventarioSucursalEmpleado;
import Modelo.DaoUsuario;
import Modelo.DaoMoto;
import Modelo.DaoPersona;
import Modelo.DaoSede;
import Modelo.DaoVentasMotos;
import Modelo.Inventario;
import Modelo.Moto;
import Modelo.Persona;
import Modelo.Sede;
import Modelo.Usuario;
import Modelo.Venta;
import Vista.ViewAdministrador;
import Vista.ViewAgregarVendedor;
import Vista.ViewCatalogoAutomaticas;
import Vista.ViewCatalogoCross;
import Vista.ViewCatalogoDeportivas;
import Vista.ViewCatalogoPrincipal;
import Vista.ViewCatalogoSuperDep;
import Vista.ViewCatalogoTodoterreno;
import Vista.ViewCatalogoUrbanas;
import Vista.ViewCerrarSesionAdmin;
import Vista.ViewCerrarSesionEmpleado;
import Vista.ViewConsultarVentas;
import Vista.ViewPrincipal;
import Vista.ViewRealizarVenta;
import Vista.ViewRegistrarmoto;
import Vista.ViewRegistrarpago;
import Vista.ViewSucursalAdministrador;
import Vista.ViewSucursalEmpleado;
import Vista.ViewVendedor;
import Vista.ViewVerInventarioSucursalAdmin;
import Vista.ViewVerInventarioSucursalEmpleado;



/**
 *
 * @author User
 */
public class ProyectoYamaha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Datos
        Persona persona = new Persona();
        Usuario usuario = new Usuario();
        Moto moto = new Moto();
        Sede sede = new Sede();
        Venta venta = new Venta();
        Inventario inventario = new Inventario();
        
        //Dao
        DaoUsuario daousuario = new DaoUsuario();
        DaoMoto daomoto = new DaoMoto();
        DaoSede daosede = new DaoSede();
        DaoVentasMotos daoventasmotos = new DaoVentasMotos();
        DaoPersona daopersona = new DaoPersona();
        
        
        
        //Vistas
        ViewPrincipal vp = new ViewPrincipal();
        ViewAdministrador vpa = new ViewAdministrador();
        ViewVendedor vpv = new ViewVendedor();
        ViewCatalogoPrincipal vcp = new ViewCatalogoPrincipal();
        ViewCerrarSesionAdmin vcsa = new ViewCerrarSesionAdmin();
        ViewCerrarSesionEmpleado vcsv = new ViewCerrarSesionEmpleado();
        ViewCatalogoDeportivas vcd = new ViewCatalogoDeportivas();
        ViewCatalogoSuperDep vsd = new ViewCatalogoSuperDep();
        ViewCatalogoAutomaticas vca = new ViewCatalogoAutomaticas();
        ViewCatalogoCross vcc = new ViewCatalogoCross();
        ViewCatalogoUrbanas vcu = new ViewCatalogoUrbanas();
        ViewCatalogoTodoterreno vctt = new ViewCatalogoTodoterreno();
        ViewRegistrarmoto vrm = new ViewRegistrarmoto();
        ViewSucursalAdministrador vsa = new ViewSucursalAdministrador();
        ViewSucursalEmpleado vse = new ViewSucursalEmpleado();
        ViewConsultarVentas vcv = new ViewConsultarVentas();
        ViewAgregarVendedor vav = new ViewAgregarVendedor();
        ViewRealizarVenta vrv = new ViewRealizarVenta();
        ViewVerInventarioSucursalAdmin vvisa = new ViewVerInventarioSucursalAdmin();
        ViewVerInventarioSucursalEmpleado vvise = new ViewVerInventarioSucursalEmpleado();
        ViewRegistrarpago vrp = new ViewRegistrarpago();
        
        
        //Controladores
        CtlViewPrincipal ctlvp = new CtlViewPrincipal(vp, vpa, vpv, vcp, daousuario, usuario);
        CtlViewCatalogoPrincipal ctlvcp = new CtlViewCatalogoPrincipal(vcp, vcd, vsd, vca, vcc, vcu, vctt, vp);
        CtlViewRegresarAutomaticas ctlvrg = new CtlViewRegresarAutomaticas(vcp, vca);
        CtlViewRegresarDeportivas ctlvrd = new CtlViewRegresarDeportivas(vcd, vcp);
        CtlViewRegresarEnduro ctvre = new CtlViewRegresarEnduro(vcc, vcp);
        CtlViewRegresarSuperD ctvrsd = new CtlViewRegresarSuperD(vsd, vcp);
        CtlViewRegresarTodoterreno ctvrtt = new CtlViewRegresarTodoterreno(vcp, vctt);
        CtlViewRegresarUrbanas ctvru = new CtlViewRegresarUrbanas(vcp, vcu);
        //controladores admin
        CtlViewAdministrador ctlva = new CtlViewAdministrador(vpa, vrm, vsa, vcv, vav, vcsa);
        CtlViewCerrarSesionAdministrado ctlcsa = new CtlViewCerrarSesionAdministrado(vp, vpa, vcsa);
        CtlViewRegistrarMoto ctlvrm = new CtlViewRegistrarMoto(daomoto, vrm, moto, vcsa);
        CtlViewSucursalAdministrador ctlvsa = new CtlViewSucursalAdministrador(vsa, vvisa, vcsa, daosede, daousuario);
        CtlViewVerInventarioSucursalAdmin ctlvisa = new CtlViewVerInventarioSucursalAdmin(vvisa, vcsa, 1);
        CtlViewAgregarVendedor ctlvav = new CtlViewAgregarVendedor(vcsa, vav, daousuario, daopersona);
        CtlViewConsultarVentas ctlcv = new CtlViewConsultarVentas(vcsa, vcv, daoventasmotos, daousuario);
        //Controladores empleado
        CtlViewVendedor ctlvv = new CtlViewVendedor(vrv, vse, vpv, vcsv);
        CtlViewCerrarSesionEmpleado ctlcse = new CtlViewCerrarSesionEmpleado(vp, vpv, vcsv);
        CtlViewSucursalEmpleado ctvse = new CtlViewSucursalEmpleado(vse, vvise, vcsv, daosede, daousuario);
        CtlViewVerinventarioSucursalEmpleado ctvise = new CtlViewVerinventarioSucursalEmpleado(vvise, vcsv, 1);
        CtlViewRegistrarPago ctvrp = new CtlViewRegistrarPago(vrp, vcsv);
        CtlViewRealizarVenta vrvev = new CtlViewRealizarVenta(vrp, vrv, vcsv, daousuario);
        
        
        
        vp.setVisible(true);
    }
    
}


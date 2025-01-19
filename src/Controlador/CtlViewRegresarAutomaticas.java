
package Controlador;



import Vista.ViewCatalogoAutomaticas;
import Vista.ViewCatalogoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtlViewRegresarAutomaticas implements ActionListener{

    private ViewCatalogoAutomaticas vca; 

    private ViewCatalogoPrincipal vcp;


    public CtlViewRegresarAutomaticas(ViewCatalogoPrincipal vcp,ViewCatalogoAutomaticas vca) {
        this.vca = vca;
        this.vcp = vcp;
        
        this.vca.btnRegresar.addActionListener(this);
           
    }    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vca.btnRegresar)){
            vcp.setVisible(true);
            vca.dispose();
       }
    
       
    }
    
}

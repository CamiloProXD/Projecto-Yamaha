
package Controlador;
import Vista.ViewCatalogoDeportivas;
import Vista.ViewCatalogoPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlViewRegresarDeportivas implements ActionListener{
    
    private ViewCatalogoDeportivas vcd;
    private ViewCatalogoPrincipal vcp;

    public CtlViewRegresarDeportivas(ViewCatalogoDeportivas vcd, ViewCatalogoPrincipal vcp) {
        this.vcd = vcd;
        this.vcp = vcp;
        
        this.vcd.btnRegresarM.addActionListener(this);
    }
    
    
    @Override
   
    public void actionPerformed(ActionEvent ev) {
        if(ev.getSource().equals(vcd.btnRegresarM)){
            vcp.setVisible(true);
            vcd.dispose();
       }    
    }
}

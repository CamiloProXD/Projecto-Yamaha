package Controlador;

import Vista.ViewCatalogoPrincipal;
import Vista.ViewCatalogoCross;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlViewRegresarEnduro implements ActionListener {

    private ViewCatalogoCross vcc;
    private ViewCatalogoPrincipal vcp;

    public CtlViewRegresarEnduro(ViewCatalogoCross vcc, ViewCatalogoPrincipal vcp) {
        this.vcc = vcc;
        this.vcp = vcp;

        this.vcc.btnRegresarCros.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource().equals(vcc.btnRegresarCros)) {
            vcp.setVisible(true);
            vcc.dispose();
        }

    }
}

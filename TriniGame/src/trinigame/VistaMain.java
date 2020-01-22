/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Jorge
 */
public class VistaMain extends JPanel {
    
    Vista vista;
    ControladorVistaMain controladorVistaMain;
    
    public VistaMain(Vista vista) {
        this.vista = vista;
        controladorVistaMain = new ControladorVistaMain(vista);
        
        setVistaMain();
    }
    
    public void setVistaMain() {
        this.setLayout(null);
        this.setBounds(0, 0, Vista.ANCHO_VENTANA, Vista.LARGO_VENTANA);
        
        //Panel central del logotipo:
        JPanel panelCentral = new JPanel();
        panelCentral.setBounds(0, 200, Vista.ANCHO_VENTANA, 50);
        JLabel logotipo = new JLabel("TriniGame");
        panelCentral.add(logotipo);
        
        //Panel Inferior boton siguiente y cargando:
        JPanel panelInferior = new JPanel();
        panelInferior.setBounds(0, 522, Vista.ANCHO_VENTANA, 50);
        JLabel etiquetaCargando = new JLabel("* * * CARGANDO * * *");
        panelInferior.add(etiquetaCargando);
        
        this.add(panelCentral);
        this.add(panelInferior);
        
        controladorVistaMain.iniciarContadorVistaMain();
    }
    
}

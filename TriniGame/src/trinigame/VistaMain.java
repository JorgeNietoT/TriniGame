/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 *
 * @author Jorge
 */
public class VistaMain extends JPanel {
    
    Vista vista;
    ControladorVistaMain controladorVistaMain;
    JProgressBar barraCarga;
    int numeroActual=0;
    
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
        
        //barra carga
        
        
        JPanel parteBarraCarga = new JPanel();
        parteBarraCarga.setBounds(0, 350, Vista.ANCHO_VENTANA, 50);
        
        barraCarga=new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        barraCarga.setValue(0);
        barraCarga.setStringPainted(true);
        
        parteBarraCarga.add(barraCarga);
        
       
        
        //Panel Inferior boton siguiente y cargando:
        JPanel panelInferior = new JPanel();
        panelInferior.setBounds(0, 522, Vista.ANCHO_VENTANA, 50);
        JLabel etiquetaCargando = new JLabel("* * * CARGANDO * * *");
        panelInferior.add(etiquetaCargando);
        
        this.add(panelCentral);
        this.add(panelInferior);
        this.add(parteBarraCarga);
        
    }
    
     public void empezarControlador(){
        controladorVistaMain.iniciarContadorVistaMain();
    }
    
    public void cambiarPosicionBarra(int numero){
        barraCarga.setValue(numero);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import org.json.simple.parser.ParseException;
import static trinigame.Vista.ANCHO_VENTANA;
import static trinigame.Vista.LARGO_VENTANA;

/**
 *
 * @author Jorge
 */
public class VistaThird extends JPanel {
    
    Vista vista;
    ControladorTimerVistaThird controladorTimerVistaThird;
    
    ControladorVistaThird controladorVistaThird;
    
    public VistaThird(Vista vista) throws IOException, ParseException {
        this.vista = vista;
        controladorVistaThird = new ControladorVistaThird(this, vista);
        controladorTimerVistaThird = new ControladorTimerVistaThird(vista);
        
        setVistaThird();
    }
    
    public void setVistaThird() {
        this.setLayout(null);
        this.setBounds(0, 0, ANCHO_VENTANA, LARGO_VENTANA);
        
        //Panel central del logotipo:
        JPanel panelCentral = new JPanel();
        panelCentral.setBounds(0, 200, ANCHO_VENTANA, 50);
        JLabel logotipo = new JLabel("TriniGame");
        panelCentral.add(logotipo);
        
        //Panel Inferior boton preparado:
        JPanel panelInferior = new JPanel();
        panelInferior.setBounds(0, 300, ANCHO_VENTANA, 200);
        JLabel etiquetaPreparado = new JLabel("¿Preparado para jugar?");
        JRadioButton radioButtonPreparado = new JRadioButton();
        radioButtonPreparado.addActionListener(controladorVistaThird);
        panelInferior.add(etiquetaPreparado);
        panelInferior.add(radioButtonPreparado);
        
        this.add(panelCentral);
        this.add(panelInferior);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static trinigame.Vista.ANCHO_VENTANA;
import static trinigame.Vista.LARGO_VENTANA;

/**
 *
 * @author Jorge
 */
public class VistaFourth extends JPanel {
    
    Vista vista;
    
    ControladorVistaFourth controladorVistaFourth;

    public VistaFourth(Vista vista) {
        this.vista = vista;
        controladorVistaFourth = new ControladorVistaFourth(this);
        
        setVistaFourth();
    }
    
    public void setVistaFourth() {
        this.setLayout(null);
        this.setBounds(0, 0, ANCHO_VENTANA, LARGO_VENTANA);
        
        //Panel superior preguntas:
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 100, ANCHO_VENTANA, 50);
        JLabel etiquetaPregunta = new JLabel("¿Quien fue Nelson Mandela?");
        panelSuperior.add(etiquetaPregunta);
        
        //Panel Inferior respuestas:
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(5,1));
        panelInferior.setBounds(150, 300, ANCHO_VENTANA, 175);
        JLabel etiquetaRespuesta = new JLabel("Respuesta: ");
        CheckboxGroup grupoCheckboxRespuestas = new CheckboxGroup();
        Checkbox checkboxRespuesta1 = new Checkbox("Alguien", grupoCheckboxRespuestas, false);
        Checkbox checkboxRespuesta2 = new Checkbox("Nadie", grupoCheckboxRespuestas, false);
        Checkbox checkboxRespuesta3 = new Checkbox("Ambas", grupoCheckboxRespuestas, false);
        Checkbox checkboxRespuesta4 = new Checkbox("Ninguna", grupoCheckboxRespuestas, false);
        
        checkboxRespuesta1.setName("respuesta1");
        checkboxRespuesta2.setName("respuesta2");
        checkboxRespuesta3.setName("respuesta3");
        checkboxRespuesta4.setName("respuesta4");
        
        checkboxRespuesta1.addItemListener(controladorVistaFourth);
        checkboxRespuesta2.addItemListener(controladorVistaFourth);
        checkboxRespuesta3.addItemListener(controladorVistaFourth);
        checkboxRespuesta4.addItemListener(controladorVistaFourth);
        
        panelInferior.add(etiquetaRespuesta);
        panelInferior.add(checkboxRespuesta1);
        panelInferior.add(checkboxRespuesta2);
        panelInferior.add(checkboxRespuesta3);
        panelInferior.add(checkboxRespuesta4);
        
        this.add(panelSuperior);
        this.add(panelInferior);
    }
    
}

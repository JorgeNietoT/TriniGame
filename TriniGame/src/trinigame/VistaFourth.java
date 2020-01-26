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
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public final class VistaFourth extends JPanel {
    
    Vista vista;
    Conexion con;
    
    ControladorVistaFourth controladorVistaFourth;

    public VistaFourth(Vista vista, int idPregunta) throws ParseException, IOException {
        this.vista = vista;
        controladorVistaFourth = new ControladorVistaFourth(this, vista.getLog(), vista);
        
        try {
            con = new Conexion();
        } catch (IOException ex) {}
        
        setVistaFourth(idPregunta);
    }
    
    public void setVistaFourth(int idPregunta) throws IOException, MalformedURLException, ParseException {
        this.setLayout(null);
        this.setBounds(0, 0, ANCHO_VENTANA, LARGO_VENTANA);
        
        String[] pregunta = cargarPregunta(idPregunta);
        //Panel superior preguntas:
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 100, ANCHO_VENTANA, 50);
        JLabel etiquetaPregunta = new JLabel(pregunta[0]);
        panelSuperior.add(etiquetaPregunta);
        
        //Panel Inferior respuestas:
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(5,1));
        panelInferior.setBounds(150, 300, ANCHO_VENTANA, 175);
        JLabel etiquetaRespuesta = new JLabel("Respuesta: ");
        CheckboxGroup grupoCheckboxRespuestas = new CheckboxGroup();
        
        Checkbox checkboxRespuesta1 = new Checkbox(pregunta[1], grupoCheckboxRespuestas, false);
        Checkbox checkboxRespuesta2 = new Checkbox(pregunta[2], grupoCheckboxRespuestas, false);
        Checkbox checkboxRespuesta3 = new Checkbox(pregunta[3], grupoCheckboxRespuestas, false);
        Checkbox checkboxRespuesta4 = new Checkbox(pregunta[4], grupoCheckboxRespuestas, false);
        
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
    
    public String[] cargarPregunta(int id) throws IOException, MalformedURLException, ParseException{
        Pregunta objPregunta = con.pedirPregunta(id);
        
        String[] preguntaEnString = new String[5];
        preguntaEnString[0] = objPregunta.getPregunta();
        preguntaEnString[1] = objPregunta.getRes1();
        preguntaEnString[2] = objPregunta.getRes2();
        preguntaEnString[3] = objPregunta.getRes3();
        preguntaEnString[4] = objPregunta.getRes4();
        
        return preguntaEnString;
        
    }
    
}

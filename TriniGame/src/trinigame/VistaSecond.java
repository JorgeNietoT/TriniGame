/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.json.simple.parser.ParseException;
import static trinigame.Vista.ANCHO_VENTANA;
import static trinigame.Vista.LARGO_VENTANA;

/**
 *
 * @author Jorge
 */
public class VistaSecond extends JPanel{
    
    Vista vista;
    
    ControladorVistaSecond controladorVistaSecond;
    
    private JTextField campoTextoIdUsuario; 
    
    public VistaSecond(Vista vista) throws IOException, ParseException {
        this.vista = vista;
        controladorVistaSecond = new ControladorVistaSecond(vista, this);
        
        setVistaSecond();
    }
    
    public void setVistaSecond() {
        this.removeAll();
        
        this.setLayout(null);
        this.setBounds(0, 0, ANCHO_VENTANA, LARGO_VENTANA);
        
        //Panel Inferior introducir id:
        JPanel panelInferior = new JPanel();
        panelInferior.setBounds(0, 300, ANCHO_VENTANA, 200);
        panelInferior.setLayout(null);
        JLabel etiquetaIntroducirId = new JLabel("Introducir ID de Usuario ");
        etiquetaIntroducirId.setBounds(100, 0, 150, 25);
        campoTextoIdUsuario = new JTextField();
        campoTextoIdUsuario.setBounds(250, 0, 50, 25);
        JButton botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(150, 50, 90, 30);
        botonContinuar.addActionListener(controladorVistaSecond);
        panelInferior.add(etiquetaIntroducirId);
        panelInferior.add(campoTextoIdUsuario);
        panelInferior.add(botonContinuar);
        
        //Panel Superior del logotipo:
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(0, 100, ANCHO_VENTANA, 100);
        JLabel logotipo = new JLabel("TriniGame");
        panelSuperior.add(logotipo);
        
        this.add(panelSuperior);
        this.add(panelInferior);
        
        this.setSize(ANCHO_VENTANA + 1, LARGO_VENTANA + 1);
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
    }
    
    public String getUserId(){
        return campoTextoIdUsuario.getText();
    }
    
}

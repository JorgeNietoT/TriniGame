/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jorge
 */
public class Vista extends Frame {
    
    
    
    public static final int ANCHO_VENTANA = 400;
    public static final int LARGO_VENTANA = 600;
    
    ControladorVistaMain controladorVistaMain;
    
    private Logica log = new Logica();
    private Timer timer;
    private VistaMain vistaMain;
    private VistaSecond vistaSecond;
    private VistaThird vistaThird;
    private VistaFourth vistaFourth;
    
    public Vista() throws IOException, ParseException {
        
        
        setVistaMain();
        //setVistaSecond();
        //setVistaThird();
        setVentana();
        cerrarVentana();
    }
    
    public void setVentana() {
        this.setLayout(new GridLayout(1,1));
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
        this.setResizable(true);
        this.setVisible(true);
    }
    
    public void setVistaMain() {
        vistaMain = new VistaMain(this);
        this.add(vistaMain);
        vistaMain.empezarControlador();
    }
    
    public void setVistaSecond() throws IOException, ParseException {
        this.removeAll();
        vistaSecond = new VistaSecond(this);
        this.add(vistaSecond);
        
        this.setSize(ANCHO_VENTANA + 1, LARGO_VENTANA + 1);
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
    }
    
    public void setVistaThird() throws IOException, ParseException {
        this.removeAll();
        
        vistaThird = new VistaThird(this);
        this.add(vistaThird);
        
        this.setSize(ANCHO_VENTANA + 1, LARGO_VENTANA + 1);
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
    }
    
    public void setVistaFourth() throws ParseException, IOException {
       
        int numPregunta = log.darContadorPregunta();
        
        this.removeAll();
        
        vistaFourth = new VistaFourth(this,numPregunta);
        this.add(vistaFourth);
        
        this.setSize(ANCHO_VENTANA + 1, LARGO_VENTANA + 1);
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
       
    }
    public void setVistaFourth(int contPregunta) throws ParseException, IOException {
       
        
        this.removeAll();
        
        vistaFourth = new VistaFourth(this,contPregunta);
        this.add(vistaFourth);
        
        this.setSize(ANCHO_VENTANA + 1, LARGO_VENTANA + 1);
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
       
    }
    
    
    public void cerrarVentana() {
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    
    
    public VistaMain getVistaMain() {
        return vistaMain;
    }

    public Logica getLog() {
        return log;
    }
    
    
    
    
}

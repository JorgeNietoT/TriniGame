/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinigame;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dmmli
 */
public class Logica {
    
    private Conexion con;
    private int numPreguntas = 0;
    public static int ID_USUARIO;
    
    public Logica() throws IOException, ParseException{
        con = new Conexion();
    }
    
    public boolean comprobarExisteUsuario(int id) throws IOException, MalformedURLException, ParseException{
        Object obj = con.showUser(id);
        
        if(obj != null) return true;
        return false;
        
    }
    
    public void guardarIdUsuario(int id){
        this.ID_USUARIO = id;
    }
    
    public int getIdUsuario(){
        return ID_USUARIO;
    }
    
    public void siguienteTurno(){
        numPreguntas++;
    }
    public int darContadorPregunta(){
        return numPreguntas;
    }
    
    public void mandarRespuestaUsuario(int numRes) throws IOException{
        con.enviarRespuestaUsuario(numRes,numPreguntas,ID_USUARIO );
    }

}

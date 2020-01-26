package trinigame;


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



    

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Conexion {
   
   private URL url;
   private String urlConectar = "http://localhost/TriniGame/public/conectar/";
   private String urlConsultarInicio = "http://localhost/TriniGame/public/comprobarTodosJugadoresListos";
   
   private BufferedReader in;
   private String in_json;
   private  JSONParser parser = new JSONParser();
   private Gson gson = new Gson();

    public Conexion() throws  IOException, ParseException {
      
       
    }
    
    public Object showUser(int id) throws MalformedURLException, IOException, ParseException{
        
        urlConectar = "http://localhost/TriniGame/public/conectar/";
        
         urlConectar += id;
         url = new URL(urlConectar);
         
         //Realizamos peticion con GET
         URLConnection con = url.openConnection();
         
         //Objeto para recibir respuesta
         in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         
         //Leemos
         in_json = in.readLine();
         
         System.out.println(in_json);      
         
         Object obj = parser.parse(in_json);
         
         
         in.close();
         
         return obj;
    }
    
    public Object parsearJson(String json) throws ParseException{
        
        Object obj = parser.parse(json);
        System.out.println(json);
        return obj;
    }
   public Boolean PersonaPreparada(int id) throws MalformedURLException, IOException, ParseException{
        
         urlConectar = "http://localhost/TriniGame/public/preparado/";
        
         urlConectar += id;
         url = new URL(urlConectar);
         
         //Realizamos peticion con GET
         URLConnection con = url.openConnection();
         
         //Objeto para recibir respuesta
         in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         
         //Leemos
         in_json = in.readLine();
         
         JSONParser parser = new JSONParser();         
         
         JSONObject object =(JSONObject) parser.parse(in_json);
         String preparado=object.get("Preparado").toString();
         
         in.close();       
         
         return Boolean.valueOf(preparado);
    }

    public void cambiarEstadoAPreparadoFalse(int id) throws MalformedURLException, IOException, ParseException {
        
         urlConectar = "http://localhost/TriniGame/public/cambiarPreparadoFalse/";
        
         urlConectar += id;
         
         System.out.println(urlConectar);
         url = new URL(urlConectar);
         
         //Realizamos peticion con GET
         URLConnection con = url.openConnection();
         
         in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         
         in.close();
             
         
    }

    public void cambiarEstadoPreparadoTrue(int id) throws MalformedURLException, IOException {
         urlConectar = "http://localhost/TriniGame/public/cambiarPreparadoTrue/";
        
         urlConectar += id;
         
         System.out.println(urlConectar);
         url = new URL(urlConectar);
         
         //Realizamos peticion con GET
         URLConnection con = url.openConnection();
         
         in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         
         in.close();
             
    }

    public boolean comprobarTodosListos() throws MalformedURLException, IOException {
         boolean todosListos;
        
         urlConectar = "http://localhost/TriniGame/public/comprobarTodosJugadoresListos";
         
         url = new URL(urlConectar);
         
         //Realizamos peticion con GET
         URLConnection con = url.openConnection();
         
         in = new BufferedReader(new InputStreamReader(con.getInputStream()));
         
         String stringEntrada = in.readLine(); 
         todosListos = Boolean.valueOf(stringEntrada);

                      
         in.close();
         

         return todosListos;
    }
    
    public Pregunta pedirPregunta(int id) throws MalformedURLException, IOException, ParseException{
        String urlPregunta ="http://localhost/TriniGame/public/getPregunta/"+id;
        url = new URL(urlPregunta);
        
        URLConnection con = url.openConnection();
        
        in = new BufferedReader( new InputStreamReader(con.getInputStream()));
        
        in_json = in.readLine();
        
        Pregunta pregunta = gson.fromJson(in_json, Pregunta.class);
        
        return pregunta;
        
        
    }
    
    public void enviarRespuestaUsuario(int numRes,int numPregunta,int idUsuario) throws MalformedURLException, IOException{
         String urlEnviarRes = "http://localhost/TriniGame/public/envRespuesta/"+numRes+"/"+numPregunta+"/"+idUsuario;
         url = new URL(urlEnviarRes);
         
         URLConnection con = url.openConnection();
         
         in = new BufferedReader( new InputStreamReader(con.getInputStream()));
        
        in_json = in.readLine();
        
        System.out.println(in_json);
    }
}



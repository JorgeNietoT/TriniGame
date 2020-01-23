<?php

namespace App\Http\Controllers;

use App\Persona;
use Illuminate\Http\Request;

use Kreait\Firebase;
use Kreait\Firebase\Factory;
use Kreait\Firebase\ServiceAccount;
use Kreait\Firebase\Database;


class Personas extends Controller
{


    /*public function __construct()
        {
            $var = $this->PrimeraVez;
            Personas::getContadorDeJugadoresEnUnaPartida();
            Personas::getContadorDeJugadoresListos();
        }*/

    public function showUser($id)
    {
        $url = 'https://trinigame-12007.firebaseio.com/Persona/'.$id.'.json';
        $json = file_get_contents($url);
        //Persona::sumarContadorDeJugadoresEnUnaPartida();
        return $json;
    }

    public function showAllUser()
    {
        $url = 'https://trinigame-12007.firebaseio.com/Persona.json';
        $json = file_get_contents($url);
        return $json;
    }

    public function cambiarValorDeEsperaATrue($id)
    {
        $serviceAccount = ServiceAccount::fromJsonFile(__DIR__.'/trinigame-12007-b794a12b8056.json');
        $firebase = (new Factory)
        ->withServiceAccount($serviceAccount)
        ->withDatabaseUri('https://trinigame-12007.firebaseio.com')
        ->create();
        $database = $firebase->getDatabase();
        $newPost = $database
        ->getReference('/Persona/'.$id)
        ->getChild('Preparado')->set('true');
        //Persona::sumarContadorDeJugadoresListos();
    }

    public function cambiarValorDeEsperaAFalse($id)
    {
        $serviceAccount = ServiceAccount::fromJsonFile(__DIR__.'/trinigame-12007-b794a12b8056.json');
        $firebase = (new Factory)
        ->withServiceAccount($serviceAccount)
        ->withDatabaseUri('https://trinigame-12007.firebaseio.com')
        ->create();
        $database = $firebase->getDatabase();
        $newPost = $database
        ->getReference('/Persona/'.$id)
        ->getChild('Preparado')->set('false');
        //Persona::restarContadorDeJugadoresListos();
    }


    public function aniadirPersona($id,$nombre,$apellidos){
        Personas::aniadirNombre($id,$nombre);
        Personas::aniadirApellido($id,$apellidos);
        Personas::aniadirPreparado($id);

    }

    public function aniadirNombre($id,$nombre){
        $serviceAccount = ServiceAccount::fromJsonFile(__DIR__.'/trinigame-12007-b794a12b8056.json');
        $firebase = (new Factory)
        ->withServiceAccount($serviceAccount)
        ->withDatabaseUri('https://trinigame-12007.firebaseio.com')
        ->create();
        $database = $firebase->getDatabase();
        $newPost = $database
        ->getReference('/Persona/'.$id)
        ->getChild('Nombre')->set($nombre);
    }

    public function aniadirApellido($id,$apellidos){
        $serviceAccount = ServiceAccount::fromJsonFile(__DIR__.'/trinigame-12007-b794a12b8056.json');
        $firebase = (new Factory)
        ->withServiceAccount($serviceAccount)
        ->withDatabaseUri('https://trinigame-12007.firebaseio.com')
        ->create();
        $database = $firebase->getDatabase();
        $newPost = $database
        ->getReference('/Persona/'.$id)
        ->getChild('Apellidos')->set($apellidos);
    }

    public function aniadirPreparado($id){
        $serviceAccount = ServiceAccount::fromJsonFile(__DIR__.'/trinigame-12007-b794a12b8056.json');
        $firebase = (new Factory)
        ->withServiceAccount($serviceAccount)
        ->withDatabaseUri('https://trinigame-12007.firebaseio.com')
        ->create();
        $database = $firebase->getDatabase();
        $newPost = $database
        ->getReference('/Persona/'.$id)
        ->getChild('Preparado')->set(0);
    }
    public function comprobarTodosJugadoresListos(){

       $numJugadores = 5;
       $numJugadoresListos=Personas::getContadorDeJugadoresListos();

       if($numJugadoresListos == $numJugadores) return "true";
       else return "false";
    }

    public function getContadorDeJugadoresListos(){
        $personasPreparadas= 0;
        $url = 'https://trinigame-12007.firebaseio.com/Persona.json';
        $json = file_get_contents($url);

        $array= json_decode($json);

        foreach ($array as $persona) {
           if($persona -> Preparado == "true"){
               $personasPreparadas++;
           }
        }

        return $personasPreparadas;

    }

    public function definirNumJugadores($numJugadores){
        return $numJugadores;
    }
/*


    public function getContadorDeJugadoresEnUnaPartida(){
        if (!isset(ContadorDeJugadoresEnUnaPartida())) {
            $ContadorDeJugadoresEnUnaPartida=0;
        }
        return $ContadorDeJugadoresEnUnaPartida;
    }



    public function sumarContadorDeJugadoresEnUnaPartida(){

        return $ContadorDeJugadoresEnUnaPartida+=1;
    }

    public function restarContadorDeJugadoresEnUnaPartida(){
        return $ContadorDeJugadoresEnUnaPartida-=1;
    }

    public function sumarContadorDeJugadoresListos(){

        return $ContadorDeJugadoresListos+=1;
    }

    public function restarContadorDeJugadoresListos(){
        return $ContadorDeJugadoresListos-=1;
    }*/
}
?>

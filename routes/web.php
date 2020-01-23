<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/conectar/{id}','Personas@showUser');

Route::get('/allUsers','Personas@showAllUser');

Route::get('/crear/{id}/{nombre}/{apellido}','Personas@aniadirPersona');

Route::get('/preparado/{id}','Personas@showUser');

Route::get('/cambiarPreparadoTrue/{id}','Personas@cambiarValorDeEsperaATrue');

Route::get('/cambiarPreparadoFalse/{id}','Personas@cambiarValorDeEsperaAFalse');

Route::get('/comprobarTodosJugadoresListos','Personas@comprobarTodosJugadoresListos');




//http://localhost/TriniGamePruebas/public/preparado/

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class JugadorHumano extends Jugador {

    /**
     * Visor de ataque del jugador humano
     */
    private Map<String, String> visorDeAtaque;

    /**
     * Inicializa el jugador.
     *
     * <br>Inicializa el atributo numBarcosHundidos a 0.
     * <br>Crea un tablero.
     * <br>Inicializa el atributo nombre al argumento nombre.
     * <br>Crea visor_ataque como un mapa vacío.
     *
     * @param nombre el nombre del barco.
     */
    public JugadorHumano(String nombre) {
        super(nombre);
        this.numBarcosHundidos = 0;
        Tablero tablero = new Tablero();
        this.nombre = nombre;
        this.visorDeAtaque = new HashMap<>();
    }

    /**
     * Get the value of visorDeAtaque
     *
     * @return the value of visorDeAtaque
     */
    @Override
    public Map<String, String> getVisorDeAtaque() {
        return this.visorDeAtaque;
    }

    /**
     * Devuelve siempre el string "ASK_USER"
     *
     *
     * @return devuelve siempre el string "ASK_USER"
     */
    @Override
    public String dispara() {
        return "ASK_USER";
    }

    /**
     * Devuelve siempre true
     * @return true
     */
    @Override
    public boolean eresHumano() {
        return true;
    }
    
    /**
     * Devuelve siempre el string "ASK_USER"
     *
     *
     * @return devuelve siempre el string "ASK_USER"
     */
    @Override
    public String procesaTocado(String posDisparo) throws PositionException {
        return "ASK_USER";
    }
    
    /**
     * Devuelve siempre el string "ASK_USER"
     *
     *
     * @return devuelve siempre el string "ASK_USER"
     */
    @Override
    public String procesaHundido(String posDisparo, int numTotalBarcos) {
        super.procesaHundido(posDisparo, numTotalBarcos);
        return "ASK_USER";
    }

    /**Anota el resultado pasado como argumento al disparar a la posición 
     * pasada como argumento, en el visor de ataque del jugador.
    *
    * @param posDisparo   la posición a la que el jugador ha disparado
    * @param resultado   el resultado del disparo (Jugador.AGUA, Jugador.TOCADO 
    * o Jugador.HUNDIDO)
    */
    @Override
    public void anotaDisparoPropio(String posDisparo, String resultado) {
        this.visorDeAtaque.put(posDisparo, resultado);
    }

    /**
     * Anota el resultado del disparo del adversario en el tablero de este
     * jugador humano.
     *
     * Si el resultado es agua, hay que anotar agua en humano en el tablero. Si
     * no es así, hay que obtener el barco y añadir la posición al conjunto de
     * posiciones tocadas del barco tocado o hundido.\n
     *
     * Debe usar los métodos Tablero::anotaAguaEnHumano, Tablero::getBarcoEn y
     * Barco::addPosicionTocada.
     *
     * @param posDisparo la posición a la que el adversario ha disparado
     * @param resultado el resultado del disparo (Jugador.AGUA, Jugador.TOCADO o
     * Jugador.HUNDIDO)
     */  
    @Override
    public void anotaDisparoAjeno(String posDisparo, String resultado) {
        if(resultado.equals(Jugador.AGUA))
            this.tablero.anotaAguaEnHumano(posDisparo);
        else{
            Barco b = this.tablero.getBarcoEn(posDisparo);
            b.addPosicionTocada(posDisparo);
        }
    }

        /**Retorna true si el usuario ya ha disparado antes a la posición 
         * pasada como argumento (puede usarse el visor
    * de disparos para averiguarlo); retorna false en caso contrario.
    *
    * @param    posicion  la posición a la que dispara el jugador.
    * @return   true si el usuario ya ha disparado antes a la posición pasada 
    * como argumento; false en caso contrario
    */
    public boolean hasDisparadoAquiAntes(String posicion){
        if(this.visorDeAtaque.containsKey(posicion))
            return true;
        else 
            return false;
    }
}

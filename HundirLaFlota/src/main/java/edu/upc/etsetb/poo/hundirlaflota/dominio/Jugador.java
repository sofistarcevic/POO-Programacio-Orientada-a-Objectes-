/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import java.util.Map;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public abstract class Jugador {

    /**
     * Constante que indica Agua
     */
    public static final String AGUA = "A";

    /**
     * Constante que indica Tocado
     */
    public static final String TOCADO = "T";

    /**
     * Constante que indica Hundido
     */
    public static final String HUNDIDO = "H";

    /**
     * El nombre del jugador
     */
    protected String nombre;

    /**
     * El número de barcos de la flota del jugador que han sido hundidos por el
     * adversario
     */
    protected int numBarcosHundidos;

    /**
     * El tablero con la flota del jugador
     */
    protected Tablero tablero;

    /**
     * Inicializa el jugador.
     *
     * <br>Inicializa el atributo numBarcosHundidos a 0.
     * <br>Crea un tablero.
     * <br>Inicializa el atributo nombre al argumento nombre.
     *
     * @param nombre el nombre del barco.
     */
    public Jugador(String nombre) {
        this.numBarcosHundidos = 0;
        this.tablero = new Tablero();
        this.nombre = nombre;
    }

    /**
     * Get the value of tablero
     *
     * @return the value of tablero
     */
    public Tablero getTablero() {
        return this.tablero;
    }

    /**
     * Invoca al método Tablero::pon_barco(...) para poner, en el tablero del
     * jugador, el barco pasado como argumento, en la posición pasada como
     * argumento, y en la dirección pasada como argumento.
     *
     * @param barco el barco a depositar en el tablero.
     * @param posicion la primera posición que ocupará el barco en el tablero.
     * @param direccion la dirección en la que se dispondrá el barco en el
     * tablero.
     *
     * @throws PositionException si alguna de las posiciones no es correcta o si
     * alguna de las posiciones contacta con algún barco.
     */
    public void ponBarco(Barco barco, String posicion, String direccion)
            throws PositionException {
        this.tablero.ponBarco(barco, posicion, direccion);
    }

    /**
     * Devuelve dónde ha dado un disparo del adversario a la posición pasada
     * como argumento. Usa los métodos Tablero::getContenidoCasilla y
     * Barco::hundiraEsteTocado.
     *
     * @param posicion la posición del tablero a la que el adversario ha
     * disparado.
     *
     * @return Jugador.AGUA si el disparo ha dado en el agua; Jugador.TOCADO si
     * el disparo ha tocado a alguno de los barcos del jugador pero no lo ha
     * hundido; Jugador.HUNDIDO si el disparo ha hundido a alguno de los barcos
     * del jugador.
     */
    public String dondeHanDado(String posicion) {
        if(this.tablero.getContenidoCasilla(posicion)!= null){
            if(!this.tablero.getContenidoCasilla(posicion).hundiraEsteTocado(posicion))
                return Jugador.TOCADO;
            else
                return Jugador.HUNDIDO;
        }
        else
            return Jugador.AGUA;
    }

    /**
     * Método que las subclases JugadorHumano y JugadorMaquina deberán
     * implementar para que se ejecute después de que hayan hundido algún barco
     * del adversario; en esta clase el código incrementa en 1 el valor del
     * atributo numBarcosHundidos y devuelve null; en las subclases se
     * especificará un retorno distinto.
     *
     * @param posDisparo la posición a la que el adversario le ha disparado (y
     * hundido algún barco) al jugador
     *
     * @param numTotalBarcos número total de barcos del jugador
     *
     * @return null
     */
    public String procesaHundido(String posDisparo, int numTotalBarcos) {
        this.numBarcosHundidos++;
        return null;
    }

    /**
     * Método que las subclase JugadorHumano deberá implementar para averiguar
     * si el usuario ha disparado antes a la posición pasada como argumento; en
     * esta clase debe retornar siempre false.
     *
     * @param posDisparo la posición a la que dispara el jugador.
     *
     * @return false siempre en la clase Jugador.
     */
    public boolean hasDisparadoAquiAntes(String posDisparo) {
        return false;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Get the value of numBarcosHundidos
     *
     * @return the value of numBarcosHundidos
     */
    public int getNumBarcosHundidos() {
        return this.numBarcosHundidos;
    }

    /**
     * Método abstracto que las subclases JugadorHumano y JugadorMaquina deberán
     * implementar para que se ejecute cuando les toque disparar
     *
     * @return la posición a la que el jugador dispara
     */
    public abstract String dispara();

    /**
     * Método abstracto que las subclases deberán implementar.
     *
     * @return true si el jugador es humano, false si el jugador es un jugador
     * máquina
     */
    public abstract boolean eresHumano();

    /**
     * Método que las subclases JugadorHumano y JugadorMaquina deberán
     * implementar para que se ejecute después de que hayan tocado algún barco
     * del adversario sin haberlo hundido
     *
     * @param posDisparo la posición a la que el adversario le ha disparado (y
     * hundido algún barco) al jugador
     *
     * @return la posición a la que el jugador dispara al finalizar el procesado
     * de tocado
     *
     * @throws PositionException si la posición no es correcta
     */
    public abstract String procesaTocado(String posDisparo) throws PositionException;

    /**
     * Método abstracto que las subclases JugadorHumano y JugadorMaquina deberán
     * implementar para que se ejecute después de que un jugador haya realizado
     * un disparo, para anotarlo en su visor de ataque.
     *
     * @param posDisparo la posición a la que el jugador ha disparado
     * @param resultado el resultado del disparo
     */
    public abstract void anotaDisparoPropio(String posDisparo, String resultado);

    /**
     * Método abstracto que las subclases JugadorHumano y JugadorMaquina deberán
     * implementar para que se ejecute después de que el adversario haya
     * realizado un disparo, para anotarlo en el tablero de barcos propios del
     * jugador atacado.
     *
     * @param posDisparo la posición a la que el adversario ha disparado
     * @param resultado el resultado del disparo
     */
    public abstract void anotaDisparoAjeno(String posDisparo, String resultado);

    /**
     * Método abstracto que las subclases deberán implementar para que devuelva
     * el visor de ataque; en el caso de jugador humano, a fin de que éste pueda
     * ser presentado al usuario.
     *
     * @return el visor de ataque
     */
    public abstract Map<String, String> getVisorDeAtaque();

}

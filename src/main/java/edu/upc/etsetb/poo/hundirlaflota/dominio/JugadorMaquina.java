/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class JugadorMaquina extends Jugador {

    /**
     * Número de objetos de esta clase que se han creado
     */
    private static int numInstances = 0;

    /**
     * lista con todas las posiciones ("A1", etc) a las que el jugador máquina
     * NO ha disparado
     */
    private List<String> noDisparadas;

    /**
     * lista de posiciones del adversario a las que este jugador ha tocado
     */
    private List<String> tocadas;

    /**
     * lista de posiciones a las que el jugador máquina disparará en sus
     * siguientes turnos (no está vacía después de tocar algún barco adversario)
     * se vacía al hundir un barco del adversario
     */
    private List<String> proximosDisparos;

    /**
     * dirección en la que el barco del adversario tocado se ha dispuesto sobre
     * el tablero ("H" o "V")
     */
    private String dirBarcoTocado;

    /**
     * objeto instancia de clase Random, que se usará para generar disparos
     * aleatoriamente en algunas ocasiones
     */
    private Random myRandom;

    /**
     * Inicializa el jugador máquina.
     *
     * <br>Incrementa en una unidad el valor de JugadorMaquina.num_instances.
     * <br>Crea un tablero.
     * <br>Inicializa num_barcos_hundidos a 0.
     * <br>Inicializa noDisparadas con todas las casillas del tablero. Para ello
     * debe invocar al método Posicion::todasLasCasillas.
     * <br>Inicializa tocadas a una lista vacía.
     * <br>Inicializa proximosDisparos a una lista vacía.
     * <br>Inicializa dirBarcoTocado a null.
     * <br>Inicializa myRandom a un objeto de clase Random y le asigna como
     * semilla el valor de JugadorMaquina.num_instances.
     * <br>Inicializa nombre a "JugadorMaquina-" seguido del valor de
     * JugadorMaquina::numInstances.
     */
    public JugadorMaquina() {
        super("");
        JugadorMaquina.numInstances++;
        Tablero tablero = new Tablero();
        this.numBarcosHundidos = 0;
        this.noDisparadas = Posicion.todasLasCasillas();
        this.tocadas = new ArrayList<>();
        this.proximosDisparos = new ArrayList<>();
        this.dirBarcoTocado = null;
        this.myRandom = new Random();
        this.myRandom.nextInt(JugadorMaquina.numInstances);
        this.nombre = "Maquina-"+numInstances;
    }

    /**
     * Ordena disparar al JugadorMáquina siguiendo los criterios mostrados en la
     * descripción larga.
     *
     * <br>Si se ha tocado antes a un barco contrario, extrae la primera
     * posición de la lista proximosDisparos y la retorna como posición a la que
     * se realiza un nuevo disparo.
     * <br>En caso contrario calcula aleatoriamente un entero correspondiente a
     * un índice en la lista noDisparadas, extrae esa posición y la retorna como
     * posición a la que se realiza un nuevo disparo
     *
     * @return la primera posición de la lista proximosDisparos si se había
     * tocado antes a un barco o una de las posiciones de noDisparadas elegida
     * aleatoriamente.
     */
    @Override
    public String dispara() {
        int num = myRandom.nextInt(this.noDisparadas.size());
        if(!this.proximosDisparos.isEmpty())     
            return this.proximosDisparos.remove(0);
        else
            return this.noDisparadas.remove(num);   
    }

    /**
     * Retorna siempre false
     *
     * @return false
     */
    @Override
    public boolean eresHumano() {
        return false;
    }

    /**
     * Este método deja en proximosDisparos solo las posiciones que están en la
     * fila o en la columna de la posición pasada como argumento, dependiendo de
     * la dirección del barco tocado.
     *
     * Debe usar los métodos Listas::quitaAUnaOtra, Posicion::getEsteOeste y
     * Posicion::getNorteSur.
     *
     * <br>Si dir es "V":
     * <ol>
     * <li>Se quitan de proximosDisparos las posiciones que no están en la misma
     * columna que la posición de disparo.</li>
     * <li>Se añaden las casillas norte-sur de la posición disparo que no estén
     * todavía en proximosDisparos y que no aparezcan en tocadas.</li>
     * </ol>
     * Si dir es "H":
     * <ol>
     * <li>Se quitan de proximosDisparos las posiciones que no están en la misma
     * fila que la posición de disparo.</li>
     * <li>Se añaden las casillas este-oeste de la posición disparo que no estén
     * todavía en proximosDisparos y que no aparezcan en tocadas.</li>
     * </ol>
     *
     * @param posDisparo posición de disparo.
     *
     * @throws PositionException si alguna posición no es correcta
     */
    public void dejaSoloFilaOColumna(String posDisparo) throws PositionException {
        List<String> quitar = new ArrayList<>();
        Set <String> añadir = new HashSet<>();
        if(this.dirBarcoTocado.equals("V")){
            for(String pos:this.proximosDisparos){
                if(!pos.substring(1).equals(posDisparo.substring(1)))
                    quitar.add(pos);
            }            
            añadir = Posicion.getNorteSur(posDisparo);
        }
        if(this.dirBarcoTocado.equals("H")){
            for(String pos:this.proximosDisparos){
                if(Posicion.filaCharToInt(pos) != Posicion.filaCharToInt(posDisparo))
                    quitar.add(pos);
            }
            añadir = Posicion.getEsteOeste(posDisparo);
        }
 
        Listas.quitaAUnaOtra(this.proximosDisparos, quitar);
        
        for(String p:añadir){
            if(Posicion.esCorrecta(p)){
                if(!this.tocadas.contains(p) && !this.proximosDisparos.contains(p))
                    this.proximosDisparos.add(p);
            }
            else throw new PositionException("Posicion "+p+" incorrecta");
        }
    }

    /**
     * Este método se invoca cuando el jugador máquina ha tocado un barco de su
     * adversario; en la descripción larga se detalla qué debe hacer.
     *
     * El método:
     * <ol>
     * <li>Añade la posición argumento (posición de disparo) a la lista
     * tocadas.</li>
     * <li>Obtiene todas las posiciones adyacentes a la posición de
     * disparo.</li>
     * <li>Trata de eliminar dichas posiciones de la lista noDisparadas.</li>
     * <li>Si es la primera vez que se toca al barco, se hace que
     * proximosDisparos contenga a los puntos cardinales de la posición disparo;
     * a continuación se dispara de nuevo y se devuelve esta nueva posición de
     * disparo.</li>
     * <li>Si es la segunda vez que se toca al barco, se determina la dirección
     * en que se ha dispuesto el barco sobre el tablero<li>
     * <li>Se deja en proximosDisparos solo las posiciones que 
     * están en la fila o en la columna de la posición de disparo en función 
     * de la dirección de disposición del barco</li>
     * <li>se elimina de proximosDisparos aquellas posiciones en las que ya se 
     * había tocado al barco adversario.</li>
     * <li>Se dispara de nuevo y se devuelve el nuevo disparo invocando a
     * JugadorMaquina::dispara().
     * </ol>
     *
     * @param posDisparo la posición de disparo realizada por el jugador máquina
     * que ha tocado a un barco del adversario.
     *
     * @return la posición del nuevo disparo realizado por el jugador máquina
     * (cuando se toca a un barco del adversario se tiene derecho a realizar un
     * nuevo disparo).
     */
    @Override
    public String procesaTocado(String posDisparo) throws PositionException {
        
        this.tocadas.add(posDisparo);

        Set<String> adyacentes = Posicion.getAdyacentes(posDisparo);
        for(String p:adyacentes)
            if(this.noDisparadas.contains(p)) this.noDisparadas.remove(p);
        
        List <String> cardinales = Posicion.getPuntosCardinales(posDisparo);
        if(this.tocadas.size()==1){
            this.proximosDisparos.addAll(cardinales);
        }
        if(this.tocadas.size()>=2){
            char fila = this.tocadas.get(0).charAt(0);
            if(fila==posDisparo.charAt(0)) this.dirBarcoTocado="H";
            else this.dirBarcoTocado="V";
            
            this.dejaSoloFilaOColumna(posDisparo);
            Listas.quitaAUnaOtra(this.proximosDisparos, this.tocadas);
        }
        
        return this.dispara();
    }

    /**
     * Este método se invoca cuando el jugador máquina ha tocado y hundido un
     * barco de su adversario; en la descripción larga se detalla qué debe
     * hacer.
     *
     * <br>Si el número de barcos hundidos es igual al valor del argumento
     * numTotalBarcos, retorna null. Si no es así:
     * <ol>
     * <li>Invoca a procesar_hundido de la superclase.</li>
     * <li>inicializa tocadas a una lista vacía.</li>
     * <li>Inicializa dir_barco_tocado a null.</li>
     * <li>Inicializa proximos_disparos a una lista vacía.</li>
     * <li>Si el número de barcos hundidos del adversario es igual 
     * al valor del argumento numTotalBarcos, retorna null; si no es 
     * así, dispara de nuevo y devuelve el nuevo disparo</li>
     * </ol>
     *
     * @param posDisparo la posición de disparo realizada por el jugador máquina
     * que ha hundido a un barco del adversario.
     * @param numTotalBarcos el número total de barcos del adversario.
     *
     * @return null si ya se han hundido todos los barcos del adversario o la
     * posición de un nuevo disparo si no es así.
     */
    @Override
    public String procesaHundido(String posDisparo, int numTotalBarcos) {
        
        if(this.numBarcosHundidos==numTotalBarcos){
            return null;
        }
        else{
            super.procesaHundido(posDisparo, numTotalBarcos);
            this.tocadas= new ArrayList<>();
            this.dirBarcoTocado=null;
            this.proximosDisparos= new ArrayList<>();
            if(super.getNumBarcosHundidos()==numTotalBarcos){
                return null;
            }
            else{
                return this.dispara();
            }
        }
        
        
    }

    /**
     * NO HACE NADA: todas las anotaciones necesarias para el jugador máquina se
     * realizan en dispara() procesaTocado() y procesaHundido()
     *
     * @param posDisparo la posición de disparo
     * @param resultado el resultado
     */
    @Override
    public void anotaDisparoPropio(String posDisparo, String resultado) {
        
    }

    /**
     * NO HACE NADA: el jugador máquina NO necesita anotar nada del disparo ajeno
     *
     * @param posDisparo la posición de disparo
     * @param resultado el resultado
     */
    @Override
    public void anotaDisparoAjeno(String posDisparo, String resultado) {
        
    }

    /**
     * Lanza la excepción UnsupportedOperationException, ya que un jugador
     * máquina NO tiene visor de ataque y si durante una ejecución se invoca a
     * este método de esta clase, es que el diseño es erróneo.
     *
     * @return no llega a devolver nada porque siempre lanza una excepción.
     */
    @Override
    public Map<String, String> getVisorDeAtaque() {
        throw new UnsupportedOperationException("JugadorMaquina::getVisorDeAtaque. "
                + "Este método no debería invocarse sobre un jugador máquina");
    }

}

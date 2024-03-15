/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.casosdeuso;

import edu.upc.etsetb.poo.hundirlaflota.dominio.ArchivoFlotaException;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Barco;
import edu.upc.etsetb.poo.hundirlaflota.dominio.GeneradorDeFlotas;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Jugador;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorHumano;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorMaquina;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Posicion;
import edu.upc.etsetb.poo.hundirlaflota.dominio.PositionException;
import edu.upc.etsetb.poo.hundirlaflota.iu.Entregador;
import edu.upc.etsetb.poo.hundirlaflota.iu.Gui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class Controlador {

    /**
     * Constante que indica el número de barcos que tiene cada jugador
     */
    public static int numBarcosJugadores = 9;

    /**
     * Atributo iu: objeto Gui
     */
    private Gui iu;

    /**
     * Atributo jugadores: lista de objetos Jugador: los dos jugadores
     */
    private List<Jugador> jugadores;

    /**
     * Atribute random: objeto de clase MyRandom
     */
    private MyRandom random;

    /**
     * Atributo atacante: objeto Jugador que tiene el turno y está atacando a su
     * contrincante
     */
    private Jugador atacante;

    /**
     * Atributo atacante: objeto Jugador que NO tiene el turno y está siendo
     * atacado por su contrincante
     */
    private Jugador atacado;

    /**
     * Atributo renderer: objeto de clase Entregador; la clase Entregador ya
     * está hecha.
     */
    private Entregador renderer;

    /**
     * Atributo generadorFlotas: objeto de clase GeneradorDeFlotas
     */
    private GeneradorDeFlotas generadorFlotas;

    /**
     * Inicializa el controlador; ver detalles en especificación larga.
     *
     * <ul>
     * <li>Asigna a atributos iu y renderer los valores de los respectivos
     * argumentos</li>
     * <li>Crea la lista de jugadores vacía</li>
     * <li>Crea el atributo random sin semilla</li>
     * <li>Inicializa atacante y atacado a null</li>
     * </ul>
     *
     * @param iu referencia al objeto Gui.
     *
     * @param renderer referencia al objeto Entregador.
     */
    public Controlador(Gui iu, Entregador renderer) {
        this.iu = iu;
        this.observadores = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.random = new MyRandom();
        this.renderer = renderer;
        this.generadorFlotas = new GeneradorDeFlotas();
    }

    /**
     * Crea y prepara un jugador máquina con flota determinista; ver detalles en
     * especificación larga.
     *
     * <ol>
     * <li>Crea un jugador máquina</li>
     * <li>Genera su flota determinista</li>
     * <li>Añade el jugador máquina a la lista jugadores</li>
     * </ol>
     *
     * Debe hacer uso del método GeneradorFlotas::generaFlotaDeterminista
     *
     * @throws PositionException si alguna posición es incorrecta
     */
    public void preparaJugadorMaquinaFlotaDet() throws PositionException {
        Jugador jugador = new JugadorMaquina();
        //Crea flota no aleatoria de máquina
        this.generadorFlotas.generaFlotaDeterminista(jugador);
        this.jugadores.add(jugador);
    }

    /**
     * Crea y prepara un jugador máquina con flota aleatoria; ver detalles en
     * especificación larga.
     *
     * <ol>
     * <li>Crea un jugador máquina</li>
     * <li>Genera su flota aleatoria</li>
     * <li>Añade el jugador máquina a la lista jugadores</li>
     * </ol>
     *
     * Debe hacer uso del método GeneradorFlotas::generaFlotaAleatoria
     *
     */
    public void preparaJugadorMaquinaFlotaAl() {
        Jugador jugador = new JugadorMaquina();
        //Crea flota no aleatoria de máquina
        this.generadorFlotas.generaFlotaAleatoria(jugador);
        this.jugadores.add(jugador);
    }

    /**
     * Crea y prepara un jugador humano con flota determinista; ver detalles en
     * especificación larga.
     *
     * <ol>
     * <li>Crea un jugador humano</li>
     * <li>Genera su flota determinista</li>
     * <li>Añade el jugador humano a la lista jugadores</li>
     * </ol>
     *
     * Debe hacer uso del método GeneradorFlotas::generaFlotaDeterminista
     *
     * @param nombre el nombre del jugador humano
     *
     * @throws PositionException si hay alguna posición incorrecta
     *
     */
    public void preparaJugadorHumanoFlotaDet(String nombre)
            throws PositionException {
        Jugador jugador = new JugadorHumano(nombre);
        //Crea flota no aleatoria de jugador humano
        this.generadorFlotas.generaFlotaDeterminista(jugador);
        this.jugadores.add(jugador);
    }

    /**
     * Crea y prepara un jugador humano con flota leida de archivo; ver detalles
     * en especificación larga.
     *
     * <ol>
     * <li>Crea un jugador humano</li>
     * <li>Genera su flota leyéndola de un archivo</li>
     * <li>Añade el jugador humano a la lista jugadores</li>
     * <li>Muestra los tableros del jugador humano por consola</li>
     * </ol>
     *
     * Debe hacer uso del método GeneradorFlotas::leeFlotaDeArchivo
     *
     * @param nombre el nombre del jugador humano
     *
     * @param pathFicheroFlota el path del archivo con los detalles de la flota
     * del jugador humano
     *
     * @throws PositionException si hay alguna posición incorrecta
     *
     * @throws IOException si se produce un error en la apertura o lectura del
     * archivo
     *
     * @throws ArchivoFlotaException si el archivo contiene algún error en sus
     * contenidos
     */
    public void preparaJugadorHumanoFlotaFichero(String nombre,
            String pathFicheroFlota) throws PositionException, IOException,
            ArchivoFlotaException {
        JugadorHumano jugador = new JugadorHumano(nombre);
        this.generadorFlotas.leeFlotaDeArchivo(jugador, pathFicheroFlota);
        this.jugadores.add(jugador);
        this.renderer.muestraTablerosHumano(jugador);
    }

    /**
     * Prepara una partida entre dos jugadores máquina cuyas flotas son la flota
     * determinista; ver detalles en especificación larga.
     *
     * <ul>
     * <li>Prepara un jugador máquina con flota determinista.</li>
     * <li>Prepara otro jugador máquina con flota determinista.</li>
     * </ul>
     *
     * @throws PositionException si hay alguna posición incorrecta
     *
     */
    public void preparaPartidaMaquinaDetVsMaquinaDet()
            throws PositionException {
        this.preparaJugadorMaquinaFlotaDet();
        this.preparaJugadorMaquinaFlotaDet();
    }

    /**
     * Prepara una partida entre un jugador humano con flota determinista y un
     * jugador máquina con flota determinista; ver detalles en especificación
     * larga.
     *
     * <ul>
     * <li>Prepara un jugador humano con flota determinista.</li>
     * <li>Prepara un jugador máquina con flota determinista.</li>
     * </ul>
     *
     * @param nombreJugador el nombre del jugador humano
     *
     * @throws PositionException si hay alguna posición incorrecta
     *
     */
    public void preparaPartidaJHumanoDetVsMaquinaDet(String nombreJugador)
            throws PositionException {
        this.preparaJugadorHumanoFlotaDet(nombreJugador);
        this.preparaJugadorMaquinaFlotaDet();
    }

    /**
     * Prepara una partida entre un jugador humano con flota leida de un archivo
     * y un jugador máquina con flota aleatoria; ver detalles en especificación
     * larga.
     *
     * <ol>
     * <li>Prepara un jugador humano con flota leida de un archivo</li>
     * <li>Prepara un jugador máquina con flota aleatoria</li>
     * <li>Añade el jugador humano a la lista jugadores</li>
     * </ol>
     *
     *
     * @param nombreJugador el nombre del jugador humano
     *
     * @param pathFicheroFlota el path del archivo con los detalles de la flota
     * del jugador humano
     *
     * @throws PositionException si hay alguna posición incorrecta
     *
     * @throws IOException si se produce un error en la apertura o lectura del
     * archivo
     *
     * @throws ArchivoFlotaException si el archivo contiene algún error en sus
     * contenidos
     *
     */
    public void preparaPartidaHumanoFichVsMaquinaAl(String nombreJugador,
            String pathFicheroFlota) throws PositionException,
            IOException, ArchivoFlotaException {
        this.preparaJugadorHumanoFlotaFichero(nombreJugador, pathFicheroFlota);
        this.preparaJugadorMaquinaFlotaAl();

    }

    /**
     * Pregunta disparo a usuario (jugador humano); ver detalles en descripción
     * larga.
     *
     * Pregunta disparo a usuario. Mientras éste le conteste con un disparo que
     * ya ha realizado antes (puede averiguarse utilizando el visor de disparos
     * del usuario), el método volverá a preguntar. Cuando el usuario le
     * conteste con un disparo que no haya realizado antes, retornará un string
     * representando la posición de disparo
     *
     * @return un string que representa la posición atacada por el disparo; el
     * usuario no debe haber realizado este disparo antes.
     *
     */
    public String preguntaDisparoAHumano() {
        boolean posicionAtacadaAntes = true;
        String posAtacada = "";
        while (posicionAtacadaAntes) {
            posAtacada = this.iu.preguntaPorDisparo();
            posicionAtacadaAntes = this.atacante.hasDisparadoAquiAntes(posAtacada);
        }
        return posAtacada;
    }

    /**
     * Ordena disparar al atacante; ver detalles en especificación larga.
     *
     * <ol>
     * <li>El atacante dispara</li>
     * <li>Si el resultado de la orden anterior es "ASK_USER", preguntar por el
     * disparo al usuario y retornar la posición entrada por éste</li>
     * <li>Sino devolver la posición que ha devuelto dispara en el paso 1</li>
     * </ol>
     *
     * @return la posición de disparo
     *
     */
    public String atacanteDispara() {
        String posAtacada = this.atacante.dispara();
        if (posAtacada.toUpperCase().equals("ASK_USER")) {
            posAtacada = this.preguntaDisparoAHumano();
        }
        return posAtacada;
    }

    /**
     * Gestiona las acciones para que el atacante procese tocado; ver detalles
     * en especificación larga.
     * <ol>
     * <li>Invocar a procesaTocado del atacante</li>
     * <li>Si el resultado de la orden anterior es "ASK_USER", preguntar por el
     * disparo al usuario y retornar la posición entrada por éste</li>
     * <li>Sino devolver la posición que ha devuelto procesaTocado del paso
     * 1</li>
     * </ol>
     *
     * @param posAtacada la posición a la que se ha disparado
     *
     * @return la posición a la que el atacante dispara al acabar de procesar
     * tocado
     *
     * @throws PositionException si alguna posición es incorrecta
     */
    public String atacanteProcesaTocado(String posAtacada)
            throws PositionException {
        posAtacada = this.atacante.procesaTocado(posAtacada);
        if (posAtacada.toUpperCase().equals("ASK_USER")) {
            posAtacada = this.preguntaDisparoAHumano();
        }
        return posAtacada;
    }

    /**
     * Gestiona las acciones para que el atacante procese hundido; ver detalles
     * en especificación larga.
     *
     * <ol>
     * <li>Invocar a procesa_hundido del atacante</li>
     * <li>Si el resultado de la orden anterior es "ASK_USER", preguntar por el
     * disparo al usuario y retornar la posición entrada por éste</li>
     * <li>Sino devolver la posición que ha devuelto procesa_hundido en el
     * primer paso</li>
     * </ol>
     *
     * @param posAtacada la posición a la que se ha disparado
     *
     * @return la posición a la que el atacante dispara después de haber
     * procesado hundido
     *
     */
    public String atacanteProcesaHundido(String posAtacada) {
        posAtacada = this.atacante.procesaHundido(posAtacada, Controlador.numBarcosJugadores);
        if (posAtacada.toUpperCase().equals("ASK_USER")) {
            posAtacada = this.preguntaDisparoAHumano();
        }
        return posAtacada;
    }

    /**
     * Muestra los tableros del jugador humano tanto si es el atacante como si
     * es el atacado.
     */
    public void presentaTableros() {
        if (this.atacante.eresHumano()) {
            this.renderer.muestraTablerosHumano((JugadorHumano) this.atacante);
        } else if (this.atacado.eresHumano()) {
            this.renderer.muestraTablerosHumano((JugadorHumano) this.atacado);
        }
    }

    /**
     * Cambia el atacante y el atacado para el siguiente turno.
     *
     * @param iAtacante el índice (0 o 1) de la posición que ocupa el atacante
     * en el atributo jugadores.
     *
     * @return el índice de la posición del jugador atacante en la lista del
     * atributo jugadores
     */
    public int cambiaTurno(int iAtacante) {
        iAtacante = (iAtacante + 1) % 2;
        this.atacante = this.jugadores.get(iAtacante);
        this.atacado = this.jugadores.get((iAtacante + 1) % 2);
        return iAtacante;
    }

    /**
     * Pone un barco del del jugador pasado como argumento, del tipo pasado como
     * argumento, con el nombre pasadocomo argumento, en el tablero de dicho
     * jugador, en la posición y dirección pasadas como argumentos.
     *
     * <ol>
     * <li>Comprueba si las posiciones que ocupará el barco al ponerse sobre el
     * tablero en la dirección dada, son correctas y no contactan con ningún
     * otro barco del tablero</li>
     * <li>Crea el barco del tipo pasado como argumento con el nombre pasado
     * como argumento</li>
     * <li>Hacer que el jugador ponga el barco en la posición y dirección
     * pasadas como argumento sobre su tablero</li>
     * </ol>
     *
     * Debe hacer uso del método Posicion::checkPosicionesCorrectas y
     * Posicion::checkNoContactaConOtro
     *
     * @param jugador el jugador.
     *
     * @param tipoBarco "L" para Lancha, "C" para Crucero, "S" para Submarino,
     * "B" para Buque y "P" para Portaviones.
     *
     * @param nombre el nombre del barco.
     *
     * @param posicionYDireccion array de 2 strings: el primero es la posición
     * ("A6" por ejemplo); el segundo es la dirección ("H" o "V")
     *
     * @throws PositionException si alguna de las posiciones no es correcta o si
     * alguna de las posiciones contacta con algún barco.
     *
     */
    public void ponBarcoJugadorHumano(Jugador jugador, String tipoBarco,
            String nombre, String[] posicionYDireccion) throws PositionException {
        Posicion.checkPosicionesCorrectas(posicionYDireccion,
                Barco.getLongitudDeTipoDeBarco(tipoBarco));
        Posicion.checkNoContactaConOtro(posicionYDireccion[0],
                Barco.getLongitudDeTipoDeBarco(tipoBarco),
                posicionYDireccion[1], jugador.getTablero());
        Barco barco = Barco.creaBarco(tipoBarco, nombre);
        jugador.ponBarco(barco, posicionYDireccion[0], posicionYDireccion[1]);
    }

    /**
     * Pide a iu que presente por pantalla un mensaje que indique los detalles
     * de un disparo que ha hecho agua; ES MUY IMPORTANTE QUE LEÁIS LA
     * ESPECIFICACIÓN LARGA DE ESTE MÉTODO.
     *
     * <ol>
     * <li>Pide a iu que presente por pantalla un mensaje con los detalles de un
     * disparo que ha hecho agua</li>
     * <li>Asimismo, añade el anterior mensaje a la lista del atributo estático
 mensajesAConsola (ES MUY IMPORTANTE HACER ESTO: SI NO, EL CORRECTOR NO
 FUNCIONARÁ CORRECTAMENTE)</li>
     * <li>PARA QUE EL CORRECTOR FUNCIONE CORRECTAMENTE ES IMPRESCINDIBLE QUE EL
     * MENSAJE CONTENGA LA SIGUIENTE INFORMACIÓN:
     * <ul>
     * <li>El NOMBRE del jugador que ha realizado el disparo</li>
     * <li>La POSICIÓN a la que se ha disparado</li>
     * <li>a palabra "agua"</li>
     * </ul>
     * </li>
     * </ol>
     *
     * @param posAtacada la posición a la que se ha disparado
     *
     */
    public void presentaMensajeAgua(String posAtacada) {
        String msg = "\n-->" + this.atacante.getNombre() + " ha disparado a '"
                + posAtacada + "', con resultado de agua";
        Controlador.mensajesAConsola.add(msg);
        this.iu.println(msg);
    }

    /**
     * Pide a iu que presente por pantalla un mensaje que indique los detalles
     * de un disparo que ha tocado un barco del contrario; ES MUY IMPORTANTE QUE
     * LEÁIS LA ESPECIFICACIÓN LARGA DE ESTE MÉTODO.
     *
     * <ol>
     * <li>Pide a iu que presente por pantalla un mensaje con los detalles de un
     * disparo que ha tocado un barco del contrario</li>
     * <li>Asimismo, añade el anterior mensaje a la lista del atributo estático
 mensajesAConsola (ES MUY IMPORTANTE HACER ESTO: SI NO, EL CORRECTOR NO
 FUNCIONARÁ CORRECTAMENTE); PARA QUE EL CORRECTOR FUNCIONE CORRECTAMENTE
 ES IMPRESCINDIBLE QUE EL MENSAJE CONTENGA LA SIGUIENTE INFORMACIÓN:
 <ul>
     * <li>El NOMBRE del jugador que ha realizado el disparo</li>
     * <li>La POSICIÓN a la que se ha disparado</li>
     * <li>La palabra "tocado"</li>
     * </ul></li>
     * </ol>
     * Tened en cuenta que los mensajes van dirigidos al usuario, por tanto,
     * sería deseable que cuando el atacante es el usuario humano, el mensaje
     * contenga algo como "ENHORABUENA" y "has tocado", mientras que si el
     * atacante es la máquina, en el mensaje aparezcan cosas como "te han
     * tocado"
     *
     * @param posAtacada la posición a la que se ha disparado
     *
     */
    public void presentaMensajeTocado(String posAtacada) {
        String parte1 = "\n-->" + this.atacante.getNombre() + " ha disparado a '"
                + posAtacada + "'";
        String parte2;
        if (this.atacante.eresHumano()) {
            parte2 = "</li>¡Enhorabuena! ¡Has tocado un barco en la posición "
                    + posAtacada + "!";
        } else {
            parte2 = "</li>¡Han tocado a uno de tus barcos en la posición "
                    + posAtacada + ", " + this.atacado.getNombre() + "!";
        }
        Controlador.mensajesAConsola.add(parte1 + parte2);
        this.iu.println(parte1 + parte2);
    }

    /**
     * Pide a iu que presente por pantalla un mensaje que indique los detalles
     * de un disparo que ha HUNDIDO un barco del contrario; ES MUY IMPORTANTE
     * QUE LEÁIS LA ESPECIFICACIÓN LARGA DE ESTE MÉTODO.
     *
     * <ol>
     * <li>Pide a iu que presente por pantalla un mensaje con los detalles de un
     * disparo que ha hundido un barco del contrario</li>
     * <li>Asimismo, añade el anterior mensaje a la lista del atributo estático
 mensajesAConsola (ES MUY IMPORTANTE HACER ESTO: SI NO, EL CORRECTOR NO
 FUNCIONARÁ CORRECTAMENTE); PARA QUE EL CORRECTOR FUNCIONE CORRECTAMENTE
 ES IMPRESCINDIBLE QUE EL MENSAJE CONTENGA LA SIGUIENTE INFORMACIÓN:
 <ul>
     * <li>El NOMBRE del jugador que ha realizado el disparo</li>
     * <li>La POSICIÓN a la que se ha disparado</li>
     * <li>La palabra "hundido"</li>
     * <li>El número de barcos que quien ha disparado ha hundido con éste</li>
     * <li>Si el número de barcos hundidos es 9:
     * <ul>
     * <li>Si el atacante es el usuario, debe aparecer la palabra "GANADO" (ES
     * IMPORTANTE QUE APAREZCA EN MAYÚSCULAS)</li>
     * <li>Si el atacante es la máquina, debe aparecer la palabra "PERDIDO" (ES
     * IMPORTANTE QUE APAREZCA EN MAYÚSCULAS), ya que los mensajes de consola
     * van dirigidos al usuario humano</li>
     * </ul></li>
     * </ul></li>
     * </ol>
     * Tened en cuenta que los mensajes van dirigidos al usuario, por tanto,
     * sería deseable que cuando el atacante es el usuario humano, el mensaje
     * contenga algo como "ENHORABUENA" y "has tocado", mientras que si el
     * atacante es la máquina, en el mensaje aparezcan cosas como "te han
     * tocado"
     *
     * @param posAtacada la posición a la que se ha disparado
     *
     * @param numBarcosHundidos el número de barcos hundidos por el atacante a
     * su contrincante
     *
     */
    public void presentaMensajeHundido(String posAtacada, int numBarcosHundidos) {
        String parte1 = "\n-->" + this.atacante.getNombre()
                + " ha disparado a '" + posAtacada + "'";
        String parte2 = "";
        if (this.atacante.eresHumano()) {
            parte2 = "\n¡¡¡Enhorabuena " + this.atacante.getNombre()
                    + "!!! ¡¡¡Has hundido un barco!!!. Con este hacen "
                    + numBarcosHundidos;
            if (numBarcosHundidos == Controlador.numBarcosJugadores) {
                parte2 += ". Por cierto...¡¡¡¡has GANADO la partida!!!!";
            }
        } else {
            parte2 = "\n¡¡¡Te han hundido un barco, " + this.atacado.getNombre()
                    + "!!!. Con este hacen " + numBarcosHundidos;
            if (numBarcosHundidos == Controlador.numBarcosJugadores) {
                parte2 += ". Por cierto...has PERDIDO la partida :-(";
            }
        }
        Controlador.mensajesAConsola.add(parte1 + parte2);
        this.iu.println(parte1 + parte2);
    }

    /**
     * Juega partida; VER DETALLES EN ESPECIFICACIÓN LARGA.
     *
     * <ol>
     * <li>Elige aleatoriamente un número entre 0 y 1</li>
     * <li>Selecciona como atacante el jugador que ocupe la posición elegida en
     * el paso anterior, y como atacado al otro</li>
     * <li>Inicializa fin a False</li>
     * <li>Ordena disparar al atacante y guardar la posicion atacada</li>
     * <li>Mientras no fin:
     * <ol>
     * <li>Obtiene el resultado de dónde ha dado el disparo en el atacado</li>
     * <li>Ordena que el atacante anote el disparo propio y que el atacado anote
     * el disparo ajeno</li>
     * <li>Si el resultado es agua:
     * <ol>
     * <li>Presentar tableros por la gui y presentar mensaje mostrando el nombre
     * de quien disparó, la posición a la que disparó y el resultado del
     * disparo.</li>
     * <li>Cambiar el turno del atacante (el índice del jugador atacante debe
     * guardarse en iAtacante).</li>
     * <li>Ordenar al atacante disparar y guardar la posición de disparo en
     * posAtacada.</li>
     * <li>Notificar tocado a los observadores con la instrucción
     * this.notificaAguaAObservadores() [USADO POR CORRECTOR AUTOMÁTICO]
     * </ol>
     * </li>
     * <li>Si el resultado es tocado:
     * <ol>
     * <li>Presentar tableros por la gui y presentar mensaje mostrando el nombre
     * de quien disparó, la posición a la que disparó y el resultado del
     * disparo.</li>
     * <li>Guardar en posicion atacada el resultado de ordenar al atacante
     * procesar tocado.</li>
     * <li>Notificar agua a los observadores con la instrucción
     * this.notificaTocadoAObservadores() [USADO POR CORRECTOR AUTOMÁTICO]
     * </ol>
     * </li>
     * <li>Si el resultado es hundido:
     * <ol>
     * <li>Presentar tableros por la gui y presentar mensaje mostrando el nombre
     * de quien disparó, la posición a la que disparó y el resultado del
     * disparo.</li>
     * <li>Si el número de barcos hundidos es igual al número total de barcos
     * del atacado, presentar mensaje de final y hacer fin=true.</li>
     * <li>En caso contrario ordenar guardar en posición atacada el resultado de
     * ordenar al atacante procesar hundido.</li>
     * <li>Notificar hundido a los observadores con la instrucción
     * this.notificaHundidoAObservadores() [USADO POR CORRECTOR AUTOMÁTICO]
     * </ol>
     * </li>
     * </ol></li>
     * </ol>
     *
     * @throws PositionException si hay alguna posición incorrecta
     */
    public void juegaPartida() throws PositionException {
        int iAtacante = this.random.nextInt(2);
        this.atacante = this.jugadores.get(iAtacante);
        this.atacado = this.jugadores.get((iAtacante + 1) % 2);
        boolean fin = false;
        String posAtacada = this.atacanteDispara();
        while (!fin) {
            String resultado = this.atacado.dondeHanDado(posAtacada);
            this.atacante.anotaDisparoPropio(posAtacada, resultado);
            this.atacado.anotaDisparoAjeno(posAtacada, resultado);
            this.presentaTableros();
            if (resultado.equals(Jugador.AGUA)) {
                this.presentaMensajeAgua(posAtacada);
                iAtacante = this.cambiaTurno(iAtacante);
                posAtacada = this.atacanteDispara();
                this.notificaAguaAObservadores();
            } else if (resultado.equals(Jugador.TOCADO)) {
                this.presentaMensajeTocado(posAtacada);
                posAtacada = this.atacanteProcesaTocado(posAtacada);
                this.notificaTocadoAObservadores();
            } else {
                int numBarcosHundidos = this.atacante.getNumBarcosHundidos() + 1;
                this.presentaMensajeHundido(posAtacada, numBarcosHundidos);
                if (numBarcosHundidos == Controlador.numBarcosJugadores) {
                    fin = true;
                } else {
                    posAtacada = this.atacanteProcesaHundido(posAtacada);
                }
                this.notificaHundidoAObservadores();
            }
        }
    }
    
    //
    //
    //
    /* ****************************************************************
    MUY IMPORTANTE: NO TOCAR EL CÓDIGO QUE SIRVE. ES UTILIZADO POR EL 
    CORRECTOR AUTOMÁTICO TAL CUAL ESTÁ. SI SE TOCA, DICHO CORRECTOR NO 
    FUNCIONARÁ CORRECTAMENTE.
    ********************************************************************
     */

    private List<ObservadorObservado> observadores;

    private static List<String> mensajesAConsola = new ArrayList<>();

    public static List<String> getMensajesAConsola(){
        return Controlador.mensajesAConsola;
    }
    
    public void addObservador(ObservadorObservado observador) {
        this.observadores.add(observador);
    }

    public void notificaAguaAObservadores() {
        for (ObservadorObservado observador : this.observadores) {
            observador.notificaAgua(this);
        }
    }

    public void notificaTocadoAObservadores() {
        for (ObservadorObservado observador : this.observadores) {
            observador.notificaTocado(this);
        }
    }

    public void notificaHundidoAObservadores() {
        for (ObservadorObservado observador : this.observadores) {
            observador.notificaHundido(this);
        }
    }
    
}

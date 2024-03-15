/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class Posicion {

    /**
     * String constante que indica dirección horizontal
     */
    public static final String HORIZONTAL = "H";

    /**
     * String constante que indica dirección vertical
     */
    public static final String VERTICAL = "V";

    /**
     * Constante que indica el número de filas del tablero
     */
    public static final int NUM_FILAS = 10;

    /**
     * Constante que indica el número de columnas del tablero
     */
    public static final int NUM_COLUMNAS = 10;

    /**
     * Entero asociado al carácter 'A'
     */
    public static final int ORD_A = "A".codePointAt(0);

    /**
     * Entero asociado al carácter 'J'
     */
    public static final int ORD_J = "J".codePointAt(0);

    /**
     * Deltas correspondientes a los puntos cardinales en desplazamientos de
     * fila y columna; NORTE:{-1,0}, ESTE:{0,1}, SUR:{1,0}, OESTE:{0,-1}
     */
    private static final int[][] DELTA_PUNTOS_CARDINALES = {
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };

    /**
     * Devuelve el número de fila correspondiente a esa posición: si el primer
     * caracter es 'A' devuelve 1, si es 'B' devuelve 2 y así sucesivamente.
     *
     * @param posicion la posición del tablero. Ejemplos: "A9", "F8", etc
     * @return devuelve el entero que identifica el número de fila que
     * corresponde a esa posición
     */
    public static int filaCharToInt(String posicion) {
        return posicion.substring(0, 1).codePointAt(0) - Posicion.ORD_A + 1;
    }

    /**
     * Devuelve un String de un solo caracter: el identificador de la fila: si
     * se pasa 1 devuelve "A", si se pasa 2 devuelve "B" y así sucesivamente
     *
     * @param intFila el número de fila
     * @return un String de un solo caracter: el carácter que identifica la fila
     * en un string posición.
     */
    public static String filaIntToFilaChar(int intFila) {
        int codePoint = Posicion.ORD_A + intFila - 1;
        return "" + Character.toChars(codePoint)[0];
    }

    /**
     * Comprueba si el string pasado como argumento se corresponde con una
     * posición correcta del tablero.
     *
     * Comprueba que el primer caracter está en el intervalo cerrado (incluye
     * los extremos) ['A','J'] y que el resto del string es la representación
     * textual de un número en el intervalo cerrado [1,10].
     *
     * @param posStr un string representando una posición del tablero ("A10",
     * por ejemplo).
     *
     * @return true si el primer caracter de pos está en el intervalo cerrado
     * (incluye los extremos) ['A','J'] y el resto del string es la
     * representación textual de un número en el intervalo cerrado [1,10]; false
     * en caso contrario.
     */
    public static boolean esCorrecta(String posStr) {
        int fila = Posicion.filaCharToInt(posStr);
        int col = Integer.parseInt(posStr.substring(1));
        
        if (fila < 1 || fila > Posicion.NUM_FILAS)
            return false;
        else if (col < 1 || col > Posicion.NUM_COLUMNAS)
            return false;        
        else return true;
    }

    /**
     * Dada una posición inicial, un incremento de fila deltaFila y un
     * incremento de columna deltaCol, devuelve la posición que está a deltaFila
     * filas y a deltaCol columnas de la posición inicial.
     *
     *
     * Dada una posición inicial, un incremento de fila delta_f y un número de
     * columna delta_c, devuelve la posición que está a delta_f filas y a
     * delta_c columnas de la posición inicial. Si delta_f es negativo, la fila
     * de la posición devuelta estará por encima de la fila de la posición
     * inicial. Si delta_c es negativo, la columna de la posición devuelta,
     * estará a la izquierda de la columna de la posición inicial.
     *
     * @param posicion un string que contiene la posición inicial
     * @param deltaFila un entero que indica el incremento de fila
     * @param deltaCol un entero que indica el incremento de columna
     *
     * @return un string que indica la posición (fila de posición inicial +
     * deltaFila, columna de posición inicial + deldeltaColta_c). Por ejemplo,
     * si la posición inicial es "C5", deltaFila es -1 y deltaCol es +2, la
     * posición a devolver sería "B7"
     *
     * @throws PositionException si el argumento "posicion" no indica una
     * posición correcta, o si la posición resultante de aplicar los cálculos de
     * deltaFila y deltaCol a la posición indicada por el argumento "posicion",
     * no es una posición correcta
     */
    public static String avanzaCasillas(String posicion,
            int deltaFila, int deltaCol) throws PositionException {
        
        String filas = Posicion.filaIntToFilaChar(Posicion.filaCharToInt(posicion)+deltaFila);
        String columnas = String.valueOf(Integer.parseInt(posicion.substring(1))+deltaCol);
        String pos = filas+columnas;
        if(!esCorrecta(pos)) throw new PositionException("La posicion " +
                pos+" es incorrecta");
        return pos;
    }
    /**
     * Dada una posición inicial, una dirección y un número de casillas
     * numCasillas, determina si la casilla inicial y las numCasillas-1 que
     * están a su derecha (si la dirección es "H"),o por debajo de ella (si la
     * dirección es "V"), son realmente posiciones correctas del tablero.
     *
     * Si todas las posiciones son correctas, el método acaba silenciosamente
     * sin devolver ningún valor. En caso contrario, lanza una excepción
     * indicando que alguna de ellas es incorrecta. Debe utilizar los métodos
     * Posicion.es_correcta y Posicion::avanzaCasillas.
     *
     * @param posicionDireccion un array de dos Strings: el primero contiene la
     * posición inicial; el segundo es la dirección ("H" para dirección
     * horizontal, "V" para dirección vertical).
     *
     * @param numCasillas el número de casillas total (la de la posición inicial
     * más las numCasillas-1 de otras posiciones).
     *
     * @throws PositionException si alguna de las posiciones no es correcta; el
     * argumento del constructor del objeto PositionException indica la posición
     * que no es correcta.
     */
    public static void checkPosicionesCorrectas(String[] posicionDireccion,
            int numCasillas) throws PositionException {
        
        String pos = posicionDireccion[0];
        if(!Posicion.esCorrecta(pos)) throw new PositionException("La posicion"
                + pos +"es incorrecta");
        for(int i=1; i<numCasillas; i++){
            if(posicionDireccion[1].equals("H"))
                pos=avanzaCasillas(posicionDireccion[0], 0, i);  
            if(posicionDireccion[1].equals("V"))
                pos=avanzaCasillas(posicionDireccion[0], i, 0);
            if(!Posicion.esCorrecta(pos)) throw new PositionException("La posicion"
                + pos +"es incorrecta");
        }
        
    }

    /**
     * Devuelve una lista con las casillas que están al norte, al este, al sur y
     * al oeste de la casilla cuya posición se pasa como argumento.
     *
     * Devuelve una lista con las casillas que están al norte, al este, al sur y
     * al oeste de la casilla cuya posición se pasa como argumento. Si alguna de
     * estas casillas no existen (porque la casilla cuya posición se pasa como
     * argumento está en un borde o en una esquina del tablero), no se añaden a
     * la lista resultante.
     *
     * Debe utilizar los métodos Posicion::esCorrecta y
     * Posicion::avanzaCasillas.
     *
     * @param posicion un string que contiene la posición
     *
     * @return una lista con las casillas que están al norte, este, sur y oeste
     * de la casilla cuya posición se pasa como argumento, siempre que dichas
     * casillas estén dentro del tablero
     *
     * @throws PositionException si la posición pasada o alguna de las
     * calculadas para añadir a la lista resultado NO es correcta
     */
    public static List<String> getPuntosCardinales(String posicion)
            throws PositionException {
        
        List<String> lista = new ArrayList();
        if(!Posicion.esCorrecta(posicion)) throw new PositionException("La posicion "
                + posicion +" es incorrecta");
        
        for(int i=0; i<4; i++){
            int j=0;
            try{
                String pos=Posicion.avanzaCasillas(posicion, DELTA_PUNTOS_CARDINALES[i][j], DELTA_PUNTOS_CARDINALES[i][j+1]);
                lista.add(pos); 
            }
            catch(PositionException ex){}             
        }    
        
        return lista;
    }

    /**
     * Devuelve una lista con las casillas que están al norte y al sur de la
     * casilla cuya posición se pasa como argumento.
     *
     * Devuelve una lista con las casillas que están al norte y al sur de la
     * casilla cuya posición se pasa como argumento. Si alguna de estas casillas
     * no existen (porque la casilla cuya posición se pasa como argumento está
     * en un borde o en una esquina del tablero), no se añaden a la lista
     * resultante.
     *
     * Debe utilizar los métodos Posicion::esCorrecta y
     * Posicion::avanzaCasillas.
     *
     * @param posicion un string que contiene la posición
     *
     * @return una lista con las casillas que están al norte y al sur de la
     * casilla cuya posición se pasa como argumento, siempre que dichas casillas
     * estén dentro del tablero
     *
     * @throws PositionException si la posición pasada o alguna de las
     * calculadas para añadir a la lista resultado NO es correcta
     */
    public static Set<String> getNorteSur(String posicion)
            throws PositionException {
        
        Set<String> lista = new HashSet();
        if(!Posicion.esCorrecta(posicion)) throw new PositionException("La posicion "
                + posicion +" es incorrecta");
        
        
        for(int i=0; i<=2; i=i+2){
            int j=0;
            try{
                String pos=Posicion.avanzaCasillas(posicion, DELTA_PUNTOS_CARDINALES[i][j], DELTA_PUNTOS_CARDINALES[i][j+1]);
                lista.add(pos); 
            }
            catch(PositionException ex){}             
        } 
        
        return lista;
    }

    /**
     * Devuelve una lista con las casillas que están al este y al oeste de la
     * casilla cuya posición se pasa como argumento.
     *
     * Devuelve una lista con las casillas que están al este y al oeste de la
     * casilla cuya posición se pasa como argumento. Si alguna de estas casillas
     * no existen (porque la casilla cuya posición se pasa como argumento está
     * en un borde o en una esquina del tablero), no se añaden a la lista
     * resultante.
     *
     * Debe utilizar los métodos Posicion::esCorrecta y
     * Posicion::avanzaCasillas.
     *
     * @param posicion un string que contiene la posición
     *
     * @return una lista con las casillas que están al este y al oeste de la
     * casilla cuya posición se pasa como argumento, siempre que dichas casillas
     * estén dentro del tablero
     *
     * @throws PositionException si la posición pasada o alguna de las
     * calculadas para añadir a la lista resultado NO es correcta
     */
    public static Set<String> getEsteOeste(String posicion)
            throws PositionException {
        
        Set<String> lista = new HashSet();
        if(!Posicion.esCorrecta(posicion)) throw new PositionException("La posicion "
                + posicion +" es incorrecta");
        
        for(int i=1; i<=3; i=i+2){
            int j=0;
            try{
                String pos=Posicion.avanzaCasillas(posicion, DELTA_PUNTOS_CARDINALES[i][j], DELTA_PUNTOS_CARDINALES[i][j+1]);
                lista.add(pos); 
            }
            catch(PositionException ex){}             
        }

        return lista;     
    }

    /**
     * Devuelve una lista con las casillas adyacentes a la casilla cuya posición
     * se pasa como argumento.
     *
     * Devuelve una lista con las casillas adyacentes a la casilla cuya posición
     * se pasa como argumento. Si alguna de estas casillas no existen (porque la
     * casilla cuya posición se pasa como argumento está en un borde o en una
     * esquina del tablero), no se añaden a la lista resultante.
     *
     * Debe utilizar los métodos Posicion::esCorrecta y
     * Posicion::avanzaCasillas.
     *
     *
     * @param posicion un string que contiene una posición ("A6" por ejemplo)
     *
     * @return una lista con las casillas adyacentes a la casilla cuya posición
     * se pasa como argumento, siempre que dichas casillas estén dentro del
     * tablero
     *
     * @throws PositionException si la posición pasada o alguna de las
     * calculadas para añadir a la lista resultado NO es correcta
     */
    public static Set<String> getAdyacentes(String posicion)
            throws PositionException {
        
        Set<String> lista = new HashSet();
        if(!Posicion.esCorrecta(posicion)) throw new PositionException("La posicion "
                + posicion +" es incorrecta");
        
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                try{
                    String pos=Posicion.avanzaCasillas(posicion, i, j);
                    lista.add(pos);
                    if(i==0 && j==0){
                        lista.remove(pos);
                    } 
                }
                catch(PositionException ex){}
            } 
        }    
        
        return lista;        
    }

    /**
     * Devuelve una lista con todas las posiciones de un tablero de 10x10, esto
     * es, desde "A1" a "J10".
     *
     * @return lista "A1","A2"..."A10"..,"J1","J2",..."J10"
     */
    public static List<String> todasLasCasillas() {
        
        List<String> listacasillas = new ArrayList();
        
        for(char c='A'; c<='J'; c++){
            for(int i=1; i<=10; i++){
                String num = String.valueOf(i);
                String letra = String.valueOf(c);
                String pos = letra+num;
                listacasillas.add(pos);
            }
        }
        return listacasillas;
    }

    /**
     * Dada una posición inicial, un número de casillas lon, una dirección y el
     * tablero con barcos,comprueba si alguna de las casillas del conjunto
     * formado por la casilla en la posición inicial y las casillas que están en
     * las lon-1 posiciones siguientes en la dirección indicada, NO contactan
     * con ningún barco previamente colocado en el tablero.
     *
     * Dada una posición inicial, un número de casillas lon, una dirección y y
     * el tablero con barcos, comprueba si alguna de las casillas del conjunto
     * formado por la casilla en la posición inicial y las casillas que están en
     * las lon-1 posiciones en la dirección indicada, NO contactan con ningún
     * barco previamente colocado en el tablero. Si ninguna de ellas contacta
     * con algún barco, el método acaba su ejecución silenciosamente; en caso
     * contrario, lanza una excepción.
     *
     * @param posicion string que contiene la posición inicial;
     *
     * @param direccion string que contiene la dirección ("H" para dirección
     * horizontal, "V" para dirección vertical).
     *
     * @param lon el número de casillas total (la de la posición inicial más las
     * lon-1 de otras posiciones).
     *
     * @param tablero el tablero con barcos colocados en él
     *
     * @throws PositionException si alguna de las posiciones es contigua a una
     * posición de algún barco.
     */
    public static void checkNoContactaConOtro(String posicion, int lon,
            String direccion, Tablero tablero) throws PositionException {       
        
        //comprobacion de que las posiciones son posiciones correctas del tablero
        String[] posdir = {posicion, direccion};
        try{
            Posicion.checkPosicionesCorrectas(posdir, lon);
        } catch(PositionException exe){
            System.out.println("Posicion incorrecta");
        }
        
        int filaInicial = Posicion.filaCharToInt(posicion);                    //letra de posicion        
        int columnaInicial = Integer.parseInt(posicion.substring(1));   //numero de posicion        
        
        Map<String, Barco> casillas = tablero.getCasillas();    //mapa de las casillas donde hay barcos
        List<String> posiciones = new LinkedList<>();           //posiciones (correctas del tablero) que queremos comprobar
        
        if(direccion.equals("H")){    
            //agregamos posiciones a comprobar a la lista
            for(int i=-1; i<=1; i++){
                for(int j=-1; j<=lon; j++){
                    String fila = Posicion.filaIntToFilaChar(filaInicial+i);
                    String columna = String.valueOf(columnaInicial+j);
                    if(Posicion.esCorrecta(fila+columna))
                        posiciones.add(fila+columna);
                }
            }
        }
        else{
            //agregamos posiciones a comprobar a la lista
            for(int i=-1; i<=lon; i++){
                for(int j=-1; j<=1; j++){
                    String fila = Posicion.filaIntToFilaChar(filaInicial+i);
                    String columna = String.valueOf(columnaInicial+j);
                    if(Posicion.esCorrecta(fila+columna))
                        posiciones.add(fila+columna);
                }
            }
        }
               
        //buscamos si en las posiciones de la lista hay algun barco
        for(int i=0; i<posiciones.size(); i++){
            if(casillas.containsKey(posiciones.get(i)))
                throw new PositionException("Alguna de las posiciones contacta con un barco");
        }
    }
}

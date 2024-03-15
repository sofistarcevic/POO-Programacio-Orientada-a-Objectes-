/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class JugadorMaquinaTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    private Tablero mockTablero;

    public JugadorMaquinaTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        JugadorMaquinaTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "JugadorMaquinaTest");
        nota.put("JugadorMaquinaTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 0.75;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 14;
        this.printlnAlways("\nComprobando JugadorMaquina::JugadorMaquina(..). Valor: " + valorTotal);
        try {
            JugadorMaquina jugRef = new JugadorMaquina();
            Optional<Object> optNumInst = this.getPrivateFieldValue(jugRef, "numInstances");
            if(!optNumInst.isPresent()){
                this.finishIfAttrNotPresent("jugador máquina", "JugadorMaquina.numInstances", puntosAntes);
                return;
            }
            int numInstances = (int)optNumInst.get();
            JugadorMaquina jugador = new JugadorMaquina();
            this.printlnAlways("\tComprobando que existe atributo "
                    + "'numInstances' y vale " + (numInstances+1));
            error = this.checkFieldValue(jugador, "numInstances", (numInstances+1), valorTotal / numTests, null);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'noDisparadas'.");
            error = this.checkPrivateFieldExists(jugador, "noDisparadas",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tComprobando que cuando el atributo "
                    + "'noDisparadas' tiene como valor la lista de todas las "
                    + "casillas del tablero.");
            List<String> casillas = Posicion.todasLasCasillas();
            Set<String> expected = new HashSet<>();
            Optional<Object> optNoDisparadas = this.getPrivateFieldValue(jugador, "noDisparadas");
            if (!optNoDisparadas.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "noDisparadas", puntosAntes);
                return;
            }
            List<String> noDisparadas = (List<String>) optNoDisparadas.get();
            Set<String> difference = new HashSet<>(Posicion.todasLasCasillas());
            difference.removeAll(new HashSet<>(noDisparadas));
            error = this.sAssertEquals(expected,
                    difference, valorTotal / numTests, "Error. La lista "
                    + "del atributo 'noDisparadas' NO es la que debe. "
                    + "Faltan los siguientes elementos: " + difference);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'tocadas'.");
            error = this.checkPrivateFieldExists(jugador, "tocadas",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //            
            this.printlnAlways("\tComprobando el atributo 'tocadas' es una lista vacía.");
            Optional<Object> optTocadas = this.getPrivateFieldValue(jugador, "tocadas");
            if (!optTocadas.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tocadas", puntosAntes);
                return;
            }
            List<String> tocadas = (List<String>) optTocadas.get();
            error = this.sAssertTrue(tocadas.isEmpty(),
                    valorTotal / numTests, "Error. La lista del atributo "
                    + "'tocadas' NO es la que debe. Debería estar vacía pero "
                    + "contiene los siguientes elementos: " + tocadas);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'proximosDisparos'.");
            error = this.checkPrivateFieldExists(jugador, "proximosDisparos",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando el atributo 'proximosDisparos' "
                    + "es una lista vacía.");
            Optional<Object> optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
            if (!optPDisparos.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
                return;
            }
            List<String> pDisparos = (List<String>) optPDisparos.get();
            error = this.sAssertTrue(pDisparos.isEmpty(), valorTotal / numTests,
                    "La lista del atributo 'proximosDisparos' NO es la que "
                    + "debe. Debería estar vacía pero contiene los "
                    + "siguientes elementos: " + pDisparos);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'dirBarcoTocado'.");
            error = this.checkPrivateFieldExists(jugador, "dirBarcoTocado",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tComprobando el atributo 'dirBarcoTocado' toma "
                    + "el valor null.");
            error = this.checkThatFieldValueIsNull(jugador, "dirBarcoTocado",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'nombre'.");
            error = this.checkPrivateFieldExists(jugador, "nombre",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            String expName = "Maquina-" + (numInstances+1);
            this.printlnAlways("\tComprobando el atributo 'nombre' toma el "
                    + "valor '" + expName +"'");
            error = this.checkFieldValue(jugador, "nombre", expName,
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'myRandom'.");
            error = this.checkPrivateFieldExists(jugador, "myRandom",
                    valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el atributo 'myRandom' es de "
                    + "clase Random.");

            error = this.checkPrivateFieldIsOfASpecificClass(jugador, "myRandom",
                    Random.class, valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el atributo 'myRandom' toma "
                    + "un valor distinto de null.");
            Optional<Object> optMyRandom = this.getPrivateFieldValue(jugador, "myRandom");
            if (!optMyRandom.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "myRandom", puntosAntes);
                return;
            }
            Random myRandom = (Random) optMyRandom.get();
            error = this.sAssertNotNull(myRandom, valorTotal / numTests,
                    "El valor del atributo 'myRandom' NO es el que debe. NO debería "
                    + "ser null, pero lo es");
            toThrow = this.toThrow(error, toThrow);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    @Test
    public void test02_dispara() {
        double valorTotal = 1.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 4;
        this.printlnAlways("\nComprobando JugadorMaquina::dispara(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: si el último disparo tocó un barco, "
                    + "el disparo será a la primera posición de la lista "
                    + "'proximosDisparos'");
            JugadorMaquina jugador = new JugadorMaquina();
            List<String> tocadas = new ArrayList<>();
            tocadas.add("A6");
            List<String> proximosDisparos = new ArrayList<>();
            proximosDisparos.add("A7");
            proximosDisparos.add("A5");
            this.setPrivateField(jugador, "tocadas", tocadas);
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            String disparo = jugador.dispara();
            this.printlnAlways("\t  Comprobar que se dispara a la primera "
                    + "posición de la lista 'proximosDisparos'");
            error = this.sAssertEquals("A7", disparo, valorTotal / (numTests),
                    "Error. No parece que se haya disparado a la primera "
                    + "posición de la lista de 'proximosDisparos'");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Comprobar que esa posición se ha sacado de "
                    + "la lista 'proximosDisparos'");
            List<String> expected = new ArrayList<>();
            expected.add("A5");
            Optional<Object> optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
            if (!optPDisparos.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
                return;
            }
            List<String> pDisparos = (List<String>) optPDisparos.get();
            error = this.sAssertEquals(expected, pDisparos, valorTotal / (numTests),
                    "Error. No parece que se haya extraido la primera posición "
                    + "de la lista de 'proximosDisparos'");
            toThrow = this.toThrow(error, toThrow);
            // 
            this.printlnAlways("\tCaso 2: dispara siendo agua el último disparo "
                    + "realizado: debe seleccionar aleatoriamente una de las "
                    + "posiciones que hay en el atributo 'noDisparadas' ");
            jugador = new JugadorMaquina();
            List<String> noDisparadas = Posicion.todasLasCasillas();
            this.setPrivateField(jugador, "noDisparadas", noDisparadas);
            disparo = jugador.dispara();
            this.printlnAlways("\t  Comprobar que la posición de disparo es una "
                    + "posición del tablero");
            int fila = Posicion.filaCharToInt(disparo);
            int col = -1;
            try {
                col = Integer.parseInt(disparo.substring(1, disparo.length()));
            } catch (NumberFormatException ex) {
                error = this.sAssertTrue(false, 0, "Error. El String retornado "
                        + "por JugadorMaquina::dispara() no es correcto: los "
                        + "dos últimos caracteres no representan un número "
                        + "entero");
                toThrow = this.toThrow(error, toThrow);
                return;
            }
            error = this.sAssertTrue(1 <= fila && fila <= 10 && 1 <= col && col <= 10,
                    valorTotal / (numTests), "Error. No parece que se haya a "
                    + "una posición correcta del tablero (" + disparo + ")");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Comprobar que la posición de disparo se ha "
                    + "sacado de la lista 'noDisparadas'");
            error = this.sAssertEquals(99, noDisparadas.size(),
                    valorTotal / (numTests), "Error. No parece que se haya "
                    + "extraido una posición de la lista de 'noDisparadas'");
            toThrow = this.toThrow(error, toThrow);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    @Test
    public void test03_dejaSoloFilaOColumna() {
        double valorTotal = 1.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 6;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando JugadorMaquina::dejaSoloFilaOColumna(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: Quitar casillas en fila; todas las "
                    + "casillas en columna ya están en proximosDisparos");
            JugadorMaquina jugador = new JugadorMaquina();
            List<String> proximosDisparos = new ArrayList<>();
            proximosDisparos.add("D5");
            proximosDisparos.add("C6");
            proximosDisparos.add("D7");
            proximosDisparos.add("E6");
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            this.setPrivateField(jugador, "dirBarcoTocado", "V");
            jugador.dejaSoloFilaOColumna("D6");
            List<String> expected = new ArrayList<>();
            expected.add("C6");
            expected.add("E6");
            error = this.sAssertEquals(new HashSet(expected), new HashSet(proximosDisparos),
                    valorTotal / numTests, "Error. La lista de próximos disparos "
                    + "debería haber sido " + expected + ", pero es "
                    + proximosDisparos);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: Quitar casillas en fila; ninguna de "
                    + "las casillas en la columna está en proximosDisparos ni en tocadas");
            jugador = new JugadorMaquina();
            proximosDisparos = new ArrayList<>();
            proximosDisparos.add("D5");
            proximosDisparos.add("D7");
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            this.setPrivateField(jugador, "dirBarcoTocado", "V");
            jugador.dejaSoloFilaOColumna("D6");
            expected = new ArrayList<>();
            expected.add("C6");
            expected.add("E6");
            error = this.sAssertEquals(new HashSet(expected), new HashSet(proximosDisparos),
                    valorTotal / numTests, "Error. La lista de próximos disparos "
                    + "debería haber sido " + expected + ", pero es "
                    + proximosDisparos);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 3: Quitar casillas en fila; ninguna de "
                    + "las casillas en columna, pero C6 está en tocadas, por lo "
                    + "que no habrá que añadirlo");
            jugador = new JugadorMaquina();
            proximosDisparos = new ArrayList<>();
            proximosDisparos.add("D5");
            proximosDisparos.add("D7");
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            this.setPrivateField(jugador, "dirBarcoTocado", "V");
            List<String> tocadas = new ArrayList<>();
            tocadas.add("C6");
            this.setPrivateField(jugador, "tocadas", tocadas);
            jugador.dejaSoloFilaOColumna("D6");
            expected.remove("C6");
            error = this.sAssertEquals(new HashSet(expected), new HashSet(proximosDisparos),
                    valorTotal / numTests, "Error. La lista de próximos disparos "
                    + "debería haber sido " + expected + ", pero es "
                    + proximosDisparos);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 4: Quitar casillas en columna; todas "
                    + "las casillas en fila ya están en proximosDisparos y no "
                    + "debe quitarse ninguna");
            jugador = new JugadorMaquina();
            proximosDisparos = new ArrayList<>();
            proximosDisparos.add("D5");
            proximosDisparos.add("C6");
            proximosDisparos.add("D7");
            proximosDisparos.add("E6");
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            this.setPrivateField(jugador, "dirBarcoTocado", "H");
            jugador.dejaSoloFilaOColumna("D6");
            expected = new ArrayList<>();
            expected.add("D5");
            expected.add("D7");
            error = this.sAssertEquals(new HashSet(expected), new HashSet(proximosDisparos),
                    valorTotal / numTests, "Error. La lista de próximos disparos "
                    + "debería haber sido " + expected + ", pero es "
                    + proximosDisparos);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 5: Quitar casillas en columna; ninguna "
                    + "de las casillas en columna están en proximosDisparos ni en tocadas");
            jugador = new JugadorMaquina();
            proximosDisparos = new ArrayList<>();
            proximosDisparos.add("C6");
            proximosDisparos.add("D7");
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            this.setPrivateField(jugador, "dirBarcoTocado", "H");
            jugador.dejaSoloFilaOColumna("D6");
            expected = new ArrayList<>();
            expected.add("D5");
            expected.add("D7");
            error = this.sAssertEquals(new HashSet(expected), new HashSet(proximosDisparos),
                    valorTotal / numTests, "Error. La lista de próximos disparos "
                    + "debería haber sido " + expected + ", pero es "
                    + proximosDisparos);
            toThrow = this.toThrow(error, toThrow);

            //
            this.printlnAlways("\tCaso 6: Quitar casillas en columna; ninguna "
                    + "de las casillas en columna están en proximosDisparos "
                    + "pero D5 está en tocadas, por lo que habrá que quitarla");
            jugador = new JugadorMaquina();
            proximosDisparos = new ArrayList<>();
            proximosDisparos.add("C6");
            proximosDisparos.add("E6");
            this.setPrivateField(jugador, "proximosDisparos", proximosDisparos);
            this.setPrivateField(jugador, "dirBarcoTocado", "H");
            tocadas = new ArrayList<>();
            tocadas.add("D5");
            this.setPrivateField(jugador, "tocadas", tocadas);
            jugador.dejaSoloFilaOColumna("D6");
            expected.remove("D5");
            error = this.sAssertEquals(new HashSet(expected), new HashSet(proximosDisparos),
                    valorTotal / numTests, "Error. La lista de próximos disparos "
                    + "debería haber sido " + expected + ", pero es "
                    + proximosDisparos);
            toThrow = this.toThrow(error, toThrow);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    @Test
    public void test04_procesaHundido() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 10;
        this.printlnAlways("\nComprobando JugadorMaquina::procesaHundido(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: se hunde un barco que NO es el último");
            JugadorMaquina jugador = new JugadorMaquina();
            String disparo = jugador.procesaHundido("A6", 9);
            //
            this.printlnAlways("\t  Comprobar que se incrementa 'numBarcosHundidos' en una unidad");
            Optional<Object> optNBarcosH = this.getPrivateFieldValue(jugador, "numBarcosHundidos");
            if (!optNBarcosH.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "numBarcosHundidos", puntosAntes);
                return;
            }
            Integer nBarcosH = (Integer) optNBarcosH.get();
            error = this.sAssertEquals(1, nBarcosH.intValue(), valorTotal / numTests,
                    "Error. 'numBarcosHundidos'  no se ha incrementado en 1. "
                    + "Debería valer 1, pero vale " + nBarcosH);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobar que 'tocadas' se vacía");
            Optional<Object> optTocadas = this.getPrivateFieldValue(jugador, "tocadas");
            if (!optTocadas.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tocadas", puntosAntes);
                return;
            }
            List<String> tocadas = (List<String>) optTocadas.get();
            error = this.sAssertTrue(tocadas.isEmpty(), valorTotal / numTests,
                    "Error. 'tocadas'  no se ha vaciado. Su contenido es "
                    + tocadas);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobar que 'proximosDisparos' se vacía");
            Optional<Object> optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
            if (!optPDisparos.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
                return;
            }
            List<String> pDisparos = (List<String>) optPDisparos.get();
            error = this.sAssertTrue(pDisparos.isEmpty(), valorTotal / numTests,
                    "Error. 'proximosDisparos'  no se ha vaciado. Su contenido es "
                    + pDisparos);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobar que 'dirBarcoTocado' toma el valor null");
            Optional<Field> optDirBTocadoF = this.getPrivateField(jugador, "dirBarcoTocado");
            if (!optDirBTocadoF.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "dirBarcoTocado", puntosAntes);
                return;
            }
            Field optDirBTocado = optDirBTocadoF.get();
            String dirBarcoTocado = (String) optDirBTocado.get(jugador);
            error = this.sAssertEquals(null, dirBarcoTocado, valorTotal / numTests,
                    "Error. 'dirBarcoTocado' no ha tomado el valor null. Su "
                    + "valor es " + dirBarcoTocado);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobar que retorna una posición de 'noDisparadas'");
            Set<String> todas = new HashSet(Posicion.todasLasCasillas());
            Optional<Object> optNoDisparadas = this.getPrivateFieldValue(jugador, "noDisparadas");
            if (!optNoDisparadas.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "noDisparadas", puntosAntes);
                return;
            }
            Set<String> noDisparadas = new HashSet((List<String>) optNoDisparadas.get());
            Set<String> disparoSet = new HashSet<>();
            disparoSet.add(disparo);
            todas.removeAll(noDisparadas);
            error = this.sAssertEquals(todas, disparoSet,
                    valorTotal / numTests, "Error. El disparo no parece haberse "
                    + "extraido correctamente de 'noDisparadas'");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: Se hunde un barco que ES el último");
            jugador = new JugadorMaquina();
            disparo = jugador.procesaHundido("A6", 1);
            //
            this.printlnAlways("\t  Comprobar que se incrementa 'numBarcosHundidos' en una unidad");
            optNBarcosH = this.getPrivateFieldValue(jugador, "numBarcosHundidos");
            if (!optNBarcosH.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "numBarcosHundidos", puntosAntes);
                return;
            }
            nBarcosH = (Integer) optNBarcosH.get();
            error = this.sAssertEquals(1, nBarcosH.intValue(), valorTotal / numTests,
                    "Error. 'numBarcosHundidos'  no se ha incrementado en 1. "
                    + "Debería valer 1, pero vale " + nBarcosH);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobar que 'tocadas' se vacía");
            optTocadas = this.getPrivateFieldValue(jugador, "tocadas");
            if (!optTocadas.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tocadas", puntosAntes);
                return;
            }
            tocadas = (List<String>) optTocadas.get();
            error = this.sAssertTrue(tocadas.isEmpty(), valorTotal / numTests,
                    "Error. 'tocadas'  no se ha vaciado. Su contenido es "
                    + tocadas);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobar que 'proximosDisparos' se vacía");
            optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
            if (!optPDisparos.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
                return;
            }
            pDisparos = (List<String>) optPDisparos.get();
            error = this.sAssertTrue(pDisparos.isEmpty(), valorTotal / numTests,
                    "Error. 'proximosDisparos'  no se ha vaciado. Su contenido es "
                    + pDisparos);
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Comprobar que 'dirBarcoTocado' toma el valor null");
            optDirBTocadoF = this.getPrivateField(jugador, "dirBarcoTocado");
            if (!optDirBTocadoF.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "dirBarcoTocado", puntosAntes);
                return;
            }
            optDirBTocado = optDirBTocadoF.get();
            dirBarcoTocado = (String) optDirBTocado.get(jugador);
            error = this.sAssertEquals(null, dirBarcoTocado, valorTotal / numTests,
                    "Error. 'dirBarcoTocado' no ha tomado el valor null. Su "
                    + "valor es " + dirBarcoTocado);
            toThrow = this.toThrow(error, toThrow);
            //           
            this.printlnAlways("\t  Comprobar que retorna null");
            error = this.sAssertEquals(disparo, null, valorTotal / numTests,
                    "Error. No ha devuelto null");
            toThrow = this.toThrow(error, toThrow);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    @Test
    public void test05_procesaTocado() {
        double valorTotal = 4.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 56;

        this.printlnAlways("\nComprobando JugadorMaquina::procesaTocado(). Valor: " + valorTotal);
        this.checksDePrimerosDisparos(valorTotal, numTests, puntosAntes);
        this.checksDeSegundosDisparos(valorTotal, numTests, puntosAntes);
        this.checksDeTercerosDisparos(valorTotal, numTests, puntosAntes);
    }

    public void checksDePrimerosDisparos(double valorTotal, int numTests,
            double puntosAntes) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            //
            this.printlnAlways(" GRUPO 1: Casos de primer disparo tocado");
            this.printlnAlways("  Caso 1: el disparo supone el primer tocado en "
                    + "la esquina izquierda superior");
            List<String> adyacentes = new ArrayList<>();
            adyacentes.add("A2");
            adyacentes.add("B1");
            adyacentes.add("B2");
            List<String> proximosDisparosAntes = new ArrayList<>();
            proximosDisparosAntes.add("A2");
            proximosDisparosAntes.add("B1");
            List<String> tocadas = new ArrayList<>();
            tocadas.add("A1");
            this.checkPrimerDisparo("A1", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //           
            this.printlnAlways("  Caso 2: el disparo supone el primer tocado en "
                    + "la esquina derecha superior");
            adyacentes.clear();
            adyacentes.add("A9");
            adyacentes.add("B9");
            adyacentes.add("B10");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("A9");
            proximosDisparosAntes.add("B10");
            tocadas.clear();
            tocadas.add("A10");
            this.checkPrimerDisparo("A10", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 3: el disparo supone el primer tocado en "
                    + "la esquina izquierda inferior");
            adyacentes.clear();
            adyacentes.add("I1");
            adyacentes.add("I2");
            adyacentes.add("J2");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("I1");
            proximosDisparosAntes.add("J2");
            tocadas.clear();
            tocadas.add("J1");
            this.checkPrimerDisparo("J1", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 4: el disparo supone el primer tocado en "
                    + "la esquina derecha inferior");
            adyacentes.clear();
            adyacentes.add("I9");
            adyacentes.add("I10");
            adyacentes.add("J9");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("J9");
            proximosDisparosAntes.add("I10");
            tocadas.clear();
            tocadas.add("J10");
            this.checkPrimerDisparo("J10", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 5: el disparo supone el primer tocado en "
                    + "la parte superior del tablero");
            adyacentes.clear();
            adyacentes.add("A5");
            adyacentes.add("A7");
            adyacentes.add("B5");
            adyacentes.add("B6");
            adyacentes.add("B7");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("A5");
            proximosDisparosAntes.add("A7");
            proximosDisparosAntes.add("B6");
            tocadas.clear();
            tocadas.add("A6");
            this.checkPrimerDisparo("A6", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 6: el disparo supone el primer tocado en "
                    + "la parte izquierda del tablero");
            adyacentes.clear();
            adyacentes.add("C1");
            adyacentes.add("C2");
            adyacentes.add("D2");
            adyacentes.add("E1");
            adyacentes.add("E2");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("C1");
            proximosDisparosAntes.add("D2");
            proximosDisparosAntes.add("E1");
            tocadas.clear();
            tocadas.add("D1");
            this.checkPrimerDisparo("D1", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 7: el disparo supone el primer tocado en "
                    + "la parte inferior del tablero");
            adyacentes.clear();
            adyacentes.add("J5");
            adyacentes.add("J7");
            adyacentes.add("I5");
            adyacentes.add("I6");
            adyacentes.add("I7");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("J5");
            proximosDisparosAntes.add("J7");
            proximosDisparosAntes.add("I6");
            tocadas.clear();
            tocadas.add("J6");
            this.checkPrimerDisparo("J6", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 8: el disparo supone el primer tocado en "
                    + "la parte derecha del tablero");
            adyacentes.clear();
            adyacentes.add("C9");
            adyacentes.add("C10");
            adyacentes.add("D9");
            adyacentes.add("E9");
            adyacentes.add("E10");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("D9");
            proximosDisparosAntes.add("C10");
            proximosDisparosAntes.add("E10");
            tocadas.clear();
            tocadas.add("D10");
            this.checkPrimerDisparo("D10", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 9: el disparo supone el primer tocado en "
                    + "una posición interior del tablero");
            adyacentes.clear();
            adyacentes.add("C5");
            adyacentes.add("C6");
            adyacentes.add("C7");
            adyacentes.add("D5");
            adyacentes.add("D7");
            adyacentes.add("E5");
            adyacentes.add("E6");
            adyacentes.add("E7");
            proximosDisparosAntes.clear();
            proximosDisparosAntes.add("C6");
            proximosDisparosAntes.add("E6");
            proximosDisparosAntes.add("D7");
            proximosDisparosAntes.add("D5");
            tocadas.clear();
            tocadas.add("D6");
            this.checkPrimerDisparo("D6", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //

        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    protected void checksDeSegundosDisparos(double valorTotal, int numTests,
            double puntosAntes) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            //
            this.printlnAlways(" GRUPO 2: Casos de segundo disparo tocado");
            this.printlnAlways("  Caso 10: el disparo supone el segundo tocado "
                    + "de un barco dispuesto en horizontal");
            List<String> adyacentes = new ArrayList<>();
            adyacentes.add("C5");
            adyacentes.add("C6");
            adyacentes.add("D6");
            adyacentes.add("C7");
            adyacentes.add("D5");
            adyacentes.add("D7");
            adyacentes.add("E5");
            adyacentes.add("E6");
            adyacentes.add("E7");
            adyacentes.add("C4");
            adyacentes.add("D4");
            adyacentes.add("E4");
            List<String> proximosDisparosAntes = new ArrayList<>();
            proximosDisparosAntes.add("D7");
            proximosDisparosAntes.add("D4");
            List<String> tocadas = new ArrayList<>();
            tocadas.add("D6");
            tocadas.add("D5");
            this.checkSegundoDisparo("D6", "D5", adyacentes,
                    proximosDisparosAntes, tocadas, valorTotal, numTests,
                    toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 11: el disparo supone el segundo tocado "
                    + "de un barco dispuesto en vertical");
            adyacentes = new ArrayList<>();
            adyacentes.add("C5");
            adyacentes.add("C6");
            adyacentes.add("C7");
            adyacentes.add("D5");
            adyacentes.add("D6");
            adyacentes.add("D7");
            adyacentes.add("E5");
            adyacentes.add("E6");
            adyacentes.add("E7");
            adyacentes.add("F5");
            adyacentes.add("F6");
            adyacentes.add("F7");
            proximosDisparosAntes = new ArrayList<>();
            proximosDisparosAntes.add("F6");
            proximosDisparosAntes.add("C6");
            tocadas = new ArrayList<>();
            tocadas.add("D6");
            tocadas.add("E6");
            this.checkSegundoDisparo("D6", "E6", adyacentes,
                    proximosDisparosAntes, tocadas, valorTotal, numTests,
                    toThrow, puntosAntes);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    protected void checksDeTercerosDisparos(double valorTotal, int numTests,
            double puntosAntes) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            //
            this.printlnAlways(" GRUPO 3: Casos de tercer disparo tocado");
            this.printlnAlways("  Caso 12: el disparo supone el tercer tocado "
                    + "de un barco dispuesto en horizontal");
            List<String> adyacentes = new ArrayList<>();
            adyacentes.add("C5");
            adyacentes.add("C6");
            adyacentes.add("D6");
            adyacentes.add("C7");
            adyacentes.add("D5");
            adyacentes.add("D7");
            adyacentes.add("E5");
            adyacentes.add("E6");
            adyacentes.add("E7");
            adyacentes.add("C4");
            adyacentes.add("D4");
            adyacentes.add("E4");
            adyacentes.add("C8");
            adyacentes.add("D8");
            adyacentes.add("E8");
            List<String> proximosDisparosAntes = new ArrayList<>();
            proximosDisparosAntes.add("D8");
            proximosDisparosAntes.add("D4");
            List<String> tocadas = new ArrayList<>();
            tocadas.add("D6");
            tocadas.add("D5");
            tocadas.add("D7");
            this.checkTercerDisparo("D6", "D5", "D7", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Caso 13: el disparo supone el tercer tocado "
                    + "de un barco dispuesto en vertical");
            adyacentes = new ArrayList<>();
            adyacentes.add("C5");
            adyacentes.add("C6");
            adyacentes.add("C7");
            adyacentes.add("D5");
            adyacentes.add("D6");
            adyacentes.add("D7");
            adyacentes.add("E5");
            adyacentes.add("E6");
            adyacentes.add("E7");
            adyacentes.add("F5");
            adyacentes.add("F6");
            adyacentes.add("F7");
            adyacentes.add("G5");
            adyacentes.add("G6");
            adyacentes.add("G7");
            proximosDisparosAntes = new ArrayList<>();
            proximosDisparosAntes.add("C6");
            proximosDisparosAntes.add("G6");
            tocadas = new ArrayList<>();
            tocadas.add("D6");
            tocadas.add("E6");
            tocadas.add("F6");
            this.checkTercerDisparo("D6", "E6", "F6", adyacentes, proximosDisparosAntes,
                    tocadas, valorTotal, numTests, toThrow, puntosAntes);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    protected void checkQuitadasAdyacentesDeNoDisparadasYTocadas(
            List<String> adyacentes, List<String> tocadasArg, JugadorMaquina jugador,
            double valorTotal, int numTests, AssertionError toThrow,
            double puntosAntes) throws Exception {
        AssertionError error = null;
        this.printlnAlways("\tComprobar que se han quitado de 'noDisparadas' todas las casillas adyacentes");
        Set<String> todasMenosDisparadas = new HashSet<>(Posicion.todasLasCasillas());
        Optional<Object> optNoDisparadas = this.getPrivateFieldValue(jugador, "noDisparadas");
        if (!optNoDisparadas.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "noDisparadas", puntosAntes);
            return;
        }
        Set<String> noDisparadas = new HashSet((List<String>) optNoDisparadas.get());
        todasMenosDisparadas.removeAll(noDisparadas);
        Set<String> adyacentesSet = new HashSet<>(adyacentes);
        error = this.sAssertEquals(adyacentesSet, todasMenosDisparadas,
                valorTotal / (numTests), "Error. No parece que se hayan quitado "
                + "todas las casillas adyacentes de 'noDisparadas'. "
                + "Deberían haberse quitado " + adyacentes + " pero se han "
                + "quitado " + todasMenosDisparadas);
        toThrow = this.toThrow(error, toThrow);
        this.printlnAlways("\tComprobar que se ha actualizado correctamente el "
                + "contenido de 'tocadas'");
        Set<String> tocadasArgSet = new HashSet(tocadasArg);
        Optional<Object> optTocadas = this.getPrivateFieldValue(jugador, "tocadas");
        if (!optTocadas.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "tocadas", puntosAntes);
            return;
        }
        Set<String> tocadasJugSet = new HashSet((List<String>) optTocadas.get());
        error = this.sAssertEquals(tocadasArgSet, tocadasJugSet,
                valorTotal / numTests, "Error. No parece que se haya actualizado "
                + "correctamente 'tocadas'. Debería contener " + tocadasArgSet
                + " pero contiene " + tocadasJugSet);
        toThrow = this.toThrow(error, toThrow);
    }

    protected void checkDisparoEnProximosDisparosDeAntes(String disparo,
            JugadorMaquina jugador, List<String> proximosDisparosAntes,
            double valorTotal, int numTests, AssertionError toThrow,
            double puntosAntes) throws Exception {
        AssertionError error = null;
        this.printlnAlways("\tComprobar que la lista 'proximosDisparos' "
                + "tiene un elemento menos que antes de disparar");
        Optional<Object> optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
        if (!optPDisparos.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
            return;
        }
        List<String> pDisparos = (List<String>) optPDisparos.get();
        error = this.sAssertEquals(proximosDisparosAntes.size() - 1,
                pDisparos.size(), valorTotal / (numTests), "Error. El tamaño de "
                + "'proximosDisparos' NO ha disminuido en una unidad");
        toThrow = this.toThrow(error, toThrow);
        //
        this.printlnAlways("\tComprobar que la posición del disparo estaba en "
                + "la lista 'proximosDisparos'");
        Set<String> pDisparosSet = new HashSet<>(pDisparos);
        Set<String> disparoComoLista = new HashSet<>();
        disparoComoLista.add(disparo);
        Set<String> pDisparosAntesSet = new HashSet((proximosDisparosAntes));
        pDisparosAntesSet.removeAll(disparoComoLista);
        error = this.sAssertEquals(pDisparosAntesSet, pDisparosSet,
                valorTotal / (numTests), "Error. No parece que el disparo haya sido a "
                + "una de las posiciones que había en 'proximosDisparos'");
        toThrow = this.toThrow(error, toThrow);
    }

    protected void checkPrimerDisparo(String tocadoEn, List<String> adyacentes,
            List<String> proximosDisparosAntes, List<String> tocadas,
            double valorTotal, int numTests, AssertionError toThrow,
            double puntosAntes) throws Exception {
        JugadorMaquina jugador = new JugadorMaquina();
        this.setPrivateField(jugador, "noDisparadas", Posicion.todasLasCasillas());
        String disparoIgnorado = jugador.procesaTocado(tocadoEn);

        this.checkQuitadasAdyacentesDeNoDisparadasYTocadas(adyacentes, tocadas,
                jugador, valorTotal, numTests, toThrow, puntosAntes);
        this.checkDisparoEnProximosDisparosDeAntes(disparoIgnorado, jugador,
                proximosDisparosAntes, valorTotal, numTests, toThrow, puntosAntes);
    }

    protected void checkSegundoDisparo(String disparo, String segundoDisparo,
            List<String> adyacentes, List<String> proximosDisparosAntes, List<String> tocadas,
            double valorTotal, int numTests, AssertionError toThrow,
            double puntosAntes) throws Exception {
        AssertionError error;
        int filaDisp = Posicion.filaCharToInt(disparo);
        int colDisp = Integer.parseInt(disparo.substring(1, disparo.length()));
        int filaSegDisp = Posicion.filaCharToInt(segundoDisparo);
        int colSegDisp = Integer.parseInt(segundoDisparo.substring(1,
                segundoDisparo.length()));
        String expected = "";
        if (filaDisp == filaSegDisp) {
            expected = "H";
        } else if (colDisp == colSegDisp) {
            expected = "V";
        } else {
            error = this.sAssertTrue(false, 0, "Error. Mal caso de test. Se ha programado "
                    + "un segundo disparo tocado en una casilla que no está ni "
                    + "en la misma fila ni en la misma columna que el primer disparo");
            toThrow = this.toThrow(error, toThrow);
            return;
        }
        JugadorMaquina jugador = new JugadorMaquina();
        Optional<Object> optNoDisparadas = this.getPrivateFieldValue(jugador, "noDisparadas");
        if (!optNoDisparadas.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "noDisparadas", puntosAntes);
            return;
        }
        List<String> noDisparadas = (List<String>) optNoDisparadas.get();
        noDisparadas = Posicion.todasLasCasillas();
        String disparoIgnorado = jugador.procesaTocado(disparo);
        //Añadir el disparo a proximosDisparos para así simular que el segundo 
        //disparo es el pasado como argumento
        Optional<Object> optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
        if (!optPDisparos.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
            return;
        }
        List<String> pDisparos = (List<String>) optPDisparos.get();
        pDisparos.add(disparoIgnorado);

        //Y ahora quitar el segundo disparo, para simular que se ha 
        //realizado el segundo disparo a esta posición
        if (pDisparos.contains(segundoDisparo)) {
            pDisparos.remove(segundoDisparo);
        }
        String tercerDisparo = jugador.procesaTocado(segundoDisparo);
        this.checkQuitadasAdyacentesDeNoDisparadasYTocadas(adyacentes,
                tocadas, jugador, valorTotal, numTests, toThrow, puntosAntes);

        this.checkDisparoEnProximosDisparosDeAntes(tercerDisparo, jugador,
                proximosDisparosAntes, valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando que el atributo 'dirBarcoTocado' "
                + "se ha asignado correctamente");
        Optional<Field> optDirBTocadoF = this.getPrivateField(jugador, "dirBarcoTocado");
        if (!optDirBTocadoF.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "dirBarcoTocado", puntosAntes);
            return;
        }
        Field optDirBTocado = optDirBTocadoF.get();
        String dirBarcoTocado = (String) optDirBTocado.get(jugador);
        error = this.sAssertEquals(expected, dirBarcoTocado, valorTotal / numTests,
                "Error. 'dirBarcoTocado' no ha tomado el valor null. Su "
                + "valor es " + dirBarcoTocado);
        toThrow = this.toThrow(error, toThrow);
    }

    protected void checkTercerDisparo(String disparo, String segundoDisparo,
            String tercerDisparo, List<String> adyacentes,
            List<String> proximosDisparosAntes, List<String> tocadas,
            double valorTotal, int numTests, AssertionError toThrow,
            double puntosAntes) throws Exception {
        AssertionError error;
        JugadorMaquina jugador = new JugadorMaquina();
        Optional<Object> optNoDisparadas = this.getPrivateFieldValue(jugador, "noDisparadas");
        if (!optNoDisparadas.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "noDisparadas", puntosAntes);
            return;
        }
        List<String> noDisparadas = (List<String>) optNoDisparadas.get();
        noDisparadas = Posicion.todasLasCasillas();
        String disparoIgnorado = jugador.procesaTocado(disparo);
        Optional<Object> optPDisparos = this.getPrivateFieldValue(jugador, "proximosDisparos");
        if (!optPDisparos.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "proximosDisparos", puntosAntes);
            return;
        }
        List<String> proximosDisparos = (List<String>) optPDisparos.get();
        proximosDisparos.add(disparoIgnorado);
        if (proximosDisparos.contains(segundoDisparo)) {
            proximosDisparos.remove(segundoDisparo);
        }
        String otroDisparo = jugador.procesaTocado(segundoDisparo);
        proximosDisparos.add(otroDisparo);
        this.printlnAlways("\tComprobando que el atributo 'dir_barco_tocado' "
                + "se ha asignado correctamente");
        int filaDisp = Posicion.filaCharToInt(disparo);
        int colDisp = Integer.parseInt(disparo.substring(1, disparo.length()));
        int filaSegDisp = Posicion.filaCharToInt(segundoDisparo);
        int colSegDisp = Integer.parseInt(segundoDisparo.substring(1,
                segundoDisparo.length()));
        String expected = "";
        if (filaDisp == filaSegDisp) {
            expected = "H";
        } else if (colDisp == colSegDisp) {
            expected = "V";
        } else {
            error = this.sAssertTrue(false, 0, "Error. Mal caso de test. Se ha programado "
                    + "un segundo disparo tocado en una casilla que no está ni "
                    + "en la misma fila ni en la misma columna que el primer disparo");
            toThrow = this.toThrow(error, toThrow);
            return;
        }
        Optional<Field> optDirBTocadoF = this.getPrivateField(jugador, "dirBarcoTocado");
        if (!optDirBTocadoF.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "dirBarcoTocado", puntosAntes);
            return;
        }
        Field optDirBTocado = optDirBTocadoF.get();
        String dirBarcoTocado = (String) optDirBTocado.get(jugador);
        error = this.sAssertEquals(expected, dirBarcoTocado, valorTotal / numTests,
                "Error. 'dirBarcoTocado' no no parece haberse actualizado "
                + "correctamente");
        toThrow = this.toThrow(error, toThrow);
        if (proximosDisparos.contains(tercerDisparo)) {
            proximosDisparos.remove(tercerDisparo);
        }
        String ultimoDisparo = jugador.procesaTocado(tercerDisparo);
        this.checkQuitadasAdyacentesDeNoDisparadasYTocadas(adyacentes, tocadas,
                jugador, valorTotal, numTests, toThrow, puntosAntes);
        this.checkDisparoEnProximosDisparosDeAntes(ultimoDisparo, jugador,
                proximosDisparosAntes, valorTotal, numTests, toThrow, puntosAntes);
    }

}

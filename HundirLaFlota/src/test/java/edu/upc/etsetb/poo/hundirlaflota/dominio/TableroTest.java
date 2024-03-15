/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
public class TableroTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public TableroTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        TableroTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "TableroTest");
        nota.put("TableroTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::Tablero(..). Valor: " + valorTotal);
        try {
            Tablero tablero = new Tablero();
            this.printlnAlways("\tComprobando atributo \'disparosAAgua\'.");
            this.checkExistCollelctionAndHasNElements(tablero, "disparosAAgua", 0,
                    0.5 * valorTotal, error);
            this.printlnAlways("\tComprobando atributo \'casillas\'.");
            this.checkExistMapAndHasNEntries(tablero, "casillas", 0,
                    0.5 * valorTotal, error);
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
    public void test02_getBarcoEn() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::getBarcoEn(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1. Se crea el tablero, se crea una "
                    + "lancha, se coloca en A1 y se invoca get_barco_en(\"A1\")");
            Tablero tablero = new Tablero();
            Barco lancha = new Lancha("Lancha1");
            Optional optCasillas = this.getPrivateFieldValue(tablero, "casillas");
            if (!optCasillas.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
                return;
            }
            Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
            casillas.put("A1", lancha);
            error = this.sAssertEquals(lancha, tablero.getBarcoEn("A1"),
                    valorTotal / 2, "Error. Se ha colocado una lancha en A1 "
                    + "debería devolverla pero no es así");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2. Se invoca get_barco_en(\'A2\') pero no hay nada en \'A2\'");
            error = this.sAssertTrue(tablero.getBarcoEn("A2") == null, valorTotal / 2,
                    "Error. No se ha colocado ningún barco "
                    + "en A2 debería devolver null pero no es así");
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
    public void test03_getDisparosAAgua() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::getDisparosAAgua(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea el tablero, se añaden algunos disparos"
                    + " y se invoca al método");
            Tablero tablero = new Tablero();
            Optional optDisparos = this.getPrivateFieldValue(tablero, "disparosAAgua");
            if (!optDisparos.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "disparosAAgua", puntosAntes);
                return;
            }
            List<String> disparos = (List<String>) optDisparos.get();
            disparos.add("A1");
            disparos.add("A2");
            error = this.sAssertEquals(disparos, tablero.getDisparosAAgua(),
                    valorTotal, "Error. El método no devuelve la referencia al "
                    + "atributo \'disparos_a_agua\'");
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
    public void test04_getPosicionesBarcos() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::getPosicionesBarcos(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea el tablero, se añaden lanchas en "
                    + "posiciones y se invoca al método");
            Tablero tablero = new Tablero();
            Barco lancha1 = new Lancha("Lancha1");
            Barco lancha2 = new Lancha("Lancha2");
            Barco lancha3 = new Lancha("Lancha3");
            Barco lancha4 = new Lancha("Lancha4");
            Optional optCasillas = this.getPrivateFieldValue(tablero, "casillas");
            if (!optCasillas.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
                return;
            }
            Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
            casillas.put("A1", lancha1);
            casillas.put("J1", lancha2);
            casillas.put("A10", lancha3);
            casillas.put("J10", lancha4);
            String[] expArray = {"A1", "A10", "J1", "J10"};
            Set<String> expected = new HashSet(Arrays.asList(expArray));
            Set<String> returned = tablero.getPosicionesBarcos();
            error = this.sAssertTrue(expected.equals(tablero.getPosicionesBarcos()),
                    valorTotal, "Error. El método no  devuelve el conjunto de "
                    + "posiciones de las casillas con barcos. Debería devolver "
                    + expected + ", pero devuelve " + returned);
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
    public void test05_anotaAguaEnHumano() {
        double valorTotal = 0.75;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::anotaAguaEnHumano(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea tablero y se invoca al método con una posición");
            Tablero tablero = new Tablero();
            tablero.anotaAguaEnHumano("A1");
            Optional optDisparos = this.getPrivateFieldValue(tablero, "disparosAAgua");
            if (!optDisparos.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "disparosAAgua", puntosAntes);
                return;
            }
            List<String> disparos = (List<String>) optDisparos.get();

            error = this.sAssertTrue(disparos.contains("A1"), valorTotal, "Error. El método no  "
                    + "ha anotado en atributo \'disparosAAgua\' la posición \'A1\'");
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
    public void test06_getCasillas() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::getCasillas(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea el tablero, se añaden lanchas en "
                    + "posiciones y se invoca al método");
            Tablero tablero = new Tablero();
            Barco lancha1 = new Lancha("Lancha1");
            Barco lancha2 = new Lancha("Lancha2");
            Barco lancha3 = new Lancha("Lancha3");
            Barco lancha4 = new Lancha("Lancha4");
            Optional optCasillas = this.getPrivateFieldValue(tablero, "casillas");
            if (!optCasillas.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
                return;
            }
            Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
            casillas.put("A1", lancha1);
            casillas.put("J1", lancha2);
            casillas.put("A10", lancha3);
            casillas.put("J10", lancha4);
            Map<String, Barco> returned = tablero.getCasillas();
            Map<String, Barco> expected = new HashMap<>();
            expected.put("A1", lancha1);
            expected.put("J1", lancha2);
            expected.put("A10", lancha3);
            expected.put("J10", lancha4);
            error = this.sAssertTrue(returned.equals(expected), valorTotal,
                    "Error. El método no devuelve el mapa de casillas con "
                    + "barcos. Debería devolver " + expected
                    + ", pero devuelve " + returned);
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
    public void test07_getContenidoCasilla() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::etContenidoCasilla(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Caso 1: hay barco en la casilla. Se crea "
                    + "tablero, se añade una lancha en \"A1\" y se invoca al "
                    + "método con \"A1\" como argumento");
            Tablero tablero = new Tablero();
            Lancha lancha = new Lancha("Lancha1");
            Optional<Object> optCasillas = this.getPrivateFieldValue(tablero, "casillas");
            if (!optCasillas.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
                return;
            }
            Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
            Barco barco = casillas.put("A1", lancha);
            error = this.sAssertEquals(lancha, tablero.getContenidoCasilla("A1"),
                    valorTotal / numTests, "Error. Se ha colocado un barco en "
                    + "la casilla A1 pero el método no devuelve ese barco");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 2: no hay barco en la casilla. Se invoca al método con 'A3' como argumento");
            error = this.sAssertNull(tablero.getContenidoCasilla("A3"),
                    valorTotal / numTests, "Error. No se ha colocado un barco en "
                    + "la casilla A3 pero el método devuelve UN barco");
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
}

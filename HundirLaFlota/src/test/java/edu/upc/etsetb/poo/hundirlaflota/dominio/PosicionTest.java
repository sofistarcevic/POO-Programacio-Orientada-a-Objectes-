/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class PosicionTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public PosicionTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        PosicionTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "PosicionTest");
        nota.put("PosicionTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_esCorrecta() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Posicion::esCorrecta(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Caso 1: Posición interior. Se invoca a Posicion.esCorrecta(\'A6\')");
            error = this.sAssertTrue(Posicion.esCorrecta("A6"), valorTotal / 13, "Error. La posición A6 (interior) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 2: Esquina inferior izquierda. Se invoca a Posicion.esCorrecta(\'J1\')");
            error = this.sAssertTrue(Posicion.esCorrecta("J1"), valorTotal / 13, "Error. La posición J1 (esquina) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 3: Esquina inferior derecha. Se invoca a Posicion.esCorrecta(\'J10\')");
            error = this.sAssertTrue(Posicion.esCorrecta("J10"), valorTotal / 13, "Error. La posición J10 (esquina) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 4: Esquina superior derecha. Se invoca a Posicion.esCorrecta(\'A10\')");
            error = this.sAssertTrue(Posicion.esCorrecta("A10"), valorTotal / 13, "Error. La posición A10 (esquina) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 5: Esquina superior izquierda. Se invoca a Posicion.esCorrecta(\'A1\')");
            error = this.sAssertTrue(Posicion.esCorrecta("A1"), valorTotal / 13, "Error. La posición A1 (esquina) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 6: Lado superior. Se invoca a Posicion.esCorrecta(\'A4\')");
            error = this.sAssertTrue(Posicion.esCorrecta("A4"), valorTotal / 13, "Error. La posición A4 (lado) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 7: Lado izquierdo. Se invoca a Posicion.esCorrecta(\'D1\')");
            error = this.sAssertTrue(Posicion.esCorrecta("C1"), valorTotal / 13, "Error. La posición C1 (lado) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 8: Lado inferior. Se invoca a Posicion.esCorrecta(\'J5\')");
            error = this.sAssertTrue(Posicion.esCorrecta("J5"), valorTotal / 13, "Error. La posición J5 (lado) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 9: Lado derecho. Se invoca a Posicion.esCorrecta(\'G10\')");
            error = this.sAssertTrue(Posicion.esCorrecta("G10"), valorTotal / 13, "Error. La posición G10 (lado) "
                    + "es correcta, sin embargo Posicion::esCorrecta ha retornado false");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 10: Casilla fuera por la derecha. Se invoca a Posicion.esCorrecta(\'G11\')");
            error = this.sAssertFalse(Posicion.esCorrecta("G11"), valorTotal / 13, "Error. La posición G11 (por derecha) "
                    + "es incorrecta, sin embargo Posicion::esCorrecta ha retornado true");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 11: Casilla fuera por arriba. Se invoca a Posicion.esCorrecta(\'@1\')");
            error = this.sAssertFalse(Posicion.esCorrecta(new String(Character.toChars("A".codePointAt(0) - 1)) + "1"), valorTotal / 13, "Error. La posición exterior por arriba "
                    + "es incorrecta, sin embargo Posicion::esCorrecta ha retornado true");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 12: Casilla fuera por la izquierda. Se invoca a Posicion.esCorrecta(\'A0\')");
            error = this.sAssertFalse(Posicion.esCorrecta("A0"), valorTotal / 13, "Error. La posición A0 (exterior por la izquierda) "
                    + "es incorrecta, sin embargo Posicion::esCorrecta ha retornado true");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("  Caso 13: Casilla fuera por abajo. Se invoca a Posicion.esCorrecta(\'K2\')");
            error = this.sAssertFalse(Posicion.esCorrecta("K2"), valorTotal / 13, "Error. La posición K2 (exterior por abajo) "
                    + "es incorrecta, sin embargo Posicion::esCorrecta ha retornado true");
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
    public void test02_avanzaCasillas() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numCasos = 28;
        this.printlnAlways("\nComprobando Posicion::avanzaCasillas(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Caso 1: Posición interior (C6), avanza norte (-1,0). ");
            try {
                Posicion.avanzaCasillas("C6", -1, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-1,0) a partir de C6 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 2: Posición interior (C6), avanza norte 2 casillas (-2,0). ");
            try {
                Posicion.avanzaCasillas("C6", -2, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-2,0) a partir de C6 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 3: Posición interior (C6), ERROR al avanzar norte 3 casillas (-3,0). ");
            try {
                Posicion.avanzaCasillas("C6", -3, 0);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-3,0) a partir de C6 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 4: Posición interior (H6), avanza sur (1,0). ");
            try {
                Posicion.avanzaCasillas("H6", 1, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (1,0) a partir de H6 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 5: Posición interior (H6), avanza sur 2 casillas (2,0). ");
            try {
                Posicion.avanzaCasillas("H6", 2, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (2,0) a partir de H6 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 6: Posición interior (H6), ERROR al avanzar norte 3 casillas (3,0). ");
            try {
                Posicion.avanzaCasillas("H6", 3, 0);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (3,0) a partir de H6 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 7: Posición interior (H8), avanza este (0,1). ");
            try {
                Posicion.avanzaCasillas("H8", 0, 1);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,1) a partir de H8 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 8: Posición interior (H8), avanza este 2 casillas (0,2). ");
            try {
                Posicion.avanzaCasillas("H8", 0, 2);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,2) a partir de H6 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 9: Posición interior (H8), ERROR al avanzar este 3 casillas (0,3). ");
            try {
                Posicion.avanzaCasillas("H8", 0, 3);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,3) a partir de H8 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 10: Posición interior (H3), avanza oeste (0,-1). ");
            try {
                Posicion.avanzaCasillas("H3", 0, -1);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-1) a partir de H3 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 11: Posición interior (H3), avanza oeste 2 casillas (0,-2). ");
            try {
                Posicion.avanzaCasillas("H3", 0, -2);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-2) a partir de H3 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 12: Posición interior (H3), ERROR al avanzar oeste 3 casillas (0,-3). ");
            try {
                Posicion.avanzaCasillas("H3", 0, -3);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-3) a partir de H3 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 13: Esquina A1, ERROR al avanzar norte 1 casilla (-1,0). ");
            try {
                Posicion.avanzaCasillas("A1", -1, 0);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-1,0) a partir de A1 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 14: Esquina A1, avanza sur 1 casilla (1,0). ");
            try {
                Posicion.avanzaCasillas("A1", 1, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (1,0) a partir de A1 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 15: Esquina A1, ERROR al avanzar oeste 1 casilla (0,-1). ");
            try {
                Posicion.avanzaCasillas("A1", 0, -1);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-1) a partir de A1 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 16: Esquina A1, avanza este 1 casilla (0,1). ");
            try {
                Posicion.avanzaCasillas("A1", 0, 1);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,1) a partir de A1 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 17: Esquina A10, ERROR al avanzar norte 1 casilla (-1,0). ");
            try {
                Posicion.avanzaCasillas("A10", -1, 0);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-1,0) a partir de A10 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 18: Esquina A10, avanza sur 1 casilla (1,0). ");
            try {
                Posicion.avanzaCasillas("A10", 1, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (1,0) a partir de A10 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 19: Esquina A10, ERROR al avanzar este 1 casilla (0,1). ");
            try {
                Posicion.avanzaCasillas("A10", 0, 1);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,1) a partir de A10 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 20: Esquina A10, avanza oeste 1 casilla (0,-1). ");
            try {
                Posicion.avanzaCasillas("A10", 0, -1);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-1) a partir de A10 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 21: Esquina J1, ERROR al avanzar sur 1 casilla (1,0). ");
            try {
                Posicion.avanzaCasillas("J1", 1, 0);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (1,0) a partir de J1 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 22: Esquina A1, avanza norte 1 casilla (-1,0). ");
            try {
                Posicion.avanzaCasillas("J1", -1, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-1,0) a partir de J1 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 23: Esquina J1, ERROR al avanzar oeste 1 casilla (0,-1). ");
            try {
                Posicion.avanzaCasillas("J1", 0, -1);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-1) a partir de J1 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 24: Esquina J1, avanza este 1 casilla (0,1). ");
            try {
                Posicion.avanzaCasillas("J1", 0, 1);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (Exception ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,1) a partir de J1 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 25: Esquina J10, ERROR al avanzar sur 1 casilla (1,0). ");
            try {
                Posicion.avanzaCasillas("J10", 1, 0);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (1,0) a partir de J10 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            //
            this.printlnAlways("  Caso 26: Esquina J10, avanza norte 1 casilla (-1,0). ");
            try {
                Posicion.avanzaCasillas("J10", -1, 0);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (-1,0) a partir de J10 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 27: Esquina J10, ERROR al avanzar este 1 casilla (0,1). ");
            try {
                Posicion.avanzaCasillas("J10", 0, 1);
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,1) a partir de J10 es "
                        + "erróneo. Sin embargo el método NO lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 28: Esquina J10, avanza oeste 1 casilla (0,-1). ");
            try {
                Posicion.avanzaCasillas("J10", 0, -1);
                error = this.sAssertTrue(true, valorTotal / numCasos, "");
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, valorTotal / numCasos, "Error. El movimiento (0,-1) a partir de J10 es "
                        + "correcto. Sin embargo el método lanza una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
        } catch (Throwable ex1) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex1.setStackTrace(this.reduceST(ex1.getStackTrace()));
            ex1.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    @Test
    public void test03_checkPosicionesCorrectas() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Posicion::checkPosicionesCorrectas(..). Valor: " + valorTotal);
        try {
            //
            this.printlnAlways("  Caso 1: Posiciones interiores horizontales.");
            try {
                String[] pos_dir = {"B6", "H"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error. Las "
                        + "posiciones B6 y B7 son correctas, sin embargo "
                        + "el método ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 2: Posiciones interiores verticales.");

            try {
                String[] pos_dir = {"B6", "V"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error. Las posiciones B6 y C6 son correctas, sin embargo "
                        + "el método ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 3: Posiciones en lado horizontales (lado izquierdo).");
            try {
                String[] pos_dir = {"B1", "H"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
            } catch (PositionException ex) {
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error. Las "
                        + "posiciones B1 y B2 son correctas, sin embargo "
                        + "el método ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 4: Posiciones en lado horizontales (lado derecho).");
            try {
                String[] pos_dir = {"B9", "H"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
            } catch (PositionException ex) {
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error. "
                        + "Las posiciones B9 y B10 son correctas, sin embargo "
                        + "el método ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 5: Posiciones en lado verticales (arriba).");
            try {

                String[] pos_dir = {"A7", "V"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
            } catch (PositionException ex) {
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error. Las "
                        + "posiciones A7 y A8 son correctas, sin embargo "
                        + "el método ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 6: Posiciones en lado verticales (abajo).");
            try {

                String[] pos_dir = {"I7", "V"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
            } catch (PositionException ex) {
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error. "
                        + "Las posiciones I7 y J7 son correctas, sin embargo "
                        + "el método ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 7: Posiciones fuera por arriba.");
            try {
                String[] pos_dir = {"@7", "V"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertFalse(true, valorTotal * 0.1, "Error"
                        + ". La posición ' [str(ord('A')-1)+\"7\"'es incorrecta, sin embargo "
                        + "el método NO ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 8: Posiciones fuera por izquierda.");
            try {
                String[] pos_dir = {"A0", "H"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertFalse(true, valorTotal * 0.1,
                        "Error. La posición A0 es incorrecta, sin embargo "
                        + "el método NO ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 9: Posiciones fuera por la derecha.");
            try {
                String[] pos_dir = {"J10", "H"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertFalse(true, valorTotal * 0.1,
                        "Error. La posición J11 es incorrecta, sin embargo "
                        + "el método NO ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 10: Posiciones fuera por izquierda.");
            try {
                String[] pos_dir = {"A0", "H"};
                Posicion.checkPosicionesCorrectas(pos_dir, 2);
                error = this.sAssertFalse(true, valorTotal * 0.1,
                        "Error. La posición A0 es incorrecta, sin embargo "
                        + "el método NO ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal * 0.1, "");
                toThrow = this.toThrow(error, toThrow);
            }

        } catch (Throwable ex1) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex1.setStackTrace(this.reduceST(ex1.getStackTrace()));
            ex1.printStackTrace();
        }
        this.acumula(puntos);
        puntos(puntosAntes);
        throwIfAnError(toThrow);
    }

    @Test
    public void test04_getPuntosCardinales() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numCasos = 10;
        String[] posiciones = {"C6", "A1", "A10", "J1", "J10", "A6", "J6",
            "C1", "C10"};
        String[][] expectedPuntosCardinales = {
            {"B6", "C5", "C7", "D6"}, {"A2", "B1"}, {"A9", "B10"}, {"J2", "I1"},
            {"I10", "J9"}, {"A5", "A7", "B6"}, {"J5", "J7", "I6"}, {"C2", "B1", "D1"},
            {"C9", "B10", "D10"}
        };
        this.printlnAlways("\nComprobando Posicion::getPuntosCardinales(..). Valor: " + valorTotal);
        try {
            int i = 0;
            for (String posicion : posiciones) {
                Set<String> expected = new HashSet(Arrays.asList(expectedPuntosCardinales[i]));
                this.checkForPuntosGetCardinales(++i, posicion,
                        expected, valorTotal / numCasos, toThrow);
            }
            try {
                this.printlnAlways("  Caso 10: Casilla incorrecta J11; debe lanzar una excepción. ");
                List<String> cardinales = Posicion.getPuntosCardinales("J11");
                this.sAssertTrue(false, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                this.sAssertTrue(true, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            }
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
    public void test05_getNorteSur() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numCasos = 10;
        String[] posiciones = {"C6", "A1", "A10", "J1", "J10", "A6", "J6",
            "C1", "C10"};
        String[][] expectedNorteSur = {
            {"B6", "D6"}, {"B1"}, {"B10"}, {"I1"},
            {"I10"}, {"B6"}, {"I6"}, {"B1", "D1"},
            {"B10", "D10"}
        };
        this.printlnAlways("\nComprobando Posicion::getNorteSur(..). Valor: " + valorTotal);
        try {
            int i = 0;
            for (String posicion : posiciones) {
                Set<String> expected = new HashSet(Arrays.asList(expectedNorteSur[i]));
                this.checkForgetNorteSur(++i, posicion,
                        expected, valorTotal / numCasos, toThrow);
            }
            try {
                this.printlnAlways("  Caso 10: Casilla incorrecta J11; debe lanzar una excepción. ");
                Set<String> cardinales = Posicion.getNorteSur("J11");
                this.sAssertTrue(false, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                this.sAssertTrue(true, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            }
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
    public void test06_getEsteOeste() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numCasos = 10;
        String[] posiciones = {"C6", "A1", "A10", "J1", "J10", "A6", "J6",
            "C1", "C10"};
        String[][] expectedEsteOeste = {
            {"C5", "C7"}, {"A2"}, {"A9"}, {"J2"},
            {"J9"}, {"A5", "A7"}, {"J5", "J7"}, {"C2"},
            {"C9"}
        };
        this.printlnAlways("\nComprobando Posicion::getEsteOeste(..). Valor: " + valorTotal);
        try {
            int i = 0;
            for (String posicion : posiciones) {
                Set<String> expected = new HashSet(Arrays.asList(expectedEsteOeste[i]));
                this.checkForgetEsteOeste(++i, posicion,
                        expected, valorTotal / numCasos, toThrow);
            }
            try {
                this.printlnAlways("  Caso 10: Casilla incorrecta J11; debe lanzar una excepción. ");
                Set<String> cardinales = Posicion.getEsteOeste("J11");
                this.sAssertTrue(false, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                this.sAssertTrue(true, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            }
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
    public void test07_getAdyacentes() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numCasos = 10;
        String[] posiciones = {"C6", "A1", "A10", "J1", "J10", "A6", "J6",
            "C1", "C10"};
        String[][] expectedAdyacentes = {
            {"C5", "C7", "B5", "B6", "B7", "D5", "D6", "D7"}, {"A2", "B1", "B2"},
            {"A9", "B9", "B10"}, {"J2", "I1", "I2"},
            {"J9", "I9", "I10"}, {"A5", "A7", "B5", "B6", "B7"},
            {"J5", "J7", "I5", "I6", "I7"}, {"C2", "B1", "B2", "D1", "D2"},
            {"C9", "B9", "B10", "D9", "D10"}
        };
        this.printlnAlways("\nComprobando Posicion::getAdyacentes(..). Valor: " + valorTotal);
        try {
            int i = 0;
            for (String posicion : posiciones) {
                Set<String> expected = new HashSet(Arrays.asList(expectedAdyacentes[i]));
                this.checkForgetAdyacentes(++i, posicion,
                        expected, valorTotal / numCasos, toThrow);
            }
            try {
                this.printlnAlways("  Caso 10: Casilla incorrecta J11; debe lanzar una excepción. ");
                Set<String> cardinales = Posicion.getAdyacentes("J11");
                this.sAssertTrue(false, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                this.sAssertTrue(true, valorTotal / numCasos, "Error. Se ha "
                        + "invocado al método con una posición incorrecta "
                        + "pero éste no ha lanzado ninguna excepción");
                toThrow = this.toThrow(error, toThrow);
            }
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
    public void test08_todasLasCasillas() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numCasos = 10;
        this.printlnAlways("\nComprobando Posicion::todas_las_casillas(..). "
                + "Valor: " + valorTotal);
        try {
            List<String> expected = this.todas();
            List<String> casillas = Posicion.todasLasCasillas();
            Set<String> difference = new HashSet<>(expected);
            difference.removeAll(casillas);
            error = this.sAssertEquals(expected, casillas, valorTotal, "La "
                    + "lista de casillas generado por el método "
                    + "NO es el que debe. Faltan los siguientes elementos: " + difference);
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

    private void checkForPuntosGetCardinales(int numCaso, String posicion,
            Set<String> expected, double valor, AssertionError toThrow) throws PositionException {
        double puntosAntes = puntosTotales;
        try {
            this.printlnAlways("  Caso " + numCaso + ": Casilla " + posicion + "; debe devolver " + expected);
            Set<String> cardinales = new HashSet(Posicion.getPuntosCardinales(posicion));
            AssertionError error = this.sAssertEquals(expected, cardinales, valor, "Los puntos "
                    + "cardinales de " + posicion + " son " + expected + ". Sin "
                    + "embargo el método no ha devuelto la lista correcta. Detalles: ");
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

    private void checkForgetNorteSur(int numCaso, String posicion,
            Set<String> expected, double valor, AssertionError toThrow)
            throws PositionException {
        double puntosAntes = puntosTotales;
        try {
            this.printlnAlways("  Caso " + numCaso + ": Casilla " + posicion + "; debe devolver " + expected);
            Set<String> norteSur = Posicion.getNorteSur(posicion);
            AssertionError error = this.sAssertEquals(expected, norteSur, valor, "Los puntos "
                    + "cardinales Norte y Sur de " + posicion + " son " + expected + ". Sin "
                    + "embargo el método no ha devuelto la lista correcta. Detalles: ");
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

    private void checkForgetEsteOeste(int numCaso, String posicion,
            Set<String> expected, double valor, AssertionError toThrow)
            throws PositionException {
        double puntosAntes = puntosTotales;
        try {
            this.printlnAlways("  Caso " + numCaso + ": Casilla " + posicion + "; debe devolver " + expected);
            Set<String> norteSur = Posicion.getEsteOeste(posicion);
            AssertionError error = this.sAssertEquals(expected, norteSur, valor, "Los puntos "
                    + "cardinales Este y Oeste de " + posicion + " son " + expected + ". Sin "
                    + "embargo el método no ha devuelto la lista correcta. Detalles: ");
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

    private void checkForgetAdyacentes(int numCaso, String posicion,
            Set<String> expected, double valor, AssertionError toThrow)
            throws PositionException {
        double puntosAntes = puntosTotales;
        try {
            this.printlnAlways("  Caso " + numCaso + ": Casilla " + posicion + "; debe devolver " + expected);
            Set<String> norteSur = Posicion.getAdyacentes(posicion);
            AssertionError error = this.sAssertEquals(expected, norteSur, valor, "Las casillas "
                    + "adyacentes de " + posicion + " son " + expected + ". Sin "
                    + "embargo el método no ha devuelto la lista correcta. Detalles: ");
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

    private List<String> todas() {
        String[] array = {
            "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10",
            "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10",
            "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "E10",
            "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "F10",
            "G1", "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G9", "G10",
            "H1", "H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10",
            "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10",
            "J1", "J2", "J3", "J4", "J5", "J6", "J7", "J8", "J9", "J10"
        };
        return Arrays.asList(array);
    }
}

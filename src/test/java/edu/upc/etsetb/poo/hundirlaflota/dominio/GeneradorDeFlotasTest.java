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
public class GeneradorDeFlotasTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public GeneradorDeFlotasTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        GeneradorDeFlotasTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "GeneradorDeFlotasTest");
        nota.put("GeneradorDeFlotasTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_generaFlotaDeterministra() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 41;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando GeneradorDeFlotas::generaFlotaDeterministra(..). Valor: " + valorTotal);
        try {
            Jugador jugador = new JugadorHumano("nombreJugador");
            GeneradorDeFlotas generador = new GeneradorDeFlotas();
            generador.generaFlotaDeterminista(jugador);
            this.checkBarcosFlotaDeterminista(jugador, valorTotal, numTests,
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

    @Test
    public void test02_generaFlotaAleatoria() {
        double valorTotal = 3;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 13;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando GeneradorDeFlotas::generaFlotaAleatoria(..). Valor: " + valorTotal);
        try {
            JugadorHumano jugador1 = new JugadorHumano("nombreJugador1");
            GeneradorDeFlotas generador = new GeneradorDeFlotas();
            generador.generaFlotaAleatoria(jugador1);
            this.printlnAlways("  Se ha generado una primera flota aleatoria. "
                    + "Comprobando que la flota es correcta");
            this.checkBarcosCorrectos(jugador1, valorTotal, numTests, toThrow, puntosAntes);
            //
            Thread.sleep(10);
            JugadorHumano jugador2 = new JugadorHumano("nombreJugador2");
            generador.generaFlotaAleatoria(jugador2);
            this.printlnAlways("  Se ha generado una segunda flota aleatoria. "
                    + "Comprobando que la flota es correcta");
            this.checkBarcosCorrectos(jugador2, valorTotal, numTests, toThrow, puntosAntes);
            //
            this.printlnAlways("  Comprobando que ambas flotas generadas "
                    + "aleatoriamente son distintas");
            Map<String, Barco> casillas1 = jugador1.getTablero().getCasillas();
            Map<String, Barco> casillas2 = jugador2.getTablero().getCasillas();
            error = this.sAssertFalse(casillas1.equals(casillas2), valorTotal / numTests,
                    "Error. Se han generado dos flotas e forma supuestamente "
                    + "aleatoria, pero ambas flotas son idénticas");
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
    public void test03_generaFlotaDeArchivo() {
        double valorTotal = 6;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 41;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando GeneradorDeFlotas::generaFlotaDeArchivo(..). Valor: " + valorTotal);
        try {
            JugadorHumano jugador = new JugadorHumano("nombreJugador");
            GeneradorDeFlotas generador = new GeneradorDeFlotas();
            generador.leeFlotaDeArchivo(jugador, System.getProperty("user.dir")
                    + "/flota_jugador_det.txt");
            this.checkBarcosFlotaDeterminista(jugador, valorTotal, numTests, toThrow, puntosAntes);
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

    private void checkBarcosFlotaDeterminista(Jugador jugador,
            double valorTotal, int numTests, AssertionError toThrow,
            double puntosAntes) throws Exception {
        AssertionError error;
        String[] casRefArray = {
            "E4", "E5", "E6", "E7", "E8",
            "G6", "H6", "I6", "J6",
            "H1", "H2", "H3",
            "B1", "B2", "B3",
            "G9", "G10",
            "B10", "C10",
            "J10", "D1", "A6"
        };
        Set<String> casillasRef = new HashSet<>(Arrays.asList(casRefArray));
        Map<String, Barco> casillas = jugador.getTablero().getCasillas();
        this.printlnAlways("\tComprobando que hay 9 barcos y que comienzan en "
                + "las posiciones correctas");
        error = this.sAssertEquals(casillasRef, casillas.keySet(),
                valorTotal / numTests, "Error. Hay algún barco que no "
                + "parece haberse colocado en la posición correcta. Las "
                + "casillas de comienzo anotadas en el tablero del "
                + "jugador no coínciden con las casillas de referencia");
        toThrow = this.toThrow(error, toThrow);
        String[][] casRefMat = {
            {"E4", "E5", "E6", "E7", "E8"},
            {"G6", "H6", "I6", "J6"},
            {"H1", "H2", "H3"},
            {"B1", "B2", "B3"},
            {"G9", "G10"},
            {"B10", "C10"},
            {"J10"}, {"D1"}, {"A6"}
        };
        this.printlnAlways("\tComprobando el Portaviones");
        this.checkBarcoFlotaDeterminista(jugador, new Portaviones("p"),
                "Portaviones", "E4", new HashSet(Arrays.asList(casRefMat[0])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando el Buque");
        this.checkBarcoFlotaDeterminista(jugador, new Buque("b1"),
                "Buque", "G6", new HashSet(Arrays.asList(casRefMat[1])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando el primer Submarino");
        this.checkBarcoFlotaDeterminista(jugador, new Submarino("s1"),
                "Submarino", "H1", new HashSet(Arrays.asList(casRefMat[2])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando el segundo Submarino");
        this.checkBarcoFlotaDeterminista(jugador, new Submarino("s2"),
                "Submarino", "B1", new HashSet(Arrays.asList(casRefMat[3])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando el primer Crucero");
        this.checkBarcoFlotaDeterminista(jugador, new Crucero("c1"),
                "Crucero", "G9", new HashSet(Arrays.asList(casRefMat[4])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando el segundo Crucero");
        this.checkBarcoFlotaDeterminista(jugador, new Crucero("c2"),
                "Crucero", "B10", new HashSet(Arrays.asList(casRefMat[5])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando la primera Lancha");
        this.checkBarcoFlotaDeterminista(jugador, new Lancha("l1"),
                "Lancha", "J10", new HashSet(Arrays.asList(casRefMat[6])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando la segunda Lancha");
        this.checkBarcoFlotaDeterminista(jugador, new Lancha("l2"),
                "Lancha", "D1", new HashSet(Arrays.asList(casRefMat[7])),
                valorTotal, numTests, toThrow, puntosAntes);
        this.printlnAlways("\tComprobando la tercera Lancha");
        this.checkBarcoFlotaDeterminista(jugador, new Lancha("l3"),
                "Lancha", "A6", new HashSet(Arrays.asList(casRefMat[8])),
                valorTotal, numTests, toThrow, puntosAntes);
    }

    private void checkBarcoFlotaDeterminista(Jugador jugador, Barco barcoArg,
            String nombreTipoBarco, String posComienzo,
            Set<String> casillasBarcoRef, double valorTotal, int numTests,
            AssertionError toThrow, double puntosAntes) throws Exception {
        AssertionError error;
        this.printlnAlways("\t  Comprobando que " + nombreTipoBarco + " está donde debe estar");
        Barco barco = jugador.getTablero().getCasillas().get(posComienzo);
        if (barco == null) {
            error = this.sAssertTrue(false, 0, "Error. En la posición "
                    + posComienzo + " no se ha encontrado ningún "
                    + "barco. Debería haber un(a) " + nombreTipoBarco);
            toThrow = this.toThrow(error, toThrow);
        } else {
            error = this.sAssertTrue(barco.getClass().equals(barcoArg.getClass()),
                    valorTotal / numTests, "Error. Hay un barco en "
                    + posComienzo + " pero no es " + nombreTipoBarco + ", es "
                    + barco.getClass().getSimpleName());
            toThrow = this.toThrow(error, toThrow);
            if (error == null) {
                Set<String> posBarco = new HashSet(barco.getPosiciones());
                toThrow = this.toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el/la "
                        + nombreTipoBarco + " ocupa las casillas que debe ocupar");
                error = this.sAssertEquals(casillasBarcoRef, posBarco,
                        valorTotal / numTests, "Error. El barco no ocupa las "
                        + "casillas que debería " + casillasBarcoRef
                        + "; ocupa " + posBarco);
                toThrow = this.toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que las casillas del tablero que "
                        + "deben estar ocupadas por el/la " + nombreTipoBarco
                        + " lo/la referencian");
                Tablero tablero = jugador.getTablero();
                for (String pos : casillasBarcoRef) {
                    error = this.sAssertEquals(barco, tablero.getCasillas().get(pos),
                            valorTotal / numTests, "Error. La casilla " + pos
                            + " no parece referenciar al (a la) " + nombreTipoBarco);
                    toThrow = this.toThrow(error, toThrow);
                }
            }

        }

    }

    private void checkBarcosCorrectos(JugadorHumano jugador, double valorTotal,
            int numTests, AssertionError toThrow, double puntosAntes) throws Exception {
        AssertionError error;
        Tablero tablero = jugador.getTablero();
        if (tablero == null) {
            error = this.sAssertTrue(false, 0, "Error. El jugador no tiene tablero");
            toThrow = this.toThrow(error, toThrow);
            return;
        }
        this.printlnAlways("\tComprobando que hay 22 casillas que contienen un "
                + "trozo de un barco o un barco entero de una casilla");
        Map<String, Barco> casillasJug = tablero.getCasillas();
        error = this.sAssertEquals(22, casillasJug.size(), valorTotal / numTests,
                "Error. El tablero del jugador DEBERÍA tener barcos en 22 "
                + "casillas, pero en su lugar tiene barcos en " + casillasJug.size());
        toThrow = this.toThrow(error, toThrow);
        int[] numBarcosPorTipo = new int[5];
        Set<Barco> barcos = new HashSet<>();
        for (Barco barco : casillasJug.values()) {
            if (!barcos.contains(barco)) {
                barcos.add(barco);
            }
        }
        for (Barco barco : barcos) {
            numBarcosPorTipo[barco.getLon() - 1] += 1;
        }
        //
        this.printlnAlways("\tComprobando que hay 3 Lanchas");
        error = this.sAssertEquals(numBarcosPorTipo[0], 3, valorTotal / numTests,
                "Error. Al parecer NO hay 3 Lanchas en el tablero sino "
                + numBarcosPorTipo[0]);
        toThrow = this.toThrow(error, toThrow);
        //
        this.printlnAlways("\tComprobando que hay 2 Cruceros");
        error = this.sAssertEquals(numBarcosPorTipo[1], 2, valorTotal / numTests,
                "Error. Al parecer NO hay 2 Cruceros en el tablero sino "
                + numBarcosPorTipo[1]);
        toThrow = this.toThrow(error, toThrow);
        //
        this.printlnAlways("\tComprobando que hay 2 Submarinos");
        error = this.sAssertEquals(numBarcosPorTipo[2], 2, valorTotal / numTests,
                "Error. Al parecer NO hay 2 Submarinos en el tablero sino "
                + numBarcosPorTipo[2]);
        toThrow = this.toThrow(error, toThrow);
        //
        this.printlnAlways("\tComprobando que hay 1 Buque");
        error = this.sAssertEquals(numBarcosPorTipo[3], 1, valorTotal / numTests,
                "Error. Al parecer NO hay 1 Buque en el tablero sino "
                + numBarcosPorTipo[3]);
        toThrow = this.toThrow(error, toThrow);
        //
        this.printlnAlways("\tComprobando que hay 1 Portaviones");
        error = this.sAssertEquals(numBarcosPorTipo[4], 1, valorTotal / numTests,
                "Error. Al parecer NO hay 1 Portaviones en el tablero sino "
                + numBarcosPorTipo[4]);
        toThrow = this.toThrow(error, toThrow);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class Posicion2Test extends ReductorTraza {

    @Mock
    private Posicion mockPos;

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public Posicion2Test() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        Posicion2Test.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Posicion2Test");
        nota.put("Posicion2Test", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
        this.mockPos = Mockito.mock(Posicion.class);
    }

    @Test
    public void test01_checkNoContactaConOtro() {
        double valorTotal = 2.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int totTests = 891;
        this.printlnAlways("\nComprobando Posicion::checkNoContactaConOtro(..). "
                + "Valor: " + valorTotal);
        try {
            Tablero tablero = new Tablero();
            Barco lancha = new Lancha("lancha1");
            Optional optCasillas = this.getPrivateFieldValue(tablero, "casillas");
            if (!optCasillas.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
                return;
            }
            Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
            casillas.put("D6", lancha);
            this.printlnAlways("  Comprobaciones con barcos de 1 casilla");
            int numTests = this.scanNoHayContacto("D6", 1, Posicion.VERTICAL,
                    0, tablero, valorTotal / totTests, toThrow);
            //
            for (int i = 2; i < 6; i++) {
                try {
                    this.printlnAlways("  Comprobaciones con barcos de " + i + " casillas");
                    numTests = this.testContactoNoContactoConLon("D6", i,
                            0, tablero, valorTotal / totTests, toThrow);
                } catch (PositionException ex) {
                    error = this.sAssertTrue(false, 0, "Error. El método "
                            + "Posicion.esCorrecta(\"D6\") ha devuelto true.");
                    toThrow = this.toThrow(error, toThrow);
                }
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

    public int testContactoNoContactoConLon(String posBarco, int lon,
            int numTestsPrev, Tablero tablero,
            double valor, AssertionError toThrow) throws PositionException {
        if (!Posicion.esCorrecta(posBarco)) {
            throw new PositionException("La posición " + posBarco + " no "
                    + "es correcta");
        }
        int numTests = numTestsPrev;
        this.printlnAlways("\tComprobando todos los casos de contacto con barcos de " + lon + " casillas "
                + "dispuestos en vertical");
        numTests = this.scanHayContacto("D6", lon, "V", numTests, tablero,
                valor, toThrow);
        this.printlnAlways("\tComprobando todos los casos de no contacto con barcos de " + lon
                + " casillas dispuestos en vertical");
        numTests = this.scanNoHayContacto("D6", lon, "V", numTests, tablero,
                valor, toThrow);
        this.printlnAlways("\tComprobando todos los casos de contacto con barcos de" + lon + " casillas dispuestos en horizontal");
        numTests = this.scanHayContacto("D6", lon, "H", numTests, tablero,
                valor, toThrow);
        this.printlnAlways("\tComprobando todos los casos de no contacto con barcos de " + lon + " casillas dispuestos en horizontal");
        numTests = this.scanNoHayContacto("D6", lon, "H", numTests, tablero,
                valor, toThrow);
        return numTests;
    }

    private int scanNoHayContacto(String posBarco, int lon, String dir,
            int numTestsPrev, Tablero tablero, double valor, AssertionError toThrow) {
        if (!Posicion.esCorrecta(posBarco)) {
            return numTestsPrev + 1;
        }
        AssertionError error;
        int numTests = numTestsPrev;
        int filaBarco = Posicion.filaCharToInt(posBarco);
        int colBarco = Integer.parseInt(posBarco.substring(1));
        for (int fila = 1; fila < 11; fila++) {
            for (int col = 1; col < 11; col++) {
                int deltaFila = fila - filaBarco;
                int deltaCol = col - colBarco;
                //Esto debería eliminar posiciones de contacto de barcos 
                //con longitud lon
                String pos = "";
                if (this.condicionNoTocar(deltaFila, deltaCol, lon, dir)) {
                    try {
                        numTests += 1;
                        pos = Posicion.filaIntToFilaChar(fila)
                                + String.valueOf(col);
                        Posicion.checkNoContactaConOtro(pos, lon, dir, tablero);
                        error = this.sAssertTrue(true, valor,
                                "Error. La posición " + pos + " contacta con algo en "
                                + "el tablero, pero el método dice que no lo hace");
                        toThrow = this.toThrow(error, toThrow);
                    } catch (PositionException ex) {
                        error = this.sAssertTrue(false, 0, "Error. La posición "
                                + pos + " no contacta con nada en el tablero, pero el "
                                + "método dice que sí");
                        toThrow = this.toThrow(error, toThrow);
                    }
                }
            }
        }
        return numTests;
    }

    private int scanHayContacto(String posBarco, int lon, String dir,
            int numTestsPrev, Tablero tablero, double valor, AssertionError toThrow) {
        if (!Posicion.esCorrecta(posBarco)) {
            return numTestsPrev + 1;
        }
        AssertionError error;
        int numTests = numTestsPrev;
        int filaBarco = Posicion.filaCharToInt(posBarco);
        int colBarco = Integer.parseInt(posBarco.substring(1));
        for (int fila = 1; fila < 11; fila++) {
            for (int col = 1; col < 11; col++) {
                int deltaFila = fila - filaBarco;
                int deltaCol = col - colBarco;
                //Esto debería eliminar posiciones de contacto de barcos 
                //con longitud lon
                if (this.condicionTocar(deltaFila, deltaCol, lon, dir)) {
                    try {
                        numTests += 1;
                        String pos = Posicion.filaIntToFilaChar(fila)
                                + String.valueOf(col);
                        Posicion.checkNoContactaConOtro(pos, lon, dir, tablero);
                        error = this.sAssertTrue(false, 0,
                                "Error. La posición " + pos + " contacta con algo en "
                                + "el tablero, pero el método dice que no lo hace");
                        toThrow = this.toThrow(error, toThrow);
                    } catch (PositionException ex) {
                        error = this.sAssertTrue(true, valor, "");
                        toThrow = this.toThrow(error, toThrow);
                    }
                }
            }
        }
        return numTests;
    }

    public boolean condicionNoTocar(int deltaFila, int deltaCol,
            int lon, String dir) {
        int absDF = Math.abs(deltaFila);
        int absDC = Math.abs(deltaCol);
        if (dir.equals(Posicion.HORIZONTAL)) {
            //condición en columna será delta_col>lon, pero condición en 
            //fila será delta_fila>1
            if (deltaCol > 0) {
                return deltaCol > 1 || absDF > 1;
            } else {
                return absDC > lon || absDF > 1;
            }
        } else {
            //condición en vertical: delta_fila>lon o delta_col>1
            if (deltaFila > 0) {
                return deltaFila > 1 || absDC > 1;
            } else {
                return absDF > lon || absDC > 1;
            }
        }
    }

    public boolean condicionTocar(int deltaFila, int deltaCol,
            int lon, String dir) {
        return !condicionNoTocar(deltaFila, deltaCol, lon, dir);
    }

}

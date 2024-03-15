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
public class Tablero2Test extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public Tablero2Test() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        Tablero2Test.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Tablero2Test");
        nota.put("Tablero2Test", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_ponBarco() {
        double valorTotal = 7;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 70;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Tablero::pon_barco. Valor: " + valorTotal);
        String[][] posicionesTests = {
            {"E4", "E5", "E6", "E7", "E8"},
            {"E4", "F4", "G4", "H4", "I4"},
            {"A1", "B1"},
            {"A1", "A2"},
            {"A10", "B10"},
            {"A9", "A10"},
            {"I1", "J1"},
            {"J1", "J2"},
            {"I10", "J10"},
            {"J9", "J10"},};
        try {
            //
            this.printlnAlways("  Caso 1: portaviones en el centro sin otros "
                    + "barcos en horizontal");
            Tablero tablero = new Tablero();
            Barco barco = new Portaviones("Portaviones1");
            tablero.ponBarco(barco, "E4", "H");
            List<String> posiciones = Arrays.asList(posicionesTests[0]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 2: portaviones en el centro sin otros "
                    + "barcos en vertical");
            tablero = new Tablero();
            barco = new Portaviones("Portaviones1");
            tablero.ponBarco(barco, "E4", "V");
            posiciones = Arrays.asList(posicionesTests[1]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 3: crucero en A1 vertical");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "A1", "V");
            posiciones = Arrays.asList(posicionesTests[2]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 4: crucero en A1 horizontal");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "A1", "H");
            posiciones = Arrays.asList(posicionesTests[3]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 5: crucero en A10 vertical");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "A10", "V");
            posiciones = Arrays.asList(posicionesTests[4]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 6: crucero en A9 horizontal");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "A9", "H");
            posiciones = Arrays.asList(posicionesTests[5]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 7: crucero en I1 vertical");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "I1", "V");
            posiciones = Arrays.asList(posicionesTests[6]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 8: crucero en J1 horizontal");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "J1", "H");
            posiciones = Arrays.asList(posicionesTests[7]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 9: crucero en I10 vertical");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "I10", "V");
            posiciones = Arrays.asList(posicionesTests[8]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 10: crucero en J9 horizontal");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            tablero.ponBarco(barco, "J9", "H");
            posiciones = Arrays.asList(posicionesTests[9]);
            this.checkBarcoEnCasillas(tablero, barco, posiciones, valorTotal,
                    numTests, toThrow);
            //
            this.printlnAlways("  Caso 11: comprobando que no se pone en "
                    + "posiciones incorrectas @1 (@ tiene como código un valor "
                    + "igual al del caracter A menos 1) -encima del tablero "
                    + "(izquierda)-");
            tablero = new Tablero();
            barco = new Crucero("Crucero1");
            try {
                tablero.ponBarco(barco, "@1", "H");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición '@1', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 12: comprobando que no se pone en "
                    + "posiciones incorrectas A0 -izquierda del tablero-");
            try {
                tablero.ponBarco(barco, "A0", "H");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición 'A0', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 13: comprobando que no se pone en "
                    + "posiciones incorrectas @10 (@ tiene como código un valor "
                    + "igual al del caracter A menos 1) -encima del tablero "
                    + "(derecha)-");
            try {
                tablero.ponBarco(barco, "@10", "H");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición '@10', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 14: comprobando que no se pone en "
                    + "posiciones incorrectas A10 -derecha del tablero-");
            try {
                tablero.ponBarco(barco, "A10", "H");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición 'A10', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 15: comprobando que no se pone en "
                    + "posiciones incorrectas. Crucero en J1 (V) "
                    + "-debajo del tablero (izquierda)-");
            try {
                tablero.ponBarco(barco, "J1", "V");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición 'J1', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 16: comprobando que no se pone en "
                    + "posiciones incorrectas. Crucero en J0 (H) "
                    + "-izquierda del tablero-");
            try {
                tablero.ponBarco(barco, "J0", "H");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición 'J0', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 17: comprobando que no se pone en "
                    + "posiciones incorrectas. Crucero en J10 (V) "
                    + "-debajo del tablero (derecha)-");
            try {
                tablero.ponBarco(barco, "J10", "V");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición 'J10', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("  Caso 18: comprobando que no se pone en "
                    + "posiciones incorrectas. Crucero en J10 (H) "
                    + "-derecha del tablero-");
            try {
                tablero.ponBarco(barco, "J10", "H");
                error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                        + "barco en la posición 'J10', que es incorrecta. "
                        + "El método Tablero::ponBarco debería haber lanzado "
                        + "una excepción PositionException, pero no lo ha hecho");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\n  Siguientes casos: comprobar si se ponen "
                    + "barcos cuando no se toca y cuando se toca con otros "
                    + "barcos.");
            this.printlnAlways("  Para ello se crea una lancha y se pone en el "
                    + "centro del tablero (E5). Después se crean otras lanchas "
                    + "y se intentan colocar en el tablero en posiciones de "
                    + "contacto...");
            tablero = new Tablero();
            barco = new Lancha("Lancha1");
            String posicionOr = "E5";
            String posicion;
            tablero.ponBarco(barco, posicionOr, "H");
            int caso = 18;
            Set<String> cars = new HashSet<>();
            cars.add("D");
            cars.add("E");
            cars.add("F");
            for (int i = 4; i < 7; i++) {
                for (String car : cars) {
                    caso++;
                    posicion = car + caso;
                    this.printlnAlways("  Caso " + caso + ": Comprobando que no "
                            + "se pone cuando toca. Lancha en '" + posicion + "'");
                    try {
                        tablero.ponBarco(barco, posicion, "H");
                        error = this.sAssertTrue(false, 0, "Error. Se ha puesto un "
                                + "barco en " + posicion + " tocando con "
                                + "una lancha que está en " + posicionOr
                                + ". Debería haber lanzado una excepción PositionException "
                                + "pero no lo ha hecho");
                        toThrow = this.toThrow(error, toThrow);
                    } catch (PositionException ex) {
                        error = this.sAssertTrue(true, valorTotal / numTests, "");
                        toThrow = this.toThrow(error, toThrow);
                    }
                }
            }
            this.printlnAlways("\n  Ahora se intentan colocar en el tablero en "
                    + "posiciones de NO contacto...");
            for (int i = 1; i < 3; i++) {
                String car;
                // tablero = this.nuevoTableroConBarco();
                if (i == 1) {
                    car = "C";
                } else {
                    car = "G";
                }
                for (int col = 3; col < 8; col++) {
                    tablero = this.nuevoTableroConBarco();
                    posicion = car + col;
                    caso++;
                    this.printlnAlways("  Caso " + caso + ": Comprobando que se "
                            + "pone cuando NO toca. Lancha en " + posicion);
                    try {
                        tablero.ponBarco(barco, posicion, "H");
                        error = this.sAssertTrue(true, valorTotal / numTests, "");
                        toThrow = this.toThrow(error, toThrow);
                    } catch (PositionException ex) {
                        error = this.sAssertTrue(false, 0, "Error. No se ha puesto un "
                                + "barco en " + posicion + ", posición que no toca con "
                                + "ningún otro barco. NO debería haber lanzado"
                                + "la excepción PositionException pero lo ha hecho");
                        toThrow = this.toThrow(error, toThrow);
                    }
                }
            }
            for (int i = 1; i < 3; i++) {
                int col;
                if (i == 1) {
                    col = 3;
                } else {
                    col = 7;
                }
                for (String car : cars) {
                    tablero = this.nuevoTableroConBarco();
                    posicion = car + col;
                    caso++;
                    this.printlnAlways("  Caso " + caso + ": Comprobando que se "
                            + "pone cuando NO toca. Lancha en " + posicion);
                    try {
                        tablero.ponBarco(barco, posicion, "H");
                        error = this.sAssertTrue(true, valorTotal / numTests, "");
                        toThrow = this.toThrow(error, toThrow);
                    } catch (PositionException ex) {
                        error = this.sAssertTrue(false, 0, "Error. No se ha puesto un "
                                + "barco en " + posicion + ", posición que no toca con "
                                + "ningún otro barco. NO debería haber lanzado"
                                + "la excepción PositionException pero lo ha hecho");
                        toThrow = this.toThrow(error, toThrow);
                    }
                }
            }
            this.printlnAlways("\n  Comprobar, cuando se pone un barco y cuando "
                    + "NO se pone, que los datos del barco son correctos");
            caso++;
            this.printlnAlways("  Caso " + caso + ": Comprobando que los datos "
                    + "del barco son correctos cuando se pone en el tablero en "
                    + "horizontal");
            tablero = this.nuevoTableroConBarco();
            barco = new Portaviones("Portaviones1");
            tablero.ponBarco(barco, "A1", "H");
            String[] expectedStr = {"A1", "A2", "A3", "A4", "A5"};
            List<String> expected = Arrays.asList(expectedStr);
            this.checkPosicionesDeBarco(barco, expected, valorTotal, numTests, toThrow);
            //
            caso++;
            this.printlnAlways("  Caso " + caso + ": Comprobando que los datos "
                    + "del barco son correctos cuando se pone en el tablero en "
                    + "vertical");
            barco = new Portaviones("Portaviones2");
            tablero.ponBarco(barco, "A10", "V");
            String[] expectedStr2 = {"A10", "B10", "C10", "D10", "E10"};
            expected = Arrays.asList(expectedStr2);
            this.checkPosicionesDeBarco(barco, expected, valorTotal, numTests, toThrow);
            //
            caso++;
            this.printlnAlways("  Caso " + caso + ": Comprobando que los datos "
                    + "del barco son correctos cuando NO se pone en el tablero");
            try {
                barco = new Portaviones("Portaviones2");
                tablero.ponBarco(barco, "J10", "V");
                this.sAssertTrue(false, 0, "Error. Se ha intentado poner un "
                        + "portaviones en J10 en vertical y el método "
                        + "NO ha lanzado una excepción");
                toThrow = this.toThrow(error, toThrow);
            } catch (PositionException ex) {
                Optional<Object> optPosiciones = this.getPrivateFieldValue(barco, "posiciones");
                if (!optPosiciones.isPresent()) {
                    this.finishIfAttrNotPresent("barco", "posicioens", puntosAntes);
                    return;
                }
                List<String> posicionesBarco = (List<String>) optPosiciones.get();
                this.sAssertTrue(posicionesBarco.size() == 0, valorTotal / numTests,
                        "Error. El barco no ha podido colocarse y sin embargo "
                        + "la lista de posiciones del barco NO está vacía");
                toThrow = this.toThrow(error, toThrow);
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

    protected void checkBarcoEnCasillas(Tablero tablero, Barco barco,
            List<String> posiciones, double valorTotal, int numTests, AssertionError toThrow) throws Exception {
        AssertionError error;
        Optional<Object> optCasillas = this.getPrivateFieldValue(tablero, "casillas");
        if (!optCasillas.isPresent()) {
            this.finishIfAttrNotPresent("tablero", "casillas", puntosTotales);
            return;
        }
        Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
        for (String posicion : posiciones) {
            error = this.sAssertTrue(casillas.get(posicion) == barco, valorTotal / numTests, "Error. En la casilla'"
                    + posicion + "' hay un barco, pero el método no ha devuelto su referencia");
            toThrow = this.toThrow(error, toThrow);
        }
    }

    protected void checkPosicionesDeBarco(Barco barco, List<String> posiciones,
            double valorTotal, int numTests, AssertionError toThrow)
            throws Exception {
        AssertionError error;
        Optional<Object> optPosiciones = this.getPrivateFieldValue(barco, "posiciones");
        if (!optPosiciones.isPresent()) {
            this.finishIfAttrNotPresent("barco", "posiciones", puntosTotales);
            return;
        }
        List<String> posicionesDeBarco = (List<String>) optPosiciones.get();
        for (String posicion : posiciones) {
            error = this.sAssertTrue(posicionesDeBarco.contains(posicion),
                    valorTotal / numTests, "Error. La posición " + posicion
                    + " no aparece en el barco como posición del mismo");
            toThrow = this.toThrow(error, toThrow);
        }
    }

    protected Tablero nuevoTableroConBarco() throws PositionException {
        Tablero tablero = new Tablero();
        Barco barco = new Lancha("Lancha1");
        String posicion = "E5";
        tablero.ponBarco(barco, posicion, "H");
        return tablero;
    }
}

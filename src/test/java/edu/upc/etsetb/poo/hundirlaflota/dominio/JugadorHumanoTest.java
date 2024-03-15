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
public class JugadorHumanoTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    private Tablero mockTablero;

    public JugadorHumanoTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        JugadorHumanoTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "JugadorHumanoTest");
        nota.put("JugadorHumanoTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 8;
        this.printlnAlways("\nComprobando JugadorHumano::JugadorHumano(..). Valor: " + valorTotal);
        try {
            Jugador jugador = new JugadorHumano("nombreJ");
            this.printlnAlways("\tComprobando el atributo \'nombre\'.");
            this.checkAttributeAfterConstructor(jugador, "nombre", "nombreJ",
                    valorTotal * 2 / numTests, 0.5, 0.5, 1);
            this.printlnAlways("\tComprobando atributo \'numBarcosHundidos\'.");
            this.checkAttributeAfterConstructor(jugador, "numBarcosHundidos", 0,
                    valorTotal * 2 / numTests, 0.5, 0.5, 1);
            this.printlnAlways("\tComprobando atributo \'tablero\'.");
            this.printlnAlways("\t   Test 1: comprobando que el atributo"
                    + " \'tablero\' existe");
            Optional optTablero = this.getPrivateFieldValue(jugador, "tablero");
            if (!optTablero.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
                return;
            }
            error = this.sAssertTrue(true, valorTotal / numTests, "");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t   Test2: Comprobando que el valor del "
                    + "atributo \'tablero\' no es null");
            Tablero tablero = (Tablero) optTablero.get();
            error = this.sAssertNotNull(tablero, valorTotal / numTests, "Error. "
                    + "El constructor debe crear un objeto tablero. Sin "
                    + "embargo, el atributo \'tablero\' es null");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando atributo \'visorDeAtaque\'.");
            this.printlnAlways("\t   Test 1: comprobando que el atributo"
                    + " \'visorDeAtaque\' existe");
            Optional<Object> optVisor = this.getPrivateFieldValue(jugador, "visorDeAtaque");
            if (!optVisor.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "visorDeAtaque", puntosAntes);
                return;
            }
            error = this.sAssertTrue(true, valorTotal / numTests, "");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t   Test2: Comprobando que el valor del "
                    + "atributo \'visorDeAtaque\' no es null");
            Map<String, String> visor = (Map<String, String>) optVisor.get();
            error = this.sAssertNotNull(visor, valorTotal / numTests, "Error. "
                    + "El constructor debe crear un mapa para el visor. Sin "
                    + "embargo, el atributo \'visorDeAtaque\' es null");
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
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando JugadorHumano::dispara(). Valor: " + valorTotal);
        try {
            this.println("\tComprobando que siempre devuelve 'ASK_USER'");
            JugadorHumano jugador = new JugadorHumano("UnNombre");
            String disparo = jugador.dispara();
            error = this.sAssertEquals("ASK_USER", disparo, valorTotal, "Error. El "
                    + "método no devuelve \"ASK_USER\", sino " + disparo);
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
    public void test03_procesaTocado() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando JugadorHumano::procesaTocado(). Valor: " + valorTotal);
        try {
            this.println("\tComprobando que siempre devuelve 'ASK_USER'");
            JugadorHumano jugador = new JugadorHumano("UnNombre");
            String disparo = jugador.procesaTocado("A1");
            error = this.sAssertEquals("ASK_USER", disparo, valorTotal, "Error. El "
                    + "método no devuelve \"ASK_USER\", sino " + disparo);
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
    public void test04_eresHumano() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando JugadorHumano::eresHumano(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea un Jugador con JugadorHumano(\"UnNombre\") y "
                    + "se invoca jugador.eresHumano()");
            Jugador jugador = new JugadorHumano("UnNombre");
            error = this.sAssertTrue(jugador.eresHumano() == true, valorTotal,
                    "Error. El método debería haber devuelto true, "
                    + "pero ha devuelto " + jugador.eresHumano());
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
    public void test05_getTablero() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando JugadorHumano::getTablero(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tComprobando que devuelve la referencia al "
                    + "tablero");
            JugadorHumano jugador = new JugadorHumano("unNombre");
            Optional<Object> optTablero = this.getPrivateFieldValue(jugador, "tablero");
            if (!optTablero.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
                return;
            }
            Tablero expected = (Tablero) optTablero.get();
            error = this.sAssertEquals(expected, jugador.getTablero(),
                    valorTotal, "Error. El método no ha retornado la referencia "
                    + "que aparece en el atributo 'tablero'");
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
    public void test06_getVisorDeAtaque() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando JugadorHumano::getVisorDeAtaque(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tComprobando que devuelve la referencia al "
                    + "tablero");
            JugadorHumano jugador = new JugadorHumano("unNombre");
            Optional<Object> optvAtaque = this.getPrivateFieldValue(jugador, "visorDeAtaque");
            if (!optvAtaque.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "visorDeAtaque", puntosAntes);
                return;
            }
            Map<String, String> expected = (Map<String, String>) optvAtaque.get();
            error = this.sAssertEquals(expected, jugador.getVisorDeAtaque(),
                    valorTotal, "Error. El método no ha retornado la referencia "
                    + "que aparece en el atributo 'visorDeAtaque'");
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
    public void test07_anotaDisparoAjeno() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 4;
        this.printlnAlways("\nComprobando JugadorHumano::anotaDisparoAjeno(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: el disparo ha sido un disparo a Agua");
            this.printlnAlways("\tComprobando que la posición de disparo se ha "
                    + "añadido al atributo \'disparos_a_agua\' del tablero del "
                    + "jugador");
            JugadorHumano jugador = new JugadorHumano("UnNombre");
            jugador.anotaDisparoAjeno("A6", Jugador.AGUA);
            Optional<Object> optTablero = this.getPrivateFieldValue(jugador, "tablero");
            if (!optTablero.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
                return;
            }
            Tablero tablero = (Tablero) optTablero.get();
            Optional<Object> optDAgua = this.getPrivateFieldValue(tablero, "disparosAAgua");
            if (!optDAgua.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "disparosAAgua", puntosAntes);
                return;
            }
            List<String> dispAAgua = (List<String>) optDAgua.get();

            error = this.sAssertTrue(dispAAgua.contains("A6"), valorTotal / numTests,
                    "Error. Se ha disparado a Agua en A6 pero el atributo "
                    + "\'disparosAAgua\' del tablero del jugador humano "
                    + "no contiene la posición A6");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: el disparo ha TOCADO un barco");
            this.printlnAlways("\t  Comprobando que el barco tocado en esa "
                    + "posición añade la posición a su atributo \'posicionesTocadas\'");
            Barco barco = new Crucero("Crucero1");
            Optional<Object> optCasillas = this.getPrivateFieldValue(tablero, "casillas");
            if (!optCasillas.isPresent()) {
                this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
                return;
            }
            Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();

            casillas.put("A3", barco);
            casillas.put("A4", barco);
            jugador.anotaDisparoAjeno("A3", Jugador.TOCADO);
            Barco barcoTocado = casillas.get("A3");
            Optional<Object> optPTocadas = this.
                    getPrivateFieldValue(barcoTocado, "posicionesTocadas");
            if (!optPTocadas.isPresent()) {
                this.finishIfAttrNotPresent("barcoTocado", "posicionesTocadas", puntosAntes);
                return;
            }
            Set<String> pTocadas = (Set<String>) optPTocadas.get();

            error = this.sAssertTrue(pTocadas.contains("A3"), valorTotal / numTests,
                    "Error. Se ha tocado a un barco en A3 pero el barco que está en las "
                    + "posiciones [A3,A4] no tiene A3 en su atributo \'posicionesTocadas\'");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 3: el disparo ha HUNDIDO un barco");
            this.printlnAlways("\t  Comprobando que el barco tocado en esa "
                    + "posición añade la posición a su atributo \'pos_tocadas\'");
            jugador.anotaDisparoAjeno("A4", Jugador.HUNDIDO);
            Barco barcoHundido = casillas.get("A4");
            error = this.sAssertTrue(pTocadas.contains("A4"), valorTotal / numTests,
                    "Error. Se ha hundido a un barco en A4 pero el barco que está en las "
                    + "posiciones [A3,A4] no tiene A4 en su atributo \'posicionesTocadas\'");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Comprobando que el barco hundido en esa "
                    + "posición asigna el valor true a su atributo \'hundido\'");
            Optional<Object> optHundido = this.
                    getPrivateFieldValue(barcoHundido, "hundido");
            if (!optHundido.isPresent()) {
                this.finishIfAttrNotPresent("barco hundido", "hundido", puntosAntes);
                return;
            }
            boolean hundido = (boolean) optHundido.get();
            error = this.sAssertTrue(hundido, valorTotal / numTests,
                    "Error. Se ha hundido a un barco en [A3,A4] pero el código "
                    + "no ha asignado a su atributo \'humdido\' el valor true");
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
    public void test08_anotaDisparoPropio() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 3;
        this.printlnAlways("\nComprobando JugadorHumano::anotaDisparoPropio(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: el disparo ha resultado en Agua");
            this.printlnAlways("\t  Comprobando el atributo \'visorDeAtaque\' "
                    + "del jugador pone 'A' en la posición atacada");
            JugadorHumano jugador = new JugadorHumano("UnNombre");
            jugador.anotaDisparoPropio("A6", Jugador.AGUA);
            Optional<Object> optvAtaque = this.getPrivateFieldValue(jugador, "visorDeAtaque");
            if (!optvAtaque.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "visorDeAtaque", puntosAntes);
                return;
            }
            Map<String, String> visorDeAtaque = (Map<String, String>) optvAtaque.get();
            error = this.sAssertEquals("A", visorDeAtaque.get("A6"),
                    valorTotal / numTests, "Error. Se ha disparado a Agua en A6 "
                    + "pero el atributo \'visorDeAtaque\' del jugador "
                    + "humano no contiene \"A\" en la posición atacada");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: el disparo ha resultado en Tocado");
            this.printlnAlways("\t  Comprobando el atributo \'visorDeAtaque\' "
                    + "del jugador pone 'T' en la posición atacada");
            jugador.anotaDisparoPropio("A6", Jugador.TOCADO);
            error = this.sAssertEquals("T", visorDeAtaque.get("A6"),
                    valorTotal / numTests, "Error. Se ha tocado a un barco en A6 "
                    + "pero el atributo \'visorDeAtaque\' del jugador "
                    + "humano no contiene \"T\" en la posición atacada");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 3: el disparo ha resultado en Hundido");
            this.printlnAlways("\t  Comprobando el atributo \'visorDeAtaque\' "
                    + "del jugador pone 'H' en la posición atacada");
            jugador.anotaDisparoPropio("A6", Jugador.HUNDIDO);
            error = this.sAssertEquals("H", visorDeAtaque.get("A6"),
                    valorTotal / numTests, "Error. Se ha tocado a un barco en A6 "
                    + "pero el atributo \'visorDeAtaque\' del jugador "
                    + "humano no contiene \"H\" en la posición atacada");
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
    public void test09_procesaHundido() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 2;
        this.printlnAlways("\nComprobando JugadorHumano::procesaHundido(). Valor: " + valorTotal);
        try {
            JugadorHumano jugador = new JugadorHumano("UnNombre");
            Optional<Object> optNBHundidos = this.getPrivateFieldValue(jugador,
                    "numBarcosHundidos");
            if (!optNBHundidos.isPresent()) {
                this.finishIfAttrNotPresent("jugador humano", "numBarcosHundidos", puntosAntes);
                return;
            }
            int antes = (int) optNBHundidos.get();
            String result = jugador.procesaHundido("A6", 9);
            this.printlnAlways("\tSe comprueba que el número de barcos hundidos "
                    + "se ha incrementado en uno");
            int despues = (int) this.getPrivateFieldValue(jugador, ""
                    + "numBarcosHundidos").get();
            error = this.sAssertEquals(antes + 1, despues, valorTotal / 2,
                    "Error. El método no incrementa el valor del atributo "
                    + "\'numBarcosHundidos\' en una unidad");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tSe comprueba que siempre devuelve \"ASK_USER\"");
            error = this.sAssertEquals("ASK_USER", result, valorTotal / 2,
                    "Error. El método no retorna \"ASK_USER\" sino " + result);
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
    public void test10_hasDisparadoAquiAntes() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 2;
        this.printlnAlways("\nComprobando JugadorHumano::hasDisparadoAquiAntes(). Valor: " + valorTotal);
        try {
            JugadorHumano jugador = new JugadorHumano("UnNombre");
            Optional<Object> optvAtaque = this.getPrivateFieldValue(jugador, "visorDeAtaque");
            if (!optvAtaque.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "visorDeAtaque", puntosAntes);
                return;
            }
            Map<String, String> visorDeAtaque = (Map<String, String>) optvAtaque.get();
            visorDeAtaque.put("A1", "A");
            this.printlnAlways("\tComprobando si devuelve true cuando se le "
                    + "pasa una posición que está en el visor de disparos");
            error = this.sAssertTrue(jugador.hasDisparadoAquiAntes("A1"),
                    valorTotal / numTests, "Error. Debería haber devuelto true, "
                    + "pero ha devuelto false");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tComprobando si devuelve false cuando se le "
                    + "pasa una posición que NO está en el visor de disparos");
            error = this.sAssertFalse(jugador.hasDisparadoAquiAntes("A2"),
                    valorTotal / numTests, "Error. Debería haber devuelto false, "
                    + "pero ha devuelto true");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.lang.reflect.Field;
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
import org.mockito.Mockito;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class JugadorTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    private Tablero mockTablero;

    public JugadorTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        JugadorTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "JugadorTest");
        nota.put("JugadorTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 2.1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Jugador::Jugador(..). Valor: " + valorTotal);
        try {
            Jugador jugador = new JugadorHumano("nombreJ");
            this.printlnAlways("\tComprobando atributo \'nombre\'.");
            this.checkAttributeAfterConstructor(jugador, "nombre", "nombreJ",
                    valorTotal / 3, 0.5, 0.5, 1);
            this.printlnAlways("\tComprobando atributo \'numBarcosHundidos\'.");
            this.checkAttributeAfterConstructor(jugador, "numBarcosHundidos", 0,
                    valorTotal / 3, 0.5, 0.5, 1);
            this.printlnAlways("\tComprobando atributo \'tablero\'.");
            this.printlnAlways("\tTest 1: comprbación de existencia del atributo"
                    + " \'tablero\'");
            Optional optTablero = this.getPrivateFieldValue(jugador, "tablero");
            if (!optTablero.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
                return;
            }
            error = this.sAssertTrue(true, valorTotal / 6, "");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tComprobando que el valor del "
                    + "atributo \'tablero\' no es null");
            Tablero tablero = (Tablero) optTablero.get();
            error = this.sAssertNotNull(tablero, valorTotal / 6, "Error. "
                    + "El constructor debe crear un objeto tablero. Sin "
                    + "embargo, el atributo \'tablero\' es null");
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
    public void test02_getNombre() {
        double valorTotal = 0.9;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Jugador::getNombre(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea un Jugador con Jugador(\'UnNombre\') "
                    + "y se invoca a jugador.get_nombre()");
            Jugador jugador = new JugadorHumano("UnNombre");
            error = this.sAssertEquals("UnNombre", jugador.getNombre(),
                    valorTotal, "Error. El método getNombre() debería haber "
                    + "devuelto \'UnNombre'. Sin embargo, ha devuelto "
                    + "\'" + jugador.getNombre() + "\'");
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
    public void test03_ponBarco() {
        double valorTotal = 2.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Jugador::ponBarco(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: Se crea un objeto Jugador, se crea un "
                    + "Crucero en A1, A2 y A3 y se mira si se ha colocado "
                    + "correctamente");
            Jugador jugador = new JugadorHumano("UnNombre");
            Barco barco = new Submarino("submarino1");
            jugador.ponBarco(barco, "A1", Posicion.HORIZONTAL);
            Optional optTablero = this.getPrivateFieldValue(jugador, "tablero");
            if (!optTablero.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
                return;
            }
            Tablero tablero = (Tablero) optTablero.get();
            for (int i = 1; i < 4; i++) {
                String pos = "A" + i;
                Barco barcoEnPos = tablero.getBarcoEn(pos);
                error = this.sAssertEquals(barco, barcoEnPos, 0.7 / 3, "Error. "
                        + "El método no ha recuperado el barco que se había "
                        + "depositado en la poscición " + pos);
                toThrow = this.toThrow(error, toThrow);
            }
            this.printlnAlways("\tCaso 2: Se crea un Crucero en C1, se trata "
                    + "de disponerlo horizontalmente y se comprueba que el "
                    + "método NO ha lanzado una excepción PositionException");
            try {
                barco = new Crucero("Crucero2");
                jugador.ponBarco(barco, "C1", Posicion.HORIZONTAL);
                error = this.sAssertTrue(true, 0.7, "");
                toThrow = this.toThrow(error, error);
            } catch (PositionException ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método Jugador::poBarco(...) NO debería "
                        + "haber lanzado PositionException, pero lo ha "
                        + "hecho.");
                toThrow = toThrow(error, toThrow);
            }
            this.printlnAlways("\tCaso 3: Se crea un Crucero en B10, se trata "
                    + "de disponerlo horizontalmente y se comprueba si el "
                    + "método lanza una excepción PositionException");
            try {
                barco = new Crucero("OtroCrucero");
                jugador.ponBarco(barco, "B10", Posicion.HORIZONTAL);
                error = this.sAssertTrue(false, 0,
                        "\nEl método Jugador::poBarco(...) debería "
                        + "haber lanzado PositionException, pero no lo ha "
                        + "hecho.");
                toThrow = toThrow(error, toThrow);
            } catch (PositionException ex) {
                error = this.sAssertTrue(true, 0.7, "");
                toThrow = this.toThrow(error, error);
            }

            this.printlnAlways("\tCasot 4: Se comprueba si el método ha invocado "
                    + "al método de Tablero que debía invocar");
            this.mockTablero = Mockito.mock(Tablero.class);
            this.setPrivateField(jugador, "tablero", this.mockTablero);
            Mockito.spy(jugador);
            jugador.ponBarco(barco, "C1", Posicion.HORIZONTAL);
            try {
                Mockito.verify(this.mockTablero).ponBarco(barco, "C1", Posicion.HORIZONTAL);
                error = this.sAssertTrue(true, 0.4, "");
                toThrow = this.toThrow(error, error);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "\nEl método Jugador::poBarco(...) debería "
                        + "invocar a Tablero::ponBarco(...), con los argumentos "
                        + "precisos, pero no lo hace.");
                toThrow = toThrow(error, toThrow);

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
    public void test04_dondeHanDado() {
        double valorTotal = 0.9;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 5;
        this.printlnAlways("\nComprobando Jugador::dondeHanDado(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: se ha tirado al agua. En el tablero no hay ningún barco");
            Jugador jugador = new JugadorHumano("UnNombre");
            Optional<Object> optTablero = this.getPrivateFieldValue(jugador, "tablero");
            if (!optTablero.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
                return;
            }
            Tablero tablero = (Tablero) optTablero.get();
            String resultado = jugador.dondeHanDado("A1");
            error = this.sAssertEquals(Jugador.AGUA, resultado,
                    valorTotal / numTests, "Error. El método no ha devuelto "
                    + "\'A\', sino \'" + resultado + "\'");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tCaso 2: Se coloca un crucero en el "
                    + "tablero (A5,A6) y se dispara a A5. Se comprueba que "
                    + "devuelve Jugador.TOCADO ('T')");
            Barco barco = new Crucero("Crucero");
            tablero.getCasillas().put("A5", barco);
            tablero.getCasillas().put("A6", barco);
            resultado = jugador.dondeHanDado("A5");
            this.printlnAlways("\t  Se comprueba que el método devuelve "
                    + "Jugador.tocado (\'T\')");
            error = this.sAssertEquals(Jugador.TOCADO, resultado, valorTotal / numTests,
                    "Error. El disparo ha tocado al crucero, sin embargo, el "
                    + "método ha devuelto " + resultado);
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Se comprueba que el atributo posicionesTocadas del "
                    + "barco tiene como valor el conjunto {\"A5\"}");
            Set<String> esperado = new HashSet<>();
            esperado.add("A5");

            Optional<Object> optPosTocadas = this.getPrivateFieldValue(barco,
                    "posicionesTocadas");
            if (!optPosTocadas.isPresent()) {
                this.finishIfAttrNotPresent("barco", "posicionesTocadas", puntosAntes);
                return;
            }
            Set<String> posicionesTocadas = (Set<String>) optPosTocadas.get();
            error = this.sAssertEquals(esperado, posicionesTocadas, valorTotal / numTests,
                    "Error. El disparo ha tocado al crucero en la posición "
                    + "\"A5\", y el atributo pos_tocadas del barco "
                    + "debiera ser el conjunto {\"A5\"}, sin embargo "
                    + "es " + posicionesTocadas);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 3: Se dispara a A6. Se comprueba que "
                    + "devuelve Jugador.HUNDIDO ('H')");
            resultado = jugador.dondeHanDado("A6");
            esperado.add("A6");
            this.printlnAlways("\t  Se comprueba que el método devuelve "
                    + "Jugador.tocado (\'H\')");
            error = this.sAssertEquals(Jugador.HUNDIDO, resultado, valorTotal / numTests,
                    "Error. El disparo ha hundido al crucero, sin embargo, el "
                    + "método ha devuelto " + resultado);
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Se comprueba que el atributo posicionesTocadas del "
                    + "barco tiene como valor el conjunto {\"A5\",\"A6\"}");
            error = this.sAssertEquals(esperado, posicionesTocadas, valorTotal / numTests,
                    "Error. El disparo ha hundido al crucero que ocupa las "
                    + "posiciones {\"A5\",\"A6\"}, y el atributo "
                    + "posicionesTocadas del barco debiera ser este conjunto, "
                    + "sin embargo es " + posicionesTocadas);
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
    public void test05_eresHumano() {
        double valorTotal = 0.9;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 5;
        this.printlnAlways("\nComprobando Jugador::eresHumano(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea un Jugador con Jugador(\"UnNombre\") y "
                    + "se invoca jugador.eres_humano()");
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
    public void test06_getNumBarcosHundidos() {
        double valorTotal = 0.9;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 2;
        this.printlnAlways("\nComprobando Jugador::getNumBarcosHundidos(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: se crea un Jugador con Jugador(\"UnNombre\"), "
                    + "y se invoca jugador.getNumBarcosHundidos()");
            Jugador jugador = new JugadorHumano("UnNombre");
            Optional<Field> optNBarcosHundidosF = this.getPrivateField(jugador, "numBarcosHundidos");
            if (!optNBarcosHundidosF.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "numBarcosHundidos", puntosAntes);
                return;
            }
            Optional<Object> optNBarcosHundidosV = this.getPrivateFieldValue(jugador, "numBarcosHundidos");
            Integer nBarcosHundidos = (Integer) optNBarcosHundidosV.get();
            error = this.sAssertEquals(0, jugador.getNumBarcosHundidos(), valorTotal / numTests,
                    "Error. El método debería haber devuelto 0, "
                    + "pero ha devuelto " + jugador.getNumBarcosHundidos());
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: se crea un Jugador con Jugador(\"UnNombre\"), "
                    + "se pone el atributo \'numBarcosHundidos\' a 3 y "
                    + "se invoca jugador.getNumBarcosHundidos()");
            jugador = new JugadorHumano("UnNombre");
            optNBarcosHundidosF = this.getPrivateField(jugador, "numBarcosHundidos");
            if (!optNBarcosHundidosF.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "numBarcosHundidos", puntosAntes);
                return;
            }
            Field nBarcosHundidosF = optNBarcosHundidosF.get();
            nBarcosHundidosF.setAccessible(true);
            nBarcosHundidosF.setInt(jugador, 3);
            error = this.sAssertEquals(3, jugador.getNumBarcosHundidos(), valorTotal / numTests,
                    "Error. El método debería haber devuelto 3, "
                    + "pero ha devuelto " + jugador.getNumBarcosHundidos());
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
    public void test07_procesaHundido() {
        double valorTotal = 0.9;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 2;
        this.printlnAlways("\nComprobando Jugador::procesaHundido(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: Se crea un Jugador, se invoca a este método y "
                    + "se comprueba si hace lo especificado");
            Jugador jugador = new JugadorHumano("UnNombre");
            jugador.procesaHundido("A6", 9);
            Optional<Object> optNBarcosHundidosV = this.getPrivateFieldValue(jugador, "numBarcosHundidos");
            if (!optNBarcosHundidosV.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "numBarcosHundidos", puntosAntes);
                return;
            }
            int retrieved = (Integer) optNBarcosHundidosV.get();
            error = this.sAssertEquals(1, retrieved, valorTotal / numTests,
                    "Error. El método debería haber puesto el atributo "
                    + "'numBarcosHundidos' a 1, pero lo ha puesto a " + retrieved);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: se invoca de nuevo a este método y "
                    + "se comprueba si hace lo especificado");
            jugador.procesaHundido("C6", 9);
            optNBarcosHundidosV = this.getPrivateFieldValue(jugador,
                    "numBarcosHundidos");
            if (!optNBarcosHundidosV.isPresent()) {
                this.finishIfAttrNotPresent("jugador", "numBarcosHundidos", puntosAntes);
                return;
            }
            retrieved = (Integer) optNBarcosHundidosV.get();
            error = this.sAssertEquals(2, retrieved, valorTotal / numTests,
                    "Error. El método debería haber puesto el atributo "
                    + "'numBarcosHundidos' a 2, pero lo ha puesto a " + retrieved);
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
    public void test08_hasDisparadoAquiAntes() {
        double valorTotal = 0.9;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 5;
        this.printlnAlways("\nComprobando Jugador::hasDisparadoAquiAntes(). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tSe crea un Jugador con Jugador(\"UnNombre\") y "
                    + "e invoca a este método y se comprueba si devuelve false");
            Jugador jugador = new JugadorHumano("UnNombre");
            boolean returned = jugador.hasDisparadoAquiAntes("A1");
            error = this.sAssertFalse(returned, valorTotal,
                    "Error. El método debería haber devuelto false, "
                    + "pero ha devuelto " + returned);
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

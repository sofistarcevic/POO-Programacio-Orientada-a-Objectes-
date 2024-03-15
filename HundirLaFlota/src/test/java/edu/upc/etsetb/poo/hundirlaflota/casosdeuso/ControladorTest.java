/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.casosdeuso;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Barco;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Buque;
import edu.upc.etsetb.poo.hundirlaflota.dominio.GeneradorDeFlotas;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Jugador;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorHumano;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorMaquina;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Lancha;
import edu.upc.etsetb.poo.hundirlaflota.dominio.PositionException;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Submarino;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Tablero;
import edu.upc.etsetb.poo.hundirlaflota.iu.Entregador;
import edu.upc.etsetb.poo.hundirlaflota.iu.Gui;
import edu.upc.poo.corrector.TestAll;
import java.util.ArrayList;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.exceptions.verification.NeverWantedButInvoked;
import org.mockito.exceptions.verification.TooLittleActualInvocations;
import org.mockito.exceptions.verification.TooManyActualInvocations;
import org.mockito.exceptions.verification.WantedButNotInvoked;
import org.mockito.exceptions.verification.junit.ArgumentsAreDifferent;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class ControladorTest extends ReductorTraza implements IObservadorObservado {

    private Controlador mockControlador;

    private GeneradorDeFlotas mockGeneradorDeFlotas;

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public ControladorTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        ControladorTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "ControladorTest");
        nota.put("ControladorTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 13;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::Controlador(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);

            this.printlnAlways("\tComprobando que existe atributo 'iu'.");
            error = this.checkPrivateFieldIsOfASpecificClass(controlador,
                    "iu", Gui.class, valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'jugadores'.");

            error = this.checkIfPrivateAtrributeIsDescendantOfAClass(controlador, "jugadores",
                    List.class, valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'random'.");
            error = this.checkPrivateFieldIsOfASpecificClass(controlador, ""
                    + "random", MyRandom.class, valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'atacante'.");
            error = this.checkPrivateFieldExists(controlador, "atacante", valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'atacado'.");
            error = this.checkPrivateFieldExists(controlador, "atacado", valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'renderer'.");
            error = this.checkPrivateFieldIsOfASpecificClass(controlador, "renderer", Entregador.class, valorTotal / numTests, toThrow);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que existe atributo 'generadorFlotas'.");
            error = this.checkPrivateFieldIsOfASpecificClass(controlador, "generadorFlotas", GeneradorDeFlotas.class, valorTotal / numTests, toThrow);
            //
            this.printlnAlways("\tComprobando que el valor del atributo 'iu' es el pasado como argumento.");
            toThrow = this.toThrow(error, toThrow);
            Optional<Object> optAtr = this.getPrivateFieldValue(controlador, "iu");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "iu", puntosAntes);
                return;
            }
            Gui iuAttr = (Gui) optAtr.get();
            error = this.sAssertEquals(iu, iuAttr, valorTotal / numTests, "Error. El "
                    + "atributo 'iu' no tiene el valor esperado");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el atributo 'jugadores' es una lista vacía");
            optAtr = this.getPrivateFieldValue(controlador, "jugadores");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "jugadores", puntosAntes);
                return;
            }
            List<Jugador> jugadores = (List<Jugador>) optAtr.get();
            error = this.sAssertEquals(0, jugadores.size(), valorTotal / numTests,
                    "Error. El atributo 'jugadores' debe ser una lista "
                    + "vacía pero en su lugar tiene " + jugadores.size() + " elementos");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el valor del atributo "
                    + "'random' no es null (se ha creado el objeto random)");
            optAtr = this.getPrivateFieldValue(controlador, "random");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "random", puntosAntes);
                return;
            }
            MyRandom random = (MyRandom) optAtr.get();
            error = this.sAssertNotNull(random, valorTotal / numTests,
                    "El atributo 'random' es null, y NO debería serlo.");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el valor del atributo 'atacante' es null.");
            optAtr = this.getPrivateFieldValue(controlador, "atacante");
            if (!optAtr.isPresent()) {
                this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } else {
                this.sAssertTrue(false, valorTotal / numTests, "El "
                        + "atributo 'atacante' NO es null, y DEBERÍA serlo.");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\tComprobando que el valor del atributo 'atacado' es null.");
            optAtr = this.getPrivateFieldValue(controlador, "atacante");
            if (!optAtr.isPresent()) {
                this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } else {
                this.sAssertTrue(false, valorTotal / numTests, "El "
                        + "atributo 'atacado' NO es null, y DEBERÍA serlo.");
                toThrow = this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\tComprobando que el valor del atributo "
                    + "'renderer' es el pasado como argumento.");
            optAtr = this.getPrivateFieldValue(controlador, "renderer");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "renderer", puntosAntes);
                return;
            }
            Entregador rendererAtr = (Entregador) optAtr.get();
            error = this.sAssertEquals(renderer, rendererAtr,
                    valorTotal / numTests, "Error. El atributo 'renderer' "
                    + "recuperado del controlador no es el mismo objeto "
                    + "que se pasó como argumento al constructor");
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
    public void test02_preparaJugadorMaquinaFlotaDet() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaJugadorMaquinaFlotaDet(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            Controlador contrEspiado = Mockito.spy(controlador);
            Optional<Object> optAtr = this.getPrivateFieldValue(contrEspiado, "generadorFlotas");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "generadorFlotas", puntosAntes);
                return;
            }
            GeneradorDeFlotas genFlotasAtr = (GeneradorDeFlotas) optAtr.get();
            GeneradorDeFlotas genFlotasEspiado = Mockito.spy(genFlotasAtr);
            this.setPrivateField(contrEspiado, "generadorFlotas", genFlotasEspiado);
            //
            contrEspiado.preparaJugadorMaquinaFlotaDet();
            //
            this.printlnAlways("\tComprobando que se ha creado un objeto JugadorMaquina "
                    + "y que se ha añadido al atributo 'jugadores'.");
            optAtr = this.getPrivateFieldValue(contrEspiado, "jugadores");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "jugadores", puntosAntes);
                return;
            }
            List<Jugador> jugadores = (List<Jugador>) optAtr.get();
            JugadorMaquina jugadorMaq = null;
            boolean encontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador != null && jugador instanceof JugadorMaquina) {
                    encontrado = true;
                    jugadorMaq = (JugadorMaquina) jugador;
                }
            }
            error = this.sAssertTrue(encontrado, valorTotal / numTests, "Error: no "
                    + "se ha encontrado ningún JugadorMaquina en la lista "
                    + "de jugadores");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que se ha invocado al método correcto "
                    + "para crear la flota determinista con los argumentos adecuados.");
            try {
                Mockito.verify(genFlotasEspiado).generaFlotaDeterminista(jugadorMaq);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorMaquinaFlotaDet() debería "
                        + "invocar a GeneradorDeFlotas::generaFlotaDeterminista() "
                        + "con el jugador máquina creado pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorMaquinaFlotaDet() debería "
                        + "invocar a GeneradorDeFlotas::generaFlotaDeterminista(), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaJugadorMaquinaFlotaDet() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test03_preparaJugadorMaquinaFlotaAl() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaJugadorMaquinaFlotaAl(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            Optional<Object> optAtr = this.getPrivateFieldValue(controlador, "generadorFlotas");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "generadorFlotas", puntosAntes);
                return;
            }
            GeneradorDeFlotas genFlotasAtr = (GeneradorDeFlotas) optAtr.get();
            GeneradorDeFlotas genFlotasEspiado = Mockito.spy(genFlotasAtr);
            this.setPrivateField(controlador, "generadorFlotas", genFlotasEspiado);
            //
            controlador.preparaJugadorMaquinaFlotaAl();
            //
            this.printlnAlways("\tComprobando que se ha creado un objeto JugadorMaquina "
                    + "y que se ha añadido al atributo 'jugadores'.");
            optAtr = this.getPrivateFieldValue(controlador, "jugadores");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "jugadores", puntosAntes);
                return;
            }
            List<Jugador> jugadores = (List<Jugador>) optAtr.get();
            JugadorMaquina jugadorMaq = null;
            boolean encontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador != null && jugador instanceof JugadorMaquina) {
                    encontrado = true;
                    jugadorMaq = (JugadorMaquina) jugador;
                }
            }
            error = this.sAssertTrue(encontrado, valorTotal / numTests, "Error: no "
                    + "se ha encontrado ningún JugadorMaquina en la lista "
                    + "de jugadores");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que se ha invocado al método correcto "
                    + "para crear la flota determinista con los argumentos adecuados.");
            try {
                Mockito.verify(genFlotasEspiado).generaFlotaAleatoria(jugadorMaq);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorMaquinaFlotaAl() debería "
                        + "invocar a GeneradorDeFlotas::generaFlotaAleatoria() "
                        + "con el jugador máquina creado pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorMaquinaFlotaAl() debería "
                        + "invocar a GeneradorDeFlotas::generaFlotaAleatoria(), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaJugadorMaquinaFlotaAl() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test04_preparaJugadorHumanoFlotaDet() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaJugadorHumanoFlotaDet(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            Optional<Object> optAtr = this.getPrivateFieldValue(controlador, "generadorFlotas");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "generadorFlotas", puntosAntes);
                return;
            }
            GeneradorDeFlotas genFlotasAtr = (GeneradorDeFlotas) optAtr.get();
            GeneradorDeFlotas genFlotasEspiado = Mockito.spy(genFlotasAtr);
            this.setPrivateField(controlador, "generadorFlotas", genFlotasEspiado);
            //
            controlador.preparaJugadorHumanoFlotaDet("unNombre");
            //
            this.printlnAlways("\tComprobando que se ha creado un objeto JugadorHumano "
                    + "y que se ha añadido al atributo 'jugadores'.");
            optAtr = this.getPrivateFieldValue(controlador, "jugadores");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "jugadores", puntosAntes);
                return;
            }
            List<Jugador> jugadores = (List<Jugador>) optAtr.get();
            JugadorHumano jugadorHum = null;
            boolean encontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador != null && jugador instanceof JugadorHumano) {
                    encontrado = true;
                    jugadorHum = (JugadorHumano) jugador;
                }
            }
            error = this.sAssertTrue(encontrado, valorTotal / numTests, "Error: no "
                    + "se ha encontrado ningún JugadorHumano en la lista "
                    + "de jugadores");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que se ha invocado al método correcto "
                    + "para crear la flota determinista con los argumentos adecuados.");
            try {
                Mockito.verify(genFlotasEspiado).generaFlotaDeterminista(jugadorHum);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorHumanoFlotaDet() debería "
                        + "invocar a GeneradorDeFlotas::generaFlotaDeterminista() "
                        + "con el jugador máquina creado pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorHumanoFlotaDet() debería "
                        + "invocar a GeneradorDeFlotas::generaFlotaDeterminista(), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaJugadorHumanoFlotaDet() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
        } catch (Exception ex) {
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
    public void test05_preparaJugadorHumanoFlotaFichero() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 3;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaJugadorHumanoFlotaFichero(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            //
            Optional<Object> optAtr = this.getPrivateFieldValue(controlador, "generadorFlotas");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "generadorFlotas", puntosAntes);
                return;
            }
            GeneradorDeFlotas genFlotasAtr = (GeneradorDeFlotas) optAtr.get();
            GeneradorDeFlotas genFlotasEspiado = Mockito.spy(genFlotasAtr);
            this.setPrivateField(controlador, "generadorFlotas", genFlotasEspiado);
            //
            optAtr = this.getPrivateFieldValue(controlador, "renderer");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "renderer", puntosAntes);
                return;
            }
            Entregador mockRenderer = Mockito.mock(Entregador.class);
            this.setPrivateField(controlador, "renderer", mockRenderer);
            //
            controlador.preparaJugadorHumanoFlotaFichero("unNombre",
                    System.getProperty("user.dir") + "/flota_jugador_det.txt");
            //
            this.printlnAlways("\tComprobando que se ha creado un objeto JugadorHumano "
                    + "y que se ha añadido al atributo 'jugadores'.");
            optAtr = this.getPrivateFieldValue(controlador, "jugadores");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "jugadores", puntosAntes);
                return;
            }
            List<Jugador> jugadores = (List<Jugador>) optAtr.get();
            JugadorHumano jugadorHum = null;
            boolean encontrado = false;
            for (Jugador jugador : jugadores) {
                if (jugador != null && jugador instanceof JugadorHumano) {
                    encontrado = true;
                    jugadorHum = (JugadorHumano) jugador;
                }
            }
            error = this.sAssertTrue(encontrado, valorTotal / numTests, "Error: no "
                    + "se ha encontrado ningún JugadorHumano en la lista "
                    + "de jugadores");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que se ha invocado al método correcto "
                    + "para crear la flota desde un fichero con los argumentos adecuados.");
            try {
                Mockito.verify(genFlotasEspiado).leeFlotaDeArchivo(jugadorHum,
                        System.getProperty("user.dir") + "/flota_jugador_det.txt");
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorHumanoFlotaFichero() debería "
                        + "invocar a GeneradorDeFlotas::leeFlotaDeArchivo(...) "
                        + "con el jugador máquina creado pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorHumanoFlotaFichero() debería "
                        + "invocar a GeneradorDeFlotas::leeFlotaDeArchivo(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de este método invocado por Controlador::preparaJugadorHumanoFlotaFichero() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\tComprobando que se ha invocado al método correcto "
                    + "para mostrar los tableros del jugador humano por consola.");
            //

            try {
                Mockito.verify(mockRenderer).muestraTablerosHumano(jugadorHum);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorHumanoFlotaFichero() debería "
                        + "invocar a Entregador::muestraTablerosHumano(...) "
                        + "con el jugador máquina creado pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaJugadorHumanoFlotaFichero() debería "
                        + "invocar a Entregador::muestraTablerosHumano(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaJugadorHumanoFlotaFichero() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test06_preparaPartidaMaquinaDetVsMaquinaDet() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 1;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaPartidaMaquinaDetVsMaquinaDet(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            controladorEspiado.preparaPartidaMaquinaDetVsMaquinaDet();
            //
            this.printlnAlways("\tComprobando que se han invocado a los métodos correctos "
                    + "para crear los jugadores y las flotas adecuados.");
            try {
                Mockito.verify(controladorEspiado, times(2)).preparaJugadorMaquinaFlotaDet();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaMaquinaDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaDet(...) "
                        + "si ningún argumento, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaMaquinaDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaDet(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaMaquinaDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaDet(...) 2 veces, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaPartidaMaquinaDetVsMaquinaDet() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test07_preparaPartidaJHumanoDetVsMaquinaDet() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaPartidaJHumanoDetVsMaquinaDet(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            controladorEspiado.preparaPartidaJHumanoDetVsMaquinaDet("UnNombre");
            //
            this.printlnAlways("\tComprobando que se han invocado a los métodos correctos "
                    + "para crear los jugadores y las flotas adecuados.");
            try {
                Mockito.verify(controladorEspiado).preparaJugadorHumanoFlotaDet("UnNombre");
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaJHumanoDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorHumanoFlotaDet(...) "
                        + "si ningún argumento, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaJHumanoDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorHumanoFlotaDet(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaJHumanoDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorHumanoFlotaDet(...) 1 vez, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaPartidaJHumanoDetVsMaquinaDet() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            //
            try {
                Mockito.verify(controladorEspiado).preparaJugadorMaquinaFlotaDet();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaJHumanoDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaDet(...) "
                        + "si ningún argumento, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaJHumanoDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaDet(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaJHumanoDetVsMaquinaDet() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaDet(...) 1 vez, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaPartidaJHumanoDetVsMaquinaDet() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test08_preparaPartidaHumanoFichVsMaquinaAl() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preparaPartidaHumanoFichVsMaquinaAl(..). Valor: " + valorTotal);
        try {
            Gui iu = new Gui();
            Entregador renderer = new Entregador(iu);
            Controlador controlador = new Controlador(iu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            Optional<Object> optAtr = this.getPrivateFieldValue(controlador, "renderer");
            if (!optAtr.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "renderer", puntosAntes);
                return;
            }
            //Para que no presente los tableros mientras corrige
            Entregador mockRenderer = Mockito.mock(Entregador.class);
            this.setPrivateField(controladorEspiado, "renderer", mockRenderer);
            //
            controladorEspiado.preparaPartidaHumanoFichVsMaquinaAl("UnNombre",
                    System.getProperty("user.dir") + "/flota_jugador_det.txt");
            //
            this.printlnAlways("\tComprobando que se han invocado a los métodos correctos "
                    + "para crear los jugadores y las flotas adecuados.");
            try {
                Mockito.verify(controladorEspiado).preparaJugadorHumanoFlotaFichero("UnNombre",
                        System.getProperty("user.dir") + "/flota_jugador_det.txt");
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaHumanoFichVsMaquinaAl() debería "
                        + "invocar a Controlador::preparaJugadorHumanoFlotaFichero(...) "
                        + "si ningún argumento, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaHumanoFichVsMaquinaAl() debería "
                        + "invocar a Controlador::preparaJugadorHumanoFlotaFichero(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaHumanoFichVsMaquinaAl() debería "
                        + "invocar a Controlador::preparaJugadorHumanoFlotaFichero(...) 1 vez, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaPartidaHumanoFichVsMaquinaAl() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            //
            try {
                Mockito.verify(controladorEspiado).preparaJugadorMaquinaFlotaAl();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = this.toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaHumanoFichVsMaquinaAl() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaAl(...) "
                        + "si ningún argumento, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaHumanoFichVsMaquinaAl() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaAl(...), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preparaPartidaHumanoFichVsMaquinaAl() debería "
                        + "invocar a Controlador::preparaJugadorMaquinaFlotaAl(...) 1 vez, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preparaPartidaHumanoFichVsMaquinaAl() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test09_preguntaDisparoAHumano() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 3;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::preguntaDisparoAHumano(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Se prepara el entorno para que el primer disparo sea a una posición a la que se ha "
                    + "disparado antes (A1), y que el segundo sea a una posición a la que NO se había disparado antes (A2).");
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            //Crear jugHumano humano y hacerlo el atacante del controlador espiado
            //
            JugadorHumano mockJugHumano = Mockito.mock(JugadorHumano.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugHumano);
            //
            //Programar los dos disparos y el retorno de si se ha disparado antes o no
            //
            Mockito.when(mockIu.preguntaPorDisparo()).thenReturn("A1", "A2");
            Mockito.when(mockJugHumano.hasDisparadoAquiAntes("A1")).thenReturn(true);
            Mockito.when(mockJugHumano.hasDisparadoAquiAntes("A2")).thenReturn(false);
            //
            String disparoFinal = controladorEspiado.preguntaDisparoAHumano();
            //
            //Hay que comprobar que el disparo final sea "A2"
            this.printlnAlways("\tSe comprueba que el método devuelve un disparo "
                    + "que consta que no ha hecho antes 'A2' en esta prueba");
            error = this.sAssertEquals("A2", disparoFinal, valorTotal / numTests,
                    "Error. El método debería haber devuelto 'A2' si se hubiera "
                    + "programado correctamente, pero ha devuelto " + disparoFinal);
            toThrow = toThrow(error, toThrow);
            //
            //Comprobar que se ha invocado dos veces al método preguna disparo y
            //hasDisparadoAquiAntes
            try {
                this.printlnAlways("\tSe comprueba que el método ha preguntado dos "
                        + "veces al usuario");
                Mockito.verify(mockIu, times(2)).preguntaPorDisparo();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preguntaDisparoAHumano() debería "
                        + "invocar a Gui::preguntaPorDisparo(), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preguntaDisparoAHumano() debería "
                        + "invocar a Gui::preguntaPorDisparo() 2 veces, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preguntaDisparoAHumano() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            try {
                this.printlnAlways("\tSe comprueba que el método ha indagado dos "
                        + "veces si el disparo ha sido a una posición a la que "
                        + "ya se había disparado antes");
                Mockito.verify(mockJugHumano).hasDisparadoAquiAntes("A1");
                Mockito.verify(mockJugHumano).hasDisparadoAquiAntes("A2");
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preguntaDisparoAHumano() debería "
                        + "invocar a JugadorHumano::hasDisparadoAquiAntes(), "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::preguntaDisparoAHumano() debería "
                        + "invocar a JugadorHumano::hasDisparadoAquiAntes() 2 veces, "
                        + "pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::preguntaDisparoAHumano() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test10_atacanteDispara() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 6;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::atacanteDispara(..). Valor: " + valorTotal);
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            //Atacante un mock de jugador humano
            //Se programa que se pregunte a jugador humano y que éste 
            //conteste que dispara a "A2".
            this.printlnAlways("\tCaso 1: el atacante es un humano. Se programa un ataque a A2");
            JugadorHumano mockJugHumano = Mockito.mock(JugadorHumano.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugHumano);
            Mockito.when(mockJugHumano.dispara()).thenReturn("ASK_USER");
            Mockito.when(mockIu.preguntaPorDisparo()).thenReturn("A2");
            Mockito.when(mockJugHumano.hasDisparadoAquiAntes("A2")).thenReturn(false);
            boolean haPasado2 = false;
            try {
                String disparo = controladorEspiado.atacanteDispara();
                this.printlnAlways("\t  Comprobando que el método devuelve lo esperado: A2");
                error = this.sAssertEquals("A2", disparo, valorTotal / numTests,
                        "Error. El método debería haber devuelto A2; sin "
                        + "embargo ha devuelto " + disparo);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método hace que el atacante dispare");
                Mockito.verify(mockJugHumano).dispara();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                haPasado2 = true;
                this.printlnAlways("\t  Comprobando que el método pregunta el "
                        + "disparo al usuario");
                Mockito.verify(controladorEspiado).preguntaDisparoAHumano();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                String metodo = (haPasado2) ? "Controlador::preguntaDisparoAHumano"
                        : "JugadorHumano::dispara()";
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteDispara() debería "
                        + "invocar a " + metodo + ", pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                String metodo = (haPasado2) ? "Controlador::preguntaDisparoAHumano"
                        : "JugadorHumano::dispara()";
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteDispara() debería "
                        + "invocar a " + metodo + " 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::atacanteDispara() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            this.printlnAlways("\tCaso 2: el atacante es un jugador máquina. Se programa un ataque a A1");
            mockIu = Mockito.mock(Gui.class);
            renderer = new Entregador(mockIu);
            controlador = new Controlador(mockIu, renderer);
            controladorEspiado = Mockito.spy(controlador);
            //
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugMaquina);
            Mockito.when(mockJugMaquina.dispara()).thenReturn("A1");
            try {
                String disparo = controladorEspiado.atacanteDispara();
                this.printlnAlways("\t  Comprobando que el método devuelve lo esperado: A1");
                error = this.sAssertEquals("A1", disparo, valorTotal / numTests,
                        "Error. El método debería haber devuelto A1; sin "
                        + "embargo ha devuelto " + disparo);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método hace que el atacante dispare");
                Mockito.verify(mockJugMaquina).dispara();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método NO pregunta el "
                        + "disparo al usuario");
                Mockito.verify(controladorEspiado, times(0)).preguntaDisparoAHumano();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteDispara() debería "
                        + "invocar a JugadorMaquina::dispara(), pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (NeverWantedButInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "Error. El método Controlador::atacanteDispara() NO debería "
                        + "invocar a Controlador::preguntaDisparoAHumano, pero lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "Error. El método Controlador::atacanteDispara() debería "
                        + "invocar a JugadorHumano::dispara() 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::atacanteDispara() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test11_atacanteProcesaTocado() {
        double valorTotal = 0.3;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 6;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::atacanteProcesaTocado(..). Valor: " + valorTotal);
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            this.printlnAlways("\tCaso 1: el atacante es un humano. Se programa un tocado en A1 y que devuelva A2");
            JugadorHumano mockJugHumano = Mockito.mock(JugadorHumano.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugHumano);
            Mockito.when(mockJugHumano.procesaTocado("A1")).thenReturn("ASK_USER");
            Mockito.when(mockIu.preguntaPorDisparo()).thenReturn("A2");
            Mockito.when(mockJugHumano.hasDisparadoAquiAntes("A2")).thenReturn(false);
            boolean haPasado2 = false;
            try {
                String disparo = controladorEspiado.atacanteProcesaTocado("A1");
                this.printlnAlways("\t  Comprobando que el método devuelve lo esperado: A2");
                error = this.sAssertEquals("A2", disparo, valorTotal / numTests,
                        "Error. El método debería haber devuelto A2; sin "
                        + "embargo ha devuelto " + disparo);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método hace que el atacante "
                        + "procese un tocado en A1");
                Mockito.verify(mockJugHumano).procesaTocado("A1");
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                haPasado2 = true;
                this.printlnAlways("\t  Comprobando que el método pregunta el "
                        + "disparo al usuario");
                Mockito.verify(controladorEspiado).preguntaDisparoAHumano();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                String metodo = (haPasado2) ? "Controlador::preguntaDisparoAHumano"
                        : "JugadorHumano::procesaTocado()";
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteProcesaTocado() debería "
                        + "invocar a " + metodo + ", pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                String metodo = (haPasado2) ? "Controlador::preguntaDisparoAHumano"
                        : "JugadorHumano::procesaTocado()";
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteProcesaTocado() debería "
                        + "invocar a " + metodo + " 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::atacanteProcesaTocado() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            this.printlnAlways("\tCaso 2: el atacante es un jugador máquina. Se programa un tocado a A1 "
                    + "y un disparo a A2");
            mockIu = Mockito.mock(Gui.class);
            renderer = new Entregador(mockIu);
            controlador = new Controlador(mockIu, renderer);
            controladorEspiado = Mockito.spy(controlador);
            //
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugMaquina);
            Mockito.when(mockJugMaquina.procesaTocado("A1")).thenReturn("A2");
            try {
                String disparo = controladorEspiado.atacanteProcesaTocado("A1");
                this.printlnAlways("\t  Comprobando que el método devuelve lo esperado: A2");
                error = this.sAssertEquals("A2", disparo, valorTotal / numTests,
                        "Error. El método debería haber devuelto A2; sin "
                        + "embargo ha devuelto " + disparo);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método hace que el atacante "
                        + "procese un tocado en A1");
                Mockito.verify(mockJugMaquina).procesaTocado("A1");
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método NO pregunta el "
                        + "disparo al usuario");
                Mockito.verify(controladorEspiado, times(0)).preguntaDisparoAHumano();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteProcesaTocado() debería "
                        + "invocar a JugadorMaquina::procesaTocado(), pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (NeverWantedButInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "Error. El método Controlador::atacanteProcesaTocado() NO debería "
                        + "invocar a Controlador::preguntaDisparoAHumano, pero lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "Error. El método Controlador::atacanteProcesaTocado() debería "
                        + "invocar a JugadorHumano::procesaTocado() 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::atacanteDispara() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test12_atacanteProcesaHundido() {
        double valorTotal = 0.3;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 6;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::atacanteProcesaHundido(..). Valor: " + valorTotal);
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            this.printlnAlways("\tCaso 1: el atacante es un humano. Se programa un hundido en A1 y que devuelva A3");
            JugadorHumano mockJugHumano = Mockito.mock(JugadorHumano.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugHumano);
            Mockito.when(mockJugHumano.procesaHundido("A1", Controlador.numBarcosJugadores)).thenReturn("ASK_USER");
            Mockito.when(mockIu.preguntaPorDisparo()).thenReturn("A3");
            Mockito.when(mockJugHumano.hasDisparadoAquiAntes("A3")).thenReturn(false);
            boolean haPasado2 = false;
            try {
                String disparo = controladorEspiado.atacanteProcesaHundido("A1");
                this.printlnAlways("\t  Comprobando que el método devuelve lo esperado: A3");
                error = this.sAssertEquals("A3", disparo, valorTotal / numTests,
                        "Error. El método debería haber devuelto A3; sin "
                        + "embargo ha devuelto " + disparo);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método hace que el atacante "
                        + "procese un hundido en A1");
                Mockito.verify(mockJugHumano).procesaHundido("A1", Controlador.numBarcosJugadores);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                haPasado2 = true;
                this.printlnAlways("\t  Comprobando que el método pregunta el "
                        + "disparo al usuario");
                Mockito.verify(controladorEspiado).preguntaDisparoAHumano();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                String metodo = (haPasado2) ? "Controlador::preguntaDisparoAHumano"
                        : "JugadorHumano::procesaHundido()";
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteProcesaHundido() debería "
                        + "invocar a " + metodo + ", pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                String metodo = (haPasado2) ? "Controlador::atacanteProcesaHundido"
                        : "JugadorHumano::procesaHundido()";
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteProcesaHundido() debería "
                        + "invocar a " + metodo + " 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::atacanteProcesaHundido() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            this.printlnAlways("\tCaso 2: el atacante es un jugador máquina. Se programa un hundido en A1 "
                    + "y un disparo a A3");
            mockIu = Mockito.mock(Gui.class);
            renderer = new Entregador(mockIu);
            controlador = new Controlador(mockIu, renderer);
            controladorEspiado = Mockito.spy(controlador);
            //
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugMaquina);
            Mockito.when(mockJugMaquina.procesaHundido("A1", Controlador.numBarcosJugadores)).thenReturn("A3");
            try {
                String disparo = controladorEspiado.atacanteProcesaHundido("A1");
                this.printlnAlways("\t  Comprobando que el método devuelve lo esperado: A3");
                error = this.sAssertEquals("A3", disparo, valorTotal / numTests,
                        "Error. El método debería haber devuelto A3; sin "
                        + "embargo ha devuelto " + disparo);
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método hace que el atacante "
                        + "procese un hundido en A1");
                Mockito.verify(mockJugMaquina).procesaHundido("A1", Controlador.numBarcosJugadores);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                this.printlnAlways("\t  Comprobando que el método NO pregunta el "
                        + "disparo al usuario");
                Mockito.verify(controladorEspiado, times(0)).preguntaDisparoAHumano();
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::atacanteProcesaHundido() debería "
                        + "invocar a JugadorMaquina::procesaHundido(), pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (NeverWantedButInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "Error. El método Controlador::atacanteProcesaHundido() NO debería "
                        + "invocar a Controlador::preguntaDisparoAHumano, pero lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "Error. El método Controlador::atacanteProcesaHundido() debería "
                        + "invocar a JugadorHumano::procesaHundido() 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::atacanteProcesaHundido() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test13_presentaTableros() {
        double valorTotal = 0.1;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 2;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::presentaTableros(..). Valor: " + valorTotal);
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = Mockito.mock(Entregador.class);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            //
            this.printlnAlways("\tCaso 1: Comprobando que si el atacante es un humano se muestran "
                    + "los tableros del atacante.");
            JugadorHumano mockJugHumano = Mockito.mock(JugadorHumano.class);
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            Mockito.when(mockJugHumano.eresHumano()).thenReturn(true);
            Mockito.when(mockJugMaquina.eresHumano()).thenReturn(false);
            boolean haPasado1 = false;
            try {
                controladorEspiado.presentaTableros();
                Mockito.verify(renderer).muestraTablerosHumano(mockJugHumano);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);

            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::muestraTablerosHumano debería "
                        + "invocar a Entregador::muestraTablerosHumano sin "
                        + "argumentos, pero no lo hace así");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::muestraTablerosHumano() debería "
                        + "invocar a Entregador::muestraTablerosHumano, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::muestraTablerosHumano() debería "
                        + "invocar a Entregador::muestraTablerosHumano, 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::muestraTablerosHumano() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
                toThrow = toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\tCaso 2: Comprobando que si el atacado es un humano se muestran "
                    + "los tableros del atacado.");
            mockIu = Mockito.mock(Gui.class);
            renderer = Mockito.mock(Entregador.class);
            controlador = new Controlador(mockIu, renderer);
            controladorEspiado = Mockito.spy(controlador);
            this.setPrivateField(controladorEspiado, "atacado", mockJugHumano);
            this.setPrivateField(controladorEspiado, "atacante", mockJugMaquina);
            Mockito.when(mockJugHumano.eresHumano()).thenReturn(true);
            Mockito.when(mockJugMaquina.eresHumano()).thenReturn(false);
            try {
                controladorEspiado.presentaTableros();
                Mockito.verify(renderer).muestraTablerosHumano(mockJugHumano);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
            } catch (ArgumentsAreDifferent ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::muestraTablerosHumano debería "
                        + "invocar a Entregador::muestraTablerosHumano sin "
                        + "argumentos, pero no lo hace así");
                toThrow = toThrow(error, toThrow);
            } catch (WantedButNotInvoked ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::muestraTablerosHumano() debería "
                        + "invocar a Entregador::muestraTablerosHumano, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (TooLittleActualInvocations | TooManyActualInvocations ex) {
                error = this.sAssertTrue(false, 0,
                        "El método Controlador::muestraTablerosHumano() debería "
                        + "invocar a Entregador::muestraTablerosHumano 1 vez, pero no lo hace");
                toThrow = toThrow(error, toThrow);
            } catch (Throwable ex) {
                error = this.sAssertTrue(false, 0,
                        "La comprobación de los métodos invocados por Controlador::muestraTablerosHumano() ha "
                        + "arrojado un error. Revisa el código de dicho método.");
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
    public void test14_cambiaTurno() {
        double valorTotal = 0.1;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 6;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::cambiaTurno(..). Valor: " + valorTotal);
        this.printlnAlways("El jugador humano está en la posición de índice 0 y "
                + "se comienza suponiendo que tiene el turno de ataque");
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            JugadorHumano mockJugHumano = Mockito.mock(JugadorHumano.class);
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            this.setPrivateField(controladorEspiado, "atacante", mockJugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            Optional<Object> optJugs = this.getPrivateFieldValue(controladorEspiado, "jugadores");
            if (!optJugs.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "jugadores", puntosAntes);
                return;
            }
            List<Jugador> jugadores = (List<Jugador>) optJugs.get();
            jugadores.add(mockJugHumano);
            jugadores.add(mockJugMaquina);
            //
            //El turno de ataque lo tiene el jugador humano (0). 
            this.printlnAlways("\t Caso 1: Comprobando que cambia bien el turno cuando el atacante es el jugador humano");
            int nuevoTurno = controladorEspiado.cambiaTurno(0);
            this.printlnAlways("\t    Comprobando que el turno es 1");
            error = this.sAssertEquals(1, nuevoTurno, valorTotal / numTests, "Error. "
                    + "Antes el turno era 0, ahora debería ser 1; sin embargo es " + nuevoTurno);
            toThrow = toThrow(error, toThrow);
            Optional<Object> optAtacante = this.getPrivateFieldValue(controladorEspiado, "atacante");
            Optional<Object> optAtacado = this.getPrivateFieldValue(controladorEspiado, "atacado");
            if (!optAtacante.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "atacante", puntosAntes);
                return;
            }
            if (!optAtacado.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "atacado", puntosAntes);
                return;
            }
            this.printlnAlways("\t    Comprobando que ahora el atacante será el jugador máquina");
            error = this.sAssertEquals(mockJugMaquina, optAtacante.get(),
                    valorTotal / numTests, "Error. El nuevo atacante debería ser "
                    + "el jugador máquina, pero no lo es");
            toThrow = toThrow(error, toThrow);
            this.printlnAlways("\t    Comprobando que ahora el atacado será el jugador humano");
            error = this.sAssertEquals(mockJugHumano, optAtacado.get(),
                    valorTotal / numTests, "Error. El nuevo atacado debería ser "
                    + "el jugador humano, pero no lo es");
            toThrow = toThrow(error, toThrow);
            //
            //El turno de ataque lo tiene el jugador máquina (1). 
            this.printlnAlways("\t Caso 2: Comprobando que cambia bien el turno cuando el atacante es el jugador máquina");
            nuevoTurno = controladorEspiado.cambiaTurno(1);
            this.printlnAlways("\t    Comprobando que el turno es 0");
            error = this.sAssertEquals(0, nuevoTurno, valorTotal / numTests, "Error. "
                    + "Antes el turno era 1, ahora debería ser 0; sin embargo es " + nuevoTurno);
            toThrow = toThrow(error, toThrow);
            optAtacante = this.getPrivateFieldValue(controladorEspiado, "atacante");
            optAtacado = this.getPrivateFieldValue(controladorEspiado, "atacado");
            if (!optAtacante.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "atacante", puntosAntes);
                return;
            }
            if (!optAtacado.isPresent()) {
                this.finishIfAttrNotPresent("controlador", "atacado", puntosAntes);
                return;
            }
            this.printlnAlways("\t    Comprobando que ahora el atacante será el jugador humano");
            error = this.sAssertEquals(mockJugHumano, optAtacante.get(),
                    valorTotal / numTests, "Error. El nuevo atacante debería ser "
                    + "el jugador humano, pero no lo es");
            toThrow = toThrow(error, toThrow);
            this.printlnAlways("\t    Comprobando que ahora el atacado será el jugador máquina");
            error = this.sAssertEquals(mockJugMaquina, optAtacado.get(),
                    valorTotal / numTests, "Error. El nuevo atacado debería ser "
                    + "el jugador máquina, pero no lo es");
            toThrow = toThrow(error, toThrow);

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
    public void test15_ponBarcoJugadorHumano() {
        double valorTotal = 0.3;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 8;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::ponBarcoJugadorHumano(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tComprobando que se crea un buque en "
                    + "horizontal a partir de la posición C5 y se coloca "
                    + "donde debe");
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            JugadorHumano jugHumano = new JugadorHumano("unNombre");
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugHumano);
            jugadores.add(mockJugMaquina);
            this.setPrivateField(controladorEspiado, "jugadores", jugadores);
            this.setPrivateField(controladorEspiado, "atacante", jugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            String[] posYDireccion = {"C5", "H"};
            try {
                controladorEspiado.ponBarcoJugadorHumano(jugHumano, "B", "Buque3", posYDireccion);
                error = this.sAssertTrue(true, valorTotal / numTests, "");
                toThrow = toThrow(error, toThrow);
                //
                String[] casillasRefArray = {"C5", "C6", "C7", "C8"};
                Set<String> casillasRef = new HashSet<>(Arrays.asList(casillasRefArray));
                this.checkBarcoDeFlotaDeterminista(jugHumano, Buque.class,
                        "Buque", "C5", casillasRef, valorTotal, numTests,
                        toThrow, puntosAntes);

            } catch (PositionException ex) {
                error = this.sAssertTrue(false, 0, "Error. El método ha "
                        + "lanzado una excepción PositionException cuando no "
                        + "debía haberlo hecho");
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
    public void test16_presentaMensajeAgua() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 3;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::presentaMensajeAgua(..). Valor: " + valorTotal);
        this.printlnAlways("Se programará la presentación del mensaje para la "
                + "casilla A5");
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            JugadorHumano jugHumano = new JugadorHumano("unNombre");
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugHumano);
            jugadores.add(mockJugMaquina);
            this.setPrivateField(controladorEspiado, "jugadores", jugadores);
            this.setPrivateField(controladorEspiado, "atacante", jugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            //
            List<String> mensajesConsola = Controlador.getMensajesAConsola();
            this.clearMensajesConsola();
            controladorEspiado.presentaMensajeAgua("A5");
            String mensaje = mensajesConsola.get(0);
            this.printlnAlways("\tComprobando que el mensaje contiene el nombre del atacante");
            error = this.sAssertTrue(mensaje.contains("unNombre"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene el nombre del atacante");
            toThrow = toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el mensaje contiene la "
                    + "coordenada de la casilla atacada");
            error = this.sAssertTrue(mensaje.contains("A5"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene la coordenada de la casilla atacada");
            toThrow = toThrow(error, toThrow);
            //
            this.printlnAlways("\tComprobando que el mensaje contiene 'agua' o "
                    + "'AGUA'");
            error = this.sAssertTrue(mensaje.contains("agua") || mensaje.contains("AGUA"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene ni la palabra 'agua' ni la palabra 'AGUA'");
            toThrow = toThrow(error, toThrow);

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
    public void test17_presentaMensajeTocado() {
        double valorTotal = 0.2;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 7;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::presentaMensajeTocado(..). Valor: " + valorTotal);
        try {
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            JugadorHumano jugHumano = new JugadorHumano("unNombre");
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            Mockito.when(mockJugMaquina.getNombre()).thenReturn("NombreJugMaquina");
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugHumano);
            jugadores.add(mockJugMaquina);
            this.setPrivateField(controladorEspiado, "jugadores", jugadores);
            this.setPrivateField(controladorEspiado, "atacante", jugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            List<String> mensajesConsola = Controlador.getMensajesAConsola();
            this.clearMensajesConsola();
            //
            //
            this.printlnAlways("\tCaso 1: el atacante que ha tocado un barco "
                    + "del contrario es el jugador humano");
            //
            controladorEspiado.presentaMensajeTocado("A5");
            //
            String mensaje = mensajesConsola.get(0);
            this.checkMensaje("unNombre", "A5", "tocado", mensaje, valorTotal,
                    numTests, null, toThrow, puntosAntes);
            //
            this.printlnAlways("\tCaso 2: el atacante que ha tocado un barco "
                    + "del contrario es el jugador maquina");
            this.setPrivateField(controladorEspiado, "atacado", jugHumano);
            this.setPrivateField(controladorEspiado, "atacante", mockJugMaquina);
            Mockito.when(mockJugMaquina.getNombre()).thenReturn("Maquina-Mock");
            this.clearMensajesConsola();

            //
            controladorEspiado.presentaMensajeTocado("A4");
            //
            mensaje = mensajesConsola.get(0);
            this.checkMensaje("Maquina-Mock", "A4", "tocado", mensaje, valorTotal,
                    numTests, "unNombre", toThrow, puntosAntes);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
    }

    @Test
    public void test18_presentaMensajeHundido() {
        double valorTotal = 0.3;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 19;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::presentaMensajeHundido(..). Valor: " + valorTotal);
        try {
            Controlador.numBarcosJugadores = 9;
            Gui mockIu = Mockito.mock(Gui.class);
            Entregador renderer = new Entregador(mockIu);
            Controlador controlador = new Controlador(mockIu, renderer);
            Controlador controladorEspiado = Mockito.spy(controlador);
            JugadorHumano jugHumano = new JugadorHumano("unNombre");
            JugadorMaquina mockJugMaquina = Mockito.mock(JugadorMaquina.class);
            Mockito.when(mockJugMaquina.getNombre()).thenReturn("NombreJugMaquina");
            List<Jugador> jugadores = new ArrayList<>();
            jugadores.add(jugHumano);
            jugadores.add(mockJugMaquina);
            this.setPrivateField(controladorEspiado, "jugadores", jugadores);
            this.setPrivateField(controladorEspiado, "atacante", jugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            List<String> mensajesConsola = Controlador.getMensajesAConsola();
            this.clearMensajesConsola();
            //
            //
            this.printlnAlways("\tCaso 1: el atacante que ha hundido un barco "
                    + "del contrario es el jugador humano Y el barco NO es "
                    + "el último barco del oponente");
            //
            controladorEspiado.presentaMensajeHundido("A5", 5);
            //
            String mensaje = mensajesConsola.get(0);
            //
            this.printlnAlways("\t  Comprobando que el mensaje contiene el "
                    + "número de barcos hundidos por el atacante");
            error = this.sAssertTrue(mensaje.contains("5"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene el número correcto de barcos hundidos por "
                    + "el atacante");
            toThrow = toThrow(error, toThrow);
            this.checkMensaje("unNombre", "A5", "hundido", mensaje, valorTotal,
                    numTests, null, toThrow, puntosAntes);
            //
            //
            this.printlnAlways("\tCaso 2: el atacante que ha tocado un barco "
                    + "del contrario es el jugador maquina Y el barco NO es "
                    + "el último barco del oponente");
            this.setPrivateField(controladorEspiado, "atacado", jugHumano);
            this.setPrivateField(controladorEspiado, "atacante", mockJugMaquina);
            Mockito.when(mockJugMaquina.getNombre()).thenReturn("Maquina-Mock");
            this.clearMensajesConsola();
            //
            controladorEspiado.presentaMensajeHundido("A4", 4);
            //
            mensaje = mensajesConsola.get(0);
            //
            this.printlnAlways("\t  Comprobando que el mensaje contiene el "
                    + "número de barcos hundidos por el atacante");
            error = this.sAssertTrue(mensaje.contains("4"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene el número correcto de barcos hundidos por "
                    + "el atacante");
            toThrow = toThrow(error, toThrow);
            this.checkMensaje("Maquina-Mock", "A4", "hundido", mensaje, valorTotal,
                    numTests, "unNombre", toThrow, puntosAntes);
            //
            //
            this.printlnAlways("\tCaso 3: el atacante que ha hundido un barco "
                    + "del contrario es el jugador máquina Y el barco ES "
                    + "el último barco del jugador humano");
            this.clearMensajesConsola();
            //
            controladorEspiado.presentaMensajeHundido("A5", 9);
            //
            mensaje = mensajesConsola.get(0);
            //
            this.printlnAlways("\t  Comprobando que el mensaje contiene el "
                    + "número de barcos hundidos por el atacante");
            error = this.sAssertTrue(mensaje.contains("9"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene el número correcto de barcos hundidos por "
                    + "el atacante");
            toThrow = toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobando que el mensaje indica al "
                    + "jugador humano que ha PERDIDO");
            error = this.sAssertTrue(mensaje.contains("PERDIDO") || mensaje.contains("perdido"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "indica que el jugador humano ha PERDIDO la partida cuando "
                    + "ha hundido el último barco del oponente");
            toThrow = toThrow(error, toThrow);
            this.checkMensaje("unNombre", "A5", "hundido", mensaje, valorTotal,
                    numTests, null, toThrow, puntosAntes);
            //
            //
            this.printlnAlways("\tCaso 2: el atacante que ha tocado un barco "
                    + "del contrario es el jugador humano Y el barco ES "
                    + "el último barco del oponente");
            this.setPrivateField(controladorEspiado, "atacante", jugHumano);
            this.setPrivateField(controladorEspiado, "atacado", mockJugMaquina);
            this.clearMensajesConsola();
            //
            controladorEspiado.presentaMensajeHundido("A4", 9);
            //
            mensaje = mensajesConsola.get(0);
            //
            this.printlnAlways("\t  Comprobando que el mensaje contiene el "
                    + "número de barcos hundidos por el atacante");
            error = this.sAssertTrue(mensaje.contains("9"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene el número correcto de barcos hundidos por "
                    + "el atacante");
            toThrow = toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobando que el mensaje indica al "
                    + "jugador humano que ha GANADO");
            error = this.sAssertTrue(mensaje.contains("GANADO"),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "indica que el jugador humano ha GANADO la partida cuando "
                    + "el jugador máquina le ha hundido el último barco");
            toThrow = toThrow(error, toThrow);
            this.checkMensaje(null, "A4", "hundido", mensaje, valorTotal,
                    numTests, "unNombre", toThrow, puntosAntes);
        } catch (Throwable ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            ex.setStackTrace(this.reduceST(ex.getStackTrace()));
            ex.printStackTrace();
        }
    }

    @Test
    public void test19_juegaPartidaGanaJugador() {
        double valorTotal = 3.1;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 7;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::juegaPartidaGanaJugador(..). Valor: " + valorTotal);
        try {
            ControladorTest.numAguas = 0;
            ControladorTest.numTocados = 0;
            ControladorTest.numHundidos = 0;
            ControladorTest.numMensajes = 0;
            //
            this.printlnAlways("  Se crea una partida con dos barcos (submarino [A1,A2,A3] y lancha [J10] para ambos jugadores)."
                    + "\n  1) Jugador humano dispara a B1 (AGUA)."
                    + "\n  2) Jugador máquina dispara a B3 (AGUA)."
                    + "\n  3) Jugador humano dispara a A1, A2, A3 y J10 y acaba la partida ganando\n");
            Controlador.numBarcosJugadores = 2;
            List<String> mensajesConsola = Controlador.getMensajesAConsola();
            this.clearMensajesConsola();
            mensajesConsola.add("Mensaje no usado");
            Entregador mockEntregador = Mockito.mock(Entregador.class);
            Gui mockGui = Mockito.mock(Gui.class);
            Controlador controlador = new Controlador(mockGui, mockEntregador);
            Controlador controladorEspiado = Mockito.spy(controlador);
            ObservadorObservado observadorObservado = new ObservadorObservado(this);
            controlador.addObservador(observadorObservado);
            controlador.preparaPartidaJHumanoDetVsMaquinaDet("unNombre");
            //
            //Se crean tableros con solo dos barcos
            Optional<Tablero> optTHumano = this.creaTableroParaCorregirJuegaPartida();
            Optional<Tablero> optTMaquina = this.creaTableroParaCorregirJuegaPartida();
            if (!optTHumano.isPresent()) {
                this.finishIfAttrNotPresent("test19_juegaPartidaGanaHumano (no objeto)", "tablero humano", puntosAntes);
                return;
            }
            if (!optTMaquina.isPresent()) {
                this.finishIfAttrNotPresent("test19_juegaPartidaGanaHumano (no objeto)", "tablero máquina", puntosAntes);
                return;
            }
            Tablero tHumano = (Tablero) optTHumano.get();
            Tablero tMaquina = (Tablero) optTMaquina.get();
            Controlador.numBarcosJugadores = 2;
            JugadorHumano jugHumano = new JugadorHumano("UnNombre");
            JugadorMaquina jugMaquina = new JugadorMaquina();
            List<Jugador> jugadores = new ArrayList<>();
            JugadorHumano jHumanoEspiado = Mockito.spy(jugHumano);
            JugadorMaquina jMaquinaEspiado = Mockito.spy(jugMaquina);
            jugadores.add(jHumanoEspiado);
            jugadores.add(jMaquinaEspiado);
            this.setPrivateField(jHumanoEspiado, "tablero", tHumano);
            this.setPrivateField(jMaquinaEspiado, "tablero", tMaquina);
            this.setPrivateField(controlador, "jugadores", jugadores);
            this.setPrivateField(controlador, "atacante", jHumanoEspiado);
            this.setPrivateField(controlador, "atacado", jMaquinaEspiado);
            //
            //No hacer nada cuando se invoca a mostrar tableros de renderer
            Mockito.doNothing().when(mockEntregador).muestraTablerosHumano(jHumanoEspiado);
            //
            // Programar los disparos de ambos jugadores.
            //
            // 1. Programar los disparos del jugador humano.
            // Los dos primeros disparos desde JugadorHumano::dispara
            Mockito.when(jHumanoEspiado.dispara()).thenReturn("B1", "A1");
//            Mockito.doReturn("B1").when(jHumanoEspiado).dispara();
            //
            //Los siguientes desde Gui::preguntaDisparo
            Mockito.when(mockGui.preguntaPorDisparo()).thenReturn("A2", "A3", "J10");
            //
            // 2. Programar los disparos del jugador máquina.
            Mockito.doReturn("B3").when(jMaquinaEspiado).dispara();
            MyRandom mockRandom = Mockito.mock(MyRandom.class);
            this.setPrivateField(controlador, "random", mockRandom);
            Mockito.when(mockRandom.nextInt(2)).thenReturn(0);
            ControladorTest.primerDisparoDe = "H";
            controlador.juegaPartida();
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
    public void test20_juegaPartidaGanaMaquina() {
        double valorTotal = 3.1;
        AssertionError toThrow = null;
        AssertionError error = null;
        int numTests = 7;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Controlador::juegaPartidaGanaMaquina(..). Valor: " + valorTotal);
        try {
            ControladorTest.numAguas = 0;
            ControladorTest.numTocados = 0;
            ControladorTest.numHundidos = 0;
            ControladorTest.numMensajes = 0;

            //
            this.printlnAlways("  Se crea una partida con dos barcos (submarino [A1,A2,A3] y lancha [J10] para ambos jugadores)."
                    + "\n  1) Jugador máquina dispara a B1 (AGUA)."
                    + "\n  2) Jugador humano dispara a B3 (AGUA)."
                    + "\n  3) Jugador máquina dispara a A1, A2, A3 y J10 y acaba la partida ganando\n");
            Controlador.numBarcosJugadores = 2;
            List<String> mensajesConsola = Controlador.getMensajesAConsola();
            ControladorTest.numMensajes = 0;
            this.clearMensajesConsola();
            mensajesConsola.add("Mensaje no usado");
            Entregador mockEntregador = Mockito.mock(Entregador.class);
            Gui mockGui = Mockito.mock(Gui.class);
            Controlador controlador = new Controlador(mockGui, mockEntregador);
            Controlador controladorEspiado = Mockito.spy(controlador);
            ObservadorObservado observadorObservado = new ObservadorObservado(this);
            controlador.addObservador(observadorObservado);
            controlador.preparaPartidaJHumanoDetVsMaquinaDet("unNombre");
            //
            //Se crean tableros con solo dos barcos
            Optional<Tablero> optTHumano = this.creaTableroParaCorregirJuegaPartida();
            Optional<Tablero> optTMaquina = this.creaTableroParaCorregirJuegaPartida();
            if (!optTHumano.isPresent()) {
                this.finishIfAttrNotPresent("test20_juegaPartidaGanaMaquina (no objeto)", "tablero humano", puntosAntes);
                return;
            }
            if (!optTMaquina.isPresent()) {
                this.finishIfAttrNotPresent("test20_juegaPartidaGanaMaquina (no objeto)", "tablero máquina", puntosAntes);
                return;
            }
            Tablero tHumano = (Tablero) optTHumano.get();
            Tablero tMaquina = (Tablero) optTMaquina.get();
            Controlador.numBarcosJugadores = 2;
            JugadorHumano jugHumano = new JugadorHumano("UnNombre");
            JugadorMaquina jugMaquina = new JugadorMaquina();
            List<Jugador> jugadores = new ArrayList<>();
            JugadorHumano jHumanoEspiado = Mockito.spy(jugHumano);
            JugadorMaquina jMaquinaEspiado = Mockito.spy(jugMaquina);
            jugadores.add(jMaquinaEspiado);
            jugadores.add(jHumanoEspiado);
            this.setPrivateField(jHumanoEspiado, "tablero", tHumano);
            this.setPrivateField(jMaquinaEspiado, "tablero", tMaquina);
            this.setPrivateField(controlador, "jugadores", jugadores);
            this.setPrivateField(controlador, "atacante", jHumanoEspiado);
            this.setPrivateField(controlador, "atacado", jMaquinaEspiado);
            //
            //No hacer nada cuando se invoca a mostrar tableros de renderer
            Mockito.doNothing().when(mockEntregador).muestraTablerosHumano(jHumanoEspiado);
            //
            // Programar los disparos de ambos jugadores.
            // 1. Programar los disparos del jugador máquina.
            Mockito.when(jMaquinaEspiado.dispara()).thenReturn("B1", "A1", "A2", "A3", "J10");

            // 2. Programar los disparos del jugador humano
            Mockito.doReturn("B3").when(jHumanoEspiado).dispara();

            MyRandom mockRandom = Mockito.mock(MyRandom.class);
            this.setPrivateField(controlador, "random", mockRandom);
            Mockito.when(mockRandom.nextInt(2)).thenReturn(0);
            ControladorTest.primerDisparoDe = "M";
            ControladorTest.numAguas = 0;
            ControladorTest.numTocados = 0;
            ControladorTest.numHundidos = 0;

            controlador.juegaPartida();
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

    private void checkBarcoDeFlotaDeterminista(Jugador jugador,
            Class tipoBarco, String nombreTipoBarco, String posComienzo,
            Set<String> casillasBarcoRef, double valorTotal,
            int numTests, AssertionError toThrow, double puntosAntes) {
        AssertionError error;
        Optional<Object> optTablero = this.getPrivateFieldValue(jugador, "tablero");
        if (!optTablero.isPresent()) {
            this.finishIfAttrNotPresent("jugador", "tablero", puntosAntes);
            return;
        }
        Tablero tablero = (Tablero) optTablero.get();
        Optional<Object> optCasillas = this.getPrivateFieldValue(tablero, "casillas");
        if (!optCasillas.isPresent()) {
            this.finishIfAttrNotPresent("tablero", "casillas", puntosAntes);
        }
        Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
        Barco barco = casillas.get(posComienzo);
        this.printlnAlways("\tComprobando que hay un barco en la casilla en la que "
                + "se ha intentado crear");
        error = this.sAssertNotNull(barco, valorTotal / numTests, "Error. No hay "
                + "ningún barco en la posición " + posComienzo);
        toThrow = toThrow(error, toThrow);
        if (error == null) {
            this.printlnAlways("\tComprobando que el barco es del tipo que "
                    + "se ha pedido crear");
            error = this.sAssertTrue(barco.getClass().equals(tipoBarco),
                    valorTotal / numTests, "Error. El barco encontrado en la "
                    + "posición de creación, NO es del tipo de barco que debía "
                    + "haberse creado");
            toThrow = toThrow(error, toThrow);
        }
        if (error == null) {
            this.printlnAlways("\tComprobando que las posiciones en el barco "
                    + "son correctas");
            Optional<Object> optCasillasBarco = this.getPrivateFieldValue(barco, "posiciones");
            if (!optCasillasBarco.isPresent()) {
                this.finishIfAttrNotPresent("barco", "posiciones", puntosAntes);
                return;
            }
            Set<String> casillasBarco = new HashSet<>((List<String>) optCasillasBarco.get());
            error = this.sAssertEquals(casillasBarcoRef, casillasBarco,
                    valorTotal / numTests, "Error. El barco debería haberse "
                    + "colocado en las casillas siguientes: " + casillasBarcoRef
                    + ", sin embargo se ha colocado en: " + casillasBarco);
            toThrow = toThrow(error, toThrow);
        }
        if (error == null) {
            this.printlnAlways("\tComprobando que el barco está asociado a las "
                    + "casillas correctas en el tablero");
            for (String casillaStr : casillasBarcoRef) {
                error = this.sAssertEquals(barco, casillas.get(casillaStr),
                        valorTotal / numTests, "Error. El barco NO está asociado "
                        + "con la casilla " + casillaStr + "del tablero");
                toThrow = toThrow(error, toThrow);
            }
        }
    }

    private void checkMensaje(String nAtacante, String posAtacada, String resultado,
            String mensaje, double valorTotal, int numTests, String nAtacado,
            AssertionError toThrow, double puntosAntes) {
        try {
            AssertionError error;
            if (nAtacante != null) {
                this.printlnAlways("\t  Comprobando que el mensaje contiene el nombre del atacante");
                error = this.sAssertTrue(mensaje.contains(nAtacante),
                        valorTotal / numTests, "Error. El mensaje enviado a "
                        + "la consola y capturado por el corrector NO "
                        + "contiene el nombre del atacante");
                toThrow = toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\t  Comprobando que el mensaje contiene la "
                    + "coordenada de la casilla atacada");
            error = this.sAssertTrue(mensaje.contains(posAtacada),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene la coordenada de la casilla atacada");
            toThrow = toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobando que el mensaje contiene '"
                    + resultado.toLowerCase() + "' o '"
                    + resultado.toUpperCase() + "'");
            error = this.sAssertTrue(mensaje.contains(resultado.toLowerCase())
                    || mensaje.contains(resultado.toUpperCase()),
                    valorTotal / numTests, "Error. El mensaje enviado a "
                    + "la consola y capturado por el corrector NO "
                    + "contiene ni '" + resultado.toLowerCase() + "' ni '"
                    + resultado.toUpperCase() + "'");
            toThrow = toThrow(error, toThrow);
            if (nAtacado != null) {
                //
                this.printlnAlways("\t  Comprobando que el mensaje contiene el nombre del atacado");
                error = this.sAssertTrue(mensaje.contains(nAtacado),
                        valorTotal / numTests, "Error. El mensaje enviado a "
                        + "la consola y capturado por el corrector cuando el "
                        + "atacante es el jugador máquina NO contiene el nombre "
                        + "del jugador humano atacado");
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

    private Optional<Tablero> creaTableroParaCorregirJuegaPartida() {
        Tablero tablero = new Tablero();
        Submarino submarino = new Submarino("Submarino1");
        Lancha lancha = new Lancha("Lancha1");
        Optional<Object> optCasillas = this.getPrivateFieldValue(tablero, "casillas");
        if (!optCasillas.isPresent()) {
            return Optional.ofNullable(null);
        }
        Map<String, Barco> casillas = (Map<String, Barco>) optCasillas.get();
        casillas.put("A1", submarino);
        casillas.put("A2", submarino);
        casillas.put("A3", submarino);
        casillas.put("J10", lancha);
        return Optional.ofNullable(tablero);
    }

    /*
    ¡¡¡EL CÓDIGO QUE SIGUE A ESTE COMENTARIO ES USADO POR EL CORRECTOR AUTOMÁTICO.
    NO LO MODIFIQUÉIS. SI LO HACÉIS EL CORRECTOR AUTOMÁTICO NO FUNCIONARÁ 
    CORRECTAMETNE!!!
     */
    private static int numAguas = 0;
    private static int numTocados = 0;
    private static int numHundidos = 0;
    private static int numMensajes = 0;
    private static double valorTotalJuegaPartida = 3.1;
    private static int numTestsJuegaPartida = 6;
    private static String primerDisparoDe = "";

    @Override
    public void addObservador(ObservadorObservado observador) {
        throw new UnsupportedOperationException("ControladorTest::addObservador. "
                + "Error. Este método NUNCA debería haber sido invocado!!.");
    }

    public void notificaAgua(Controlador controlador) {
        AssertionError toThrow = null;
        AssertionError error = null;
        ControladorTest.numAguas++;
        ControladorTest.numMensajes++;
        double puntosAntes = puntosTotales;
        try {
            String nombre;
            String quien;
            String mensaje;
            boolean condicion;
            if (ControladorTest.numAguas == 1) {
                mensaje = Controlador.getMensajesAConsola().get(ControladorTest.numMensajes);
                nombre = "";
                quien = "";
                if (ControladorTest.primerDisparoDe.equals("H")) {
                    nombre = "UnNombre";
                    quien = "del humano";
                } else {
                    nombre = "Maquina";
                    quien = "del jugador máquina";
                }
                this.printlnAlways("  Comprobando que el disparo al agua "
                        + quien + " ha sido bien procesado");
                condicion = mensaje.contains(nombre) && mensaje.contains("B1")
                        && (mensaje.contains("agua") || mensaje.contains("AGUA"));
                error = this.sAssertTrue(condicion, ControladorTest.valorTotalJuegaPartida / ControladorTest.numTestsJuegaPartida, "Error. El mensaje "
                        + "generado al tocar agua no parece contener "
                        + "todos los datos que debería, a saber: el nombre del "
                        + "jugador, la posición de disparo Y que ha hecho agua");
                toThrow = this.toThrow(error, toThrow);
            } else {
                if (ControladorTest.primerDisparoDe.equals("H")) {
                    nombre = "Maquina";
                    quien = "del jugador máquina";
                } else {
                    nombre = "UnNombre";
                    quien = "del humano";
                }
                this.printlnAlways("  Comprobando que el disparo al agua "
                        + quien + " ha sido bien procesado");
                mensaje = Controlador.getMensajesAConsola().get(ControladorTest.numMensajes);
                condicion = mensaje.contains(nombre) && mensaje.contains("B3")
                        && (mensaje.contains("agua") || mensaje.contains("AGUA"));
                error = this.sAssertTrue(condicion, ControladorTest.valorTotalJuegaPartida / ControladorTest.numTestsJuegaPartida,
                        "Error. El mensaje generado al tocar agua no parece "
                        + "contener todos los datos que debería, a saber: el "
                        + "nombre del jugador, la posición de disparo Y que ha "
                        + "hecho agua");
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

    public void notificaTocado(Controlador controlador) {
        AssertionError toThrow = null;
        AssertionError error = null;
        ControladorTest.numTocados++;
        ControladorTest.numMensajes++;
        double puntosAntes = puntosTotales;
        try {
            String nombre = "";
            String quien = "";
            String mensaje;
            String ganadoPerdido = "";
            boolean condicion;
            mensaje = Controlador.getMensajesAConsola().get(ControladorTest.numMensajes);
            if (ControladorTest.primerDisparoDe.equals("H")) {
                nombre = "UnNombre";
                quien = "del humano";
            } else {
                nombre = "Maquina";
                quien = "del jugador máquina";
            }
            if (ControladorTest.numTocados == 1) {
                this.printlnAlways("  Comprobando que el disparo de " + quien + ", "
                        + "que ha tocado por primera vez el barco del contrario, "
                        + "ha sido bien procesado");
                condicion = mensaje.contains(nombre) && mensaje.contains("A1")
                        && mensaje.contains("tocado");
                error = this.sAssertTrue(condicion, ControladorTest.valorTotalJuegaPartida / ControladorTest.numTestsJuegaPartida, "Error. El mensaje "
                        + "generado al tocar un barco por primera vez no parece contener "
                        + "todos los datos que debería, a saber: el nombre del "
                        + "jugador, la posición de disparo Y que ha tocado un "
                        + "barco por primera vez");
                toThrow = this.toThrow(error, toThrow);
            } else {
                this.printlnAlways("  Comprobando que el disparo de " + quien + ", "
                        + "que ha tocado un barco del contrario por segunda vez, "
                        + "ha sido bien procesado");
                condicion = mensaje.contains(nombre) && mensaje.contains("A2")
                        && mensaje.contains("tocado");
                error = this.sAssertTrue(condicion, ControladorTest.valorTotalJuegaPartida / ControladorTest.numTestsJuegaPartida, "Error. El mensaje "
                        + "generado al tocar un barco por segunda vez no parece contener "
                        + "todos los datos que debería, a saber: el nombre del "
                        + "jugador, la posición de disparo Y que ha tocado un "
                        + "barco por segunda vez");
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

    public void notificaHundido(Controlador controlador) {
        AssertionError toThrow = null;
        AssertionError error = null;
        ControladorTest.numHundidos++;
        ControladorTest.numMensajes++;
        double puntosAntes = puntosTotales;
        try {
            String nombre = "";
            String quien = "";
            String mensaje;
            String ganadoPerdido = "GANADO";
            boolean condicion;
            mensaje = Controlador.getMensajesAConsola().get(ControladorTest.numMensajes);
            if (ControladorTest.primerDisparoDe.equals("H")) {
                nombre = "UnNombre";
                quien = "del humano";
            } else {
                nombre = "Maquina";
                quien = "del jugador máquina";
            }
            if (ControladorTest.numHundidos == 1) {
                this.printlnAlways("  Comprobando que el disparo de " + quien + ", "
                        + "que ha hundido el primer barco del contrario, "
                        + "ha sido bien procesado");
                condicion = mensaje.contains(nombre) && mensaje.contains("A3")
                        && mensaje.contains("hundido") && mensaje.contains("1");
                error = this.sAssertTrue(condicion, ControladorTest.valorTotalJuegaPartida / ControladorTest.numTestsJuegaPartida, "Error. El mensaje "
                        + "generado al hundir el primer barco no parece contener "
                        + "todos los datos que debería, a saber: el nombre del "
                        + "jugador, la posición de disparo Y que ha hundido 1 "
                        + "barco");
                toThrow = this.toThrow(error, toThrow);
            } else {
                this.printlnAlways("  Comprobando que el disparo de " + quien + ", "
                        + "que ha hundido el segundo barco del contrario, "
                        + "ha sido bien procesado");
                condicion = mensaje.contains(nombre) && mensaje.contains("J10")
                        && mensaje.contains("hundido") && mensaje.contains("2");
                error = this.sAssertTrue(condicion, ControladorTest.valorTotalJuegaPartida / ControladorTest.numTestsJuegaPartida, "Error. El mensaje "
                        + "generado al hundir el segundo barco no parece contener "
                        + "todos los datos que debería, a saber: el nombre del "
                        + "jugador, la posición de disparo Y que ha hundido 2 "
                        + "barcos");
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

    private void ponHumanoEn0(Controlador controlador, double puntosTotales) {
        Optional<Object> optJugadores = this.getPrivateFieldValue(controlador, "jugadores");
        if (!optJugadores.isPresent()) {
            this.finishIfAttrNotPresent("Controlador", "jugadores", puntosTotales);
            return;
        }
        List<Jugador> jugadores = (List<Jugador>) optJugadores.get();
        if (jugadores.get(1) instanceof JugadorHumano) {
            Jugador tmp = jugadores.get(1);
            jugadores.set(1, jugadores.get(0));
            jugadores.set(0, tmp);
        }

    }

    private void clearMensajesConsola() {
        List<String> mensajesConsola = Controlador.getMensajesAConsola();
        mensajesConsola.clear();
        ControladorTest.numMensajes = 0;
    }

}

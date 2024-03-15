/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.lang.reflect.Field;
import java.util.Arrays;
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
public class BarcoTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public BarcoTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        BarcoTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "BarcoTest");
        nota.put("BarcoTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Barco::Barco(..). Valor: " + valorTotal);
        try {
            String expectedNombre = "nombreBarco";
            int expectedLon = 2;
            Barco instance = new Barco(expectedNombre, expectedLon);
           this.checkAttributeAfterConstructor(instance, "nombre", expectedNombre,
                    valorTotal, 0.1, 0.1, 1);
            this.checkAttributeAfterConstructor(instance, "lon", expectedLon,
                    valorTotal, 0.1, 0.1, 3);
            this.checkAttributeAfterConstructor(instance, "hundido", false,
                    valorTotal, 0.1, 0.1, 5);
            this.printlnAlways("\tTest 7: comprobación de existencia de atributos "
                    + "\'posiciones\' (conjunto vacío)");
            this.checkExistCollelctionAndHasNElements(instance, "posiciones", 0,
                    0.2 * valorTotal, error);
            this.printlnAlways("\tTest 8: comprobación de existencia de atributos "
                    + "\'posicionesTocadas\' (conjunto vacío)");
            this.checkExistCollelctionAndHasNElements(instance, "posicionesTocadas", 0,
                    0.2 * valorTotal, error);
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
    public void test02_creaBarco() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 6;
        this.printlnAlways("\nComprobando Barco::creaBarco(..). Valor: " + valorTotal);
        try {
            String[] tipos = {"L", "C", "S", "B", "P", "L"};
            Class[] clases = {Lancha.class, Crucero.class, Submarino.class,
                Buque.class, Portaviones.class, Lancha.class};

            String expectedNombre = "nombreBarco";
            int i = 0;
            for (String tipo : tipos) {
                this.printlnAlways("\tTest " + (i + 1) + ": Creando un barco de tipo " + tipo);
                Barco b = Barco.creaBarco(tipo, expectedNombre);
                this.checkBarcoCreado(tipo, clases[i], expectedNombre, valorTotal / numTests, toThrow);
                i++;
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
    public void test03_getLongitudDeTipoDeBarco() {
        double valorTotal = 1.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 6;
        this.printlnAlways("\nComprobando Barco::getLongitudDeTipoDeBarco(..). Valor: " + valorTotal);
        try {
            String[] tipos = {"L", "C", "S", "B", "P", "L"};
            int[] longitudes = {1, 2, 3, 4, 5, 1};
            int i = 0;
            for (String tipo : tipos) {
                this.printlnAlways("\tTest " + (i + 1) + ": Oteniendo la longitud de un barco de tipo " + tipo);
                this.checkLongitudDeTipoDeBarco(tipo, longitudes[i], valorTotal / numTests, toThrow);
                i++;
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
    public void test04_addPosicionTocada() {
        double valorTotal = 2;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 4;
        this.printlnAlways("\nComprobando Barco::addPosicionTocada(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: Se invoca a barco.addPosicionTocada(\'A6\') "
                    + "sobre un barco previamente creado y sin posición tocada alguna");
            Barco barco = new Barco("Portaviones1", 5);
            barco.addPosicionTocada("A6");
            this.printlnAlways("\t  Comprobando que despúes de de la invocación "
                    + "el tamaño de posicionesTocadas es 1.");
            Optional<Field> optField = this.getPrivateField(barco, "posicionesTocadas");
            if (!optField.isPresent()) {
                this.finishIfAttrNotPresent("barco", "posicionesTocadas", puntosAntes);
                return;
            }
            Field field = optField.get();
            field.setAccessible(true);
            Set<String> posicionesTocadas = (Set<String>) field.get(barco);
            int lon = posicionesTocadas.size();
            error = this.sAssertEquals(1, lon, valorTotal / numTests,
                    "El tamaño de la lista debería ser 1. En su lugar es " + lon);
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\t  Comprobando que despúes de la invocación, "
                    + "\'A6\' está en posicionesTocadas.");
            error = this.sAssertTrue(posicionesTocadas.contains("A6"),
                    valorTotal / numTests, "La posición \"A6\" debería estar en el "
                    + "conjunto posicionesTocadas, pero no lo está.");
            toThrow = this.toThrow(error, toThrow);

            this.printlnAlways("\tCaso 2: Se invoca a barco.addPosicionTocada(\'A7\') "
                    + "sobre el mismo barco");
            barco.addPosicionTocada("A7");
            this.printlnAlways("\t  Comprobando que despúes de la invocación el "
                    + "tamaño de posicionesTocadas es 2.");
            lon = posicionesTocadas.size();
            error = this.sAssertEquals(2, lon, valorTotal / numTests, "El tamaño de "
                    + "la lista debería ser 2. En su lugar es " + lon);
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\t  Comprobando que despúes de la invocación, "
                    + "\'A7\' está en posicionesTocadas.");
            error = this.sAssertTrue(posicionesTocadas.contains("A7"),
                    valorTotal / numTests, "La posición \"A7\" debería estar en el "
                    + "conjunto posicionesTocadas, pero no lo está.");

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
    public void test05_getPosicionesTocadas() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Barco::getPosicionesTocadas(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Se crea un barco; se invoca a "
                    + "barco.addPosicionTocada 2 veces y después se invoca a "
                    + "barco.getPosicionesTocadas()");
            Barco barco = new Barco("Portaviones1", 5);
            barco.addPosicionTocada("A6");
            barco.addPosicionTocada("A7");
            Set<String> gottenPosTocadas = barco.getPosicionesTocadas();
            this.printlnAlways("\tComprobando que el conjunto devuelto "
                    + "por barco.getPosicionesTocadas() es el mismo que "
                    + "el atributo posicionesTocadas de barco.");
            Optional<Field> optField = this.getPrivateField(barco, "posicionesTocadas");
            if (!optField.isPresent()) {
                this.finishIfAttrNotPresent("barco", "posicionesTocadas", puntosAntes);
                return;
            }
            Field field = optField.get();
            field.setAccessible(true);
            Set<String> posicionesTocadas = (Set<String>) field.get(barco);
            int lon = posicionesTocadas.size();
            error = this.sAssertEquals(posicionesTocadas, gottenPosTocadas,
                    1 * valorTotal, "El conjunto devuelto NO es el esperado Se "
                    + "esperaba. Detalles: ");
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
    public void test06_setPosiciones() {
        double valorTotal = 0.5;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Barco::setPosiciones(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Se crea un barco; se crea una lista de posiciones y "
                    + "se invoca a barco.setPosiciones(...) ");
            Barco barco = new Barco("Portaviones1", 5);
            String[] posArray = {"A6", "A7", "A8", "A9", "A10"};
            List<String> posEsperadas = Arrays.asList(posArray);
            barco.setPosiciones(posEsperadas);

            Optional<Field> optField = this.getPrivateField(barco, "posiciones");
            if (!optField.isPresent()) {
                this.finishIfAttrNotPresent("barco", "posiciones", puntosAntes);
                return;
            }
            Field field = optField.get();
            field.setAccessible(true);
            List<String> gottenPos = (List<String>) field.get(barco);
            error = this.sAssertEquals(posEsperadas, gottenPos,
                    1 * valorTotal, "La lista devuelta NO es la esperada. "
                    + "Detalles: ");
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
    public void test07_isHundido() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 2;
        this.printlnAlways("\nComprobando Barco::isHundido(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: se crea un barco; se pone su atributo "
                    + "hundido a true y se invoca a barco.isHundido()");
            Barco barco = new Barco("Lancha1", 1);
            this.setPrivateField(barco, "hundido", true);
            error = this.sAssertTrue(barco.isHundido(), valorTotal / 2,
                    "El método barco.esta_hundido() ha devuelto false cuando el "
                    + "atributo hundido es true.");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tCaso 2: se crea un barco; se pone su atributo "
                    + "hundido a false y se invoca a barco.isHundido()");
            this.setPrivateField(barco, "hundido", false);
            error = this.sAssertFalse(barco.isHundido(), valorTotal / 2,
                    "El método barco.esta_hundido() ha devuelto true cuando el "
                    + "atributo hundido es false.");
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
    public void test08_hundiraEsteTocado() {
        double valorTotal = 1;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 2;
        this.printlnAlways("\nComprobando Barco::hundiraEsteTocado(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: Se crea un barco de dos posiciones y se invoca a "
                    + "barco.hundiraEsteTocado(...). Debería devolver false");
            Barco barco = new Barco("Crucero1", 2);
            error = this.sAssertFalse(barco.hundiraEsteTocado("A6"), valorTotal / 2,
                    "El método barco.hundiraEsteTocado() ha devuelto true cuando"
                    + " debería haber devuelto false.");
            toThrow = this.toThrow(error, toThrow);
            this.printlnAlways("\tCaso 2: Se invoca nuevamente a "
                    + "barco.hundiraEsteTocado(...). Ahora debería devolver "
                    + "true (se ha tocado dos veces a un barco de dos posiciones)");
            error = this.sAssertTrue(barco.hundiraEsteTocado("A7"), valorTotal / 2,
                    "El método barco.hundiraEsteTocado() ha devuelto false cuando"
                    + " debería haber devuelto true.");
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
    public void test09_getLongitud() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Barco::getLongitud(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\t  Se crea un crucero y se invoca a "
                    + "barco.getLongitud(...). Debería devolver 2");
            Barco barco = new Barco("Crucero1", 2);
            error = this.sAssertEquals(2, barco.getLon(), valorTotal,
                    "El método barco.getLon() ha devuelto " + barco.getLon()
                    + " en lugar de " + 2);
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
    public void test10_getPosiciones() {
        double valorTotal = 0.25;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Barco::getPosiciones(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("  Se crea un barco de 5 posiciones y se invoca a "
                    + "barco.getPosiciones()");
            Barco barco = new Barco("Portaviones1", 5);

            List<String> gottenPos = barco.getPosiciones();
            this.printlnAlways("\tComprobando que la lista devuelta "
                    + "por barco.getPosiciones() es el mismo que "
                    + "el atributo posiciones de barco.");
            Optional<Field> optField = this.getPrivateField(barco, "posiciones");
            if (!optField.isPresent()) {
                this.finishIfAttrNotPresent("barco", "posiciones", puntosAntes);
                return;
            }
            Field field = optField.get();
            field.setAccessible(true);
            List<String> expectedPos = (List<String>) field.get(barco);
            int lon = expectedPos.size();
            error = this.sAssertEquals(expectedPos, gottenPos,
                    1 * valorTotal, "La lista devuelto NO es la esperada. Se "
                    + "esperaba. Detalles: ");
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

    private void checkLongitudDeTipoDeBarco(String tipo, int lonEsperada,
            double d, AssertionError toThrow) {
        int longitud = Barco.getLongitudDeTipoDeBarco(tipo);
        AssertionError error = this.sAssertEquals(lonEsperada, longitud, d * 1,
                "Error. Debería debería tener una longitud " + lonEsperada
                + ". En su lugar, su longitud es " + longitud);
        toThrow = this.toThrow(error, toThrow);
    }

    private void checkBarcoCreado(String tipo, Class clase,
            String expectedNombre, double d, AssertionError toThrow) {
        Barco creado = Barco.creaBarco(tipo, expectedNombre);
        AssertionError error = this.sAssertEquals(clase, creado.getClass(), d * 0.5,
                "Error. Debería haber creado un objeto de clase " + clase.getName()
                + ". En su lugar, ha creado un objeto de clase " + creado.getClass().getName());
        toThrow = this.toThrow(error, toThrow);
        error = this.checkFieldValue(creado, "nombre", expectedNombre, d * 0.5, toThrow);
        toThrow = this.toThrow(error, toThrow);
    }
}

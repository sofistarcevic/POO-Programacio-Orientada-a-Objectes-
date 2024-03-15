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
public class SubmarinoTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public SubmarinoTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        SubmarinoTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "SubmarinoTest");
        nota.put("SubmarinoTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_constructor() {
        double valorTotal = 10;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\nComprobando Submarino::Submarino(..). Valor: " + valorTotal);
        try {
            String expectedNombre = "nombreSubmarino";
            int expectedLon = 3;
            Barco instance = new Submarino(expectedNombre);
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

}

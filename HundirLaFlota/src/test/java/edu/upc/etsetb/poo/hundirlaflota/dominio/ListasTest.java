/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import edu.upc.ac.corrector.ReductorTraza;
import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.poo.corrector.TestAll;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ListasTest extends ReductorTraza {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static List<AssertionError> indErrors;

    private static Map<String, Double> nota;

    public ListasTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
        ListasTest.indErrors = SuperClassForTests.indErrors;
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        puntosTotales = 0;
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "ListasTest");
        nota.put("ListasTest", puntosTotales);
        puntosTotales = 0;
    }

    @Test
    public void test01_quitaAUnaOtra() {
        double valorTotal = 10;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        int numTests = 4;
        this.printlnAlways("\nComprobando Listas::quitaAUnaOtra(..). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tCaso 1: Ambas listas están vacías. Resultado vacío");
            List una = new ArrayList();
            List otra = new ArrayList();
            Listas.quitaAUnaOtra(una, otra);
            error = this.sAssertEquals(otra, una, valorTotal / numTests, "Error. "
                    + "La lista resultante debería estar vacía. Detalles: ");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 2: Lista de la que hay que quitar vacía; "
                    + "la lista con lo que hay que quitar NO vacía. Resultado vacío");
            una = new ArrayList();
            String[] otraArr = {"A2", "A3"};
            otra = Arrays.asList(otraArr);
            List<String> esperada = new ArrayList<>();
            Listas.quitaAUnaOtra(una, otra);
            error = this.sAssertEquals(esperada, una, valorTotal / numTests, "Error. "
                    + "La lista resultante debería estar vacía. Detalles: ");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 3: Lista de la que hay que quitar "
                    + "NO vacía; la lista con lo que hay que quitar vacía. "
                    + "Resultado lista inicial no cambiada");
            String[] unaArr = {"A1", "A3", "A4"};
            una = new ArrayList(Arrays.asList(unaArr));
            otra = new ArrayList<>();
            esperada = new ArrayList<>(una);
            Listas.quitaAUnaOtra(una, otra);
            error = this.sAssertEquals(esperada, una, valorTotal / numTests, "Error. "
                    + "La lista resultante debería estar vacía. Detalles: ");
            toThrow = this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tCaso 4: Ninguna de las listas está vacía. "
                    + "Resultado lista inicial - lista a quitar");
            String[] unaArr2 = {"A1", "A3", "A4"};
            una = new ArrayList(Arrays.asList(unaArr2));
            String[] otraArr2 = {"B1", "A3", "A4"};
            otra = Arrays.asList(otraArr2);
            esperada = new ArrayList<>();
            esperada.add("A1");
            Listas.quitaAUnaOtra(una, otra);
            error = this.sAssertEquals(esperada, una, valorTotal / numTests, "Error. "
                    + "La lista resultante debería estar vacía. Detalles: ");
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

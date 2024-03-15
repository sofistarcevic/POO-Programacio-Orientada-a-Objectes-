/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.corrector;

import edu.upc.ac.corrector.SuperClassForTests;
import java.util.HashMap;
import java.util.Map;
import org.junit.rules.ErrorCollector;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class TestAll {

    private static String[] clases = {
        "PosicionTest", "ListasTest", "BarcoTest", "LanchaTest",
        "CruceroTest", "SubmarinoTest", "BuqueTest",
        "PortavionesTest", "TableroTest", "JugadorTest",
        "JugadorMaquinaTest", "JugadorHumanoTest", "Posicion2Test",
        "Tablero2Test","GeneradorDeFlotasTest","ControladorTest"};

    public static final double[] tantosPorCiento = {
        15, //PosicionTest
        1, //ListasTest
        10, //BarcoTest
        1, //LanchaTest
        1, //CruceroTest
        1, //SubmarinoTest
        1, //BuqueTest
        1, //PortavionesTest
        10, //TableroTest
        6.5,//JugadorTest
        20, //JugadorMaquinaTest
        5,  //JugadorHumanoTest
        15, //Posicion2Test
        10, //Tablero2Test
        5, //GeneradorDeFlotasTest
        22.5 //ControladorTest
    };

    public static Map<String, Double> notas;
    public static Map<String, Double> porcentajes;

    public static ErrorCollector allCollector;

    static {
        notas = new HashMap<>();
        porcentajes = new HashMap<>();
//        allCollector = SuperClassForTests.allCollector;
        int i = -1;
        for (String className : clases) {
            i++;
            notas.put(className, 0.0);
            porcentajes.put(className, tantosPorCiento[i]);
        }
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(edu.upc.poo.corrector.TestSuite.class);
        System.out.println("\n\nResumen de notas obtenidas en corrección automática:\n");
        double notaFinal = 0;
        double notaParcial;
        for (Map.Entry<String, Double> nota : notas.entrySet()) {
            String className = nota.getKey();
            notaParcial = nota.getValue() * porcentajes.get(className) / 100;
            notaFinal += notaParcial;
            System.out.println("Nota en clase " + className
                    + ": " + SuperClassForTests.withMathRound(nota.getValue(), 3) + " (Porcentaje en nota final: "
                    + porcentajes.get(className) + "%). Contribución a nota final: " + notaParcial);
        }
        System.out.println("\nNota final de corrección automática: " + SuperClassForTests.withMathRound(notaFinal, 3));
    }
}

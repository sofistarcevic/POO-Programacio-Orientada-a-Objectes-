/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.corrector;


import edu.upc.etsetb.poo.hundirlaflota.casosdeuso.ControladorTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.BarcoTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.BuqueTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.CruceroTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.GeneradorDeFlotasTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorHumanoTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorMaquinaTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.LanchaTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.ListasTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.PortavionesTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Posicion2Test;
import edu.upc.etsetb.poo.hundirlaflota.dominio.PosicionTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.SubmarinoTest;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Tablero2Test;
import edu.upc.etsetb.poo.hundirlaflota.dominio.TableroTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@RunWith(Suite.class)
@SuiteClasses({
    PosicionTest.class,
    ListasTest.class,
    BarcoTest.class,
    LanchaTest.class,
    CruceroTest.class,
    SubmarinoTest.class,
    BuqueTest.class,
    PortavionesTest.class,
    TableroTest.class,
    Posicion2Test.class,
    JugadorTest.class,
    JugadorMaquinaTest.class,
    JugadorHumanoTest.class,
    Tablero2Test.class,
    GeneradorDeFlotasTest.class,
    ControladorTest.class
})
public class TestSuite {

}

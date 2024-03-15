/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.iu;

import edu.upc.etsetb.poo.hundirlaflota.casosdeuso.Controlador;
import edu.upc.etsetb.poo.hundirlaflota.dominio.ArchivoFlotaException;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Posicion;
import edu.upc.etsetb.poo.hundirlaflota.dominio.PositionException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class Gui {

    private Entregador renderer;

    private Controlador controlador;

    private Scanner scanner;

    public Gui() {
        this.renderer = new Entregador(this);
        this.controlador = new Controlador(this, this.renderer);
        this.scanner = new Scanner(System.in);
    }

    public void print(String mssg) {
        System.out.print(mssg + " ");
    }

    public void println(String mssg) {
        System.out.println(mssg + " ");
    }

    public void println() {
        System.out.println();
    }

    public String preguntaPorDisparo() {
        String posicionAtacada = "";
        while (true) {
            System.out.println("¿A qué coordenada quieres disparar?");
            posicionAtacada = this.scanner.nextLine();
            if (posicionAtacada.toUpperCase().startsWith("Q")) {
                System.out.println("Ejecución finalizada a petición del usuario");
                System.exit(0);
            }
            if (Posicion.esCorrecta(posicionAtacada.trim().replaceAll("\\s+", ""))) {
                return posicionAtacada;
            }
        }
    }

    public void preparaPartidaMaquinaDetVsMaquinaDet() throws PositionException {
        this.controlador.preparaPartidaMaquinaDetVsMaquinaDet();
    }

    public void juegaPartida() throws PositionException {
        this.controlador.juegaPartida();
    }

    public void preparaPartidaHumanoDetVsMaquinaDet(String nombreJugador) 
            throws PositionException {
        this.controlador.preparaPartidaJHumanoDetVsMaquinaDet(nombreJugador);
    }
    
    public void preparaPartidaHumanoFichVsMaquinaAl(String nombreJugador,
            String pathFicheroFlota) 
            throws PositionException, IOException, ArchivoFlotaException {
        this.controlador.preparaPartidaHumanoFichVsMaquinaAl(nombreJugador, 
                pathFicheroFlota);
    }
}

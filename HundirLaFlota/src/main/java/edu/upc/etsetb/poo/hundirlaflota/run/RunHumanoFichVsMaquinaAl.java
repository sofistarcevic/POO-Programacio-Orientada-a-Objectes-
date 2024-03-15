/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.run;

import edu.upc.etsetb.poo.hundirlaflota.dominio.ArchivoFlotaException;
import edu.upc.etsetb.poo.hundirlaflota.dominio.PositionException;
import edu.upc.etsetb.poo.hundirlaflota.iu.Gui;
import java.io.IOException;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class RunHumanoFichVsMaquinaAl {
    public static void main(String[] args){
        try {
            Gui gui = new Gui();           
            gui.preparaPartidaHumanoFichVsMaquinaAl("nombreJugador",
                    System.getProperty("user.dir")+"/flota_jugador_det.txt");
            gui.juegaPartida();
        } catch (PositionException ex) {
            System.out.println("Error en el desarrollo del juego. Se ha "
                    + "generado alguna posición no correcta o se ha hecho "
                    + "algo incorrecto con alguna posición");
            System.exit(-1);
        } catch (IOException ex) {
            System.out.println("Error en el desarrollo del juego. Se ha "
                    + "producido un error de entrada/salida.");
            System.exit(-1);
        } catch (ArchivoFlotaException ex) {
            System.out.println("Error en el desarrollo del juego. Se ha "
                    + "detectado un error en el archivo de la flota. "
                    + "Detalles: " + ex.getMessage());
           System.exit(-1);
        }
    }      
}

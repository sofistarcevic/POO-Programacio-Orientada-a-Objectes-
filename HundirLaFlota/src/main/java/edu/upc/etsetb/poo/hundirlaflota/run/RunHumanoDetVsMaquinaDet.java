/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.run;

import edu.upc.etsetb.poo.hundirlaflota.dominio.PositionException;
import edu.upc.etsetb.poo.hundirlaflota.iu.Gui;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class RunHumanoDetVsMaquinaDet {
    public static void main(String[] args){
        try {
            Gui gui = new Gui();           
            gui.preparaPartidaHumanoDetVsMaquinaDet("nombreJugador");
            gui.juegaPartida();
        } catch (PositionException ex) {
            System.out.println("Error en el desarrollo del juego. Se ha "
                    + "generado alguna posición no correcta o se ha hecho "
                    + "algo incorrecto con alguna posición");
            System.exit(-1);
        }
    }    
}

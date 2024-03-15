/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.iu;

import edu.upc.etsetb.poo.hundirlaflota.dominio.Barco;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Buque;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Crucero;
import edu.upc.etsetb.poo.hundirlaflota.dominio.JugadorHumano;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Lancha;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Portaviones;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Posicion;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Submarino;
import edu.upc.etsetb.poo.hundirlaflota.dominio.Tablero;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class Entregador {

    private Gui iu;

    private String[][] visorDisparos = {
        {"A ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"B ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"C ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"D ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"E ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"F ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"G ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"H ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"I ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"J ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}
    };

    private String[][] tableroJugador = {
        {"A ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"B ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"C ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"D ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"E ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"F ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"G ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"H ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"I ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"},
        {"J ", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"}
    };

    public Entregador(Gui gui) {
        this.iu = gui;
    }

    public String representaBarco(Barco barco) {
        if (barco instanceof Lancha) {
            return "[L]";
        } else if (barco instanceof Crucero) {
            return "[C]";
        } else if (barco instanceof Submarino) {
            return "[S]";
        } else if (barco instanceof Buque) {
            return "[B]";
        } else if (barco instanceof Portaviones) {
            return "[P]";
        }
        return "[ ]";
    }


    public void datosATableros(Tablero tablero, List<String> aguas) {
        for (String pos : tablero.getPosicionesBarcos()) {
            Barco barco = tablero.getBarcoEn(pos);
            int columna = Integer.parseInt(pos.substring(1));
            if (barco.isHundido()) {
                this.tableroJugador[Posicion.filaCharToInt(pos)-1][columna] = "[H]";
            } else if(barco.getPosicionesTocadas().contains(pos)){
                this.tableroJugador[Posicion.filaCharToInt(pos)-1][columna] = "[T]";
            }else{
                this.tableroJugador[Posicion.filaCharToInt(pos)-1][columna] = 
                        this.representaBarco(barco);
            }
        }
        for(String pos: aguas){
            int columna = Integer.parseInt(pos.substring(1));
            this.tableroJugador[Posicion.filaCharToInt(pos)-1][columna] = "[X]";
        }
    }
    
    public void datosAVisorDeAtaque(Map<String,String> visorDeAtaque){
        for(String pos: visorDeAtaque.keySet()){
            int columna = Integer.parseInt(pos.substring(1));
            String valor = visorDeAtaque.get(pos);
            this.visorDisparos[Posicion.filaCharToInt(pos)-1][columna] = "["+valor+"]";
        }
    }
    
    public void muestraTablerosHumano(JugadorHumano jugador){
        Map<String,String> visor = jugador.getVisorDeAtaque();
        Tablero tablero = jugador.getTablero();
        List<String> aguas = tablero.getDisparosAAgua();
        this.datosAVisorDeAtaque(visor);
        this.datosATableros(tablero, aguas);
        this.iu.println();
        this.iu.println("        TABLERO DE BARCOS PROPIOS                  VISOR DE DISPAROS REALIZADOS Y RESULTADOS");
        this.iu.println("   1   2   3   4   5   6   7   8   9   10            1   2   3   4   5   6   7   8   9   10");
        for(int i=0;i<10;i++){
            this.iu.print(Posicion.filaIntToFilaChar(i+1));
            //Presentar fila de tablero de barcos propios
            for(int j=0;j<10;j++){
                this.iu.print(this.tableroJugador[i][j+1]);
            }
            //Separación entre tablero y visor más nombre de fila
            this.iu.print("        "+Posicion.filaIntToFilaChar(i+1));
            //Presentar fila de visor de ataque
            for(int j=0;j<10;j++){
                this.iu.print(this.visorDisparos[i][j+1]);
            }
            this.iu.println();
        }
    }
}

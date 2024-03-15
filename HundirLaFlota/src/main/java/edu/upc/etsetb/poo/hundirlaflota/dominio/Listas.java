/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import java.util.List;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class Listas {

    /**
     * Crea y retorna una lista resultante de quitar a la lista pasada como
     * primer argumento los elementos de la lista pasada como segundo argumento.
     *
     * El método elimina de la lista pasada en el primer argumento aquellos 
     * elementos que también estén en la lista pasada como segundo argumento.
     *
     * @param una la lista de la cual queremos quitar elementos.
     *
     * @param otra la segunda lista. El método debe quitar de la lista una los 
     * elementos que estén en una y en otra.
     *
     */
    public static void quitaAUnaOtra(List<String> una,
            List<String> otra) {
       
        una.removeAll(otra);
    } 
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class Crucero extends Barco{
    
    /**Inicializa el crucero.
    *
    * Inicializa el atributo nom el valor del argumento. Inicializa el atributo 
    * lon a 2. Crea posiciones como una lista vacía, crea el conjunto 
    * posTocadas como un conjunto vacío y hundido a false.
    *
    * @param nombre   el nombre del barco.
    */
    public Crucero(String nombre){
        super(nombre,2);
        boolean hundido = false;
    }
}

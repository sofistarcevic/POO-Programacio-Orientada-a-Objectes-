/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.casosdeuso;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public interface IObservadorObservado {
    
    public void addObservador(ObservadorObservado observador);

    public void notificaAgua(Controlador controlador);

    public void notificaTocado(Controlador controlador);

    public void notificaHundido(Controlador controlador);
        
}

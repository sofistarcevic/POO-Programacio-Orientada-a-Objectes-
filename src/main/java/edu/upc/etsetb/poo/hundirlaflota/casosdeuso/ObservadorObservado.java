/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.casosdeuso;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class ObservadorObservado {

    private IObservadorObservado testControlador;

    private List<ObservadorObservado> observadores;

    public ObservadorObservado(IObservadorObservado testControlador) {
        this.observadores = new ArrayList<>();
        this.testControlador = testControlador;
    }

    public void addObservador(ObservadorObservado observador) {
        this.observadores.add(observador);
    }

    public void notificaAgua(Controlador controlador) {
        this.testControlador.notificaAgua(controlador);
    }

    public void notificaTocado(Controlador controlador) {
        this.testControlador.notificaTocado(controlador);
    }

    public void notificaHundido(Controlador controlador) {
        this.testControlador.notificaHundido(controlador);
    }

}

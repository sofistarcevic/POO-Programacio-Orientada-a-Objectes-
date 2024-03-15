/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.dominio;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class ArchivoFlotaException extends Exception {

    /**
     * Creates a new instance of <code>ArchivoFlotaException</code> without
     * detail message.
     */
    public ArchivoFlotaException() {
    }

    /**
     * Constructs an instance of <code>ArchivoFlotaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ArchivoFlotaException(String msg) {
        super(msg);
    }
}

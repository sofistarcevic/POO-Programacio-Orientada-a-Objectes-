/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.hundirlaflota.casosdeuso;

import java.util.Random;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class MyRandom {

    private Random random;
    
    public MyRandom(){
        this.random = new Random(System.currentTimeMillis());
    }
    
    public int nextInt(int bound){
        return this.random.nextInt(bound);
    }
    
}

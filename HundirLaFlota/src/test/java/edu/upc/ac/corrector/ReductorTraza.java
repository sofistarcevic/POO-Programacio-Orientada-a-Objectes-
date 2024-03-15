/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.ac.corrector;

import java.util.ArrayList;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class ReductorTraza extends SuperClassForTests{
    
    public ReductorTraza(){
        super();
    }
    
    protected StackTraceElement[] reduceST(StackTraceElement[] orStack){
        ArrayList<StackTraceElement> resList = new ArrayList<>();
        for(StackTraceElement el: orStack){
            String classN = el.getClassName();
            if(classN.contains("edu.upc")){
                resList.add(el);
            }
        }    
        //Si no se ha generado en ningún método edu.upc, coger los tres
        //primeros elementos de la traza; si no hay tres coger los que haya.
        if(resList.isEmpty()){
            int num = 0;
            for(StackTraceElement el: orStack){
                num++;
                if(num==3){
                    break;
                }
                resList.add(el);
            }
        }
        return resList.toArray(new StackTraceElement[0]);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberint.model;

/**
 *
 * @author sofij
 */
public abstract class SecretElement {
    public static final int ELEMENT_USED = 1;
    public static final int OK_ACTION = 0;       //Codis d'èxit o error
    public static final int WRONG_KEY = 2;
    protected Item keyModel;    //Cal un Item clau idèntic a keyModel per activar l'element secret
    protected String name;
    protected boolean used;     //False, si l'element ja ha estat utilitzat
    protected Room where;       //indica a quina sala està l'element secret
    
    public SecretElement(String name, Item model, Room here){
        this.name = name;
        this.keyModel = model;
        this.where = here;
        this.used = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    /*métode polimòrfic.  Cada subclasse en fa una implementació diferent.
    Aquí fem la gestió d'errors, que és el denominador comú de les classes filles.
    Parameters:
    key, - amb aquest Item provem de d'activar l'element.
    Returns:
    OK_ACTION si tot és correcte i es pot activar el secret; ELEMENT_USED si ja
    l'ha utilitzat abans; i WRONG_KEY si l'item utilitzat no és la clau que activa
    el secret.
    */    
    public int use(Item key){
        if(this.keyModel.equals(key)){
            if(!this.used)
                return SecretElement.ELEMENT_USED;
            return SecretElement.OK_ACTION;
        }
        return SecretElement.WRONG_KEY;
    }
}

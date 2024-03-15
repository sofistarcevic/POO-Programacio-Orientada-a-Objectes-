/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberint.model;

/**
 *
 * @author sofij
 */
public class SecretDoor extends SecretElement{
    
    private Room hiddenR;
    
    public SecretDoor(String name, Item keyModel, Room here, Room hiddenR){
        super(name, keyModel, here);
        this.hiddenR = hiddenR;
    }
    
    /*Si el SecretDoor no ha estat utilitzat i l'item clau que rep com a paràmetre
    és igual que keyModel, conecta la sala where amb l'habitacio hiddenR per mitjà
    de la sortida name.
    */
    @Override
    public int use(Item key){
        if(this.keyModel.equals(key)){
            if(!this.used){
                this.where.connect(hiddenR, name);
                return ELEMENT_USED;
            }
            return OK_ACTION;
        }
        return WRONG_KEY;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberint.model;

/**
 *
 * @author sofij
 */
public class SecretContainer extends SecretElement{
    
    private Item hidden;
    
    public SecretContainer(String name, Item keyModel, Room here, Item hidden){
        super(name, keyModel, here);
        this.hidden = hidden;
    }
    
    /*Si el SecretContainer no ha estat utilitzat i l'item key que rep com a
    paràmetre és igual que keyModel, posa l'item hidden a la sala where.*/
    @Override
    public int use(Item key){
        if(this.keyModel.equals(key)){
            if(!this.used){
                this.where.putItem(this.hidden);
                return SecretContainer.ELEMENT_USED;
            }
            return SecretContainer.OK_ACTION;
        }
        return SecretContainer.WRONG_KEY;
    }
}

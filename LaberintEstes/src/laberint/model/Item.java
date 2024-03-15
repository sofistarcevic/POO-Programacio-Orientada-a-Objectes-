package laberint.model;

import java.util.Objects;

/** Atributs i mètodes dels items. */
public class Item {
    
    private final String name;
    private final String description;
    private int value;                  //Valor de l'item
    private int encumbrance;            //Càrrega (encumbrance) de l'item.
    
    /**
     * Constuctor d'un item. Inicialitza el valor a 0 i l'encumbrance a 0.
     * @param name - Nom de l'item.
     * @param description - Descripció d l'item.
     */
    public Item(String name, String description){
        this.name = name;
        this.description = description;
        this.value = 0;
        this.encumbrance = 0;
    }
    
    /**
     * Mètode accessor (lectura) del nom.
     * @return Nom de l'item.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Mètode accessor (lectura) de la càrrega.
     * @return Càrrega de l'objecte.
     */
    public int getEncumbrance(){
        return this.encumbrance;
    }

    /**
     * Mètode accessor (escriptura) de la càrrega.
     * @param enc - Càrrega de l'objecte.
     */
    public void setEncumbrance(int enc){
        this.encumbrance = enc;
    }
    
    /**
     * Métode accessor (escriptura) del valor.
     * @param value - Valor de l'objecte.
     */
    public void setValue(int value){
        this.value = value;
    }
    
    
    /** Retorna una String amb el valor dels atributs de l'Item.
     * @return la descripció textual de l'Item.
     */
    @Override
    public String toString(){
        return "[" + this.name + ", valor " + this.value + ", car " + this.encumbrance + "] " + this.description;
    }
    
    /**
     * Laberint Estès: Compara si l'item this és igual a l'item que rep com a parametre,
     * en el valor de cada un dels seus atributs. La primera linia d'aquest mètode ha 
     * de ser Item item = (Item) object; per convertir l'Object que rep com a parèmetre en Item.
     * @param object - l'objecte que rep com a paràmetre.
     * @return true si son iguals, false en cas contrari.
     */
    @Override
    public boolean equals(Object object){
        Item item = (Item) object;
        
        if(!this.name.equals(item.name)) return false;
        else if(!this.description.equals(item.description)) return false;
        else if(this.value!=item.value) return false;
        else if(this.encumbrance!=item.encumbrance) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + this.value;
        hash = 59 * hash + this.encumbrance;
        return hash;
    }
}

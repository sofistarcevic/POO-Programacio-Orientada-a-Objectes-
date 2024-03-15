package laberint.model;

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
     * @return la descripció textual de l'Item
     */
    @Override
    public String toString(){
        return "[" + this.name + ", valor " + this.value + ", car " + this.encumbrance + "] " + this.description;
    }
}

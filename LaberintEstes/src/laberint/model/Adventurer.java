package laberint.model;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/** Atributs i mètodes de l'Aventurer. */
public class Adventurer {

    private static final int MAX_ENCUMBRANCE = 15;
    
    public static final int OK_ACTION = 0;
    public static final int NO_SUCH_EXIT = 1;
    public static final int INVENTORY_IS_FULL = 2;
    public static final int NO_SUCH_ITEM_IN_INVENTORY = 3;
    public static final int NO_SUCH_ITEM_IN_ROOM = 4;
    public static final int NO_SUCH_ELEMENT_IN_ROOM = 5;
    
    private final String name;                  //El nom de l'aventurer
    private Room currentLocation;               //La sala on està l'aventurer actualment.
    private int encumbrance;                    //La càrrega (encumbrance) acumulada de tots els items que té a l'inventari.
    private final Map<String, Item> inventory;  //L'inventari d'items que l'aventurer ha recollit fins ara.
    
    /**
     * Constructor de l'adventurer.  Inicialment no té cap item a l'inventari, i l'encumbrance inicial és 0.
     * @param name - Nom de l'aventurer.
     * @param startLocation - Sala on inicia l'aventura.
     */
    public Adventurer(String name, Room startLocation){
        this.name = name;
        this.currentLocation = startLocation;
        this.encumbrance = 0;
        this.inventory = new TreeMap<>();
    }
    
    /**
     * Métode accessor (lectura) del nom.
     * @return Nom de l'aventurer.
     */
    public String getName(){
        return this.name;
    }
    
    /** Obté la ubicació actual de l'adventurer.
     * @return La sala actual.
     */
    public Room getCurrentLocation(){
        return this.currentLocation;
    }

    /** Fa que l'aventurer es mogui cap a una de les sortides de la sala actual.
     * @param exitName - nom de la sortida cap on s'ha de moure.
     * @return OK_ACTION si tot és correcte; NO_SUCH_EXIT si no existeix la sortida.
     */
    public int move(String exitName){
        Room sortida = this.currentLocation.nextRoom(exitName);
        if(sortida==null)
            return Adventurer.NO_SUCH_EXIT;
        
        this.currentLocation.connect(sortida, exitName);
        this.currentLocation = sortida;
        return Adventurer.OK_ACTION;
    }
    
    /** Fa que l'adventurer agafi un item
     * @param itemName - Nom de l'item.
     * @return OK_ACTION si tot és correcte; NO_SUCH_ITEM_IN_ROOM si a la sala actual
     * no hi ha aquest item; INVENTORY_IS_FULL si l'inventari és ple i el nou item no
     * hi cap (si amb el nou item l'encumbrance de l'aventurer supera MAX_ENCUMBRANCE).
     * Actualitza encumbrance.
     */
    public int pickUp(String itemName){
        Item itemAgafat = this.currentLocation.retrieveItem(itemName);
        
        if(itemAgafat==null){
            this.currentLocation.putItem(itemAgafat);
            return Adventurer.NO_SUCH_ITEM_IN_ROOM;
        }
        if(this.encumbrance+itemAgafat.getEncumbrance()>Adventurer.MAX_ENCUMBRANCE){
            this.currentLocation.putItem(itemAgafat);
            return Adventurer.INVENTORY_IS_FULL;
        }
        this.inventory.put(itemName, itemAgafat);
        this.encumbrance=this.encumbrance + itemAgafat.getEncumbrance();
        return Adventurer.OK_ACTION;
    }
    
    /** Fa que l'adventurer deixi caure un item (l'item s'extreu de l'inventari i
     * s'afegeix a la sala actual).
     * @param itemName - Nom de l'item que ha de deixar.
     * @return OK_ACTION si tot és correcte; NO_SUCH_ITEM_IN_INVENTORY si l'aventurer
     * no te aquest item a l'inventari. Actualitza encumbrance.
     */
    public int drop(String itemName){
        if(!this.inventory.containsKey(itemName))
            return Adventurer.NO_SUCH_ITEM_IN_INVENTORY;
        
        Item itemDrop = this.inventory.remove(itemName);
        this.currentLocation.putItem(itemDrop);
        this.encumbrance+=-itemDrop.getEncumbrance();
        return Adventurer.OK_ACTION;
    }
    
    /**
     * LabEstes: Ordena a l'aventurer a utilitzar un item per activar un element.
     * @param itemName - Nom de l'item.
     * @param elementName - Nom de l'element.
     * @return SecretElement.OK_ACTION si tot correcte; SecretElement.ELEMENT_USED
     * si l'element ja ha estat utilitzat; SecretElement.WRONG_KEY si l'item clau
     * no activa l'element; Adventurer.NO_SUCH_ITEM_IN_INVENTORY si l'item no està
     * a l'inventari, i Adventurer.NO_SUCH_ELEMENT_IN_ROOM si la sala no conté l'element.
     */
    public int useItemOnElement(String itemName, String elementName){
        Item item = null;
        for(Item i:this.inventory.values()){
            if(i.getName().equals(itemName)){
                item = i;
                break;
            }
        }
        if(item==null) return Adventurer.NO_SUCH_ITEM_IN_INVENTORY;
        
        SecretElement element = this.currentLocation.getElement(elementName);
        if(element==null) return Adventurer.NO_SUCH_ELEMENT_IN_ROOM;
        
        return element.use(item);
    }
    
    
    /** Retorna un String amb les dades de tots els items de l'inventari de l'aventurer.
     * @return Iterador.
     */
    public String inventoryToString() {
        String text = "";
        Iterator<Item> itItems = this.inventory.values().iterator();
        if (itItems.hasNext() == false) {
            text = "No tens cap item.\n";
        } else {
            while (itItems.hasNext()) {
                Item item = itItems.next();
                text += item.toString() + "\n";
            }
        }
        return text;
    }
}

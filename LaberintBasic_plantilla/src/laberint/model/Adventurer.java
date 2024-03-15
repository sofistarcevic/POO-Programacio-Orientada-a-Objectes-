package laberint.model;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import laberint.excepcions.LaberintException;


public class Adventurer {
    
    private static final int MAX_ENCUMBRANCE = 15;  //Càrrega màxima que pot suportar l'adventurer
    
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
     * Si no existeix la sortida, llença una LaberintException amb el missatge "No such exit".
     * @throws LaberintException
     */
    public void move(String exitName) throws LaberintException{
        Room sortida = this.currentLocation.nextRoom(exitName);
        if(sortida==null)
            throw new LaberintException("No such exit");
        
        this.currentLocation.connect(sortida, exitName);
        this.currentLocation = sortida;
    }
    
    /** Fa que l'adventurer agafi un item
     * @param itemName - Nom de l'item.
     * Si a la sala actual no hi ha aquest item llença una LaberintException amb el
     * missatge "No such item in room"; Si l'inventari és ple i el nou item no hi cap
     * (és a dir, si amb el nou item l'encumbrance de l'aventurer supera MAX_ENCUMBRANCE),
     * aleshores llença una LaberintException amb el missatge "Inventory is full".
     * Actualitza encumbrance.
     * @throws LaberintException
     */
    public void pickUp(String itemName) throws LaberintException{
        Item itemAgafat = this.currentLocation.retrieveItem(itemName);
        
        if(itemAgafat==null){
            this.currentLocation.putItem(itemAgafat);
            throw new LaberintException("No such item in room");
        }
        if(this.encumbrance+itemAgafat.getEncumbrance()>Adventurer.MAX_ENCUMBRANCE){
            this.currentLocation.putItem(itemAgafat);
            throw new LaberintException("Inventory is full");
        }
        this.inventory.put(itemName, itemAgafat);
        this.encumbrance=this.encumbrance + itemAgafat.getEncumbrance();
    }
    
    
    /** Fa que l'adventurer deixi caure un item (l'item s'extreu de l'inventari i
     * s'afegeix a la sala actual).
     * @param itemName - Nom de l'item que ha de deixar.
     * Si l'aventurer no te aquest item
     * a l'inventari, llença una LaberintException amb el missatge "No disposes de
     * cap item amb aquest nom.". Actualitza encumbrance.
     * @throws LaberintException
     */
    public void drop(String itemName) throws LaberintException{
        if(!this.inventory.containsKey(itemName))
            throw new LaberintException("No disposes de cap item amb aquest nom.");
        
        Item itemDrop = this.inventory.remove(itemName);
        this.currentLocation.putItem(itemDrop);
        this.encumbrance+=-itemDrop.getEncumbrance();
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

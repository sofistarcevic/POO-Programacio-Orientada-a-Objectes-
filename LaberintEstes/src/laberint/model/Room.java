package laberint.model;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


public class Room {
    
    public static final boolean SHOW_SECRET_ELEMENTS = false;    /*Per fer proves: Si aquesta constant
        val true, toString() ha de llistar també els elements secrets de la sala (veure toString()).*/
    
    private final String name;              //Nom de la sala.
    private final String description;       //Descripció de la sala.
    private final Map<String, Item> items;  //Map dels items que hi ha a la sala <Nom item,Item>.
    private final Map<String, Room> exits;  //Map de les sortides de la sala <Nom sortida,Sala a la que s'accedeix per aquesta sortida>.
    private final Map<String, SecretElement> elements;   //Map dels elements secrets que hi ha a la sala.
    
    /**
     * Constructor d'una sala. Inicialment, no té cap item ni cap sortida.
     * @param name - Nom de la sala.
     * @param description - Descripció de la sala.
     */
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.items = new HashMap<>();
        this.exits = new HashMap<>();
        this.elements = new HashMap<>();
    }
    
    /**
     * Mètode accessor (getter) del nom.
     * @return Nom de la sala.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Mètode accessor (setter) dels l'items de la sala. Afegeix un item als items de la sala.
     * @param item - Item que hi ha a la sala.
     */
    public void putItem(Item item){
        this.items.put(item.getName(), item);
    }
        
    /**
     * Cerca un item amb un cert nom a la sala i el recupera. Aquest deixa d'estar a la sala.
     * @param itemName - Nom de l'item que es vol recuperar.
     * @return Item recuperat o null si no existeix cap item amb aquest nom.
     */
    public Item retrieveItem(String itemName){
        if(!this.items.containsKey(itemName)) return null;
        return this.items.remove(itemName);
    }
    
    /**
     * Connecta unidireccionalment aquesta sala amb una altra.
     * @param destination - Sala destí.
     * @param exitName - Nom de l'accés o sortida que permet accedir a la sala destí.
     */
    public void connect(Room destination, String exitName){
        this.exits.put(exitName, destination);
    }
    
    /**
     * Retorna la sala a la qual s'accedeix per una sortida donada.
     * @param exitName - Nom de la sortida o accés cap on es vol anar.
     * @return Sala destí, o null si no existeix tal sortida.
     */
    public Room nextRoom(String exitName){
        return this.exits.get(exitName);
    }

    /**
     * LabEstès: Retorna l'element secret que té el nom indicat. L'element es queda a la sala.
     * @param elementName
     * @return L'element secret, null si no n'existeix cap element amb aquest nom.
     */
    public SecretElement getElement(String elementName){
        
        for(SecretElement e:this.elements.values())
            if(e.getName().equals(elementName))
                return e;
            
        return null;
    }
    
    /**
     * LabEstès: Afegeix un element secret al map d'elements de la sala.
     * @param el - l'element que posem a la sala.
     */
    public void putElement(SecretElement el){
        this.elements.put(el.getName(), el);
    }
     
    /** Retorna una String amb el valor actual dels atributs de la Room.
     * @return la String.
     */
    @Override
    public String toString(){
        String text = "[" + this.getName() + "]\n";
        text += this.description + "\n";
        Iterator<String> itemNames = this.items.keySet().iterator();
        if (itemNames.hasNext() == false) {
            text += "No hi ha cap item en aquesta sala.\n";
        } else {            
            while (itemNames.hasNext()) {
                String itName = itemNames.next();
                text += "Pots veure que hi ha un item [" + itName + "].\n";
            }
        }
        text += "Accessos:";
        Iterator<String> itExitNames = this.exits.keySet().iterator();
        while (itExitNames.hasNext()) {
            String exit = itExitNames.next();
            text += " " + exit;
        }
        text += "\n";
        return text;
    }
}

package laberint.controller;

import java.util.HashMap;
import laberint.model.Adventurer;
import laberint.model.Item;
import laberint.model.Room;
import laberint.model.SecretContainer;
import laberint.model.SecretDoor;
import laberint.model.SecretElement;
import laberint.userinterface.UserInterface;

/** 
 * Controlador: gestiona l'execució de cada una de les comandes que composen
 * l'aplicació.
 */
public class Controller {

    private final UserInterface ui;
    private Adventurer adventurer;
    private final HashMap<String,Room> allRooms;
    private final HashMap<String,Item> allItems;
    /** LabEstes: mapa amb tots els elements secrets. */
    private final HashMap<String,SecretElement> allElements;
    private String objectiuJoc;

    /** 
     * Constructor del controlador.
     * @param iu
     */
    public Controller(UserInterface iu){
        this.ui=iu;
        this.adventurer=null;
        this.objectiuJoc="";
        this.allRooms=new HashMap<>();
        this.allItems=new HashMap<>();
        this.allElements=new HashMap<>();
    }
    
    /**
     * LabEstes: Crea el laberint i retorna l'habitació on estarà inicialment l'aventurer.
     * @return l'habitació inicial.
     */
    public Room createDungeon(){
        //Objectiu
        this.setObjectiu("Anar fins la sala \"Arribada\" amb una corona d'or.\n");

        // Sales
        this.createRoom("Exterior", "Una gran obertura al costat de la muntanya permet entrar al laberint.");
        this.createRoom("Boca de la cova","La boca de la cova condueix cap a una bifurcació en extrems oposats.");
        this.createRoom("Caverna Principal","Una enorme caverna s'obre al teu davant. Terra i sostre es troben plens d'estalagmites i estalactites. Es un cofre això que es veu?");
        this.createRoom("Cul de sac","El passadís acaba abruptament en un munt de rocs producte d'una esllevissada. Sembla que hi ha un forat.");
        this.createRoom("Arribada","Un paisatge idílic.");
        this.createRoom("Tunel","Un tunel estret. Al final es veu una mica de llum.");

        // Items
        this.createItem("Capsa", "Una capsa de fusta tancada.",10,15,"Cul de sac");
        this.createItem("Moneda", "Una antiga moneda d'or.",100,1,"Boca de la cova");
        this.createItem("Roc", "Un roc de bassalt.",20,5,"Caverna Principal");
        this.createItem("Estelactita", "Una estelactita punxeguda.",20,10,"Exterior");
        this.createItem("Corona","Una corona d'or.",130,5,"");

        //Connexions entre sales
        this.connectRooms("Exterior","Boca de la cova","Entrada");
        this.connectRooms("Boca de la cova","Caverna Principal","Est");
        this.connectRooms("Boca de la cova","Cul de sac","Oest");
        this.connectRooms("Boca de la cova","Exterior","Sortida");
        this.connectRooms("Cul de sac","Boca de la cova","Recular");
        this.connectRooms("Caverna Principal","Boca de la cova","Enrera");
        this.connectRooms("Tunel","Arribada","Sortida");
        this.connectRooms("Tunel","Cul de sac","Forat");

        // SecretElements
        this.createSecretDoor("Forat","Roc","Cul de sac","Tunel");
        this.createSecretContainer("Cofre","Estelactita","Caverna Principal","Corona");

        return this.getRoom("Exterior");
    }

    /** Crea l'aventurer amb el seu nom i la sala inicial.
     * @param name, nom de l'aventurer
     * @param startRoom, sala on es troba incialment
     */
    public void createAdventurer(String name,Room startRoom){
        this.adventurer=new Adventurer(name,startRoom);
    }
        
    /** 
     * Mou l'aventurer cap a una altra sala i retorna un codi que indica si
     * la operacio ha tingut exit o hi ha hagut un error.
     * @param exitName nom de la sortida que condueix a la sala destí.
     * @return el codi d'error (veure javadoc d'Adventurer.move()).
     */
    public int move(String exitName){
        return this.adventurer.move(exitName);
    }

    /** 
     * L'aventurer cull un item de la sala actual i retorna el codi d'èxit o error.
     * @param itemName nom de l'item que ha de collir.
     * @return el codi d'error (veure javadoc d'Adventurer.pickUp()).
     */ 
    public int pickUp(String itemName){
        return this.adventurer.pickUp(itemName);
    }

    /** 
     * L'aventurer deixa l'item indicat a la sala actual i retorna el codi d'èxit o error.
     * @param itemName nom de l'item que ha de deixar.
     * @return el codi d'error (veure javadoc d'Adventurer.drop()).
     */ 
    public int drop(String itemName){
        return this.adventurer.drop(itemName);
    }
    
    /** 
     * LabEstes: L'aventurer utilitza l'item indicat com a clau per activar l'element indicat.
     * @param itemName, nom de l'item clau.
     * @param elementName, nom de l'element que es vol activar.
     * @return codi del resultat (veure Adventurer.useItemOnElelment()).
     */
    public int useItemOnElement(String itemName,String elementName){
        return this.adventurer.useItemOnElement(itemName, elementName);
    }

    /**
     * Invoca la interficie d'usuari per mostrar l'inventari d'items de l'aventurer.
     */
    public void showInventory(){
        this.ui.showInventory(this.adventurer);
    }
    
    /** 
     * Invoca la interficie d'usuari per mostrar l'habitació on està l'aventurer.
     */
    public void showCurrentRoom(){
        this.ui.showCurrentRoom(this.adventurer);
    }
    
    /** 
      * Crea una nova sala a partir del nom i de la descripció, i
      * la desa al Map que conté totes les sales.
      * @param name
      * @param description 
      */
     public void createRoom(String name,String description){
         Room newRoom = new Room(name,description);
         allRooms.put(newRoom.getName(), newRoom);
     }

    /**
     * Crea una nou item amb les dades corresponents i el deixa a la sala
     * indicada.
     *
     * @param name
     * @param description
     * @param value
     * @param encumbrance
     * @param where, nom de la sala on es deixa l'item. Si (where.isEmpty()==true)
     * l'item no es deixa a cap sala (només s'afegeix al map de allItems). 
     */
    public void createItem(String name, String description, int value, int encumbrance, String where) {
        Item newItem = new Item(name, description);
        newItem.setValue(value);
        newItem.setEncumbrance(encumbrance);
        if (!where.isEmpty()) {
            Room here = allRooms.get(where);
            here.putItem(newItem);
        }
        allItems.put(newItem.getName(), newItem);
    }
    
    /** 
     * Connecta les dos sales indicades per mitjà de l'accés (o sortida) indicat.
     * @param origin
     * @param destination
     * @param accesName
     */
    public void connectRooms(String origin,String destination,String accesName){
        Room rOrigin=allRooms.get(origin);
        Room rDest=allRooms.get(destination);
        rOrigin.connect(rDest, accesName);
    }

    /**
     * LabEstes: Crea una porta secreta name entre les sales origin i destination, activada per key.
     * @param name
     * @param key
     * @param origin
     * @param destination
     */
    public void createSecretDoor(String name,String key,String origin,String destination){
        Item iKey=allItems.get(key);
        Room rOrigin=allRooms.get(origin);
        Room rDest=allRooms.get(destination);
        SecretElement se = new SecretDoor(name,iKey,rOrigin,rDest);
        rOrigin.putElement(se);
        allElements.put(se.getName(), se);
    }
    
    /**
     * LabEstes: Crea un contenidor secret name a la sala where activat per key que conté
     * un hiddenItem.
     * @param name
     * @param key
     * @param where
     * @param hiddenItem
     */
    public void createSecretContainer(String name,String key,String where,String hiddenItem){
        Item iKey=allItems.get(key);
        Item iHidden=allItems.get(hiddenItem);
        Room rWhere=allRooms.get(where);
        SecretElement se = new SecretContainer(name,iKey,rWhere,iHidden);
        rWhere.putElement(se);
        allElements.put(se.getName(), se);
    }
    
    /**
     * Retorna la sala que es diu name del map allRooms, o null si no existeix.
     * @param name
     * @return la sala 
     */
    public Room getRoom(String name){
        return allRooms.get(name);
    }
    
    /** 
     * Retorna una string amb l'objectiu del joc.
     * @return un text que descriu l'objectiu del joc.
     */
     public String getObjectiu(){
         return this.objectiuJoc;
     }

    /** 
     * Setter de l'objectiu de la partida.
     * @param descripcioObjectiu
     */
    public void setObjectiu(String descripcioObjectiu){
        this.objectiuJoc=descripcioObjectiu;
    }          
}


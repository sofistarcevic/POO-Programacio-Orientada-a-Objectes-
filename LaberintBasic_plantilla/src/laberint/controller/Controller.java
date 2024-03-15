package laberint.controller;

import java.util.HashMap;
import laberint.excepcions.LaberintException;
import laberint.model.Adventurer;
import laberint.model.Item;
import laberint.model.Room;
import laberint.userinterface.IOoperations;

/** Controlador: gestiona l'execució de cada una de les comandes que composen
 * l'aplicació.
 */
public class Controller {
    private Adventurer adventurer;
    private final HashMap<String,Room> allRooms;
    private final HashMap<String,Item> allItems;
    private String objectiuJoc;

    /** 
     * Constructor del controlador.
     */
    public Controller(){
        this.adventurer=null;
        this.objectiuJoc="";
        this.allRooms=new HashMap<>();
        this.allItems=new HashMap<>();
    }
    
    /**
     * Crea el laberint i retorna l'habitació on estarà inicialment l'aventurer.
     * @return l'habitació inicial.
     * @throws LaberintException
     */
    public Room createDungeon() throws LaberintException{
        //Objectiu
        this.setObjectiu("Recollir una capsa i tornar a l'Exterior.\n");

        // Sales
        this.createRoom("Exterior", "Una gran obertura al costat de la muntanya permet entrar al laberint.");
        this.createRoom("Boca de la cova","La boca de la cova condueix cap a una bifurcació en extrems oposats.");
        this.createRoom("Caverna Principal","Una enorme caverna s'obre al teu davant. Terra i sostre es troben plens d'estalagmites i estalactites.");
        this.createRoom("Cul de sac","El passadís acaba abruptament en un munt de rocs producte d'una esllevissada.");

        // Items
        this.createItem("Capsa", "Una capsa de fusta tancada.",10,15,"Cul de sac");
        this.createItem("Moneda", "Una antiga moneda d'or.",100,1,"Boca de la cova");
        this.createItem("Roc", "Un roc de bassalt.",20,5,"Caverna Principal");
        this.createItem("Estelactita", "Una estelactita punxeguda.",20,10,"Exterior");

        //Connexions entre sales
        this.connectRooms("Exterior","Boca de la cova","Entrada");
        this.connectRooms("Boca de la cova","Caverna Principal","Est");
        this.connectRooms("Boca de la cova","Cul de sac","Oest");
        this.connectRooms("Boca de la cova","Exterior","Sortida");
        this.connectRooms("Cul de sac","Boca de la cova","Recular");
        this.connectRooms("Caverna Principal","Boca de la cova","Enrera");

        return this.getRoom("Exterior");
    }

    /** Crea l'aventurer amb el nom i la sala inicial.
     * @param name
     * @param startRoom */
    public void createAdventurer(String name,Room startRoom){
        this.adventurer=new Adventurer(name,startRoom);
    }
        
    /** 
     * Mou l'aventurer cap a una altra sala. Si hi ha algun error, rellença
     * la LaberintException (veure javadoc d'Adventurer::move())
     * @param exitName nom de la sortida que condueix a la sala destí.
     * @throws LaberintException
     */
    public void move(String exitName) throws LaberintException{
        this.adventurer.move(exitName);
    }

    /** 
     * L'aventurer cull un item de la sala actual i en cas d'error rellença
     * la LaberintException (Adventurer::pickUp()).
     * @param itemName nom de l'item que ha de collir.
     * @throws LaberintException
     */ 
    public void pickUp(String itemName) throws LaberintException{
        this.adventurer.pickUp(itemName);
    }

    /** 
     * L'aventurer deixa l'item indicat a la sala actual i en cas d'error
     * rellença la LaberintException (Adventurer::drop()).
     * @param itemName nom de l'item que ha de deixar.
     * @throws LaberintException
     */ 
    public void drop(String itemName) throws LaberintException{
        this.adventurer.drop(itemName);
    }

    /**
     * Mostra l'inventari d'items que l'aventurer porta a sobre.
     */
    public void showInventory(){
        String text = this.adventurer.inventoryToString();
        IOoperations.writeString(text);
    }
    
    /** 
     * Mostra el contingut de la sala actual (la sala on està l'aventurer).
     */
    public void showCurrentRoom(){
        Room currentLocation = this.adventurer.getCurrentLocation();
        IOoperations.writeString(currentLocation.toString());
    }

    /** 
     * Retorna una string amb l'objecitiu del joc.
     * @return un text que descriu l'objectiu del joc.
     */
     public String getObjectiu(){
         return this.objectiuJoc;
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
     * Si la Room where no existeix, llença una LaberintException amb el 
     * missatge "No such room".
     * @throws LaberintException
     */
    public void createItem(String name, String description, int value, int encumbrance, String where) throws LaberintException {
        Item newItem = new Item(name, description);
        newItem.setValue(value);
        newItem.setEncumbrance(encumbrance);
        if (!where.isEmpty()) {
            Room here = allRooms.get(where);
            if (null==here) throw new LaberintException("No such room");
            here.putItem(newItem);
        }
        allItems.put(newItem.getName(), newItem);
    }
    
    /** 
     * Connecta les dos sales indicades per mitjà de l'accés (o sortida) indicat.
     * @param origin
     * @param destination
     * @param accesName
     * Si alguna de les dos sales no existeix, llença una LaberintException amb el 
     * missatge "No such room".
     * @throws LaberintException
     */
    public void connectRooms(String origin,String destination,String accesName) throws LaberintException{
        Room rOrigin=allRooms.get(origin);
        Room rDest=allRooms.get(destination);
        if (null==rOrigin || null==rDest) throw new LaberintException("No such room");
        rOrigin.connect(rDest, accesName);
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
     * Setter de l'objectiu de la partida.
     * @param descripcioObjectiu
     */
    public void setObjectiu(String descripcioObjectiu){
        this.objectiuJoc=descripcioObjectiu;
    }          
}


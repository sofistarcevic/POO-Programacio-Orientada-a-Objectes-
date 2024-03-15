package laberint.userinterface;

import laberint.controller.Controller;
import laberint.model.Adventurer;
import laberint.model.Room;
import laberint.model.SecretElement;

/**
 * Interficie d'usuari: gestiona tota la interacció amb l'usuari/a, i invoca el
 * controlador perquè executi les comandes de l'aplicació.
 */
public class UserInterface {

    /**
     * Diferents maneres que l'usuari/a pot fer servir per escriure cada
     * comanda.
     */
    private static final String[] ORDER_MOVE = {"M", "Mou", "Mueve", "Move"};
    private static final String[] ORDER_PICKUP = {"A", "Agafa", "Coje", "Pick"};
    private static final String[] ORDER_DROP = {"D", "Deixa", "Suelta", "Drop"};
    private static final String[] ORDER_INVENTORY = {"I", "Inventari", "Inventario", "Inventori"};
    private static final String[] ORDER_HELP = {"J", "Ajuda", "Ayuda", "H", "Help"};
    /**
     * LabEstes.
     */
    private static final String[] ORDER_USE = {"U", "Utilitza", "Usa", "Use"};
    private static final String[] ORDER_QUIT = {"F", "Fi"};

    private final Controller controller;

    /**
     * Constructor. Crea una instancia de Controller.
     */
    public UserInterface() {
        this.controller = new Controller(this);
    }

    /**
     * Mètode main. Simplement inicialitza IOoperations, instancia UserInterface
     * i crida start(),
     *
     * @param args
     */
    public static void main(String args[]) {
        IOoperations.init();
        UserInterface ui = new UserInterface();
        ui.start();
    }

    /**
     * LabEstes: Afegeix la comanda ORDER_USE. Inicia l'execució de l'aplicació
     * i executa el menú principal.
     */
    private void start() {
        if (Room.SHOW_SECRET_ELEMENTS) {
            IOoperations.writeString("ATENCIÓ, Room.SHOW_SECRET_ELEMENTS = true, programa en proves! Es mostren els elements secrets!\n");
        }
        IOoperations.writeString("Selecciona el nom de l'aventurer: ");
        String adventurerName = IOoperations.readLine();
        Room startRoom = this.controller.createDungeon();
        this.controller.createAdventurer(adventurerName, startRoom);
        IOoperations.writeString(this.controller.getObjectiu());

        boolean play = true;
        while (play) {
            IOoperations.writeString("-----------------------------------------------------------\n");
            IOoperations.writeString("Hola " + adventurerName + " et trobes a la sala:\n");
            this.controller.showCurrentRoom();

            IOoperations.writeString("Què vols fer? ");
            String line = IOoperations.readLine();
            line = line.trim();
            String[] arguments = line.split(" ");
            String command = arguments[0];

            switch (arguments.length) {
                case 1:
                    // Inventory
                    if (simpleMatch(UserInterface.ORDER_INVENTORY, command)) {
                        this.controller.showInventory();
                    } //Help
                    else if (simpleMatch(UserInterface.ORDER_HELP, command)) {
                        this.showHelp();
                    } //Quit
                    else if (this.simpleMatch(UserInterface.ORDER_QUIT, command)) {
                        play = false;
                        IOoperations.writeString("Fi del joc...\n");
                    } else {
                        IOoperations.writeString("Ordre incorrecta.\n");
                        break;
                    }
                    break;
                case 2:
                    // Moure
                    if (this.simpleMatch(UserInterface.ORDER_MOVE, command)) {

                        int res = this.controller.move(arguments[1]);

                        if (res == Adventurer.OK_ACTION) {
                            IOoperations.writeString("Et dirigeixes a l'accés " + arguments[1] + ".\n");
                        } else if (res == Adventurer.NO_SUCH_EXIT) {
                            IOoperations.writeString("No existeix cap sortida amb aquest nom.\n");
                        }
                    } // Agafar
                    else if (simpleMatch(UserInterface.ORDER_PICKUP, command)) {

                        int res = this.controller.pickUp(arguments[1]);

                        switch (res) {
                            case Adventurer.OK_ACTION:
                                IOoperations.writeString("Agafes l'item " + arguments[1] + ".\n");
                                break;
                            case Adventurer.INVENTORY_IS_FULL:
                                IOoperations.writeString("Ja no pots agafar mes items. Has de deixar alguna cosa abans.\n");
                                break;
                            case Adventurer.NO_SUCH_ITEM_IN_ROOM:
                                IOoperations.writeString("A la sala no hi ha aquest item.\n");
                                break;
                            default:
                                break;
                        }
                    } //Deixar
                    else if (simpleMatch(UserInterface.ORDER_DROP, command)) {

                        int res = this.controller.drop(arguments[1]);

                        if (res == Adventurer.OK_ACTION) {
                            IOoperations.writeString("Deixes l'item " + arguments[1] + " a la sala actual.\n");
                        } else if (res == Adventurer.NO_SUCH_ITEM_IN_INVENTORY) {
                            IOoperations.writeString("No disposes de cap item amb aquest nom.\n");
                        }
                    } else {
                        IOoperations.writeString("Ordre incorrecta.\n");
                    }
                    break;
                case 3:
                    // Utilitzar 
                    if (simpleMatch(UserInterface.ORDER_USE, command)) {
                        int res = this.controller.useItemOnElement(arguments[1], arguments[2]);
                        switch (res) {
                            case SecretElement.OK_ACTION:
                                IOoperations.writeString("Has utilitzat " + arguments[1] + " per activar " + arguments[2] + ", amb exit.\n");
                                break;
                            case Adventurer.NO_SUCH_ITEM_IN_INVENTORY:
                                IOoperations.writeString("No tens cap item amb aquest nom " + arguments[1] + ".\n");
                                break;
                            case Adventurer.NO_SUCH_ELEMENT_IN_ROOM:
                                IOoperations.writeString("A la sala no hi ha cap element anomenat " + arguments[2] + ".\n");
                                break;
                            case SecretElement.ELEMENT_USED:
                                IOoperations.writeString("Ja has utilitzat aquest element " + arguments[2] + ".\n");
                                break;
                            case SecretElement.WRONG_KEY:
                                IOoperations.writeString("L'item " + arguments[1] + " no és la clau que destapa l'element " + arguments[2] + ".\n");
                                break;
                            default:
                                break;
                        }
                    } else {
                        IOoperations.writeString("Ordre incorrecta.\n");
                    }
                    break;
                default:
                    IOoperations.writeString("Ordre incorrecta.\n");
            }
        }
    }

    /**
     * Mostra l'inventari d'items que l'aventurer porta a sobre.
     *
     * @param adventurer
     */
    public void showInventory(Adventurer adventurer) {
        String text = adventurer.inventoryToString();
        IOoperations.writeString(text);
    }

    /**
     * Mostra el contingut de la sala actual.
     *
     * @param adventurer
     */
    public void showCurrentRoom(Adventurer adventurer) {
        Room currentLocation = adventurer.getCurrentLocation();
        IOoperations.writeString(currentLocation.toString());
    }

    /**
     * Mostra l'ajut per pantalla.
     */
    private void showHelp() {
        IOoperations.writeString("Opcions:\n");
        IOoperations.writeString("[A]gafa <item>     [D]eixa <item>\n");
        IOoperations.writeString("[M]ou <nom porta>   A[J]uda \n");
        IOoperations.writeString("[I]nventari        [U]tilitza <item clau> <element secret> \n");
        IOoperations.writeString("[F]i \n");
    }

    /**
     * Compara un string amb un array de cadenes de text. Aquest mètode permet
     * que cada comanda es pugui expressar de diverses maneres (p.ex., "M",
     * "Mou", "Move", "Mueve")
     */
    private boolean simpleMatch(String[] base, String text) {
        for (String base1 : base) {
            if (base1.equalsIgnoreCase(text)) {
                return true;
            }
        }
        return false;
    }
}

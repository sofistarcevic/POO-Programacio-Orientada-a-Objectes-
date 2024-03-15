package laberint.userinterface;

import laberint.controller.Controller;
import laberint.excepcions.LaberintException;
import laberint.model.Room;

/**
 * Interficie d'usuari: gestiona tota la interacció amb l'usuari/a, i invoca el
 * controlador perquè executi les comandes de l'aplicació.
 */
public class UserInterface {

    /**
     * Diferents maneres que l'usuari/a pot fer servir per escriure la comanda.
     */
    private static final String[] ORDER_MOVE = {"M", "Mou", "Mueve", "Move"};
    private static final String[] ORDER_PICKUP = {"A", "Agafa", "Coje", "Pick"};
    private static final String[] ORDER_DROP = {"D", "Deixa", "Suelta", "Drop"};
    private static final String[] ORDER_INVENTORY = {"I", "Inventari", "Inventario", "Inventori"};
    private static final String[] ORDER_HELP = {"J", "Ajuda", "Ayuda", "H", "Help"};
    private static final String[] ORDER_QUIT = {"F", "Fi"};

    private Controller controller;

    /**
     * Constructor. Instancia el controlador.
     */
    public UserInterface() {
        this.controller = null;
        this.controller = new Controller();
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
        System.exit(0);
    }

    /**
     * Inicia l'execució de l'aplicació i executa el menú principal (veure
     * l'exemple d'execució). Captura les excepcions i mostra el missatge 
     * corresponent.
     */
    private void start() {
        IOoperations.writeString("Selecciona el nom de l'aventurer: ");
        String adventurerName = IOoperations.readLine();
        Room startRoom = null;
        try{
            startRoom = this.controller.createDungeon();
        }
        catch (LaberintException ex){
            IOoperations.writeString(ex.getMessage());
            System.exit(1);
        }
        this.controller.createAdventurer(adventurerName, startRoom);
        IOoperations.writeString("OBJECTIU: " + this.controller.getObjectiu()+"\n");

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
                        try{
                            this.controller.move(arguments[1]);
                            IOoperations.writeString("Et dirigeixes a l'accés " + arguments[1] + ".\n");
                        }
                        catch (LaberintException ex){
                            IOoperations.writeString(ex.getMessage()+"\n");
                        }
                    } // Agafar
                    else if (simpleMatch(UserInterface.ORDER_PICKUP, command)) {
                        try{
                            this.controller.pickUp(arguments[1]);
                            IOoperations.writeString("Agafes l'item " + arguments[1] + ".\n");
                        }
                        catch (LaberintException ex){
                            IOoperations.writeString(ex.getMessage()+"\n");
                        }
                    } //Deixar
                    else if (simpleMatch(UserInterface.ORDER_DROP, command)) {
                        try{
                            this.controller.drop(arguments[1]);
                            IOoperations.writeString("Deixes l'item " + arguments[1] + " a la sala actual.\n");
                        }
                        catch (LaberintException ex){
                            IOoperations.writeString(ex.getMessage()+"\n");
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
     * Mostra l'ajut per pantalla.
     */
    private void showHelp() {
        IOoperations.writeString("Opcions:\n");
        IOoperations.writeString("[A]gafa <item>     [D]eixa <item>\n");
        IOoperations.writeString("[M]ou <nom porta>   A[J]uda \n");
        IOoperations.writeString("[I]nventari        [F]i \n");
    }

    /**
     * Retorna true si text coincideix amb alguna de les cadenes de base.
     * Compara l'string text amb l'array base que conté diverses strings.
     * Aquest mètode permet que cada comanda es pugui expressar de 
     * diverses maneres (p.ex., "M", "Mou", "Move", "Mueve")
     * @param base, array de Strings
     * @param text,
     * @return true si text coincideix amb alguna de les cadenes de base
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

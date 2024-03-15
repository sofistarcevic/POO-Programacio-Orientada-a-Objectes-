package laberint.userinterface;

import java.io.PrintStream;
import java.util.Scanner;

/** Encapsula les operacions d'entrada/sortida.*/
public class IOoperations {
    /** Dispositiu d'entrada. */
    private static Scanner input;
    /** Dispositiu de sortida. */
    private static PrintStream output;
    
    /** 
     * Inicialitza els dispositius d'entrada/sortida: entrada de teclat
     * i sortida a pantalla.
     */
    public static void init(){
        input = new Scanner(System.in); 
        output = System.out;
    }
    
    /**
     * LLegeix una linia de text de l'entrada.
     * @return la linia de text.
     */
    public static String readLine(){
        return input.nextLine();
    }
    
    /** Mostra un text per la sortida.
     * @param text 
     */
    public static void writeString(String text){
        output.print(text);
    }
}

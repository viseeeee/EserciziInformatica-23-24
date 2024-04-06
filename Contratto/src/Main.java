import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Fine"};
       boolean Sitel=true;
       boolean controllo;
        final int nMax = 3;
        int contrattiVenduti = 0;
        Contatto[] gestore = new Contatto[nMax];

        Scanner keyboard = new Scanner(System.in);

        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(Sitel,keyboard);
                        controllo=Controllo(gestore,contrattiVenduti);
                        if(controllo){
                            System.out.println("Hai già inserito questo nome e questo cognome");
                            gestore[contrattiVenduti]=null;
                        }else {
                            contrattiVenduti++;
                        }
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }

                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static boolean Controllo(Contatto[] gestore,int contrattiVenduti){
        boolean controllo=false,ripetizioneNome=false,ripetizioneCognome=false;
        for(int i=0;i<contrattiVenduti;i++){
            if (gestore[i].nome.equals(gestore[contrattiVenduti].nome)) {
                ripetizioneNome=true;
            }
            if (gestore[i].cognome.equals(gestore[contrattiVenduti].cognome)) {
                ripetizioneCognome=true;
            }
        }
        if (ripetizioneCognome && ripetizioneNome) {
            controllo=true;
        }
        return controllo;
    }

    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"ABITAZIONE",
                "[1] Abitazione",
                "[2] Cellulare",
                "[3] Aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();
        System.out.println("\nInserisci il numero di telefono: ");
        if (Sitel) {
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }
        return persona;
    }
}
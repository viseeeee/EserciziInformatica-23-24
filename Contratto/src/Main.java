import static tools.utility.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] operazioni = {"VODAFONE",
                "[1] Inserimento",
                "[2] Visualizzazione",
                "[3] Ricerca",
                "[4] Cambio numero di telefono",
                "[5] Cambio contratto",
                "[6] Eliminazione del contatto tramite nome e cognome",
                "[7] Eliminazione del contatto tramite numero",
                "[8] Fine"};
       boolean Sitel=true;
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
       int posizione=0;
        final int nMax = 3;
        int contrattiVenduti = 0;
        Contatto[] gestore = new Contatto[nMax];
        Contatto telefono=new Contatto();

        Scanner keyboard = new Scanner(System.in);

        boolean fine = true;
        do {
            switch (menu(operazioni, keyboard)) {
                case 1:

                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti]=leggiPersona(Sitel,keyboard);
                        while (ControlloNumero(gestore,gestore[contrattiVenduti],contrattiVenduti)){
                            System.out.println("Reinseisci il numero perchè già presente");
                            gestore[contrattiVenduti].telefono=keyboard.nextLine();
                        }
                        //entra solo se il nome e il cognome non sono presenti
                        if (!ricerca (gestore,gestore[contrattiVenduti], contrattiVenduti)){
                            contrattiVenduti++;
                        }//se il nome e il cognome sono già stati inseriti annulla l'inserimento
                        else {
                            System.out.println("Il nome utente è già presente");
                            gestore[contrattiVenduti]=null;
                        }
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;
                case 2: {
                    visualizza(gestore, contrattiVenduti);
                    break;
                }

                case 3: {
                    if(contrattiVenduti !=0){
                        //Ci sono contratti venduti
                        //lettura, ricerca, visualizzazione
                        posizione=Posizione(gestore,leggiPersona(false, keyboard), contrattiVenduti);
                        if(posizione!=-1){
                            System.out.println(gestore[posizione].stampa());
                        }else{
                            System.out.println("Il contatto non esiste");
                        }
                    }else{
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }
                case 4:{
                    posizione=Posizione(gestore,leggiPersona(false, keyboard), contrattiVenduti);
                    if(posizione!=-1){
                        System.out.println("Inserisci il numero");
                        gestore[posizione].telefono=keyboard.nextLine();
                        if (ControlloNumero(gestore,gestore[posizione], contrattiVenduti)){
                            System.out.println("Il numero è uguale a quello inserito precedentemente");
                        }
                    }else{
                        System.out.println("Il contatto non esiste");
                    }
                    break;
                }
                case 5:{
                    posizione=Posizione(gestore,leggiPersona(false, keyboard), contrattiVenduti);
                    if(posizione!=-1){
                        switch (menu(tipoC, keyboard)) {
                            case 1 -> gestore[posizione].tipo = tipoContratto.abitazione;
                            case 2 -> gestore[posizione].tipo = tipoContratto.cellulare;
                            default -> gestore[posizione].tipo = tipoContratto.aziendale;
                        }
                    }else{
                        System.out.println("Il contatto non esiste");
                    }
                    break;
                }

                case 6:{
                    posizione=Posizione(gestore,leggiPersona(false, keyboard), contrattiVenduti);
                    if(posizione!=-1){
                        gestore=PosizioneEliminata(gestore,contrattiVenduti,posizione);
                        gestore[contrattiVenduti-1]=null;
                        contrattiVenduti--;
                        System.out.println("Il contatto è stato eliminato");
                    }else {
                        System.out.println("Il contatto non esiste");
                    }
                    break;
                }
                case 7:{
                    System.out.println("Inserisci il numero di telefono");
                    telefono.telefono=keyboard.nextLine();
                    posizione=PosizioneTelefono(gestore,telefono,contrattiVenduti);
                    if(posizione!=-1){
                        gestore=PosizioneEliminata(gestore,contrattiVenduti,posizione);
                        gestore[contrattiVenduti-1]=null;
                        contrattiVenduti--;
                        System.out.println("Il contatto è stato eliminato");
                    }else {
                        System.out.println("Il contatto non esiste");
                    }
                    break;
                }
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }
    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("Inserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();
        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
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

    private static boolean ControlloNumero(Contatto[] gestore, Contatto contatto, int contrattiVenduti){
        for (int i=0;i<contrattiVenduti;i++){
            if (gestore[i].telefono.equals(contatto.telefono)){
                return  true;
            }
        }
        return false;
    }
    private static int Posizione(Contatto[] gestore, Contatto contatto, int contrattiVenduti){

        for(int i = 0; i<contrattiVenduti; i++){
            if(contatto.nome.equals(gestore[i].nome)  && contatto.cognome.equals(gestore[i].cognome)){
                return i;
            }
        }
        return -1;
    }

    //serve per trovare la posizione del telefono all'iterno dell'array
    private static int PosizioneTelefono(Contatto[] gestore, Contatto contatto, int contrattiVenduti){
        for (int i=0;i<contrattiVenduti;i++){
            if (gestore[i].telefono.equals(contatto.telefono)){
                return i;
            }
        }
        return -1;
    }

    //elimina la posizione dell'array
    private static Contatto[] PosizioneEliminata(Contatto[] gestore, int contrattiVenduti,int posizione){
        for (int i=posizione;i<contrattiVenduti;i++){
            gestore[posizione]=gestore[posizione+1];
        }

        return gestore;
    }
    private static boolean ricerca (Contatto[] gestore, Contatto contatto, int contrattiVenduti){
        //Controllo se il nome e il cognome del contatto e ugale al nome e cogome del gestore
        boolean ricerca = false;

        for(int i = 0; i<contrattiVenduti; i++){
            if(contatto.nome.equals(gestore[i].nome)  && contatto.cognome.equals(gestore[i].cognome)){
                ricerca = true;
            }
        }
        return ricerca;
    }

    private static void visualizza(Contatto [] gestore, int contrattiVenduti){
        for(int i=0 ; i<contrattiVenduti; i++){
            System.out.println(gestore[i].stampa());
        }

    }

}
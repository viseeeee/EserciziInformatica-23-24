import java.util.Scanner;
import java.util.Random;
public class dadiGiocatori {
    //stampare 5 numeri casuali che hanno un valore
    //fare un metodo che si chiama ruota estratta e ci fà ritornare un array con un valore casuale
    public static void main(String[] args) {
        int ruota;
        int valoreMenu;
        int faccia;
        String risposta;
        String menu;
        String[] nome = new String[2];//menu di stringhe
        boolean mentre=true;
        Scanner keyboard = new Scanner(System.in);
        do {
            ClrScr();//serve per pulire il menù
            System.out.println("=== APP Gara Dadi ===\n" +
                    "[1]-Sfida tra due giocatori\n" +
                    "[2]-Sfida contro il computer\n" +
                    "[3]-Fine");
            valoreMenu=keyboard.nextInt();

            switch (valoreMenu){
                case 1:{
                    System.out.println("inserisci il nome del giocatore numero 1");
                    nome[0]= keyboard.next().toLowerCase();
                    System.out.println("inserisci il nome del giocatore numero 2");
                    nome[1]= keyboard.next().toLowerCase();
                    int[] numeriUsciti = array();
                    for (int giocatore = 0; giocatore < numeriUsciti.length; giocatore++) {//mostra in output tutti
                        System.out.println("il valore uscito al giocatore " + nome[giocatore] + " è " + numeriUsciti[giocatore]);//mostra in output i valori dell'array
                        faccia=numeriUsciti[giocatore];
                        FacceDado(faccia);
                    }
                    if (numeriUsciti[1]<numeriUsciti[0]){
                        System.out.println("il vincitore è "+ nome[0]);
                    }
                    if (numeriUsciti[1]>numeriUsciti[0]){
                        System.out.println("il vincitore è "+ nome[1]);
                    }
                    if (numeriUsciti[1]==numeriUsciti[0]){
                        System.out.println("sono usciti 2 valori uguali");
                    }
                    System.out.println("\n" +
                            "premi invio per far vedere il menù");
                    keyboard.nextLine();
                    menu=keyboard.nextLine();//se si preme invio si esce dallo switch case e si calcella tutto il terminale
                    break;
                }
                case 2:{
                    int[] numeriUsciti = array();
                    for (int giocatore1 = 0; giocatore1 < numeriUsciti.length; giocatore1++){//mostra in output tutti

                        System.out.println("il valore uscito al computer numero " + (giocatore1+1) + " è " + numeriUsciti[giocatore1]);//mostra in output i valori dell'array
                        faccia=numeriUsciti[giocatore1];
                       FacceDado(faccia);
                    }
                    if (numeriUsciti[1]<numeriUsciti[0]){
                        System.out.println("il vincitore è il computer numero 1");
                    }
                    if (numeriUsciti[1]>numeriUsciti[0]){
                        System.out.println("il vincitore è il computer numero 2");
                    }
                    if (numeriUsciti[1]==numeriUsciti[0]){
                        System.out.println("sono usciti 2 valori uguali");
                    }
                    System.out.println("\n" +
                            "premi invio per far vedere il menù");
                    keyboard.nextLine();
                    menu=keyboard.nextLine();//se si preme invio si esce dallo switch case e si calcella tutto il terminale
                    break;
                }
                    //se sceglie 3 esce dal ciclo
                case 3: {
                    break;
                }
                default:{
                    System.out.println("il valore che hai inserito non è tra quelli richiesti" +
                            "reinserisci il valore");
                    valoreMenu=keyboard.nextInt();
                }
            }

        }while(valoreMenu!=3);


    }

    public static int random(int minValue, int maxValue) {
        Random casuale = new Random();
        return casuale.nextInt(minValue, maxValue);
    }
    public static void vincitore(int[] numeriUsciti){
        if (numeriUsciti[1]==numeriUsciti[2]){

        }
    }

    public static int[] array() {
        int valore;
        int[] numeriUsciti = new int[2];//creazione dell'array
        for (int i = 0; i < numeriUsciti.length; i++)
        {//un for che applica il valore random ad una cella dell'array
            valore = random(0,6);
            numeriUsciti[i] = valore;

        }
        return numeriUsciti;
    }
    private static void FacceDado(int faccia) {
        //ALT + 201 ╔
        //ALT + 188 ╝
        //ALT + 187 ╗
        //ALT + 200 ╚
        //ALT + 205 ═
        //ALT + 186 ║

        switch (faccia) {
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


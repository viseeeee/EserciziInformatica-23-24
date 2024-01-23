import java.util.Random;
import java.util.Scanner;

public class dadiMenu {
    public static void main(String[] args) {
        int valoreMenu = 0;
        String menu;
        String[] nome = new String[2]; // menu di stringhe
        boolean mentre = true;
        Scanner keyboard = new Scanner(System.in);
        String[] opzioni = {"=== Gioco Dadi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Exit "};
        do {
            valoreMenu = Menu(opzioni, keyboard);
            switch (valoreMenu) {
                case 1: {
                    System.out.println("inserisci il nome del giocatore numero 1");
                    nome[0] = keyboard.next().toLowerCase();
                    System.out.println("inserisci il nome del giocatore numero 2");
                    nome[1] = keyboard.next().toLowerCase();
                    int[] numeriUsciti = array();
                    for (int giocatore = 0; giocatore < numeriUsciti.length; giocatore++) {//mostra in output tutti
                        System.out.println("il valore uscito al giocatore " + nome[giocatore] + " è " + numeriUsciti[giocatore]);//mostra in output i valori dell'array
                    }
                    if (numeriUsciti[1] < numeriUsciti[0]) {
                        System.out.println("il vincitore è " + nome[0]);
                    }
                    if (numeriUsciti[1] > numeriUsciti[0]) {
                        System.out.println("il vincitore è " + nome[1]);
                    }
                    if (numeriUsciti[1] == numeriUsciti[0]) {
                        System.out.println("sono usciti 2 valori uguali");
                    }
                    System.out.println("\n" +
                            "premi invio per far vedere il menù");
                    keyboard.nextLine();
                    menu = keyboard.nextLine();//se si preme invio si esce dallo switch case e si calcella tutto il terminale
                    break;
                }
                case 2: {
                    int[] numeriUsciti = array();
                    for (int giocatore1 = 0; giocatore1 < numeriUsciti.length; giocatore1++) {//mostra in output tutti
                        System.out.println("il valore uscito al computer numero " + (giocatore1 + 1) + " è " + numeriUsciti[giocatore1]);//mostra in output i valori dell'array
                    }
                    if (numeriUsciti[1] < numeriUsciti[0]) {
                        System.out.println("il vincitore è il computer numero 1");
                    }
                    if (numeriUsciti[1] > numeriUsciti[0]) {
                        System.out.println("il vincitore è il computer numero 2");
                    }
                    if (numeriUsciti[1] == numeriUsciti[0]) {
                        System.out.println("sono usciti 2 valori uguali");
                    }
                    System.out.println("\n" +
                            "premi invio per far vedere il menù");
                    keyboard.nextLine();
                    menu = keyboard.nextLine();//se si preme invio si esce dallo switch case e si calcella tutto il terminale
                    break;
                }
                case 3: {
                    break;
                }
            }

        } while (valoreMenu != 3);
    }

    private static int Menu(String opzioni[], Scanner keyboard) {
        int valoreMenu;
        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            valoreMenu = keyboard.nextInt();

            if ((valoreMenu < 1) || (valoreMenu > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
            }
        }
        while ((valoreMenu < 1) || (valoreMenu > opzioni.length - 1));

        return valoreMenu;
    }

    public static int random(int minValue, int maxValue) {
        Random casuale = new Random();
        return casuale.nextInt(maxValue - minValue + 1) + minValue;
    }

    public static void vincitore(int[] numeriUsciti) {
        if (numeriUsciti[1] == numeriUsciti[2]) {

        }
    }

    public static int[] array() {
        int valore;
        int[] numeriUsciti = new int[2];//creazione dell'array
        for (int i = 0; i < numeriUsciti.length; i++) {//un for che applica il valore random ad una cella dell'array
            valore = random(0, 6);
            numeriUsciti[i] = valore;

        }
        return numeriUsciti;
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

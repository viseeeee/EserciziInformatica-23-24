import java.util.Scanner;
import java.util.Random;
public class appLotto {
    public static void main(String[] args) {
        int scelta;
        int[] valori=null;
        boolean cambio = true;
        do {
            ClrScr();
            menu();
            Scanner keyboard = new Scanner(System.in);

            // si mette in inpu la scelta del menù
            scelta = keyboard.nextInt();

            // controllo della scelta fatta precedentemente se la scelta non è 1,2,3 e ti fà reinserire la scelta
            while (scelta!=1 && scelta!=2 && scelta!=3){
                ClrScr();
                System.out.println("reinserisci la scelta che può essere");
                menu();
            scelta=keyboard.nextInt();
            }
            
            //switch case della scelta
            switch (scelta) {
                case 1: {
                    //fà l'estrazione dei numeri inserendo dei numeri casuali
                    valori=estrazione();
                    System.out.println("l'estrazione dei numeri è finita");
                    Wait();
                    break;
                }
                case 2: {
                    //è un for che mostro in output tutti i numeri presenti nell'array
                    for (int i =0; i < valori.length; i++) {
                        System.out.println("dall'estrazione numero " + (i+1) + " è uscito il valore " + valori[i]);
                    }
                    Wait();
                    break;
                }
                case 3: {
                    cambio = false;
                    break;
                }

            }
        } while (cambio == true);
    }

    //metodo che mostra il menu
    private static void menu() {
        System.out.println("== App lotto\n");
        System.out.println("[1] estrazione ruota di venezia");
        System.out.println("[2] visualizzazione ruota di venezia");
        System.out.println("[3] exit\n");
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int[] estrazione() {
        int[] valori = new int[5];
        Random casuale = new Random();//creazione del random per generare un numero casuale
        for (int j = 0; j < valori.length; j++) {//salvo i numeri nell'array facendo il for che passa per ogni numero
            valori[j] = casuale.nextInt(1, 90);
        }
        return valori;
    }

}

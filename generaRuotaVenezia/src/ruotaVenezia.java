import java.util.Scanner;
import java.util.Random;
public class ruotaVenezia {
    //stampare 5 numeri casuali che hanno un valore
    //fare un metodo che si chiama ruota estratta e ci fà ritornare un array con un valore casuale
    public static void main(String[] args) {
        int ruota;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("scegli la ruota che può andare da 1 a 11");
        ruota = keyboard.nextInt();
        while (ruota <= 0 || ruota > 11) { // controllo della ruota
            System.out.println("il numero della ruota è sbagliato,reinserisci un'altro valore");
            ruota = keyboard.nextInt();
        }
        int[] numeriUsciti = array();
        for (int contatore1=0;contatore1<numeriUsciti.length;contatore1++){
            for (int contatore2=0 ;contatore2<numeriUsciti.length;contatore2++){
                if(contatore1==contatore2){

                }
                else if (numeriUsciti[contatore1]==numeriUsciti[contatore2]) {
                    System.out.println("i valori sono uguali quindi cambio rigenero un valore");
                    numeriUsciti[contatore1]=random(0, 90);
                }
            }
        }
        for (int contatore = 1; contatore < numeriUsciti.length; contatore++) {
            System.out.println("il valore numero " + contatore + " è " + numeriUsciti[contatore]);//mostra in output i valori dell'array
        }

    }

    public static int random(int minValue, int maxValue) {
        Random casuale = new Random();
        return casuale.nextInt(minValue, maxValue);
    }

    public static int[] array() {
        int valore;
        int[] numeriUsciti = new int[6];//creazione dell'array
        for (int i = 0; i < 6; i++)
        {//un for che applica il valore random ad una cella dell'array
            valore = random(0,90);
            numeriUsciti[i] = valore;

        }
        return numeriUsciti;
    }
}

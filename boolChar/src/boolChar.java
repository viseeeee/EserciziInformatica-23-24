import  java.util.Scanner;
public class boolChar {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numeroInserimento;//indica i numeri che si vogliono inserire
        int j;//si usa in un for

        //array con 26 caratteri booleani
        boolean[] valori = new boolean[26];

        //array con 26 caratteri di stringhe
        String[] inserire = new String[26];
        //array con tutti i caratteri dell'alfabeto
        String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        System.out.println("inserisci quanti caratteri vuoi inserire vuoi inserire");
        numeroInserimento = keyboard.nextInt();

        //controllo per il numero di caratteri che si vuole inserire
        while (numeroInserimento<=0 || numeroInserimento>26){
            System.out.println("reiserisci il valore(deve essere minore di 26)");
            numeroInserimento=keyboard.nextInt();
        }

        //inserimento dei valori alfabetici
        for (int i = 0; i < numeroInserimento; i++) {
            System.out.println("inserisci i valori alfabetici che vuoi inserire");
            inserire[i] = keyboard.next();
        }

        //controllo di entrambi gli array
        for (int k = 0; k < alfabeto.length; k++) {
            for (j = 0; j < numeroInserimento; j++) {
                //se il valore che ho inserito è uguale a uno presente nell'alfabeto l'indice di quel carattere fà diventare true la cella di valori
                if (alfabeto[k].equals(inserire[j])) {
                    valori[k] = true;
                }
            }
            //reset di j in modo da fare il controllo tra gli array
            j = 0;
        }

        //serve per stampare i caratteri che ho inserito
            for (int contatore1 = 0; contatore1 < valori.length; contatore1++) {
                if (valori[contatore1]) {
                    System.out.println("hai inserito:" + alfabeto[contatore1]);
                }
            }
            
            //serve per stampare i caratteri che non ho inserito
            for (int contatore2 = 0; contatore2 < valori.length; contatore2++) {
                if (!valori[contatore2]) {
                    System.out.println("non hai inserito:" + alfabeto[contatore2]);
                }
            }
    }
}

import java.util.Scanner;

public class salvaLettere {
    public static void main(String[] args) {
        String[] maiuscole = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] parole = new String[100];
        String[] controllo = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] volte = new int[26]; // La lunghezza è 26 poiché l'alfabeto ha 26 lettere
        Scanner keyboard = new Scanner(System.in);
        int numero;
        int j = 0;
        int lunghezza;
        char lettera;

        //inserimento della quantità di parole che si vogliono inserire
        System.out.println("Inserisci quante parole vuoi inserire: ");
        numero = keyboard.nextInt();

        //inserimento delle parole
        for (int i = 0; i < numero; i++) {
            System.out.println("Inserisci la parola n° " + (i + 1));
            //inserimento della parola in maiuscolo
            parole[i] = keyboard.next().toUpperCase();
        }

        //controllo delle lettere inserite e quelle non lo sono
        for (j = 0; j < numero; j++) {
            for (int k = 0; k < parole[j].length(); k++) {
                lettera = parole[j].charAt(k);
                for (int l = 0; l < maiuscole.length; l++) {
                    if (maiuscole[l].equals(String.valueOf(lettera))) {
                        //le celle delle lettere che sono state inserite diventano 0
                        controllo[l] = "0";
                        volte[l]++;
                    }
                }
            }
        }

        //out delle lettere che non sono state inserite
        System.out.println("Le lettere che non hai inserito sono:");
        for (int h = 0; h < controllo.length; h++) {
            if (controllo[h].equals(maiuscole[h])) {
                System.out.println(controllo[h]);
            }
        }

        //out delle lettere che sono state inserite
        System.out.println("Le lettere che hai inserito sono:");
        for (int h = 0; h < controllo.length; h++) {
            if (!controllo[h].equals(maiuscole[h])) {
                System.out.println(maiuscole[h]);
                //mostra quante volte si è ripetuta la lettera inserita
                System.out.println("la lettera si è ripetuta per:" + volte[h]);
            }
        }
    }

    //metodo che serve per pulire lo schermo
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


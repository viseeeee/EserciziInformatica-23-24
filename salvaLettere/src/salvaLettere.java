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

        System.out.println("Inserisci quante parole vuoi inserire: ");
        numero = keyboard.nextInt();

        for (int i = 0; i < numero; i++) {
            System.out.println("Inserisci la parola n° " + (i + 1));
            parole[i] = keyboard.next().toUpperCase();
        }

        for (j = 0; j < numero; j++) {
            for (int k = 0; k < parole[j].length(); k++) {
                lettera = parole[j].charAt(k);
                for (int l = 0; l < maiuscole.length; l++) {
                    if (maiuscole[l].equals(String.valueOf(lettera))) {
                        controllo[l] = "0";
                        volte[l]++;
                    }
                }
            }
        }

        System.out.println("Le lettere che non hai inserito sono:");
        for (int h = 0; h < controllo.length; h++) {
            if (controllo[h].equals(maiuscole[h])) {
                System.out.println(controllo[h]);
            }
        }
        System.out.println("Le lettere che non hai inserito sono:");
        for (int h = 0; h < controllo.length; h++) {
            if (!controllo[h].equals(maiuscole[h])) {
                System.out.println(maiuscole[h]);
                System.out.println("la lettera si è ripetuta per:" + volte[h]);
            }
        }
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


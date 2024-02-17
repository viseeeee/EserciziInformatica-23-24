import java.util.Scanner;

public class stampaMaiuscole {
    public static void main(String[] args) {
        int contatore2 = 0;
        Scanner keyboard = new Scanner(System.in);
        int numeroP;
        String[] maiuscole = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        System.out.println("Quante parole vuoi inserire?");
        numeroP = keyboard.nextInt();
        String[] paroleM = new String[numeroP];
        while (numeroP > 0) {
            System.out.println("Inserisci la parola:");
            numeroP--;
            String parole = keyboard.next();
            char pCarattere = parole.charAt(0);
            for (int i = 0; i < maiuscole.length; i++) {
                if (maiuscole[i].equals(Character.toString(pCarattere))) {
                    paroleM[contatore2] = parole;
                    contatore2++;
                    System.out.println("La parola inizia con una lettera maiuscola.");
                    break; // Esci dal ciclo una volta trovata la corrispondenza
                }
            }
            ClrScr();
        }
        // Stampa le parole che iniziano con una lettera maiuscola
        System.out.println("Le parole che iniziano con una lettera maiuscola sono:");
        for (int i = 0; i < contatore2; i++) {
            System.out.println(paroleM[i]);
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

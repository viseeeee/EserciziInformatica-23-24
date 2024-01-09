import java.util.Scanner;

public class morraCinese {
    public static void main(String[] args) {

        String Giocatore1,Giocatore2;
        Scanner keyboard = new Scanner(System.in);
        do {
            // Input del giocatore
            System.out.println("Giocatore numero 1 inserisci la lettera\n" + "A - sasso\n" + "B - carta\n" + "C - forbice");
            Giocatore1 = keyboard.next().toUpperCase();

            // Verifica dell'input
            while (!Giocatore1.equals("A") && !Giocatore1.equals("B") && !Giocatore1.equals("C") && !Giocatore1.equals("X")) {
                System.out.println("Reinserisci la lettera\n" + "A - sasso\n" + "B - carta\n" + "C - forbice");
                Giocatore1 = keyboard.next().toUpperCase();
            }
            if (Giocatore1.equals("X")){
                break;
            }
            // Pulizia della console dopo la risposta del giocatore
            ClrScr();

            System.out.println("Giocatore numero 2 inserisci la lettera\n" + "A - sasso\n" + "B - carta\n" + "C - forbice");
            Giocatore2 = keyboard.next().toUpperCase();

            // Verifica dell'input
            while (!Giocatore2.equals("A") && !Giocatore2.equals("B") && !Giocatore2.equals("C") && !Giocatore2.equals("X")) {
                System.out.println("Reinserisci la lettera\n" + "A - sasso\n" + "B - carta\n" + "C - forbice");
                Giocatore2 = keyboard.next().toUpperCase();
            }
            if (Giocatore2.equals("X")){
                break;
            }
            ClrScr();
            System.out.println("                                                   ");
            System.out.println("                                                   ");
            System.out.println("------------------------------------------------");
            if (Giocatore1.equals("A") && Giocatore2.equals("C")){
                System.out.println("il giocatore numero 1 ha vinto contro il giocatore numero 2");
            }
            if (Giocatore1.equals("B") && Giocatore2.equals("A")){
                System.out.println("il giocatore numero 1 ha vinto contro il giocatore numero 2");
            }
            if (Giocatore1.equals("C") && Giocatore2.equals("B")){
                System.out.println("il giocatore numero 1 ha vinto contro il giocatore numero 2");
            }

            if (Giocatore2.equals("A") && Giocatore1.equals("C")){
                System.out.println("il giocatore numero 2 ha vinto contro il giocatore numero 1");
            }
            if (Giocatore2.equals("B") && Giocatore1.equals("A")){
                System.out.println("il giocatore numero 2 ha vinto contro il giocatore numero 1");
            }
            if (Giocatore2.equals("C") && Giocatore1.equals("B")){
                System.out.println("il giocatore numero 2 ha vinto contro il giocatore numero 1");
            }
            System.out.println("------------------------------------------------");
            System.out.println("                                                   ");
            System.out.println("                                                   ");
        }while (!Giocatore1.equals("X") || !Giocatore2.equals("X"));
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


import java.util.Scanner;
public class OrologioDigitale {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int ore = 0, minuti = 0, secondi = 0, centesimi=0;
        int avvio;
        System.out.println("inserisci 0 per far avviare il programma");
        avvio = keyboard.nextInt();

        while (avvio == 0) {//loop infinito
            ClrScr();
            Wait();
            centesimi++;
            while (centesimi >= 60) {
                centesimi = centesimi-60;
                secondi = secondi + 1;
            }
            while (secondi >= 60) {
                secondi = secondi - 60;
                minuti = minuti + 1;
            }
            while (minuti >= 60) {//
                minuti = minuti - 60;
                ore = ore + 1;
            }
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println(" ore: " + ore + " minuti: " + minuti + " secondi: " + secondi + " centesimi: " + centesimi);        //output
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }
    private static void Wait() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
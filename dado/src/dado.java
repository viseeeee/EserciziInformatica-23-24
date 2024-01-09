import java.util.Random;
import java.util.Scanner;
public class dado {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Random faccia=new Random();
        System.out.println("gioca il giocatore 1:");

        int ValoreFaccia=0,giocatore1=0,giocatore2=0,giocate=1;
        do{

            for (int i=0;i<=7;i++){
                if (i==7){
                    System.out.println("è uscito");
                    ValoreFaccia= faccia.nextInt(0,6) +1;

                }
                else {

                    Wait();
                    ClrScr();
                    ValoreFaccia=i;
                }
                faceDado(ValoreFaccia);
            }
            if(giocate==2){
                giocatore2=ValoreFaccia;
            }
            if(giocate==1){
                giocatore1=ValoreFaccia;
                System.out.println("gioca il giocatore 2:");
            }
            giocate++;
        }while (giocate<=2);
        if (giocatore1<giocatore2){
            System.out.println("ha vinto in giocatore2");
        }
        if (giocatore2<giocatore1){
            System.out.println("ha vinto in giocatore1");
        }
        if (giocatore2==giocatore1){
            System.out.println("hanno lo stesso numero");
        }

    }
    private static void faceDado(int ValoreFaccia){
        switch ( ValoreFaccia) {
            case 1:{
                System.out.println("\t\t\t\t\t\t\t  _______\n" +
                        "\t\t\t\t\t\t\t |       |\n" +
                        "\t\t\t\t\t\t\t |   ●   |\n" +
                        "\t\t\t\t\t\t\t |_______|");
                break;
        }
            case 2: {
                System.out.println("\t\t\t\t\t\t\t  _______\n" +
                        "\t\t\t\t\t\t\t | ●     |\n" +
                        "\t\t\t\t\t\t\t |   ●   |\n" +
                        "\t\t\t\t\t\t\t |_______|");
                break;
            }
            case 3: {
                System.out.println("\t\t\t\t\t\t\t  _______\n" +
                        "\t\t\t\t\t\t\t | ●   ● |\n" +
                        "\t\t\t\t\t\t\t |   ●   |\n" +
                        "\t\t\t\t\t\t\t |_______|");
                break;
            }
            case 4: {
                System.out.println("\t\t\t\t\t\t\t  _______\n" +
                        "\t\t\t\t\t\t\t | ●   ● |\n" +
                        "\t\t\t\t\t\t\t | ●   ● |\n" +
                        "\t\t\t\t\t\t\t |_______|");
                break;
            }
            case 5: {
                System.out.println("\t\t\t\t\t\t\t  _______\n" +
                        "\t\t\t\t\t\t\t | ●   ● |\n" +
                        "\t\t\t\t\t\t\t | ● ● ● |\n" +
                        "\t\t\t\t\t\t\t |_______|");
                break;
            }
            case 6: {
                System.out.println("\t\t\t\t\t\t\t  _______\n" +
                        "\t\t\t\t\t\t\t | ● ● ● |\n" +
                        "\t\t\t\t\t\t\t | ● ● ● |\n" +
                        "\t\t\t\t\t\t\t |_______|");
                break;
            }
        }



    }


    private static void Wait() {
        try {
            Thread.sleep(500);//sono millisecondi
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

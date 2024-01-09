import java.util.Scanner;

public class barchi_3E_Es11A_EsercizioNatalizio {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        double incasso = 0;
        int pFinal = 0;
        int uovaNat = 0;
        int costoUova;
        int scelta;
        final int uovo1 = 2;
        String other = kb.next();

        do {
        //Scelta del lavoro in input
        System.out.println("Benvenuto! Cosa vuoi fare?");
        System.out.println("1. Cuocere uova di Natale");
        System.out.println("2. Pagare il conto");
        System.out.println("3. Stampare l'incasso del giorno");
        scelta = kb.nextInt();


        switch (scelta) { //Switch case
            case 1:
                System.out.println("Inizio a cuocere le uova di Natale...");
                System.out.println("Vuoi cuocere un'altro uovo? (sì/no)");

                while (other.equals("sì")) {
                    uovaNat++;
                    incasso = incasso + 1.5; // supponiamo un costo di 1.5 euro per uovo
                    System.out.println("Vuoi cuocere un'altra uova? (sì/no)");
                    other = kb.next();
                }
                System.out.println("Hai cotto " + uovaNat + " uova di Natale.");
                costoUova = uovaNat * uovo1;
                pFinal = pFinal + costoUova;
                break;
                case 2:
                    System.out.println("Cosa vuoi?\n"+
                            "1.hamburgher di renna\n"+
                            "2.vegani\n"+
                            "3.alcoliche\n" +
                            "4.analcoliche\n");
                    break;

                case 3:
                    System.out.println("L'incasso del giorno è di: " + pFinal + " euro.");
                    break;

                case 4:
                    System.out.println("sei uscito dal programma");
                    break;

                default:
                    System.out.println("Scelta non valida. \n" +
                            "Riprova inserendo un numero da 1 a 4.");
                    break;
            }
        }while (scelta<4);
    }
}
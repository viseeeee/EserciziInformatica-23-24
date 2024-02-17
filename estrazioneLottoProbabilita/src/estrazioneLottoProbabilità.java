import java.util.Scanner;
import java.util.Random;
public class estrazioneLottoProbabilità {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numeroVolte;
        int terno2, terno3;
        int quaterna2, quaterna3, quaterna4;
        int indovinatiTerna = 0,indovinatiQuaterna=0;
        int contatore2 = 0;
        boolean ciclo = false;
        int[] numeriInseriti = new int[5];
        int[] somma = new int[9];
        int contatore1 = 0;
        for (int volte = 0; volte < numeriInseriti.length; volte++) {
            System.out.println("inserisci un numero");
            numeriInseriti[volte] = keyboard.nextInt();
        }

        //per il terno
        for (int terno1 = 0; terno1 < numeriInseriti.length; terno1++) {
            for (terno2 = terno1 + 1; terno2 < numeriInseriti.length; terno2++) {
                for (terno3 = terno2 + 1; terno3 < numeriInseriti.length; terno3++) {
                    somma[contatore1] = numeriInseriti[terno1] + numeriInseriti[terno2] + numeriInseriti[terno3];
                    contatore1++;
                    for (contatore2 = 0; contatore2 < contatore1; contatore2++) {
                        if (contatore1 == 1) {
                            System.out.println("la combinazione è:" + numeriInseriti[terno1] + " " + numeriInseriti[terno2] + " " + numeriInseriti[terno3]);
                            indovinatiTerna++;
                        }
                        if (somma[contatore1] != somma[contatore2] && contatore1 > 1) {
                            System.out.println("la combinazione è: " + numeriInseriti[terno1] + " " + numeriInseriti[terno2] + " " + numeriInseriti[terno3]);
                            contatore1--;

                            indovinatiTerna++;
                        }
                    }
                }
                terno3 = 0;

            }
            terno2 = 0;
        }
        System.out.println("i numeri indovinati sono: " + indovinatiTerna);

        //per la quaterna
        for (int quaterna1 = 0; quaterna1 < numeriInseriti.length; quaterna1++) {
            for (quaterna2 = quaterna1 + 1; quaterna2 < numeriInseriti.length; quaterna2++) {
                for (quaterna3 = quaterna2 + 1; quaterna3 < numeriInseriti.length; quaterna3++) {
                    for (quaterna4 = quaterna3 + 1; quaterna4 < numeriInseriti.length; quaterna4++) {
                        somma[contatore1] = numeriInseriti[quaterna1] + numeriInseriti[quaterna2] + numeriInseriti[quaterna3] + numeriInseriti[quaterna4];
                        contatore1++;
                        for (contatore2 = 0; contatore2 < contatore1; contatore2++) {
                            if (contatore1 == 1) {
                                System.out.println("la combinazione è:" + numeriInseriti[quaterna1] + " " + numeriInseriti[quaterna2] + " " + numeriInseriti[quaterna3] + " " + numeriInseriti[quaterna4]);
                                indovinatiQuaterna++;
                            }
                            if (somma[contatore1] != somma[contatore2] && contatore1 > 1) {
                                System.out.println("la combinazione è: " + numeriInseriti[quaterna1] + " " + numeriInseriti[quaterna2] + " " + numeriInseriti[quaterna3] + " " + numeriInseriti[quaterna4]);
                                contatore1--;
                                indovinatiQuaterna++;
                            }

                        }
                    }
                    quaterna4=0;
                }
                quaterna3=0;
            }
            quaterna2 = 0;

        }
        System.out.println("i numeri indovinati sono: " + indovinatiQuaterna);

    }
}








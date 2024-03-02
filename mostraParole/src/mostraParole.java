import javax.swing.*;
import java.util.Scanner;
//mette dentro un array le parole di una frase
public class mostraParole {
    public static void main(String[] args) {
        int[] lunghezza;
        String[] parole;
        int caratteri;
        Scanner keyboard = new Scanner(System.in);
        String frase;
        System.out.println("inserisci la frase");
        frase=keyboard.nextLine();
        caratteri=Vuoti(frase);
        lunghezza=lunghezza(frase,caratteri);
        parole=Parole(caratteri,frase,lunghezza);
        for (int i=0;i<parole.length;i++){
            System.out.println(parole[i]);
        }

    }
    private static int Vuoti(String frase){
        int caratteri=1;
        for (int i=0;i<frase.length();i++) {
            if (' ' == frase.charAt(i)){
                caratteri++;
            }
        }
        return caratteri;
    }

    private static int[] lunghezza(String frase,int caratteri){
        int[] lunghezza=new int[caratteri];
        int cella=0;
        for (int k=0;k<caratteri;k++)
            for (int i=cella;i<frase.length();i++) {
            if (' ' != frase.charAt(i)){
                lunghezza[k]++;
                cella++;
            }else {
                i=frase.length()+1;
                cella=cella+1;
            }
        }
        return lunghezza;
    }
    private static String[] Parole(int caratteri, String frase, int[] lunghezza){
        String[] parole=new String[caratteri];
        int cella=0;
        int i=0;
        for (int k=0;k<caratteri;k++) {
            for ( i =0; i < lunghezza[k]+1; i++) {
                if (k==caratteri-1 && i==lunghezza[k]) {
                    break;
                }
                else if (i==0){
                    parole[k]= String.valueOf(frase.charAt(cella));
                } else if (' ' != frase.charAt(cella)) {
                    parole[k]+= String.valueOf(frase.charAt(cella));
                }
                cella++;


            }
            }
        return parole;
    }
}

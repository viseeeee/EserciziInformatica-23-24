import java.util.Random;

public class statistica {
    public static void main(String[] args)
    {
        int [] frequenze  = new int[6];   //Il vettore è una collezione di dati dello stesso tipo.
        int valore=0;
        for( int i=0; i<2; i++) {
            valore = valoreRandom(0, 6);
            System.out.println(frequenze[1]);
            // System.out.printf("Valore %d \n ",valore);  //%d vuoldire variabile di tipo intero.
            //%f vuoldire float
            // %s vuoldire stringa
            // %c vuoldire char (carattere)
            // Printf serve per formattare il testo.
            FacceDado(valore);
            frequenze[valore-1]=+1;
            for(int index=0; index<frequenze.length; index++)
            {
                System.out.println("Faccia"+(index+1)+"="+frequenze[index]);
            }
        }
          /* System.out.printf(" Faccia1: %d,Faccia2: %d,Faccia3: %d,Faccia4: %d,Faccia5: %d,Faccia6: %d ",faccia1,faccia2,faccia3,
                    faccia4,faccia5,faccia6);*/
    }

    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random(); //Metodo che non ha nessun parametro, si chiama costruttore
        return  casuale.nextInt(minValue,maxValue)+1;
    }
    private static void FacceDado(int valoreFaccia1)
    {
        //ALT + 201 ╔
        //ALT + 188 ╝
        //ALT + 187 ╗
        //ALT + 200 ╚
        //ALT + 205 ═
        //ALT + 186 ║

        switch (valoreFaccia1) {
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }

            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }

            case 6 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        }
    }
}


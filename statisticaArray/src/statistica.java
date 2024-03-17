import java.util.Random;

public class statistica {
    public static void main(String[] args)
    {
        int [] frequenze  = new int[6]; //creazione dell'array 
        int valore=0;//si inizializza a 0
        for( int i=0; i<2; i++) {
            valore = valoreRandom(0, 6);
            System.out.println(frequenze[1]);
            FacceDado(valore);
            frequenze[valore-1]=+1;// fà aumentare di 1 la cella 
            // la frequenza serve per mostrare quante volte è uscita quella cella
            for(int index=0; index<frequenze.length; index++)
            {
                System.out.println("Faccia"+(index+1)+"="+frequenze[index]);// serve per stampare 6 volte la stessa cosa
            }
        }
    }

    private static int valoreRandom(int minValue, int maxValue)//metodo che serve per creare il valore random
    {
        Random casuale = new Random();//crea il valore random
        return  casuale.nextInt(minValue,maxValue)+1; // si fà il return fi casuale(il valore random) che è compreso tra minValue e MaxValue
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
                //dado che vale 1 
            case 1 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }
           //dado che vale 2
            case 2 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");

                break;
            }
        //dado che vale 3
            case 3 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O      ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║      O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
            //dado che vale 4
            case 4 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
        //dado che vale 5
            case 5 : {
                System.out.println("\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ║    O    ║");
                System.out.println("\t\t\t\t ║  O   O  ║");
                System.out.println("\t\t\t\t ╚═════════╝");
                break;
            }
            //dado che vale 6
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


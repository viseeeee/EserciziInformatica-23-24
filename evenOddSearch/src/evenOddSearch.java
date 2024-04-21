import java.util.Scanner;
import tools.utility.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class evenOddSearch {
    public static void main(String[] args) {
        int[] numeri = new int[100];
        String[] operazioni = {"MENU",
                "[1] Inserimento",
                "[2] evenOddSearch ",
                "[3] biBinarySearch ",
                "[4] visualizzazione",
                "[5] esci"};
        Scanner keyboard = new Scanner(System.in);
        int numeriInseriti = 0;
        boolean ripetizione=true;
        int numeriPari = 0;
        do {
        switch (tools.utility.menu(operazioni, keyboard)) {
            case 1 -> {
                if (numeriInseriti==numeri.length){
                    //serve per copiare l'array
                    //perchè il punto 3 toglie tutti gli zeri che erano presenti nell'array all'inizio
                    numeri=copia(numeri);
                }
                if (numeriInseriti < numeri.length) { // Assicurati che ci sia spazio nell'array
                    //inserimento del numero
                    System.out.println("Inserisci il numero:");
                    numeri[numeriInseriti] = keyboard.nextInt();
                    numeriInseriti++;
                    //aumento dei numeri inseriti
                    keyboard.nextLine(); // Consuma il resto della riga dopo l'input del numero
                } else {
                    System.out.println("Spazio nell'array esaurito.");
                }
            }

            case 2->{
                //richiama il metodo dell'ordinamento
            numeri=evenOddSearch(numeri,numeriInseriti);
            System.out.println("L'ordinamento è finito");
            }

            case 3->{
                //inserimento del numero da ricercare
                System.out.println("Inserisci il numero che vuoi ricercare");
                int NumeroRicercato= keyboard.nextInt();
                int pos=0;

                //richiamo del metodo
                pos=biBinarySearch(numeri,numeriInseriti,NumeroRicercato);

                //out della posizione
                System.out.println("La posizione di quell'oggetto è:");
                System.out.println(pos);
                keyboard.nextLine();
            }

            //visualizzazione
            case 4->Visualizza(numeri,numeriInseriti);

            //esce dal cicl o
            case 5->ripetizione=false;
        }
        }while (ripetizione);
    }

    //
    private static int[] evenOddSearch(int[] numeri, int numeriInseriti) {
        int[] copiaNumeri = new int[numeriInseriti];
        int[] numeriPari = new int[numeriInseriti];
        int[] numeriDispari = new int[numeriInseriti];
        int ripetizione=0;
        int volte1 = 0, volte2 = 0;
        for (int i = 0; i < numeriInseriti; i++) {
            //entra con i numeri pari
            if (numeri[i] % 2 == 0) {
                numeriPari[volte1] = numeri[i];
                volte1++;
            } else {
                numeriDispari[volte2] = numeri[i];
                volte2++;
            }
        }

        //ordina in modo crescente i numeri pari
        numeriPari = Crescente(numeriPari, volte1);

        //ordina in modo decrescente i numeri dispari
        numeriDispari=Decrescente(numeriDispari,volte2);

        //
        for (int i=0;i<volte1;i++){
            copiaNumeri[i]=numeriPari[i];
        }
        for (int k=volte1;k<numeriInseriti;k++){
            copiaNumeri[k]=numeriDispari[ripetizione];
            ripetizione++;
        }
        return copiaNumeri;
    }

    //mette i numeri in ordine decrescente
    private static int[] Crescente(int[] pari, int volte) {
        int[] ordinato = new int[volte];
        boolean ripetizione = true;
        int volteRipetute = 0;

        do {
            //gli fornisce il valore intero maggiore
            int minore = Integer.MAX_VALUE;
            int posizione = -1;

            for (int i = 0; i < volte; i++) {
                //entra quando è un numero minore
                if (pari[i] < minore && pari[i]!=3) {
                    minore = pari[i];
                    posizione = i;
                }
            }

            //se non entra nel for esce dal ciclo
            if (posizione == -1) {
                break;
            }


            if (volteRipetute == volte) {
                ripetizione = false;
            }else {
                //mette il numero maggiore
                ordinato[volteRipetute] = minore;

                //segna l'elemento come già utilizzato
                pari[posizione] = 3;

                //conta tutti gli elemtni che ho ordinato
                volteRipetute++;
            }
        } while (ripetizione);
        return ordinato;
    }

    //mette i numeri in ordine decrescente
    private static int[] Decrescente(int[] pari, int volte) {
        int[] ordinato = new int[volte];
        boolean ripetizione = true;
        int volteRipetute = 0;

        do {
            int maggiore = 0;
            int posizione = -1;

            //prende il numero maggiore
            for (int i = 0; i < volte; i++) {
                if (pari[i] > maggiore && pari[i]!=-4) {
                        maggiore = pari[i];
                        posizione = i;
                }
            }

            //esce dal ciclo quando non ci sono numeri che sono minori
            if (posizione == -1) {
                break;
            }

            if (volteRipetute == volte) {
                ripetizione = false;
            }else {
                //mette il numero maggiore
                ordinato[volteRipetute] = maggiore;

                //segna l'elemento come già utilizzato
                pari[posizione] = -4;

                //conta tutti gli elemtni che ho ordinato
                volteRipetute++;
            }
        } while (ripetizione);
        return ordinato;
    }


    private static int biBinarySearch(int[] numeri,int numeriInseriti,int NumeroRicercato){
        boolean maggiore=false;
        int NumeriPari = 0, NumeriDispari = 0;

        //trova la fine dei numeri pari e dei numeri dispari
        for (int i = 0; i < numeriInseriti; i++) {
            if (numeri[i] % 2 == 0) {
                NumeriPari=i;
            } else {
                NumeriDispari=i;
            }
        }

        //entra se il numero ricercato è pari
        if (NumeroRicercato%2==0){

            //trova se il numero è minore della metà e quindi è più piccolo
            if(numeri[NumeriPari/2]>NumeroRicercato){
                maggiore=true;
            }
            if (numeri[NumeriPari/2]==NumeroRicercato){
                return NumeriPari/2;
            }

            //entra quando il numero è minore della metà e quindi più piccolo
            for (int i=NumeriPari/2;i<NumeriPari+1 && !maggiore;i++){

                //trova se il numero è uguale
                if(numeri[i]==NumeroRicercato) {
                    return i;
                }
            }

            //entra quando il numero da ricercare è maggiore rispetto al centro dei numeri pari
            for (int i = 0; i < NumeriPari/2 && maggiore; i++) {
                //trova se il numero è uguale;

                if(numeri[i]==NumeroRicercato) {
                    return i;
                }
            }
            //entra quando il numero ricercato è dispari
        }else {

            //trova se il numero è minore rispetto al centro
            if(numeri[NumeriPari+NumeriDispari/2]>NumeroRicercato){
                maggiore=true;
            }
            if (numeri[NumeriPari+NumeriDispari/2]==NumeroRicercato){
                return NumeriPari+NumeriDispari/2;
            }
            //entra quando il numero è maggiore rispetto al centro
            for (int i = NumeriPari+1; i < NumeriPari+NumeriDispari/2 && !maggiore ; i++) {
                //entra quando il numero è uguale

                if (numeri[i] == NumeroRicercato) {
                    return i;
                }
            }
            //entra quando è minore del numero presente nella metà
            for (int i=NumeriPari+NumeriDispari/2;i<NumeriDispari+1 && maggiore;i++){

                //entra quando trova il numero uguale
                if(numeri[i]==NumeroRicercato) {
                    return i;
                }
            }

            //entra quando i numeri

        }


        return -1;
    }

    //copia il l'array
    private static int[] copia(int[] numeri){
        int[] copiaNumeri=new int[100];
        for (int i=0;i< numeri.length;i++){
            copiaNumeri[i]=numeri[i];
        }
        return copiaNumeri;
    }

    //out
    private static void Visualizza(int[] inserimento,int volte){
        System.out.println("I numeri inseriti sono:");
        for (int i=0;i<volte;i++){
            System.out.println(inserimento[i]);
        }
    }
}



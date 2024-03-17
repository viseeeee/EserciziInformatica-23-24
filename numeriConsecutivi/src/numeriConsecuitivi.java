import java.util.Random;
public class numeriConsecuitivi {
    public static void main(String[] args) {
        //Scrivere un programma TreConsecutivi che prevede un array di 10 numeri interi contenente valori a piacere (senza bisogno di chiederli all’utente) e
        // stampa "Tre valori consecuitivi uguali" se l’array contiene tre valori uguali in tre posizioni consecutive, oppure stampa "NO" altrimenti.
        int i, k;
        int numeroPrec=0;
        int minValue=1,maxValue=5;
        int volte = 0, consecutivi = 0;
        int primoNumero = 0;
        int[] numeri = new int[10];

        //inserimento di tre numeri casuali compresi tra 1 e 5
        for (int j = 0; j < numeri.length; j++) {
            numeri[j]=random(minValue,maxValue);
        }

        //controllo se i numeri sono consecutivi
        for (int l=0;l<numeri.length;l++){
            volte++;
            if (consecutivi==0) {
                consecutivi++;
                primoNumero = numeri[l];
                numeroPrec= numeri[l];
            }
            if (numeri[l]==numeroPrec+1){
                    consecutivi++;
                    numeroPrec= numeri[l];
                }
            //se 3 numeri non sono consecutivi si riinizia tutto in controllo precedente
            if (volte== 3) {
                volte=0;
                l=l-2;

                //stampa dei numeri consecutivi
                if (consecutivi == 3) {
                    consecutivi=0;
                    for (k =primoNumero; k < primoNumero+3; k++) {
                        System.out.println("I numeri cosecutivi sono:");
                        System.out.println(numeri[k]);
                    }
                }

                //out Questi tre numeri non sono cosecutivi se quei 3 numeri non sono consecutivi
                if (consecutivi<3) {
                    consecutivi=0;
                    System.out.println("Questi tre numeri non sono cosecutivi");
                }
                consecutivi=0;
            }

        }
        }

    //metodo del random
    private static int random( int minValue,int maxValue){
        Random casuale=new Random();
        return casuale.nextInt(minValue,maxValue);
    }
}

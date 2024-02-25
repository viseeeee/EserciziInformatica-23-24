import java.util.Random;
 class prova {
    public static void main(String[] args) {
        int cifra;
        double risultato=0;
        int max=2;
        int min=0;
        int[] c=new int[8];
        for (int i=0;i<c.length;i++){
            c[i]=random(max,min);
            System.out.print(c[i]);
        }
        cifra=Controllo(c);
        if ((cifra+1)<8){
            System.out.println("\nnon è un numero formato da 8 bit ");
        }else {
            System.out.println("\nè un numero formato da 8 bit");
        }
        risultato=esponente(c);
        System.out.println(risultato+"\n"+cifra);


    }
    //metodo random
     private static int random(int max, int min){
        Random c=new Random();
        return c.nextInt(min,max);
     }
        //posizione finale 1
        private static int Controllo(int[] c){
        int cifra=0;
        for (int k=c.length-1;k>=0;k--){
                if (c[k]==1){
                    cifra=c.length-k-1;
                }
        }
        return cifra;
        }

         private static int esponente(int[] c) {
             int risultato = 0;
             int esponente = 1;

             for (int k = c.length - 1; k >= 0; k--) { // Ciclo da destra verso sinistra
                 if (c[k] != 0) {
                     for (int j = 0; j < c.length - 1 - k; j++) { // Calcolo della posizione corretta
                         esponente *= 2;
                     }
                     risultato += esponente;
                     esponente = 1;
                 }
             }
             return risultato;
         }
     }

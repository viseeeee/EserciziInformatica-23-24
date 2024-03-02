import java.util.Scanner;

 class Main {
    //Visentin Luca cl.3E 21/6/2024
    public static void main(String[] args) {
        int quantita,copiaQuantita;
        int pari,positivi;
        int contatore=0;//dichiarazione del contatore
        //inizializzazione dell'array
        int[] numeri=new int[20];

        //inizializzazione keyboard
        Scanner keyboard=new Scanner(System.in);

        //inserimento della quantità dei numeri che si vogliono inserire
        System.out.println("quanti numeri vuoi inserire?(0/20)");
        quantita=keyboard.nextInt();
        while (quantita<=0 || quantita>20){
            System.out.println("reiserisci i numeri");
            quantita=keyboard.nextInt();
        }

        //inserimento numeri
        for (copiaQuantita=quantita;copiaQuantita>0;copiaQuantita--){
            System.out.println("inserisci i numeri");
            numeri[contatore]= keyboard.nextInt();
            contatore++;
        }
        //richiamo dei metodi
        pari=verificaPari(numeri,quantita);
        positivi=verificaPos(numeri);
        //visualizzazione
        if (pari==quantita && positivi==quantita){
            System.out.println("tutti numeri positivi e pari");
        }else {
            System.out.println("NO");
        }
    }
    //metodo per la verifica dei numeri positivi
    private static int verificaPos(int[] numeri){
             int positivi=0;

        for (int i =0;i< numeri.length;i++){
            if (numeri[i]>0){
                positivi++;
            }
        }
        return positivi;
    }

    //metodo per la verifica dei numeri pari
    private static int verificaPari(int[] numeri,int quatita){
        int pari=0;
        int modulo;
        for (int i=0;i<quatita;i++){
            //il modulo che serve per verificare se è pari o no
          modulo=numeri[i]%2;
            if (modulo==0 && numeri[i]!=0){
                pari++;
            }
        }
        return pari;
    }
}
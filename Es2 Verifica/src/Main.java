

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner keyboard=new Scanner(System.in);
        //faccio inserire all’utente quanti numeri vuole inserire
        System.out.println("Inserisci quanti numeri vuoi inserire");
        int quantita =keyboard.nextInt();
        //chiede all’utente quanti numeri vuole inserire, in caso il valore inserito sia sbagliato lo fa reinserire
        while (quantita !=10 && quantita !=11){
            System.out.println("hai inserito un valore sbagliato");
            quantita =keyboard.nextInt();
        }
        //dichiare l’array di dove andranno salvati tutti i numeri
        int[] inserimento=new int[quantita];
        int inseriti=0;
        int numero;
        //inserimento dei nuemri
        for(int i = 0; i< quantita; i++){
            System.out.println("Inserisci il numero " +(i+1));
            numero=keyboard.nextInt();
            inseriti++;
            while (ripetuti(inserimento,numero,inseriti) || numero==0 || numero>30 ){
                System.out.println("Reinserisci il valore");
                numero=keyboard.nextInt();
            }
            
            //salvo nell’array i numeri presi direttamente dal metodo che li fa diventare positivi
            inserimento[i]=positivo(numero);

            //controlla se i numeri cambiati di segno sono positivi
            while (ripetuti(inserimento,inserimento[i],inseriti)){
                System.out.println("Reinserisci il valore");
                inserimento[i]=keyboard.nextInt();
            }
        }
        //entra solo se sono stati inseriti dei numeri pari
        if(ContaPari(inserimento)>1){

            //chiamo il metodo che mi prende i numeri pari
            int[] pari=pari(inserimento);
            //metodo che cambia tutti i numeri pari tranne l’ultimo
            cambiaNumero(inserimento);
            //metodo che mi riordina i numeri pari
            ordinamento(pari);
            int volte=0;

            System.out.println("L'array con i pari riordinati è:");
            //mi salva i numeri pari riordinati al posto dei -1
            for(int i=0;i<inserimento.length;i++){
                if(inserimento[i]==-1){
                    inserimento[i]=pari[volte];
                    volte++;
                }
                System.out.print(inserimento[i] + "  ");
            }

        }else{
            System.out.println("non hai inserito numeri paro o ne hai inserito soltanto uno non contando l'ultimo");
        }
    }


    //bubble sort che mi ordina i numeri pari
    private static void ordinamento(int[] pari){
        //variabile temporanea
        int temp;
        for(int i=0;i< pari.length-1;i++){
            for (int j=i+1;j<pari.length;j++){
                if(pari[i]>pari[j]){
                    temp=pari[i];
                    pari[i]=pari[j];
                    pari[j]=temp;
                }
            }
        }
    }


    //pone tutti i numeri pari in -1
    private static void cambiaNumero(int[] inserimento){
        for(int i=0;i< inserimento.length-1;i++) {
            if (inserimento[i] % 2 == 0) {
                inserimento[i] = -1;
            }
        }
    }


    //serve per contare tutti i numeri pari che sono presenti nell’array
    private static int ContaPari(int[] inserimento){
        int volte=0;
        for(int i=0;i<inserimento.length-1;i++){
            if(inserimento[i]%2==0){
                volte++;
            }
        }
        if(volte>0){
            return volte;
        }else{
            return -1;
        }
    }

    //controlla i numeri ripetuti
    private static boolean ripetuti(int[] inseriti,int numero,int numeriInseriti){
        for (int i=0;i< numeriInseriti-1;i++){
            if(numero==inseriti[i]){
                return true;
            }
        }
        return false;
    }

    //crea l’array con tutti i numeri pari prendendoli da quelli inseriti
    private static int[] pari(int[] inserimento){
        int volte=0;
        int[] pari=new int[ContaPari(inserimento)];
        for(int i=0;i<inserimento.length-1;i++) {
            if (inserimento[i] % 2 == 0) {
                pari[volte] = inserimento[i];
                volte++;
            }
        }
        return pari;
    }

    //fa diventare i numeri negativi inseriti dall’utente in positivi
    private static int positivo(int numero){
        if(numero <0){
            return numero*-1;
        }else{
            return numero;
        }
    }
}
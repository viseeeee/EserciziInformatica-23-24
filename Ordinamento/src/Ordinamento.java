import java.util.Scanner;

public class Ordinamento {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        int inserimento[] = {5,8,0,1,4,2,4,3,9,7};
        int[] Pari=ArrayPari(inserimento);
        int[] Dispari=ArrayDispari(inserimento);
        int togli=0;
        if (QuantitaPari(inserimento)!=-1){
            CrescenteSelection(Pari);
        }else {
            System.out.println("Non ha inserito numeri pari");
        }
        if (QuantitaDispari(inserimento)!=-1){
            CrescenteBubble(Dispari);
        }else {
            System.out.println("Non ha inserito numeri Dispari");
        }

        //inserimento numeri pari con doppioni
        int[] ordinato=new int[inserimento.length*2];
        int uguale;
        int volte=0;
        for (int i=0;volte<Pari.length;i++){
            if (i%2==0){
                ordinato[i]=Pari[volte];
            }else {
                uguale=Uguali(inserimento,ordinato[i-1]);
                ordinato[i]=uguale;
                if (uguale>1){
                    volte=volte+uguale;
                    togli+=uguale;
                }else {
                    volte++;
                }
            }
        }
        ordinato=posEliminata(ordinato,togli);
        togli=0;
        //inizializzazione volte
        volte=0;
        //inserimento numeri dispari con doppioni
        for (int i= ordinato.length-Pari.length*2;i<ordinato.length;i++){
            if (i%2==0){
                ordinato[i]=Dispari[volte];

            }else {
                uguale=Uguali(inserimento,ordinato[i-1]);
                ordinato[i]=uguale;
                if (uguale>1){
                    i=i+uguale;
                    togli+=uguale;
                }else {
                    volte++;
                }
            }
        }
        ordinato=posEliminata(ordinato,togli);
        for (int i=0;i< ordinato.length;i++){
            System.out.println(ordinato[i]);
        }
    }

    private static int[] posEliminata(int[] inserimento,int togli){
        int[] nuovo=new int[inserimento.length-togli];
        for (int i=0;i< inserimento.length-togli;i++){
            nuovo[i]=inserimento[i];
        }
        return nuovo;
    }
    private static int Uguali(int[] inserimento,int ordinato){
        int volte=0;
        for (int i=0;i< inserimento.length;i++){
            if (inserimento[i]==ordinato){
                volte++;
            }
        }
        return volte;
    }
    private static int QuantitaPari(int[] volte){
        int quantitaPari=0;
        for (int i=0;i< volte.length;i++){
            if (volte[i]%2==0){
                quantitaPari++;
            }
        }
        if (quantitaPari!=0)
            return quantitaPari;
        else
            return -1;
    }

    private static int QuantitaDispari(int[] volte){
        int quantitaDispari=0;
        for (int i=0;i< volte.length;i++){
            if (volte[i]%2==0){
                quantitaDispari++;
            }
        }
        if (quantitaDispari!=0)
            return quantitaDispari;
        else
            return -1;
    }

    private static int[] ArrayPari(int[] volte){
        int quantitaPari=0;
        int[] Pari=new int[QuantitaPari(volte)];
        for (int i=0;i< volte.length;i++){
            if (volte[i]%2==0){
                Pari[quantitaPari]=volte[i];
                quantitaPari++;
            }
        }
        return Pari;
    }

    private static int[] ArrayDispari(int[] volte){
        int quantitaDispari=0;
        int[] Dispari=new int[QuantitaDispari(volte)];
        for (int i=0;i< volte.length;i++){
            if (volte[i]%2!=0){
                Dispari[quantitaDispari]=volte[i];
                quantitaDispari++;
            }
        }
        return Dispari;
    }

    private static void CrescenteBubble(int[] inserimento){
        int temp;
        for (int i = 0; i< inserimento.length-1; i++){
            for (int j = i+1; j< inserimento.length; j++){
                if (inserimento[i]> inserimento[j]){
                    temp= inserimento[i];
                    inserimento[i]= inserimento[j];
                    inserimento[j]=temp;
                }
            }
        }
    }

    private static void CrescenteSelection(int[] inserimento){
        int minore;
        int posizione=0;
        for (int i=0;i< inserimento.length-1;i++){
            minore=inserimento[i];
            posizione=i;
            for (int j=i+1;j<inserimento.length;j++){
                if (minore>inserimento[j]){
                    minore=inserimento[j];
                    posizione=j;
                }
            }
            inserimento[posizione]=inserimento[i];
            inserimento[i]=minore;
        }
    }


    private static void selection(int[] inserimento){
        int minore=0;
        int posizione;
        for (int i=0;i<inserimento.length;i++){
            minore=inserimento[i];
            posizione=i;
            for (int j=i+1;j<inserimento.length;j++){
                if (minore>inserimento[j]){
                    minore=inserimento[j];
                    posizione=j;
                }
            }
            inserimento[posizione]=inserimento[i];
            inserimento[i]=minore;
        }
    }
    private static void SelectionDecrescente(int[] inserimento){
        int maggiore;
        int posizione;
        for (int i=0;i<inserimento.length;i++){
            maggiore=inserimento[i];
            posizione=i;
            for(int j=i+1;j<inserimento.length;j++){
                if (maggiore<inserimento[j]){
                    maggiore=inserimento[j];
                    posizione=j;
                }
            }
            inserimento[posizione]=inserimento[i];
            inserimento[i]=maggiore;
        }
    }

    private static void BubbleDecrescente(int[] inserimento){
        int temp;
        for (int i=0;i< inserimento.length;i++){
            for (int j=i+1;j< inserimento.length;j++){
                if (inserimento[i]<inserimento[j]){
                    temp=inserimento[i];
                    inserimento[i]=inserimento[j];
                    inserimento[j]=temp;
                }
            }
        }

    }
}

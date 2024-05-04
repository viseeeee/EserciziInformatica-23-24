import java.util.Scanner;
import java.util.Random;
public class tools {

    //metodo random
    private static int random(int max, int min){
        Random c=new Random();
        return c.nextInt(min,max);
    }

    //clear screen
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //wait
    public static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //menu
    public static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = Integer.parseInt(keyboard.nextLine());
            if(scelta<1 || scelta>opzioni.length-1)
            {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }

    //inserimento
    /*private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono","1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }*/


    //visualizza
    /*public int getRisultato() {
        return risultato;
    }*/

    //controlla se un elemento è presente e ritorna le volte che lo è
    /*private static int Posizione(Numero[] inserimento,Numero ricerca,int volte){
        for (int i=0;i<volte;i++){
            if (ricerca.getNumero1()==inserimento[i].getNumero1() && ricerca.getNumero2()==inserimento[i].getNumero2() && ricerca.operazione.equals(inserimento[i].operazione)){
                return i;
            }
        }
        return -1;
    }*/

    //metodo che serve per aumentare di 1 giorno la data


    private static int[] data_down(int giorno, int mese, int anno){
        int[] dataCambiata=new int[3];
        switch (giorno){
            case 1 -> {
                mese=mese-1;
                if (mese!=0 && giorno==1){
                    switch (mese){
                        case 1, 3, 5, 7, 8, 10, 12-> giorno=31;
                        case 4, 6, 9, 11 -> giorno=30;
                        case 2-> {
                            if (Bisestile(anno)){
                                giorno=29;
                            }
                        }
                    }
                }else {
                    anno=anno-1;
                    mese=12;
                    giorno=31;
                }
            }
            default -> giorno=giorno-1;
        }
        for (int i=0;i<dataCambiata.length;i++){
            if (i==0){
                dataCambiata[i]=giorno;
            }
            else if (i==1){
                dataCambiata[i]=mese;
            }
            else{
                dataCambiata[i]=anno;
            }
        }
        return dataCambiata;
    }


    //metodo che serve per diminuire di 1 giorno la data
    private static int[] data_up(int giorno, int mese, int anno) {
        int[] dataCambiata = new int[3];
        switch (giorno) {
            case 31 -> {
                switch (mese) {
                    case 1, 3, 5, 7, 8, 10-> {
                        giorno = 1;
                        mese = mese + 1;
                    }
                    case 12-> {
                        giorno = 1;
                        mese = 1;
                        anno = anno + 1;
                    }
                }
            }
            case 30 -> {
                switch (mese) {
                    case 4, 6, 9, 11 -> {
                        giorno = 1;
                        mese=mese+1;
                    }
                    case 1, 3, 5, 7, 8, 10,12->giorno=giorno+1;
                }
            }
            case 29 -> {
                switch (mese) {
                    case 2 -> {
                        giorno=1;
                        mese=mese+1;
                    }
                    default -> giorno=giorno+1;
                }

            }
            case 28-> {
                switch (mese) {
                    case 2 -> {
                        if (!Bisestile(anno)) {
                            mese = mese + 1;
                            giorno = 1;
                        } else {
                            giorno = giorno + 1;
                        }
                    }
                }
            }
            default -> giorno = giorno + 1;
        }
        for (int i = 0; i < dataCambiata.length; i++) {
            if (i == 0) {
                dataCambiata[i] = giorno;
            } else if (i == 1) {
                dataCambiata[i] = mese;
            } else {
                dataCambiata[i] = anno;
            }
        }
        return dataCambiata;
    }


    //controlla se l'anno inserito è bisestile
    private static boolean Bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    }


    //controlla se la data inserita è valida
    private static boolean dataOk(int giorno, int mese, int anno) {
        boolean valida = false;
        valida = switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12 -> (giorno > 0 && giorno < 32);
            case 4, 6, 9, 11 -> (giorno > 0 && giorno < 31);
            case 2-> (Bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
            default -> false;
        };
        return valida;
    }



    //mi separa la data inserita tutta in una riga
    private static int[] separazioneData(int data) {
        //Contiene il valore d'uscita
        int[] output = new int[3];

        //Anno
        output[2] = data % 10000;
        //Rimuovere l'anno dalla data
        data /= 10000;
        //Mese
        output[1] = data % 100;
        //Rimuovere il mese dalla data
        data /= 100;
        //Giorno
        output[0] = data;

        //Ritornare i valori separati
        return output;
    }

    //mette in una stringa i numeri pari in ordine crescente e mette i numeri dispari in ordine descrescente
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

        //unisce una stringa i numeri pari e i numeri dispari
        for (int i=0;i<volte1;i++){
            copiaNumeri[i]=numeriPari[i];
        }
        for (int k=volte1;k<numeriInseriti;k++){
            copiaNumeri[k]=numeriDispari[ripetizione];
            ripetizione++;
        }
        return copiaNumeri;
    }


    //mette i numeri in ordine crescente
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

    //metodo che conta quanti numeri pari ci sono in un array
    private static int ConteggioPari(int lunghezza,int[] numeri) {
        int volte=0;
        for (int i = 0; i < lunghezza; i++) {
            //entra con i numeri pari
            if (numeri[i] % 2 == 0) {
                volte++;
            }
        }

        if (volte>0)
            return volte;
        else
            return -1;

    }


    //metodo che mette in array tutti i numeri pari
    private static int[] Pari(int lunghezza,int[] numeri) {
        int volte = 0;
        int[] numeriPari=new int[lunghezza];
        for (int i = 0; i < lunghezza; i++) {
            //entra con i numeri pari
            if (numeri[i] % 2 == 0) {
                numeriPari[volte] = numeri[i];
                volte++;
            }
        }
        return numeriPari;
    }




    //metodo che mette in array tutti i numeri dispari
    public static int[] Dispari(int lunghezza,int[] numeri) {
        int volte = 0;
        int[] numeriDispari=new int[lunghezza];
        for (int i = 0; i < lunghezza; i++) {
            //entra con i numeri dispari
            if (numeri[i] % 2 != 0) {
                numeriDispari[volte] = numeri[i];
                volte++;
            }
        }
        return numeriDispari;
    }


    //metodo che conta quanti numeri pari ci sono in un array
    public static int ConteggioDispari(int lunghezza,int[] numeri) {
        int volte=0;
        for (int i = 0; i < lunghezza; i++) {
            //entra con i numeri dispari
            if (numeri[i] % 2 != 0) {
                volte++;
            }
        }
        if (volte>0)
            return volte;
        else
            return -1;
    }

    //mostra i giorni le ore e i minuti dall'inserimento dei secondi
    public static void GiorniOreMinuti(int secondi){
        int ore,minuti,giorni;
        ore=secondi;
        minuti=secondi;
        giorni=secondi;
        giorni=giorni/86400;
        ore=ore%86400/3600;
        minuti=minuti%86400%3600/60;
        secondi=secondi%86400%3600%60;
        System.out.println("giorni: "+giorni+" ore:"+ore+" minuti:"+minuti+" secondi:"+secondi);
    }
}

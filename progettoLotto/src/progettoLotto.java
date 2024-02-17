import java.util.Scanner;
import java.util.Random;
public class progettoLotto {
    public static void main(String[] args) {
        int scelta,sceltaRuota = 0,numeriEstratti = 0;
        int sceltaNome;
        double costoMinimo=0,costoFinale;
        int[] numeriInseriti=new int[5];
        int[] numeriCasuali=new int[5];
        boolean ruote;
        Scanner keyboard = new Scanner(System.in);
        String invio;
        int sceltaPuntata;
        int contatore = 0;
        boolean singoloBool = false,amboBool=false,ternoBool=false,quaternaBool=false,cinquinaBool=false;
        String altraRuota = null;
        int giocata;
        boolean scelta1=true,scelta2=false,scelta3=false,scelta4=false,scelta5=false;
        int contatore2=0,contatore3=0,contatore4=0,contatore5=0;

        final double singolo = 11.23;
        final double singolo2 = 5.61;
        final double singolo3 = 3.74;
        final double singolo4 = 2.80;
        final double singolo5 = 2.24;
        final int ambo2 = 250;
        final double ambo3 = 83.33;
        final double ambo4 = 41.66;
        final double ambo5 = 25;
        final int terna3 = 4500;
        final int terna4 = 1125;
        final int terna5 = 450;
        final int quaterna4 = 120000;
        final int quaterna5 = 24000;
        final int cinquina5 = 6000000;

        String[] opzioni = {"=== Gioco Dadi === ",
                "[1] scelta della ruota singola o tutte e 10 le ruote",
                "[2] Quanti numeri 1-5 vuoi estrarre?",//con l'estrazione dei numeri
                "[3] singolo, ambo, terna, quaterna, cinquina?",//con la probabilità di vincità
                "[4] Giocata (minimo - 200€)",
                "[5] Visualizza giocate",
                "[6] Exit"
        };
        String[] opzioniPuntata = {"=== Puntata === ",
                "[1] Singolo",
                "[2] Ambo",
                "[3] Terna",
                "[4] Quaterna",
                "[5] Cinquina"};

        String[] opzioniRuota = {"=== scelta della ruota === ",
                "[1] ruota singola",
                "[2] 10 ruote (tutte le ruote)"};

        int[] ruotaBari=new int[5];
        int[] ruotaCagliari=new int[5];
        int[] ruotaFirenze=new int[5];
        int[] ruotaGenova=new int[5];
        int[] ruotaMilano=new int[5];
        int[] ruotaNapoli=new int[5];
        int[] ruotaPalermo=new int[5];
        int[] ruotaRoma=new int[5];
        int[] ruotaTorino=new int[5];
        int[] ruotaVenezia=new int[5];

        String[] nomeRuota= {"=== nome della ruota === ",
                "[1] Bari",
                "[2] Cagliari",
                "[3] Firenze",
                "[4] Genova",
                "[5] Milano ",
                "[6] Napoli",
                "[7] Palermo",
                "[8] Roma",
                "[9] Torino",
                "[10] Venezia"};

        String[] estrazioneNumeri= {"=== numeri da estrarre === ",
                "[1] uno",
                "[2] due",
                "[3] tre",
                "[4] quattro",
                "[5] cinque "};
        do {
            scelta = Menu(opzioni, keyboard);
            switch (scelta) {


                case 1:{ //scelta della ruota
                    if (scelta1){
                        sceltaRuota = Menu(opzioniRuota, keyboard);
                        switch (sceltaRuota){
                            case 1:{
                                sceltaNome = Menu(nomeRuota, keyboard);
                                break;
                            }
                            case 2:{
                                costoMinimo = costoMinimo + 9;
                                ruote=true;
                                break;
                            }
                        }
                        keyboard.nextLine();
                        System.out.println("        ");
                        System.out.println("premi invio per continuare");
                        invio = keyboard.nextLine();
                    }
                    scelta1=false;

                    break;
                }
                case 2:{//estrazione dei numeri
                    contatore2++;
                    if (!scelta1 && contatore2==1){
                        scelta2=true;
                    }
                    if (scelta2 && contatore2==1){
                        numeriEstratti = Menu(estrazioneNumeri, keyboard);
                        for (int i = 0; i < numeriEstratti; i++) {
                            costoMinimo = costoMinimo + 0.50;
                            System.out.println("inserisci i numeri che vuoi puntare");
                            numeriInseriti[i] = keyboard.nextInt();
                        }
                        switch (sceltaRuota) {
                            case 1: {
                                for (int k = 0; k < numeriEstratti; k++) {
                                    numeriCasuali[k] = random(0,90);
                                    scelta2=false;
                                }
                                break;
                            }
                            case 2: {
                                for (int j = 0; j < numeriEstratti; j++) {
                                    ruotaBari[j]=random(0,90);
                                    ruotaCagliari[j]=random(0,90);
                                    ruotaFirenze[j]=random(0,90);
                                    ruotaGenova[j]=random(0,90);
                                    ruotaMilano[j]=random(0,90);
                                    ruotaNapoli[j]= random(0,90);
                                    ruotaPalermo[j]= random(0,90);
                                    ruotaRoma[j]= random(0,90);
                                    ruotaTorino[j]= random(0,90);
                                    ruotaVenezia[j]= random(0,90);
                                    scelta2=false;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }

                case 3:{
                   if (scelta2 && contatore3==1){
                       scelta3=true;
                   }

                    if (scelta3){
                        //scelta singolo,ambo ecc..
                        do {
                            sceltaPuntata=Menu(opzioniPuntata, keyboard);
                            contatore++;
                            switch (sceltaPuntata){
                                case 1: {//singolo
                                    if (contatore != 1 && !singoloBool && numeriEstratti>=1) {
                                        costoMinimo = costoMinimo + 1;
                                    }

                                    if (singoloBool){
                                        System.out.println("non puoi reinserire la stessa ruota di prima");
                                    }
                                    singoloBool=true;
                                    break;
                                }
                                case 2: {//ambo
                                    if (contatore != 1 && !amboBool && numeriEstratti>=2) {
                                        costoMinimo = costoMinimo + 1;
                                    }

                                    if (amboBool){
                                        System.out.println("non puoi reinserire la stessa ruota di prima");
                                    }
                                    amboBool=true;
                                    break;
                                }

                                case 3: {//terno
                                    if (contatore != 1 && !ternoBool && numeriEstratti>=3) {
                                        costoMinimo = costoMinimo + 1;
                                    }

                                    if (ternoBool){
                                        System.out.println("non puoi reinserire la stessa ruota di prima");
                                    }
                                    ternoBool=true;
                                    break;
                                }
                                case 4: {//quaterna
                                    if (contatore != 1 && !quaternaBool && numeriEstratti>=4) {
                                        costoMinimo = costoMinimo + 1;
                                    }

                                    if (quaternaBool){
                                        System.out.println("non puoi reinserire la stessa ruota di prima");
                                    }
                                    quaternaBool=true;
                                    break;
                                }
                                case 5: {//cinquina
                                    if (contatore != 1 && !cinquinaBool && numeriEstratti==5) {
                                        costoMinimo = costoMinimo + 1;
                                    }
                                    if (cinquinaBool){
                                        System.out.println("non puoi reinserire la stessa ruota di prima");
                                    }
                                    cinquinaBool=true;
                                    break;
                                }
                            }
                            if (contatore <= 1) {
                                System.out.println("vuoi puntare qualcos'altro (si/no)");
                                altraRuota = keyboard.next().toLowerCase();
                                while (!altraRuota.equals("no") && !altraRuota.equals("si")) ;
                            }
                        }while (altraRuota.equals("si") && contatore<=1);
                        scelta3=false;
                    }


                    keyboard.nextLine();
                    System.out.println("        ");
                    System.out.println("premi invio per continuare");
                    invio = keyboard.nextLine();
                    break;
                }

                case 4:{
                    if (scelta3){
                        scelta4=true;
                    }
                    if (scelta4){
                        ClrScr();
                        System.out.println("inserisci la giocata (" + costoMinimo + "/200)");
                        giocata = keyboard.nextInt();
                        while (giocata < 1 || giocata > 200) {
                            System.out.println("reinserisci la giocata (" + costoMinimo + "/200)");
                            giocata = keyboard.nextInt();
                        }
                        costoFinale=costoMinimo;
                        costoFinale = costoFinale + giocata;
                        scelta4=false;
                    }
                    keyboard.nextLine();
                    System.out.println("        ");
                    System.out.println("premi invio per continuare");
                    invio = keyboard.nextLine();
                    break;
                }

                case 5:{
                    for (int l=0;l<sceltaRuota;l++){

                    }
                    break;
                }

                case 6:{
                    break;
                }
            }
        }while (scelta!=6);
    }

    public static int fattoriale(int num) {
        for (int i = num; i > 1; i--)
            num = num * i;

        return num;
    }
    private static int random( int minValue,int maxValue){
        Random casuale=new Random();
        return casuale.nextInt(minValue,maxValue);
    }
    private static int Menu(String opzioni[], Scanner keyboard) {
        int scelta;

        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = keyboard.nextInt();

            // Controllo se la scelta è valida
            if (scelta < 1 || scelta > opzioni.length) {
                System.out.println("Opzione Sbagliata");
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

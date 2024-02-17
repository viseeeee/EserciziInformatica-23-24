import java.util.Scanner;
import java.util.Random;

public class menu {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int scelta;
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
        boolean[] puntata = new boolean[5];
        puntata[0] = true;
        puntata[1] = false;
        puntata[2] = true;
        puntata[3] = false;
        puntata[4] = true;
        int ruotaSingola;
        double costoFinale = 1;
        boolean ruotaSing=false;
        boolean ruoteMultiple=false;
        int num;
        int estrarre = 0;
        int[] numeriEstratti = new int[5];
        double giocata = 0;
        int scelta2, sceltaRuota = 0;
        double vincita;
        String inserimentoRuota = null;
        int contatore = 0;
        int[] estrazioneRuota = new int[50];
        String invio;
        int l;
        int numeriIndovinati=0;
        boolean singolo1=false,ambo=false,terno=false,quaterna=false,cinquina=false;


        String[] opzioni = {"=== Gioco Dadi === ",
                "[1] scelta della ruota singola o tutte e 10 le ruote",
                "[2] Quanti numeri 1-5 vuoi estrarre?",
                "[3] singolo, ambo, terna, quaterna, cinquina?",
                "[4] Giocata (minimo - 200€)",
                "[5] Estrazione",
                "[6] Probabilità di vincita",
                "[7] Visualizza giocate",
                "[8] Exit"
        };
        String[] opzioni1 = {"=== Puntata === ",
                "[1] Singolo",
                "[2] Ambo",
                "[3] Terna",
                "[4] Quaterna",
                "[5] Cinquina"};

        String[] opzioni2 = {"=== scelta della ruota === ",
                "[1] ruota singola",
                "[2] 10 ruote (tutte le ruote)"};

//array con scritto le ruota delle con i nomi delle varie città


        do {
            scelta = Menu(opzioni, keyboard);
            switch (scelta) {

                case 1: {//singolo o tutte
                    for (int j = 0; j < estrazioneRuota.length; j++) {
                        estrazioneRuota[j] = random(0, 90);
                    }
                    sceltaRuota = Menu(opzioni2, keyboard);
                    if (sceltaRuota == 1) {
                        System.out.println("inserisci il numero della ruota che vuoi. " +
                                "inserisci un valore da 1 a 10");
                        ruotaSingola = keyboard.nextInt();
                    }
                    if (sceltaRuota==2){
                        costoFinale = costoFinale + 9;
                        ruoteMultiple=true;
                    }
                    break;
                }


                case 2: {//scelta dei numeri dell'utente
                    System.out.println("quanti numeri vuoi estrarre?");
                    estrarre = keyboard.nextInt();
                    for (int i = 0; i < estrarre; i++) {
                        costoFinale = costoFinale + 0.50;
                        System.out.println("inserisci i numeri che puntare");
                        numeriEstratti[i] = keyboard.nextInt();
                    }
                    keyboard.nextLine();
                    System.out.println("premi invio per continuare");
                    invio = keyboard.nextLine();
                    break;
                }

                case 3: {//scelta singolo ambo ecc.
                    ClrScr();
                    do {
                        scelta2 = Menu(opzioni1, keyboard);
                        contatore++;
                        switch (scelta2) {
                            //1 euro per un numero
                            //se 2 1.50
                            //ogni numero +0.50
                            //ogni routa +1
                            case 1: {//singolo
                                if (contatore != 1 && !singolo1) {
                                    costoFinale = costoFinale + 1;
                                }

                                if (singolo1){
                                    System.out.println("non puoi reinserire la stessa ruota di prima");
                                }
                                singolo1=true;
                                break;
                            }
                            case 2: {//ambo
                                if (contatore != 1 && !ambo) {
                                    costoFinale = costoFinale + 1;
                                }

                                if (ambo){
                                    System.out.println("non puoi reinserire la stessa ruota di prima");
                                }
                                ambo=true;
                                break;
                            }

                            case 3: {//terno
                                if (contatore != 1) {
                                    costoFinale = costoFinale + 1;
                                }

                                if (terno){
                                    System.out.println("non puoi reinserire la stessa ruota di prima");
                                }
                                terno=true;
                                break;
                            }
                            case 4: {//quaterna
                                if (contatore != 1) {
                                    costoFinale = costoFinale + 1;
                                }

                                if (quaterna){
                                    System.out.println("non puoi reinserire la stessa ruota di prima");
                                }
                                quaterna=true;
                                break;
                            }
                            case 5: {//cinquina
                                if (contatore != 1) {
                                    costoFinale = costoFinale + 1;
                                }

                                if (cinquina){
                                    System.out.println("non puoi reinserire la stessa ruota di prima");
                                }
                                cinquina=true;

                            }
                        }
                        if (contatore <= 1) {
                            System.out.println("vuoi puntare qualcos'altro (si/no)");
                            inserimentoRuota = keyboard.next().toLowerCase();
                            while (!inserimentoRuota.equals("no") && !inserimentoRuota.equals("si")) ;
                        }
                    } while (inserimentoRuota.equals("si") && contatore<=1);
                    keyboard.nextLine();
                    System.out.println("premi invio per continuare");
                    invio = keyboard.nextLine();
                    break;
                }

                case 4: {//giocata e inserisci anche la Probabilità
                    System.out.println("inserisci la giocata (" + costoFinale + "/200)");
                    giocata = keyboard.nextInt();
                    while (giocata < 1 || giocata > 200) {
                        System.out.println("reinserisci la giocata (" + costoFinale + "/200)");
                        giocata = keyboard.nextInt();
                    }
                    costoFinale = costoFinale + giocata;
                    keyboard.nextLine();
                    System.out.println("premi invio per continuare");
                    invio = keyboard.nextLine();
                    break;
                }
                case 7: {//Visualizza giocate
                    for (int k = 0; k < numeriEstratti.length; k++) {
                        for (l = k; l < estrazioneRuota.length; l++) {
                            if (numeriEstratti[k] == estrazioneRuota[l]) {
                                numeriIndovinati++;
                                if (ruoteMultiple) {
                                    if (l <= 4) {
                                        System.out.println("nella prima ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 4 && l <= 9) {
                                        System.out.println("nella seconda ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 9 && l <= 14) {
                                        System.out.println("nella terza ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 14 && l <= 19) {
                                        System.out.println("nella quarta ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 19 && l <= 24) {
                                        System.out.println("nella quinta ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l < 24 && l <= 29) {
                                        System.out.println("nella sesta ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 29 && l <= 34) {
                                        System.out.println("nella settima ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 34 && l <= 39) {
                                        System.out.println("nella ottava ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 39 && l <= 44) {
                                        System.out.println("nella nona ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                    if (l > 44 && l <= 49) {
                                        System.out.println("nella decima ruota hai indovinato:" + numeriEstratti[k]);
                                    }
                                }
                                if (ruotaSing) {
                                    System.out.println("nella ruota"+ruotaSingola+"hai indovinato:" + numeriEstratti[k]);
                                }
                                if(numeriIndovinati==1 && singolo1){
                                    costoFinale=costoFinale*singolo;
                                }

                                if(numeriIndovinati==2 && singolo1){
                                    costoFinale=costoFinale*singolo2;
                                }

                                if(numeriIndovinati==3 && singolo1){
                                    costoFinale=costoFinale*singolo3;
                                }

                                if(numeriIndovinati==4 && singolo1){
                                    costoFinale=costoFinale*singolo4;
                                }

                                if(numeriIndovinati==5 && singolo1){
                                    costoFinale=costoFinale*singolo5;
                                }
                                if(numeriIndovinati==2 && ambo){
                                    costoFinale=costoFinale*ambo2;
                                }

                                if(numeriIndovinati==3 && ambo){
                                    costoFinale=costoFinale*ambo3;
                                }

                                if(numeriIndovinati==4 && ambo){
                                    costoFinale=costoFinale*ambo4;
                                }

                                if(numeriIndovinati==5 && ambo){
                                    costoFinale=costoFinale*ambo5;
                                }

                                if(numeriIndovinati==3 && terno){
                                    costoFinale=costoFinale*terna3;
                                }

                                if(numeriIndovinati==4 && terno){
                                    costoFinale=costoFinale*terna4;
                                }

                                if(numeriIndovinati==5 && terno){
                                    costoFinale=costoFinale*terna5;
                                }

                                if(numeriIndovinati==4 && quaterna){
                                    costoFinale=costoFinale*quaterna4;
                                }

                                if(numeriIndovinati==5 && quaterna){
                                    costoFinale=costoFinale*quaterna5;
                                }

                                if(numeriIndovinati==5 && cinquina){
                                    costoFinale=costoFinale*ci;
                                }
                            }
                        }
                        l = 0;
                        //
                        if (numeriIndovinati == 0) {
                            System.out.println("non hai azzeccato nemmeno un numero");
                        }
                        if (numeriIndovinati == 1) {
                            System.out.println("hai fatto singolo(1)");
                        }
                        if (numeriIndovinati == 2) {
                            System.out.println("hai fatto ambo(2)");
                        }
                        if (numeriIndovinati == 3) {
                            System.out.println("hai fatto terno(3)");
                        }
                        if (numeriIndovinati == 4) {
                            System.out.println("hai fatto quaterna(4)");
                        }
                        if(numeriIndovinati>1){
                            System.out.println("hai vinto"+costoFinale+"euro");
                        }
                        keyboard.nextLine();
                        System.out.println("inserisci invio per mostrare il menù");
                        invio = keyboard.nextLine();
                        break;
                    }
                }
                case 8: {//exit
                    break;
                }
            }
        }while (scelta != 8) ;
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

    public static double[] probabilita(boolean[] puntata)
    {
        double[] prob = new double[5];
        double value=1;
        double tot=90;
        for(int i=0;i< puntata.length;i++)
        {
            if(puntata[i]==true)
            {
                for(double k=1;k<=i+1; k++)
                {
                    value = value*(k/tot);
                    tot--;
                }

                prob[i]=value;
                tot=90;
                value=1;
            }
        }

        return prob;
    }

    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
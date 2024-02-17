/* Authors: Mattia Albieri
 *           Filippo Barchi
 *           Daniele Chiarion
 *           Visentin Luca */

/* realizzare un programma che simuli il gioco del lotto */

import java.util.Scanner;
import java.util.Random;

public class versioneDaniel {
    public static void main(String[] args) {
        /* creazione scanner e generatore casuale */
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();
        /* dichiarazione variabili */
        int limite;
        int uguali=0;
        int ugualiBari=0, ugualiCagliari=0, ugualiGenova=0, ugualiFirenze=0, ugualiMilano=0, ugualiNapoli=0, ugualiPalermo=0, ugualiRoma=0, ugualiTorino=0, ugualiVenezia=0;
        int scelta1, scelta2, scelta3;
        int cont;
        double vincita = 0, prezzoMin, puntata;
        char input;
        /* dichiarazione vettori */
        boolean[] combo = new boolean[5];
        //menu ruota
        String[] opzioni1={"Scegli quale modalita'", "[1] ruota singola", "[2] tutte le ruote"};
        //menu ruote singole
        String[] opzioni2={"Scegli la tua ruota", "[1] Bari", "[2] Cagliari", "[3] Genova", "[4] Firenze", "[5] Milano", "[6] Napoli", "[7] Palermo", "[8] Roma", "[9] Torino", "[10] Venezia"};

        /* dichiarazione vettori ruote */
        int[] giocatore = new int[5];
        int[] ruota = new int[5];
        int[] ruotaBari = new int[5];
        int[] ruotaCagliari = new int[5];
        int[] ruotaGenova = new int[5];
        int[] ruotaFirenze = new int[5];
        int[] ruotaMilano = new int[5];
        int[] ruotaNapoli = new int[5];
        int[] ruotaPalermo = new int[5];
        int[] ruotaRoma = new int[5];
        int[] ruotaTorino = new int[5];
        int[] ruotaVenezia = new int[5];
        /* Menu di scelta */
        do {
            System.out.println("Quanti numeri vuoi giocare? ");
            limite=keyboard.nextInt();
        }while(limite<1 || limite>5);
        System.out.println("\nScegli per cosa vuoi giocare. (X per confermare, N per annullare)");
        for(int i=1;i<=limite;i++)
        {
            do{
                System.out.print("\n"+printCombo(i)+": ");
                input=keyboard.next().charAt(0);
                if(input=='X')
                    combo[i]=true;
            }while(input!='X' && input!='N');
        }

        ClrScr();
        scelta1=menu(opzioni1, keyboard);
        switch(scelta1)
        {
            case 1:
                cont=1;
                break;
            case 2:
                cont=2;
                break;
            default:
                cont=0;
        }

        /* possibilità di rilancio dell'offerta */
        prezzoMin=prezzoMinimo(combo, limite, cont);
        System.out.printf("\n\nIl prezzo minimo da pagare e' di %.2f€", prezzoMin);
        do {
            System.out.println("Digita C per confermare, R per rilanciare (fino a 200€)");
            input = keyboard.next().charAt(0);
        }while(input!='C' && input!='R');
        puntata=prezzoMin;
        if(input=='R')
        {
            System.out.println("Inserisci prezzo di rilancio");
            puntata=keyboard.nextDouble();
        }while(puntata<prezzoMin || puntata>200);
        giocatore = valCasuale(ruota, casuale);
        if(scelta1==1)
        {
            ruota = valCasuale(ruota, casuale);
            uguali = controlloUguali(ruota, giocatore);
        }
        else
        {
            ruotaBari = valCasuale(ruotaBari, casuale);
            ugualiBari = controlloUguali(ruotaBari, giocatore);
            ruotaCagliari = valCasuale(ruotaCagliari, casuale);
            ugualiCagliari = controlloUguali(ruotaCagliari, giocatore);
            ruotaGenova = valCasuale(ruotaGenova, casuale);
            ugualiGenova = controlloUguali(ruotaGenova, giocatore);
            ruotaFirenze = valCasuale(ruotaFirenze, casuale);
            ugualiFirenze = controlloUguali(ruotaFirenze, giocatore);
            ruotaMilano = valCasuale(ruotaMilano, casuale);
            ugualiMilano = controlloUguali(ruotaMilano, giocatore);
            ruotaNapoli = valCasuale(ruotaNapoli, casuale);
            ugualiNapoli = controlloUguali(ruotaNapoli, giocatore);
            ruotaPalermo = valCasuale(ruotaPalermo, casuale);
            ugualiPalermo = controlloUguali(ruotaPalermo, giocatore);
            ruotaRoma = valCasuale(ruotaRoma, casuale);
            ugualiRoma = controlloUguali(ruotaRoma, giocatore);
            ruotaTorino = valCasuale(ruotaTorino, casuale);
            ugualiTorino = controlloUguali(ruotaTorino, giocatore);
            ruotaVenezia = valCasuale(ruotaVenezia, casuale);
            ugualiVenezia = controlloUguali(ruotaVenezia, giocatore);
        }

        /* controllo vincita ruota singola */
        for(int i=0;i<ruota.length;i++)
        {
            for(int k=0;k<giocatore.length; k++) {
                if(giocatore[k]==ruota[i])
                    uguali++;
            }
        }

    }

    private static int controlloUguali(int[] vet, int[] player)
    {
        int uguali=0;

        for(int i=0;i<vet.length;i++)
        {
            for(int k=0;k<player.length; k++) {
                if(player[k]==vet[i])
                    uguali++;
            }
        }

        return uguali;
    }

    private static double moltiplicatore(int scelta, int limite)
    {
        final double singolo1=11.23;
        final double singolo2=5.61;
        final double singolo3=3.74;
        final double singolo4=2.80;
        final double singolo5=2.24;
        final double ambo2=250;
        final double ambo3=83.33;
        final double ambo4=41.66;
        final double ambo5=25;
        final double terna3=4500;
        final double terna4=1125;
        final double terna5=450;
        final double quaterna4=120000;
        final double quaterna5=24000;
        final double cinquina5=6000000;
        /* dichiarazione variabile */
        double num=0;

        /* menu di scelta */
        switch(scelta)
        {
            case 1:
                if(limite==1)
                    num=singolo1;
                else if(limite==2)
                    num=singolo2;
                else if(limite==3)
                    num=singolo3;
                else if(limite==4)
                    num=singolo4;
                else
                    num=singolo5;
                break;
            case 2:
                if(limite==2)
                    num=ambo2;
                else if(limite==3)
                    num=ambo3;
                else if(limite==4)
                    num=ambo4;
                else
                    num=ambo5;
                break;
            case 3:
                if(limite==3)
                    num=terna3;
                else if(limite==4)
                    num=terna4;
                else
                    num=terna5;
                break;
            case 4:
                if(limite==4)
                    num=quaterna4;
                else
                    num=quaterna5;
                break;
            case 5:
                num=cinquina5;
                break;
        }
        return num;
    }

    private static double prezzoMinimo(boolean[] combo, int limite, int cont)
    {
        double costo=1+0.5*(limite-1);
        for(int i=0;i<combo.length;i++)
        {
            if(combo[i]==true)
                costo++;
        }

        costo = costo*cont;

        return costo;
    }

    private static int[] valCasuale(int[] vet, Random casuale)
    {
        int check;
        for(int i=0; i<vet.length; i++)
        {
            do {
                check = 0; //azzeramento variabile
                vet[i] = casuale.nextInt(0, 90) + 1;
                for (int k = i - 1; k >= 0; k--) {
                    if (vet[i] == vet[k])
                        check++;
                }
            }while(check!=0);
        }

        return vet;
    }

    private static int menu(String[] opzioni, Scanner keyboard)
    {
        int scelta;

        do {
            ClrScr();
            System.out.println("=== "+opzioni[0]+" ===");
            for(int i=1;i<opzioni.length;i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = keyboard.nextInt();
            if(scelta<1 || scelta>opzioni.length-1)
            {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        }while(scelta<1 || scelta>opzioni.length-1);

        return scelta;
    }

    private static String printCombo(int x)
    {
        String name;
        switch(x)
        {
            case 1:
                name="Singolo";
                break;
            case 2:
                name="Ambo";
                break;
            case 3:
                name="Terna";
                break;
            case 4:
                name="Quaterna";
                break;
            default:
                name="Cinquina";
        }
        return name;
    }
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* metodo per il tempo di attesa
    come parametro si inserisce il numero di secondi */
    private static void Wait(int val)
    {
        try{
            Thread.sleep(1000*val);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

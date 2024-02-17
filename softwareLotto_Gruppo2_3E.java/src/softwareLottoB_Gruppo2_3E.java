/* Authors: Mattia Albieri
 *           Filippo Barchi
 *           Daniele Chiarion
 *           Visentin Luca */

/* make a program that allow to play the lottery game
with one or ten different lottery wheels.
The software will show in output the amount of money won
and the possibility of win */

/* including the necessary libraries */
import java.util.*;

public class softwareLottoB_Gruppo2_3E {
    public static void main(String[] args) {
        /* creating Scanner and Random objects */
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();
        /* variable declaration */
        int limite;
        int check=0;
        int scelta1 = 0, scelta2 = 0, scelta3 = 0, scelta4 = 0, scelta5=0, scelta6=0;
        int cont = 0;
        int tentativi=5;
        int inputPin;
        double vincita = 0;
        char ripetere = 'N', input;
        /* array declaration */
        double[] giocata = new double[5];

        /* menu for wheels */
        String[] opzioni1 = {"Scegli quale modalita'", "[1] ruota singola", "[2] tutte le ruote"};
        String[] opzioni2 = {"Scegli la tua ruota", "[1] Bari", "[2] Cagliari", "[3] Genova", "[4] Firenze", "[5] Milano", "[6] Napoli", "[7] Palermo", "[8] Roma", "[9] Torino", "[10] Venezia"};
        String[] opzioni3 = {"Opzioni di visualizzazione", "[1] Visualizza i risultati di ogni ruota", "[2] Visualizza le probabilita' di uscita"};
        String[] opzioni4 = {"Giocata terminata", "[1] Terminare sessione corrente", "[2] Spegnere il macchinario"};
        String[] opzioni5 = {"GIOCATA UTENTE", "[1] Scegli i tuoi numeri", "[2] Estraili casualmente"};
        String[] opzioni6={"Risultati da vedere", "[1] Risultati della ruota scelta e probabilita'", "[2] Risultati delle altre ruote"};

        /* declaration player and wheel arrays */
        int[] giocatore = new int[5];
        int[] ugualiCitta = new int[10];
        int[][] ruoteCitta = new int[10][5];
        /* constant declaration */
        final double prezzoMin = 0.5;
        final double prezzoMax = 200;
        final int password = 1234;

        do {
            ClrScr();
            System.out.println("*-*-*- Maxilotteria 3E -*-*-*\n");
            /* Choice menu */
            do {
                System.out.println("Quanti numeri vuoi giocare? ");
                limite = keyboard.nextInt();
            } while (limite < 1 || limite > 5); //input check

            /* opzioni of choice of numbers */
            scelta5=menu(opzioni5, keyboard);
            switch(scelta5)
            {
                case 1:
                    /* numbers given by the user */
                    for(int i=0;i<limite;i++)
                    {
                        do {
                            System.out.println("Inserisci il "+(i+1)+"^ numero");
                            giocatore[i]=keyboard.nextInt();
                            /* checking possible repetiotions */
                            check=0;
                            for(int k=i-1;k>=0;k--)
                            {
                                if(giocatore[k]==giocatore[i])
                                    check++;
                            }
                        }while(giocatore[i]<1 || giocatore[i]>90 || check!=0);
                    }
                    break;
                default:
                    /* numbers chosen at random */
                    for(int i=0;i<limite;i++)
                    {
                        giocatore[i]=casuale.nextInt(0,90)+1;
                    }
                    System.out.println("Numeri estratti");
                    Wait(3);
            }

            ClrScr();
            /* choose in which combos you want to bet */
            System.out.println("\nScegli per cosa vuoi giocare.\n(Inserisci una somma di denaro per confermare, 0 per annullare)");
            System.out.printf("Puoi inserire un importo tra %.2f e %.2f euro", prezzoMin, prezzoMax);
            for (int i = 0; i <= limite - 1; i++) {
                do {
                    System.out.print("\n" + printCombo(i + 1) + ": ");
                    giocata[i] = keyboard.nextDouble();
                } while (giocata[i] < 0 || (giocata[i] > 0 && giocata[i] < prezzoMin) || giocata[i] > prezzoMax);
            }
            ClrScr();

            /* type of wheel choice */
            scelta1 = menu(opzioni1, keyboard);
            switch (scelta1) {
                case 1:
                    cont = 1;
                    scelta2 = menu(opzioni2, keyboard);
                    break;
                case 2:
                    cont = 10;
                    break;
            }

            /* cycle to generate random numbers,
             * check equals
             * and calculating winning*/
            for (int i = 0; i < ruoteCitta.length; i++) {
                ruoteCitta[i] = valCasuale(ruoteCitta[i], casuale); //generating random numbers
                ugualiCitta[i] = controlloUguali(ruoteCitta[i], giocatore); //checking equal numbers
                vincita += calcVincita(ugualiCitta[i], limite, giocata) / cont; //calculating winning
            }

            /* choice of 1 wheel */
            if (scelta1 == 1) {
                /* output of the results */
                ClrScr();
                do {
                    scelta6 = menu(opzioni3, keyboard);
                    switch (scelta6) {
                        /* output of results with the other wheels */
                        case 1:
                            System.out.println("CONFRONTI CON LE ALTRE RUOTE");
                            System.out.printf("Avresti potuto vincere %.2f euro\n\n", vincita);
                            System.out.println("*** I tuoi numeri ***");
                            printNumeri(giocatore);
                            System.out.println("\n___ I numeri delle altre ruote ___");
                            for(int i=0;i<ruoteCitta.length;i++)
                            {
                                if(i!=(scelta2-1))
                                {
                                    System.out.println("\n\n" + opzioni2[i + 1]);
                                    System.out.println(printCombo(ugualiCitta[i]));
                                    System.out.println("--- Numeri estratti ---");
                                    printNumeri(ruoteCitta[i]);
                                }
                            }
                            System.out.println("\n\nDigita S per continuare a navigare nel menu, qualsiasi altro tasto per uscire");
                            ripetere = keyboard.next().charAt(0);
                            ClrScr();
                            break;
                        /* compare between numbers */
                        case 2:
                            ClrScr();
                            System.out.println("*** Risultati ***");
                            System.out.println("Hai fatto >> " + printCombo(ugualiCitta[scelta2-1]));
                            System.out.printf("Hai ottenuto %.2f euro", calcVincita(ugualiCitta[scelta2-1], limite, giocata));
                            System.out.println("\n\n");
                            /* output of the random and player numbers */
                            System.out.println("--- Numeri estratti sulla ruota " + opzioni2[scelta2] + " ---");
                            printNumeri(ruoteCitta[scelta2-1]);
                            System.out.println("\n--- Numeri giocati ---");
                            printNumeri(giocatore);
                            /* probabilities */
                            System.out.println("\n\n\n___ Probabilita' ___");
                            printProbabilita(giocata, limite);
                            /* request of repeating the menu */
                            System.out.println("\n\nDigita S per continuare a navigare nel menu, qualsiasi altro tasto per uscire");
                            ripetere = keyboard.next().charAt(0);
                            ClrScr();
                            break;
                    }
                } while (ripetere == 'S');
            }
            else {
                /* output of the results */
                ClrScr();
                System.out.printf("Hai vinto %.2f euro", vincita);
                System.out.println("\nPuoi anche visualizzare:");
                /* menu for selecting what you want to see */
                do {
                    scelta3 = menu(opzioni3, keyboard);
                    switch (scelta3) {
                        /* compare between numbers */
                        case 1:{
                            ClrScr();
                            System.out.println("VISUALIZZAZIONE RISULTATI");
                            System.out.println("*** Numeri giocatore ***");
                            printNumeri(giocatore);
                            System.out.println("\n\n");
                            for (int k = 0; k < ruoteCitta.length; k++) {
                                System.out.println("\n\n" + opzioni2[k + 1]);
                                System.out.println(printCombo(ugualiCitta[k]));
                                System.out.println("--- Numeri estratti ---");
                                printNumeri(ruoteCitta[k]);
                            }
                            /* possibility to return to the beginning of this menu or go forward */
                            System.out.println("\n\nDigita S per continuare a navigare nel menu, qualsiasi altro tasto per uscire");
                            ripetere = keyboard.next().charAt(0);
                            ClrScr();
                            break;}
                        /* output of probabilities */
                        case 2:{
                            ClrScr();
                            System.out.println("PROBABILITA' DI USCITA");
                            printProbabilita(giocata, limite);
                            System.out.println("\n\nDigita S per continuare a navigare nel menu, qualsiasi altro tasto per uscire");
                            ripetere = keyboard.next().charAt(0);
                            ClrScr();
                            break;}
                    }
                } while (ripetere == 'S');
            }
            ClrScr();
            /* ending menu
            you can choose either to repeat the program or
            to stop it using a security PIN */
            scelta4 = menu(opzioni4, keyboard);
            switch (scelta4) {
                /* repeating the programme */
                case 1:
                    System.out.println("Sessione terminata. Riavvio programma");
                    Wait(4);
                    break;
                /* possibility of ending the programme */
                case 2:
                    do {
                        System.out.println("Inserisci PIN di spegnimento: ");
                        inputPin = keyboard.nextInt();
                        if (inputPin != password) {
                            System.out.println("Arresto negato");
                            System.out.println(tentativi + " tentativi rimasti\n");
                            tentativi--;
                        }
                    }while(tentativi>=0 && inputPin!=password);
                    if(inputPin!=password)
                    {
                        System.out.println("Tentativo di arresto fallito");
                        scelta4=1;
                    }
                    else
                        System.out.println("Spegnimento macchinario");
                    Wait(3);
                    break;
            }

            /* reset of variables for a new play */
            vincita = 0;
            tentativi=5;
            for(int i=0;i<giocata.length;i++)
            {
                giocata[i]=0;
                giocatore[i]=0;
            }

            ClrScr();
        } while (scelta4 == 1); //condition for repeating the whole programme
    }

    /* method to check equal numbers */
    private static int controlloUguali(int[] vet, int[] player) {
        int uguali = 0;

        for (int i = 0; i < vet.length; i++) {
            for (int k = 0; k < player.length; k++) {
                if (player[k] == vet[i])
                    uguali++;
            }
        }

        return uguali;
    }

    /* method to calculate the money won */
    private static double calcVincita(int combo, int limite, double[] giocata) {
        double vincita = 0;
        double molt;

        molt = moltiplicatore(combo, limite);
        for (int i = 0; i < combo; i++) {
            vincita += giocata[i] * molt * possibilita(combo, i + 1) / possibilita(limite, i + 1);
        }

        return vincita;
    }

    /* method to calculate possible combinations */
    private static int possibilita(int numTot, int num) {
        int pos = 1;
        if (num < numTot)
            pos = fattoriale(numTot) / (fattoriale(num) * fattoriale(numTot - num));

        return pos;
    }

    /* method to calculate factorial */
    public static int fattoriale(int num) {
        for (int i = num; i > 1; i--)
            num = num * i;

        return num;
    }

    /* method to find the multiplier to use in the method calcVincita */
    private static double moltiplicatore(int scelta, int limite) {
        final double singolo1 = 11.23;
        final double singolo2 = 5.61;
        final double singolo3 = 3.74;
        final double singolo4 = 2.80;
        final double singolo5 = 2.24;
        final double ambo2 = 250;
        final double ambo3 = 83.33;
        final double ambo4 = 41.66;
        final double ambo5 = 25;
        final double terna3 = 4500;
        final double terna4 = 1125;
        final double terna5 = 450;
        final double quaterna4 = 120000;
        final double quaterna5 = 24000;
        final double cinquina5 = 6000000;
        /* dichiarazione variabile */
        double num = 0;

        /* menu di scelta */
        switch (scelta) {
            case 1:
                if (limite == 1)
                    num = singolo1;
                else if (limite == 2)
                    num = singolo2;
                else if (limite == 3)
                    num = singolo3;
                else if (limite == 4)
                    num = singolo4;
                else
                    num = singolo5;
                break;
            case 2:
                if (limite == 2)
                    num = ambo2;
                else if (limite == 3)
                    num = ambo3;
                else if (limite == 4)
                    num = ambo4;
                else
                    num = ambo5;
                break;
            case 3:
                if (limite == 3)
                    num = terna3;
                else if (limite == 4)
                    num = terna4;
                else
                    num = terna5;
                break;
            case 4:
                if (limite == 4)
                    num = quaterna4;
                else
                    num = quaterna5;
                break;
            case 5:
                num = cinquina5;
                break;
            default:
                num = 0;
        }
        return num;
    }

    /* method for generating random numbers */
    private static int[] valCasuale(int[] vet, Random casuale) {
        int check;
        for (int i = 0; i < vet.length; i++) {
            do {
                check = 0; //azzeramento variabile
                vet[i] = casuale.nextInt(0, 90) + 1;
                for (int k = i - 1; k >= 0; k--) {
                    if (vet[i] == vet[k])
                        check++;
                }
            } while (check != 0);
        }

        return vet;
    }

    /* method to calculate probabilities */
    private static double probabilita(int uguali, int limite) {
        double prob;
        switch (uguali) {
            case 1:
                prob = (double)limite/90;
                break;
            case 2:
                if (limite == 2)
                    prob = (double)1 / 407;
                else if (limite == 3)
                    prob = (double)1 / 137;
                else if (limite == 4)
                    prob = (double)1 / 70;
                else
                    prob = (double)1 / 43;
                break;
            case 3:
                if (limite == 3)
                    prob = (double)1 / 11748;
                else if (limite == 4)
                    prob = (double)1 / 2989;
                else
                    prob = (double)1 / 1217;
                break;
            case 4:
                if (limite == 4)
                    prob = (double)1 / 511038;
                else
                    prob = (double)1 / 103167;
                break;
            case 5:
                prob = (double)1 / 43949268;
                break;
            default:
                prob = 0;
        }

        return prob*100;
    }

    /* method for the output of probabilities */
    private static void printProbabilita(double[] giocata, int limite) {
        for (int i = 0; i < giocata.length; i++) {
            if (giocata[i] > 0) {
                System.out.printf("%s su %d numeri = %.6f%%\n", printCombo(i + 1), limite, probabilita(i + 1, limite));
            }
        }
    }

    /* method to print a general choice menu */
    private static int menu(String[] opzioni, Scanner keyboard) {
        int scelta;

        do {
            System.out.println("=== " + opzioni[0] + " ===");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = keyboard.nextInt();
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Valore errato. Riprova");
                Wait(3);
            }
        } while (scelta < 1 || scelta > opzioni.length - 1);

        return scelta;
    }

    /* method to print the result (ambo, terna, ecc.)
    using an input number */
    private static String printCombo(int x) {
        String name;
        switch (x) {
            case 1:
                name = "Singolo";
                break;
            case 2:
                name = "Ambo";
                break;
            case 3:
                name = "Terna";
                break;
            case 4:
                name = "Quaterna";
                break;
            case 5:
                name = "Cinquina";
                break;
            default:
                name = "///";
        }
        return name;
    }

    /* method to print
    wheels and player numbers */
    private static void printNumeri(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            if(vet[i]!=0)
                System.out.print(vet[i] + "\t");
        }
    }

    /* method to clear screen */
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* method for waiting time */
    private static void Wait(int val) {
        try {
            Thread.sleep(1000 * val);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
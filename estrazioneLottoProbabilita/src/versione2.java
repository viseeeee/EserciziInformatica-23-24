import java.util.Random;
import java.util.Scanner;
public class versione2 {
    public static void main(String[] args) {
        /* dichiarazione vettori */
        int[] scelta = new int[3];
        int[] numeri = new int[5];
        boolean[] puntata = new boolean[5];
        String[] opzioni1={"Ruota da giocare", "1 ruota", "tutte le 10 ruote"};
        /* dichiarazione variabili */
        int limite, nRuote;
        char input;
        double vincita;

        /* creazione oggetti Scanner e Random */
        Scanner keyboard = new Scanner(System.in);
        Random casuale = new Random();

        /* richiesta inserimento dati input */
        do {
            System.out.println("Quanti numeri vuoi giocare? (da 1 a 5)");
            limite=keyboard.nextInt();
        }while(limite<1 || limite>5);
        for(int i=0;i<limite;i++)
        {
            do {
                System.out.println("Inserisci un numero da 1 a 90");
                numeri[i]=keyboard.nextInt();
            }while(numeri[1]<1 || numeri[1]>90);
        }
        System.out.println("\nMetti una X per selezionare, N per non selezionare");
        for(int i=1;i<=limite;i++)
        {
            do {
                System.out.print("\n"+turnType(i));
                input = keyboard.next().charAt(0);
            }while(input!='X' && input!='N');

            if(input=='X')
                puntata[i-1]=true;
        }

        /* selezione ruote */
        ClrScr();
        scelta[0]=menu(opzioni1, keyboard);
        if(scelta[0]==1)
            nRuote=1;
        else
            nRuote=10;

    }

    private static int calc(int y)
    {
        int pos=fattoriale(90)/(fattoriale(y)*fattoriale(90-y));
        return pos;
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
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void Wait(int x)
    {
        try{
            Thread.sleep(1000*x);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private static String turnType(int x)
    {
        String stringa="";
        switch(x)
        {
            case 1:
                stringa="Singolo";
                break;
            case 2:
                stringa="Ambo";
                break;
            case 3:
                stringa="Terna";
                break;
            case 4:
                stringa="Quaterna";
                break;
            case 5:
                stringa="Cinquina";
                break;
        }

        return stringa;
    }

    private static int fattoriale(int num)
    {
        for(int i=num;i>=1;i++)
        {
            num=num*i;
        }

        return num;
    }
}

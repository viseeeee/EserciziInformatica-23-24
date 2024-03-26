import java.util.Scanner;
import java.util.Random;

public class Fiammiferi {
    public static void main(String[] args) {
        int round=0;
        int inserimento = 0;
        String[] nomeGiocatore=new String[2];
        boolean ripetizione;
        Scanner keyboard=new Scanner(System.in);
        int fiammiferi=21;
        //menu
        String[] opzioni = {"=== Gioco Fiammiferi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Exit "};

        //richiamo del menu dentro il try catch
        do {
            ripetizione=true;
        try{
            inserimento=Menu(opzioni,keyboard);
            ripetizione=false;
        }catch (Exception x){
            System.out.println("Errore, dato inserito non valido");
        }
        keyboard.nextLine();
        }while (ripetizione);
        if (inserimento!=3){

            //invoco il metodo per l'inserimento del nome
            nomeGiocatore=InserimentoNome(inserimento,keyboard);

            //condizione che invoca il metodo del gioco
            do {
                round++;
                fiammiferi=Gioco(nomeGiocatore,fiammiferi,keyboard,round,inserimento);
            }while (fiammiferi!=0);

            //se round è dispari significa che ha giocato giocatore 2
            if (round%2!=0){
                System.out.println("Ha vinto "+nomeGiocatore[0]);
            }else {
                System.out.println("Ha vinto "+nomeGiocatore[1]);
            }
        }


    }


    //metodo che controlla i fiammiferi tolti
    private static int ControlloFiammiferiTolti(int fiammiferiTolti, Scanner keyboard, int fiammiferi, int round, int inserimento) {
        boolean ripetizione;
        boolean controllo = false;
        int maxValue = 3, minValue = 1;

        do {
            ripetizione = true;
            try {
                // Inserimento dei fiammiferi
                switch (inserimento) {
                    case 1:
                        fiammiferiTolti = keyboard.nextInt();
                        break;
                    case 2:
                        if (round % 2 != 0) {
                            fiammiferiTolti = keyboard.nextInt();
                        } else {
                            if (fiammiferi > 4) {
                                Random random = new Random();
                                fiammiferiTolti = random.nextInt(maxValue - minValue + 1) + minValue;
                            } else {
                                // Entra nel ciclo quando i fiammiferi sono minori di 4
                                fiammiferiTolti = fiammiferi;
                                return fiammiferiTolti;
                            }
                        }
                        break;
                }
                ripetizione = false;
            } catch (Exception x) {
                System.out.println("Errore, dato inserito non valido");
            }


        } while (ripetizione);

        // Controllo se il numero inserito è corretto
        while (fiammiferiTolti > 3 || fiammiferiTolti <= 0 || fiammiferi == 2 && fiammiferiTolti > 2 || fiammiferi == 1 && fiammiferiTolti > 1) {
            System.out.println("Dato inserito non valido");
            try {
                fiammiferiTolti = keyboard.nextInt();
            } catch (Exception x) {
                System.out.println("Errore, dato inserito non valido");
            }
        }
        return fiammiferiTolti;
    }


    //metodo che dice i turni e i fiammiferi da togliere
private static int Gioco(String[] nomeGiocatore,int fiammiferi,Scanner keyboard,int round,int inserimento){
        int fiammiferiTolti=0;
        ClrScr();
    if (round%2==0){
        System.out.println("E' il turno di "+nomeGiocatore[1]);
    }else {
        System.out.println("E' il turno di "+nomeGiocatore[0]);
    }

    //mostra i fiammiferi che ci sono
    Fiammiferi(fiammiferi);
    System.out.println("Quanti fiammiferi vuoi togliere?MAX 3");

    //inserimento dei fiammiferi
    fiammiferiTolti=ControlloFiammiferiTolti(fiammiferiTolti,keyboard,fiammiferi,round,inserimento);

    if (round%2==0 && inserimento==2){
        System.out.println(fiammiferiTolti);
        Wait(1000);
    }

    //switch case che fa la sottrazione
        switch (fiammiferiTolti){
            case 1->fiammiferi--;
            case 2->fiammiferi=fiammiferi-2;
            case 3->fiammiferi=fiammiferi-3;
            case 4->fiammiferi=fiammiferi-4;
        }




    return fiammiferi;
}


//metodo che stampa i fiammiferi
    private static void Fiammiferi(int fiammiferi) {

        //for che servono per stampare i fiammiferi
        for(int volte=0;volte<fiammiferi;volte++ ){
            System.out.print("*");
        }
        for(int volte=0;volte<fiammiferi;volte++ ){

            //serve per andare a capo la prima volte che si inserisce il fiammifero
            if (volte==0){
                System.out.println(" ");
                System.out.print("|");
            }else {
                System.out.print("|");
            }
        }
        System.out.println(" ");
    }


   //metodo che serve per inserire il nome
    private static String[] InserimentoNome(int inserimento,Scanner keyboard){
        String[] nomeGiocatore=new String[2];
        switch (inserimento){
            case 1 -> {
                //inserimento dei giocatori
                System.out.println("inserisci il nome del primo giocatore");
                nomeGiocatore[0]=keyboard.next().toLowerCase();
                System.out.println("inserisci il nome del secondo giocatore");
                nomeGiocatore[1]=keyboard.next().toLowerCase();
                ClrScr();
            }
            case 2->{
                //inserimento di un giocatore e del computer
                System.out.println("inserisci il nome del giocatore");
                nomeGiocatore[0]=keyboard.next().toLowerCase();
                nomeGiocatore[1]="Computer";
                ClrScr();
            }
            case 3->{
            }
        }
        return nomeGiocatore;
    }

//metodo del menu
    private static int Menu(String opzioni[], Scanner keyboard) {
        int valoreMenu;
        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            //inserimento del valore
            valoreMenu = keyboard.nextInt();
            //se il valore è diverso da quelli del menu fà reinserire il valore
            if ((valoreMenu < 1) || (valoreMenu > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
            }
        }
        while ((valoreMenu < 1) || (valoreMenu > opzioni.length - 1));

        return valoreMenu;
    }

    //metodo del random
    private static int valoreRandom(int minValue, int maxValue)//metodo che serve per creare il valore random
    {
        Random casuale = new Random();//crea il valore random
        return  casuale.nextInt(minValue,maxValue)+1; // si fà il return fi casuale(il valore random) che è compreso tra minValue e MaxValue
    }

    //Metodo che serve per pulire lo schermo
    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //metodo del wait
    private static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
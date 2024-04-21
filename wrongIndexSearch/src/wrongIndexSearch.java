import tools.utility.*;
import java.util.Scanner;
import java.util.Random;


public class wrongIndexSearch {
    public static void main(String[] args) {

        //menu iniziale
        String[] menu={" MENU ",
                "[1] inserimento",
                        "[2] Visualizzazione",
                        "[3] Ricerca Rislutato",
                        "[4] esci"};
        int volte=0;
        boolean ripetizione=true;
        Scanner keyboard=new Scanner(System.in);
        Numero[] inserimento=new Numero[100];
        int ripetizioneRicerca=0,rip=0;
        int[] random=new int[100];
        int numeroPrec=0;
        do {
            inserimento[volte] = new Numero();

            //visualizzazione del menu
            switch (tools.utility.menu(menu,keyboard)){
            case 1->{

                //insewrimento del primo numero
                System.out.println("Inserisci il primo numero");
               inserimento[volte].setNumero1(keyboard.nextInt());

               //inserimento dell'operatore
               System.out.println("Inserisci l'operatore(+,-,*)");
                inserimento[volte].setOperazione(keyboard.next());

                //controllo operatore
                while (!inserimento[volte].operazione.equals("+") && !inserimento[volte].operazione.equals("-") && !inserimento[volte].operazione.equals("*")){
                    System.out.println("L'inserimento è errato");

                    //pulizia del buffer
                    keyboard.nextLine();

                    //inserimento dell'operazione in caso sia sbagliata
                    inserimento[volte].setOperazione(keyboard.next());
                }

                //inserimento secondo numero
                System.out.println("Inserisci il secondo numero");
                inserimento[volte].setNumero2(keyboard.nextInt());

                //aumento della ripetizione del ciclo
                volte++;
                keyboard.nextLine();
            }
            case 2->{

                //visualizza tutto
                Visualizza(inserimento,volte);
            }

            case 3->{
                Numero ricerca=new Numero();
                if (volte<2){
                    System.out.println("Inserisci più dati per fare la ricerca del risultato");
                }else {
                    //inserimento del primo numero
                    System.out.println("Inserisci il primo numero");
                    ricerca.setNumero1(keyboard.nextInt());

                    //inserimento operazione
                    System.out.println("Inserisci l'operazione");
                    ricerca.setOperazione(keyboard.next());

                    //inserimento secondo numero
                    System.out.println("Inserisci il secondo numero");
                    ricerca.setNumero2(keyboard.nextInt());

                    //controlla la posizione dei dati inseriti
                    int posizione=Posizione(inserimento,ricerca,volte);
                    if (posizione==-1){
                        System.out.println("I dati ricercati non esistono");
                    }else {
                        if (ripetizioneRicerca==0 || ripetizioneRicerca==random[rip-1]){
                        //numero random
                            random=random(rip,random);
                        //contatore delle volte che da il numero errato
                            rip++;
                        }
                        //conta quante volte si è fatta la ricera
                        ripetizioneRicerca++;

                        //out del risultato
                        if (ripetizioneRicerca!=random[rip-1]) {
                            numeroPrec = inserimento[posizione].getRisultato();
                        }

                        //richiamo del metodo
                        ripetizioneRicerca=wrongIndexSearch(inserimento,posizione,random,ripetizioneRicerca,rip,numeroPrec);
                    }
                    //pulizia buffer
                    keyboard.nextLine();
                }
            }

            //esce dal ciclo
            case 4->ripetizione=false;
        }

        }while (ripetizione);
    }

    //metodo per il risultato errato
    private static int wrongIndexSearch(Numero[] inserimento,int posizione,int[] random,int ripetizioneRicerca,int rip,int numeroPrec){

        System.out.println("Il risultato è:");

        //crea il risultato
        inserimento[posizione].setRisultato();

        //out del risultato giusto
        if (ripetizioneRicerca!=random[rip-1]){
            System.out.println(inserimento[posizione].getRisultato());
        }
        //out del risultato sbagliato
        else {
            System.out.println(numeroPrec);
            return 0;
        }
        return ripetizioneRicerca;
    }

    //numero random
    private static int[] random(int rip,int[] randomInt){
        Random random=new Random();
        randomInt[rip]=random.nextInt(3,6);
        System.out.println(randomInt[rip]);
        return randomInt;
    }

    //controlla la posizione
    private static int Posizione(Numero[] inserimento,Numero ricerca,int volte){
        for (int i=0;i<volte;i++){
            if (ricerca.getNumero1()==inserimento[i].getNumero1() && ricerca.getNumero2()==inserimento[i].getNumero2() && ricerca.operazione.equals(inserimento[i].operazione)){
                return i;
            }
        }
        return -1;
    }

    //out del risultato
    private static void Visualizza(Numero[] inserimento,int volte){
        for (int i=0;i<volte;i++){
            System.out.println(inserimento[i].numero1+inserimento[i].operazione+inserimento[i].numero2);
        }
    }
}

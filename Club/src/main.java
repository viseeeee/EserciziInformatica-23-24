import java.util.Scanner;
import  static tools.utility.*;
public class main {
    //ordinamento
    //eliminazione



    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Club[] club = new Club[30];
        Club inserimento=new Club();
        int personeInserite = 0;
        String[] menu = {"CLUB",
                "[1] Inserimento",
                "[2] Visualizza",
                "[3] Cambio Nome",
                "[4] Cambio Cognome",
                "[5] Cambio Classe",
                "[6] Cambio stato",
                "[7] Ordinamento",
                "[8] Eliminazione",
                "[9] Ordinamento secondo il Club",
                "[10] Esci"};
        String[] stato = {"STATO",
                "[1] Dentro",
                "[2] Uscito"};
        boolean uscita=true;
        int pos=0;
        do {

            switch (menu(menu,keyboard)) {
                //inserimento
                case 1 -> {
                    club[personeInserite] = leggiPersona(club, personeInserite, stato, keyboard, true);
                    if (ClubControl(club, personeInserite) == -1) {
                        if (club[personeInserite].classe != null) {
                            System.out.println("Il club nuovo è stato inserito");
                            club[personeInserite].partecipanti++;
                            personeInserite++;
                        }
                        System.out.println(personeInserite);
                    } else {
                        if (club[personeInserite].classe != null) {
                            System.out.println("Il club è già presente");
                            club[ClubControl(club, personeInserite)].partecipanti++;
                            personeInserite++;

                        }
                        System.out.println(personeInserite);
                    }

                }


                //visualizza
                case 2 -> Visualizza(club, personeInserite);

                //cambio nome
                case 3 -> {
                    inserimento = leggiPersona(club, personeInserite, stato, keyboard, false);
                    pos = utente(club, personeInserite, inserimento);
                    if (pos != -1) {
                        System.out.println("Inserisci il nuovo nome");
                        inserimento.nome = keyboard.nextLine();
                        while (utente(club, personeInserite, inserimento) != -1) {
                            System.out.println("Il nome è uguale a quello precendete inseriti, reiseriscilo");
                            inserimento.nome = keyboard.nextLine();
                        }
                        club[pos].nome = inserimento.nome;
                    } else {
                        System.out.println("L'utente non esite");
                    }
                }


                //cambio del cognome
                case 4 -> {
                    inserimento = leggiPersona(club, personeInserite, stato, keyboard, false);
                    pos = utente(club, personeInserite, inserimento);
                    if (pos != -1) {
                        System.out.println("Inserisci il cognome");
                        inserimento.cognome = keyboard.nextLine();

                        System.out.println(Cognome(club, personeInserite, inserimento));
                        while (utente(club, personeInserite, inserimento) != -1) {
                            System.out.println("Il cognome è ugugale a quello precedentemente messo, reinseriscilo");
                            inserimento.cognome = keyboard.nextLine();
                        }
                        club[pos].cognome = inserimento.cognome;
                    } else {
                        System.out.println("L'utente non esiste");
                    }
                }

                //cambio della classe
                case 5 -> {
                    inserimento = leggiPersona(club, personeInserite, stato, keyboard, false);
                    if (utente(club, personeInserite, inserimento) != -1) {
                        System.out.println("Inserisci la classe");
                        club[utente(club, personeInserite, inserimento)].classe = keyboard.nextLine();
                    } else {
                        System.out.println("L'utente non esiste");
                    }
                }
                case 6 -> {
                    inserimento = leggiPersona(club, personeInserite, stato, keyboard, false);
                    if (utente(club, personeInserite, inserimento) != -1) {
                        switch (tools.utility.menu(stato, keyboard)) {
                            case 1 -> club[utente(club, personeInserite, inserimento)].stato = Stato.dentro;
                            case 2 -> club[utente(club, personeInserite, inserimento)].stato = Stato.uscito;
                        }

                    } else {
                        System.out.println("L'utente non esiste");
                    }
                }
                //ordinamento
                case 7 -> club = ordinamento(club, personeInserite);
                case 8 -> {inserimento = leggiPersona(club, personeInserite, stato, keyboard, false);
                    pos=utente(club, personeInserite, inserimento);
                if ( pos!= -1) {
                    club=PosEliminata(club,personeInserite,pos);
                    personeInserite--;
                    pos=cercaClub(club,personeInserite,pos);
                    club[pos].partecipanti--;
                    System.out.println("L'eliminazione è stata fatta");
                } else{
                System.out.println("L'utente non esiste");
            }
        }
            case 9->club=OrdinamentoClub(club,personeInserite);
            case 10->uscita=false;
        }

        }while (uscita);
    }

    //serve per leggere le persone
    private static Club leggiPersona(Club[] clubss,int clubInseriti,String[] stato,Scanner keyboard,boolean entrata){
        Club club=new Club();
        System.out.println("Inserisci il nome del club a cui vuoi partecipare");
        club.nomeClub=keyboard.nextLine();
        System.out.println("Inserisci il nome dell'utente");
        club.nome=keyboard.nextLine();
        System.out.println("Inserisci il cognome dell'utente");
        club.cognome=keyboard.nextLine();
        if (entrata) {
            if (utente(clubss, clubInseriti, club) == -1 ) {
                while (Cognome(clubss, clubInseriti, club) != -1) {
                    System.out.println("Hai già inserito questo cognome");
                    club.cognome = keyboard.nextLine();
                }
                System.out.println("Inserisci la classe dell'utente");
                club.classe = keyboard.nextLine();
                switch (tools.utility.menu(stato, keyboard)) {
                    case 1 -> club.stato = Stato.dentro;
                    case 2 -> club.stato = Stato.uscito;
                }
            } else {
                System.out.println("Questo utente è già stato inserito");
            }
        }
        return club;
    }

    //serve per cercare il primo valore del club
    private static int cercaClub(Club[] club,int PersoneInserite,int posizione){
        for (int i=0;i<PersoneInserite;i++){
            if (club[posizione].nomeClub.equals(club[i].nomeClub)){
                return i;
            }
        }
        return -1;
    }


    //controlla se il club è inserito o meno
    private static int ClubControl(Club[] club,int clubinseriti){
        for (int i=0;i<clubinseriti;i++){
            if (club[clubinseriti].nomeClub.equals(club[i].nomeClub)){
                return i;
            }
        }
        return -1;
    }



    //serve epr controllare se cognome è già stato inserito
    private static int Cognome(Club[] club,int clubinseriti,Club clubs){
        for (int i=0;i<clubinseriti;i++){
            if (clubs.cognome.equals(club[i].cognome)){
                return i;
            }
        }
        return -1;
    }

    //serve per controllare se il nome e il cognome se sono stati inseriti
    private static int utente(Club[] club,int clubinseriti,Club clubs){
        for (int i=0;i<clubinseriti;i++){
            if (clubs.cognome.equals(club[i].cognome) && clubs.nome.equals(club[i].nome)){
                return i;
            }
        }
        return -1;
    }

//visualizza tutto quanto
    private static void Visualizza(Club[] club,int personeInserite){
        for (int i=0;i<personeInserite;i++){
            System.out.println(club[i].Stampa());
        }
    }

    private static Club[] ordinamento(Club[] club,int personeInserite){
        int[] compare=new int[personeInserite];
        Club[] clubOrdinato=new Club[100];
        int[] compareordinato=new int[personeInserite];
        int maggiore=0,volte=0,pos=0;
        //fa il compare di tutti gli elementi
        for (int i=0;i<personeInserite;i++){
            compare[i]=club[0].cognome.compareTo(club[i].cognome);
            System.out.println(compare[i]);
        }
        do {

        for (int i=0;i<personeInserite;i++){
            if (i==0 ||compare[i]>maggiore &&  compare[i]!=-30){
                maggiore=compare[i];
                System.out.println(maggiore);
                pos=i;
            }
        }
        //
        compareordinato[volte]=pos;
            System.out.println(compareordinato[volte]);
        compare[pos]=-30;

        volte++;
       }while (volte<personeInserite);

        //attribuisce a volte il valore
        for (int i=0;i<volte;i++){
            clubOrdinato[i]=club[compareordinato[i]];
            System.out.println(clubOrdinato[i].cognome);
        }
        return clubOrdinato;
    }

    private static Club[] OrdinamentoClub(Club[] club,int personeInserite) {
        Club[] ClubOrdinato = new Club[personeInserite];
        int[] compare = new int[personeInserite];
        int[] compareOrdinato = new int[personeInserite];
        int volte = 0, maggiore = 0, pos = 0;

    //fa il compare del nome del club e salva tutti i valori in un array
        for (int i = 0; i < personeInserite; i++) {
            compare[i] = club[0].nomeClub.compareTo(club[i].nomeClub);
            System.out.println(compare[i]);
        }
        do {
            //serve per prende il numero maggiore
            for (int i = 0; i < personeInserite; i++) {
                if (i == 0 || compare[i] > maggiore && compare[i] != -30) {
                    //prende il numero del compare to maggiore
                    maggiore = compare[i];
                    //si salva la posizione nell'array
                    pos = i;

                }
            }
            //prende la posizione del numero maggiore
            compareOrdinato[volte]=pos;

            //pone il numero maggiore a -30
            compare[pos] = -30;

            //aumenta il numero di volte che si ripete il ciclo e questo serve per compare ordinato
            volte++;
        }    while (volte < personeInserite) ;

        //mette tutti i valori di club con indice il valore ordinato e in questo modo il club diventa ordinato
        for (int i=0;i<volte;i++){
            ClubOrdinato[i]=club[compareOrdinato[i]];
        }
    return ClubOrdinato;
    }

    //elimina una posizione
    private static Club[] PosEliminata(Club[] club,int personeInserite,int posizione){
                for (int i=posizione;i<personeInserite;i++){
                    club[i]=club[i+1];
                }
                return club;
    }
}

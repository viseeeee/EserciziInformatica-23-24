import java.util.Scanner;
import tools.utility.*;
public class main {
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
                "[7] Esci"};
        String[] stato = {"STATO",
                "[1] Dentro",
                "[2] Uscito"};
        boolean uscita=true;
        do {

            switch (tools.utility.menu(menu, keyboard)) {
                //inserimento
                case 1 -> {
                club[personeInserite] = leggiPersona(club,personeInserite, stato,keyboard,true);
                    if (ClubControl(club,personeInserite)==-1){
                        if (club[personeInserite].classe!=null) {
                            System.out.println("Il club nuovo è stato inserito");
                            club[personeInserite].partecipanti++;
                            personeInserite++;
                        }
                        System.out.println(personeInserite);
                    }else {
                        if (club[personeInserite].classe!=null) {
                            System.out.println("Il club è già presente");
                            club[ClubControl(club,personeInserite)].partecipanti++;
                            personeInserite++;
                        }
                        System.out.println(personeInserite);
                    }

                }


            //visualizza
            case 2 -> Visualizza(club,personeInserite);
            case 3->{

            }
            case 4->{
                inserimento=leggiPersona(club,personeInserite, stato,keyboard,false);
                int pos=utente(club, personeInserite, inserimento);
                if(pos!=-1){
                    System.out.println("Inserisci il cognome");
                    club[pos].cognome = keyboard.nextLine();
                    System.out.println(Cognome(club, personeInserite,club[pos] ));
                    while (utente(club, personeInserite,club[pos] )!=-1){
                        System.out.println("Il cognome è ugugale a quello precedentemente messo, reinseriscilo");
                        club[pos].cognome = keyboard.nextLine();
                        System.out.println(club[pos].cognome);
                        System.out.println(utente(club, personeInserite,club[pos] ));
                    }
                }else {
                    System.out.println("L'utente non esiste");
                }
            }
            case 5->{
                inserimento=leggiPersona(club,personeInserite, stato,keyboard,false);
                if(utente(club, personeInserite, inserimento)!=-1){
                    System.out.println("Inserisci la classe");
                        club[utente(club, personeInserite, inserimento)].classe = keyboard.nextLine();
                }else {
                    System.out.println("L'utente non esiste");
                }
            }
                case 6->{
                    inserimento=leggiPersona(club,personeInserite, stato,keyboard,false);
                    if(utente(club, personeInserite, inserimento)!=-1){
                        switch (tools.utility.menu(stato, keyboard)) {
                            case 1 -> club[utente(club, personeInserite, inserimento)].stato = Stato.dentro;
                            case 2 -> club[utente(club, personeInserite, inserimento)].stato = Stato.uscito;
                        }

                    }else {
                        System.out.println("L'utente non esiste");
                    }
                }
            case 7->uscita=false;
        }


        }while (uscita);
    }
    private static Club leggiPersona(Club[] clubss,int clubInseriti,String[] stato,Scanner keyboard,boolean entrata){
        Club club=new Club();
        System.out.println("Inserisci il nome del club a cui vuoi partecipare");
        club.nomeClub=keyboard.nextLine();
        System.out.println("Inserisci il nome dell'utente");
        club.nome=keyboard.nextLine();
        System.out.println("Inserisci il cognome dell'utente");
        club.cognome=keyboard.nextLine();
        if (entrata) {
            if (Cognome(clubss, clubInseriti, club) == -1 || Nome(clubss, clubInseriti, club) == -1) {
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
    private static int ClubControl(Club[] club,int clubinseriti){
        for (int i=0;i<clubinseriti;i++){
            if (club[clubinseriti].nomeClub.equals(club[i].nomeClub)){
                return i;
            }
        }
        return -1;
    }


    private static int Nome(Club[] club,int clubinseriti,Club clubs){
        for (int i=0;i<clubinseriti;i++){
            if (clubs.nome.equals(club[i].nome)){
                return i;
            }
        }
        return -1;
    }

    private static int Cognome(Club[] club,int clubinseriti,Club clubs){
        for (int i=0;i<clubinseriti;i++){
            if (clubs.cognome.equals(club[i].cognome)){
                return i;
            }
        }
        return -1;
    }

    private static int utente(Club[] club,int clubinseriti,Club clubs){
        for (int i=0;i<clubinseriti;i++){
            if (clubs.cognome.equals(club[i].cognome) && clubs.nome.equals(club[i].nome)){
                return i;
            }
        }
        return -1;
    }


    private static void Visualizza(Club[] club,int personeInserite){
        for (int i=0;i<personeInserite;i++){
            System.out.println(club[i].Stampa());
        }
    }
}

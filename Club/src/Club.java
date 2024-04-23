
enum Stato{dentro,uscito};
public class Club {
    public String nomeClub;

    public int partecipanti;

    public String nome;

    public String cognome;

    public String classe;
    public Stato stato;
    public String Stampa(){
        return String.format("Nome: "+ nome+"   Cognome: "+ cognome+"    classe: "+ classe + "    Stato: "+ stato+"     Nome Club:"+nomeClub+"      Partecipanti:"+ partecipanti);
    }
}

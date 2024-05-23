enum Tipo{
    pubblico,
    nascosto

};
public class contatto {
    public String nome;
    public String cognome;
    public String numero;
    public Tipo tipo;


    //non stampo il tipo perchè deve rimanere nascosto
    public String Stampa(){
        return String.format("nome: " + nome+"   cognome: "+cognome+"    numero: "+numero);
    }

    //stampa tipo nascosto
    public String StampaNascosta(){
        return String.format("nome: " + nome+"   cognome: "+cognome+"    numero: "+numero+"     tipo:"+tipo);
    }

}

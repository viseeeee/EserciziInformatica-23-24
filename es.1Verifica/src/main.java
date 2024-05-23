import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;

import static tools.utility.Wait;
import static tools.utility.*;

public class main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        String[] tipo={"TIPO","[1] PUBBLICO ","[2] NASCOSTO"};
        String[] menu={
                "CLUB",
                "[1] Inserimento Numero di telefono",
                "[2] Aggiunta numero alla rubrica",
                "[3] Visualizza la rubrica dei numeri",
                "[4] Visualizza la rubrica delle telefonate",
                "[5] Scrittura su file",
                "[6] Lettura su file e Salva dati",
                "[7] Reinserisci la password",
                "[8] Esci"
        };
        boolean ripetizione=true;
        int personeInserite=0;
        int utentiTelefono=0;
        contatto[] RubricaNumeri =new contatto[20];
        contatto[] RubricaTelefonica=new contatto[20];
        
        //inserimento password
        System.out.println("Inserisci una password per accedere");
        String password=keyboard.nextLine();
        do {
            switch (menu(menu,keyboard)){
                //inserimento
                case 1->{
                    keyboard.nextLine();
                    if (personeInserite<=20){
                        RubricaNumeri[personeInserite]= leggiContatto(RubricaNumeri,personeInserite,tipo,keyboard,true,true,password);

                        if (!RubricaNumeri[personeInserite].numero.equals(-1)){
                            personeInserite++;
                        }

                    }else{
                        System.out.println("Hai raggiunto il numero massimo di persone che puoi inserire");
                    }
                }

                case 2->{
                    contatto utente =new contatto();
                    keyboard.nextLine();
                    System.out.println("Inserisci il nome dell'utente");
                    utente.nome=keyboard.nextLine();
                    System.out.println("Inserisci il cognome dell'utente");
                    utente.cognome=keyboard.nextLine();
                    System.out.println("Inserisci il numero di telefono");
                    utente.numero=keyboard.nextLine();
                    int i=numeroUtente(RubricaNumeri,personeInserite,utente);
                    if (i!=-1){
                        RubricaTelefonica[utentiTelefono]=RubricaNumeri[i];
                        utentiTelefono++;
                        System.out.println("L'utente è stato inserito correttamente");
                        Wait(2000);
                    }else {
                        System.out.println("Non hai inserito questo utente tra i numeri salvati");
                        Wait(2000);
                    }
                }

                case 3->{
                    //controlla l'inserimento della pw
                    if (InserimentoPW(password)){
                        VisualizzaNascosta(RubricaNumeri,personeInserite);
                        Wait(2000);
                    }else {
                        VisualizzaPubblico(RubricaNumeri,personeInserite);
                        Wait(2000);
                    }
                }

                case 4->{
                    //controlla l'inserimento della pw
                    if (InserimentoPW(password)){
                        VisualizzaNascosta(RubricaTelefonica,utentiTelefono);
                        Wait(2000);
                    }else {
                        VisualizzaPubblico(RubricaTelefonica,utentiTelefono);
                        Wait(2000);
                    }
                }
                case 5->{
                    //scrittura su file
                    try {
                        ScriviFile("File.txt",RubricaNumeri,personeInserite);
                    } catch (IOException ex) {
                        System.out.println(ex.toString());
                        break;
                    }
                }

                case 6->{
                    //lettura da file
                    if (InserimentoPW(password)){
                        try {
                            personeInserite=LeggiFileNascosto("File.txt",RubricaNumeri,personeInserite);
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                            break;
                        }
                    }else {
                        try {
                            LeggiFilePubblico("File.txt",RubricaNumeri,personeInserite);
                        } catch (IOException ex) {
                            System.out.println(ex.toString());
                            break;
                        }
                    }
                }
                case 7->{
                    keyboard.nextLine();
                    System.out.println("Inserisci la password");
                    password=keyboard.nextLine();
                    Wait(2000);
                }

                case 8->{
                    ripetizione=false;
                }
            }

        }while (ripetizione);

    }

    //mi legge in ingresso le persone
    private static contatto leggiContatto(contatto[] inseriti, int personeInserite, String[] tipo, Scanner keyboard, boolean entrata, boolean numero, String password){
        contatto utente =new contatto();
        System.out.println("Inserisci il nome dell'utente");
        utente.nome=keyboard.nextLine();
        System.out.println("Inserisci il cognome dell'utente");
        utente.cognome=keyboard.nextLine();
        if (numero){
            System.out.println("Inserisci il numero del contatto");
            utente.numero=keyboard.nextLine();
            while (controlloNumero(inseriti,personeInserite,utente)){
                System.out.println("Hai già inserito questo numero in un altro utente");
                utente.numero=keyboard.nextLine();
            }
        }
        if (entrata) {
            //controlla se l'utente è già stato inserito
            //controlla se la pw inserita è quella privata
            if (InserimentoPW(password)){
                switch (menu(tipo,keyboard)) {
                    case 1-> utente.tipo = Tipo.pubblico;
                    case 2-> utente.tipo = Tipo.nascosto;
                }
            } else {
                utente.tipo = Tipo.pubblico;
            }

        }
        return utente;
    }

    private static int numeroUtente(contatto[] inseriti,int personeInserite,contatto utente){
        for (int i=0;i<personeInserite;i++){
            if (inseriti[i].nome.equals(utente.nome) && inseriti[i].cognome.equals(utente.cognome) && inseriti[i].numero.equals(utente.numero)){
                return i;
            }
        }
        return -1;
    }

    //controlla se la password è la stessa
    private static boolean InserimentoPW(String password){
        password=password.toLowerCase();
        if (password.equals("pr") ){
            return true;
        }
        else {
            return false;
        }
    }


    //visualizza solo i contatti pubblici
    private static void VisualizzaPubblico(contatto[] inseriti, int personeInserite){
        for (int i=0;i<personeInserite;i++){
            //controlla se il tipo è pubblico e basta
            if (inseriti[i].tipo.equals(Tipo.pubblico)){
                System.out.println(inseriti[i].Stampa());
            }        }
    }

    //visualizza tutto quanto
    private static void VisualizzaNascosta(contatto[] inseriti,int personeInserite){
        for (int i=0;i<personeInserite;i++){
            System.out.println(inseriti[i].StampaNascosta());
        }
    }

    //controllo numero uguale
    private static boolean controlloNumero(contatto[] inseriti,int personeInserite,contatto utente){
        for (int i=0;i<personeInserite;i++){
            if (inseriti[i].numero==utente.numero){
                return true;
            }
        }
        return false;
    }

    // Funzione per scrivere i contatti su file
    public static void ScriviFile(String fileName, contatto[] gestore, int contrattiVenduti) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (int i = 0; i < contrattiVenduti; i++) {
            writer.write(gestore[i].nome + "," + gestore[i].cognome + "," + gestore[i].numero + "," + gestore[i].tipo +"\n");
        }
        writer.flush();
        writer.close();
    }

    public static int LeggiFilePubblico(String fileName, contatto[] gestore, int contrattiVenduti) throws IOException {
        FileReader reader = new FileReader(fileName);
        Scanner input = new Scanner(reader);
        String lineIn;
        String[] vetAttributi;
        int contaElementi = 0;
        while (input.hasNextLine() && (contaElementi < gestore.length)) {
            lineIn = input.nextLine();
            vetAttributi = lineIn.split(",");
            contatto persona = new contatto();
            persona.nome = vetAttributi[0];
            persona.cognome = vetAttributi[1];
            persona.numero = vetAttributi[2];
            switch (vetAttributi[3]) {
                case "pubblico":
                    persona.tipo = Tipo.pubblico;
                    break;
                case "nascosto":
                    persona.tipo = Tipo.nascosto;
                    break;
            }
            if (ControlloNomeCognome(gestore,persona,contrattiVenduti)==-1){
                //inserimento nell'array
                gestore[contrattiVenduti]=persona;

                //aumenta il contatore delle persone inserite
                contrattiVenduti++;
            }
            if (persona.tipo.equals(Tipo.pubblico)){
                System.out.println("nome: " + persona.nome+"   cognome: "+persona.cognome+"    numero: "+persona.numero);
            }
        }
        reader.close();
        return contrattiVenduti;
    }

    //leggi file con salvataggio del file
    public static int LeggiFileNascosto(String fileName, contatto[] gestore, int contrattiVenduti) throws IOException {
        FileReader reader = new FileReader(fileName);
        Scanner input = new Scanner(reader);
        String lineIn;
        String[] vetAttributi;
        int contaElementi = 0;
        while (input.hasNextLine() && (contaElementi < gestore.length)) {
            lineIn = input.nextLine();
            vetAttributi = lineIn.split(",");
            contatto persona = new contatto();
            persona.nome = vetAttributi[0];
            persona.cognome = vetAttributi[1];
            persona.numero = vetAttributi[2];
            switch (vetAttributi[3]) {
                case "pubblico":
                    persona.tipo = Tipo.pubblico;
                    break;
                case "nascosto":
                    persona.tipo = Tipo.nascosto;
                    break;
            }
            if (ControlloNomeCognome(gestore,persona,contrattiVenduti)==-1){
                //inserimento nell'array
                gestore[contrattiVenduti]=persona;

                //aumenta il contatore delle persone inserite
                contrattiVenduti++;
            }
            System.out.println("nome: " + persona.nome+"   cognome: "+persona.cognome+"    numero: "+persona.numero+"    tipo: "+persona.tipo);
        }
        reader.close();
        return contrattiVenduti;
    }

    //controlla tutte le caratteristiche del tipo contatto
    private static int ControlloNomeCognome(contatto[] gestore,contatto persona,int personeInserite){
        for (int i=0;i<personeInserite;i++){
            if (persona.nome.equals(gestore[i].nome) && persona.cognome.equals(gestore[i].cognome) && persona.numero.equals(gestore[i].numero) && persona.tipo.equals(gestore[i].tipo) ){
                return i;
            }
        }
        return -1;
    }
}


import java.util.Scanner;

public class ValidaData {
    public static void main(String[] args) {
        //declaration and initialization of variables/arrays

        int numero = 0;
        int output = 0;
        boolean domain=false;
        Scanner scanner = new Scanner(System.in);
        //output for enter the date
        System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
        //Check for non valido user input
        try{
            numero=scanner.nextInt();
        }catch (Exception x){
            domain=true;
            scanner.next();
        }
        output=validata(numero,domain);
        do{
            domain=false;
            if(output!=-1 && output!=0){
                System.out.println("Errore : il valore inserito non e' valido");
                System.out.println("reinserisci il valore");
                try{
                    numero=scanner.nextInt();
                }catch (Exception x){
                    domain=true;
                    scanner.next();
                }
                output=validata(numero,domain);
            }
        } while(output!=-1 && output!=0);

        //Separare la data in giorno, mese, anno
        int[] dataSeparata = separazioneData(numero);

        System.out.println("Conversione stringa 1 : " + dataToString1(dataSeparata));
        System.out.println("Conversione stringa 2 : " + dataToString2(dataSeparata));
        System.out.println("Conversione stringa 3 : " + dataToString3(dataSeparata));
    }

    /* Separazione della data inserita in giorno, mese ed anno*/
    //12042024
    //12
    //04
    //2024:
    //Si ottiene dal resto della divisione della data per 10000
    //12042024 / 10000 = 1204 Resto 2024
    //12042024 / 10000 = 1204 Salviamo il risultato dentro data
    //1204 / 100 = 12 Resto 04
    //1204 / 100 = 12 Salviamo il risultato dentro data
    private static int[] separazioneData (int data) {
        //Contiene il valore d'uscita
        int[] output = new int[3];

        //Anno
        output[2] = data % 10000;
        //Rimuovere l'anno dalla data
        data /= 10000;
        //Mese
        output[1] = data % 100;
        //Rimuovere il mese dalla data
        data /= 100;
        //Giorno
        output[0] = data;

        //Ritornare i valori separati
        return output;
    }

    private static String dataToString1(int[] data) {
        String output;

        output = String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);

        return output;
    }

    private static String dataToString2(int[] data) {
        String output;

        output = Integer.toString(data[0]) + "/" + Integer.toString(data[1]) + "/" + Integer.toString(data[2]);

        return output;
    }

    private static String dataToString3(int[] data) {
        Integer boxing = data[0];
        String output = boxing.toString() + "/";

        boxing = data[1];
        output += boxing.toString() + "/";

        boxing = data[2];
        output += boxing.toString();

        return output;
    }
    //anno: 31129999
    //01010001

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect

    //metodo che indica se la data inserita ha il domio incorretto, è out of range o non ha nulla
    private static int validata (int numero,boolean domain){
       if(domain){
            return 2;
        }
        if(numero>31129999 || numero<  1010001){
            return 1;
        }
            return -1;

    }
}

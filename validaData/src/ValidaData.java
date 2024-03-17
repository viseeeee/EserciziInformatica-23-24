import java.util.Scanner;

public class ValidaData {
    public static void main(String[] args) {
        //declaration and initialization of variables/arrays
        String[] menu = {"=== DATA === ", "[1]-incremento data", "[2]-decremento data", "[3]-Exit "};
        int numero = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        char scelta;
        Boolean dataValida;
        boolean bisestile;
        boolean dataNonValida = false;
        do {
            dataValida = false;
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //Check for non valida user input
            try {
                //insertion of the date
                numero = scanner.nextInt();
                int[] dataSeparata = separazioneData(numero);
                if (!dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])) {
                    dataValida = true;
                    System.out.println("DATA ERRATA");
                } else {
                    System.out.println("DATA CORRETTA");
                }
            } catch (Exception x) {
                System.out.println("DATA ERRATA");
                dataValida = true;
                scanner.nextLine();
            }
        } while (dataValida);
        int[] dataSeparata = separazioneData(numero);
        int[]  dataCambiata = new int[0];
        int sceltaMenu;
        sceltaMenu=menu(menu,scanner);
        switch (sceltaMenu){
            case 1->dataCambiata=data_up(dataSeparata[0], dataSeparata[1], dataSeparata[2]);
            case 2->dataCambiata=data_down(dataSeparata[0], dataSeparata[1], dataSeparata[2]);
            case 3->{
            }
        }
        System.out.println("la data cambiata è "+dataToString1(dataCambiata));
        //Separare la data in giorno, mese, anno




        /*System.out.println("Conversione stringa 1 : " + dataToString1(dataSeparata));
        System.out.println("Conversione stringa 2 : " + dataToString2(dataSeparata));
        System.out.println("Conversione stringa 3 : " + dataToString3(dataSeparata));
        */
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

    
 //metodo che serve per aumentare di 1 giorno la data
    private static int[] data_down(int giorno, int mese, int anno){
        int[] dataCambiata=new int[3];
        switch (giorno){
            case 1 -> {
                mese=mese-1;
                if (mese!=0 && giorno==1){
                    switch (mese){
                        case 1, 3, 5, 7, 8, 10, 12-> giorno=31;
                        case 4, 6, 9, 11 -> giorno=30;
                        case 2-> {
                            if (Bisestile(anno)){
                                giorno=29;
                            }
                        }
                    }
                }else {
                    anno=anno-1;
                    mese=12;
                    giorno=31;
                }
            }
            default -> giorno=giorno-1;
        }
        for (int i=0;i<dataCambiata.length;i++){
            if (i==0){
                dataCambiata[i]=giorno;
            }
            else if (i==1){
                dataCambiata[i]=mese;
            }
            else{
                dataCambiata[i]=anno;
            }
        }
        return dataCambiata;
    }


    //metodo che serve per diminuire di 1 giorno la data
    private static int[] data_up(int giorno, int mese, int anno) {
        int[] dataCambiata = new int[3];
        switch (giorno) {
            case 31 -> {
                    switch (mese) {
                        case 1, 3, 5, 7, 8, 10-> {
                            giorno = 1;
                            mese = mese + 1;
                        }
                        case 12-> {
                            giorno = 1;
                            mese = 1;
                            anno = anno + 1;
                        }
                    }
                }
            case 30 -> {
                switch (mese) {
                    case 4, 6, 9, 11 -> {
                        giorno = 1;
                        mese=mese+1;
                    }
                    case 1, 3, 5, 7, 8, 10,12->giorno=giorno+1;
                }
            }
            case 29 -> {
                switch (mese) {
                    case 2 -> {
                            giorno=1;
                            mese=mese+1;
                    }
                    default -> giorno=giorno+1;
                }

            }
            case 28-> {
                switch (mese) {
                    case 2 -> {
                        if (!Bisestile(anno)) {
                            mese = mese + 1;
                            giorno = 1;
                        } else {
                            giorno = giorno + 1;
                        }
                    }
                }
            }
            default -> giorno = giorno + 1;
        }
            for (int i = 0; i < dataCambiata.length; i++) {
                if (i == 0) {
                    dataCambiata[i] = giorno;
                } else if (i == 1) {
                    dataCambiata[i] = mese;
                } else {
                    dataCambiata[i] = anno;
                }
            }
        return dataCambiata;
        }

    private static int[] separazioneData(int data) {
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

    private static boolean Bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    }

    private static boolean dataOk(int giorno, int mese, int anno) {
        boolean valida = false;
        /*switch (mese) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                valida = (giorno > 0 && giorno < 32);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                valida = (giorno > 0 && giorno < 31);
                break;
            case 2:
                if (Bisestile(anno) && giorno > 0 && giorno < 30) {
                    valida = true;
                } else if (giorno > 0 && giorno < 29) {
                    valida = true;
                }
                break;
        }
         */
        /*if (mese==2) {
            if(Bisestile(anno) && giorno > 0 && giorno < 30) {
                valida = true;
            } else if (giorno > 0 && giorno < 29) {
                valida = true;
            }
        }else*/ {


            valida = switch (mese) {
                case 1, 3, 5, 7, 8, 10, 12 -> (giorno > 0 && giorno < 32);
                case 4, 6, 9, 11 -> (giorno > 0 && giorno < 31);
                case 2-> (Bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
                default -> false;
            };
        }
        return valida;
        }



    //anno: 31129999
    //01010001
    private static boolean validadata(int numero){
        return (numero>31129999 || numero<01010001);
    }

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect

    public static int menu(String[] opzioni, Scanner keyboard) {
        int scelta;

        do {
            System.out.println("=== " + opzioni[0] + " ==="); //print of the title
            for (int i = 1; i < opzioni.length; i++) {
                System.out.println(opzioni[i]);
            }
            scelta = keyboard.nextInt(); //input of the variable
            /* error message */
            if (scelta < 1 || scelta > opzioni.length - 1) {
                System.out.println("Valore errato. Riprova");
                ClrScr();
            }
        } while (scelta < 1 || scelta > opzioni.length - 1); //check if the value is correct

        return scelta;
    }
    public static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.util.Scanner;
public class convMeseValore {


    public static void main(String[] args) {
        String mese;
        Scanner keybord=new Scanner(System.in);
        System.out.println("Inserisci il nome del mese");
        mese=keybord.next().toUpperCase();
        if (ConvMese(mese)==-1){
            System.out.println("Hai inserito un valore sbagliato");
        }else{
            System.out.println("La conversione del mese è:"+ConvMese(mese));
        }


    }
    private static int ConvMese(String mese){
        int valoreMese;
        switch (mese){
            case "GENNAIO" -> {
                return 1;
            }
            case "FEBBRAIO" -> {
                return 2;
            }
            case "MARZO"->{
                return 3;
            }
            case "APRILE"->{
                return 4;
            }
            case "MAGGIO"->{
                return 5;
            }
            case "GIUGNO"->{
                return 6;
            }
            case "LUGLIO"->{
                return 7;
            }
            case "AGOSTO"->{
                return 8;
            }
            case "SETTEMBRE"->{
                return 9;
            }
            case "OTTOBRE"->{
                return 10;
            }
            case "NOVEMBRE"->{
                return 11;
            }
            case "DICEMBRE"->{
                return 12;
            }
            default -> {
                return -1;
            }
        }
    }
}

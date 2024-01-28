import java.util.Scanner;
import java.util.Random;
public class estrazioneLotto {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int[] valoriUtente=new int[5];
        int[] estrazioneRuota=new int[5];
        int contatoreVincita=0;
        boolean ciclo=true;
        String invio;
        int valoreMenu=0;
        int l;
        String [] opzioni = {"=== Gioco Dadi === ", "[1] estrazioni ruota di venezia", "[2] giocata utente","[3] verifica vincita","[4] visualizza giocate", "[5] Exit "};
        do {
            valoreMenu=Menu(opzioni, keyboard);
        switch (valoreMenu){
            case 1:{
                for (int i=0;i<estrazioneRuota.length;i++){
                    estrazioneRuota[i]=random(0,90);
                }
                System.out.println("l'estrazione della ruota di venezia è finita");
                keyboard.nextLine();
                System.out.println("inserisci invio per mostrare il menù");
                invio= keyboard.nextLine();
                break;
            }
            case 2:{
                for (int j=0;j< valoriUtente.length;j++){
                    System.out.println("inserisci il valore numero "+(j+1)+",deve essere compreso tra 0 e 90");
                    valoriUtente[j]= keyboard.nextInt();
                }
                keyboard.nextLine();
                System.out.println("inserisci invio per mostrare il menù");
                invio= keyboard.nextLine();
                break;
            }
            case 3:{
                for (int cella=0;cella< estrazioneRuota.length;cella++){
                    for (int cella1=cella+1;cella1< estrazioneRuota.length;cella1++){
                        if (estrazioneRuota[cella1]==estrazioneRuota[cella]){
                            estrazioneRuota[cella1]=random(0,90);
                            cella=0;
                        }

                    }
                }
                for (int k=0;k< valoriUtente.length;k++){
                    for (l=k;l<estrazioneRuota.length;l++){
                        if (valoriUtente[k]==estrazioneRuota[l]){
                            contatoreVincita++;
                        }
                    }
                    l=0;
                }
                //
                if (contatoreVincita==0){
                    System.out.println("non hai azzeccato nemmeno un numero");
                } if (contatoreVincita==1) {
                    System.out.println("hai fatto ambata(1)");
                }
                if (contatoreVincita==2) {
                    System.out.println("hai fatto ambo(2)");
                }
                if (contatoreVincita==3){
                    System.out.println("hai fatto terno(3)");
                }
                if (contatoreVincita==4){
                    System.out.println("hai fatto quaterna(4)");
                }
                keyboard.nextLine();
                System.out.println("inserisci invio per mostrare il menù");
                invio= keyboard.nextLine();
                break;
            }
            case 4:{
                System.out.println("i numeri che hai azzeccato sono:"+contatoreVincita);//mostra il numero di valori indovinati
               for (int v=0;v<estrazioneRuota.length;v++){//mostra tutti i numeri che sono usciti dall'estrazione della ruota
                   System.out.println("il numero " +v+" uscito è:"+estrazioneRuota[v]);
               }
                keyboard.nextLine();
                System.out.println("inserisci invio per mostrare il menù");
                invio= keyboard.nextLine();
                break;
                }
            case 5:{
                break;
            }
        }
        }while (valoreMenu!=5);
    }

    //giocata utente:l'utente punte 5 numeri sulla ruota di venezia
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
            valoreMenu = keyboard.nextInt();

            if ((valoreMenu < 1) || (valoreMenu > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
            }
        }while ((valoreMenu < 1) || (valoreMenu > opzioni.length - 1));

        return valoreMenu;
    }
    private static int random( int minValue,int maxValue){
        Random casuale=new Random();
        return casuale.nextInt(minValue,maxValue);
    }
    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

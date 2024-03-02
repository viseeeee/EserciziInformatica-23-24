import java.util.Scanner;

public class gestioneData3 {
                    public static void main(String[] args) {
                        int data;
                        int copia;
                        int mese,giorno,anno;
                        String nomeMese = null;
                        String risposta;
                        boolean confermaBisestile;
                        boolean controlloMesi;
                        boolean controlloGIorni;
                        Scanner keyboard=new Scanner(System.in);

                        //inserimento della data
                        System.out.println("inserisci la data(ggmmaaaa) se si inserisce un numero negativo sarà convertito a positivo");
                        data=keyboard.nextInt();

                        //pongo copia uguale a data
                        copia=data;

                        //invoco il metodo per trasformare il metodo in positivo da negativo
                        copia=Positivo(data);
                        for ( int i=0; i<8; i++){
                            data=data/10;
                            if (data==0 && i<7){
                                System.out.println("reiserisci la data(ggmmaaaa)");
                                data=keyboard.nextInt();
                                copia=data;
                                i=0;
                            }
                            ClrScr();
                        }

                        //attribuisce il giorno,il mese e l'anno alla cifra
                        anno=Anno(copia);
                        mese=Mese(copia);
                        giorno=Giorno(copia);


                        do{
                            //pongo risposta uguale a no in modo che il programma successivamente non si ripeta in loop
                            risposta="no";

                        //invoco il metodo che dice se l'anno è bisestile
                        confermaBisestile=ControlloBisestile(anno);

                        //metodo che controlla se i mesi inseriti sono da 1 a 12 e sono giusti
                        controlloMesi=ControlloMesi(mese);

                        //controllo se il giorno che è stato inserito è giusto
                        controlloGIorni=ControlloGiorno(confermaBisestile,giorno,mese);

                        if (controlloGIorni && controlloMesi){
                            //mostra in output il giorno il mese sotto forma di stringa e l'anno e questo solo se i giorni e i mesi
                            // sono corretti altrimenti va avanti nel programma
                            System.out.println("giorno="+giorno);
                            switch (mese) {
                                case 1 -> nomeMese = "GENNAIO";
                                case 2 -> nomeMese = "FEBBRAIO";
                                case 3 -> nomeMese = "MARZO";
                                case 4 -> nomeMese = "APRILE";
                                case 5 -> nomeMese = "MAGGIO";
                                case 6 -> nomeMese = "GIUGNO";
                                case 7 -> nomeMese = "LUGLIO";
                                case 8 -> nomeMese = "AGOSTO";
                                case 9 -> nomeMese = "SETTEMBRE";
                                case 10 -> nomeMese = "OTTOBRE";
                                case 11 -> nomeMese = "NOVEMBRE";
                                case 12 -> nomeMese = "DICEMBRE";
                            }
                            System.out.println("mese="+nomeMese);
                            System.out.println("anno="+anno);
                        }  else {

                            //controlla se i mesi sono sbagliati
                            // se lo sono fà reiserire il mese e fà ripetere il ciclo
                            if (!controlloMesi){
                                System.out.println("non hai inserito un mese corretto");
                                System.out.println("vuoi reinserire il mese?");
                                risposta=keyboard.next().toLowerCase();
                                if (risposta.equals("si")){
                                    System.out.println("inserisci il mese");
                                    mese=keyboard.nextInt();
                                }
                            }

                            //controlla se i giorni sono sbagliati
                            //se i giorni sono sbagliati li fà reiserire dall'utente e fà ripetere il ciclo
                            if (!controlloGIorni){
                                System.out.println("non hai inserito i giorni correttamente");
                                System.out.println("vuoi reinserire il giorno?(si/no)");
                                risposta=keyboard.next().toLowerCase();
                                ClrScr();
                                if (risposta.equals("si")){
                                    System.out.println("inserisci il giorno(numero)");
                                    giorno=keyboard.nextInt();
                                }
                            }
                        }
                        }while (risposta.equals("si"));

                    }


                    private static boolean ControlloGiorno(boolean confermaBisestile,int giorno,int mese){
                        boolean controlloGiorno;

                        // se il giorno inseriti sono minori di 28
                        if (giorno<=28){
                            controlloGiorno=true;
                        }

                        //se il giorno sono 29 e l'anno è bisestile
                        else if(giorno==29 && confermaBisestile){
                            controlloGiorno=true;
                        }

                        //se il giorno sono 30 e il mese inserito è diverso da febbraio
                        else if(giorno==30 && mese!=2){
                            controlloGiorno=true;
                        }

                        //se il giorno è 31 e i mesi sono diversi da quelli che arrivano fino ai mesi che arrivano fino a 30 giorni ì
                        else if (giorno==31 && mese!=2 && mese!=4 && mese!=6 && mese!=9 && mese!=11) {
                            controlloGiorno=true;
                        }

                        //se non entrano negli if controllo giorni diventa false e  indica che il giorno inserito non è corretto
                        else {
                            controlloGiorno=false;
                        }
                        return controlloGiorno;
                    }

                    //controlla se l'anno è bisestile
                    private static Boolean ControlloBisestile(int anno){
                        boolean confermaBisestile=false;

                        //conferma bisestile diventa vera solo se entra dentro l'if altrimenti non lo è
                        if ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0){
                            confermaBisestile=true;
                        }
                        return confermaBisestile;
                    }


                    //controlla se il mese inserito è corretto
                    private static boolean ControlloMesi(int mesi){
                        boolean controlloMesi=false;

                        //se il mese inserito è corretto controllo mesi è true altrimenti è false
                        if (mesi>0 && mesi<=12){
                            controlloMesi=true;
                        }
                        return controlloMesi;
                    }


                    //separa le prime 4 cifre dal numero
                    private static int Anno(int copia){
                        int anno=0;
                        int contatore=1;
                        for (int i=0;i<3;i++){
                            if (i==0){
                                anno=copia%10;
                                copia=copia/10;
                            }
                            contatore=contatore*10;
                            anno+=(copia%10)*contatore;
                            copia=copia/10;
                        }
                        return anno;
                    }

                    //controlla se il numero inserito è negativo
                    //se lo è lo fà diventare positivo
                    private static int Positivo(int data){
                        int copia;
                        copia=data;
                        if (data<0){
                            copia=data*-1;
                        }
                        return copia;
                    }

                    //prende il quarto e il quinto numero
                    private static int Mese(int copia){
                        int mese=0;
                        for (int i=0;i<6;i++){
                            if (i==4){
                                mese=copia%10;
                                copia=copia/10;
                            }else if (i==5) {
                                mese+=(copia%10)*10;
                            }else {
                                copia=copia/10;
                            }

                        }
                        return mese;
                    }

                    //prende i primi 2 numeri
                    private static int Giorno(int copia){
                        int giorno=0;
                        for (int i=0;i<8;i++){
                            if (i==6){
                                giorno=copia%10;
                                copia=copia/10;
                            }else if (i==7) {
                                giorno+=(copia%10)*10;
                            }else {
                                copia=copia/10;
                            }
                        }
                        return giorno;
                    }
                 private static void ClrScr(){
                    try {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
}

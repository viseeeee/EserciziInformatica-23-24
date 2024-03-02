import java.util.Scanner;

public class gestioneData2 {
            public static void main(String[] args) {
                int data;
                int mese;
                int copia;
                int giorno;
                int anno = 0;
                Scanner keyboard=new Scanner(System.in);

                //inserimento della data
                System.out.println("inserisci la data(ggmmaaaa)");
                data=keyboard.nextInt();

                //pongo copia uguale a data
                copia=data;

                //attribuisce il giorno,il mese e l'anno alla cifra
                anno=Anno(copia);
                mese=Mese(copia);
                giorno=Giorno(copia);

                //mese scritto sotto forma di stringa
                System.out.println("giorno="+giorno);
                switch (mese){
                    case 1-> System.out.println("mese=GENNAIO");
                    case 2-> System.out.println("mese=FEBBRAIO");
                    case 3-> System.out.println("mese=MARZO");
                    case 4-> System.out.println("mese=APRILE");
                    case 5-> System.out.println("mese=MAGGIO");
                    case 6-> System.out.println("mese=GIUGNO");
                    case 7-> System.out.println("mese=LUGLIO");
                    case 8-> System.out.println("mese=AGOSTO");
                    case 9-> System.out.println("mese=SETTEMBRE");
                    case 10-> System.out.println("mese=OTTOBRE");
                    case 11-> System.out.println("mese=NOVEMBRE");
                    case 12-> System.out.println("mese=DICEMBRE");
                }
                System.out.println("anno="+anno);
            }

            //separa le prime 4 cifre dal numero
            public static int Anno(int copia){
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
            public static int Mese(int copia){
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

            //prende il quarto e il quinto numero
            public static int Giorno(int copia){
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
        }


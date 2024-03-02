import java.util.Scanner;
public class gestioneData1 {
    public static void main(String[] args) {
        int data;
        int mese;
        int copia;
        int giorno;
        int anno;
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

            //data in giorno mese e anno
            System.out.println("giorno="+giorno);
            System.out.println("mese="+mese);
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


    //prende il numero quarto e il quinto numero
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

    //prende i primi 2 numeri
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

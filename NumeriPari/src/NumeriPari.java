import java.util.Scanner;
public class NumeriPari {

    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        int NumeriInseriti;
        int Numero1=0,Numero2=0,Numero3=0,Numero4=0,Numero5=0;
        int Numero=0, pari=0;
        int resto;
       do {
           System.out.println("inserisci il numero");
           NumeriInseriti= keyboard.nextInt();
           resto=NumeriInseriti%2;
           Numero++;
            if (resto==0){
                pari++;
                if(pari==1){
                    Numero1=NumeriInseriti;
                }
                if(pari==2){
                    Numero2=NumeriInseriti;
                }
                if(pari==3){
                    Numero3=NumeriInseriti;
                }
                if(pari==4){
                    Numero4=NumeriInseriti;
                }
                if(pari==5){
                    Numero5=NumeriInseriti;
                }

            }
        } while (pari<5);
        System.out.println("sono stai inseriti: "+ Numero);
        System.out.println("i numeri sono:"+ Numero1 +","+Numero2 +","+Numero3 +","+Numero4 +","+Numero5 +",");

    }
}

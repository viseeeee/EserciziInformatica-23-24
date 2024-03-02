import java.util.Scanner;
//Visentin Luca cl.3E 21/2/2024
public class Main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        String[] sequenza1;
        String[] sequenza2;
        int uguali;
        //inserimento delle stringhe
        System.out.println("inserisci nella prima sequenza(premi invio per inserira la stringa successiva)");
        sequenza1=inserimento(keyboard);
        System.out.println("inserisci nella serconda sequenza(premi invio per inserira la stringa successiva)");
        sequenza2=inserimento(keyboard);
        //verifica delle stringhe uguali tramire il metodo
        uguali=verifica(sequenza1,sequenza2);

        //visualizzazione in output
        if (uguali>=1){
            System.out.println("OK");
        }else {
            System.out.println("NO");
        }
    }
    //inserimento delle stringhe
    private static String[] inserimento(Scanner keyboard){
        //inizializzazione array
        String[] sequenza=new String[5];
        // for per l'inserimento delle stringhe
        for (int i=0;i<sequenza.length;i++){
            sequenza[i]= keyboard.next();
        }
        return sequenza;
    }


    //metodo per la verifica delle strighe uguali
    private static int verifica(String[] sequenza1,String[] sequenza2){
        //inizializzazione delle stringhe uguali
        int uguali=0;
        //for che servono per controllare tra i 2 array
        for (int i=0;i< sequenza1.length;i++){
            for (int k=0;k<sequenza2.length;k++){
                if (sequenza1[i].equals(sequenza2[k])){
                    //se almeno una stringa è uguale il metodo si termina e con lui anche il controllo
                    uguali++;
                    break;
                }
                //mette dei valori a k e i in modo che si esca dal for e termini il metodo
                if (uguali==1){
                    k=20;
                    i=20;
                }
            }
        }
        return uguali;
    }
}
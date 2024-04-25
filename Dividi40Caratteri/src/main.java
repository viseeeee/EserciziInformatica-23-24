import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //dichiarazione scanner
        Scanner keyboard=new Scanner(System.in);

        //dividere la stringa al 40esimo carattere finenedo la sua parola
        String frase;
        System.out.println("Inserisci la frase");
        frase=keyboard.nextLine();
        if (frase.length()<40){
            System.out.println("Hai inserito una frase che ha meno di 40 caratteri");
        } else if (frase.length()>80) {
            System.out.println("Hai inserito una frase troppo lunga, deve avere meno di 80 caratteri");
        } else {
            //40 esimo carattere della stringa
            String fraseQuaranta = "";

            //booleano che serve per uscire dal ciclo
            boolean spazio=false;

            //iterazione di i
            for (int i=0;i< frase.length() && !spazio;i++){
                //è una stringa vuota che aggiunge in singolo carattere all'interno di essa
                fraseQuaranta+=frase.charAt(i);

                //se si supera il 40 esimo carattere e si incontra uno spazio si esce dal for
                if(i>40 && frase.charAt(i)==' '){
                    spazio=true;
                }
            }
            System.out.println("La frase è:");
            System.out.println(fraseQuaranta);
        }



    }
}

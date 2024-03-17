import java.util.Scanner;
public class GiorniOreMInuti {
    public static void main(String[] args) {
        //Inserire un numero intero che rappresenta i secondi trascorsi dall’inizio di oggi e mostra in
        //uscita l’ora attuale espressa in hh:mm:ss (ore:minuti:secondi).
        //Se l’utente inserisce un valore nullo o un valore superiore ad un giorno chiedere il
        //reinserimento.
        Scanner keyboard = new Scanner(System.in);
        int input;
        int ore, minuti, giorni,secondi;
        //indiserimento dei secondi da convertire
        System.out.println("inserisci il numero dei secondi da convertire a giorni,ore,minuti e secondi");
        input= keyboard.nextInt();
            secondi=input;
            ore=input;
            minuti=input;
            giorni=input;
            giorni=giorni/86400;
            ore=ore%86400/3600;
            minuti=minuti%86400%3600/60;
            secondi=secondi%86400%3600%60;
        System.out.println("giorni: "+giorni+" ore:"+ore+" minuti:"+minuti+" secondi:"+secondi);
    }
}

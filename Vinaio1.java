import java.util.Scanner;

public class Vinaio1{
    public static void main(String[] args){

    Scanner keyboard=new Scanner(System.in);
    int Numero;
    int iva;
    double capacita;
    double prezzoTot,ivaTot,totale;

        System.out.println("quanti bottiglioni vuoi?");
        Numero=keyboard.nextInt();
       while (Numero<0) {
        System.out.println("reinsertisci il numero di bottiglioni che vuoi");
        Numero=keyboard.nextInt();
    }
    iva=21;
    capacita=1.5;
    prezzoTot=Numero*capacita;
    System.out.println("il costo totale senza inva è di: " +prezzoTot);
    ivaTot=(prezzoTot/100)*iva;
    System.out.println("il costo dell'iva è di: "+ivaTot);
    totale=ivaTot+prezzoTot;
    System.out.println("il costo totale è di: "+totale);


}
}
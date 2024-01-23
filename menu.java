import java.util.Scanner;
public class menu {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int scelta=0;
        String [] opzioni = {"=== Gioco Dadi === ", "[1]-Sfida tra due giocatori", "[2] Sfida contro il computer", "[3] Exit "};

        System.out.println(Menu(opzioni, tastiera));
        Wait(5000);

    }

    private static int Menu (String opzioni[], Scanner tastiera)
    {
        int scelta;

        do {
            ClrScr();
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);
            }
            scelta = tastiera.nextInt();

            if ((scelta < 1 ) || (scelta > opzioni.length -1 ))
            {
                System.out.println("Opzione Sbagliata");
                Wait(2000);
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length -1 ));

        return 0;
    }

    private static void ClrScr(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int attesa) {
        try{
            Thread.sleep(attesa);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

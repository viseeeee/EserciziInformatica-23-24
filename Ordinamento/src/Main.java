public class Main {
    public static void main(String[] args) {
        int[] inserito={
                76,	68	,67,72,	41,	64,	60,	48,	40,	16
        };
        int[] inserito2={
                76,	68	,67,72,	41,	64,	60,	48,	40,	16
        };
        bubble(inserito2);
        selection(inserito);
        for (int i=0;i<inserito.length;i++) {
            System.out.println(inserito2[i]);
        }
        for (int i=0;i<inserito.length;i++) {
            System.out.println(inserito[i]);
        }
    }
    private static void selection(int[] inserito){
        int minore;
        int posizione=0;
        int volte=0;
        for (int i=0;i<inserito.length;i++){
            minore=inserito[i];
            for (int j=1;j<inserito.length;j++){
                if (minore>inserito[j]){
                    minore=inserito[j];
                    posizione=j;
                }
            }
            inserito[posizione]=inserito[volte];
            inserito[volte]=minore;
            volte++;
        }
    }
    private static void bubble(int[] inserito){
        int temp=0;
        for (int i=0;i< inserito.length-1;i++){
            for (int j=i+1;j< inserito.length;j++){
                if (inserito[i]>inserito[j]){
                    temp=inserito[i];
                    inserito[i]=inserito[j];
                    inserito[j]=temp;
                }
            }
        }
    }
}
public class main {
    public static void main(String[] args) {
        int inserimento[] = {5,8,0,1,4,2,4,3,9,7};
        int inserimento2[] = {5,8,0,1,4,2,4,3,9,7};
        int volte=Bubble(inserimento);
        int volte2=Selection(inserimento2);
        System.out.println(volte);
        System.out.println(volte2);

    }
    private static int Selection(int[] inserimento){
        int minore;
        int posizione;
        int volte=0;
        for (int i=0;i< inserimento.length;i++){
            minore=inserimento[i];
            posizione=i;
            volte+=3;
            for (int j=i+1;j< inserimento.length;j++){
                volte++;
                if (minore>inserimento[j]){
                    minore=inserimento[j];
                    posizione=j;
                    volte+=3;
                }
            }
            inserimento[posizione]=inserimento[i];
            inserimento[i]=minore;
            volte+=2;
        }
        return volte;
    }

    private static int Bubble(int[] inserimento){
        int temp;
        int volte=0;
        for (int i=0;i<inserimento.length-1;i++){
            volte++;
            for (int j=i+1;j<inserimento.length;j++){
                volte++;
                if (inserimento[i]>inserimento[j]){
                    volte+=4;
                    temp=inserimento[i];
                    inserimento[i]=inserimento[j];
                    inserimento[j]=temp;
                }
            }
        }
        return volte;
    }
}

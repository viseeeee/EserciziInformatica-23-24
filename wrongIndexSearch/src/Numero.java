public class Numero {
        public int numero1;
        public String operazione;
        public int numero2;
        public int risultato;


        public int getNumero1() {
                return numero1;
        }

        public void setNumero1(int numero1) {
                this.numero1 = numero1;
        }

        public String getOperazione() {
                return operazione;
        }

        public void setOperazione(String operazione) {
                this.operazione = operazione;
        }

        public int getNumero2() {
                return numero2;
        }

        public void setNumero2(int numero2) {
                this.numero2 = numero2;
        }

        public int setRisultato(){
                switch (operazione) {
                        case "+":
                                risultato = numero1 + numero2;
                                break;
                        case "-":
                                risultato = numero1 - numero2;
                                break;
                        case "*":
                                risultato = numero1 * numero2;
                                break;
                }
                return risultato;
        }
        public int getRisultato() {
                return risultato;
        }
}

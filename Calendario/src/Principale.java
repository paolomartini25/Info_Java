public class Principale {
    CLInput cli;
    Somma s;
    Differenza d;

    public Principale() {
        this.cli = new CLInput();
    }

    public void svolgi() {
        int scelta;//contirne la scelta tra il sommare o il sottrarre. 0 = +; 1 = -.
        /*
        giorno contiene il giorno delladata inserita dall'utente
        mese contiene il mese della data inserita dall'utente
        anno cotiene l'anno dela data inserita dall'utente
         */
        int giorno = this.cli.readInteger("Inserire il giorno della data"), mese = this.cli.readInteger("Inserire il mese della data"), anno = this.cli.readInteger("Inserire l'anno della data");

        do {
            scelta = this.cli.readInteger("Inserire 0 se vuoi sommare, Inserire 1 se vuoi sottrarre"); //richiedo in input la scelta
            if (scelta!=0&&scelta!=1){ //se il numero inserito dall'utente non è 0 o 1:
                System.out.println("Errore, devi inserire o 0 o 1.");
            }
        }while(scelta!=0&&scelta!=1); //se il numero inserito dall'utente non è 0 o 1 reinserisci la scelta

        if(scelta == 0){ //se viene scelto di sommare:
            try {//se non c'è un eccezione:
                s = new Somma(giorno, mese, anno);
                s.aggiungiGiorni(this.cli.readInteger("Inserire i giorni da sommare alla data"));
                System.out.println("La data risultante è: " + s.getGiorno() + "/" + s.getMese() + "/" + s.getAnno());//viene stampata la data risultante
            } catch (Exception e) { //se c'è un eccezione:
                System.out.println(e.getMessage());
            }
        }
        else { //se viene scelto di sottrarre:
            try { //se non c'è un eccezione:
                d = new Differenza(giorno, mese, anno);
                d.sottraiData(this.cli.readInteger("Inserire il giorno della seconda data"), this.cli.readInteger("Inserire il mese della seconda data"), this.cli.readInteger("Inserire l'anno della seconda data"));
                System.out.println("Il numero di giorni e': " + d.getNGiorni());
            } catch (Exception e) { //se c'è un eccezione:
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Principale p = new Principale();
        p.svolgi();// viene svolto il programma
    }
}

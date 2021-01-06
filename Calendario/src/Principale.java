public class Principale {
    CLInput cli;
    Somma s;
    Differenza d;

    public Principale() {
        this.cli = new CLInput();
    }

    public void svolgi() {
        int scelta;

        do {
            scelta = this.cli.readInteger("Inserire 0 se vuoi sommare, Inserire 1 se vuoi sottrarre");
            if (scelta!=0&&scelta!=1){
                System.out.println("Errore, devi inserire o 0 o 1.");
            }
        }while(scelta!=0&&scelta!=1);

        if(scelta == 0){
            try {
                s = new Somma(this.cli.readInteger("Inserire il giorno della data"), this.cli.readInteger("Inserire il mese della data"), this.cli.readInteger("Inserire l'anno della data"), this.cli.readInteger("Inserire i giorni da sommare alla data"));
                System.out.println("La data risultante è: " + s.getGiorno() + "/" + s.getMese() + "/" + s.getAnno());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {

            try {
                d = new Differenza(this.cli.readInteger("Inserire il giorno della prima data"), this.cli.readInteger("Inserire il mese della prima data"), this.cli.readInteger("Inserire l'anno della prima data"), this.cli.readInteger("Inserire il giorno della seconda data"), this.cli.readInteger("Inserire il mese della seconda data"), this.cli.readInteger("Inserire l'anno della seconda data"));
                System.out.println("Il numero di giorni e': " + d.getNGiorni());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public static void main(String[] args) {
        Principale p = new Principale();
        p.svolgi();
    }
}

public class Somma {
    int giorno;
    int mese;
    int anno;
    boolean bisestile = false;
    int num;

    public static final int GIORNO_INIZIO = 1;
    public static final int ANNO_0 = 0;
    public static final int MESE_INIZIO = 1;
    public static final int MESE_FINE = 12;
    public static final int MIN_NUM = 0;

    public Somma(int giorno, int mese, int anno) throws Exception {
        //vengono settati giorno, mese ed anno della data
        this.setAnno(anno);
        this.setMese(mese);
        this.setGiorno(giorno, controlloMese(mese, anno));
    }
    public void aggiungiGiorni(int num) throws Exception{
        //viene settato il numero
        this.setNum(num);

        int gmese; //è il numero di giorni che ha il mese
        int app; //è una variabile d'appoggio per fare in modo che il valore di this.num non vada perso
        do{

            gmese = controlloMese(this.mese, this.anno); //gmese = numero di giorni del mese
            /*
            gmese-this.giorno: al numero di giorni che ha il mese viene sottratto il numero di giorni della data in modo che rimangano solamente i giorni mancanto
            this.num - (gmese-this.giorno): al numero da sommare viene sottratto i giorni mancanti alla fine del mese
             */
            app = this.num - (gmese-this.giorno);

            if (app <= 0){ //se l'appoggio è minore o uguale a 0:
                this.giorno = this.num; //il numero di giorni è uguale ai giorni da sommare perchè il giorno della data è uguale a 0
            }
            else { //se l'appoggio è maggiore di 0:
                this.num = app;
                this.mese++; //si passa al mese successivo

                if (this.mese > MESE_FINE) { //se finisce l'ultimo mese
                    this.mese = 1; //si riorna al primo mese
                    this.anno++; //si passa all'anno successivo
                }

                this.giorno = 0; //i giorni della data vanno a 0 dato che manca l'intero mese alla fine del mese e verrebbe sottrato ogni volta 1 alla fine del mese

            }
        }while(app > 0);

    }

    public void setGiorno(int giorno, int var) throws Exception {
        //var contiene il numero di giorni che ci sono nel mese
        if(giorno < GIORNO_INIZIO || giorno > var)  //se il numero di giorni non è compreso tra 1 e il numero di giorni che ci sono nel mese vene generata l'eccezione
            throw new Exception("Hai insrito un giorno impossibile");
        this.giorno = giorno;
    }
    public void setMese(int mese) throws Exception {
        if(mese < MESE_INIZIO || mese > MESE_FINE) //se il mese non è compreso tra 1 e 12 viene generata l'eccezione
            throw new Exception("Il mese che hai inserito è impossibile");
        this.mese = mese;
    }
    public void setAnno(int anno) throws Exception {
        if(anno < ANNO_0) //se l'anno è minore di 0
            throw new Exception("la Data che hai inserito è prima dell'anno 0");
        this.anno = anno;
    }

    public void setNum(int num) throws Exception {
        if(num < MIN_NUM) //se il numero è minore di 0
            throw new Exception("Il numero che hai inserito è minore di 0");
        this.num = num;
    }

    public int getGiorno() {
        return this.giorno;
    }

    public int getMese() { return this.mese; }

    public int getAnno() { return this.anno; }

    public int controlloMese(int mese, int anno){
        //controllo mese serve per contare i giorni che possiende il mese perso in esame
        int var = 31;

        if ((anno % 100) % 4 == 0) bisestile = true; //se l'anno è bisestile: bisestile è vero

        if (mese == 4 || mese == 6 || mese == 9 || mese == 11) var = 30; //se mese è uguale a 4 o 6 o 9 o a 11 il numero di giorni è uguale a 30
        else if (mese == 2) { //oppure se il mese è uguale a 2
            var = 28; //il numero di giorni è uguale a 28
            if (bisestile) { //se l'anno è bisestile
                var++; //il numero di giorni diviene 29
            }
        }

        bisestile = false; //bisestile viene settato a falso

        return var; //viene ritornato il numero di mesi
    }
}

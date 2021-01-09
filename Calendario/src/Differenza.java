public class Differenza {
    int giorno1, mese1, anno1; //giorno, mese ed anno della prima data
    int giorno2, mese2, anno2; //giorno, mese ed anno della seconda data
    boolean bisestile = false; //bolleano che segna se l'anno è bisestile o meno
    int ngiorni; //risultato della differenza

    public static final int GIORNO_INIZIO = 1;
    public static final int ANNO_0 = 0;
    public static final int MESE_INIZIO = 1;
    public static final int MESE_FINE = 12;

    public Differenza(int giorno1, int mese1, int anno1) throws Exception {
        //vengono settati giorno, mese ed anno della prima data
        this.setAnno1(anno1);
        this.setMese1(mese1);
        this.setGiorno1(giorno1, controlloMese(mese1, anno1));
    }

    public void sottraiData(int giorno2, int mese2, int anno2) throws Exception {
        //vengono settati giorno, mese ed anno della seconda data
        this.setAnno2(anno2);
        this.setMese2(mese2);
        this.setGiorno2(giorno2, controlloMese(mese2, anno2));

        piuGrande(); //viene controllata quale delle due date è la più grande, la più grande vene messa nella data "1" la più piccola nella data "2"

        //vengono contati i numeri di giorni di differenza
        this.ngiorni = (this.giorno1 - this.giorno2) + contaMese(this.mese1, this.mese2) + contaAnno(this.anno1, this.anno2);
    }

    public void setGiorno1(int giorno, int var) throws Exception {
        //var contiene il numero di giorni che ci sono nel mese
        if(giorno < GIORNO_INIZIO || giorno > var)  //se il numero di giorni non è compreso tra 1 e il numero di giorni che ci sono nel mese vene generata l'eccezione
            throw new Exception("Hai insrito un giorno impossibile");
        this.giorno1 = giorno;
    }
    public void setMese1(int mese) throws Exception {
        if(mese < MESE_INIZIO || mese > MESE_FINE) //se il mese non è compreso tra 1 e 12 viene generata l'eccezione
            throw new Exception("Il mese che hai inserito è impossibile");
        this.mese1 = mese;
    }
    public void setAnno1(int anno) throws Exception {
        if(anno < ANNO_0) //se l'anno è minore di 0
            throw new Exception("la Data che hai inserito è prima dell'anno 0");
        this.anno1 = anno;
    }

    public void setGiorno2(int giorno, int var) throws Exception {
        if(giorno < GIORNO_INIZIO || giorno > var) //se il numero di giorni non è compreso tra 1 e il numero di giorni che ci sono nel mese vene generata l'eccezione
            throw new Exception("Hai insrito un giorno impossibile");
        this.giorno2 = giorno;
    }
    public void setMese2(int mese) throws Exception {
        if(mese < MESE_INIZIO || mese > MESE_FINE) //se il mese non è compreso tra 1 e 12 viene generata l'eccezione
            throw new Exception("Il mese che hai inserito è impossibile");
        this.mese2 = mese;
    }
    public void setAnno2(int anno) throws Exception {
        if(anno < ANNO_0) //se l'anno è minore di 0
            throw new Exception("la Data che hai inserito è prima dell'anno 0");
        this.anno2 = anno;
    }

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

    public int contaAnno(int anno1, int anno2){
        //conta i giorni che ci sono tra l'anno2 e l'anno1, non comprende i giorni dell'anno1
        int giorni = 0;

        for(int i = anno2; i < anno1; i++){ //il for gira fino a quando il contatore degli anni è minore del primo anno, il contatore degli anni parte dal secondo anno inserito
            if ((i % 100) % 4 == 0) giorni+=366; //se l'anno è bisestile al numero di giorni viene aggiunto 366
            else giorni+=365; //se l'anno non è bisestile al numero di giorni viene aggiunto 365
        }
        return giorni; //viene ritornato il numero di giorni
    }

    public int contaMese(int mese1, int mese2){
        //conta la differenza di giorni tra il mese del primo anno e il mese del secondo anno
        int giornim1 = 0;
        int giornim2 = 0;

        for(int i = MESE_INIZIO; i < mese1; i++){ //conta tutti i giorni dall'inizio dell'anno1 fino al mese1 non compreso
            giornim1 += controlloMese(i, this.anno1); //viene aggiunto il numero di giorni del i mese

        }

        for(int i = MESE_INIZIO; i < mese2; i++){ //conta tutti i giorni dall'inizio dell'anno2 fino al mese2 non compreso
            giornim2 += controlloMese(i, this.anno2); //viene aggiunto il numero di giorni del i mese
        }

        return giornim1 - giornim2; //viene ritornato la differenza tra i giorni dell'anno1 e dell'anno2
    }
    public void piuGrande(){
        //viene controllata quale delle due date è la più grande, la più grande vene messa nella data "1" la più piccola nella data "2"

        if (this.anno2 > this.anno1){
            int variabile = this.anno1;
            this.anno1 = this.anno2;
            this.anno2 = variabile;
            variabile = this.mese1;
            this.mese1 = this.mese2;
            this.mese2 = variabile;
            variabile = this.giorno1;
            this.giorno1 = this.giorno2;
            this.giorno2 = variabile;
        }
        else if(this.anno2 == this.anno1){
            if (this.mese2 > this.mese1){
                int variabile = this.mese1;
                this.mese1 = this.mese2;
                this.mese2 = variabile;
                variabile = this.giorno1;
                this.giorno1 = this.giorno2;
                this.giorno2 = variabile;
            }
            else if(this.mese2 == this.mese1){
                if (this.giorno2 > this.giorno1){
                    int variabile = this.giorno1;
                    this.giorno1 = this.giorno2;
                    this.giorno2 = variabile;
                }
            }
        }
    }

    public int getNGiorni() {
        return this.ngiorni;
    }
}



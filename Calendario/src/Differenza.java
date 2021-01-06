public class Differenza {
    int giorno1, mese1, anno1;
    int giorno2, mese2, anno2;
    boolean bisestile = false;
    int ngiorni;
    public Differenza(int giorno1, int mese1, int anno1, int giorno2, int mese2, int anno2) throws Exception {

        this.setAnno1(anno1);
        this.setMese1(mese1);
        this.setGiorno1(giorno1, controlloMese(mese1, anno1));

        this.setAnno2(anno2);
        this.setMese2(mese2);
        this.setGiorno2(giorno2, controlloMese(mese2, anno2));

        piuGrande();

        this.ngiorni = (this.giorno1 - this.giorno2) + contaMese(this.mese1, this.mese2) + contaAnno(this.anno1, this.anno2);

    }

    public void setGiorno1(int giorno, int var) throws Exception {
        if(giorno < 0 || giorno > var)
            throw new Exception("Hai insrito un giorno impossibile");
        this.giorno1 = giorno;
    }
    public void setMese1(int mese) throws Exception {
        if(mese < 1 || mese > 12)
            throw new Exception("Il mese che hai inserito è impossibile");
        this.mese1 = mese;
    }
    public void setAnno1(int anno) throws Exception {
        if(anno < 0)
            throw new Exception("la Data che hai inserito è prima dell'anno 0");
        this.anno1 = anno;
    }

    public void setGiorno2(int giorno, int var) throws Exception {
        if(giorno < 0 || giorno > var)
            throw new Exception("Hai insrito un giorno impossibile");
        this.giorno2 = giorno;
    }
    public void setMese2(int mese) throws Exception {
        if(mese < 1 || mese > 12)
            throw new Exception("Il mese che hai inserito è impossibile");
        this.mese2 = mese;
    }
    public void setAnno2(int anno) throws Exception {
        if(anno < 0)
            throw new Exception("la Data che hai inserito è prima dell'anno 0");
        this.anno2 = anno;
    }

    public int controlloMese(int mese, int anno){
        int var = 31;

        if ((anno % 100) % 4 == 0) bisestile = true;

        if (mese == 4 || mese == 6 || mese == 9 || mese == 11) var = 30;
        else if (mese == 2) {
            var = 28;
            if (bisestile) {
                var++;
            }
        }

        bisestile = false;

        return var;
    }

    public int contaAnno(int anno1, int anno2){
        int giorni = 0;

        for(int i = anno2; i < anno1; i++){
            if ((i % 100) % 4 == 0) giorni+=366;
            else giorni+=365;
        }
        return giorni;
    }

    public int contaMese(int mese1, int mese2){
        int giornim1 = 0;
        int giornim2 = 0;

        for(int i = 1; i < mese1; i++){
            giornim1 += controlloMese(i, this.anno1);

        }

        for(int i = 1; i < mese2; i++){
            giornim2 += controlloMese(i, this.anno2);
        }

        return giornim1 - giornim2;
    }
    public void piuGrande(){
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



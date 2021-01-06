public class Somma {
    int giorno;
    int mese;
    boolean bisestile = false;
    int anno;
    int num;

    public Somma(int giorno, int mese, int anno, int num) throws Exception {
        this.setAnno(anno);

        this.setMese(mese);

        this.setGiorno(giorno, controlloMese(mese, anno));

        this.setNum(num);

        int gmese;
        int app;
        do{

            //gmese = controlloMese(this.mese, this.anno);
            //app -=gmese;
            gmese = controlloMese(this.mese, this.anno);
            app = this.num - (gmese-this.giorno);

            if (app <= 0){

                this.giorno = this.giorno + this.num;
                if (this.giorno>gmese){

                    this.mese++;

                    if (this.mese > 12) {
                        this.mese = 1;
                        this.anno++;
                    }
                    this.giorno -= gmese;
                }
            }
            else {
                this.num = app;
                this.mese++;

                if (this.mese > 12) {
                    this.mese = 1;
                    this.anno++;
                }

                this.giorno = 0;

            }
        }while(app > 0);
    }

    public void setGiorno(int giorno, int var) throws Exception {
        if(giorno < 0 || giorno > var)
            throw new Exception("Hai insrito un giorno impossibile");
        this.giorno = giorno;
    }
    public void setMese(int mese) throws Exception {
        if(mese < 1 || mese > 12)
            throw new Exception("Il mese che hai inserito è impossibile");
        this.mese = mese;
    }
    public void setAnno(int anno) throws Exception {
        if(anno < 0)
            throw new Exception("la Data che hai inserito è prima dell'anno 0");
        this.anno = anno;
    }
    public void setNum(int num) throws Exception {
        if(num < 0)
            throw new Exception("Il numero che hai inserito è minore di 0");
        this.num = num;
    }

    public int getGiorno() {
        return this.giorno;
    }

    public int getMese() {
        return this.mese;
    }

    public int getAnno() {
        return this.anno;
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
}

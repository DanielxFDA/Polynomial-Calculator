package model;

public class Monom {
    private int coeficient;
    private int putere;
    private int numitor;


    public Monom(int coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
        this.numitor = 1;
    }

    public Monom() {

    }

    public String toString() {
        String result = "";
        if (this.coeficient == 0 && this.putere == 0) {
            result = " ";
        }
        if (this.coeficient > 0 && this.putere != 0) {
            if (this.coeficient == 1) {
                if (this.putere == 1)
                    result = "" + "+x";
                else
                    result = "" + "+x^" + this.putere;
            } else if (this.coeficient > 0 && this.putere == 1) {
                result = "" + "+" + this.coeficient + "x";
            } else
                result = "" + "+" + this.coeficient + "x^" + this.putere;
        } else if (coeficient < 0 && this.putere != 0) {
            if (this.coeficient == -1) {
                if (this.putere == 1)
                    result = "" + "-x";
                else
                    result = "" + "-x^" + this.putere;
            } else if (this.coeficient < 0 && this.putere == 1) {
                result = "" + this.coeficient + "x";
            } else
                result = "" + this.coeficient + "x^" + this.putere;

        } else if (this.coeficient > 0 && this.putere == 0) {
            result = "" + "+" + this.coeficient;
        } else if (this.coeficient < 0 && this.putere == 0) {
            result = "" + this.coeficient;
        }

        if (this.numitor != 1) {
            String temp = result;
            if (temp.indexOf('x') != -1) {
                if (temp.charAt(0) == '+' && temp.charAt(1) == 'x') {
                    result = "" + temp.substring(0, temp.indexOf('x')) + "1/" + this.numitor + temp.substring(temp.indexOf('x'));
                } else if (temp.charAt(0) == '-' && temp.charAt(1) == 'x') {
                    result = "" + temp.substring(0, temp.indexOf('x')) + "1/" + this.numitor + temp.substring(temp.indexOf('x'));

                } else {
                    result = "" + temp.substring(0, temp.indexOf('x')) + "/" + this.numitor + temp.substring(temp.indexOf('x'));

                }
            }
        }


        return result;
    }

    public void setCoeficient(int coef) {
        this.coeficient = coef;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public int getPutere() {
        return this.putere;
    }

    public int getCoeficient() {
        return this.coeficient;
    }

    public void setNumitor(int numitor) {
        this.numitor = numitor;
    }

    public int getNumitor() {
        return this.numitor;
    }

}
package model;

import java.util.*;

public class Polinom {
    List<Monom> monomList;

    public Polinom() {
        this.monomList = new ArrayList<Monom>();
    }


    public void addMonom(Monom e) {
        this.monomList.add(e);
    }

    public void polinomialSort() {
        Collections.sort(this.monomList, new Comparator<Monom>() {
            public int compare(Monom m1, Monom m2) {
                return m2.getPutere() - m1.getPutere();
            }
        });

    }

    public static Polinom addPolynomials(Polinom p1, Polinom p2) {
        Polinom tempResult = new Polinom();
        Polinom result = new Polinom();
        for (Monom var : p1.monomList) {
            tempResult.addMonom(var);
        }
        for (Monom var : p2.monomList) {
            tempResult.addMonom(var);
        }
        tempResult.polinomialSort();
        int pow = tempResult.getMaxPow();
        int coef = 0;
        while (pow >= 0) {
            coef = 0;
            for (Monom var : tempResult.monomList) {
                if (var.getPutere() == pow) {
                    coef += var.getCoeficient();
                }
                if (pow > var.getPutere()) {
                    break;
                }
            }
            if (coef != 0) {
                result.addMonom(new Monom(coef, pow));
            }
            pow--;
        }
        return result;
    }

    public static Polinom substractPolynomials(Polinom p1, Polinom p2) {
        Polinom tempP2 = new Polinom();
        for (Monom var : p2.monomList) {
            tempP2.addMonom(new Monom(var.getCoeficient() * (-1), var.getPutere()));
        }
        Polinom result = Polinom.addPolynomials(p1, tempP2);
        return result;

    }

    public static Polinom derivePolynomial(Polinom p) {
        Polinom px = new Polinom();
        px.addMonom(new Monom(0, 0));
        Polinom result = Polinom.addPolynomials(p, px);
        for (Monom var : result.monomList) {
            var.setCoeficient(var.getCoeficient() * var.getPutere());
            var.setPutere(var.getPutere() - 1);
        }
        return result;
    }

    public static Polinom integratePolynomial(Polinom p) {
        Polinom px = new Polinom();
        px.addMonom(new Monom(0, 0));
        Polinom result = Polinom.addPolynomials(p, px);
        for (Monom var : result.monomList) {
            var.setPutere(var.getPutere() + 1);
            var.setNumitor(var.getPutere());
        }
        return result;
    }

    public static Polinom multiplicatePolynomial(Polinom p1, Polinom p2) {
        Polinom px = new Polinom();
        px.addMonom(new Monom(0, 0));
        Polinom pol1 = Polinom.addPolynomials(p1, px);
        Polinom pol2 = Polinom.addPolynomials(p2, px);
        Polinom result = new Polinom();
        int newCoef = 0, newPow = 0;
        for (Monom var1 : pol1.monomList) {
            for (Monom var2 : pol2.monomList) {
                newCoef = var1.getCoeficient() * var2.getCoeficient();
                newPow = var1.getPutere() + var2.getPutere();
                Monom tempM = new Monom(newCoef, newPow);
                result.addMonom(tempM);
            }

        }
        result = Polinom.addPolynomials(result, px);
        return result;
    }

    public static List<Polinom> dividePolynomials(Polinom p1, Polinom p2) {
        Polinom px = new Polinom();
        px.addMonom(new Monom(0, 0));
        Polinom n = Polinom.addPolynomials(p1, px);
        Polinom d = Polinom.addPolynomials(p2, px);
        Polinom q = new Polinom();
        List<Polinom> resultList = new ArrayList<Polinom>();
        q.addMonom(new Monom(0, 0));
        Polinom r = n;
        if (n.getMaxPow() < d.getMaxPow()) {
            q.addMonom(new Monom(0, 0));
            r = n;
            resultList.add(q);
            resultList.add(r);
            return resultList;
        }
        if (n.monomList.get(0).getCoeficient() == 0) {
            return null;
        }

        Polinom tempT = new Polinom();
        int newCoef = 0, newPow = 0, newNum = 0;
        while (!r.monomList.isEmpty() && r.getMaxPow() >= d.getMaxPow()) {
            newCoef = r.monomList.get(0).getCoeficient();
            newNum = d.monomList.get(0).getCoeficient();
            newPow = r.monomList.get(0).getPutere() - d.monomList.get(0).getPutere();
            tempT.addMonom(new Monom(newCoef / newNum, newPow));
            q = Polinom.addPolynomials(q, tempT);
            Polinom tempXD = new Polinom();
            tempXD.addMonom(new Monom(newCoef / newNum, newPow));
            tempXD = Polinom.multiplicatePolynomial(tempXD, d);
            r = Polinom.substractPolynomials(r, tempXD);
            tempT.freePolinom();
            tempXD.freePolinom();
        }

        resultList.add(q);
        resultList.add(r);
        return resultList;
    }

    public String toString() {
        String result = "";
        boolean ok = false;
        for (Monom var : monomList) {
            if (!ok && var.toString().charAt(0) == '+') {
                result += var.toString().substring(1);

            } else
                result = result + var.toString();
            ok = true;
        }
        return result;
    }

    public void freePolinom() {
        this.monomList.clear();
    }

    public int getMaxPow() {
        return this.monomList.get(0).getPutere();
    }


}

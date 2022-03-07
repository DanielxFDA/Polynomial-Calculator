package controller;

import model.Monom;
import model.Polinom;
import view.CalcView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private CalcView view;
    private Monom monom;
    private Polinom polinom1;
    private Polinom polinom2;

    public Controller(CalcView view, Polinom polinomModel1, Polinom polinomModel2) {
        this.view = view;
        this.polinom1 = polinomModel1;
        this.polinom2 = polinomModel2;
        view.setVisible(true);
        final String[] p1 = {new String()};
        final String[] p2 = {new String()};

        //get the monomials from the first polynomial
        this.view.addtextFieldPolinom1Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polinom1.freePolinom();
                p1[0] = view.getPolinom1();
                Pattern pattern = Pattern.compile("([+-]?+(?:(?:\\d+(?:[x]|(?:\\*[x]))(?:(?:\\^[1-9]\\d*+)|(?:\\^[0]))?+)" +
                        "|(?:(?:[x])(?:(?:\\^[1-9]\\d*+)|(?:\\^[0]))?+)|\\d+))");
                Matcher matcher = pattern.matcher(p1[0]);
                while (matcher.find()) {
                    String temp = matcher.group(1);
                    Monom monom = getMonomialFromString(temp);
                    polinom1.addMonom(monom);
                }
                polinom1.polinomialSort();
            }
        });

        //get the monomials from the second polynomial
        this.view.addtextFieldPolinom2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polinom2.freePolinom();
                p2[0] = view.getPolinom2();
                Pattern pattern = Pattern.compile("([+-]?+(?:(?:\\d+(?:[x]|(?:\\*[x]))(?:(?:\\^[1-9]\\d*+)|(?:\\^[0]))?+)" +
                        "|(?:(?:[x])(?:(?:\\^[1-9]\\d*+)|(?:\\^[0]))?+)|\\d+))");
                Matcher matcher = pattern.matcher(p2[0]);
                while (matcher.find()) {
                    String temp = matcher.group(1);
                    Monom monom = getMonomialFromString(temp);
                    polinom2.addMonom(monom);
                }
                polinom2.polinomialSort();
            }
        });

        //addition operation
        this.view.addBtnAddListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom result;
                result = Polinom.addPolynomials(polinom1, polinom2);
                view.setTextResult(result.toString());

            }
        });

        //substraction operation
        this.view.addBtnSubstractListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom result;
                result = Polinom.substractPolynomials(polinom1, polinom2);
                System.out.println(polinom1.toString() + " " + polinom2.toString());
                view.setTextResult(result.toString());

            }
        });

        //derivative operation
        this.view.addBtnDeriveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom result;
                result = Polinom.derivePolynomial(polinom1);
                view.setTextResult(result.toString());
            }
        });

        this.view.addBtnIntegrateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom result;
                result = Polinom.integratePolynomial(polinom1);
                view.setTextResult(result.toString());
            }
        });

        this.view.addBtnMultiplicateListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom result;
                result = Polinom.multiplicatePolynomial(polinom1, polinom2);
                view.setTextResult(result.toString());
            }
        });

        this.view.addBtnDivideListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Polinom> result = new ArrayList<>();
                result = Polinom.dividePolynomials(polinom1, polinom2);
                view.setTextResult("Q:" + result.get(0).toString() + " R: " + result.get(1).toString());
            }
        });
    }

    public Monom getMonomialFromString(String temp) {
        Monom monom = new Monom();

        int sign = 0;
        int coef = 0;
        int pow = 0;
        if (temp.charAt(0) == '-') {
            sign = -1;
            if (temp.charAt(1) == 'x') {
                coef = -1;
            } else if (temp.indexOf('x') == -1) {
                coef = Integer.parseInt(temp.substring(1));
                coef = coef * sign;
                pow = 0;
            } else {
                coef = Integer.parseInt(temp.substring(1, temp.indexOf('x')));
                coef = coef * sign;
            }
        }
        if (temp.charAt(0) == '+') {
            sign = 1;
            if (temp.charAt(1) == 'x') {
                coef = 1;
            } else if (temp.indexOf('x') == -1) {
                coef = Integer.parseInt(temp.substring(1));
                coef = coef * sign;
                pow = 0;
            } else {
                coef = Integer.parseInt(temp.substring(1, temp.indexOf('x')));
                coef = coef * sign;
            }
        }
        if (temp.charAt(0) == 'x') {
            coef = 1;
            sign = 1;
        }
        if (Character.isDigit(temp.charAt(0)) && temp.charAt(0) != 'x') {
            sign = 1;
            if (temp.indexOf('x') == -1) {
                pow = 0;
                coef = Integer.parseInt(temp);
            } else
                coef = Integer.parseInt(temp.substring(0, temp.indexOf('x')));
        }
        if (temp.charAt(temp.length() - 1) == 'x') {
            pow = 1;
        } else if (temp.indexOf('x') != -1) {
            pow = Integer.parseInt(temp.substring(temp.indexOf('x') + 2, temp.length()));
        }

        monom.setCoeficient(coef);
        monom.setPutere(pow);
        monom.setNumitor(1);
        return monom;

    }
}

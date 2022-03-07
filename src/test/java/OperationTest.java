import model.Monom;
import model.Polinom;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationTest {
    @Test
    public void addTest() {
        Polinom p1 = new Polinom();
        p1.addMonom(new Monom(2, 3));
        p1.addMonom(new Monom(3, 4));
        p1.addMonom(new Monom(-6, 2));
        p1.addMonom(new Monom(3, 0));
        Polinom p2 = new Polinom();
        p2.addMonom(new Monom(3, 4));
        p2.addMonom(new Monom(5, 3));
        p2.addMonom(new Monom(1, 7));
        p2.addMonom(new Monom(-3, 0));
        Polinom result = Polinom.addPolynomials(p1, p2);
        assertEquals(result.toString(), "x^7+6x^4+7x^3-6x^2");
    }

    @Test
    public void substractTest() {
        Polinom p1 = new Polinom();
        p1.addMonom(new Monom(2, 3));
        p1.addMonom(new Monom(3, 4));
        p1.addMonom(new Monom(-6, 2));
        p1.addMonom(new Monom(3, 0));
        Polinom p2 = new Polinom();
        p2.addMonom(new Monom(3, 4));
        p2.addMonom(new Monom(5, 3));
        p2.addMonom(new Monom(1, 7));
        p2.addMonom(new Monom(-3, 0));
        Polinom result = Polinom.substractPolynomials(p1, p2);
        assertEquals(result.toString(), "-x^7-3x^3-6x^2+6");
    }

    @Test
    public void multiplicateTest() {
        Polinom p1 = new Polinom();
        p1.addMonom(new Monom(2, 3));
        p1.addMonom(new Monom(3, 4));
        p1.addMonom(new Monom(-6, 2));
        p1.addMonom(new Monom(3, 0));
        Polinom p2 = new Polinom();
        p2.addMonom(new Monom(3, 4));
        p2.addMonom(new Monom(5, 3));
        p2.addMonom(new Monom(1, 7));
        p2.addMonom(new Monom(-3, 0));
        Polinom result = Polinom.multiplicatePolynomial(p1, p2);
        assertEquals(result.toString(), "3x^11+2x^10-6x^9+9x^8+24x^7-8x^6-30x^5+9x^3+18x^2-9");
    }

    @Test
    public void deriveTest() {
        Polinom p1 = new Polinom();
        p1.addMonom(new Monom(2, 3));
        p1.addMonom(new Monom(3, 4));
        p1.addMonom(new Monom(-6, 2));
        p1.addMonom(new Monom(3, 0));
        Polinom result = Polinom.derivePolynomial(p1);
        assertEquals(result.toString(), "12x^3+6x^2-12x");
    }

    @Test
    public void integrateTest() {
        Polinom p1 = new Polinom();
        p1.addMonom(new Monom(2, 3));
        p1.addMonom(new Monom(3, 4));
        p1.addMonom(new Monom(-6, 2));
        p1.addMonom(new Monom(3, 0));
        Polinom result = Polinom.integratePolynomial(p1);
        assertEquals(result.toString(), "3/5x^5+2/4x^4-6/3x^3+3x");
    }

    @Test
    public void divideTest() {
        Polinom p1 = new Polinom();
        p1.addMonom(new Monom(2, 3));
        p1.addMonom(new Monom(3, 4));
        p1.addMonom(new Monom(-6, 2));
        p1.addMonom(new Monom(3, 0));
        Polinom p2 = new Polinom();
        p2.addMonom(new Monom(3, 4));
        p2.addMonom(new Monom(5, 3));
        p2.addMonom(new Monom(1, 7));
        p2.addMonom(new Monom(-3, 0));
        List<Polinom> result = Polinom.dividePolynomials(p1, p2);
        String resulttemp = "Q:" + result.get(0).toString() + " R: " + result.get(1).toString();
        assertEquals(resulttemp, "Q:   R: 3x^4+2x^3-6x^2+3");
    }


}

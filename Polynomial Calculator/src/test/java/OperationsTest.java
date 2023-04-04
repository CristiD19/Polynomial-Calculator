import model.Operations;
import model.Monomial;
import model.Polynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class OperationsTest {

    Operations operations = new Operations();

    @Test public void derivationTest(){

        Monomial m = new Monomial(3,2);
        Polynomial p = new Polynomial(List.of(m));
        Monomial m2 = new Monomial(6,1);
        Polynomial p2 = new Polynomial(List.of(m2));
        Assertions.assertEquals(p2,operations.derivative(p));
    }

    @Test public void addTest(){

        Monomial m = new Monomial(3,2);
        Monomial m1 = new Monomial(3,2);
        Polynomial p = new Polynomial(List.of(m));
        Polynomial p1 = new Polynomial(List.of(m1));
        Monomial m2 = new Monomial(6,2);
        Polynomial p2 = new Polynomial(List.of(m2));
        Assertions.assertEquals(p2,operations.add(p,p1));
    }

    @Test public void substractTest(){

        Monomial m = new Monomial(3,2);
        Monomial m1 = new Monomial(2,2);
        Polynomial p = new Polynomial(List.of(m));
        Polynomial p1 = new Polynomial(List.of(m1));
        Monomial m2 = new Monomial(1,2);
        Polynomial p2 = new Polynomial(List.of(m2));
        Assertions.assertEquals(p2,operations.substract(p,p1));
    }

    @Test public void multiplyTest(){

        Monomial m = new Monomial(3,2);
        Monomial m1 = new Monomial(2,2);
        Polynomial p = new Polynomial(List.of(m));
        Polynomial p1 = new Polynomial(List.of(m1));
        Monomial m2 = new Monomial(6,4);
        Polynomial p2 = new Polynomial(List.of(m2));
        Assertions.assertEquals(p2,operations.multiplication(p,p1));
    }

    @Test public void integrationTest(){

        Monomial m = new Monomial(3,2);
        Polynomial p = new Polynomial(List.of(m));
        Monomial m2 = new Monomial(1,3);
        Polynomial p2 = new Polynomial(List.of(m2));
        Assertions.assertEquals(p2,operations.integration(p));
    }

    @Test public void divideTest(){

        Monomial m = new Monomial(3,2);
        Polynomial p = new Polynomial(List.of(m));
        Monomial m2 = new Monomial(6,1);
        Polynomial p2 = new Polynomial(List.of(m2));
        Assertions.assertEquals(p2,operations.derivative(p));
    }
}

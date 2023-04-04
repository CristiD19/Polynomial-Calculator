package controller;

import model.Operations;
import model.Polynomial;
import view.CalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {

    private CalculatorView calculatorView;
    private Operations operations;

    public Controller(CalculatorView calculatorView, Operations operations){
        this.calculatorView = calculatorView;
        this.operations = operations;

        this.calculatorView.btnAddListener(new ActionListener() {

            String firstPolynomial;
            String secondPolynomial;

            @Override
            public void actionPerformed(ActionEvent e) {

                firstPolynomial = calculatorView.getFirstPolynomial();
                secondPolynomial = calculatorView.getSecondPolynomial();

                Polynomial p1 = operations.getPolynomial(firstPolynomial);
                Polynomial p2 = operations.getPolynomial(secondPolynomial);

                Polynomial result = operations.add(p1,p2);

                calculatorView.setResultPolynomial(result.toString());
            }
        });

        this.calculatorView.btnSubstractListener(new ActionListener() {

            String firstPolynomial;
            String secondPolynomial;

            @Override
            public void actionPerformed(ActionEvent e) {

                firstPolynomial = calculatorView.getFirstPolynomial();
                secondPolynomial = calculatorView.getSecondPolynomial();

                Polynomial p1 = operations.getPolynomial(firstPolynomial);
                Polynomial p2 = operations.getPolynomial(secondPolynomial);

                Polynomial result = operations.substract(p1,p2);

                calculatorView.setResultPolynomial(result.toString());
            }
        });

        this.calculatorView.btnDivideListener(new ActionListener() {

            String firstPolynomial;
            String secondPolynomial;

            @Override
            public void actionPerformed(ActionEvent e) {

                firstPolynomial = calculatorView.getFirstPolynomial();
                secondPolynomial = calculatorView.getSecondPolynomial();

                Polynomial p1 = operations.getPolynomial(firstPolynomial);
                Polynomial p2 = operations.getPolynomial(secondPolynomial);

                List<Polynomial> result = operations.divide(p1,p2);

                calculatorView.setResultPolynomial("Q = " + result.get(0).toString() + " " + "R = " + result.get(1).toString());
            }
        });

        this.calculatorView.btnMultiplyListener(new ActionListener() {

            String firstPolynomial;
            String secondPolynomial;

            @Override
            public void actionPerformed(ActionEvent e) {

                firstPolynomial = calculatorView.getFirstPolynomial();
                secondPolynomial = calculatorView.getSecondPolynomial();

                Polynomial p1 = operations.getPolynomial(firstPolynomial);
                Polynomial p2 = operations.getPolynomial(secondPolynomial);

                Polynomial result = operations.multiplication(p1,p2);

                calculatorView.setResultPolynomial(result.toString());
            }
        });

        this.calculatorView.btnDerivationListener(new ActionListener() {

            String firstPolynomial;
            String secondPolynomial;

            @Override
            public void actionPerformed(ActionEvent e) {

                firstPolynomial = calculatorView.getFirstPolynomial();

                Polynomial p1 = operations.getPolynomial(firstPolynomial);

                Polynomial result = operations.derivative(p1);

                calculatorView.setResultPolynomial(result.toString());
            }
        });

        this.calculatorView.btnIntegrationListener(new ActionListener() {

            String firstPolynomial;

            @Override
            public void actionPerformed(ActionEvent e) {

                firstPolynomial = calculatorView.getFirstPolynomial();

                Polynomial p1 = operations.getPolynomial(firstPolynomial);

                Polynomial result = operations.integration(p1);

                calculatorView.setResultPolynomial(result.toString());
            }
        });



    }

    public void start(){
        calculatorView.setVisible(true);
    }

}

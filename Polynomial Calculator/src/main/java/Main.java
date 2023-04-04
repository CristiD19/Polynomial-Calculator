import controller.Controller;
import model.Operations;
import view.CalculatorView;

public class Main {
    public static void main(String[] args) {

        CalculatorView mainView = new CalculatorView();
        Operations operations = new Operations();
        Controller controller = new Controller(mainView,operations);
        controller.start();

//        Operations controller = new Operations();
//        List<String> result = controller.getMonomialsAsString("25x^32+4x^2+x+5");
//        result.forEach((s -> System.out.println(controller.getMonomialFromString(s))));
//         Polynomial p1 = operations.getPolynomial("x^3-2x^2+6^x-5");
//         Polynomial p2 = operations.getPolynomial("x^2-1");
//        System.out.println(operations.divide(p1,p2));

    }
}

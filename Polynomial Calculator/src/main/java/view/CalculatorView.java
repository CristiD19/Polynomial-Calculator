package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;


public class CalculatorView extends JFrame{
    private JPanel contentPane;

    private JLabel first;
    private JLabel second;
    private JLabel result;
    private JLabel title;


    private JTextField firstPolynomial;
    private JTextField secondPolynomial;

    private JLabel resultPolynomial;

    private JButton add;
    private JButton substract;
    private JButton multiply;
    private JButton divide;
    private JButton derivation;
    private JButton integrate;



    public CalculatorView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        title = new JLabel("Polynomial Calculator");
        title.setFont(new Font("Calibri", Font.BOLD, 18));
        title.setBounds(110, 10, 180, 27);
        contentPane.add(title);

        first = new JLabel("First Polynomial = ");
        first.setFont(new Font("Calibri", Font.BOLD, 15));
        first.setBounds(26, 53, 135, 27);
        contentPane.add(first);

        second = new JLabel("Second Polynomial = ");
        second.setFont(new Font("Calibri", Font.BOLD, 15));
        second.setBounds(26, 104, 135, 27);
        contentPane.add(second);

        result = new JLabel("Result = ");
        result.setFont(new Font("Calibri", Font.BOLD, 15));
        result.setBounds(55, 155, 135, 27);
        contentPane.add(result);

        firstPolynomial = new JTextField();
        firstPolynomial.setBounds(183, 51, 160, 27);
        contentPane.add(firstPolynomial);
        firstPolynomial.setColumns(10);

        secondPolynomial = new JTextField();
        secondPolynomial.setBounds(183, 102, 160, 27);
        contentPane.add(secondPolynomial);
        secondPolynomial.setColumns(10);

        resultPolynomial = new JLabel("");
        resultPolynomial.setFont(new Font("Calibri", Font.BOLD, 15));
        resultPolynomial.setBounds(153, 153, 160, 27);
        this.getContentPane().add(resultPolynomial);

        add = new JButton("Add");
        add.setBounds(26, 203, 142, 31);
        contentPane.add(add);

        substract = new JButton("Substract");
        substract.setBounds(26, 257, 142, 31);
        contentPane.add(substract);

        multiply = new JButton("Multiply");
        multiply.setBounds(26, 313, 142, 31);
        contentPane.add(multiply);

        divide = new JButton("Divide");
        divide.setBounds(198, 203, 142, 31);
        contentPane.add(divide);

        derivation = new JButton("Derivation");
        derivation.setBounds(198, 257, 142, 31);
        contentPane.add(derivation);

        integrate = new JButton("Integrate");
        integrate.setBounds(198, 313, 142, 31);
        contentPane.add(integrate);


    }

    public String getFirstPolynomial(){

        return this.firstPolynomial.getText();
    }

    public String getSecondPolynomial(){
        return this.secondPolynomial.getText();
    }

    public void setResultPolynomial(String resultPolynomials){
        resultPolynomial.setText(resultPolynomials);
        contentPane.add(resultPolynomial);
        contentPane.setVisible(true);
    }

    public void btnAddListener(ActionListener actionListener){
        this.add.addActionListener(actionListener);
    }

    public void btnSubstractListener(ActionListener actionListener){
        this.substract.addActionListener(actionListener);
    }

    public void btnMultiplyListener(ActionListener actionListener){
        this.multiply.addActionListener(actionListener);
    }

    public void btnDivideListener(ActionListener actionListener){
        this.divide.addActionListener(actionListener);
    }

    public void btnDerivationListener(ActionListener actionListener){
        this.derivation.addActionListener(actionListener);
    }

    public void btnIntegrationListener(ActionListener actionListener){
        this.integrate.addActionListener(actionListener);
    }


}

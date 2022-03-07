package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame {
    private JPanel contentPane;
    private JTextField textFieldPolinom1;
    private JTextField textFieldPolinom2;
    private JTextField textFieldResult;
    private JLabel lblPolinom1;
    private JLabel lblPolinom2;
    private JLabel lblResult;
    private JButton btnMultiplicate;
    private JButton btnDivide;
    private JButton btnAdd;
    private JButton btnSubstract;
    private JButton btnDerive;
    private JButton btnIntegrate;

    public CalcView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 280);
        contentPane = new JPanel();
        setTitle("Polynomial calculator");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblPolinom1 = new JLabel("First polynomial:");
        lblPolinom1.setFont(new Font("Arial", Font.BOLD, 12));
        lblPolinom1.setBounds(35, 30, 120, 20);
        contentPane.add(lblPolinom1);

        lblPolinom2 = new JLabel("Second polynomial:");
        lblPolinom2.setFont(new Font("Arial", Font.BOLD, 12));
        lblPolinom2.setBounds(35, 60, 120, 20);
        contentPane.add(lblPolinom2);

        lblResult = new JLabel("Result: ");
        lblResult.setFont(new Font("Arial", Font.BOLD, 12));
        lblResult.setBounds(35, 90, 300, 20);
        contentPane.add(lblResult);

        textFieldResult = new JTextField();
        textFieldResult.setFont(new Font("Arial", Font.ITALIC, 12));
        textFieldResult.setBounds(155, 90, 250, 20);
        textFieldResult.setText("Your result will be displayed here...");
        contentPane.add(textFieldResult);
        textFieldResult.setEditable(false);
        textFieldResult.setColumns(10);


        textFieldPolinom1 = new JTextField();
        textFieldPolinom1.setFont(new Font("Arial", Font.PLAIN, 12));
        textFieldPolinom1.setBounds(155, 30, 250, 20);
        contentPane.add(textFieldPolinom1);
        textFieldPolinom1.setColumns(10);

        textFieldPolinom2 = new JTextField();
        textFieldPolinom2.setFont(new Font("Arial", Font.PLAIN, 12));
        textFieldPolinom2.setBounds(155, 60, 250, 20);
        contentPane.add(textFieldPolinom2);
        textFieldPolinom2.setColumns(10);

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Arial", Font.BOLD, 12));
        btnAdd.setBounds(35, 130, 100, 20);
        contentPane.add(btnAdd);

        btnSubstract = new JButton("Substract");
        btnSubstract.setFont(new Font("Arial", Font.BOLD, 12));
        btnSubstract.setBounds(140, 130, 100, 20);
        contentPane.add(btnSubstract);

        btnMultiplicate = new JButton("Multiplicate");
        btnMultiplicate.setFont(new Font("Arial", Font.BOLD, 12));
        btnMultiplicate.setBounds(35, 160, 100, 20);
        contentPane.add(btnMultiplicate);

        btnDivide = new JButton("Divide");
        btnDivide.setFont(new Font("Arial", Font.BOLD, 12));
        btnDivide.setBounds(140, 160, 100, 20);
        contentPane.add(btnDivide);

        btnDerive = new JButton("Derive");
        btnDerive.setFont(new Font("Arial", Font.BOLD, 12));
        btnDerive.setBounds(35, 190, 100, 20);
        contentPane.add(btnDerive);

        btnIntegrate = new JButton("Integrate");
        btnIntegrate.setFont(new Font("Arial", Font.BOLD, 12));
        btnIntegrate.setBounds(140, 190, 100, 20);
        contentPane.add(btnIntegrate);

    }

    public String getPolinom1() {

        return this.textFieldPolinom1.getText();
    }

    public String getPolinom2() {
        return this.textFieldPolinom2.getText();
    }

    public void setTextResult(String text) {
        this.textFieldResult.setText(text);
    }

    public void addBtnAddListener(ActionListener actionListener) {
        this.btnAdd.addActionListener(actionListener);
    }

    public void addBtnSubstractListener(ActionListener actionListener) {
        this.btnSubstract.addActionListener(actionListener);
    }

    public void addBtnMultiplicateListener(ActionListener actionListener) {
        this.btnMultiplicate.addActionListener(actionListener);
    }

    public void addBtnDivideListener(ActionListener actionListener) {
        this.btnDivide.addActionListener(actionListener);
    }

    public void addBtnDeriveListener(ActionListener actionListener) {
        this.btnDerive.addActionListener(actionListener);
    }

    public void addBtnIntegrateListener(ActionListener actionListener) {
        this.btnIntegrate.addActionListener(actionListener);
    }

    public void addtextFieldPolinom1Listener(ActionListener actionListener) {
        textFieldPolinom1.addActionListener(actionListener);
    }

    public void addtextFieldPolinom2Listener(ActionListener actionListener) {
        textFieldPolinom2.addActionListener(actionListener);
    }
}

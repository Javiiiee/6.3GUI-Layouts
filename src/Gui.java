import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Gui extends JFrame{
    private JTextField [] textField = new JTextField[4];
    private JLabel label;


    public Gui(){
        label = new JLabel("           0.0");
        JButton button = new JButton("SUM");
        button.addActionListener(new CalculateHandle());
        JPanel masterPanel = new JPanel(new BorderLayout());
        JPanel numberPanels = textfieldMethod();

        masterPanel.add(button, BorderLayout.PAGE_END);
        masterPanel.add(label, BorderLayout.PAGE_START);
        masterPanel.add(numberPanels, BorderLayout.CENTER);
        setContentPane(masterPanel);
    }
    public static void main(String [] args){
        Gui calculator = new Gui();
        calculator.setSize(10000,10000);
        calculator.setTitle("Graphic User Interface");
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.pack();
        calculator.setLayout(new BorderLayout());
        calculator.setVisible(true);
    }
    public JPanel textfieldMethod (){
        GridLayout grid = new GridLayout(2, 2);
        JPanel fieldsPanel = new JPanel(grid);
        for(int i = 0; i < textField.length; i++) {
            textField[i] = new JTextField("            ");
            fieldsPanel.add(textField[i]);
        }
        return fieldsPanel;
    }
    private class CalculateHandle implements ActionListener {
        public void actionPerformed (ActionEvent e){
            double input0 = Double.parseDouble(textField[0].getText());
            double input1 = Double.parseDouble(textField[1].getText());
            double input2 = Double.parseDouble(textField[2].getText());
            double input3 = Double.parseDouble(textField[3].getText());
            double result = (input0+input1+input2+input3);
            DecimalFormat format = new DecimalFormat("####.00");
            label.setText(String.valueOf(format.format(result)));

        }
    }
}
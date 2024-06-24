import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JTextField display;
    private double wertEins = 0;
    private double wertZwei = 0;
    private String operator = "";
    private boolean neueEingabe = true;

    private double memory = 0;

    public Window() {
        initWindow();
        initDisplay();
        initButtons();
    }

    private void initWindow() {
        setTitle("Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    private void initDisplay() {
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);
    }

    private void initButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(4,6));

        String[] buttonLabels = {
                "7", "8", "9", "/", "C",
                "4", "5", "6", "*", "DEL",
                "1", "2", "3", "-", "MC",
                ".", "0", "=", "+", "M"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonController(this));
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDisplay() {
        return display.getText();
    }

    public void setDisplay(String display) {
        this.display.setText(display);
    }

    public double getWertEins() {
        return wertEins;
    }

    public void setWertEins(double wertEins) {
        this.wertEins = wertEins;
    }

    public double getWertZwei() {
        return wertZwei;
    }

    public void setWertZwei(double wertZwei) {
        this.wertZwei = wertZwei;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public boolean isNeueEingabe() {
        return neueEingabe;
    }

    public void setNeueEingabe(boolean neueEingabe) {
        this.neueEingabe = neueEingabe;
    }
}

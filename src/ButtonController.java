import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {

    private Window window;

    public ButtonController(Window window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            if (window.isNeueEingabe()) {
                window.setDisplay(cmd);
                window.setNeueEingabe(false);
            } else {

                if (window.getDisplay().equals("0")) {
                    if (!cmd.equals("0")) {
                        window.setDisplay(cmd);
                    }
                } else {
                    window.setDisplay(window.getDisplay() + cmd);
                }
            }
        }

        if (cmd.equals("C")) {
            window.setDisplay("0");
            window.setWertEins(0);
            window.setWertZwei(0);
            window.setNeueEingabe(true);
        }

        if (cmd.matches("[/*\\-+]")) {
            window.setWertEins(Double.parseDouble(window.getDisplay()));
            window.setOperator(cmd);
            window.setNeueEingabe(true);
        }

        if (cmd.equals("DEL")) {
            if (!window.getDisplay().equals("0")) {
                window.setDisplay(window.getDisplay().substring(0, window.getDisplay().length() - 1));
            }
            if (window.getDisplay().isEmpty()) {
                window.setDisplay("0");
            }
        }

        if (cmd.equals("MC")) {
            window.setMemory(0);
        }

        if (cmd.equals("M")) {
            if (window.getMemory() == 0) {
                window.setMemory(Double.parseDouble(window.getDisplay()));
            } else {
                window.setDisplay(String.valueOf(window.getMemory()));
            }
        }

        if (cmd.equals("=")) {
            window.setWertZwei(Double.parseDouble(window.getDisplay()));
            double ergebnis = 0;
            double ersterWert = window.getWertEins();
            double zweiterWert = window.getWertZwei();
            switch (window.getOperator()) {
                case "+": ergebnis = ersterWert + zweiterWert; break;
                case "-": ergebnis = ersterWert - zweiterWert; break;
                case "/": ergebnis = ersterWert / zweiterWert; break;
                case "*": ergebnis = ersterWert * zweiterWert; break;
            }
            window.setDisplay(String.valueOf(ergebnis));
            window.setNeueEingabe(true);
        }

        if (cmd.equals(".")) {
            if (window.getDisplay().equals("0") || window.isNeueEingabe()) {
                window.setDisplay("0.");
                window.setNeueEingabe(false);
            }
            if (!window.getDisplay().contains(".")) {
                window.setDisplay(window.getDisplay() + ".");
            }
        }
    }
}

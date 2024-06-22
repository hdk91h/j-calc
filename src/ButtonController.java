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
                window.setDisplay(window.getDisplay() + cmd);
            }
        }

        if (cmd)

    }

}

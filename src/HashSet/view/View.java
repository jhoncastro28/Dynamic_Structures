package HashSet.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author jhonm
 */
public class View {

    BufferedReader read;

    public View() {
        read = new BufferedReader(new InputStreamReader(System.in));
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showInt(int number) {
        JOptionPane.showMessageDialog(null, number);
    }

    public String readData(String message) {
        String data = JOptionPane.showInputDialog(null, message);
        return data;
    }

    public void showErr(String message) {
        System.err.println(message);
    }

    public int readInt(String message) {
        String input = JOptionPane.showInputDialog(null, message);

        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Introduce un número entero válido.");
            value = readInt(message); // Recursividad
        }

        return value;
    }

    public void showInteger(Set<Integer> subset) {
        StringBuilder message = new StringBuilder("Subcojunto: { ");
        for (Integer element : subset) {
            message.append(element).append(" ");
        }
        message.append("}");

        JOptionPane.showMessageDialog(null, message.toString());
    }
}

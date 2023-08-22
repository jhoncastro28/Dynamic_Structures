package PriorityQueue.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

    public double readDouble(String message) {
        String inputData = JOptionPane.showInputDialog(null, message);
        double data = Double.parseDouble(inputData);
        return data;
    }

    public int readInt(String message) {
        String inputData = JOptionPane.showInputDialog(null, message);
        int value = Integer.parseInt(inputData);
        return value;
    }

    public void showErr(Exception e) {
        System.err.println(e);
    }
}

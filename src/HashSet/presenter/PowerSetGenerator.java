package HashSet.presenter;

import HashSet.model.Model;
import HashSet.view.View;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jhonm
 */
public class PowerSetGenerator {

    private Model model;
    private View view;

    public PowerSetGenerator() {
        model = new Model();
        view = new View();
    }

    public void run() {
        String inputLine = view.readData("Ingrese los elementos del conjunto separados por espacios: ");
        String[] inputElements = inputLine.split("\\s+");
        Set<Integer> inputSet = new HashSet<>();
        for (String element : inputElements) {
            inputSet.add(Integer.parseInt(element));
        }
        Set<Set<Integer>> powerSet = model.generatePowerSet(inputSet);

        view.showMessage("Conjunto de partes:");
        for (Set<Integer> subset : powerSet) {
            view.showInteger(subset);
        }
    }

    public static void main(String[] args) {
        new PowerSetGenerator().run();
    }

}

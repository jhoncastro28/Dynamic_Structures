package Stack.presenter;

import java.util.Scanner;
import java.util.Stack;
import java.util.function.Function;

import Stack.model.Model;
import Stack.view.View;

/**
 *
 * @author jhonm
 */
public class ExpressionEvaluator {

    private Model model;
    private View view;
    private double result;
    private String expression;

    public ExpressionEvaluator() {
        model = new Model();
        view = new View();
    }

    public static void main(String[] args) {
        new ExpressionEvaluator().run();
    }

    private void run() {
        int option = showMenu();
        while (option != 3) {
            switch (option) {
                case 1:
                    expression = view.readData("Ingrese la expresion: ");
                    result = model.evaluateExpression(expression);
                    break;
                case 2:
                    view.showMessage("Result: " + result);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    view.showMessage("Parametro invalido");
            }
        }
        view.showMessage("Cerrando programa. Adios!!");
    }

    private int showMenu() {
        int option = view.readInt("Bienvenido al analizador de expresiones matematicas \n"
                + "-- MENU PRINCIPAL -- \n1. Evaluar una expresion matematica"
                + "\n2. Mostrar el resultado \n3. Salir \nDigite Eleccion: ");
        return option;
    }
    
}

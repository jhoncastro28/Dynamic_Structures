package Vector.presenter;

import Vector.model.*;
import Vector.view.View;

/**
 *
 * @author jhonm
 */
public class ShoppingCart {

    private View view;
    private Model model;

    public ShoppingCart() {
        model = new Model();
        view = new View();
    }

    public static void main(String[] args) {
        new ShoppingCart().run();
    }

    public void displayCart() {
        view.showMessage("Contenido del carrito de compras: ");
        for (Item item : model.getItems()) {
            view.showMessage(item.getName() + " - $" + item.getPrice());
        }
    }

    public void assignPrices() {
        String itemName = view.readData("Ingrese el nombre del item: ");

        double itemPrice = view.readDouble("Ingrese el precio del item: ");

        Item newItem = new Item(itemName, itemPrice);
        model.addItem(newItem);

        view.showMessage("Item añadido al carrito.");
    }

    public void readChoice() {
        int option = view.readInt("Ingrese el numero de articulos a registrar: ");
        for (int i = 0; i < option; i++) {
            view.showMessage("Item #" + (i + 1));
            assignPrices();
        }
    }
    
    public void run() {
        int option = 0;
        while (option != 3) {
            option = showMenu();
            switch (option) {
                case 1:
                    readChoice();
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    double totalPrice = model.calculateTotalPrice();
                    view.showMessage("Total Price: $" + totalPrice);
                    break;
                default:
                    view.showMessage("Parametro incorrecto");
                    break;
            }
        }
    }

    private int showMenu() {
        int option = view.readInt("-- MENU PRINCIPAL -- \n1)Poner los items en el carrito de compras "
                + "\n2)Ver el contenido del carrito de compras "
                + "\n3)Calcular precio total"
                + "\n4)Salir"
                + "\nDigite opcion: ");
        return option;
    }

}

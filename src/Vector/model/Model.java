package Vector.model;

import java.util.Vector;

/**
 *
 * @author jhonm
 */
public class Model {

    private Vector<Item> items;

    public Model() {
        items = new Vector<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public Vector<Item> getItems() {
        return items;
    }

    public void setItems(Vector<Item> items) {
        this.items = items;
    }
}

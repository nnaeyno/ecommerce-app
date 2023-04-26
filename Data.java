import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    HashMap<String, ArrayList<Product>> data;

    public Data() {
        data = new HashMap<>();

    }

    public String getFewest() {
        return null;
    }

    public boolean saveProduct(String id, String name, double price) {
        return false;
    }

    public void changeQuantity(String id, int quantity) {

    }
    public int getQuantity(String id) {
        return 0;
    }

    public double getAverage(String id) {
        return 0;
    }

    public String getMostPopular() {
        return null;
    }

    public double getProfit(String id) {
        return 0.0;
    }
}

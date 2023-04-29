import java.util.HashMap;

public class Data {

    private HashMap<String, ProductOrderHistory> orderHistory;
    // something like that attached to idea would be smarter
    //registeredProdycts ID -> PRODUCT
    //wareHouse data    ID
    public Data() {
        orderHistory = new HashMap<>();
    }

    public String getFewest() {
        String result = "";
        int currMax = Integer.MAX_VALUE;
        for (String key : orderHistory.keySet()) {
            ProductOrderHistory value = orderHistory.get(key);
            if (currMax > value.getRemainingQuantity()) {
                result = value.getProductName();
                currMax = value.getRemainingQuantity();
            }
        }
        return result;
    }

    public void saveProduct(String id, String name, double price) {
        Product prod = new Product(name, price, id);
        if(!orderHistory.containsKey(id)){
            ProductOrderHistory history = new ProductOrderHistory(prod);
            orderHistory.put(id, history);
        } else
            orderHistory.get(id).changeProduct(prod);

    }

    public void orderProduct(String id, int quantity) {
        // in history change remaningQuantity and soldQuantity as well as profit
        if(orderHistory.containsKey(id)){
            ProductOrderHistory order = orderHistory.get(id);
            if(order.getRemainingQuantity() > quantity){
                order.changeRemainingQuantity(-1*quantity);
                order.changeAverageOrderPrice(quantity);
                order.changeSoldQuantity(quantity);
            } else throw new RuntimeException("NOT ENOUGH PRODUCTS");
        } else throw new RuntimeException(Constants.ERROR_MESSAGE);

    }

    public void purchaseProduct(String id, int quantity, double price) {
        // change remaningQuantity
        if(orderHistory.containsKey(id)) {
            ProductOrderHistory order = orderHistory.get(id);
            order.changeAveragePurchasePrice(quantity, price);
            order.changeRemainingQuantity(quantity);
        } else throw new RuntimeException(Constants.ERROR_MESSAGE);
    }

    public int getQuantity(String id) {
        if(orderHistory.containsKey(id)) {
            return orderHistory.get(id).getRemainingQuantity();
        } else throw new RuntimeException(Constants.ERROR_MESSAGE);
    }

    public double getAverage(String id) {
        if(orderHistory.containsKey(id)) {
            return orderHistory.get(id).getAveragePurchasePrice();
        } else throw new RuntimeException(Constants.ERROR_MESSAGE);
    }

    public String getMostPopular() {
        String result = "";
        int currMax = Integer.MIN_VALUE;
        for (String key : orderHistory.keySet()) {
            ProductOrderHistory value = orderHistory.get(key);
            if (currMax < value.getSoldQuantity()) {
                result = value.getProductName();
                currMax = value.getSoldQuantity();
            }
        }
        return result;
    }

    public double getProfit(String id) {
        if(orderHistory.containsKey(id)) {
            return orderHistory.get(id).getProfit();
        } else throw new RuntimeException(Constants.ERROR_MESSAGE);
    }
}

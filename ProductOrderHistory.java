public class ProductOrderHistory {
    private Product product;
    private int remainingQuantity;
    private double averagePurchasePrice;
    private double averageOrderPrice;
    private int soldQuantity;

    public ProductOrderHistory(Product product) {
        this.product = product;
        this.remainingQuantity = 0;
        this.averagePurchasePrice = product.getPrice();
        this.averageOrderPrice = 0;
        this.soldQuantity = 0;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public String getProductName() {
        return product.getName();
    }

    public double getProfit() {
       double profitPerUnit = averageOrderPrice - averagePurchasePrice;
       return profitPerUnit * soldQuantity;
    }

    public double getAveragePurchasePrice() {
        return averagePurchasePrice;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void changeRemainingQuantity(int quantity) {
        remainingQuantity += quantity;
    }

    public void changeSoldQuantity(int quantity) {
        soldQuantity += quantity;
    }
    public void changeAverageOrderPrice(int quantity) {
        double sum = averageOrderPrice * soldQuantity;
        sum += quantity * product.getPrice();
        averageOrderPrice = sum / (quantity + soldQuantity);
    }

    public void changeAveragePurchasePrice(int quantity, double price) {
        double sum = averagePurchasePrice * (remainingQuantity + soldQuantity);
        sum += quantity * price;
        averagePurchasePrice = sum / (remainingQuantity + soldQuantity + quantity);
    }


    public void changeProduct(Product prod){
        this.product = prod;
    }
}

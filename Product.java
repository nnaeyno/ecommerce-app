import java.util.Objects;

public class Product {
    String name;
    double price;
    String prodID;
    double sellPrice;


    public Product(String name, Double price, String prodID) {
        this.name = name;
        this.price = price;
        this.prodID = prodID;
    }

    public double getPrice() {
        return price;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return prodID.equals(product.prodID);
    }



    @Override
    public int hashCode() {
        return Objects.hash(prodID);
    }
}

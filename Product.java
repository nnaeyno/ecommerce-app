import java.util.Objects;

public class Product {
    private final String name;
    private final double price;
    private final String prodID;


    public Product(String name, Double price, String prodID) {
        this.name = name;
        this.price = price;
        this.prodID = prodID;
    }

    public double getPrice() {
        return price;
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

    public String getName() {
        return name;
    }
}


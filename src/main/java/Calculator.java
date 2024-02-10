import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Product> productList = new ArrayList<>();
    private double currentSum;

    public void add(Product product) {
        productList.add(product);
        addToSum(product.getPrice());
    }

    private void addToSum(double price) {
        currentSum += price;
    }

    public double getSum() {
        return currentSum;
    }

    public List<Product> getProducts() {
        return productList;
    }

}
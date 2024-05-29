import entities.CustomProductFunction;
import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static CustomProductFunction createProducts = (int quantity, String category, String name, List<Product> list) -> {
        for (int i = 0; i < quantity; i++) {
            list.add(new Product(new Random().nextDouble(5.0, 200.0), category, name));
        }
        return list;
    };

    public static void main(String[] args) {

        List<Product> products = getProductList(10);
        Collections.shuffle(products);
        List<Order> orders = getOrderList();

        //Es1
        System.out.println("__________Es1__________");
        System.out.println(products);
        List<Product> listBooksUnder100 = products.stream().filter(product -> Objects.equals(product.getCategory(), "Books") & product.getPrice() > 100).toList();
        System.out.println("\nProdotti appartenenti alla categoria Books con prezzo maggiore di cento \n" + listBooksUnder100);

        //Es2
        System.out.println("__________Es2__________");
        System.out.println(orders);
        List<Order> orderWithBabyCategory = orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> Objects.equals(product.getCategory(), "Baby"))).toList();
        System.out.println("\n Ordini che contengono la categoria Baby" + orderWithBabyCategory);
    }

    private static List<Product> getProductList(int quantity) {
        List<Product> products = new ArrayList<>();
        createProducts.create(quantity, "Books", "book", products);
        createProducts.create(quantity, "Baby", "milk", products);
        createProducts.create(quantity, "Boys", "clothes", products);
        return products;
    }

    private static List<Order> getOrderList() {
        Customer customer = new Customer("Mario", 2);
        Customer customer2 = new Customer("Cristian", 3);
        List<Product> products = new ArrayList<>();
        createProducts.create(2, "Smartphone", "samsung", products);
        createProducts.create(3, "Books", "book", products);
        createProducts.create(4, "Boys", "clothes", products);
        Order order1 = new Order("In consegna", LocalDate.now(), LocalDate.now().plusDays(5), products, customer);
        Order order2 = new Order("In attesa", LocalDate.now(), LocalDate.now().plusDays(5), getProductList(3), customer2);
        Order[] list = {order1, order2};
        return Arrays.stream(list).toList();
    }
}
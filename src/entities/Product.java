package entities;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private Double price;

    public Product(Double price, String category, String name) {
        this.setId(new Random().nextLong(100000, 1000000));
        this.price = price;
        this.category = category;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "\tProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                "}\n";
    }
}

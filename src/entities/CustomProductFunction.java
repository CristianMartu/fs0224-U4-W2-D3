package entities;

import java.util.List;

@FunctionalInterface
public interface CustomProductFunction {
    public List<Product> create(int quantity, String category, String name, List<Product> list);
}

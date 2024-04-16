package pl.bryczek.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ArrayListProductStorage implements ProductStorage {
    private ArrayList<Product> products;

    public ArrayListProductStorage() {
        this.products = new ArrayList<>();
    }

    @Override
    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public void add(Product newProduct) {
        products.add(newProduct);
    }
    @Override
    public Product getProductBy(String id) {
        return products.stream()
                    .filter(product -> product.getID().equals(id))
                    .findFirst()
                    .get();
    }
}


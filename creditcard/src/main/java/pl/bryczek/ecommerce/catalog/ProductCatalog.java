package pl.bryczek.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    private ProductStorage productStorage;
    public ProductCatalog(ProductStorage storage) {
        this.productStorage = storage;
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();
        Product newProduct = new Product(id, name, description);
        productStorage.add(newProduct);

        return newProduct.getID();
    }

    public Product getProductBy(String id){
        return productStorage.getProductBy(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product product = getProductBy(id);

        product.changePrice(newPrice);
    }
}

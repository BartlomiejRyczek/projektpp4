package pl.bryczek.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.bryczek.ecommerce.Sales.SalesFacade;
import pl.bryczek.ecommerce.catalog.ArrayListProductStorage;
import pl.bryczek.ecommerce.catalog.Product;
import pl.bryczek.ecommerce.catalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main (String[] args){
        System.out.println("Czesc");
        SpringApplication.run(App.class, args);
    }

    @Bean
    SalesFacade createSalesFacade(){
        return new SalesFacade();
    }

    @Bean
    ProductCatalog createMyCatalog(){
        var catalog = new ProductCatalog(new ArrayListProductStorage());
        var p1 =
        catalog.addProduct("Lego set 8083", "Nice one");
        catalog.addProduct("Cobi bricks", "Nice one");

        return catalog;
    }
}

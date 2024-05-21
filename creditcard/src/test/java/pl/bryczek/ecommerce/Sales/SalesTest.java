package pl.bryczek.ecommerce.Sales;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class SalesTest {
    @Test
    void itAllowsToAddProductToCart(){
        SalesFacade sales = thereIsSalesFacade();
        String customerId = thereIsCustomer("Bartek");
        String productId = thereIsProduct("x", BigDecimal.valueOf(10.10));

        sales.addProductToCard(customerId, productId);
        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal().isEqualTo(BigDecimal.valueOf(10.10));
        assertThat(offer.getItemsCount()).isEqualTo(1);

    }

    @Test
    void itAllowsToRemoveProductFromCart(){

    }

    @Test
    void itAllowsToAcceptOffer(){

    }


    @Test
    void itAShowsCurrentOffer(){
        //ARRANGE
        SalesFacade sales = thereIsSalesFacade();
        String customerId = thereIsCustomer("Bartek");

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(0));
        assertThat(offer.getItemsCount()).isEqualTo(0);


        sales.getCurrentOffer(customerId);
    }

    private String thereIsCustomer(String name) {
        return  name;
    }

    private SalesFacade thereIsSalesFacade(){
        return  new SalesFacade();
    }

    private String thereIsProduct(String name, BigDecimal price) { return null;

    }
}

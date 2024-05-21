package pl.bryczek.ecommerce.Sales;

import org.springframework.web.bind.annotation.*;

@RestController
public class SalesController {
    SalesFacade sales;

    public SalesController(SalesFacade sales) {
        this.sales = sales;
    }

    @PostMapping("/api/add-product/{productId}")
    void addProduct(@PathVariable String productId){
        String customerId = getCurrentCustomer();
        sales.addProductToCard(customerId, productId);
    }

    @PostMapping("/api/accept-offer")
    ReservationDetails acceptOffer(@RequestBody AcceptOfferRequest request){
        String customerId = getCurrentCustomer();
        return sales.acceptOffer(customerId, request);
    }
    @GetMapping("/api/current-offer")
    Offer getCurrentOffer(){
        String customerId = getCurrentCustomer();
        return  sales.getCurrentOffer(customerId);
    }

    private String getCurrentCustomer() {
        return "guest";
    }



}

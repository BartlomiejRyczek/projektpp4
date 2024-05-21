package pl.bryczek.ecommerce.Sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaleHTTPTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate http;

    @Test
    void itAllowsToAcceptOfferHappyPath(){
        var productId= thereIsProduct("product X");
        var addProductToCartUrl = String.format("http://localhost:%s/api/cart/add-product/%s", port, productId);
        ResponseEntity<Void> addProductResponse = http.postForEntity(addProductToCartUrl, null, Void.class);

        var getCurrentOfferUrl = String.format("http://localhost:%s/api/current-offer", port);
        ResponseEntity<Offer> offerResponse = http.getForEntity(getCurrentOfferUrl, Offer.class);

        var acceptOfferUrl = String.format(
                "http://localhost:%s/api/accept-offer", port);

        var acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstname("John")
                .setLastname("Doe")
                .setEmail("johndoe@gmail.com");

        ResponseEntity<ReservationDetails> acceptOfferResponse = http.postForEntity(acceptOfferUrl, acceptOfferRequest, ReservationDetails.class);

        assert HttpStatus.OK.equals(addProductResponse.getStatusCode());
        assert HttpStatus.OK.equals(offerResponse.getStatusCode());
        assert HttpStatus.OK.equals(acceptOfferResponse.getStatusCode());
        assertNotNull(acceptOfferResponse.getBody().getPaymentUrl());
        assertNotNull(acceptOfferResponse.getBody().getReservationId());
    }

    private String thereIsProduct(String id){
        return id;
    }
}

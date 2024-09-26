package nl.casperdaris.film_product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import nl.casperdaris.film_product_service.dto.ProductRequest;
import nl.casperdaris.film_product_service.dto.ProductResponse;
import nl.casperdaris.film_product_service.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // TODO: Nog even de parameter path toevoegen
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createFilmProduct(@RequestBody ProductRequest productRequest) {
        productService.createFilmProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }
}

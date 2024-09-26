package nl.casperdaris.film_product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import nl.casperdaris.film_product_service.dto.ProductRequest;
import nl.casperdaris.film_product_service.dto.ProductResponse;
import nl.casperdaris.film_product_service.model.Product;
import nl.casperdaris.film_product_service.repository.ProductRepository;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createFilmProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product with id {} is saved in the database.", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapProductToResponse(product)).toList();
    }

    private ProductResponse mapProductToResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

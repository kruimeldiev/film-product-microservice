package nl.casperdaris.film_product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.casperdaris.film_product_service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    

}

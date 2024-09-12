package org.example.productcatalogservice.Controllers;

import org.example.productcatalogservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    // you can also use: public Product getProductById(@PathVariable Long id)
    public Product getProductById(@PathVariable("id") Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setTitle("Iphone 16");
        product.setDescription("IPhone 16 Apple Inc.");
        product.setAmount(130000.00);
        return product;
    }

    @PostMapping("/products/")
    public Product createProduct(@RequestBody Product product) {
        return null;
    }


}

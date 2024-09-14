package org.example.productcatalogservice.Controllers;

import org.example.productcatalogservice.dtos.CategoryDto;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.example.productcatalogservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {
    //Auto wiring is to be done to make sure that the same type of object of product service is initialized.

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return null;
    }

    @GetMapping("/products/{id}")
    // you can also use: public Product getProductById(@PathVariable Long id)
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId) {

        try{
            if(productId == null || productId < 0){
                throw new RuntimeException("Product not found");
            }

            Product product = productService.getProductById(productId);
            if(product == null){
                throw new RuntimeException("Selected Product id not available or call to fake store is unsuccessful");
            }

            return new ResponseEntity<ProductDto>(from(product), HttpStatus.OK);

        } catch (RuntimeException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/products/")
    public ProductDto createProduct(@RequestBody ProductDto product) {
        return null;
    }

    ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            productDto.setCategory(categoryDto);

        }

        return productDto;
    }


}

package org.example.productcatalogservice.services;

import org.example.productcatalogservice.dtos.CategoryDto;
import org.example.productcatalogservice.dtos.FakeStoreDto;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<Product> getProducts() {
        return null;
    }

    public Product getProductById(long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{product_id}",FakeStoreDto.class,id);
        FakeStoreDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        if(fakeStoreProductDtoResponseEntity.getStatusCode().is2xxSuccessful() &&  fakeStoreProductDto != null){
            return from(fakeStoreProductDto);
        }

        return null;
    }

    public Product createProduct() {
        return null;
    }

    Product from (FakeStoreDto fakeStoreDto) {
        Product product = new Product();

        product.setDescription(fakeStoreDto.getDescription());
        product.setImageUrl(fakeStoreDto.getImage());
        product.setAmount(fakeStoreDto.getPrice());
        product.setTitle(fakeStoreDto.getTitle());
        product.setId(fakeStoreDto.getId());

        if(fakeStoreDto.getCategory() != null) {
            Category category = new Category();
            category.setName(fakeStoreDto.getCategory());
            product.setCategory(category);
        }

        return product;
    }

}

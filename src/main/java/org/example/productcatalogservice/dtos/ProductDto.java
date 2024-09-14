package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.productcatalogservice.models.Category;

@Setter
@Getter
public class ProductDto {
    private long id;
    private String title;
    private String description;
    private String imageUrl;
    private Double amount;
    private CategoryDto category;
}

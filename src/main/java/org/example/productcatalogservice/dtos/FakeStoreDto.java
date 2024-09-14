package org.example.productcatalogservice.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    @JsonProperty
    private Rating rating;

    @Setter
    @Getter
    public static class Rating {
        private double rate;
        private int count;
    }

}

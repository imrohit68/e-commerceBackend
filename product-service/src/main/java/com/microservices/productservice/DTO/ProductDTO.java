package com.microservices.productservice.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    @NotBlank
    private String name;
    @NotBlank
    private  String description;
    @NotBlank
    private BigDecimal price;
    @NotBlank
    private String image;
}

package com.shizuru.McDonaldsApi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record ProductsDTO(@NotBlank String productName, @NotNull BigDecimal productPrice,  @NotNull UUID categoryId, @NotBlank String productDescription ) {


}

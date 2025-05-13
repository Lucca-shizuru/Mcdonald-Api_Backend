package com.shizuru.McDonaldsApi.dtos;

import jakarta.validation.constraints.NotBlank;

public record CategoryDTO(@NotBlank String categoryName) {
}

package com.shizuru.McDonaldsApi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Product_Table")
@Getter
@Setter
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;



    @ManyToOne
    @JoinColumn(name ="Category_id")
    private CategoryModel category;
}

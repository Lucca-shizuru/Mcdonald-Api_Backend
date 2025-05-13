package com.shizuru.McDonaldsApi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.List;
import java.util.UUID;

@Entity
@Table (name= " Category_Table")
@Getter
@Setter
public class CategoryModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID categoryId;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<ProductModel> products;





}

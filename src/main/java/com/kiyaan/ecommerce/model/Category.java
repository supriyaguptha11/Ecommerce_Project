package com.kiyaan.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @EqualsAndHashCode
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @NotNull
    @Column(unique = true)
    private String categoryId;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @NotNull
    private Integer level;
}

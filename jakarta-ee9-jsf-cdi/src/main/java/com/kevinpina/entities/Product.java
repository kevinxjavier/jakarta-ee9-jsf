package com.kevinpina.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_test")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float price;
    private String sku;
    private String name;

    @Column(name = "date")
    private LocalDate registryDate;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}

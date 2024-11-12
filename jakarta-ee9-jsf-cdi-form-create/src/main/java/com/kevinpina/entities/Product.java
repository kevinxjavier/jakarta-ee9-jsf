package com.kevinpina.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@ToString
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

    //@PrePersist   // Deactivated to not persist automatically the date
    public void prePersist() {
        registryDate = LocalDate.now();
    }

    /*@Override
    public String toString() {
        return name;
    }*/

}

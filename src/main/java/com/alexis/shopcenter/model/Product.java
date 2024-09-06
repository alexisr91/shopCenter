package com.alexis.shopcenter.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="category_id")
    private Optional<Category> category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Image> images;
    // MappedBy : coté propriétaire [ Celui qui possede la clé etrangere ] est l'entité image, la relation est définie par l'attribut product 
    // Cascade = toutes opérations effectués sur l'entité Product sera affecté sur les entités associées
    // OrphanRemoval = Supression auto des entités orphelines dans une relation parent enfant. Supprime automatiquement une entité enfant. Cela veut dire que si on supprime la collection Product, l'image sera aussi supprimé de sa bdd 
    // Association d'objet avec image


    public Product(String name, String brand, BigDecimal price, int inventory, String description,Optional<Category> category){
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.inventory = inventory;
        this.description = description;
        this.category = category;
    }
}

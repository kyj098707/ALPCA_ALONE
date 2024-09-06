package com.example.back.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


@Entity
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String type;

    @Column(nullable = false)
    private String genre;

    private String rank;
    private float rating;
    private String tier;
    private String broadcastAt;
    private String airedYear;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Long hits;
    private String imageUrl;
}

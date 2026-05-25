package com.srinlankagem.gembackend.gem.models;

import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.core.SpringVersion;

import java.time.LocalDateTime;

@Entity
@Table(name = "gemstones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GemStone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String gemCode;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GemType type;

    @Column(nullable = false)
    private String color;


    @Column(nullable = false)
    private Double caratWeight;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GemOrigin origin;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GemTreatment treatment;

    @Column(nullable = false)
    private Double pricePerCarat;

    @Column(nullable = false)
    private Integer stockQuantity;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    @Builder.Default
    private boolean certified = false;

    @Column(nullable = false)
    @Builder.Default
    private boolean active = true;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @PrePersist
    protected void onCreate(){

        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){

        this.updateAt = LocalDateTime.now();
    }
}

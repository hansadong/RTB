package com.toy.rtb.model.recipe;

import com.toy.rtb.model.common.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipes")
@Getter
@Setter
public class Recipes extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeSn;

    @Column(nullable = false)
    private String recipeName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String preparationTime;

    @Column(nullable = false)
    private String cookingTime;
}

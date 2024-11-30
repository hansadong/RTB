package com.toy.rtb.model.recipe;

import com.toy.rtb.model.common.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipe_ingredients")
@Getter
@Setter
public class RecipeIngredients extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeSn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ingredientSn;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private String preparationTime;

    @Column(nullable = false)
    private String cookingTime;
}

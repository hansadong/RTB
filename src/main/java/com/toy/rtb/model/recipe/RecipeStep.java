package com.toy.rtb.model.recipe;

import com.toy.rtb.model.common.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recipe_step")
@Getter
@Setter
public class RecipeStep extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stepSn;

    @Column(nullable = false)
    private String stepOrder;

    @Column(nullable = false)
    private String stepDescription;

    @Column(nullable = false)
    private String preparationTime;

    @Column(nullable = false)
    private String cookingTime;
}

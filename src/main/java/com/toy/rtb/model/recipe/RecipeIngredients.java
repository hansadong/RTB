package com.toy.rtb.model.recipe;

import com.toy.rtb.model.common.CommonEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "recipe_ingredients")
@Getter
@Setter
@IdClass(RecipeIngredients.CompositeKey.class)
public class RecipeIngredients extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeSn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredientSn;

    @Column(nullable = false)
    private String quantity;

    @Column(nullable = false)
    private String preparationTime;

    @Column(nullable = false)
    private String cookingTime;

    public static class CompositeKey implements Serializable {
        private Long recipeSn;
        private Long ingredientSn;

        // 기본 생성자, getter, setter, equals(), hashCode() 구현

        public CompositeKey() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompositeKey that = (CompositeKey) o;
            return Objects.equals(recipeSn, that.recipeSn) && Objects.equals(ingredientSn, that.ingredientSn);
        }

        @Override
        public int hashCode() {
            return Objects.hash(recipeSn, ingredientSn);
        }
    }
}

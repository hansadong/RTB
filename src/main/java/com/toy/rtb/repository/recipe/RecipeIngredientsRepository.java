package com.toy.rtb.repository.recipe;

import com.toy.rtb.model.recipe.RecipeIngredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientsRepository extends JpaRepository<RecipeIngredients, Integer> {
}

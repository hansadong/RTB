package com.toy.rtb.repository.recipe;

import com.toy.rtb.model.recipe.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, Integer> {
}

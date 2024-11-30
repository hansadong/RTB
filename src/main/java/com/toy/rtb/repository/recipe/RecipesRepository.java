package com.toy.rtb.repository.recipe;

import com.toy.rtb.model.recipe.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipesRepository extends JpaRepository<Recipes, Integer> {
}

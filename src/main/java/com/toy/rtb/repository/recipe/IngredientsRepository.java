package com.toy.rtb.repository.recipe;

import com.toy.rtb.model.recipe.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientsRepository extends JpaRepository<Ingredients, Integer> {
}

package com.toy.rtb.service.recipe;

import com.toy.rtb.model.recipe.Recipes;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
    public List<Recipes> getRecipeList();
    public Optional<Recipes> getRecipe(Integer recipeSn);
}

package com.toy.rtb.service.recipe;

import com.toy.rtb.model.recipe.Recipes;
import com.toy.rtb.repository.recipe.RecipesRepository;

import java.util.List;
import java.util.Optional;

public class RecipeServiceImpl implements RecipeService {
    private RecipesRepository recipesRepository;

    public List<Recipes> getRecipeList() {
        return recipesRepository.findAll();
    }

    public Optional<Recipes> getRecipe(Integer recipeSn) {
        return recipesRepository.findById(recipeSn);
    }
}

package com.toy.rtb.service.recipe;

import com.toy.rtb.model.recipe.Recipes;
import com.toy.rtb.repository.recipe.RecipesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipesRepository recipesRepository;

    public List<Recipes> getRecipeList() {
        return recipesRepository.findAll();
    }

    public Optional<Recipes> getRecipe(Integer recipeSn) {
        return recipesRepository.findById(recipeSn);
    }
}

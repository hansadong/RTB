package com.toy.rtb.controller.recipe;

import com.toy.rtb.dto.recipe.RecipeRequestDTO;
import com.toy.rtb.model.recipe.Recipes;
import com.toy.rtb.service.recipe.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private RecipeService recipeService;

    @GetMapping("/getRecipeList")
    public ResponseEntity<?> getRecipeList(RecipeRequestDTO recipeRequestDTO) {
        List<Recipes> recipeList = recipeService.getRecipeList();
        return ResponseEntity.ok(recipeList);
    }

    @GetMapping("/getRecipeDetail")
    public ResponseEntity<?> getRecipeDetail(RecipeRequestDTO recipeRequestDTO) {
        Optional<Recipes> recipe = recipeService.getRecipe(recipeRequestDTO.getRecipeSn());
        return ResponseEntity.ok(recipe);
    }
}

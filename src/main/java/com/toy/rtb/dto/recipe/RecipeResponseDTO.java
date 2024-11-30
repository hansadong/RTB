package com.toy.rtb.dto.recipe;

import com.toy.rtb.model.recipe.Recipes;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeResponseDTO {
    private List<Recipes> recipeList;
}

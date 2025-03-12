package com.toy.rtb.dto.recipe;

import com.toy.rtb.model.recipe.Recipes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponseDTO {
    private List<Recipes> recipeList;
}

package com.toy.rtb.service.recipe;

import com.querydsl.jpa.impl.JPAQueryFactory;
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

    @Autowired
    private JPAQueryFactory queryFactory;

    public List<Recipes> getRecipeList() {
//        QRecipes qRecipes = QRecipes.recipes;
//        QRecipeIngredients qRecipeIngredients = QRecipeIngredients.recipeIngredients;
//        QIngredients qIngredients = QIngredients.ingredients;
//
//        List<Recipes> result = queryFactory
//                .selectFrom(qRecipes)
//                .join(qRecipes.recipeIngredients, qRecipeIngredients)
//                .join(qRecipeIngredients.ingredients, qIngredients)
////                .where(qIngredients.ingredientSn.eq("조건값")) // 원하는 조건 추가
//                .fetch();
//        return result;
        return recipesRepository.findAll();
    }

    public Optional<Recipes> getRecipe(Integer recipeSn) {
        return recipesRepository.findById(recipeSn);
    }
}

package com.toy.rtb.controller.recipe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @GetMapping("/list")
    public ResponseEntity<?> getRecipeList() {
        return ResponseEntity.ok("Get Recipe List Success!");
    }
}

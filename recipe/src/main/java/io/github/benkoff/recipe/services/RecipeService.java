package io.github.benkoff.recipe.services;

import io.github.benkoff.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}

package io.github.benkoff.recipe.domain;

import io.github.benkoff.recipe.repositories.RecipeRepository;
import io.github.benkoff.recipe.services.RecipeService;
import io.github.benkoff.recipe.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Ben on 2017-11-01.
 */
public class CategoryTest {

    Category category;
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getId() throws Exception {
        Long idValue = 4L;
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() throws Exception {
        String description = "Some description";
        category.setDescription(description);
        assertEquals(description, category.getDescription());
    }

    @Test
    public void getRecipes() throws Exception {
        MockitoAnnotations.initMocks(this);
        RecipeService recipeService = new RecipeServiceImpl(recipeRepository);
        Recipe recipe = new Recipe();
        Set<Recipe> recipeSet = new HashSet<>();
        recipeSet.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeSet);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }
}

package recipeapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RecipeManager {
    private ObservableList<Recipe> recipes;

    public RecipeManager() {
        recipes = FXCollections.observableArrayList();
    }

    public ObservableList<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }
}


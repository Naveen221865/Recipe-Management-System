package recipeapp;

public class Recipe {
    private String name;
    private String ingredients;
    private String instructions;

    public Recipe(String name, String ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() { return name; }
    public String getIngredients() { return ingredients; }
    public String getInstructions() { return instructions; }

    public void setName(String name) { this.name = name; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    @Override
    public String toString() {
        return name;
    }
}


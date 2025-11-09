package recipeapp;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class RecipeAppUI {
    private RecipeManager manager;

    public RecipeAppUI(RecipeManager manager) {
        this.manager = manager;
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("🍳 Recipe Management System");

        // Left: Recipe List
        ListView<Recipe> recipeList = new ListView<>(manager.getRecipes());
        recipeList.setPrefWidth(200);

        // Right: Form and Details
        TextField nameField = new TextField();
        nameField.setPromptText("Recipe Name");

        TextArea ingredientsArea = new TextArea();
        ingredientsArea.setPromptText("Ingredients");
        ingredientsArea.setPrefRowCount(4);

        TextArea instructionsArea = new TextArea();
        instructionsArea.setPromptText("Instructions");
        instructionsArea.setPrefRowCount(4);

        Button addButton = new Button("Add Recipe");
        Button deleteButton = new Button("Delete Recipe");

        // Recipe details view
        Label detailTitle = new Label("Recipe Details:");
        TextArea detailArea = new TextArea();
        detailArea.setEditable(false);
        detailArea.setPrefRowCount(8);

        VBox form = new VBox(10, nameField, ingredientsArea, instructionsArea, addButton, deleteButton, detailTitle, detailArea);
        form.setPadding(new Insets(10));
        form.setPrefWidth(400);

        BorderPane root = new BorderPane();
        root.setLeft(recipeList);
        root.setCenter(form);

        // Event: Add Recipe
        addButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String ingredients = ingredientsArea.getText().trim();
            String instructions = instructionsArea.getText().trim();

            if (!name.isEmpty() && !ingredients.isEmpty() && !instructions.isEmpty()) {
                manager.addRecipe(new Recipe(name, ingredients, instructions));
                nameField.clear();
                ingredientsArea.clear();
                instructionsArea.clear();
            } else {
                showAlert("Please fill all fields!");
            }
        });

        // Event: Delete Recipe
        deleteButton.setOnAction(e -> {
            Recipe selected = recipeList.getSelectionModel().getSelectedItem();
            if (selected != null) {
                manager.removeRecipe(selected);
                detailArea.clear();
            } else {
                showAlert("Select a recipe to delete!");
            }
        });

        // Event: View Recipe Details
        recipeList.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                detailArea.setText(
                    "Name: " + newSel.getName() + "\n\n" +
                    "Ingredients:\n" + newSel.getIngredients() + "\n\n" +
                    "Instructions:\n" + newSel.getInstructions()
                );
            }
        });

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


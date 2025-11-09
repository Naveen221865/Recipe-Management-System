package recipeapp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        RecipeManager manager = new RecipeManager();
        RecipeAppUI ui = new RecipeAppUI(manager);
        ui.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package be.kdg.sokoban;

import be.kdg.sokoban.view.start.StartPresenter;
import be.kdg.sokoban.view.start.StartView;
import be.kdg.sokoban.model.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Massimo on 10/02/2017.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        final Game model = new Game();
        final StartView view = new StartView();
        final StartPresenter presenter = new StartPresenter(model, view);
        Scene scene = new Scene(view);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Soko-Ban");
        primaryStage.setHeight(500);
        primaryStage.setWidth(300);
        primaryStage.setMinWidth(250);
        primaryStage.setMinHeight(400);
        presenter.addWindowEventHandlers();
        primaryStage.show();
        view.setFocusTraversable(true);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}

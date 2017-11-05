package be.kdg.sokoban.view.start;

import be.kdg.sokoban.model.Game;
import be.kdg.sokoban.view.game.GamePresenter;
import be.kdg.sokoban.view.game.GameView;
import be.kdg.sokoban.view.menu.MenuPresenter;
import be.kdg.sokoban.view.menu.MenuView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * Created by Massimo on 10/02/2017.
 */
public class StartPresenter {
    private Game model;
    private StartView view;

    public StartPresenter(Game model, StartView view){
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers(){
        view.getBtnPlay().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameView gameView = new GameView();
                new GamePresenter(model, gameView);
                view.getScene().setRoot(gameView);
                gameView.getScene().getWindow().sizeToScene();
            }
        });

        view.getBtnSelect().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuView menuView = new MenuView();
                new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });

        view.getBtnQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    private void updateView(){

    }

    public void addWindowEventHandlers () {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
           @Override
            public void handle(WindowEvent event){
               final Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
               confirm.setHeaderText("Ben je zeker?");
               confirm.setContentText("Ben je zeker dat je wil afsluiten?");
               Optional<ButtonType> keuze = confirm.showAndWait();
               if (keuze.get().getText().equalsIgnoreCase("CANCEL")) {
                   event.consume();
               }
           }
        });
    }
}

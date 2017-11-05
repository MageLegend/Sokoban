package be.kdg.sokoban.view.menu;

import be.kdg.sokoban.model.Game;
import be.kdg.sokoban.view.start.StartPresenter;
import be.kdg.sokoban.view.start.StartView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * Created by Massi on 22/04/2017.
 */
public class MenuPresenter {
    private Game model;
    private MenuView view;

    public MenuPresenter(Game model, MenuView view){
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers(){
        view.getBtnBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StartView menuView = new StartView();
                new StartPresenter(model, menuView);
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

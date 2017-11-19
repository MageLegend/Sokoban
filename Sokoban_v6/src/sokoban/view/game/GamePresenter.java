package be.kdg.sokoban.view.game;

import be.kdg.sokoban.model.*;
import be.kdg.sokoban.view.start.StartPresenter;
import be.kdg.sokoban.view.start.StartView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.util.List;

public class GamePresenter {
    private Game model;
    private GameView view;



    public GamePresenter(Game model, GameView view) {
        this.model = model;
        this.view = view;
        loadContents();
        addEventHandlers();
        updateView();
    }




    private void addEventHandlers() {
        view.getMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StartView menuView = new StartView();
                new StartPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });

        view.getQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

        view.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Speler player = model.getPlayer();
                final KeyCode key = event.getCode();

                switch (key) {
                    case UP:
                        player.moveUp();
                        event.consume();
                        break;
                    case DOWN:
                        player.moveDown();
                        event.consume();
                        break;
                    case LEFT:
                        player.moveLeft();
                        event.consume();
                        break;
                    case RIGHT:
                        player.moveRight();
                        event.consume();
                        break;
                    //default:
                        //event.consume();
                }
                updateView();
                showWinner();
            }
        });
    }

    private void loadContents() {
        model.setWalls(FieldLoader.loadWalls());
        model.setBestemmingen(FieldLoader.loadBestemmingen());
        model.setDozen(FieldLoader.loadDozen(model));
        model.setPlayer(FieldLoader.loadPlayer(model));
    }

    private void updateView() {
        view.getGrid().getChildren().clear();
        updateViewWalls();
        updateViewPlayer();
        updateViewDozen();
        updateViewBestemmingen();
    }

    private void updateViewWalls() {
        List<Wall> walls = model.getWalls();
        for (Wall wall : walls) {
            ImageView wallImg = new ImageView(wall.getSPRITE());
            wallImg.setPreserveRatio(true);
            wallImg.setFitWidth(30.0);
            view.getGrid().add(wallImg, wall.getX(), wall.getY());
        }
    }

    private void updateViewDozen() {
        List<Doos> dozen = model.getDozen();
        for (Doos doos : dozen) {
            ImageView doosImg = new ImageView(doos.getSPRITE());
            doosImg.setPreserveRatio(true);
            doosImg.setFitWidth(30.0);
            view.getGrid().add(doosImg, doos.getX(), doos.getY());
        }
    }

    private void updateViewPlayer() {
        Speler player = model.getPlayer();
        ImageView spelerImg = new ImageView(player.getSPRITE());
        spelerImg.setPreserveRatio(true);
        spelerImg.setFitWidth(30.0);
        view.getGrid().add(spelerImg, player.getX(), player.getY());
    }

    private void updateViewBestemmingen() {
        List<Bestemming> bestemmingen = model.getBestemmingen();
        for (Bestemming bestemming : bestemmingen) {
            ImageView bestemmingImg = new ImageView(bestemming.getSPRITE());
            bestemmingImg.setPreserveRatio(true);
            bestemmingImg.setFitWidth(30.0);
            view.getGrid().add(bestemmingImg, bestemming.getX(), bestemming.getY());
        }
    }

    private void showWinner(){
        List<Doos> dozen = model.getDozen();
        if (model.hasWon()){
            ImageView winner = new ImageView("be/kdg/sokoban/view/images/plaque.png");
            view.setTop(winner);
            BorderPane.setAlignment(winner, Pos.CENTER);
        }
    }
}

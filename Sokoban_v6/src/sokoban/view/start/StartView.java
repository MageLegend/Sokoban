package be.kdg.sokoban.view.start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;

public class StartView extends BorderPane {
    // private MenuItem aflsuiten;
    // private MenuItem over;

    private VBox vBox = new VBox();

    private Canvas canvas;
    private Label lblTitel;
    private Button btnPlay;
    private Button btnSelect;
    private Button btnQuit;

    private ImageView titel;


    public StartView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        /* this.aflsuiten = new MenuItem("Afsluiten");
        this.over = new MenuItem("Over");*/

        this.canvas = new Canvas();
        this.lblTitel = new Label("Sokoban");
        this.btnPlay = new Button("Play");
        this.btnSelect = new Button("Select a level");
        this.btnQuit = new Button("Quit");
        this.titel = new ImageView("be" + File.separator + "kdg" + File.separator + "sokoban" + File.separator + "view" + File.separator + "images" + File.separator + "Soko-ban_title.png");
    }

    private void layoutNodes(){
        // Menubar
        /*final Menu game = new Menu("Game", null, this.aflsuiten);
        final Menu help = new Menu("Help", null, this.over);
        final MenuBar menuBar = new MenuBar(game);
        this.setTop(menuBar);
        BorderPane.setMargin(menuBar, new Insets(0.0, 0.0, 100.0, 0.0));*/

        // overige controls
        this.setTop(titel);
        BorderPane.setAlignment(titel, Pos.TOP_CENTER);

        /*this.setCenter(btnPlay);
        this.setBottom(btnQuit);
        BorderPane.setAlignment(btnQuit, Pos.BOTTOM_CENTER);
        this.setMargin(btnQuit, new Insets(0, 0, 160 ,0));
        this.setRight(btnSelect);
        BorderPane.setAlignment(btnSelect, Pos.CENTER);*/

        this.setCenter(vBox);

        this.setPadding(new Insets(20));

        this.setBackground(new Background(
                new BackgroundImage(new Image("be/kdg/sokoban/view/images/background.jpg", 1500, 1500, true, true),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT
                )));
        // VBox settings

        vBox.setSpacing(20);
        vBox.setPadding(new Insets(35));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(btnPlay, btnSelect, btnQuit);
    }

    // getters voor controls

    Button getBtnPlay() {
        return btnPlay;
    }

    Button getBtnSelect() { return btnSelect; }

    Button getBtnQuit() { return btnQuit; }
}

package be.kdg.sokoban.view.menu;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;

/**
 * Created by Massi on 22/04/2017.
 */
public class MenuView extends BorderPane {
    private VBox vBox = new VBox();

    private ImageView titel;

    private Button btnBack;
    private Button btnQuit;
    private Button level1;
    private Button level2;
    private Button level3;
    private Button level4;
    private Button level5;

    public MenuView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.titel = new ImageView("be" + File.separator + "kdg" + File.separator + "sokoban" + File.separator + "view" + File.separator + "images" + File.separator + "Soko-ban_title.png");

        this.btnBack = new Button("Back");
        this.btnQuit = new Button("Quit");
        this.level1 = new Button("Level 1");
        this.level2 = new Button("Level 2");
        this.level3 = new Button("Level 3");
        this.level4 = new Button("Level 4");
        this.level5 = new Button("Level 5");
    }

    private void layoutNodes(){
        this.setTop(titel);
        BorderPane.setAlignment(titel, Pos.TOP_CENTER);

        this.setCenter(vBox);

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
        vBox.getChildren().addAll(level1, level2, level3, level4, level5, btnBack, btnQuit);
    }

    Button getBtnBack() {
        return btnBack;
    }

    Button getBtnQuit() {
        return btnQuit;
    }

    Button getLevel1() {
        return level1;
    }

    Button getLevel2() {
        return level2;
    }

    Button getLevel3() {
        return level3;
    }

    Button getLevel4() {
        return level4;
    }

    Button getLevel5() {
        return level5;
    }
}

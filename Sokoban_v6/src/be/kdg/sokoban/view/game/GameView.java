package be.kdg.sokoban.view.game;

import be.kdg.sokoban.model.Field;
import be.kdg.sokoban.model.Wall;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;

/**
 * Created by Massi on 5/03/2017.
 */
public class GameView extends BorderPane {
    private GridPane grid = new GridPane();

    private MenuItem aflsuiten;
    private MenuItem over;

    private Button quit;
    private Button menu;


    public GameView(){
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes(){
        this.aflsuiten = new MenuItem("Afsluiten");
        this.over = new MenuItem("Over");

        this.quit = new Button("Quit");
        this.menu = new Button("Menu");
    }

    private void layoutNodes(){
        this.setTop(grid);
        BorderPane.setAlignment(grid, Pos.TOP_CENTER);


        // Menubar
        final Menu game = new Menu("Game", null, this.aflsuiten);
        final Menu help = new Menu("Help", null, this.over);
        final MenuBar menuBar = new MenuBar(game);
        //this.setTop(menuBar);
        BorderPane.setMargin(menuBar, new Insets(0.0, 0.0, 100.0, 0.0));

        // overige controls

        this.setCenter(menu);
        this.setBottom(quit);
        BorderPane.setAlignment(quit, Pos.BOTTOM_CENTER);
        this.setMargin(quit, new Insets(20, 0, 60, 0));

        this.setBackground(new Background(
                new BackgroundImage(new Image("be/kdg/sokoban/view/images/background.jpg", 1500, 1500, true, true),
                        BackgroundRepeat.REPEAT,
                        BackgroundRepeat.REPEAT,
                        BackgroundPosition.CENTER,
                        BackgroundSize.DEFAULT
                )));

        // gridpane settings

        ColumnConstraints column1 = new ColumnConstraints(30.0);
        ColumnConstraints column2 = new ColumnConstraints(30.0);
        ColumnConstraints column3 = new ColumnConstraints(30.0);
        ColumnConstraints column4 = new ColumnConstraints(30.0);
        ColumnConstraints column5 = new ColumnConstraints(30.0);
        ColumnConstraints column6 = new ColumnConstraints(30.0);
        ColumnConstraints column7 = new ColumnConstraints(30.0);
        ColumnConstraints column8 = new ColumnConstraints(30.0);
        ColumnConstraints column9 = new ColumnConstraints(30.0);
        ColumnConstraints column10 = new ColumnConstraints(30.0);
        ColumnConstraints column11 = new ColumnConstraints(30.0);
        ColumnConstraints column12 = new ColumnConstraints(30.0);
        ColumnConstraints column13 = new ColumnConstraints(30.0);
        ColumnConstraints column14 = new ColumnConstraints(30.0);
        ColumnConstraints column15 = new ColumnConstraints(30.0);
        ColumnConstraints column16 = new ColumnConstraints(30.0);
        ColumnConstraints column17 = new ColumnConstraints(30.0);
        ColumnConstraints column18 = new ColumnConstraints(30.0);
        ColumnConstraints column19 = new ColumnConstraints(30.0);

        grid.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11, column12, column13, column14, column15, column16, column17, column18, column19);

        RowConstraints row1 = new RowConstraints(30.0);
        RowConstraints row2 = new RowConstraints(30.0);
        RowConstraints row3 = new RowConstraints(30.0);
        RowConstraints row4 = new RowConstraints(30.0);
        RowConstraints row5 = new RowConstraints(30.0);
        RowConstraints row6 = new RowConstraints(30.0);
        RowConstraints row7 = new RowConstraints(30.0);
        RowConstraints row8 = new RowConstraints(30.0);
        RowConstraints row9 = new RowConstraints(30.0);
        RowConstraints row10 = new RowConstraints(30.0);
        RowConstraints row11 = new RowConstraints(30.0);
        RowConstraints row12 = new RowConstraints(30.0);

        grid.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12);

        //grid.setGridLinesVisible(true);
    }

    // getters voor controls

    GridPane getGrid(){
        return grid;
    }

    Button getQuit() {
        return quit;
    }

    Button getMenu() {
        return menu;
    }
}

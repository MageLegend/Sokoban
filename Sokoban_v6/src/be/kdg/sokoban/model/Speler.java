package be.kdg.sokoban.model;

import java.io.File;
import java.util.List;

/**
 * Created by Massimo on 24/02/2017.
 */
public class Speler extends FieldObject {
    private static final String SPRITE = "be" + File.separator + "kdg" + File.separator + "sokoban" + File.separator + "view" + File.separator + "images" + File.separator + "player.png";

    private Game game;

    public Speler(Game game, int x, int y) {
        super(x, y);
        this.game = game;
    }

    public void moveUp(){
        int newx = x;
        int newy = y - 1;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();

        for (Wall wall : walls){
            if (wall.getX() == newx && wall.getY() == newy){
                return;
            }
        }

        for (Doos doos : dozen){
            if (doos.getX() == newx && doos.getY() == newy){
                doos.moveUp();
                // WIP
                if (doos.getX() == newx && doos.getY() != newy){
                    this.y = newy;
                }
                // end
                return;
            }
        }

        this.y = newy;
    }

    public void moveDown(){
        int newx = x;
        int newy = y + 1;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();

        for (Wall wall : walls){
            if (wall.getX() == newx && wall.getY() == newy){
                return;
            }
        }

        for (Doos doos : dozen){
            if (doos.getX() == newx && doos.getY() == newy){
                doos.moveDown();
                return;
            }
        }

        this.y = newy;
    }

    public void moveLeft(){
        int newx = x - 1;
        int newy = y;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();

        for (Wall wall : walls){
            if (wall.getX() == newx && wall.getY() == newy){
                return;
            }
        }

        for (Doos doos : dozen){
            if (doos.getX() == newx && doos.getY() == newy){
                doos.moveLeft();
                return;
            }
        }

        this.x = newx;
    }

    public void moveRight(){
        int newx = x + 1;
        int newy = y;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();

        for (Wall wall : walls){
            if (wall.getX() == newx && wall.getY() == newy){
                return;
            }
        }

        for (Doos doos : dozen){
            if (doos.getX() == newx && doos.getY() == newy){
                doos.moveRight();
                return;
            }
        }

        this.x = newx;
    }

    public static String getSPRITE() {
        return SPRITE;
    }
}

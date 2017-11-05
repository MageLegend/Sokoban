package be.kdg.sokoban.model;

import java.io.File;
import java.util.List;

/**
 * Created by Massimo on 24/02/2017.
 */
public class Doos extends FieldObject {
    private static final String SPRITE = "be" + File.separator + "kdg" + File.separator + "sokoban" + File.separator + "view" + File.separator + "images" + File.separator + "crate.png";
    private boolean onBestemming;

    private Game game;

    public Doos(Game game, int x, int y) {
        super(x, y);
        this.game = game;
        this.onBestemming = false;
    }


    // if move target = wall of box -> niet moven
    // if move target box, box.move
    // if move target = bestemming, onBestemming = true

    public void moveUp(){
        int newx = x;
        int newy = y - 1;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();
        List<Bestemming> bestemmingen = game.getBestemmingen();

        for (Wall wall : walls){
            if (wall.getX() == newx && wall.getY() == newy){
                return;
            }
        }

        for (Doos doos : dozen){
            if (doos.getX() == newx && doos.getY() == newy){
                doos.moveUp();
                return;
            }
        }

        for (Bestemming bestemming : bestemmingen){
            if (bestemming.getX() == newx && bestemming.getY() == newy){
                onBestemming = true;
            }
        }

        this.y = newy;
    }

    public void moveDown(){
        int newx = x;
        int newy = y + 1;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();
        List<Bestemming> bestemmingen = game.getBestemmingen();

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

        for (Bestemming bestemming : bestemmingen){
            if (bestemming.getX() == newx && bestemming.getY() == newy){
                onBestemming = true;
            }
        }

        this.y = newy;
    }

    public void moveLeft(){
        int newx = x - 1;
        int newy = y;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();
        List<Bestemming> bestemmingen = game.getBestemmingen();

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

        for (Bestemming bestemming : bestemmingen){
            if (bestemming.getX() == newx && bestemming.getY() == newy){
                onBestemming = true;
            }
        }

        this.x = newx;
    }

    public void moveRight(){
        int newx = x + 1;
        int newy = y;

        List<Wall> walls = game.getWalls();
        List<Doos> dozen = game.getDozen();
        List<Bestemming> bestemmingen = game.getBestemmingen();

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

        for (Bestemming bestemming : bestemmingen){
            if (bestemming.getX() == newx && bestemming.getY() == newy){
                onBestemming = true;
            }
        }

        this.x = newx;
    }


    public boolean isOnBestemming() {
        return onBestemming;
    }

    public static String getSPRITE() {
        return SPRITE;
    }
}

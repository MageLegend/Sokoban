package be.kdg.sokoban.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Massi on 28/02/2017.
 */
public class Game {
    private List<Wall> walls;
    private Speler player;
    private List<Doos> dozen;
    private List<Bestemming> bestemmingen;

    public Game() {
        this.walls = new ArrayList<>();
        this.dozen = new ArrayList<>();
        this.bestemmingen = new ArrayList<>();

    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public Speler getPlayer() {
        return player;
    }

    public void setPlayer(Speler player) {
        this.player = player;
    }

    public List<Doos> getDozen() {
        return dozen;
    }

    public void setDozen(List<Doos> dozen) {
        this.dozen = dozen;
    }

    public List<Bestemming> getBestemmingen() {
        return bestemmingen;
    }

    public void setBestemmingen(List<Bestemming> bestemmingen) {
        this.bestemmingen = bestemmingen;
    }

    @Override
    public String toString() {
        return "Game{" +
                "walls=" + walls +
                ", player=" + player +
                ", dozen=" + dozen +
                ", bestemmingen=" + bestemmingen +
                '}';
    }

    public boolean hasWon() {
        for (Doos doos : dozen) {
            if (!doos.isOnBestemming()){
                return false;
            }
        }
        return true;
    }
}

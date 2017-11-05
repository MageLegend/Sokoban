package be.kdg.sokoban.model;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Massimo on 13/03/2017.
 */
public class FieldLoader {

    static Path path = Paths.get("levels" + File.separator + "level1.txt");

    public static List<Wall> loadWalls() {
        List<Wall> walls = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line = reader.readLine();
            int x = 0;
            int y = 0;
            while (line != null) {
                String[] symbolen = line.split("");
                for (String karakter : symbolen) {
                    if (karakter.equals("#")) {
                        walls.add(new Wall(x, y));
                    }
                    x += 1;
                }
                line = reader.readLine();
                x = 0;
                y += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return walls;
    }

    public static Speler loadPlayer(Game game) {
        Speler player = new Speler(game, 0, 0);
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line = reader.readLine();
            int x = 0;
            int y = 0;
            while (line != null) {
                String[] symbolen = line.split("");
                for (String karakter : symbolen) {
                    if (karakter.equals("@")) {
                        player = new Speler(game, x, y);
                    }
                    x += 1;
                }
                line = reader.readLine();
                x = 0;
                y += 1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return player;
    }

    public static List<Doos> loadDozen(Game game) {
        List<Doos> dozen = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))){
            String line = reader.readLine();
            int x = 0;
            int y = 0;
            while (line != null) {
                String[] symbolen = line.split("");
                for (String karakter : symbolen) {
                    if (karakter.equals("$")) {
                        dozen.add(new Doos(game, x, y));
                    }
                    x += 1;
                }
                line = reader.readLine();
                x = 0;
                y += 1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dozen;
    }

    public static List<Bestemming> loadBestemmingen() {
        List<Bestemming> bestemmingen = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))){
            String line = reader.readLine();
            int x = 0;
            int y = 0;
            while (line != null) {
                String[] symbolen = line.split("");
                for (String karakter : symbolen) {
                    if (karakter.equals(".")) {
                        bestemmingen.add(new Bestemming(x, y));
                    }
                    x += 1;
                }
                line = reader.readLine();
                x = 0;
                y += 1;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bestemmingen;
    }
}

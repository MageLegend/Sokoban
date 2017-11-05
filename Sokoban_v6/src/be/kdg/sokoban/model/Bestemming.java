package be.kdg.sokoban.model;

import java.io.File;

/**
 * Created by Massimo on 24/02/2017.
 */
public class Bestemming extends FieldObject {
    private static final String SPRITE = "be" + File.separator + "kdg" + File.separator + "sokoban" + File.separator + "view" + File.separator + "images" + File.separator + "target.png";

    public Bestemming(int x, int y) {
        super(x, y);
    }

    public static String getSPRITE() {
        return SPRITE;
    }
}

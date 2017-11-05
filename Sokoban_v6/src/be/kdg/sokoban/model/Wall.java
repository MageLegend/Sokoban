package be.kdg.sokoban.model;

import java.io.File;

/**
 * Created by Massimo on 10/03/2017.
 */
public class Wall extends FieldObject {
    private static final String SPRITE = "be" + File.separator + "kdg" + File.separator + "sokoban" + File.separator + "view" + File.separator + "images" + File.separator + "block.png";

    public Wall(int x, int y){
        super(x, y);
    }

    public String getSPRITE() {
        return SPRITE;
    }
}

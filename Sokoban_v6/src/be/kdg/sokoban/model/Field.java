package be.kdg.sokoban.model;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Massi on 28/02/2017.
 */
public class Field {
    public int width;
    public int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

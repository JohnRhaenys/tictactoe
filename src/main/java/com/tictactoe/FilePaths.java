package com.tictactoe;

import java.nio.file.Paths;

public class FilePaths {
    public static final String IMAGES_BASE_PATH = Paths.get(
            "src", "main", "resources",
            "com", "tictactoe", "images"
    ).toString();

    public static final String X_IMAGE_PATH = Paths.get(
            IMAGES_BASE_PATH, "x.png"
    ).toString();

    public static final String CIRCLE_IMAGE_PATH = Paths.get(
            IMAGES_BASE_PATH, "circle.png"
    ).toString();
}

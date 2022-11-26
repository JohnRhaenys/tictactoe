package com.tictactoe.utils;

import com.tictactoe.game_entities.Line;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Helpers {
    public static String getFilename(String uri) {
        char pathSeparator = File.separatorChar;
        int index = uri.lastIndexOf(pathSeparator);
        return uri.substring(index + 1);
    }

    public static ArrayList<Line> getValuesFromHashMap(HashMap<Integer, Line> hashMap) {
        ArrayList<Line> values = new ArrayList<>();
        for (Map.Entry<Integer, Line> element : hashMap.entrySet()) {
            values.add(element.getValue());
        }
        return values;
    }
}

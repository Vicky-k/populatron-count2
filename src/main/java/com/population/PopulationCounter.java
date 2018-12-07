package com.population;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PopulationCounter {

    public static String getPopulation(final String inputPath)  throws IOException {
        long sum = 0;
        String path = inputPath;
        List<String> lines = UserFileReader.readFile(path);
        for(int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] terms = line.split(",");
            String popText = terms[4];
            if(popText.length() == 0) {
                continue;
            }
            long population = Integer.parseInt(popText);
            sum += population;
        }
        String num = NumberFormat.getInstance(Locale.getDefault()).format(sum);
        return num;
    }
}
package core.basesyntax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileWork {
    public static final char LETTER_W = 'w';

    public String[] readFromFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                String[] parts = value.toLowerCase().split("\\W+");
                for (String s : parts) {
                    if (s.charAt(0) == LETTER_W) {
                        stringBuilder.append(s.toLowerCase()).append(",");
                    }
                }
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file!", e);
        }
        String[] output = stringBuilder.toString().split(",");
        Arrays.sort(output);
        return (output[0].equals("")) ? new String[]{} : output;
    }
}


package Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataReader {
    public static Map<String, String> readData(File file){
        Map<String, String> result = new HashMap<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bf.readLine()) != null) {
                result.put(line.split(":")[0], line.split(":")[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

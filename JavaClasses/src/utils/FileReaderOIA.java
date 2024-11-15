package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderOIA <T extends TextProcessor<T>> {
    
    public void fileReader(T obj, String path, String file) {
    	String fileName = path + file;
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            List<String> lineas = new ArrayList<>();
            String linea;
            
            while ((linea = br.readLine()) != null)
            	lineas.add(linea);
            
            String[] data = lineas.toArray(new String[lineas.size()]);
            
            obj.textProcess(data);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
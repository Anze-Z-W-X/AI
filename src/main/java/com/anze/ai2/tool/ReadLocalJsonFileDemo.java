package com.anze.ai2.tool;
import java.io.*;
public class ReadLocalJsonFileDemo {
    public static String readerMethod(String uri) throws IOException {
        File file = new File(uri);
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), "Utf-8");
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while ((ch = reader.read()) != -1) {
            sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        return sb.toString();
    }
}


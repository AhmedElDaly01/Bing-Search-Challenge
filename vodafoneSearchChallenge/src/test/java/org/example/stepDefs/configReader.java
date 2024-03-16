package org.example.stepDefs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {


    public static void set(String key, String value) {

        try {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("config.properties");
        prop.load(fis);
        prop.setProperty(key, value);
        fis.close();

        FileOutputStream fos = new FileOutputStream("config.properties");
        prop.store(fos, "");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String get(String key) {

        String value;

        try {
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            prop.load(fis);
            value = prop.getProperty(key);
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;

    }
}

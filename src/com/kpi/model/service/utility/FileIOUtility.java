package com.kpi.model.service.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class FileIOUtility {
    public static final String FILE_NAME = "data.txt";
    public static final String OUTER = "Updated: ";
    public static final String LOG_FILE = "log.txt";

    public static void writeArrayUtility(String filename, ArrayList<?> array) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(array);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static ArrayList<?> readArrayUtility(String filename) {
        ArrayList<?> array = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            array = ((ArrayList<?>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return array;
    }

    public static void writeFile(String text, String filename) {
        try(FileWriter writer = new FileWriter(filename, true))
        {
            writer.write(OUTER + new Date().toString() + "\n" + text);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

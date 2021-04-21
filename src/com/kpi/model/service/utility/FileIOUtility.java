package com.kpi.model.service.utility;

import java.io.*;
import java.util.ArrayList;

public class FileIOUtility {
    public static final String FILE_NAME = "data.txt";

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
}

package com.kpi.view;

public class ShopView {

    public static final String INPUT_FLOWER_ID = "Enter flower ID = ";
    public static final String INPUT_FLOWER_TITLE = "Enter flower title = ";
    public static final String INPUT_FLOWER_TYPE = "Enter flower type = ";
    public static final String INPUT_FLOWER_SPECIES = "Enter flower species = ";
    public static final String INPUT_FLOWER_SUBSPECIES = "Enter flower subspecies = ";
    public static final String INPUT_FLOWER_PRICE = "Enter flower price = ";
    public static final String INPUT_FLOWER_COUNT = "Enter flower count = ";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please!";
    public static final String FLOWERING_INDOOR_FLOWERS = "Flowering indoor flowers: ";
    public static final String LIST_OF_CURRENT_FLOWER_SUBSPECIES = "Current flower subspecies and count: ";
    public static final String NO_SUCH_FLOWERS = "No such flowers!";
    public static final String INPUT_MAIN_MENU_OPTION = "Selected option = ";
    public static final String OUTPUT_ALL_FLOWERS = "All flowers in shop: ";

    public static final String MAIN_MENU = "Main menu:" + "\n"
            + "1 - Add flower to the shop" + "\n"
            + "2 - Show flowering indoor flowers" + "\n"
            + "3 - Enter flower to get list of it's subspecies and count" + "\n"
            + "4 - Show all flowers" + "\n"
            + "0 - Exit" + "\n";

    public void printMessage(String message) {
        System.out.print(message);
    }

    public void printMessageAndResultList(String message, String value) {
        System.out.println(message);
        if (value.length() != 0)
            System.out.println(value);
        else
            System.out.println(NO_SUCH_FLOWERS);
    }
}

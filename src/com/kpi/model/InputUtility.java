package com.kpi.model;

import com.kpi.view.ShopView;

import java.util.Scanner;

public class InputUtility {

    private static final Scanner sc = new Scanner(System.in);

    public static String inputString(ShopView view, String message) {
        view.printMessage(message);
        return sc.next();
    }

    public static int inputIntValue(ShopView view, String message) {
        view.printMessage(message);
        while (!sc.hasNextInt()) {
            view.printMessage(view.WRONG_INPUT_DATA + message);
            sc.next();
        }
        return sc.nextInt();
    }

}

package com.kpi.model.service.utility;

import com.kpi.model.exсeptions.InvalidInputRuntimeException;
import com.kpi.view.ShopView;

import java.util.Scanner;

public class InputUtility {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputString(ShopView view, String message) {
        view.printMessage(message);
        return SCANNER.next();
    }

    public static int inputIntValue(ShopView view, String message) {
        view.printMessage(message);
        String input = SCANNER.next();
        try {
            Validator.isNumber(input);
        } catch (InvalidInputRuntimeException e) {
            view.printMessage(e.getMessage() + "\n");
            return inputIntValue(view, message);
        }
        return Integer.parseInt(input);
    }

    public static int inputIntPositiveValue(ShopView view, String message) {
        view.printMessage(message);
        String input = SCANNER.next();
        try {
            Validator.isNumber(input);
            Validator.checkPositiveNumber(Integer.parseInt(input));
        } catch (InvalidInputRuntimeException e) {
            view.printMessage(e.getMessage() + "\n");
            return inputIntValue(view, message);
        }
        return Integer.parseInt(input);
    }
}

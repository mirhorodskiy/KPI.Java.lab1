package com.kpi.controller;

import com.kpi.model.*;
import com.kpi.view.ShopView;

public class ShopController {
    private ShopModel model = new ShopModel();
    private ShopView view = new ShopView();

    public void menu() {
        while (true) {
            view.printMessage(view.MAIN_MENU);
            switch (InputUtility.inputIntValue(view, view.INPUT_MAIN_MENU_OPTION)) {
                case 0:
                    return;
                case 1:
                    model.addFlower(new Flowers(
                            InputUtility.inputIntValue(view, view.INPUT_FLOWER_ID),
                            InputUtility.inputString(view, view.INPUT_FLOWER_TITLE),
                            InputUtility.inputString(view, view.INPUT_FLOWER_TYPE),
                            InputUtility.inputString(view, view.INPUT_FLOWER_SPECIES),
                            InputUtility.inputString(view, view.INPUT_FLOWER_SUBSPECIES),
                            InputUtility.inputIntValue(view, view.INPUT_FLOWER_PRICE),
                            InputUtility.inputIntValue(view, view.INPUT_FLOWER_COUNT)
                    ));

                    break;
                case 2:
                    view.printMessageAndResultList(view.FLOWERING_INDOOR_FLOWERS,
                            model.getFloweringIndoorFlowersAndPrices());
                    break;
                case 3:
                    view.printMessageAndResultList(view.LIST_OF_CURRENT_FLOWER_SUBSPECIES,
                            model.getSubspeciesAndCountsOfFlower(InputUtility.inputString(view, view.INPUT_FLOWER_TITLE)));
                    break;
                case 4:
                    view.printMessageAndResultList(view.OUTPUT_ALL_FLOWERS, model.getListOfFlowers());
                    break;
                default:
                    view.printMessage(view.WRONG_INPUT_DATA);
            }
        }
    }
}

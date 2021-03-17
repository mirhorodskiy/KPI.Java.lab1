package com.kpi.controller;

import com.kpi.model.domain.Flower;
import com.kpi.model.service.ShopModel;
import com.kpi.model.service.utility.InputUtility;
import com.kpi.view.ShopView;

import static com.kpi.view.ViewConstant.*;

public class ShopController {
    private ShopModel model = new ShopModel();
    private ShopView view = new ShopView();

    public void menu() {
        while (true) {
            view.printMessage(MAIN_MENU);
            switch (InputUtility.inputIntValue(view, INPUT_MAIN_MENU_OPTION)) {
                case 0:
                    return;
                case 1:
                    model.addFlower(new Flower(
                            InputUtility.inputIntPositiveValue(view, INPUT_FLOWER_ID),
                            InputUtility.inputString(view, INPUT_FLOWER_TITLE),
                            InputUtility.inputString(view, INPUT_FLOWER_TYPE),
                            InputUtility.inputString(view, INPUT_FLOWER_SPECIES),
                            InputUtility.inputString(view, INPUT_FLOWER_SUBSPECIES),
                            InputUtility.inputIntPositiveValue(view, INPUT_FLOWER_PRICE),
                            InputUtility.inputIntPositiveValue(view, INPUT_FLOWER_COUNT)
                    ));

                    break;
                case 2:
                    view.printMessageAndResultList(FLOWERING_INDOOR_FLOWERS,
                            model.getFloweringIndoorFlowersAndPrices());
                    break;
                case 3:
                    view.printMessageAndResultList(LIST_OF_CURRENT_FLOWER_SUBSPECIES,
                            model.getSubspeciesAndCountsOfFlower(InputUtility.inputString(view, INPUT_FLOWER_TITLE)));
                    break;
                case 4:
                    view.printMessageAndResultList(OUTPUT_ALL_FLOWERS, model.getListOfFlowers());
                    break;
                default:
                    view.printMessage(WRONG_INPUT_DATA);
            }
        }
    }
}

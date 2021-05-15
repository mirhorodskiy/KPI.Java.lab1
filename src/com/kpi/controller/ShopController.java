package com.kpi.controller;

import com.kpi.model.domain.Flower;
import com.kpi.model.service.ShopModel;
import com.kpi.model.service.impl.ShopModelImpl;
import com.kpi.view.ConsoleInput;
import com.kpi.view.ShopView;

import java.io.IOException;

import static com.kpi.view.ViewConstant.*;

public class ShopController {
    private static final String DATA_READ_ERROR = "Data read error";
    private static final String DATA_WRITE_ERROR = "Dara write error";
    private final ShopView view;
    private ShopModel shopModel;

    public ShopController() {
        this.view = new ShopView();
        try {
            this.shopModel = new ShopModelImpl();
        } catch (Exception exception) {
            view.printMessage(DATA_READ_ERROR);
            System.exit(1);
        }
    }

    public void menu() {
        try {
            startProcess();
        } catch (IOException ex) {
            view.printMessage(DATA_WRITE_ERROR);
            System.exit(1);
        }
    }

    public void startProcess() throws IOException {
        while (true) {
            view.printMessage(MAIN_MENU);
            switch (ConsoleInput.inputIntValue(view, INPUT_MAIN_MENU_OPTION)) {

                //adding flower to the shop
                case 1:
                    shopModel.addFlower(new Flower(
                            ConsoleInput.inputIntPositiveValue(view, INPUT_FLOWER_ID),
                            ConsoleInput.inputString(view, INPUT_FLOWER_TITLE),
                            ConsoleInput.inputString(view, INPUT_FLOWER_TYPE),
                            ConsoleInput.inputString(view, INPUT_FLOWER_SPECIES),
                            ConsoleInput.inputString(view, INPUT_FLOWER_SUBSPECIES),
                            ConsoleInput.inputIntPositiveValue(view, INPUT_FLOWER_PRICE),
                            ConsoleInput.inputIntPositiveValue(view, INPUT_FLOWER_COUNT)
                    ));

                    break;

                // show flowering indoor flowers
                case 2:
                    String floweringIndoorFlowers = "Flowering indoor flowers: " +
                            shopModel.getFloweringIndoorFlowersAndPrices();
                    view.printMessageAndResultList(FLOWERING_INDOOR_FLOWERS,
                            floweringIndoorFlowers);
                    shopModel.writeFile(floweringIndoorFlowers);
                    break;

                // get subspecies and count of flower
                case 3:
                    String subspeciesAndCountOfFlower =
                            shopModel.getSubspeciesAndCountsOfFlower(ConsoleInput.inputString(view, INPUT_FLOWER_TITLE));
                    view.printMessageAndResultList(LIST_OF_CURRENT_FLOWER_SUBSPECIES,
                            subspeciesAndCountOfFlower);
                    shopModel.writeFile(subspeciesAndCountOfFlower);
                    break;

                // print all flowers in shop
                case 4:
                    view.printMessageAndResultList(OUTPUT_ALL_FLOWERS, shopModel.getListOfFlowers());
                    break;
                default:
                    view.printMessage(WRONG_INPUT_DATA);

                    // exit
                case 0:
                    view.printMessage(SAVING_DATA);
                    while (true) {
                        switch (ConsoleInput.inputIntValue(view, SAVING_DATA_CHOICE)) {
                            case 1:
                                shopModel.saveChanges(shopModel.getFlowers());
                                shopModel.writeFile(shopModel.toString());
                                view.printMessage(DATA_UPDATING);
                                return;
                            case 2:
                                return;
                            default:
                                view.printMessage(WRONG_INPUT_DATA);
                        }
                    }
            }
        }
    }
}

package com.kpi.controller;

import com.kpi.model.domain.Flower;
import com.kpi.model.service.ShopService;
import com.kpi.model.service.impl.ShopServiceImpl;
import com.kpi.view.ConsoleInput;
import com.kpi.view.ShopView;

import java.io.IOException;

import static com.kpi.view.ViewConstant.*;

public class ShopController {
    private static final String FILE_DOES_NOT_EXIST = "File does not exist";
    private ShopService shopService;
    private ShopView view;

    public ShopController() {
        this.shopService = new ShopServiceImpl();
        this.view = new ShopView();
        initFlowersData();
    }

    private void initFlowersData() {
        try {
            shopService.readFlowersArray();
        } catch (Exception ex) {
            view.printMessage(FILE_DOES_NOT_EXIST);
            System.exit(1);
        }
    }

    public void menu() {
        try {
            startProcess();
        } catch (IOException ex) {
            view.printMessage(FILE_DOES_NOT_EXIST);
            System.exit(1);
        }
    }

    public void startProcess() throws IOException {
        while (true) {
            view.printMessage(MAIN_MENU);
            switch (ConsoleInput.inputIntValue(view, INPUT_MAIN_MENU_OPTION)) {

                //adding flower to the shop
                case 1:
                    shopService.addFlower(new Flower(
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
                    view.printMessageAndResultList(FLOWERING_INDOOR_FLOWERS,
                            shopService.getFloweringIndoorFlowersAndPrices());
                    break;

                // get subspecies and count of flower
                case 3:
                    view.printMessageAndResultList(LIST_OF_CURRENT_FLOWER_SUBSPECIES,
                            shopService.getSubspeciesAndCountsOfFlower(ConsoleInput.inputString(view, INPUT_FLOWER_TITLE)));
                    break;

                // print all flowers in shop
                case 4:
                    view.printMessageAndResultList(OUTPUT_ALL_FLOWERS, shopService.getListOfFlowers());
                    break;
                default:
                    view.printMessage(WRONG_INPUT_DATA);

                    // exit
                case 0:
                    view.printMessage(SAVING_DATA);
                    while (true) {
                        switch (ConsoleInput.inputIntValue(view, SAVING_DATA_CHOICE)) {
                            case 1:
                                shopService.saveChanges();
                                shopService.writeFile(shopService.toString());
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

package com.kpi.model.service;

import com.kpi.model.domain.Flower;

import java.io.IOException;

public interface ShopService {
    void writeFile(String text) throws IOException;

    void readFlowersArray() throws Exception;

    void saveChanges() throws IOException;

    void addFlower(Flower flower);

    String getFloweringIndoorFlowersAndPrices();

    String getSubspeciesAndCountsOfFlower(String flowerName);

    String getListOfFlowers();
}

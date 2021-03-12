package com.kpi.model;

import java.util.Arrays;

public class ShopModel {
    private int flowersCount;
    private Flowers[] flowersArray;

    public ShopModel() {
        flowersArray = DataSource.flowers;
        flowersCount = DataSource.flowers.length;
    }

    public ShopModel(Flowers[] flowers) {
        this.flowersArray = flowers;
        this.flowersCount = flowers.length;
    }

    private Flowers[] expandArray() {
        return Arrays.copyOf(this.flowersArray, this.flowersArray.length*2);
    }

    public void addFlower(Flowers flower) {
        if (flowersCount == flowersArray.length)
            this.flowersArray = expandArray();
        flowersArray[flowersCount] = flower;
        flowersCount++;
    }

    public String getFloweringIndoorFlowersAndPrices() {
        StringBuilder sb = new StringBuilder();
        for (Flowers f : flowersArray) {
            if (f.getType().equals("indoor") && f.getSpecies().equals("flowering"))
                sb.append("Type: ").append(f.getTitle()).append(", price: ").append(f.getPrice()).append("\n");
        }
        return sb.toString();
    }

    public String getSubspeciesAndCountsOfFlower(String flower) {
        StringBuilder sb = new StringBuilder();
        for (Flowers f : flowersArray) {
            if (f.getTitle().equals(flower))
                sb.append("Subspecies: ").append(f.getSubspecies()).append(", count: ").append(f.getCount()).append("\n");
        }
        return sb.toString();
    }


    public String getListOfFlowers() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < flowersCount; i++) {
            sb.append(flowersArray[i].toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ShopModel{" +
                "flowersCount=" + flowersCount +
                ", flowersArray=" + Arrays.toString(flowersArray) +
                '}';
    }
}

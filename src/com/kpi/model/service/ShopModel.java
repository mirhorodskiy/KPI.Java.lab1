package com.kpi.model.service;

import com.kpi.model.DataSource;
import com.kpi.model.domain.Flower;

import java.util.Arrays;

public class ShopModel {
    private int flowersCount;
    private Flower[] flowers;

    public ShopModel() {
        flowers = DataSource.flowers;
        flowersCount = DataSource.flowers.length;
    }

//    public ShopModel(Flowers[] flowers) {
//        this.flowersArray = flowers;
//        this.flowersCount = flowers.length;
//    }

    private Flower[] expandArray() {
        return Arrays.copyOf(this.flowers, this.flowers.length * 2);
    }

    /**
     * This method add flower to shop
     * @param flower
     */
    public void addFlower(Flower flower) {
        if (flowersCount == flowers.length){
            this.flowers = expandArray();
        }
        flowers[flowersCount] = flower;
        flowersCount++;
    }

    public String getFloweringIndoorFlowersAndPrices() {
        StringBuilder builder = new StringBuilder();
        for (Flower flower : flowers) {
            if (flower.getType().equals("indoor") && flower.getSpecies().equals("flowering")) {
                builder.append("Type: ")
                        .append(flower.getTitle())
                        .append(", price: ")
                        .append(flower.getPrice())
                        .append("\n");
            }
        }
        return builder.toString();
    }

    public String getSubspeciesAndCountsOfFlower(String flowerName) {
        StringBuilder builder = new StringBuilder();
        for (Flower flower : flowers) {
            if (flower.getTitle().equals(flowerName)) {
                builder.append("Subspecies: ")
                        .append(flower.getSubspecies())
                        .append(", count: ")
                        .append(flower.getCount())
                        .append("\n");
            }
        }
        return builder.toString();
    }

    public String getListOfFlowers() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < flowersCount; i++) {
            builder.append(flowers[i].toString()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "ShopModel{" +
                "flowersCount=" + flowersCount +
                ", flowersArray=" + Arrays.toString(flowers) +
                '}';
    }
}

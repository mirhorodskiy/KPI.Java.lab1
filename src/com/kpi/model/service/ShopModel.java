package com.kpi.model.service;

import com.kpi.model.domain.Flower;
import com.kpi.model.service.utility.FileIOUtility;


import java.util.ArrayList;

public class ShopModel {

    private ArrayList<Flower> flowers = new ArrayList<>();

    public ShopModel(String filename) {
        flowers = (ArrayList<Flower>) FileIOUtility.readArrayUtility(filename);
    }



//    private Flower[] expandArray() {
//        return Arrays.copyOf(this.flowers, this.flowers.length * 2);
//    }
//
//    public void addFlower(Flower flower) {
//        if (flowersCount == flowers.length){
//            this.flowers = expandArray();
//        }
//        flowers[flowersCount] = flower;
//        flowersCount++;
//    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void saveChanges(String filename) {
        FileIOUtility.writeArrayUtility(filename, flowers);
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
        for (int i = 0; i < flowers.size(); i++) {
            builder.append(flowers.get(i).toString()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "ShopModel{" +
                "flowersCount=" + flowers.size() +
                ", flowersArray=" + flowers.toString() +
                '}';
    }
}

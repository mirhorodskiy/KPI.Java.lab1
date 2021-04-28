package com.kpi.model.service.impl;

import com.kpi.model.domain.Flower;
import com.kpi.model.service.ShopService;

import java.io.*;
import java.util.Date;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private static final String FILE_NAME = "data.txt";
    private static final String OUTER = "Updated: ";
    private static final String LOG_FILE = "log.txt";
    private List<Flower> flowers;

    public void writeFile(String text) throws IOException {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(OUTER + new Date().toString() + "\n" + text + "\n");
            writer.flush();
        }
    }

    public void readFlowersArray() throws Exception {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            flowers = (List<Flower>) inputStream.readObject();
        }
    }

    public void saveChanges() throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            outputStream.writeObject(flowers);
        }
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
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
        for (Flower flower : flowers) {
            builder.append(flower.toString()).append("\n");
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

package com.kpi.model;

public class Flowers {
    private int id;
    private String title;
    private String type;
    private String species;
    private String subspecies;
    private int price;
    private int count;

    public Flowers(int id, String title, String type, String species, String subspecies, int price, int count) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.species = species;
        this.subspecies = subspecies;
        this.price = price;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getSpecies() {
        return species;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", species='" + species + '\'' +
                ", subspecies='" + subspecies + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}

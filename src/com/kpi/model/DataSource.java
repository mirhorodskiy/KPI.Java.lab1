package com.kpi.model;


import com.kpi.model.domain.Flower;

public class DataSource {
    public static Flower[] flowers = {
            new Flower(1, "Rose", "outdoor",
                    "flowering", "red", 55, 100),
            new Flower(2, "Rose", "outdoor",
                    "flowering", "yellow", 50, 80),
            new Flower(3, "Rose", "indoor",
                    "flowering", "purple", 100, 30),
            new Flower(3, "violet", "indoor",
                    "flowering", "purple", 40, 20),
    };
}

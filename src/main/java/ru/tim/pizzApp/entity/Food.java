package ru.tim.pizzApp.entity;

public class Food {
    private int food_id;
    private String name;
    private String description;
    private int price;
    private int weight;
    private int type;

    public Food() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Food(int food_id, String name, String description, int price, int weight, int type) {
        this.food_id = food_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.type = type;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

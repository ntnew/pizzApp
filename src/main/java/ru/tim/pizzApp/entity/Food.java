package ru.tim.pizzApp.entity;

public class Food {
    private int food_id;
    private String name;
    private String description;
    private double price;
    private int weight;
    private String type;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Food() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Food(int food_id, String name, String description, double price, int weight, String type, String image) {
        this.food_id = food_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.type = type;
        this.image = image;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

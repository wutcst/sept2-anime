package cn.edu.whut.sept.zuul;

public class Item {
    private String name;
//    private String description;
    private int number;
    private double weight;

    public Item(String name, int number, double weight) {

        this.name = name;
        this.number = number;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }

    public double getWeight() {
        return weight;
    }
}

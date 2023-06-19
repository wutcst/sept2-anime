package cn.edu.whut.sept.zuul;

/**
 * Item类表示游戏中的物品。
 * 包含物品的名称、数量和重量信息。
 */
public class Item {
    private String name;
//    private String description;
    private int number;
    private double weight;

    /**
     * 构造一个具有指定名称、数量和重量的物品对象。
     *
     * @param name   物品的名称。
     * @param number 物品的数量。
     * @param weight 物品的重量。
     */
    public Item(String name, int number, double weight) {

        this.name = name;
        this.number = number;
        this.weight = weight;
    }

    /**
     * 返回物品的名称。
     *
     * @return 物品的名称。
     */
    public String getName() {
        return name;
    }
    /**
     * 返回物品的数量。
     *
     * @return 物品的数量。
     */
    public int getNumber() {
        return number;
    }
    /**
     * 返回物品的重量。
     *
     * @return 物品的重量。
     */
    public double getWeight() {
        return weight;
    }
}

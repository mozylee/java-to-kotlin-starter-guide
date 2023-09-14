package com.lannstark.lec17;

public class Fruit {

    private final String name;
    private final int price;

    private final int factoryPrice;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
        this.factoryPrice = price * 2;
    }

    public Fruit(String name, int price, int factoryPrice) {
        this.name = name;
        this.price = price;
        this.factoryPrice = factoryPrice;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getFactoryPrice() {
        return factoryPrice;
    }

    public boolean isApple() {
        return this.name.equals("사과");
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", factoryPrice=" + factoryPrice +
                '}';
    }

}

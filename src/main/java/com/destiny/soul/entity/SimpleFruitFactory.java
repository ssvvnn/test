package com.destiny.soul.entity;

/**
 * @author zhuhaifeng
 * @since 2020-11-26
 */
public class SimpleFruitFactory {
    public Fruit getFruit(FruitType fruitType) {
        if (fruitType.name().equals(FruitType.APPLE.name())) {
            return new Apple();
        }
        if (fruitType.name().equals(FruitType.ORANGE.name())) {
            return new Orange();
        }
        return null;
    }
}

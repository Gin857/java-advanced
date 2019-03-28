package com.soft1841.test;

/**
 * Goods封装类
 */
public class Goods implements Comparable<Goods>{
    private String name;
    private Integer price;
    private Integer stock;

    public Goods(String name, Integer price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Goods(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int compareTo(Goods goods) {
        return  this.getStock() - goods.getStock();
    }
}

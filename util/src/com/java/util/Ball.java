package com.java.util;

public class Ball {

    private String name;
    private String chuohao;
    private Double defen;
    private Double lanban;
    private Double zhugong;


    public Ball(String name, String chuohao, Double defen, Double lanban, Double zhugong) {
        this.name = name;
        this.chuohao = chuohao;
        this.defen = defen;
        this.lanban = lanban;
        this.zhugong = zhugong;
    }

    public Ball(){

    }

    public String getName() {
        return name;
    }

    public String getChuohao() {
        return chuohao;
    }

    public Double getDefen() {
        return defen;
    }

    public Double getLanban() {
        return lanban;
    }

    public Double getZhugong() {
        return zhugong;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "name='" + name + '\'' +
                ", chuohao='" + chuohao + '\'' +
                ", defen=" + defen +
                ", lanban=" + lanban +
                ", zhugong=" + zhugong +
                '}';
    }
}

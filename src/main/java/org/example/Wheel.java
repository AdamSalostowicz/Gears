package org.example;

public class Wheel {
    private String ertro;
    private String tireSize;
    private double circumference;

    public Wheel(String ertro, String tireSize, double circumference) {
        this.ertro = ertro;
        this.tireSize = tireSize;
        this.circumference = circumference;
    }

    public String getErtro() {
        return ertro;
    }

    public String getTireSize() {
        return tireSize;
    }

    public double getCircumference() {
        return circumference;
    }

}

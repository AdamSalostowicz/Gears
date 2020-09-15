package org.example;
import java.io.*;
import java.util.LinkedList;

@SuppressWarnings("ALL")
public class Velocity {

    private double cadence;
    private double numberTeethOfCasette;
    private double numberTeethOfChainring;
    public static LinkedList<Wheel> wheels;
    private double circumference;

    public Velocity(double cadence, double numberTeethOfCasette, double numberTeethOfChainring) throws IOException {
        this.cadence = cadence;
        this.numberTeethOfCasette = numberTeethOfCasette;
        this.numberTeethOfChainring = numberTeethOfChainring;
        this.circumference = 2000;
        printList();
    }

    public double getCadence() {
        return cadence;
    }

    public void setCadence(double cadence) {
        this.cadence = cadence;
    }

    public double getNumberTeethOfCasette() {
        return numberTeethOfCasette;
    }

    public void setNumberTeethOfCasette(double numberTeethOfCasette) {
        this.numberTeethOfCasette = numberTeethOfCasette;
    }

    public double getNumberTeethOfChainring() {
        return numberTeethOfChainring;
    }

    public void setNumberTeethOfChainring(double numberTeethOfChainring) {
        numberTeethOfChainring = numberTeethOfChainring;
    }

    public static LinkedList<Wheel> fillList() throws IOException {
        String ertro;
        String size;
        double circumference;
        wheels = new LinkedList<Wheel>();
        File file = new File("src/main/resources/circumferences.txt");
        try {
            String currentLine;
            String[] parts;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while ((currentLine = bufferedReader.readLine()) != null) {
                parts = currentLine.split(",");
                ertro = parts[0];
                size = parts[1];
                circumference = Double.parseDouble(parts[2]);
                wheels.add(new Wheel(ertro, size, circumference));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wheels;
    }

    public static void printList() {
        for (Wheel wheel: wheels
        ) {
            System.out.println("Ertro: " + wheel.getErtro() + ", size: " + wheel.getTireSize() + ", circumstances is equal: " + wheel.getCircumference());
        }
    }

}


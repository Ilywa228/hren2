package com;

import java.util.ArrayList;

public class Flowerbed implements Runnable {
    private int totalAmountOfPlants;
    public ArrayList<com.Plant> listOfPlants = new ArrayList<>(totalAmountOfPlants);
    com.FlowerQueue flowerQueue;

    public Flowerbed(int totalAmountOfPlants) {
        this.totalAmountOfPlants = totalAmountOfPlants;
    }

    public int getTotalAmountOfPlants() {
        return this.totalAmountOfPlants;
    }

    public void setFlowerQueue(com.FlowerQueue flowerQueue) {
        this.flowerQueue = flowerQueue;
    }

    public void fillList() {
        int numOfStatus;
        for (int i = 0; i < this.totalAmountOfPlants; i++) {
            numOfStatus = (int) (Math.random() * 2);
            if (numOfStatus == 0) {
                this.listOfPlants.add(new com.Plant("Faded"));
            } else {
                this.listOfPlants.add(new com.Plant("Watered"));
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < this.listOfPlants.size(); i++) {
            this.flowerQueue.put(this.listOfPlants.get(i));
        }
    }
}
package com;

import java.util.ArrayList;

public class FlowerQueue {
    private int totalAmountOfPlants;
    private int numOfPlantsToHandle = 0;
    private int amountHandledPlants = 0;
    private ArrayList<com.Plant> listPlantsToHandle = new ArrayList<>();
    private boolean allTasksDone = false;

    public FlowerQueue(int totalAmountOfPlants) {
        this.totalAmountOfPlants = totalAmountOfPlants;
    }

    public synchronized void put(com.Plant plant) {
        while (this.numOfPlantsToHandle >= 2) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.listPlantsToHandle.add(plant);
        this.numOfPlantsToHandle++;
        notify();
    }

    public synchronized int getAmountHandledPlants() {
        return this.amountHandledPlants;
    }

    public synchronized boolean getAllTasksDone() {
        return this.allTasksDone;
    }

    public synchronized com.Plant get() {
        while ((this.numOfPlantsToHandle < 1) && (this.amountHandledPlants < this.totalAmountOfPlants) && (this.listPlantsToHandle.size() == 0)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.numOfPlantsToHandle--;
        com.Plant plant = null;
        if (this.amountHandledPlants < this.totalAmountOfPlants) {
            this.amountHandledPlants++;
            int indexToRemove = 0;
            plant = this.listPlantsToHandle.get(indexToRemove);
            this.listPlantsToHandle.remove(indexToRemove);
        } else {
            this.allTasksDone = true;
        }
        notify();
        return plant;
    }
}
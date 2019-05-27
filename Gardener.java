package com;

public class Gardener implements Runnable {
    private int totalAmountOfPlants;
    FlowerQueue flowerQueue;
    FlowerbedUpdater flowerbedUpdater;

    public Gardener(int totalAmountOfPlants, FlowerQueue flowerQueue, FlowerbedUpdater flowerbedUpdater) {
        this.totalAmountOfPlants = totalAmountOfPlants;
        this.flowerQueue = flowerQueue;
        this.flowerbedUpdater = flowerbedUpdater;
    }

    @Override
    public void run() {
        while ((this.flowerQueue.getAmountHandledPlants() < this.totalAmountOfPlants) || (this.flowerQueue.getAllTasksDone() == false)) {
            Plant plant = this.flowerQueue.get();
            if (plant != null) {
                this.flowerbedUpdater.water(plant);
            }
        }
    }
}
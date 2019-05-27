package com;
//        На клумбі росте 40 квитів, за ними безперервно стежать два садівника і поливають зів'ялі квіти,
//        при цьому обидва садівника дуже бояться полити одну і ту же квітку. Створити багатопотоковий додаток,
//        що моделює стан клумби і дії садівників.

public class Main {

    public static void main(String[] args) throws Exception {
        com.Flowerbed flowerbed = new com.Flowerbed(40);
        FlowerQueue flowerQueue = new FlowerQueue(flowerbed.getTotalAmountOfPlants());
        flowerbed.setFlowerQueue(flowerQueue);
        flowerbed.fillList();
        FlowerbedUpdater flowerbedUpdater = new FlowerbedUpdater();
        Thread threadFlowerbed = new Thread(flowerbed);
        Printer.printList(flowerbed.listOfPlants);
        Thread firstGardener = new Thread(new Gardener(flowerbed.getTotalAmountOfPlants(), flowerQueue, flowerbedUpdater));
        Thread secondGardener = new Thread(new Gardener(flowerbed.getTotalAmountOfPlants(), flowerQueue, flowerbedUpdater));
        threadFlowerbed.start();
        firstGardener.start();
        secondGardener.start();
        threadFlowerbed.join();
        firstGardener.join();
        secondGardener.join();
        Printer.printList(flowerbed.listOfPlants);
    }
}
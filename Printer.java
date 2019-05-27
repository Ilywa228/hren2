package com;

import java.util.ArrayList;

public class Printer {
    public static void printList(ArrayList<com.Plant> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).getStatus() + ", ");
        }
        System.out.println("\n");
    }
}
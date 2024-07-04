package org.example;

import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el límite inferior del rango: ");
        int less = scanner.nextInt();
        System.out.print("Ingrese el límite superior del rango: ");
        int high = scanner.nextInt();
        scanner.close();

        FriendNumbers friendNumbers = new FriendNumbers(less, high);

        int range = (high - less + 1) / 3;
        int start1 = less;
        int end1 = start1 + range - 1;
        int start2 = end1 + 1;
        int end2 = start2 + range - 1;
        int start3 = end2 + 1;
        int end3 = high;

        RunnerFriends task1 = new RunnerFriends(friendNumbers, start1, end1);
        RunnerFriends task2 = new RunnerFriends(friendNumbers, start2, end2);
        RunnerFriends task3 = new RunnerFriends(friendNumbers, start3, end3);

        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();

        Map<Integer, Integer> friends = friendNumbers.getFriends();
        for (Map.Entry<Integer, Integer> entry : friends.entrySet()) {
            System.out.println(entry.getKey() + " y " + entry.getValue() + " son números amigos.");
        }

        System.out.println("Tiempo inicial: " + startTime + " ms");
        System.out.println("Tiempo final: " + endTime + " ms");
        System.out.println("Tiempo total de ejecución: " + (endTime - startTime) + " ms");
    }
}
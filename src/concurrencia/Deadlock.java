package concurrencia;

import java.util.concurrent.*;

public class Deadlock {
    public static void main(String[] args) {
// Create participants and resources
        FoxDeadlock robin = new FoxDeadlock();
        FoxDeadlock miki = new FoxDeadlock();
        FoodDeadlock foodDeadlock = new FoodDeadlock();
        WaterDeadlock waterDeadlock = new WaterDeadlock();
// Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> robin.eatAndDrink(foodDeadlock, waterDeadlock));
            service.submit(() -> miki.drinkAndEat(foodDeadlock, waterDeadlock));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}

class FoodDeadlock {}

class WaterDeadlock {}

class FoxDeadlock {
    public void eatAndDrink(FoodDeadlock foodDeadlock, WaterDeadlock waterDeadlock) {
        synchronized(foodDeadlock) {
            System.out.println("Robin: Got deadlock.Food!");
            move();
            synchronized(waterDeadlock) {
                System.out.println("Robin: Got deadlock.Water!");
            }
        }
    }
    public void drinkAndEat(FoodDeadlock foodDeadlock, WaterDeadlock waterDeadlock) {
        synchronized(waterDeadlock) {
            System.out.println("Miki: Got deadlock.Water!");
            move();
            synchronized(foodDeadlock) {
                System.out.println("Miki: Got deadlock.Food!");
            }
        }
    }
    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
// Handle exception
        }
    }
}
package concurrencia;
import java.util.concurrent.*;

public class Livelock {
    public static void main(String[] args) {
// Create participants and resources
        FoxLivelock robin = new FoxLivelock();
        FoxLivelock miki = new FoxLivelock();
        FoodLivelock food = new FoodLivelock();
        WaterLivelock water = new WaterLivelock();
// Process data
        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> robin.eatAndDrink(food,water));
            service.submit(() -> miki.drinkAndEat(food,water));
        } finally {
            if(service != null) service.shutdown();
        }
    }
}

class FoodLivelock {}

class WaterLivelock {}

class FoxLivelock {
    public void eatAndDrink(FoodLivelock food, WaterLivelock water) {
        synchronized(food) {
            System.out.println("Got Food!");
            move();
        }
        drinkAndEat(food, water);
    }
    public void drinkAndEat(FoodLivelock food, WaterLivelock water) {
        synchronized(water) {
            System.out.println("Got Water!");
            move();
        }
        eatAndDrink(food, water);
    }
    public void move() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
// Handle exception
        }
    }
}
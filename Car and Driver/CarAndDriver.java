class Car {
    protected int gas;

    public Car() {
        gas = 10;
    }

    public int getGas() {
        return gas;
    }

    public void displayStatus() {
        System.out.println("Gas remaining: " + gas + "/10");
    }

    public void gameOver() {
        if (gas == 0) {
            System.out.println("Game Over! The car is out of gas.");
        }
    }
}

class Driver extends Car {
    public void drive() {
        if (gas > 0) {
            System.out.println("You drive the car.");
            gas--;
        } else {
            gameOver();
        }
        displayStatus();
    }

    public void boost() {
        if (gas >= 3) {
            System.out.println("You use boosters.");
            gas -= 3;
        } else {
            System.out.println("Not enough gas for boosters.");
        }
        displayStatus();
    }

    public void refuel() {
        if (gas < 8) {
            System.out.println("You refuel the car.");
            gas += 2;
        } else {
            System.out.println("Gas tank is almost full. No need to refuel.");
        }
        displayStatus();
    }
}

public class CarAndDriver {
    public static void main(String[] args) {
        Driver driver = new Driver();

        driver.drive();
        driver.drive();
        driver.drive();
        driver.drive();
        driver.boost();
        driver.refuel();
        driver.refuel();
        driver.refuel();
    }
}

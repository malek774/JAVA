class Bat extends Mammal {
    public Bat() {
        energyLevel = 300;
    }

    public void fly() {
        System.out.println("Bat takes off and flies.");
        energyLevel -= 50;
    }

    public void eatHumans() {
        System.out.println("Bat eats humans, gaining energy.");
        energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("Bat attacks a town, causing chaos.");
        energyLevel -= 100;
    }
}
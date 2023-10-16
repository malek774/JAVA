class Gorilla extends Mammal {
    public void throwSomething() {
        System.out.println("Gorilla throws something!");
        energyLevel -= 5;
    }

    public void eatBananas() {
        System.out.println("Gorilla is satisfied after eating bananas.");
        energyLevel += 10;
    }

    public void climb() {
        System.out.println("Gorilla climbs a tree.");
        energyLevel -= 10;
    }
}

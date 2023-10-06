class Mammal {
    protected int energyLevel;

    public Mammal() {
        energyLevel = 100;
    }

    public int displayEnergy() {
        System.out.println("Energy level: " + energyLevel);
        return energyLevel;
    }
}

// class Gorilla extends Mammal {
//     public void throwSomething() {
//         System.out.println("Gorilla throws something!");
//         energyLevel -= 5;
//     }

//     public void eatBananas() {
//         System.out.println("Gorilla is satisfied after eating bananas.");
//         energyLevel += 10;
//     }

//     public void climb() {
//         System.out.println("Gorilla climbs a tree.");
//         energyLevel -= 10;
//     }
// }

// class Bat extends Mammal {
//     public Bat() {
//         energyLevel = 300;
//     }

//     public void fly() {
//         System.out.println("Bat takes off and flies.");
//         energyLevel -= 50;
//     }

//     public void eatHumans() {
//         System.out.println("Bat eats humans, gaining energy.");
//         energyLevel += 25;
//     }

//     public void attackTown() {
//         System.out.println("Bat attacks a town, causing chaos.");
//         energyLevel -= 100;
//     }
// }

// public class Zookeeper {
//     public static void main(String[] args) {
//         // Test Gorilla
//         Gorilla gorilla = new Gorilla();
//         gorilla.throwSomething();
//         gorilla.throwSomething();
//         gorilla.throwSomething();
//         gorilla.eatBananas();
//         gorilla.eatBananas();
//         gorilla.climb();
//         gorilla.displayEnergy();

//         // Test Bat
//         Bat bat = new Bat();
//         bat.attackTown();
//         bat.attackTown();
//         bat.attackTown();
//         bat.eatHumans();
//         bat.eatHumans();
//         bat.fly();
//         bat.fly();
//         bat.displayEnergy();
//     }
// }

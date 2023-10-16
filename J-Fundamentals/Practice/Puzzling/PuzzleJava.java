import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    // Method to generate and return an array with 10 random numbers between 1 and 20 inclusive
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        Random randMachine = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = randMachine.nextInt(20) + 1;
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    // Method to generate a random letter from the alphabet
    public char getRandomLetter() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random randMachine = new Random();
        int randomIndex = randMachine.nextInt(26);
        return alphabet[randomIndex];
    }

    // Method to generate a random string of eight characters
    public String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char randomLetter = getRandomLetter();
            password.append(randomLetter);
        }
        return password.toString();
    }

    // Method to create an array of random eight-character words
    public String[] getNewPasswordSet(int length) {
        String[] passwordSet = new String[length];
        for (int i = 0; i < length; i++) {
            passwordSet[i] = generatePassword();
        }
        return passwordSet;
    }

    // Method to shuffle an array in a pseudo-random way
    public void shuffleArray(int[] array) {
        Random randMachine = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = randMachine.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}

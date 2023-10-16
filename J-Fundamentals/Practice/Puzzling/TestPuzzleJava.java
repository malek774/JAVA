import java.util.ArrayList;

public class TestPuzzleJava {

    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();

        // Test getTenRolls
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("Random Rolls: " + randomRolls);

        // Test getRandomLetter
        char randomLetter = generator.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);

        // Test generatePassword
        String password = generator.generatePassword();
        System.out.println("Generated Password: " + password);

        // Test getNewPasswordSet
        String[] passwordSet = generator.getNewPasswordSet(5);
        System.out.println("Generated Password Set:");
        for (String pwd : passwordSet) {
            System.out.println(pwd);
        }

        // Test shuffleArray (SENSEI BONUS)
        int[] arrayToShuffle = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Original Array: " + java.util.Arrays.toString(arrayToShuffle));
        generator.shuffleArray(arrayToShuffle);
        System.out.println("Shuffled Array: " + java.util.Arrays.toString(arrayToShuffle));
    }
}

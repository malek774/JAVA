import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                // Code to handle the Integer value
            } catch (ClassCastException e) {
                System.out.println("Error occurred at index " + i + ": " + e.getMessage());
                System.out.println("Value causing the error: " + myList.get(i));
            }
        }

        System.out.println("Continue with the rest of the program.");
    }
}

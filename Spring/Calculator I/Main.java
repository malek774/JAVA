public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setOperandOne(10.5);
        calculator.setOperation("+");
        calculator.setOperandTwo(5.2);
        calculator.performOperation();

        double result = calculator.getResults();
        System.out.println("Result: " + result);  // Output: 15.7
    }
}

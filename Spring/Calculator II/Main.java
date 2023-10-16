public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        calculator.setOperand(10.5);
        calculator.setOperation("+");
        calculator.setOperand(5.2);
        calculator.setOperation("*");
        calculator.setOperand(10);
        calculator.setOperation("=");

        double result = calculator.getResults();
        System.out.println("Result: " + result);  // Output: 62.5
    }
}

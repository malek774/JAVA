public class Calculator {
    private double result;
    private double currentOperand;
    private String currentOperation;
    private boolean hasPendingOperation;

    // Constructor
    public Calculator() {
        this.result = 0;
        this.currentOperand = 0;
        this.currentOperation = "";
        this.hasPendingOperation = false;
    }

    // Set the current operand
    public void setOperand(double operand) {
        if (hasPendingOperation) {
            calculateResult();
            hasPendingOperation = false;
        }
        currentOperand = operand;
    }

    // Set the current operation
    public void setOperation(String operation) {
        currentOperation = operation;
        hasPendingOperation = true;
    }

    // Perform the operation and update the result
    private void calculateResult() {
        switch (currentOperation) {
            case "+":
                result += currentOperand;
                break;
            case "-":
                result -= currentOperand;
                break;
            case "*":
                result *= currentOperand;
                break;
            case "/":
                if (currentOperand != 0) {
                    result /= currentOperand;
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
        }
    }

    // Get the final result
    public double getResults() {
        calculateResult();
        return result;
    }
}

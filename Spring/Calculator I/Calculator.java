public class Calculator {
    private double operandOne;
    private double operandTwo;
    private String operation;

    // Constructor
    public Calculator() {
        this.operandOne = 0;
        this.operandTwo = 0;
        this.operation = "";
    }

    // Setter for operandOne
    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    // Setter for operation
    public void setOperation(String operation) {
        if (operation.equals("+") || operation.equals("-")) {
            this.operation = operation;
        } else {
            System.out.println("Invalid operation. Only '+' and '-' are supported.");
        }
    }

    // Setter for operandTwo
    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    // Perform operation based on the set operation
    public void performOperation() {
        if (operation.equals("+")) {
            operandOne += operandTwo;
        } else if (operation.equals("-")) {
            operandOne -= operandTwo;
        } else {
            System.out.println("No operation set.");
        }
    }

    // Get the results of the performed operations
    public double getResults() {
        return operandOne;
    }
}

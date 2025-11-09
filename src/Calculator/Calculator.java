package Calculator;

import javax.swing.*;
import java.util.Objects;

public class Calculator {
    private CalculatorGUI calculatorGUI;
    private int result = 0;

    public Calculator(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
    }

    public void computeResult() {

        String operator = Objects.requireNonNull(calculatorGUI.cbOperations.getSelectedItem()).toString();

        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
                if (calculatorGUI.tfNumber1.getText().isEmpty() || calculatorGUI.tfNumber2.getText().isEmpty()) {
                    result = -1;
                    break;
                }

                int num1 = Integer.parseInt(calculatorGUI.tfNumber1.getText());
                int num2 = Integer.parseInt(calculatorGUI.tfNumber2.getText());

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) result = -1;
                        else result = num1 / num2;
                        break;
                }
                break;
        }

        calculatorGUI.updateText(result);
    }
}

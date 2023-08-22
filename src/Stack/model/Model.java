package Stack.model;

import java.util.*;
/**
 *
 * @author jhonm
 */
public class Model {

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static boolean hasHigherPrecedence(char op1, char op2) {
        return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
    }

    public static void performOperation(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = applyOperator(operand1, operand2, operator);
        operandStack.push(result);
    }

    public static double applyOperator(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador invalido: " + operator);
        }
    }
}

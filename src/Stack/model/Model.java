package Stack.model;

import java.util.*;
/**
 *
 * @author jhonm
 */
public class Model {
    
    public double evaluateExpression(String expression) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder numBuilder = new StringBuilder();
                numBuilder.append(ch);

                while (i + 1 < expression.length() && (Character.isDigit(expression.charAt(i + 1)) || expression.charAt(i + 1) == '.')) {
                    numBuilder.append(expression.charAt(i + 1));
                    i++;
                }

                double num = Double.parseDouble(numBuilder.toString());
                operandStack.push(num);
            } else if (ch == '(') {
                operatorStack.push(ch);
            } else if (ch == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.pop(); // Expulsa el parentesis de la pila de operadores
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), ch)) {
                    performOperation(operandStack, operatorStack);
                }
                operatorStack.push(ch);
            }
        }

        while (!operatorStack.isEmpty()) {
            performOperation(operandStack, operatorStack);
        }

        return operandStack.pop();
    }

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

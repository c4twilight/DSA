package com.example.test.problem445.stack;
import java.sql.SQLOutput;
import java.util.*;
public class InfixToPrefix {
//    public static void main(String[] args) {
//        String s = ("x+y*z/w+u");
//        // Function call
//        System.out.print(infixToPrefix(s));
//    }

    /**
     *
     * steps :-
     * Step 1: Reverse the infix expression. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
     * Step 2: Convert the reversed infix expression to “nearly” postfix expression.
     * While converting to postfix expression, instead of using pop operation to pop operators with greater than or equal precedence, here we will only pop the operators from stack that have greater precedence.
     * Step 3: Reverse the postfix expression.
     * @param infixExpression
     * @return
     */
    public static String infixToPrefix(String infixExpression) {


        char [] infix = infixExpression.toCharArray();
        //replace open '( with close ') and vs;

        for(int i=0; i<infix.length; i++){
            if(infix[i] == '('){
                infix[i] = ')';
                i++;
            }
            else if(infix[i] == ')'){
                infix[i] = '(';
                i++;
            }
        }
        reverse(infix); // reverse the infixexpresiion
        char[] ReversePrefix = infixToPostfix(infix); // but we won't for equal precedence.
        reverse(ReversePrefix);
        return String.valueOf(ReversePrefix);
    }
    public static char[] infixToPostfix(char[] infixExpression) {
        //Deque<Character> stack= new ArrayDeque<Character>();
        Stack<Character> operatorStack = new Stack<>();//{maintain lower precdence to higher: higher should be on top}
        StringBuilder postfixExpression = new StringBuilder();

        for (char currentChar : infixExpression) {
            if (Character.isLetterOrDigit(currentChar)) {
                // Operand: Append to the postfix expression
                postfixExpression.append(currentChar);
            } else if (currentChar == '(') {
                // Left parenthesis: Push onto the stack
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                // Right parenthesis: Pop operators from the stack and append to the postfix expression
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.pop(); // Pop the '(' from the stack
            } else {
                // Operator: Pop operators with higher or equal precedence from the stack and then push the current operator
                while (!operatorStack.isEmpty() && precedence(currentChar) < precedence(operatorStack.peek())) {
                    postfixExpression.append(operatorStack.pop());
                }
                operatorStack.push(currentChar);
            }
        }

        // Pop any remaining operators from the stack and append to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfixExpression.append(operatorStack.pop());
        }

        return postfixExpression.toString().toCharArray();
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;

            default:
                return -1; // Unknown operator
        }
    }

    private static void reverse(char[] arr){
        int s =0, e= arr.length-1;

        while(s<e) {
            char temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}

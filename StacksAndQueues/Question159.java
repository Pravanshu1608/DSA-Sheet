package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/* Infix to Postfix

Given an infix expression in the form of string str. Convert this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Note: The order of precedence is: ^ greater than * equals to / greater than + equals to -. 
Example 1:

Input: str = "a+b*(c^d-e)^(f+g*h)-i"
Output: abcd^e-fgh*+^*+i-
Explanation:
After converting the infix expression 
into postfix expression, the resultant 
expression will be abcd^e-fgh*+^*+i-
Example 2:

Input: str = "A*(B+C)/D"
Output: ABC+*D/
Explanation:
After converting the infix expression 
into postfix expression, the resultant 
expression will be ABC+*D/
 
Your Task:
This is a function problem. You only need to complete the function infixToPostfix() that takes a string(Infix Expression) as a parameter and returns a string(postfix expression). The printing is done automatically by the driver code.

Expected Time Complexity: O(|str|).
Expected Auxiliary Space: O(|str|).

Constraints:
1 ≤ |str| ≤ 105



*/

public class Question159 {
    public static int prec(char ch){
        switch(ch){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        String res = "";
        Deque<Character> stack = new ArrayDeque();
        for(int i=0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                res+=c;
            } else if(c=='('){
                stack.push(c);
            } else if(c==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    res+=stack.peek();
                    stack.pop();
                }
                stack.pop();
            } else{
                while(!stack.isEmpty() && prec(c) <= prec(stack.peek())){
                    res+=stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            res+=stack.peek();
            stack.pop();
        }
        return res;
    }
}

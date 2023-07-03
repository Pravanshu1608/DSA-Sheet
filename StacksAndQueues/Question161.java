package StacksAndQueues;

import java.util.Stack;

public class Question161 {
    public static int longestParentheses(String str){
        int n = str.length();

        Stack<Integer> index = new Stack<>();
        Stack<Character> character = new Stack<>();

        int result = 0;
        index.push(-1);
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(ch=='('){
                character.push(ch);
                index.push(i);
            } else{
                if(!character.isEmpty()){
                    character.pop();
                    index.pop();
                    result = Math.max(result, i-index.peek());
                } else{
                    index.push(i);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "()(()))))";

        System.out.println(longestParentheses(str));
    }
}

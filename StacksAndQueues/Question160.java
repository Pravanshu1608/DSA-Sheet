package StacksAndQueues;

import java.util.Stack;

/* Design and Implement Special Stack Data Structure */

public class Question160 extends Stack<Integer> {
    Stack<Integer> min = new Stack<>();

    void push(int data){
        if(isEmpty()==true){
            super.push(data);
            min.push(data);
        } else{
            super.push(data);
            int y = min.pop();
            min.push(y);

            if(data<=y){
                min.push(data);
            }
        }
    }

    public Integer pop(){
        int x = super.pop();
        int y = min.pop();

        if(y!=x){
            min.push(y);
        }
        return x;
    }

    int getMin(){
        int x = min.pop();
        min.push(x);
        return x;
    }

    public static void main(String[] args) {
        Question160 specialStack = new Question160();
        specialStack.push(10);
        specialStack.push(20);
        specialStack.push(30);
        System.out.println(specialStack.getMin());
        specialStack.push(5);
        System.out.println(specialStack.getMin());
        specialStack.pop();
        System.out.println(specialStack.getMin());
    }
}

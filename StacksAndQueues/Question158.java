package StacksAndQueues;

public class Question158 {
    class Node{
        Node prev;
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    Node head;
    Node mid;
    int size;

    public void push(int data){
        Node new_node = new Node(data);
        if(size==0){
            head = new_node;
            mid = new_node;
            size++;
            return;
        }
        head.next = new_node;
        new_node.prev = head;
        head = head.next;
        if(size%2!=0){
            mid = mid.next;
        }
        size++;
    }

    public int pop(){
        int data = -1;
        if(size==0){
            System.out.println("The stack is empty");
        }
        if(size!=0){
            if(size==1){
                head=null;
                mid=null;
            } else{
                data = head.data;
                head = head.prev;
                head.next=null;
                if(size%2==0){
                    mid = mid.prev;
                }
            }
            size--;
        }
        return data;
    }

    public int findMiddle(){
        if(size==0){
            System.out.println("The stack is empty");
            return -1;
        }
        return mid.data;
    }

    public void deleteMiddleElement(){
        if(size!=0){
            if(size==1){
                head = null;
                mid = null;
            } else if(size==2){
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            } else{
                mid.next.prev = mid.prev;
                mid.prev.next = mid.next;
                if(size%2==0){
                    mid = mid.prev;
                } else{
                    mid = mid.next;
                }
            }
            size--;
        }
    }

    public static void main(String[] args) {
        Question158 stack = new Question158();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.push(66);
        stack.push(77);
        stack.push(88);
        stack.push(99);
        System.out.println(stack.findMiddle());
        System.out.println(stack.pop());
        System.out.println(stack.findMiddle());
        System.out.println(stack.pop());
        System.out.println(stack.findMiddle());

        stack.deleteMiddleElement();

        System.out.println(stack.findMiddle());


    }
}

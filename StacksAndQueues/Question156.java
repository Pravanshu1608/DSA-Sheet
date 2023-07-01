package StacksAndQueues;

public class Question156 {
    static class DequeNode {
        int value;
        DequeNode next;
        DequeNode prev;
    }

    static class deque {
        DequeNode head;
        DequeNode tail;

        public deque() {
            head = tail = null;
        }

        boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }

        int size() {
            if (!isEmpty()) {
                int length = 0;
                DequeNode temp = head;
                while (temp.next != null) {
                    length++;
                    temp = temp.next;
                }
                return length;
            }
            return 0;
        }

        void insert_FirstElement(int data) {
            DequeNode temp = new DequeNode();
            temp.value = data;
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                head.prev = temp;
                temp.prev = null;
                temp.next = head;
                head = temp;
            }
        }

        void insert_LastElement(int data) {
            DequeNode temp = new DequeNode();
            temp.value = data;
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            } else {
                tail.next = temp;
                temp.prev = tail;
                temp.next = null;
                tail = temp;
            }
        }

        void remove_first() {
            if (!isEmpty()) {
                DequeNode temp = head;
                head = head.next;
                head.prev = null;
                return;
            } else {
                System.out.println("The list is empty");
            }
        }

        void remove_last() {
            if (!isEmpty()) {
                DequeNode temp = tail;
                tail = tail.prev;
                if(tail!=null){
                    tail.next = null;
                }
                return;
            }
            System.out.print("The List is Empty");
        }

        void display() {
            if (!isEmpty()) {
                DequeNode temp = head;
                while (temp != null) {
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }
                System.out.println();
            } else {
                System.out.println("The list is empty");
            }
        }
    }

    static class Stack {
        deque d = new deque();

        public void push(int data) {
            d.insert_LastElement(data);
        }

        public int size() {
            return d.size();
        }

        public void pop() {
            d.remove_last();
        }

        public void display() {
            d.display();
        }

    }

    static class Queue {
        deque d = new deque();

        public void Enque(int data) {
            d.insert_FirstElement(data);
        }

        public void dequeue() {
            d.remove_first();
        }

        public void display() {
            d.display();
        }

        public int size() {
            return d.size();
        }
    }

    public static void main(String[] args) {
        Stack stk = new Stack();

        stk.push(7);
        stk.push(8);
        stk.push(9);
        stk.push(10);
        stk.display();
        stk.pop();
        stk.display();
        stk.pop();
        stk.display();
        stk.pop();
        stk.display();

        System.out.println();

        Queue q = new Queue();

        q.Enque(6);
        q.Enque(8);
        q.Enque(14);
        q.Enque(16);
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
        q.dequeue();
        q.display();
    }
}

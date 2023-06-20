package LinkedList;


public class Question136 {
    class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    Node tail = null;
    public void add(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printZigZag(){
        Node temp = head;
        boolean flag = true;
        int var = 0;
        while(temp!=null && temp.next!=null){
            if(flag == true){
                if(temp.data>temp.next.data){
                    var = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = var;
                }
            } else{
                if(temp.data < temp.next.data){
                    var = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = var;
                }
            }
            temp = temp.next;
            flag = !flag;
        }
    }
    
    public static void main(String[] args) {
        Question136 ll = new Question136();
        ll.add(4);
        ll.add(3);
        ll.add(7);
        ll.add(8);
        ll.add(6);
        ll.add(2);
        ll.add(1); 
        ll.display();
        ll.printZigZag();
        ll.display();
    }
}

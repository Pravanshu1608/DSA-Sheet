package LinkedList;

public class Question129 {
    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node push(Node head, int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void display(Node head){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void sortList(Node head){
        int count[] = {0, 0, 0};

        Node temp = head;
        while(temp!=null){
            count[temp.data]++;
            temp = temp.next;
        }
        int i=0;
        temp = head;
        while(temp!=null){
            if(count[i]==0){
                i++;
            } else{
                temp.data = i;
                count[i]--;
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) {
        Node head = null;
 
        // Insert some elements into the linked list
        head = push(head, 0);
        head = push(head, 1);
        head = push(head, 0);
        head = push(head, 2);
        head = push(head, 1);
        head = push(head, 1);
        head = push(head, 2);
        head = push(head, 1);
        head = push(head, 2);
 
        System.out.println("Linked List before Sorting: ");
        display(head);

        sortList(head);
        System.out.println("Linked List after Sorting: ");
        display(head);

        
    }
}

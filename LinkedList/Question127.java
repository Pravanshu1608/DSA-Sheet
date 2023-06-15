package LinkedList;

/* 707. Design Linked List

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
 

Constraints:

0 <= index, val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.

*/

public class Question127 {
    Node head;
    int size;

    class Node{
        int val;
        Node next;
        
        public Node(int val){
            this.val = val;
        }
    }
    public MyLinkedList() {
    }
    
    public int get(int index) {
        if(index < 0 || index >= size)
            return -1;
        Node temp = head;
        int count = 0;
        while(count != index){
            temp = temp.next;
            count++;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(size == 0)
            addAtHead(val);
        else{
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            Node newNode = new Node(val);
            temp.next = newNode;
            size++;
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        
        if(index == 0)
            addAtHead(val);
        else if(index == size)
            addAtTail(val);
        else{
            Node temp = head;
            int count = 0;
            while(count != index-1){
                temp = temp.next;
                count++;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size)
            return;
        
        if(index == 0){
            Node temp = head.next;
            head = temp;
            size--;
        } else {
            int count = 0;
            Node pre = head;
            while(count != index-1){
                pre = pre.next;
                count++;
            }
            pre.next = pre.next.next;
            size--;
        }
    }
}

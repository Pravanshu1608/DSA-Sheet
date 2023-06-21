package LinkedList;

/* Segregate even and odd nodes in a Link List


Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.

NOTE: Don't create a new linked list, instead rearrange the provided one.


Example 1:

Input: 
N = 7
Link List:
17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL

Output: 8 2 4 6 17 15 9

Explaination: 8,2,4,6 are the even numbers 
so they appear first and 17,15,9 are odd 
numbers that appear later.

Example 2:

Input:
N = 4
Link List:
1 -> 3 -> 5 -> 7

Output: 1 3 5 7

Explaination: There is no even number. 
So ne need for modification.

Your Task:
You do not need to read input or print anything. Your task is to complete the function divide() which takes N and head of Link List as input parameters and returns the head of modified link list. Don't create a new linked list, instead rearrange the provided one.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 105
1 ≤ Each element of the list ≤ 105

*/

public class Question139 {
    Node divide(int N, Node head){
        // code here
        Node currNode = head;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        
        while(currNode!=null){
            if(currNode.data%2==0){
                if(evenStart==null){
                    evenStart = currNode;
                    evenEnd = currNode;
                } else{
                    evenEnd.next = currNode;
                    evenEnd = evenEnd.next;
                }
            } else{
                if(oddStart == null){
                    oddStart = currNode;
                    oddEnd = currNode;
                } else{
                    oddEnd.next = currNode;
                    oddEnd = oddEnd.next;
                }
            }
            currNode = currNode.next;
        }
        if(evenStart==null || oddStart==null){
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
        return head;
    }
}

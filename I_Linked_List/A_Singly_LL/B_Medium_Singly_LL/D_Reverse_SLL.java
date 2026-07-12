//Reverse Linked List

package I_Linked_List.A_Singly_LL.B_Medium_Singly_LL;
import java.util.*;
class Node{
    int data;
    Node next;
    Node(){

    }
    Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class D_Reverse_SLL {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        //head = brute(head);
        //head = optimal(head);
        head = reverseLinkedList(head);

        System.out.println("Linked List Elements:");
        temp = head;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    //Brute
    public static Node brute(Node head){
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp != null){
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }
    //Optimal
    public static Node optimal(Node head){
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
            
        }
        return prev;
    }
    //Recursive
    public static Node reverseLinkedList(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
}

//OUTPUT
/*
Linked List Elements:
50->40->30->20->10
*/

//----------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(2N)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(1)

Recursive:
TC:- O(N)
SC:- O(N)
*/
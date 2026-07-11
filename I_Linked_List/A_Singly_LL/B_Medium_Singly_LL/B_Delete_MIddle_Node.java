// Delete Middle Node

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
public class B_Delete_MIddle_Node {
    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        Node head1 = optimal(head);


        System.out.println("Linked List:");
        temp = head1;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    //Optimal
    public static Node optimal(Node head){
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}

//OUTPUT
/*
Linked List:
10->20->40->50

Linked List:
10->20->40
*/

//--------------------------------------------------------------------------------------------------------------------------
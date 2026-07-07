//Delete the Head Node

package I_Linked_List.A_Singly_LL.A_Easy_Singly_LL;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data , Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class F_Delete_Head {
    public static void main(String agrs[]){
        int[] arr = {10,20,30,40,50};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }

        head = DeleteHead(head);
        System.out.println("Linked List:");
        temp = head;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public static Node DeleteHead(Node head){
        return head.next;
    }
}

//OUTPUT
/*
Linked List:
20->30->40->50
*/

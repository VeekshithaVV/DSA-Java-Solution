//Insert a Node at Head

package I_Linked_List.A_Singly_LL.A_Easy_Singly_LL;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class B_Insert_at_Head {
    public static void main(String[] args){
        //Create a Linked list
        int[] arr = {10,20,30,40,50};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the new node data:");
        int ele = input.nextInt();
        input.close();

        Node head1 = InsertAtBegin(head,ele);
        System.out.println("Linked List Elements:");
        while(head1.next != null){
            System.out.print(head1.data+"->");
            head1 = head1.next;
        }
        System.out.print(head1.data);
    }
    //Insert Ar the Head
    public static Node  InsertAtBegin(Node head, int ele){
        Node newNode = new Node(ele);
        newNode.next = head;
        head = newNode;
        return head;
    }
}

//OUTPUT
/*
Enter the new node data:
11
Linked List Elements:
11->10->20->30->40->50
*/
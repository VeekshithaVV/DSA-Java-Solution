//Insert at Middle of Linked List

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
public class C_Insert_At_Middle {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] arr = {10,20,30,40,50};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        System.out.print("Enter the new node data:");
        int x = input.nextInt();
        input.close();

        Node head1 = optimal(head,x);
        System.out.println("Linked List:");
        temp = head1;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public static Node optimal(Node head, int x){
        if(head == null){
            return new Node(x);
        }
        if(head.next == null){
            head.next = new Node(x);
            return head;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newNode = new Node(x);
        newNode.next = slow.next;
        slow.next = newNode;
        return head;
    }
}


//OUTPUT
/*
Enter the new node data:11
Linked List:
10->20->11->30->40

Enter the new node data:11
Linked List:
10->20->30->11->40->50
*/
//Delete the Node located in the Given Position

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
public class H_Delete_at_Pos {
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
        System.out.print("Enter the pos:");
        int pos = input.nextInt();
        input.close();
        Node head1 = DeletePos(head,pos);
        System.out.println("Linked List:");
        temp = head1;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public static Node DeletePos(Node head , int pos){
        Node temp = head;
        int count = 0;
        if(pos == 1){
            head = head.next;
            return head;
        }
        while(temp.next != null){
            count++;
            if(count == pos-1){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}


//OUTPUT
/*
Enter the pos:1
Linked List:
20->30->40->50

Enter the pos:6
Linked List:
10->20->30->40->50
*/
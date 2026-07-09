//Delete a Node having the Given Value
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
public class I_Delete_Given_Val {
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
        System.out.print("Enter the value:");
        int val = input.nextInt();
        input.close();
        Node head1 = DeleteVal(head,val);
        System.out.println("Linked List:");
        temp = head1;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    public static Node DeleteVal(Node head , int val){
        Node temp = head;
        Node prev = null;
        if(head.data == val){
            return head.next;
        }
        while(temp != null){
            if(temp.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
//OUTPUT
/*
Enter the value:10
Linked List:
20->30->40->50

Enter the value:60
Linked List:
10->20->30->40->50
*/

//Insert the Node at the Given Position

package I_Linked_List.A_Singly_LL.A_Easy_Singly_LL;
import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class D_Insert_at_Pos {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the position:");
        int pos = input.nextInt();
        System.out.print("Enter the new node data:");
        int ele = input.nextInt();
        input.close();

        Node head1 = InsertAtPos(head,ele,pos);
        System.out.println("Linked List Elements:");
        while(head1.next != null){
            System.out.print(head1.data+"->");
            head1 = head1.next;
        }
        System.out.print(head1.data);
    }
    public static Node InsertAtPos(Node head, int data, int pos){
        Node newNode = new Node(data);
        if(pos == 1){
            newNode.next = head;
            head = newNode;
            return head;
        }
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            if(count == pos-1){
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    } 
}

//OUTPUT
/*
Enter the position:1
Enter the new node data:11
Linked List Elements:
11->10->20->30->40->50

Enter the position:2
Enter the new node data:11
Linked List Elements:
10->11->20->30->40->50

Enter the position:19
Enter the new node data:231
Linked List Elements:
10->20->30->40->50
*/
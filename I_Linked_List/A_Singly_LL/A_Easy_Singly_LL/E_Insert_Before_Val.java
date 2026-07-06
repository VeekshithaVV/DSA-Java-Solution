//Insert a Node before the Given Value

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
public class E_Insert_Before_Val {
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
        System.out.print("Enter the value:");
        int val = input.nextInt();
        System.out.print("Enter the new node data:");
        int ele = input.nextInt();
        input.close();

        Node head1 = InsertBeforeVal(head,ele,val);
        System.out.println("Linked List Elements:");
        while(head1.next != null){
            System.out.print(head1.data+"->");
            head1 = head1.next;
        }
        System.out.print(head1.data);
    }
    public static Node InsertBeforeVal(Node head, int ele, int val){
        Node newNode = new Node(ele);
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == val){
                if(prev == null){
                    newNode.next = head;
                    head = newNode;
                    return head;
                }
                prev.next = newNode;
                newNode.next = temp;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
    
}

//OUTPUT
/*
Enter the value:50
Enter the new node data:111
Linked List Elements:
10->20->30->40->111->50

Enter the value:10
Enter the new node data:1111
Linked List Elements:
1111->10->20->30->40->50
*/

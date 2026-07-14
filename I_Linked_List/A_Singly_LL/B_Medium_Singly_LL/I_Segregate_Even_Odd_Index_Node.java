//Segregate odd and even nodes in Linked List

package I_Linked_List.A_Singly_LL.B_Medium_Singly_LL;
import java.util.*;

class Node{
    int data;
    Node next;
    Node (){

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
public class I_Segregate_Even_Odd_Index_Node {
    public static void main(String[] args){
        int[] arr = {10,20,30,40};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }

        //brute(head);
        optimal(head);

        Node head1 = head;
        System.out.println("Linked List Elements:");
        while(head1.next != null){
            System.out.print(head1.data+"->");
            head1 = head1.next;
        }
        System.out.print(head1.data);
    }
    //Brute
    public static void brute(Node head){
        ArrayList<Integer> list = new ArrayList<>();
        Node temp = head;
        while(temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp!= null){
            list.add(temp.data);
        }

        temp = head.next;
        while(temp != null && temp.next != null){
            list.add(temp.data);
            temp = temp.next.next;
        }
        if(temp!= null){
            list.add(temp.data);
        }

        temp = head;
        for(int i=0; i<list.size(); i++){
            temp.data = list.get(i);
            temp = temp.next;
        }
    }

    //Optimal
    public static void optimal(Node head){
        if (head == null || head.next == null) {
            return ;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
    }
}

//OUTPUT
/*
Linked List Elements:
10->30->50->20->40
*/
//---------------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(2N)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(1)
*/
//Middle Node of Singly Lined List

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
public class A_Middle_Node_SLL {
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
        input.close();

        // Node midNode = brute(head);
        Node midNode = optimal(head);
        System.out.println("Middle Node data is:"+midNode.data);
    }
    //Brute
    public static Node brute(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        int mid = (count / 2);
        temp = head;
        for(int i=0; i<mid; i++){
            temp = temp.next;
        }
        return temp;
    }

    //Optimal
    public static Node optimal(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null  && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


//OUTPUT
/*
Middle Node data is:40
*/

//----------------------------------------------------------------------------------------------------------------------------

/*
Brute:
TC:- O(N) + O(N/2)
SC:- O(1)

Optimal:
TC:- O(N)
SC:- O(1)
*/
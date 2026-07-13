//Find the Starting Point in LL

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

public class F_Starting_Loop_Node_SLL {
    public static void main(String[] args){
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        Node fifth = new Node(50);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        //Cycle
        //fifth.next = third;

        //int nodeData = brute(head);
        int nodeData = optimal(head);

        System.out.println("Loop Node Data :"+nodeData);
    }
    //Brute
    public static int brute(Node head){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            if(map.containsKey(temp)){
                return temp.data;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return -1;
    }
    //Optimal
    public static int optimal(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast.data;
            }
        }
        return -1;
    }
}
//OUTPUT
/*
Loop Node Data :30
*/
//---------------------------------------------------------------------------------------------------------------------------
/*
Brute: 
TC:- O(N)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(1)
*/

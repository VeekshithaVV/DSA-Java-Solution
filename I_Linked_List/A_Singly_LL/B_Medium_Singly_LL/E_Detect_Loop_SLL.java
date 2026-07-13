//Detect Loop/Cycle in LinkedList

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
public class E_Detect_Loop_SLL {
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
        
        //boolean res = brute(head);
        boolean res = optimal(head);

        if(res){
            System.out.println("Loop detected in the linked list");
        }
        else{
            System.out.println("No Loop detected in the linked list");
        }
    }
    //Brute
    public static boolean brute(Node head){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            if(map.containsKey(temp)){
                return true;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return false;
    }

    //Optimal
    public static boolean optimal(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
//OUTPUT
/*
Loop detected in the linked list
*/

//-------------------------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N)
SC:- O(N)

Optimal:
TC:- O(N)
SC:- O(1)
*/
//Length Of Loop

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

public class G_Length_Of_Loop {
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
        fifth.next = third;
        
        //int res = brute(head);
        int res = optimal(head);

        if(res > 0){
            System.out.println("Length of Loop is :"+res);
        }
        else{
            System.out.println("No Loop detected in the linked list");
        }
    }
    //Brute
    public static int brute(Node head){
        HashMap<Node,Integer> map = new HashMap<>();
        Node temp = head;
        int timer = 1;
        while(temp != null){
            if(map.containsKey(temp)){
                int value = map.get(temp);
                return timer - value;
            }
            map.put(temp,timer);
            timer++;
            temp = temp.next;
        }
        return 0;
    }
    //Optimal
    public static int optimal(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                int count = 1;
                slow = slow.next;
                while(slow != fast){
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
    }
}
//OUTPUT
/*
Length of Loop is :3
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
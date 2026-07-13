//Check the Linked List Palindrome or not

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

public class H_Check_Palindrome {
    public static void main(String[] args){
        int[] arr = {10,20,30,200,10};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length;i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        
        //boolean res = brute(head);
        boolean res = optimal(head);

        if(res){
            System.out.println("The given list is a palindrome.");
        }
        else{
            System.out.println("The given list is not a palindrome.");
        }
    }
    //Brute
    public static boolean brute(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp != null){
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            if(temp.data != st.pop()){
                return false;
            }
            temp = temp.next;
           
        }
        return true;
    }
    //Optimal
    public static Node reverse(Node head){
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static boolean optimal(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverse(slow.next);
        Node first = head;
        Node second = newHead;
        while(second != null){
            if(first.data != second.data){
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

}
//OUTPUT
/*
The given list is a palindrome.
*/
//------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(N)
SC:- O(N)

Optimal:
TC:- O(N/2) + O(N/2) + O(N/2) + O(N/2) ~ O(2N)
SC:- O(1)
*/
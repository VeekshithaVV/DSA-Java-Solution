//Remove Nth Node From End of List

package I_Linked_List.A_Singly_LL.B_Medium_Singly_LL;
import java.util.*;

class Node{
    int data;
    Node next;
    Node(){}
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class J_Remove_NthNode_from_End {
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50};
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the n:");
        int n = input.nextInt();
        input.close();

        //head = brute(head,n);
        head = optimal(head,n);
        temp = head;
        while(temp.next != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
    //Brute
    public static Node brute(Node head, int n){
        Node temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        if(count == n){
            return head.next;
        }
        int res = count - n;
        temp = head;
        while(temp != null){
            res--;
            if(res == 0){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    //Optimal
    public static Node optimal(Node head, int n){
        Node slow = head;
        Node fast = head;
        for(int i=0; i<n; i++){
            //If N exceeds the range
            if(fast == null){
                return head;
            }
            fast = fast.next;
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
//OUTPUT
/*
Enter the n:1
10->20->30->40

Enter the n:5
20->30->40->50
*/
//--------------------------------------------------------------------------------------------------------------------------------
/*
Brute:
TC:- O(len)+O(len-n) ~O(2N)
SC:- O(1)

Optimal:
TC:- O(Len)
SC:- O(1)
*/
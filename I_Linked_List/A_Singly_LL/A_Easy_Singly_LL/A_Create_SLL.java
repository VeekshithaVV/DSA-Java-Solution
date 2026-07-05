//Create a Singly Linkded List

package I_Linked_List.A_Singly_LL.A_Easy_Singly_LL;

import java.util.*;

//Node
class Node{
    int data;
    Node next;

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class A_Create_SLL {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of array:");
        int n = input .nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i=0; i<n; i++){
            arr[i] = input.nextInt();
        }
        input.close();
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<n; i++){
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            temp = newNode;
        } 

        System.out.println("Linked List Data:");
        temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
    }
}


//OUTPUT
/*
Enter the size of array:5        
Enter the array elements:
1 2 3 4 5
Linked List Data:
1 -> 2 -> 3 -> 4 -> 5 -> 
*/
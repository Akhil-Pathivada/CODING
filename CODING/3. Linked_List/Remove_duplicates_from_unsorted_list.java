/* 
Remove Duplicates from UnSorted LinkedList 

Time Complexity : O(n)
Space Complexity : O(n) 
*/ 

import java.util.HashMap;
import java.util.HashSet;

class Node{
    int data;
    Node next;

    Node(int key){
        data = key;
        next = null;
    }
}

class LinkedList{
    private void removeDuplicates(Node head){
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null){
            if (hs.contains(current.data)){
                prev.next = current.next;       
            }
            else {
                hs.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    private void printList( Node curr){
        for( ; curr != null; curr = curr.next){
            System.out.print(curr.data + ", ");
        }
    } 

    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(3);
        head.next.next.next.next.next.next = new Node(1);

        LinkedList obj = new LinkedList();
        System.out.print(" Actual List : ");
        obj.printList(head);
        
        obj.removeDuplicates(head);
        System.out.print(" Linked List after removing duplicates : ");
        obj.printList(head);
    }
}
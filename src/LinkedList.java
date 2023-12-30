import java.util.*;
class LinkedList<T> {
    Node<T>head;
    public void addNode(T data) {
        Node<T> toAdd=new Node<>(data);
        if(head == null)
            head=toAdd;
        else
        {
            Node<T> curr=head;
            while(curr.next!=null) {
                curr=curr.next;
            }
            curr.next=toAdd;
        }

    }
    public void revList() {
        //using the three variable iterative technique to reverse the list
        Node<T> prev=null;
        Node<T> curr=head;
        Node<T> other=null;
        while(curr!=null) {
            other=curr.next;
            curr.next=prev;
            prev=curr;
            curr=other;
        }
        head=prev;

    }
    public void display() {
        Node<T> curr=head;
        while(curr!=null) {
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
        System.out.println();
    }
}
public class LinkedListQueue {
    private Node front, tail;
    int size;
    public LinkedListQueue(){
        front=null;
        tail=null;
        size=0;
    }
    public void push(char item) {
        Node newNode = new Node(item);
        if(tail==null) {
            front=newNode;
        }
        else {
            tail.next=newNode;
        }
        tail=newNode;
        size++;
    }
    public boolean isEmpty(){
        return front==null;
    }
    public char pop(){
        if(isEmpty()) {
            return '\0';
        }
        Node temp=front;
        front=front.next;
        size--;
        return temp.data;
    }
    public int getSize(){
        return size;
    }
}

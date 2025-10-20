public class LinkedListStack {
    private Node front, tail;
    private int size;
    public LinkedListStack(){
        front=null;
        tail=null;
        size=0;
    }
    public void push(char item) {
        Node newNode = new Node(item);
        newNode.next = front;
        front=newNode;
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

import java.util.Scanner;

public class ArrayQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void push(int item) {
        if (rear == capacity) {
            return;
        }
        queue[rear++] = item;
        size++;
    }

    public int pop() {
        int item=queue[front];
        front=(front+1)%capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int getSize(){
        return size;
    }
}

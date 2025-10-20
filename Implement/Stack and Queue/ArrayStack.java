public class ArrayStack {
    private int[] stack;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        size=0;
    }

    public void push(int value) {
        if (size == capacity) {
            return;
        }
        stack[size++] = value;
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        return stack[--size];
    }

    public boolean isEmpty() {
        return size==0;
    }
    public int getSize(){
        return size;
    }
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.getSize());
        stack.pop();
        System.out.println(stack.getSize());
    }
}

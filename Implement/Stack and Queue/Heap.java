import java.util.ArrayList;

public class Heap {
    public void heap(ArrayList<Integer> heapTree, int i) {
        int size = heapTree.size();
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < size && heapTree.get(leftChild) > heapTree.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < size && heapTree.get(rightChild) > heapTree.get(largest)) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = heapTree.get(largest);
            heapTree.set(largest, heapTree.get(i));
            heapTree.set(i, temp);
            heap(heapTree, largest);
        }
    }

    public void insertNode(ArrayList<Integer> heapTree, int num) {
        int size = heapTree.size();
        if (size == 0) {
            heapTree.add(num);
        } else {
            heapTree.add(num);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heap(heapTree, i);
            }
        }
    }

    public void deleteNode(ArrayList<Integer> heapTree, int num) {
        int size = heapTree.size();
        int i;
        for (i = 0; i < size; i++) {
            if (num == heapTree.get(i))
                break;
        }

        int temp = heapTree.get(i);
        heapTree.set(i, heapTree.get(size - 1));
        heapTree.set(size - 1, temp);

        heapTree.remove(size - 1);
        for (int j = size / 2 - 1; j >= 0; j--) {
            heap(heapTree, j);
        }
    }

    public void printArray(ArrayList<Integer> heapTree) {
        for(Integer i : heapTree) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        int size = array.size();

        Heap h = new Heap();
        h.insertNode(array, 3);
        h.insertNode(array, 4);
        h.insertNode(array, 9);
        h.insertNode(array, 5);
        h.insertNode(array, 2);

        System.out.println("Max-Heap array: ");
        h.printArray(array);

        h.deleteNode(array, 3);
        System.out.println("After deleting an element: ");
        h.printArray(array);
    }
}

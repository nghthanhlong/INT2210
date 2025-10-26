import java.util.Arrays;

public class HashTable {
    private static class Entry {
        int key;
        int value;
        Entry (int value) {
            this.value=value;
        }
        @Override
        public String toString() {
            return String.format("{%d,%d}", key, value);
        }
    }
    private Entry[] table;
    private int size;

    public HashTable(int size){
        this.size=size;
        this.table=new Entry[size];
    }
    private int hash(int key) {
        return Math.abs(key)%size;
    }
    public void putLinear(int value) {
        int index=hash(value);
        while(table[index]!=null) {
            index=(index+1)%size;
        }
        table[index]=new Entry(value);
    }
    public int getLinear(int key) {
        int index=hash(key);
        while(table[index]!=null) {
            if(table[index].key==key) {
                return table[index].value;
            }
            index=(index+1)%size;
        }
        return -1;
    }
    public void putSquare(int value) {
        int startIndex=hash(value);
        int currentIndex=startIndex;
        int i=0;
        while(table[currentIndex]!=null) {
            i++;
            currentIndex=(startIndex+i*i)%size;
            if(i>size) {
                System.out.println("Error");
                return;
            }
        }
        table[currentIndex]=new Entry(value);
    }
    public int getSquare(int key) {
        int startIndex=hash(key);
        int currentIndex=startIndex;
        int i=0;

        while(table[currentIndex]!=null) {
            if(table[currentIndex].key==key) {
                return table[currentIndex].value;
            }
            i++;
            currentIndex=(startIndex+i*i)%size;
            if(i>size){
                break;
            }
        }
        return -1;
    }
    public void printHashTable() {
        for(int i=0; i<size; i++) {
            if(table[i]!=null) {
                System.out.printf("{%d,%d}, ", i, table[i].value);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Linear Probing Test ---");
        int[] values = {17, 25, 43, 51, 62, 7, 32};
        HashTable linearTable = new HashTable(7);

        for (int value : values) {
            linearTable.putLinear(value);
        }

        linearTable.printHashTable();
    }

}

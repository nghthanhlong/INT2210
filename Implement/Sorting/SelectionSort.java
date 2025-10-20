import java.util.Scanner;

public class SelectionSort {
    static void selectionSort(int[] arr) {
        int n=arr.length;
        for(int i=0; i<n-1; i++){
            int min_index=i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=temp;
        }

    }
    public static void main(String[] args) {
        int[] a={12, 2, 3,4 ,1, 6, 44};
        selectionSort(a);
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}

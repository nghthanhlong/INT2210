public class QuickSort {
    public static void sort(int[] a) {
        if(a==null || a.length==0) return;
        quickSort(a, 0, a.length-1);
    }

    public static void quickSort(int[] a, int left, int right) {
        if(left>=right) return;
        int pivotIndex=partition(a, left, right);
        quickSort(a, left, pivotIndex-1);
        quickSort(a, pivotIndex+1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot=a[right];
        int i=left;
        for(int j=left; j<right; j++){
            if(a[j]<=pivot){
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, right);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

public class InsertionSort {
    public static void insertionSort(int[] a){
        int n=a.length;
        for(int i=1;i<n;i++){
            int key=a[i];
            int j=i-1;
            while(j>=0 && a[j]>key) {
                a[j+1]=a[j];
                j=j-1;
            }
            a[j+1]=key;
        }
    }
    public static void main(String[] args) {
        int[] a={12, 2, 3,4 ,1, 6, 44};
        insertionSort(a);
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
    }
}

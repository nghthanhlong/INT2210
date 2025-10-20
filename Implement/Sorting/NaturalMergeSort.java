public class NaturalMergeSort {
    public static void merge(int[] a, int left, int mid, int right) {
        int[] temp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right) {
            if(a[i]<=a[j]) {
                temp[k++]=a[i++];
            } else {
                temp[k++]=a[j++];
            }
        }
        while(i<=mid) {
            temp[k++]=a[i++];
        }
        while(j<=right) {
            temp[k++]=a[j++];
        }
        for(int t=0; t<temp.length; t++) {
            a[left+t]=temp[t];
        }
    }

    public static void naturalMergeSort(int[] a){
        int n=a.length;
        for(int size=1; size<n; size++){
            for(int left=0; left<n; left+=2*size) {
                int mid=Math.min(left+size-1, n-1);
                int right=Math.min(left+2*size-1, n-1);
                if(mid<right) {
                    merge(a, left, mid, right);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a={3,5,1,2,4,6,8,7};
        naturalMergeSort(a);
        for(int num:a){
            System.out.print(num+" ");
        }
    }
}

public class BubbleSort {
    public static void bubbleSort(int array[], int n) {
        int temp;
        boolean swapped=false;
        for(int i=0; i<n-1; i++){
            swapped=false;
            for(int j=0; j<n-i-1; j++){
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }
}

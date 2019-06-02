// Visit https://stackabuse.com/sorting-algorithms-in-java/


import java.util.Arrays;

class Sorting{

    public static void bubbleSort(int[] a) {  
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    public static void insertionSort(int[] array) {  
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while(j >= 0 && current < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            // at this point we've exited, so j is either -1
            // or it's at the first element where current >= a[j]
            array[j+1] = current;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {  
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minId = j;
                }
            }
            // swapping
            int temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        System.out.println(Arrays.toString(array));
    }


    public static void main(String args[]){
        int[] arr = {1,4,6,3,8,-2,43};
        System.out.println(Arrays.toString(arr));
        Sorting.bubbleSort(arr);
        Sorting.insertionSort(arr);
        Sorting.selectionSort(arr);
    }
}
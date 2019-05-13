package sort;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {8,4,3,11,13,22,5,2,7,9};
        // bubbleSort(arr);
        // choiceSort(arr);
        // insertSort(arr);
        // quickSort(arr, 0, arr.length - 1);
        //mergeSort(arr, 0, arr.length -1);
        //heapSort(arr,);
    }
    //冒泡排序
   public static void bubbleSort(int[] arr) {
        int temp = 0;
        int isChange = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isChange = 1;
                }
            }
            if (isChange == 0) {
                break;
            }
       }
       for (int a : arr) {
           System.out.print(a + ", ");
       }
       System.out.println();
   }
    //选择排序
    public static void choiceSort(int[]  arr) {
        int pos;
        for (int i = 0; i < arr.length - 1; i++) {
            pos = 0;
            for (int j = 1; j < arr.length  - i; j++) {
                if (arr[j] > arr[pos]) {
                    pos = j;
                }
            }
            int temp = arr[pos];
            arr[pos] = arr[arr.length - 1 -i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    //插入排序
    public static void insertSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            while (i >= 1 && arr[i-1] > temp) {
                arr[i] = arr[i-1];
                i--;
            }
            arr[i] = temp;
        }
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    //快速排序
    public static void quickSort(int[] arr, int L,  int R) {
        int left = L;
        int right = R;
        int M = arr[(L+R)/2];
        while (left <right) {
            while (arr[left] < M) {
                left++;
            }
            while (arr[right] > M) {
                right--;
            }
            if (left <= right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }
        if (left < R) {
            quickSort(arr, left, R);
        }
        if (right > L) {
            quickSort(arr, L, right);
        }
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    //归并排序
    public static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = (L + R)/2;
        mergeSort(arr, L, M);
        mergeSort(arr, M + 1, R);
        merge(arr, L, M+1, R);
    }
    //合并数组
    public static void merge(int[] arr, int L, int M, int R) {
        int[] leftArr = new int[M -L];
        int[] rigthArr = new int[R - M + 1];
        for (int i = L; i< M; i++) {
            leftArr[i - L] = arr[i];
        }
        for (int i = M; i <= R; i++) {
            rigthArr[i - M] = arr[i];
        }
        int i = 0;
        int j = 0;
        int k = L;
        while (i < leftArr.length && j < rigthArr.length) {
            if (leftArr[i] < rigthArr [j]) {
                arr[k] = leftArr[i];
                i++;
                k++;
            }else {
                arr[k] = rigthArr[j];
                j++;
                k++;
            }
        }
        while (i < leftArr.length) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rigthArr.length) {
            arr[k] = rigthArr[j];
            j++;
            k++;
        }
        for (int a : arr) {
            System.out.print(a + ", ");
        }
        System.out.println();
    }
    //堆排
    public static void heapSort(int[] arr, int currentRoot, int size) {
        if (currentRoot < size) {
            int left = 2 * currentRoot + 1;
            int right = 2 * currentRoot + 2;
            int max = currentRoot;
            if (left < size) {
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }
            if (right < size) {
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }
            if (max != currentRoot) {
                int temp = arr[max];
                arr[max] = arr[currentRoot];
                arr[currentRoot] = temp;
                heapSort(arr, max, arr.length);
            }
        }
    }
    public static void maxHeap(int[] arr, int size) {
        for (int i = size -1; i >= 0; i--) {
            heapSort(arr, i, size);
        }
    }


}

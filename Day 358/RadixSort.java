import java.util.Arrays;

class RadixSort {

    private  int getMax(int[] arr, int n) {
        int maxNumArr = arr[0];
        for (int i : arr){  maxNumArr = i > maxNumArr ? i:maxNumArr;  }
        return maxNumArr;
    }

    private  void contSort(int[] arr, int n, int e) {
        int[] output = new int[n];
        int[] cont = new int[10];
        Arrays.fill(cont, 0);

        for (int i = 0; i < n; i++)
            cont[(arr[i] / e) % 10]++;

        for (int i = 1; i < 10; i++)
            cont[i] += cont[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[cont[(arr[i] / e) % 10] - 1] = arr[i];
            cont[(arr[i] / e) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    private  void radixsort(int[] arr, int n) {
        int max = getMax(arr, n);
        for (int exp = 1; max / exp > 0; exp *= 10)
            contSort(arr, n, exp);
    }
}
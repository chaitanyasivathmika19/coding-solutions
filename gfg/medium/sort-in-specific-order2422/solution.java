class Solution {
    public void sortIt(int[] arr) {
        // code here
        Arrays.sort(arr);

        int n = arr.length;
        int[] result = new int[n];
        int index = 0;

        // Odd numbers in descending order
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }

        // Even numbers in ascending order
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }

        // Copy result back into the original array
        for (int i = 0; i < n; i++) {
            arr[i] = result[i];
        }
    }
}

class Solution {
    public int findKthSmall(int[] arr, int k) {
        // code here
        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] + k;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int index = Arrays.binarySearch(arr, mid);
            int countLessOrEqual;

            if (index >= 0) {
                countLessOrEqual = index + 1;

                // Handle duplicates in sorted array (though input is distinct)
                while (countLessOrEqual < arr.length
                        && arr[countLessOrEqual] == mid) {
                    countLessOrEqual++;
                }
            } else {
                countLessOrEqual = -index - 1;
            }

            int missing = mid - countLessOrEqual;

            if (missing >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
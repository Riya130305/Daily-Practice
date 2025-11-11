import java.util.*;

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;

        for (int size = n; size > 1; size--) {
            int maxIndex = findIndex(arr, size);

            if (maxIndex == size - 1) continue;

            if (maxIndex != 0) {
                res.add(maxIndex + 1);
                reverse(arr, 0, maxIndex);
            }

            res.add(size);
            reverse(arr, 0, size - 1);
        }

        return res;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) return i;
        }
        return -1;
    }
}

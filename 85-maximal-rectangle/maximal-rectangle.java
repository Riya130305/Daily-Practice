import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] arr = new int[cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {

            // Build histogram
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1')
                    arr[j]++;
                else
                    arr[j] = 0;
            }

            max = Math.max(max, largestRectangle(arr));
        }

        return max;
    }

    public int largestRectangle(int[] arr) {

        int n = arr.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        Arrays.fill(nse, n);
        Arrays.fill(pse, -1);

        ArrayDeque<Integer> st = new ArrayDeque<>();

        // Next Smaller Element
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                nse[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Previous Smaller Element
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = arr[i] * width;
            max = Math.max(max, area);
        }

        return max;
    }
}
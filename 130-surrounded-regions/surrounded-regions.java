import java.util.*;

class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] row = {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};

        Queue<int[]> q = new LinkedList<>();

        // 1️⃣ Step 1: Boundary 'O' ko queue me daalo aur 't' mark karo
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1)
                        && board[i][j] == 'O') {
                    board[i][j] = 't';
                    q.add(new int[]{i, j});
                }
            }
        }

        // 2️⃣ Step 2: BFS – boundary se connected 'O' ko bhi 't' mark karo
        while (!q.isEmpty()) {
            int[] val = q.poll();
            int u = val[0];
            int v = val[1];

            for (int i = 0; i < 4; i++) {
                int nrow = u + row[i];
                int ncol = v + col[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && board[nrow][ncol] == 'O') {
                    board[nrow][ncol] = 't';
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        // 3️⃣ Step 3: Final conversion
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';   // surrounded
                } else if (board[i][j] == 't') {
                    board[i][j] = 'O';   // safe
                }
            }
        }
    }
}

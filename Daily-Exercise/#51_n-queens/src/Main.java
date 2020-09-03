import java.util.*;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 提示：
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上*/

// 基于集合的回溯
//class Solution {
//    public List<List<String>> solveNQueens(int n) {
//        List<List<String>> solutions = new ArrayList<>();
//        int[] queens = new int[n];
//        Set<Integer> cols = new HashSet<>();
//        Set<Integer> diag1 = new HashSet<>();
//        Set<Integer> diag2 = new HashSet<>();
//
//        Arrays.fill(queens, -1);
//        backtrack(solutions, queens, n, 0, cols, diag1, diag2);
//
//        return solutions;
//    }
//
//    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> cols, Set<Integer> diag1, Set<Integer> diag2) {
//        if (row == n) {
//            solutions.add(generateBoard(queens, n));
//        } else {
//            for (int i=0; i<n; i++) {
//                int d1 = i+row;
//                int d2 = i-row;
//
//                if (cols.contains(i) || diag1.contains(d1) || diag2.contains(d2)) {
//                    continue;
//                } else {
//                    cols.add(i);
//                    diag1.add(d1);
//                    diag2.add(d2);
//                    queens[row] = i;
//
//                    backtrack(solutions, queens, n, row+1, cols, diag1, diag2);
//
//                    cols.remove(i);
//                    diag1.remove(d1);
//                    diag2.remove(d2);
//                    queens[row] = -1;
//                }
//            }
//        }
//    }
//
//    public List<String> generateBoard(int[] queens, int n) {
//        List<String> board = new ArrayList<>();
//        for (int i=0; i<n; i++) {
//            char[] row = new char[n];
//            Arrays.fill(row, '.');
//            row[queens[i]] = 'Q';
//            board.add(new String(row));
//        }
//        return board;
//    }
//}
    
// 位运算方法（花里胡哨）
class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions = new ArrayList<>();
        solve(solutions, queens, n, 0, 0, 0, 0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> sol = solution.solveNQueens(4);

        for (List<String> list : sol) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("------------------");
        }
    }
}
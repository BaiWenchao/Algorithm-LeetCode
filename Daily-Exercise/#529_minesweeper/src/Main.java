/**
 * #529: 扫雷游戏
 * 让我们一起来玩扫雷游戏！
 * 给定一个代表游戏板的二维字符矩阵。 
 * 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，
 * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
 * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），
 * 根据以下规则，返回相应位置被点击后对应的面板：
 *      1. 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 *      2. 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 *      3. 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 *      4. 如果在此次点击中，若无更多方块可被揭露，则返回面板。*/

class Solution {

    private int[] dirX = {0, 0, -1, 1, -1, -1, 1, 1};
    private int[] dirY = {-1, 1, 0, 0, -1, 1, -1, 1};
    private int rBdy;
    private int cBry;

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null) return null;
        int x = click[0], y = click[1];
        rBdy = board.length;
        cBry = board[0].length;
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int count = 0;
        for (int i=0; i<dirX.length; i++) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx<0||ty<0||tx>rBdy-1||ty>cBry-1) {
                continue;
            }
            if (board[tx][ty] == 'M') {
                count++;
            }
        }

        if (count == 0) {
            board[x][y] = 'B';
            for (int i=0; i<dirX.length; i++) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];

                if (tx>=0 && ty>=0 && tx<rBdy && ty<cBry && board[tx][ty]=='E') {
                    dfs(board, tx, ty);
                }
            }
        } else {
            board[x][y] = (char)(count+'0');
        }
    }
}

public class Main {
    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                          {'E', 'E', 'M', 'E', 'E'},
                          {'E', 'E', 'E', 'E', 'E'},
                          {'E', 'E', 'E', 'E', 'E'}};

        Solution solution = new Solution();

        char[][] ans = solution.updateBoard(board, new int[] {3, 0});

        for (char[] ch : ans) {
            for (char c : ch) {
                System.out.print(c+"\t");
            }
            System.out.println();
        }
    }
}

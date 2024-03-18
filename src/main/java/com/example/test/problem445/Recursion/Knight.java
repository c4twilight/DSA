package com.example.test.problem445.Recursion;
import java.util.*;
public class Knight {
}
/*Problem Statement:-
Imagine you have a chessboard of dimensions N x M. A knight is positioned at the top-left corner of the board (0, 0). Can you devise a strategy for the knight to traverse the entire chessboard, visiting each square precisely once, while adhering to the movement rules of a knight?
A knight in chess moves in an L-shape pattern: it can move two squares vertically and one square horizontally, or two squares horizontally and one square vertically. This means that if the knight is at (x, y), it can move to any of the following squares: (x±1, y±2) or (x±2, y±1), as long as they are within the bounds of the chessboard.
type 1 : need to print all possible solution
type 2: need to print any possible solution */


class Main {

    public static void main(String[] args) {
        KnightTour knightTour = new KnightTour();
        boolean printAll = false;
        knightTour.mainKnight(5,5,0,0, printAll);
    }


}
class KnightTour{
    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public void mainKnight(int n, int m, int staringRow, int startingCol, boolean printAll) {

        //stating point
        int row = staringRow;
        int col = startingCol;

        int chess[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chess[i][j] = -1;
            }
        }
        if(printAll){
            List<int[][]> ans = new ArrayList<>();
            printKnightsTour(chess, row, col, 0,n, m, ans);

            for(int[][] chess1 : ans){
                displayBoard(chess1,n,m);
            }
        }
        else{
            isKnightsTourPossible(chess, row, col, 0,n, m);
            displayBoard(chess,n,m);
        }

    }
    public KnightTour(){

    }
    public boolean isKnightsTourPossible(int[][] chess, int row, int col, int move, int n, int m) {

        if (isInvalid(chess, row, col, n, m)) {
            return false;
        }
        if (move == ((n * m) - 1)) {
            chess[row][col] = move;
            return true;
        }

        chess[row][col] = move;
        for (int k = 0; k < 8; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];
            if(isKnightsTourPossible(chess, newRow, newCol, move + 1, n, m)){
                return true;
            }
        }
        chess[row][col] = -1;
        return false;
    }
    public void printKnightsTour(int[][] chess, int row, int col, int move, int n, int m, List<int[][]> ans) {

        if (isInvalid(chess, row, col, n, m)) {
            return;
        }
        if (move == (n * m -1)){
            chess[row][col] = move;
            ans.add(deepCopy(chess));
            chess[row][col] = -1;
            return;
        }

        chess[row][col] = move;
        for (int k = 0; k < 8; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];
            printKnightsTour(chess, newRow, newCol, move + 1, n, m,ans);
        }
        chess[row][col] = -1;
    }

    public void displayBoard(int[][] chess, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
    private boolean isInvalid(int[][] chess, int row, int col, int n, int m) {
        return row < 0 || col < 0 || row >= n|| col >= m || chess[row][col] > -1;
    }
    public int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        int[][] copy = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
}
//time : O(8^total) , total = n*m;
//same approch different way:-


class Solution {
    private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    public static int[][] knightTour(int n, int m) {
        //You can code here
        int[][] board = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = -1;
            }
        }
        // Start the tour from the top-left corner of the board
        board[0][0] = 0;
        if (!solve(board, 0, 0, 1, n, m)) {
            board[0][0] = -1;
            System.out.println("Solution does not exist");

        }
        return board;
    }
    private static boolean solve(int[][] board, int row, int col, int move, int n, int m) {

        if (move ==  n * m) {
            return true;
        }

        for (int k = 0; k < 8; k++) {
            int newRow = row + dx[k];
            int newCol = col + dy[k];
            if (isValid(board, newRow, newCol, n, m)) {
                board[newRow][newCol] = move;
                if (solve(board, newRow, newCol, move + 1, n, m)) {
                    return true;
                }
                board[newRow][newCol] = -1; // backtrack
            }
        }

        return false;
    }

    private static boolean isValid(int[][] board, int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m && board[row][col] == -1;
    }
}
//find the shortest path to a destination from source if possible

class Cell {
    int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution2 {
    private boolean isInside(int x, int y, int N) {
        if (x >= 1 && x <= N && y >= 1 && y <= N)
            return true;
        return false;
    }

    public int minStepToReachTarget(int knightPos[], int targetPos[], int N) {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        Queue<Cell> q = new LinkedList<>();
        q.add(new Cell(knightPos[0], knightPos[1]));

        boolean visit[][] = new boolean[N + 1][N + 1];

        visit[knightPos[0]][knightPos[1]] = true;
        int ans = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Cell t = q.poll();

                if (t.x == targetPos[0] && t.y == targetPos[1])
                    return ans;

                for (int j = 0; j < 8; j++) {
                    int x = t.x + dx[j];
                    int y = t.y + dy[j];

                    if (isInside(x, y, N) && !visit[x][y]) {
                        visit[x][y] = true;
                        q.add(new Cell(x, y));
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}

/*stackOverflow memory limit
class Solution {
  private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
  private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
  int minStep;
  int targetPos[];

  public int minStepToReachTarget(int knightPos[], int targetPos[], int boardSize) {
    minStep = Integer.MAX_VALUE;
    boolean[][] visited = new boolean[boardSize][boardSize];
    this.targetPos = targetPos;
    int row = knightPos[0] - 1;
    int col = knightPos[1] - 1;
    updateMinStepsToTarget(visited, row, col, 0, boardSize);
    if (minStep == Integer.MAX_VALUE) {
      return -1;
    }
    return minStep;
  }

  public void updateMinStepsToTarget(boolean[][] visited, int row, int col, int move, int boardSize) {
    if (row < 0 || col < 0 || row >= boardSize || col >= boardSize || visited[row][col] || move >= minStep) {
      return ;
    }

    if (row == targetPos[0] - 1 && col == targetPos[1] - 1) {
      minStep = move;
      return ;
    }

    visited[row][col] = true;
    for (int k = 0; k < 8; k++) {
      int newRow = row + dx[k];
      int newCol = col + dy[k];

      updateMinStepsToTarget(visited, newRow, newCol, move + 1, boardSize);

    }
    visited[row][col] = false;
    return;
  }
}
*/
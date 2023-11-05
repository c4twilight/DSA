package com.example.test.problem.arrays;

import java.util.*;

public class ArraysLiv1 {
    //MAXIMUM ABSOLUTE DIFFERENCE

    public class Solution {
        public int maxArr(ArrayList<Integer> A) {
            int max1=Integer.MIN_VALUE;
            int min1=Integer.MAX_VALUE;

            int max2=Integer.MIN_VALUE;
            int min2=Integer.MAX_VALUE;

            int n=A.size();

            for(int i=0; i<n; i++){
                max1 = Math.max(max1, A.get(i)+i);
                min1 = Math.min(min1, A.get(i)+i);
                max2 = Math.max(max2, A.get(i)-i);
                min2 = Math.min(min2, A.get(i)-i);
            }

            int a=max1-min1;
            int b=max2-min2;

            return Math.max(a, b);
        }
    }

//UNIQUE PATHS-3


    class Solution1 {
        public int uniquePathsIII(int[][] grid) {
            int cntZero = 0;
            int sx = 0;
            int sy = 0;

            for(int r = 0; r < grid.length; r++){
                for(int c = 0; c < grid[0].length; c++){
                    if(grid[r][c] == 0) cntZero++;
                    else if(grid[r][c] == 1){
                        sx = r;
                        sy = c;
                    }
                }
            }

            return dfs(grid, sx, sy, cntZero);
        }

        public int dfs(int grid[][], int x, int y, int cntZero){
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
                return 0;
            }
            if(grid[x][y] == 2){
                if(cntZero == 0) return 1;
                else return 0;
                //return cntZero == 0 ? 1 : 0;
            }
            if(grid[x][y] == 0) cntZero--;
            grid[x][y] = -1;

            int totalPaths = dfs(grid, x + 1, y, cntZero) +
                    dfs(grid, x - 1, y, cntZero) +
                    dfs(grid, x, y + 1, cntZero) +
                    dfs(grid, x, y - 1, cntZero);

            grid[x][y] = 0;
            cntZero++;

            return totalPaths;
        }
    }

}

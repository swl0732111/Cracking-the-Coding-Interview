/*
请编写一个算法，若N阶方阵中某个元素为0，则将其所在的行与列清零。
*/

import java.util.*;

public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        /*空间复杂度能最小化（O(n)）*/
        boolean[] row = new boolean[mat.length];
        boolean[] colum = new boolean[mat[0].length];
        
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    row[i] = true;
                    colum[j] = true;
                }
            }
        }
        
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(row[i] == true || colum[j] == true){
                    mat[i][j] = 0;
                }
            }
        }
        
        return mat;
    }
}
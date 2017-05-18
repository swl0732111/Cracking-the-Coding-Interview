/*
有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，
请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
*/

import java.util.*;

public class Transform {
    public int[][] transformImage(int[][] mat, int n) {
        
        for(int layer=0; layer<n/2; layer++) {
            int first = layer;
            int last = n-layer-1;
            
            for(int i=first; i<last; i++) {
                int offset = i-first;
                int temp = mat[first][i];
                mat[first][i] = mat[last-offset][first];
                mat[last-offset][first] = mat[last][last-offset];
                mat[last][last-offset] = mat[first+offset][last];
                mat[first+offset][last] = temp;
            }
        }
        
        return mat;
    }
}
import java.util.*;

public class Transform {
    /* 投机的做法 */
    public int calcCost(int A, int B) {
        return Integer.bitCount(A^B);
    }
    
    /* 最好的做法 */
    public int calcCost(int A, int B) {
        int n = A ^ B;
        int count = 0;
        while(n != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }
}
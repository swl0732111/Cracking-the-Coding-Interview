import java.util.*;

/**
 *给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *这里规定大小写为不同字符，且考虑字符串重点空格。
 */

public class Same {
    public boolean checkSame(String stringA, String stringB) {
        
        int lenA = stringA.length();
        int lenB = stringB.length();
        if(lenA != lenB) return false;
        int[] strA = new int[256];
        int[] strB = new int[256];
        for(int i=0; i<lenA; i++) {
            strA[stringA.charAt(i)]++;
            strB[stringB.charAt(i)]++;
        }
        for(int i=0; i<256; i++) {
            if(strA[i] != strB[i]) {
                return false;
            }
        }
        return true;
    }
}
import java.util.*;
/*题目描述:
请实现一个算法，确定一个字符串的所有字符是否全都不同。
给定一个string iniString，请返回一个bool值,
True代表所有字符全都不同，False代表存在相同的字符。
保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
*/
public class Different {
    public boolean checkDifferent(String iniString) {
        int len = iniString.length();
        if(len > 256) {
            return false;
        }
        boolean[] hash =new boolean[256];
        char[] arr = iniString.toCharArray();
        for(char c : arr){       
            if(hash[c]) {
                return false;
            }else {
                hash[c]=true;
            }
        }
        return true;
    }
}
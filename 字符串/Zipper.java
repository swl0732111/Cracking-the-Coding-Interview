import java.util.*;
/*
利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
若压缩后的字符串没有变短，则返回原先的字符串。
*/
public class Zipper {
    public String zipString(String iniString) {
    	StringBuffer sb = new StringBuffer();
        char[] c = iniString.toCharArray();
        char pre = c[0];
        int count = 1;
        for(int i=1; i<iniString.length(); i++) {
            if(pre == c[i]) {
                count++;
            } else {
                sb.append(pre + "" + count);
                pre = c[i];
                count = 1;
            }
        }
        sb.append(pre + "" + count);
        if(sb.toString().length() < iniString.length()) {
            return sb.toString();
        } else {
            return iniString;
        }
    }
}
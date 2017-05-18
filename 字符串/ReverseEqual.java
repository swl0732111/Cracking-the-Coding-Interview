/* 
题目描述
假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。
请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
*/

import java.util.*;

public class ReverseEqual {
    public boolean checkReverseEqual(String s1, String s2) {
        return (s1+s1).contains(s2);
    }
}
/*
题目描述
有一个介于0和1之间的实数，类型为double，返回它的二进制表示。如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。
*/

import java.util.*;

public class BinDecimal {
    public String printBin(double num) {
        if(num >= 1 || num <= 0) return "Error";
        StringBuilder res = new StringBuilder();
        res.append("0.");
        while(num > 0) {
            if(res.length() >= 32) return "Error";
			/* 先乘以2，再不断与1比较：*/
            double r = num * 2;
            if(r >= 1) {
                res.append("1");
                num = r - 1;
            } else {
                res.append("0");
                num = r;
            }
        }
        return res.toString();
    }
}
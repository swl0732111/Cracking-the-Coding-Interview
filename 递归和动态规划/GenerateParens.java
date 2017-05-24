/**
题目描述：
实现一个算法，实现打印n对括号全部合法组合
*/
import java.util.*;

public class GenerateParens {
	
	public static ArrayList<String> generateParens(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<>();
		addParen(list, count, count, str, 0);
		return list;
	}
	
	private static void addParen(ArrayList<String> list, int left, int right, char[] str, int i) {
		/**
		 * left和right分别代表剩余的可以用的左右括号。初始值为count。
		 */
		
		if(left<0 || right<left) return;//无效
		
		if(left==0 || right==0) {
			/* 边界：没有括号可以用了*/
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			/* 如果还有左括号可以用，添加一个左括号 */
			if(left > 0) {
				str[i] = '(';
				addParen(list, left-1, right, str, i+1);
			}
			/* 如果字符串有效，则加入右括号 */
			if(right > left) {
				str[i] = ')';
				addParen(list, left, right-1, str, i+1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generateParens(8));

	}

}

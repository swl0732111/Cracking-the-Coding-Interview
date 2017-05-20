import java.util.*;
/*
题目描述
请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。
请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
*/
public class TwoStacksSort {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        
        if(numbers == null || numbers.length == 0) return null;
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
		//把元素全部放入栈1
        for(int i=0; i<numbers.length; i++) {
            stack1.push(numbers[i]);
        }
        
		//将栈1的元素放入栈2，并使之有序
        while(!stack1.isEmpty()) {
            int temp = stack1.pop();//temp作为另一个缓存，存放栈顶元素
            while(!stack2.isEmpty() && stack2.peek()>temp) {
				//stack2栈顶大于temp的数放回stack1
                stack1.push(stack2.pop());
            }
            stack2.push(temp);
        }
        while(!stack2.isEmpty()) {
            res.add(stack2.pop());
        }
        return res;
        
        
        
    }
}
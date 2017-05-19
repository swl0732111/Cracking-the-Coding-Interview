import java.util.*;

/*
题目描述
请编写一个函数，检查链表是否为回文。
*/
public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        ListNode walk = pHead;
        ListNode run = pHead;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        while(run != null && run.next != null) {
            stack.push(walk.val);
            walk = walk.next;
            run = run.next.next;
        }
        
        if(run != null) {
            walk = walk.next;//跳过中间元素
        }
        
        while(walk != null) {
            if(walk.val != stack.pop()) {
                return false;
            }
            walk = walk.next;
        }
        
        return true;
    }
}
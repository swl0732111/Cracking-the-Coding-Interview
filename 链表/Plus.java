import java.util.*;
/*
题目描述:
有两个用链表表示的整数，每个结点包含一个数位。
这些数位是反向存放的，也就是个位排在链表的首部。
编写函数对这两个整数求和，并用链表形式返回结果。
*/
public class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        
        int add = 0;
        
        while(a!=null || b!=null || add!=0) {
            int aVal = a!=null ? a.val : 0;
            int bVal = b!=null ? b.val : 0;
            int sum = aVal + bVal + add;
            int digit = sum%10;
            add = sum/10;
            
            curr.next = new ListNode(digit);
            curr = curr.next;
            
            a = (a!=null ? a.next : null);
            b = (b!=null ? b.next : null);
        }
        
        return res.next;
        
    }
}












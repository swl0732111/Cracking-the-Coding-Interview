/*
输入一个链表，输出该链表中倒数第k个结点.
*/
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
        
        ListNode h1 = head;
        ListNode h2 = head;
        
        while(k>1){
			//h1先跑k-1步，即h1是正数第k个节点
            if(h1 !=null){
 				h1 = h1.next;
                k--;
            }else{
                return null;
            }
            
        }
        
        while(h1.next != null){
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return h2;
    }
}
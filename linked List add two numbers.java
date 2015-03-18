//Add two numbers
//what I learned here
//1. for each linked list, there should be ListNode data structure
//what i should maintain is a head and a pointer,they are both ListNode
//the pointer starts from the head and go down to null; the tail is null
//2. for the while( p1 &&  p2) then I can do while(p1)... while(p2)...
//but also(p1||p2){  if(p1!=null)....  if(p2!=null)....}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        int remain=0;
        ListNode newHead=new ListNode(0);
       // ListNode p1=l1,p2=l2;
        ListNode p3=newHead;
        
        while(l1!=null&&l2!=null){
             remain=(l1.val+l2.val+carry)%10;
             carry =(l1.val+l2.val+carry)/10;
            l1=l1.next;
            l2=l2.next;
            p3.next = new ListNode(remain);
            p3=p3.next; 
        }
        
            
       while(l1!=null){
           p3.next = new ListNode((l1.val+carry)%10);
           carry = (l1.val+carry)/10;
           p3 = p3.next;
           l1=l1.next;
           
       }
       while(l2!=null){
           p3.next = new ListNode((l2.val+carry)%10);
           carry = (l2.val+carry)/10;
           p3=p3.next;
           l2=l2.next;
       }
       /*
        if(l1==null){
            if(l2==null){
                if(carry!=0)l3.next = new ListNode(carry);
                return l3;
            }else{
                 ListNode temp=new ListNode(0);
                 temp.next = l2;
                     while(carry!=0&&temp.next!=null){
                         temp = temp.next;
                         temp.val = (temp.val+carry)%10;
                         carry = (temp.val+carry)/10;
                        
                     }
                     l3.next=l2;
                     if(carry!=0)l3.next = new ListNode(1);
                 return l3;
            }
        }else{
            ListNode temp=new ListNode(0);
            temp.next=l1;
                     while(carry!=0&&temp.next!=null){
                         temp = temp.next;
                         temp.val = (temp.val+carry)%10;
                         carry = (temp.val+carry)/10;
                     }
            l3.next=l1;
            if(carry!=0)l3.next = new ListNode(1);
            return l3;
        }
        
        */
        if(carry!=0) p3.next = new ListNode(1);
                 return newHead.next;
    }
}
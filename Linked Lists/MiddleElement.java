// https://leetcode.com/problems/middle-of-the-linked-list/submissions/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MiddleElement 
{
    public ListNode middleNode(ListNode head) 
    {
        ListNode current = head;
        ListNode runner;
        if(head.next != null)
            runner = head.next;
        else
            return head;
        
        while(runner.next != null && runner.next.next != null)
        {
            current = current.next;
            runner = runner.next.next;
        }
        return current.next;
    }
}
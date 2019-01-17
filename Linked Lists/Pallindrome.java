// Check if LinkedList is Pallindrome

import LinkedListNode;
import java.util.Stack;

class Pallindrome
{
    boolean isPallindrome(LinkedListNode head)
    {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();

        while(fast != null && fast.next != null)
        {
            stack.add(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // has odd elements, so skip the middle element
        if(fast != null)
            slow = slow.next;

        while(slow != null)
        {
            int top = stack.pop().intValue();

            if(top != slow.data)
                return false;
            
            slow = slow.next;
        }
        return true;
    }

}
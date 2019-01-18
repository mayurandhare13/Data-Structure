// find start of loop in LinkedList

import LinkedListNode;

class BeginLoop
{
    LinkedListNode findBeginning(LinkedListNode head)
    {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;  // we found loop // collision
        }

        // error check -> if no loop
        if(fast == null || fast.next == null)
            return null;

        // move slow to head. if they are k steps into loop
        // they will meet at start of loop if both move at same pace
        slow = head;
        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return fast; // or slow, both are at beginning of loop
    }
}
// Que - Remove Duplicates from list
import LinkedListNode;
import java.util.HashSet;
import java.util.Iterator;

class RemoveDups
{
    void deleteDups(LinkedListNode n)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode prev = null;
        while(n != null)
        {
            if(set.contains(n.data))
            {
                prev.next = n.next;
            }
            else
            {
                set.add(n.data);
                prev = n;
            }
            n = n.next;
        }
    }
    // O(N) time ==> N number of elements in list

    void deleteDups2(LinkedListNode head)
    {
        LinkedListNode current = head;
        while(current != null)
        {
            LinkedListNode runner = current;
            while(runner.next != null)
            {
                if(runner.next.data == current.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
    }
    // O(1) space complexity, but O(n^2) time.

    public static void main(String[] args) 
    {
        LinkedListNode first = new LinkedListNode(0, null, null);
		LinkedListNode head = first;
		LinkedListNode second = first;
        for (int i = 1; i < 8; i++) 
        {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrev(first);
			first = second;
		}
		
        System.out.println(head.printForward());

        RemoveDups rd = new RemoveDups();
        rd.deleteDups2(head);

        System.out.println(head.printForward());

    }
}
// Que - Remove Duplicates from list

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class RemoveDups
{
    void deleteDups(LinkedList n)
    {
        HashSet<Integer> set = new HashSet<>();
        LinkedList prev = null;
        while(n != null)
        {
            if(set.contains(n.data))
            {
                prev.next = n.next;
            }
            else
            {
                set.add(n.add);
                prev = n;
            }
            n = n.next;
        }
    }
    // O(N) time ==> N number of elements in list
}
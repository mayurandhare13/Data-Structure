"""
An XOR linked list is a more memory efficient doubly linked list.
Instead of each node holding next and prev fields, it holds a field named both, which is a XOR of the next node and the previous node. Implement a XOR linked list;it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

Note: python does not have actual pointers (id() exists but it is not an actual pointer in all implementations).
For this reason, we use a python list to simulate memory. Indexes are the addresses in memory. This has the unfortunate consequence that the travel logic needs to reside in the List class rather than the Node one.
"""

class XORNode(object):

    def __init__(self, val, prev, next):
        self.val = val
        self.both = prev ^ next

    def next_node(self, prev_idx):
        return self.both ^ prev_idx

    def prev_node(self, next_idx):
        return self.both ^ next_idx


class XORLinkedList(object):

    def __init__(self):
        self.mem = [XORNode(None, -1, -1)]  # head node index, prev node index, next node index

    def head(self):
        return 0, -1, self.mem[0]

    def add(self, val):
        current_node_idx, prev_node_idx, current_node = self.head()

        while(True):
            next_node_idx = current_node.next_node(prev_node_idx)
            if(next_node_idx == -1):    # last node
                break
            prev_node_idx, current_node_idx = current_node_idx, next_node_idx
            current_node = self.mem[next_node_idx]

        new_node_idx = len(self.mem)
        current_node.both = prev_node_idx ^ new_node_idx
        self.mem.append(XORNode(val, current_node_idx, -1))

    def get(self, idx):
        current_idx, prev_idx, current_node = self.head()
        for count in range(idx + 1):
            prev_idx, current_idx = current_idx, current_node.next_node(prev_idx)
            current_node = self.mem[current_idx]
        
        return current_node.val


if __name__ == "__main__":
    
    l = XORLinkedList()
    l.add(13)
    l.add(9)
    l.add(1994)

    print(l.get(0))
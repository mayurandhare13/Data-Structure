public class Node
{
    Node above;
    Node below;
    int value;

    public Node(int val)
    {
        this.value = val;
        above = null;
        below = null;
    }
}
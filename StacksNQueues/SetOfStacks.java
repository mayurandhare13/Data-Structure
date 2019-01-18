import java.util.ArrayList;
import java.util.EmptyStackException;
import Stack;

public class SetOfStacks
{
    ArrayList<Stack> stacks = new ArrayList<>();
    public int capacity;
    
    public SetOfStacks(int capacity)
    {
        this.capacity = capacity;
    }

    public Stack getLastStack()
    {
        if(stacks.size() == 0)
        {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int v)
    {
        Stack last = getLastStack();
        if(last != null && !last.isFull())
        {
            last.push(v);
        }
        else
        {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop()
    {
        Stack last = getLastStack();
        if(last == null) throw new EmptyStackException();
        int v = last.pop();
        if(last.size == 0)
        {
            stacks.remove(stacks.size() - 1);
        }
        return v;
    }

    public boolean isEmpty()
    {
        Stack last = getLastStack();
        return last == null || last.isEmpty();
    }

    public int popAt(int index)
    {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop)
    {
        Stack stack = stacks.get(index);
        int removed_item;
        if(removeTop)
        {
            removed_item = stack.pop(); // removeTop
        }
        else
        {
            removed_item = stack.removeBottom();
        }

        if(stack.isEmpty())
        {
            stacks.remove(index);
        }
        else if (stacks.size() > index + 1)
        {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removed_item;
    }


    public static void main(String[] args) 
    {
        SetOfStacks ss = new SetOfStacks(5);
        ss.push(13);
        ss.push(9);
        ss.push(1994);
        ss.push(30);
        ss.push(8);
        ss.push(1994);
        ss.push(1);
        ss.push(1);
        ss.push(2001);
        System.out.println(ss.popAt(0));
    }
}
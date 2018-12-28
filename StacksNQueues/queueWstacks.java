import java.util.Stack;

public class queueWstacks<T>
{
    Stack<T> stackNewest, stackOldest;

    public queueWstacks()
    {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size()
    {
        return stackOldest.size() + stackNewest.size();
    }

    public void add(T value)
    {
        //push onto Newest which always have newest at top
        stackNewest.push(value);
    }

    private void shiftStacks()
    {
        if(stackOldest.isEmpty())
        {
            while(!stackNewest.isEmpty())
            {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek()
    {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove()
    {
        shiftStacks();
        return stackOldest.pop();
    }


    public static void main(String[] args) 
    {
        queueWstacks<Integer> qs = new queueWstacks<>();
        qs.add(13);
        qs.add(9);
        qs.add(1994);
        
        System.out.println(qs.remove());
        qs.add(44);
        qs.add(50);
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.remove());
        System.out.println(qs.peek());
    }
}
import java.lang.Exception;
import java.util.EmptyStackException;

public class MultiStack
{
// class StackInfo - for holding data about each stack
    private class StackInfo
    {
        public int start, size, capacity;
        public StackInfo(int start, int capacity)
        {
            this.start = start;
            this.capacity = capacity;
        }

        // check if index on full array within stack boundries
        // stack can wrap around to start of array.

        public boolean isWithinStackCapacity(int index)
        {
            // if outside of bound of array, return false
            if(index < 0 || index >= values.length)
            {
                return false;
            }

            // if index wraps around adjust it.
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end; 
        }

        public int lastCapacityIndex()
        {
            return adjustIndex(start + capacity - 1);
        }

        public int lastElementIndex()
        {
            return adjustIndex(start + size - 1);
        }

        public boolean isFull()
        {
            return size == capacity;
        }

        public boolean isEmpty()
        {
            return size == 0;
        }
    }

    private StackInfo[] info;
    private int[] values;

    public MultiStack(int numOfStack, int defaultSize)
    {
        // create metadata for all stacks
        info = new StackInfo[numOfStack];
        for(int i=0; i<numOfStack; i++)
        {
            info[i] = new StackInfo(defaultSize * i, defaultSize);
        }
        values = new int[numOfStack * defaultSize];
    }

    // throws FullStackException
    public void push(int stackNum, int value)
    {
        if(allStacksFull())
        {
            // throw new FullStackException();
            System.out.println("Full Stack");
            return;
        }
        System.out.println("in push");

        // if this stack is full, expand
        StackInfo stack = info[stackNum];
        if(stack.isFull())
        {
            expand(stackNum);
        }

        //find the index of top element in array + 1, increment pointer
        stack.size++;
        values[stack.lastCapacityIndex()] = value;
    }

    public int pop(int stackNum) throws Exception
    {
        StackInfo stack = info[stackNum];
        if(stack.isEmpty())
        {
            throw new EmptyStackException();
        }
        
        // remove last element
        int value = values[stack.lastElementIndex()];
        values[stack.lastElementIndex()] = 0; // clear item
        stack.size--; // shrink size
        return value;
    }

    public int peek(int stackNum)
    {
        StackInfo stack = info[stackNum];
        return values[stack.lastElementIndex()];
    }

    private void shift(int stackNum)
    {
        System.out.println("Shifting: " + stackNum);
        StackInfo stack = info[stackNum];

        if(stack.size >= stack.capacity)
        {
            int nextStack = (stackNum + 1) % info.length;
            shift(nextStack);
            stack.capacity++;
        }

        // shift all elements in stack over by one.
        int index = stack.lastCapacityIndex();
        while(stack.isWithinStackCapacity(index))
        {
            values[index] = values[previousIndex(index)];
            index = previousIndex(index);
        }

        // adjust stack data
        values[stack.start] = 0;    // clear item
        stack.start = nextIndex(staack.start);  //move start
        stack.capacity--;   // shrink capacity
    }

    private void expand(int stackNum)
    {
        shift((stackNum + 1) % info.length);
        info[stackNum].capacity++;
    }

    public int numberOfElements()
    {
        int size = 0;
        for(StackInfo si : info)
        {
            size = si.size;
        }
        return size;
    }

    public boolean allStacksFull()
    {
        return numberOfElements() == values.length;
    }

    private int adjustIndex(int index)
    {
        // java mod for -ve --> (-11 % 4) = -1, not 4
        int max = values.length;
        return ((index % max) + max) % max;
    }

    private int nextIndex(int index)
    {
        return adjustIndex(index + 1);
    }

    private int previousIndex(int index)
    {
        return adjustIndex(index - 1);
    }


    public static void main(String[] args) 
    {
        MultiStack ms = new MultiStack(3, 5);
        ms.push(1, 11);
        ms.push(0, 22);
        ms.push(0, 33);
        ms.push(0, 44);
        ms.push(0, 55);
        ms.push(0, 66);
        
        System.out.println(ms.pop(0));
    }
}
import MyStack;

public class StackWithMin extends MyStack<Integer>
{
    MyStack<Integer> s2;

    public StackWithMin()
    {
        s2 = new MyStack<>();
    }

    public void push(int value)
    {
        super.push(value);
        if(value <= min())
        {
            s2.push(value);
        }
    }

    public Integer pop()
    {
        int val = super.pop();
        if(val == min())
        {
            s2.pop();
        }
        return val;
    }

    public int min()
    {
        if(s2.isEmpty())
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return s2.peek();
        }
    }

    public static void main(String[] args) 
    {
        StackWithMin sm = new StackWithMin();
        sm.push(8);
        sm.push(13);
        sm.push(1);
        sm.push(1994);

        sm.pop();
        System.out.print(sm.min());;
    }
}
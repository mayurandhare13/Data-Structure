import java.util.Stack;

class Tower
{
    private Stack<Integer> disks = new Stack<>();
    public String name;

    public void add(int d)
    {
        if(!disks.isEmpty() && disks.peek() <= d)
            System.out.println("error placing disk "+d);
        else
            disks.push(d);
    }

    public void moveTopTo(Tower t)
    {
        int top = disks.pop();
        t.add(top);
    }

    public void print()
        System.out.println("Content of Tower: "+disks.toString());

    public void moveDisks(int quantity, Tower dest, Tower buffer)
    {
        if(quantity <= 0)
            return;
        
        moveDisks(quantity-1, buffer, dest);
        System.out.println("Move "+ disks.peek() + " from "+ this.name +" to "+ dest.name);
        moveTopTo(dest);
        buffer.moveDisks(quantity-1, dest, this);
    }
}
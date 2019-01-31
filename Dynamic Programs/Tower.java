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
    {
        System.out.println("Content of Tower: "+disks.toString());
    }

    public void moveDisks(int quantity, Tower dest, Tower buffer)
    {
        if(quantity <= 0)
            return;
        
        moveDisks(quantity-1, buffer, dest);
        System.out.println("Move "+ disks.peek() + " from "+ this.name +" to "+ dest.name);
        moveTopTo(dest);
        buffer.moveDisks(quantity-1, dest, this);
    }

    public static void main(String[] args) 
    {
        Tower source = new Tower();
        Tower dest = new Tower();
        Tower buffer = new Tower();

        source.name = "S";
        dest.name = "D";
        buffer.name = "B";

        int numberOfDisks = 5;
        for(int disk = numberOfDisks; disk>=1; disk--)
            source.add(disk);

        source.print();
        source.moveDisks(numberOfDisks, dest, buffer);
        dest.print();
    }
}
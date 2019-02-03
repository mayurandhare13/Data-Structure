class Box
{
    public int depth;
    public int height;
    public int width;

    public Box(int w, int h, int d)
    {
        depth = d;
        width = w;
        height = h;
    }

    public boolean canBeUnder(Box b)
    {
        if(width > b.width && depth > b.depth && height > b.height)
            return true;
        return false;
    }

    public boolean canBeAbove(Box b)
    {
        if(b == null)
            return true;

        if(width < b.width && depth < b.depth && height < b.height)
            return true;
        
        return false;
    }

    public String toString()
    {
        return "Box(width: " + width +", depth: "+ depth + ", height: "+ height + ")";
    }
}
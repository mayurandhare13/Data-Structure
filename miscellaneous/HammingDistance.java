class HammingDistance
{
    public static int hammingDistance(int x, int y)
    {
        int r = x ^ y;
        int count = 0;
        while(r > 0)
        {
            count += r & 1;
            r >>= 1;
        }
        return count;

        //Integer.bitCount(x^y) --> one line solution
    }

    public static void main(String[] args) 
    {
        System.out.println(hammingDistance(1, 4));    
    }
}
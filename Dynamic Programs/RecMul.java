// recursive multiiply w/o using * or / operator
// peasant algorithm
class RecMul
{
    static int counter = 0;

    public static int minProduct(int a, int b)
    {
        if(a < b)
            return minProduct(b, a);

        int value = 0;
        while(a > 0)
        {
            counter++;
            if((a % 10) % 2 == 1)
            {
                value += b;
            }

            a = a >> 1;
            b = b << 1;
        }
        return value;
    }

    public static void main(String[] args) 
    {
        int a = 13;
        int b = 30;
        System.out.println(minProduct(a, b));    
    }
}
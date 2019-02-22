class NumberComplement
{
    public static int findComplement(int num) 
    {
        int k = (int)(Math.log10(num) / Math.log10(2) + 1); // will return number of bits in integer
        System.out.println(k);
        int mask = (1 << k) - 1;
        return num ^ mask;
    }
    public static void main(String[] args) 
    {
        System.out.println(findComplement(8));
    }
}
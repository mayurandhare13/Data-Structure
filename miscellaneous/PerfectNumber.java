//https://leetcode.com/problems/perfect-number/

class PerfectNumber
{
    public static boolean checkPerfectNumber(int num) 
    {
        if(num <= 1)
            return false;
        
        int sum = 1;
        int maxNum = (int)Math.sqrt(num);
        for (int i = 2; i <= maxNum; i++) 
        {
            if (num % i == 0)
                sum += i + num / i;
        }
        
        return sum == num;
    }

    public static void main(String[] args) 
    {
        System.out.println(checkPerfectNumber(28));    
    }
}
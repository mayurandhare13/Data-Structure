// check int pallindrome

class Pallindrome {
    public boolean isPalindrome(int x) 
    {
        if(x < 0)
            return false;
        
        int rev = 0;
        int n = x;
        while(x > 0)
        {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        
        return (n == rev);
    }
}

// time complexity O(log_10 (n))

// (str(x)==str(x)[::-1]) in python
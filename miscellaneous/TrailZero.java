// return trailing zeroes from factorial

class TrailZero {
    

    public static int trailingZeroes(int n) 
    {
        int count = 0;
        
        while(n >= 5)
            count += (n /= 5);
        
        return count;
    }

    public static void main(String[] args) {
        int num = 13;
        System.out.println(trailingZeroes(num));
    }
}

// This gives log(n) time complexity
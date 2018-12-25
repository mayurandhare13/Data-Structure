/* Que - Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structure?
*/

class Unique
{
    boolean isUniqueChars(String str)
    {
        if (str.length() > 128) // consider 128 ASCII chars
            return false;
        
        boolean[] charSet = new boolean[128];
        for(int i=0; i<str.length(); i++)
        {
            int val = str.charAt(i);
            if(charSet[val])
                return false;
            else
                charSet[val] = true;
        }
        return true;
    }

    // optimize for space by factor of 8
    boolean isUniqueCharsOpt(String str)
    {
        if (str.length() > 128) // consider 128 ASCII chars
            return false;
        
        int checker = 0;
        for(int i=0; i<str.length(); i++)
        {
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0)
                return false;
            else
                checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) 
    {
        Unique u = new Unique();
        String s1 = "Algorithm";
        String s2 = "Data Structure";
        System.out.println(u.isUniqueChars(s1));    
        System.out.println(u.isUniqueCharsOpt(s2));
    }
}

/* Space Complexity O(1)
Time Complexity O(min(c, n))
c=set of characters, n=length of string */
/*Que - Check Permutation - given two strings, write a method to check 
if one is permutation of other.*/
class StringPermutation
{
    String sort(String s)
    {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content); //based on iterative merge sort
        return new String(content);
    }

    boolean check_permutation(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        return sort(s1).equals(sort(s2));
    }

    // optimized
    boolean permutation(String s, String t)
    {
        if(s.length() != t.length())
            return false;
        
        int[] letters = new int[128]; //assume ASCII char set
        char[] s_array = s.toCharArray();
        for(char c : s_array)
        {
            letters[c]++;
        }

        for(int i=0; i<t.length(); i++)
        {
            int c = (int) t.charAt(i);
            letters[c]--;
            if(letters[c] < 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) 
    {
        StringPermutation sp = new StringPermutation();
        String s1 = "apple";
        String s2 = "paple";
        String s3 = "maple";
        System.out.println(sp.check_permutation(s1, s2));
        System.out.println(sp.permutation(s1, s3));
    }
}
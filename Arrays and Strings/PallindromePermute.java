/*Que- Check if string is permutation of pallindrome*/
class PallindromePermute
{
    boolean isPermutationOfPallindrome(String phrase)
    {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    // case insensitive A === a == 10
    int getCharNumber(Character c)
    {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z)
            return val-a;    
        return -1;
    }

    int[] buildCharFrequencyTable(String phrase)
    {
        int[] table = new int[Character.getNumericValue('z') - 
                              Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray())
        {
            int x = getCharNumber(c);
            if(x != -1) //ignoring space
                table[x]++;
        }
        return table;
    }

    boolean checkMaxOneOdd(int[] table)
    {
        boolean foundOdd = false;
        for (int count: table)
        {
            if(count%2 == 1)
            {
                if(foundOdd)
                    return false;
                foundOdd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        PallindromePermute pp = new PallindromePermute();
        String s = "Mam Sas";
        System.out.println(pp.isPermutationOfPallindrome(s));
    }
}
// O(N) time complexity
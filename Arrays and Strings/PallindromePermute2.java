/*Que- Check if string is permutation of pallindrome*/
class PallindromePermute2
{
    boolean isPermutationOfPallindrome(String phrase)
    {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
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

    int createBitVector(String phrase)
    {
        int bitVector = 0;
        for(char c : phrase.toCharArray())
        {
            int val = getCharNumber(c);
            bitVector = toggle(bitVector, val);
        }
        return bitVector;
    }

    int toggle(int bitVector, int index)
    {
        if(index < 0) return bitVector;

        int mask = 1 << index;
        if((bitVector & mask) == 0)
            bitVector |= mask;  // set the bit
        else
            bitVector &= ~mask; //reset the bit
        
        return bitVector;
    }

    boolean checkExactlyOneBitSet(int bitVector)
    {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String[] args) 
    {
        PallindromePermute2 pp = new PallindromePermute2();
        String s = "Mam Sas";
        System.out.println(pp.isPermutationOfPallindrome(s));
    }
}
// O(N) time complexity
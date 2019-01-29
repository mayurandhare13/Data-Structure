import java.util.Set;
import java.util.HashSet;

class JewelStone
{

    public static int numJewelsInStones(String J, String S) 
    {
        int jStone = 0;
        Set set = new HashSet(J.length());
        for(char j : J.toCharArray())
            set.add(j);
        
        for(char c : S.toCharArray())
        {
            if(set.contains(c))
                jStone++;
        }
        return jStone;
        // time complexity O(M+N)
    }

    public static int numJewelsInStones2(String J, String S) 
    {
        int jStone = 0;
        for(int i=0; i<S.length(); i++)
            if(J.indexOf(S.charAt(i)) > -1) jStone++;

        return jStone;
    }

    public static void main(String[] args) 
    {
        String J = "aA", S = "aAAbbbb";   
        System.out.println(numJewelsInStones2(J, S)); 
    }
}


class OneAway
{
    boolean oneEditAway(String f, String s)
    {
        if(f.length() == s.length())
            return oneEditReplace(f, s);
        else if(f.length()+1 == s.length())
            return oneEditInsert(f, s);
        else if(f.length()-1 == s.length())
            return oneEditInsert(s, f);

        return false;
    }

    boolean oneEditReplace(String f, String s)
    {
        boolean foundDifference = false;
        for(int i=0; i<f.length(); i++)
        {
            if(f.charAt(i) != s.charAt(i))
            {
                if(foundDifference)
                    return false;
                else
                    foundDifference = true;
            }
        }
        return true;
    }

    boolean oneEditInsert(String f, String s)
    {
        int index1 = 0;
        int index2 = 0;
        while(index2 < s.length() && index1 < f.length())
        {
            if(s.charAt(index2) != f.charAt(index1))
            {
                if(index1 != index2)
                    return false;
                index2++;   // as string s is longer by 1
            }
            else
            {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static void main(String[] args) 
    {
        OneAway oa = new OneAway();
        String f = "Mayur";
        String s = "Mayuri";
        System.out.println(oa.oneEditAway(f, s));    
    }
}
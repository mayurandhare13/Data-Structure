// https://leetcode.com/problems/di-string-match/

class DIStringMatch 
{
    public int[] diStringMatch(String S) 
    {
        int n = S.length();
        int[] res = new int[n+1];
        int low = 0;
        int high = n;
        for(int i=0; i<n; i++)
        {
            if(S.charAt(i) == 'I')
            {
                res[i] = low;
                low++;
            }
            else
            {
                res[i] = high;
                high--;
            }
        }
        if(S.charAt(n-1) == 'D') res[n] = high;
        else res[n] = low;
        return res;
    }   
}
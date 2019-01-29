import java.util.Arrays;

class LCS
{
    public static int findSubs(char[] s1, char[] s2)
    {
        int[][] mat = new int[s1.length + 1][s2.length +1];
        int max = 0;

        for(int i=1; i<mat.length; i++)
        {
            for(int j=1; j<mat[0].length; j++)
            {
                if(s1[i-1] == s2[j-1])
                    mat[i][j] = mat[i-1][j-1] + 1;
                else
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);

                if(mat[i][j] > max)
                    max = mat[i][j];
            }
        }

        for(int[] r : mat)
        {
            System.out.println(Arrays.toString(r));
        }

    //    printSubs(mat, s1, s2, max);  TODO

        return max;
    }



    public static void main(String[] args) 
    {
        String s1 = "abcdaf";
        String s2 = "acbcf";
        int maxLen = findSubs(s1.toCharArray(), s2.toCharArray()); 
        System.out.println(maxLen);
    }
}
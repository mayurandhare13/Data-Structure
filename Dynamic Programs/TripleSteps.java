import java.util.Arrays;

class TripleSteps
{
    public static int countWays(int n)
    {
        int[] map = new int[n + 1];
        Arrays.fill(map, -1);
        return countWays(n, map);
    }

    private static int countWays(int n, int[] map)
    {
        if(n < 0)
            return 0;
        else if(n == 0)
            return 1;
        else if(map[n] > -1)
            return map[n];
        else
        {
            map[n] = countWays(n-1, map) + countWays(n-2, map) + countWays(n-3, map);
            return map[n];
        }
    }

    public static void main(String[] args) 
    {
        int steps = 10;
        System.out.println(countWays(steps));    
    }
}
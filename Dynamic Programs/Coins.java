// number of ways denominators add upto given number

class Coins
{
    private static int makeChange(int total, int[] denoms, int index, int[][] map)
    {
        if(map[total][index] > 0)
            return map[total][index];

        int coin = denoms[index];
        if(index == denoms.length-1)
        {
            int remains = total % coin;
            return remains == 0 ? 1 : 0;
        }

        int numberOfWays = 0;
        for(int amount = 0; amount <= total; amount += coin)
        {
            numberOfWays += makeChange(total-amount, denoms, index+1, map);
        }

        map[total][index] = numberOfWays;

        return numberOfWays;
    }

    public static int makeChange(int n , int[] denoms)
    {
        int[][] map = new int[n+1][denoms.length];
        return makeChange(n, denoms, 0, map);
    }

    public static void main(String[] args) 
    {
        int[] denoms = {25, 10, 5, 1};
		int ways = makeChange(10, denoms);
		System.out.println(ways);    
    }
}
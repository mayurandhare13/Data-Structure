import java.util.HashMap;

// https://leetcode.com/problems/remove-boxes/description/

class RemoveBoxes
{
    HashMap<String, Integer> map = new HashMap<>();
    public int removeBox(String input)
    {
        int profit = 0;
        if(input == null || input.length() == 0)
            return 0;

        if(map.containsKey(input))
            return map.get(input);
        
        if(input.length() == 1)
            return 1;

        int start_index = 0;
        int end_index = 0;
        while(start_index < input.length())
        {
            char c = input.charAt(start_index);
            int count = 0;
            while(end_index < input.length() && c == input.charAt(end_index))
            {
                count++;
                end_index++;
            }

            if(end_index >= input.length())
                profit = Math.max(profit, count*count);
            else
            {
                profit = Math.max(profit, removeBox(input.substring(0, start_index) + input.substring(end_index, input.length())) + count*count);
            }
            start_index = end_index;
        }  
        map.put(input, profit);
        return profit;      
    }

    public static void main(String[] args) 
    {
        RemoveBoxes r = new RemoveBoxes();
        long startTime  = System.currentTimeMillis();
        String input = "123321";
        System.out.println("Max Profit: " + r.removeBox(input));
        long end  = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-startTime)/1000 + " seconds");
    }
}
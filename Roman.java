// return numeric value of roman integers

import java.util.HashMap;
import java.util.Map;

class Roman 
{
    public static int romanToInt(String s) 
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int numeric = 0;
        
        int c = 0;
        while(c < s.length())
        {
            if((c+1) < s.length() && map.get(s.charAt(c)) < map.get(s.charAt(c+1)))
            {
                numeric += map.get(s.charAt(c+1)) - map.get(s.charAt(c));
                c += 2;
            }
            else
            {
                numeric += map.get(s.charAt(c));
                c += 1;
            }
        }
        return numeric;
    }

    public static void main(String[] args) 
    {
        System.out.println(romanToInt("IM"));
    }
}
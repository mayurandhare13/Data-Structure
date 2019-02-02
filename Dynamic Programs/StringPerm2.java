import java.util.ArrayList;
import java.util.HashMap;

// String Permutation with Duplicates
class StringPerm2
{
    private static HashMap<Character, Integer> buildFreqTable(String str)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray())
        {
            if(!map.containsKey(c))
                map.put(c, 0);
            
            map.put(c, map.get(c) + 1);
        }
        return map;
    }

    private static void printPerms(HashMap<Character, Integer> map, String prefix, int remains, ArrayList<String> result)
    {
        if(remains == 0)
        {
            result.add(prefix);
            return;
        }

        for(Character c : map.keySet())
        {
            int count = map.get(c);
            if(count > 0)
            {
                map.put(c, count - 1);
                printPerms(map, prefix + c, remains - 1, result);
                map.put(c, count);
            }
        }
    }

    public static ArrayList<String> printPerms(String str)
    {
        ArrayList<String> result = new ArrayList<>();
        HashMap<Character, Integer> map = buildFreqTable(str);

        printPerms(map, "", str.length(), result);
        return result;
    }

    public static void main(String[] args) 
    {
		String s = "aabbc";
		ArrayList<String> result = printPerms(s);
		System.out.println("Count: " + result.size());
		for (String r : result) {
			System.out.println(r);
		}
	}
}
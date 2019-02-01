// String permutation without duplicates

import java.util.ArrayList;

class StringPermutation
{
    public static ArrayList<String> getPerms(String str)
    {
        if(str == null)
            return null;

        ArrayList<String> permutations = new ArrayList<>();

        if(str.length() == 0)   //base case
        {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); //first char
        String remains = str.substring(1);
        ArrayList<String> words = getPerms(remains);
        
        for(String word : words)
        {
            for(int j=0; j<=word.length(); j++)
            {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    private static String insertCharAt(String word, char c, int i)
    {
        String before = word.substring(0, i);
        String after = word.substring(i);
        return before + c + after;
    }

    public static void main(String[] args) 
    {
        ArrayList<String> list = getPerms("abcd");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}    
    }
}
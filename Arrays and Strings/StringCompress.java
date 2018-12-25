/*Que- String Compression, aabcccccaaa ==> a2b1c5a3 assume only uppercase and lowercase letters.
if compressed string is not smaller than original, then return original string
*/

class StringCompress
{
    String compress(String str)
    {
        int finalLen = countCompression(str);
        if(finalLen >= str.length())
            return str;
        
            StringBuilder compressed = new StringBuilder(finalLen);
            int countConsecutive = 0;
            for(int i=0; i<str.length(); i++)
            {
                countConsecutive++;
                if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))
                {
                    compressed.append(str.charAt(i));
                    compressed.append(countConsecutive);
                    countConsecutive = 0;
                }
            }
        return compressed.toString();
    }

    int countCompression(String str)
    {
        int compressedLen = 0;
        int countConsecutive = 0;
        for(int i=0; i<str.length(); i++)
        {
            countConsecutive++;
            if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))
            {
                compressedLen += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLen;
    }

    public static void main(String[] args) 
    {
        StringCompress sc = new StringCompress();
        String s = "aaabbccccd";
        System.out.println(sc.compress(s));    
    }
}

/* String concatenation works in O(n^2) time
we used stringbuilder with fixed initial capacity(line 13). which will reduce time complexity.
we have repeated code to count the length of final compressed string, but this helps in NOT creating compressed String unless its length is less than actual string length.(line 10)
*/
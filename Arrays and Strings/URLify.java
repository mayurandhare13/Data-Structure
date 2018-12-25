/* Que - replace all spaces in String with '%20', assume string has sufficient space at the end to hold additional character.
you have given 'true' length of string.
*/

class URLify
{
    String replaceSpaces(char[] str, int trueLength)
    {
        int spaceCount = 0, index, i = 0;
        for(i=0; i<trueLength; i++)
        {
            if(str[i] == ' ') 
                spaceCount++;
        }
        // we need 3 space, 1 already in truelength
        index = trueLength + spaceCount*2; 

        if(trueLength < str.length)
            str[trueLength] = '\0'; //end array
        
        for(i=trueLength-1; i>=0; i--)
        {
            if(str[i] == ' ')
            {
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index = index - 3;
            }
            else
            {
                str[index-1] = str[i];
                index--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) 
    {
        URLify u = new URLify();
        String s = "Mr John Wick    ";
        System.out.println(u.replaceSpaces(s.toCharArray(), 12));
    }
}

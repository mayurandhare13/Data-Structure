import java.lang.StringBuilder;

class ToLower
{
    public static void toLowerCase(String str) 
    {
        StringBuilder sb = new StringBuilder();
        char a = '0';
        for(int i : str.toCharArray())
        {
            
            System.out.println(a);
            if(i <= 90 && i >= 65)
            {
                a = (char)(i+32);
                sb.append(a);
            }
            else
                sb.append((char)i);
        }
        System.out.println(sb);    
    }
    public static void main(String[] args) 
    {
        toLowerCase("ZzBb");
    }
}
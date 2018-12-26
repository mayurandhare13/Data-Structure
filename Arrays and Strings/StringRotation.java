/* Que - String Rotation, check if one string is rotation of another
using one call to isSubstring() method.
*/

class StringRotation
{
    boolean isRotation(String s1, String s2)
    {
        int len = s1.length();

        if(len == s2.length() && len > 0)
        {
            String str = s1 + s1;
            return isSubstring(str, s2);
        }
        return false;
    }

    // here isSubstring is assumed method.
    boolean isSubstring(String str, String s2)
    {
        return str.contains(s2);
    }

    public static void main(String[] args) 
    {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        
        StringRotation sr = new StringRotation();
        System.out.println(sr.isRotation(s1, s2));
    }
}

// runtime O(N) ==> length of s1 and s2
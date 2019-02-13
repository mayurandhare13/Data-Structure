class RansomNote
{
    public static boolean canConstruct(String ransomNote, String magazine) 
    {
        int[] arr = new int[26];
        for(int i=0; i<magazine.length(); i++)
        {
            arr[magazine.charAt(i) - 'a']++;
        }

        for(int j=0; j<ransomNote.length(); j++)
        {
            if(--arr[ransomNote.charAt(j) - 'a'] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String magazine = "effjfggbffjdgbjjhhdegh";
        String ransomNote = "fffbfg";
        System.out.println(canConstruct(ransomNote, magazine));
    }
}
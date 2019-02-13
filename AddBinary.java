class AddBinary
{
    public static String addBinary(String a, String b) 
    {
        /* works for small length
        Long f = Long.parseLong(a, 2);
        Long s = Long.parseLong(b, 2);
        return Long.toBinaryString(f+s);
        */

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) 
                sum += b.charAt(j--) - '0';
            if (i >= 0) 
                sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) 
            sb.append(carry);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        String a = "1010000";
        String b = "11010";
        System.out.println(addBinary(a, b));
    }
}
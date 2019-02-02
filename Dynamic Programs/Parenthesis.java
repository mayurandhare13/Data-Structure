// create valid parenthesis string

import java.util.ArrayList;

class Parenthesis
{
    private static void addParen(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index)
    {
        if(leftRem < 0 || rightRem < leftRem)   // invalid state
            return;
        if(leftRem == 0 && rightRem == 0)
            list.add(String.copyValueOf(str));  // out of left and right parenthesis
        else
        {
            str[index] = '(';
            addParen(list, leftRem-1, rightRem, str, index+1);  // add left and recurse

            str[index] = ')';
            addParen(list, leftRem, rightRem-1, str, index+1);  // add right and recurse
        }
    }

    public static ArrayList<String> generateParens(int count)
    {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }

    public static void main(String[] args) 
    {
		ArrayList<String> list = generateParens(4);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list.size());		
	}
}
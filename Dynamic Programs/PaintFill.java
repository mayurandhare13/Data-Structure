//fill in the new color until surrounding same color changes to new color

class PaintFill
{
    public enum Color
    {
        Black, White, Red, Yellow, Green
    }

    private static String printColor(Color c)
    {
        switch (c) 
        {
            case Black:
                return "B ";
            case White:
                return "W ";
            case Red:
                return "R ";
            case Yellow:
                return "Y ";
            case Green:
                return "G ";
        }
        return "X";
    }

    public static void printScreen(Color[][] screen)
    {
        for(int r=0; r<screen.length; r++)
        {
            for(int c=0; c<screen[0].length; c++)
                System.out.print(printColor(screen[r][c]));
            System.out.println();
        }
    }

    private static boolean paintFill(Color[][] screen, int r, int c, Color oColor, Color nColor)
    {
        if(r < 0 || r >= screen.length || c < 0 || c >= screen[0].length)
            return false;
        
        if(screen[r][c] == oColor)
        {
            screen[r][c] = nColor;
            paintFill(screen, r+1, c, oColor, nColor); // down
            paintFill(screen, r-1, c, oColor, nColor); // up
            paintFill(screen, r, c+1, oColor, nColor); // right
            paintFill(screen, r, c-1, oColor, nColor); //left
        }
        return true;
    }

    public static boolean paintFill(Color[][] screen, int r, int c, Color nColor)
    {
        if(screen[r][c] == nColor)
            return false;
        return paintFill(screen, r, c, screen[r][c], nColor);
    }

    public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

    public static void main(String[] args) 
    {
		int N = 10;
		Color[][] screen = new Color[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				screen[i][j] = Color.Black;
			}			
		}
		for (int i = 0; i < 100; i++) {
			screen[randomInt(N)][randomInt(N)] = Color.Green;
		}
		printScreen(screen);
		paintFill(screen, 9, 9, Color.White);
		System.out.println();
		printScreen(screen);
	}
}
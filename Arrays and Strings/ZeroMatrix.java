/*Que- if an element in an MxN matrix is 0,
its entire row and column are set to 0. */

class ZeroMatrix
{
    void setZeros(int[][] mat)
    {
        boolean rowHasZero = false;
        boolean colHasZero = false;

        // check if first row has a zero
        for(int j=0; j<mat[0].length; j++)
        {
            if(mat[0][j] == 0)
            {
                rowHasZero = true;
                break;
            }
        }

        // check if column has zero
        for(int i=0; i<mat.length; i++)
        {
            if(mat[i][0] == 0)
            {
                colHasZero = true;
                break;
            }
        }

        // check for zeros in the rest of the array
        // and set 0 to corrosponding 0th row and column
        for(int i=1; i<mat.length; i++)
        {
            for(int j=1; j<mat[0].length; j++)
            {
                if(mat[i][j] == 0)
                {
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        // nullify based on 0th column
        for(int i=1; i<mat.length; i++)
        {
            if(mat[i][0] == 0)
                nullifyRow(mat, i);
        }

        // nullify based on 0th row
        for(int j=1; j<mat[0].length; j++)
        {
            if(mat[0][j] == 0)
                nullifyCol(mat, j);
        }

        if(rowHasZero)
            nullifyRow(mat, 0);

        if(colHasZero)
            nullifyCol(mat, 0);

    }

    void nullifyRow(int[][] mat, int row)
    {
        for(int j=0; j<mat[0].length; j++)
            mat[row][j] = 0;
    }

    void nullifyCol(int[][] mat, int col)
    {
        for(int i=0; i<mat.length; i++)
            mat[i][col] = 0;
    }


    public static void main(String[] args) 
    {
        int[][] mat = {
            {1, 4, 0, 7},
            {6, 9, 8, 7},
            {1, 6, 5, 7},
            {9, 2, 3, 7}
        };    

        ZeroMatrix zm = new ZeroMatrix();
        zm.setZeros(mat);

        for(int [] a : mat)
        {
            for(int i : a)
                System.out.print(i + "\t");
            System.out.println();
        }
    }
}

// we reduced space to O(1) by using zeroth row and column as  
//replacement for row array and column array
/* Que- Rotate Matrix by 90 degree */
class RotateMatrix
{
    boolean rotate(int[][] matrix)
    {
        if(matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++)
        {
            int first = layer;
            int last = n-1-layer;

            for(int i=first; i<last; i++)
            {
                int offset = i-first;
                int top = matrix[first][i];    //save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }

        // print rotated matrix
        System.out.println("Rotated Matrix");
        printMatrix(matrix);

        return true;
    }

    void printMatrix(int[][] matrix)
    {
        for (int[] a : matrix) 
        {
            for (int i : a) 
            {
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) 
    {
        int[][] mat= {{1, 2, 3, 4},
                  {5, 6, 7, 8},
                  {9, 10, 11, 12},
                  {13, 14, 15, 16} } ;
        RotateMatrix rm = new RotateMatrix();
        System.out.println("Original Matrix");
        rm.printMatrix(mat);
        System.out.println(rm.rotate(mat));  
    }
}

// O(n^2) as algorithm must touch n^2 elements
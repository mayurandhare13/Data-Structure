import java.util.LinkedList;
import java.util.Queue;

class SnakeLadder
{
    static class Vertex
    {
        int cell;
        int moves;
        Vertex(int cell, int moves)
        {
            this.cell = cell;
            this.moves = moves;
        }
    }

    public int findMinMoves(int[] board)
    {
        int size = board.length;
        boolean[] visited = new boolean[size];

        Queue<Vertex> queue = new LinkedList<>();
        Vertex v = new Vertex(0, 0);
        queue.add(v);
        visited[0] = true;

        while(!queue.isEmpty())
        {
            v = queue.poll();
            int cellNo = v.cell;
            
            if(cellNo == size-1)
                break;
            
            for(int i=cellNo+1; i<=(cellNo+6) && i<size; i++)
            {
                Vertex curVertex;
                if(!visited[i])
                {
                    if(board[i] == -1)
                        curVertex = new Vertex(i, v.moves+1);
                    else
                        curVertex = new Vertex(board[i], v.moves+1);
                    
                    visited[i] = true;
                    queue.add(curVertex);
                }
            }    
        }
        return v.moves;
    }

    public static void main(String[] args) 
    {
        int size = 36;
        int [] board = new int[size];
        for (int i = 0; i < size ; i++) {
            board[i] = -1;
        }
        //ladders
        board[2] = 15;
        board[14] = 24;
        board[20] = 31;

        // Snakes
        board[11] = 1;
        board[29] = 3;
        board[34] = 21;

        SnakeLadder s = new SnakeLadder();
        System.out.println("Minimum Dice throws needed to reach to end: " + s.findMinMoves(board));
    
    }
}
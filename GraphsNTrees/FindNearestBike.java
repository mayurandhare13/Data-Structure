import java.util.LinkedList;
import java.util.Queue;

class BuildingBlock
{
    int row, col, dist;

    public BuildingBlock(int row, int col, int dist)
    {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class FindNearestBike
{
    public static BuildingBlock findBike(int[][] buildings, int start_row, int start_col)
    {
        int distance = 0;
        if(buildings[start_row][start_col] == 1)
            return new BuildingBlock(start_row, start_col, distance);

        int len = buildings.length;
        boolean[][] Visited = new boolean[len][len];
        Visited[start_row][start_row] = true;
        
        BuildingBlock bb = new BuildingBlock(start_row, start_col, distance);
        Queue<BuildingBlock> queue = new LinkedList<BuildingBlock>();
        queue.add(bb);

        while(!queue.isEmpty())
        {
            BuildingBlock bObj = queue.poll();
            int row = bObj.row;
            int col = bObj.col;
            int dist = bObj.dist;

            dist++;

            // go UP
            int dest_row = row-1;
            int dest_col = col;
            if(dest_col >= 0 && dest_col < len && 
               dest_row >= 0 && dest_row < len && !Visited[dest_row][dest_col])
            {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if(buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                Visited[dest_row][dest_col] = true;
            } 

            // go DOWN
            dest_row = row+1;
            dest_col = col;
            if(dest_col >= 0 && dest_col < len && 
                dest_row >= 0 && dest_row < len && !Visited[dest_row][dest_col])
            {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if(buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                Visited[dest_row][dest_col] = true;
            } 

            // go LEFT
            dest_row = row;
            dest_col = col-1;
            if(dest_col >= 0 && dest_col < len && 
                dest_row >= 0 && dest_row < len && !Visited[dest_row][dest_col])
            {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if(buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                Visited[dest_row][dest_col] = true;
            } 

            // go RIGHT
            dest_row = row;
            dest_col = col+1;
            if(dest_col >= 0 && dest_col < len && 
                dest_row >= 0 && dest_row < len && !Visited[dest_row][dest_col])
            {
                BuildingBlock b1 = new BuildingBlock(dest_row, dest_col, dist);
                if(buildings[dest_row][dest_col] == 1)
                    return b1;
                queue.add(b1);
                Visited[dest_row][dest_col] = true;
            } 
        }

        return null;
    }

    public static void main(String[] args) 
    {
        int [][] buildings = {  {0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0},
                                {1, 0, 1, 0, 0},
                                {0, 0, 0, 0, 1},
                                {1, 0, 1, 0, 0}
                                };

        int start_building_row = 0;
        int start_building_col = 3;

        BuildingBlock result = findBike(buildings, start_building_row, start_building_col);

        if(result!=null) {
            int distance = result.dist;
            int dest_row = result.row;
            int dest_col = result.col;
            String buildingNo = start_building_row + "," + start_building_col;
            String destinationBuilding = dest_row + "," + dest_col;
            System.out.println("Source building No: " + buildingNo +"\n Nearest building " +
                    "where bike is available is: "+ destinationBuilding + "\n" +
                    " at distance: " + distance);
        }else{
            System.out.println("No bike is present in the any community");
        }
        
    }
}
import java.util.*;
public class Q122_ShortestDistanceFromAllBuildings {
	
	public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int buildings = 0;
        //Find how many buildings in grid
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1){
                    ++buildings;
                }
            }
        }
        //Store the distance for a spot to all the buildings
        int[][] distance = new int[rows][cols];
        //Store how many buildings a spot connects to
        int[][] count = new int[rows][cols];
        
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1){
                		//If one building cannot connect to all the other buildings
                		//Then we cannot find a solution
                    if(!bfs(grid, i, j, distance, count, buildings)){
                        return -1;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        boolean findOne = false;
        
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 0){
                    if(count[i][j] == buildings){
                        findOne = true;
                        min = min < distance[i][j] ? min : distance[i][j];
                    }
                }
            }
        }
        return findOne ? min : -1;
    }
    
    private class Point{
        int x;
        int y;
        int distance;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.distance = d;
        }
    }
    
    //Return true if the current building can connect to all the other buildings, false other wid=se
    private boolean bfs(int[][] grid, int startX, int startY, int[][] distance, int[][] count, int buildings){
        boolean[][] flag = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0));
        
        flag[startX][startY] = true;
        int find = 1; //All buildings should connect to each other 
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0; i < 4; ++i){
                int x = dx[i] + cur.x;
                int y = dy[i] + cur.y;
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                    continue;
                }
                //Connect to a building
                if(grid[x][y] == 1 && !flag[x][y]){
                    flag[x][y] = true;
                    ++find;
                }
                //Connect to a spot
                if(grid[x][y] == 0 && !flag[x][y]){
                    flag[x][y] = true;
                    queue.offer(new Point(x, y, cur.distance + 1));
                    distance[x][y] += cur.distance + 1;
                    ++count[x][y];
                }
                
            }
        }
        return find == buildings;
    }
}

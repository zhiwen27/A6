import java.util.*;
public class Test{
    public static ArrayList<Point> Maze(ArrayList<Point> route, int row, int col, int desX, int desY, int currentX, int currentY, boolean[][] canGo){
        if ((currentX == desX) && (currentY == desY)){
            System.err.println("Arrive at destination.");
            return route;
        }
        if (canGo[currentX][currentY] == false){
            System.err.println("You're at a wall/ you've visited here!");
            return route;
        }
        canGo[currentX][currentY] = false;
        //  Go north
        if (((currentX - 1) >= 0) && (canGo[currentX - 1][currentY] == true)){
            System.err.println("From: (" + currentX+ "," + currentY + ").");
            System.err.println("Now at: (" + (currentX - 1)+ "," + currentY + ").");
            route.add(new Point(currentX - 1, currentY));
            Maze(route, row, col, desX, desY, currentX - 1, currentY, canGo);
        }
        // Go south
        if (((currentX + 1) < row) && (canGo[currentX + 1][currentY] == true)){
            System.err.println("From: (" + currentX+ "," + currentY + ").");
            System.err.println("Now at: (" + (currentX + 1)+ "," + currentY + ").");
            route.add(new Point(currentX + 1, currentY));
            Maze(route,row, col, desX, desY,currentX + 1, currentY, canGo);
        }
        // Go east
        if (((currentY + 1) < col) && ((canGo[currentX][currentY + 1] == true))){
            System.err.println("From: (" + currentX+ "," + currentY + ").");
            System.err.println("Now at: (" + currentX + "," + (currentY + 1) + ").");
            route.add(new Point(currentX, currentY + 1));
            Maze(route,row, col, desX, desY, currentX, currentY + 1, canGo);
        }
        // Go west
        if (((currentY - 1) >= 0) && ((canGo[currentX][currentY - 1] == true))){
            System.err.println("From: (" + currentX+ "," + currentY + ").");
            System.err.println("Now at: (" + currentX + "," + (currentY - 1) + ").");
            route.add(new Point(currentX, currentY - 1));
            Maze(route, row, col, desX, desY, currentX, currentY - 1, canGo);
        }
        else{
            System.err.println("Fail to find a way at: (" + currentX + "," + currentY + ").");
            //return route;
        }
        return route;
    }
    public static void main(String[] args) {
        boolean[][] canGo = {{true,true,true},{false,true,true},{true,true,true}};
        int row = 3;
        int col = 3;
        int desX = 2;
        int desY = 0;
        int startX = 0;
        int startY = 1;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (canGo[i][j] == false){
                    System.out.print("W ");
                }
                else if ((i == startX) && (j == startY)){
                    System.out.print("S ");
                }
                else if ((i == desX) && (j == desY)){
                    System.out.print("E ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.err.println();
        }
        System.err.println("Start at: (" + startX + "," + startY + ").");
        ArrayList<Point> route = new ArrayList<>();
        route.add(new Point(startX, startY));
        route = Test.Maze(route, row, col, desX, desY, startX, startY, canGo);
        for(Point p: route){
            if ((p.x == desX) && (p.y == desY)){
                System.err.println(p);
                break;
            }
            System.err.print(p + "->");
        }
    }
}
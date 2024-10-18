public class Test{
    public static void Maze(int row, int col, int desX, int desY, int currentX, int currentY, boolean[][] canGo, boolean reach){
        if (reach){
            return;
        }
        if ((currentX == desX) && (currentY == desY)){
            System.err.println("Arrive at destination: (" + currentX + "," + currentY + ").");
            reach = true;
            return;
        }
        if (canGo[currentX][currentY] == false){
            System.err.println("You're at a wall/ you've visited here!");
            return;
        }
        else{
            canGo[currentX][currentY] = false;
            //  Go north
            if (((currentY + 1) < col) && ((canGo[currentX][currentY + 1] == true))){
                System.err.println("Now at: (" + currentX + "," + (currentY + 1) + ").");
                Maze(row, col, desX, desY, currentX, currentY + 1, canGo, reach);
            }
            // Go south
            if (((currentY - 1) >= 0) && ((canGo[currentX][currentY - 1] == true))){
                if ((currentY + 1) < col){
                    canGo[currentX][currentY + 1] = false;    
                }
                System.err.println("Now at: (" + currentX + "," + (currentY - 1) + ").");
                Maze(row, col, desX, desY, currentX, currentY - 1, canGo, reach);
            }
            // Go east
            if (((currentX + 1) < row) && (canGo[currentX + 1][currentY] == true)){
                if (((currentY - 1) >= 0)){
                    canGo[currentX][currentY - 1] = false;
                }
                System.err.println("Now at: (" + (currentX + 1)+ "," + currentY + ").");
                Maze(row, col, desX, desY,currentX + 1, currentY, canGo, reach);
            }
            // Go west
            if (((currentX - 1) >= 0) && (canGo[currentX - 1][currentY] == true)){
                if (((currentX + 1) < row)){
                    canGo[currentX + 1][currentY] = false;
                }
                System.err.println("Now at: (" + (currentX - 1)+ "," + currentY + ").");
                Maze(row, col, desX, desY, currentX - 1, currentY, canGo, reach);
            }
            // else{
            //     System.err.println("Fail to find a way!");
            //     return;
            // }
            System.err.println("Fail to find a way!");
            return;
        }
    }
    public static void main(String[] args) {
        boolean[][] canGo = {{true,true,true},{false,true,true},{true,true,true}};
        int desX = 2;
        int desY = 0;
        int startX = 0;
        int startY = 1;
        System.err.println("Start at: ("  + startX + "," + startY + ").");
        Test.Maze(3, 3, desX, desY, startX, startY, canGo,false);

    }
}
public class Test{
    public static boolean Maze(int row, int col, int desX, int desY, int currentX, int currentY, boolean[][] canGo, boolean reach){
        if ((currentX == desX) && (currentY == desY)){
            System.err.println("Arrive at destination.");
            reach = true;
            return reach;
        }
        if (canGo[currentX][currentY] == false){
            System.err.println("You're at a wall/ you've visited here!");
            return reach;
        }
        canGo[currentX][currentY] = false;
        //  Go north
        if (((currentX - 1) >= 0) && (canGo[currentX - 1][currentY] == true)){
            if(!reach){
                System.err.println("From: (" + currentX+ "," + currentY + ").");
                System.err.println("Now at: (" + (currentX - 1)+ "," + currentY + ").");
                reach = Maze(row, col, desX, desY, currentX - 1, currentY, canGo, reach);
            }
        }
        // Go south
        if (((currentX + 1) < row) && (canGo[currentX + 1][currentY] == true)){
            if(!reach){
                System.err.println("From: (" + currentX+ "," + currentY + ").");
                System.err.println("Now at: (" + (currentX + 1)+ "," + currentY + ").");
                reach = Maze(row, col, desX, desY,currentX + 1, currentY, canGo, reach);
            }
        }
        // Go east
        if (((currentY + 1) < col) && ((canGo[currentX][currentY + 1] == true))){
            if(!reach){
                System.err.println("From: (" + currentX+ "," + currentY + ").");
                System.err.println("Now at: (" + currentX + "," + (currentY + 1) + ").");
                reach = Maze(row, col, desX, desY, currentX, currentY + 1, canGo, reach);
            }
        }
        // Go west
        if (((currentY - 1) >= 0) && ((canGo[currentX][currentY - 1] == true))){
            if(!reach){
                System.err.println("From: (" + currentX+ "," + currentY + ").");
                System.err.println("Now at: (" + currentX + "," + (currentY - 1) + ").");
                reach = Maze(row, col, desX, desY, currentX, currentY - 1, canGo, reach);
            }
        }
        else{
            if (!reach){
                System.err.println("Fail to find a way at: (" + currentX + "," + currentY + ").");
            }
        }
        return reach;
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
        Test.Maze(row, col, desX, desY, startX, startY, canGo, false);
    }
}
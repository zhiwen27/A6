public class Test{
    public static void Maze(int row, int col, int desX, int desY, int currentX, int currentY, boolean[][] canGo){
        if ((currentX == desX) && (currentY == desY)){
            System.err.println("Arrive at destination: (" + currentX + "," + currentY + ").");
            return;
        }
        if (canGo[currentX][currentY] == false){
            System.err.println("You're at a wall/ you've visited here!");
            return;
        }
        else{
            canGo[currentX][currentY] = false;
            //  Go north
            if (((currentX - 1) >= 0) && (canGo[currentX - 1][currentY] == true)){
                System.err.println("Now at: (" + (currentX - 1)+ "," + currentY + ").");
                Maze(row, col, desX, desY, currentX - 1, currentY, canGo);
            }
            // Go south
            if (((currentX + 1) < row) && (canGo[currentX + 1][currentY] == true)){
                if (((currentX - 1) >= 0)){
                    canGo[currentX - 1][currentY] = false;
                }
                System.err.println("Now at: (" + (currentX + 1)+ "," + currentY + ").");
                Maze(row, col, desX, desY,currentX + 1, currentY, canGo);
            }
            // Go east
            if (((currentY + 1) < col) && ((canGo[currentX][currentY + 1] == true))){
                if ((currentX + 1) < row){
                    canGo[currentX + 1][currentY] = false;
                }
                System.err.println("Now at: (" + currentX + "," + (currentY + 1) + ").");
                Maze(row, col, desX, desY, currentX, currentY + 1, canGo);
            }
            // Go west
            if (((currentY - 1) >= 0) && ((canGo[currentX][currentY - 1] == true))){
                if ((currentY - 1) >= 0){
                    canGo[currentX][currentY - 1] = false;    
                }
                System.err.println("Now at: (" + currentX + "," + (currentY - 1) + ").");
                Maze(row, col, desX, desY, currentX, currentY - 1, canGo);
            }
            else{
                //System.err.println("Fail to find a way!");
                canGo[currentX][currentY] = true;
                return;
            }
        }
    }
    public static void main(String[] args) {
        boolean[][] canGo = {{true,true,true},{false,true,true},{true,true,true}};
        int row = 3;
        int col = 3;
        int desX = 2;
        int desY = 0;
        int startX = 0;
        int startY = 1;
        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                if (canGo[i][j] == false){
                    System.out.print("wall ");
                }
                else if ((i == startX) && (j == startY)){
                    System.out.print("start ");
                }
                else if ((i == desX) && (j == desY)){
                    System.out.print("end ");
                }
                else{
                    System.out.print("way ");
                }
            }
            System.err.println();
        }
        Test.Maze(row, col, desX, desY, startX, startY, canGo);

    }
}
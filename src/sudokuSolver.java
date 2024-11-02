
class sudokuSolver {
 public boolean isSafe(int [][]board ,int row,int col,int number) {
     for (int i = 0; i < board.length; i++) {
         //for ROW
         if (board[i][col] == number) { // cheaking in ROW agr no. k equal hojaye
             return false;
         }
         //for COL
         if (board[row][i] == number) {
             return false;   // cheaking for column
         }
     }
         //for GRID
         int sr = (row / 3) * 3;  // Rows 0, 1, and 2 will result in 0 / 3 = 0.
                                  //Rows 3, 4, and 5 will result in 3 / 3 = 1.
                                   //Rows 6, 7, and 8 will result in 6 / 3 = 2.
         int sc = (col / 3) * 3;    //starting column

         for (int k = sr; k < sr + 3; k++) {     // +3 is liye kia h taki vo apne aage 3 tk jaye
             for (int j = sc; j < sc + 3; j++) {
                 if (board[k][j] == number) {
                     return false;
                 }
             }
         }
         return true;
     }

     public boolean solveSudoku ( int[][] board, int row, int col){
         if (row == board.length) {
             return true;   //means pura board bhar chuka h
         }


         int nrow ;   //initializing next row
         int ncol ;
         // agr hum kisi b colmn pe h jo last colmn nhi h to aage bhadh jao
         if (col == board.length ) {
              return true;
         }
             nrow = row;
             ncol = col + 1;

         //agr last colm h to next row pe jao
         if (col == board.length-1) {
             nrow = row + 1;
             ncol = 0;
         }
         if(board[row][col] != 0) {
             return solveSudoku(board, nrow, ncol) ;

         } else {
             for (int i = 1; i <= 9; i++) {
                 if (isSafe(board, row, col, i)) {  //is safre function cheak kya hum is no ko baitha skte h
                     board[row][col] =i;  //agr safe tha to baitha dia
                     if (solveSudoku(board, nrow, ncol)) { // recursive call and is no baithane k baad ye fit hua ki nhi
                         return true;
                     } else {       // pr aage jake pta lga ye safe nhi h to vapis hta dia
                         board[row][col] = 0;

                     }
                 }
             }
         }
         return false;
     }
     public void display ( int[][] board, int n ){
         for (int i = 0; i < n; i++) {
             for (int d = 0; d < n; d++) {
                 System.out.print(board[i][d]+" ");
               //  System.out.print("\n");
             }
             System.out.println("  ");
             if ((i + 1) % (int) Math.sqrt(n) == 0) {

             }
         }
     }

     public static void main (String argvs[]){
         int[][] board = new int[][]{
                 {5, 3, 0, 0, 7, 0, 0, 0, 0},
                 {6, 0, 0, 1, 9, 5, 0, 0, 0},
                 {0, 9, 8, 0, 0, 0, 0, 6, 0},
                 {8, 0, 0, 0, 6, 0, 0, 0, 3},
                 {4, 0, 0, 8, 0, 3, 0, 0, 1},
                 {7, 0, 0, 0, 2, 0, 0, 0, 6},
                 {0, 6, 0, 0, 0, 0, 2, 8, 0},
                 {0, 0, 0, 4, 1, 9, 0, 0, 5},
                 {0, 0, 0, 0, 8, 0, 0, 7, 9}
         };


         sudokuSolver obj = new sudokuSolver();

         // computing the size of the grid
         int size = board.length;

         System.out.println("The grid is: ");
         for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board.length; j++) {
                 System.out.print(board[i][j] + " ");
             }

             System.out.println();
         }
         System.out.println();
         if (obj.solveSudoku(board, 0,0)) {
// display solution

             System.out.println("The solution of the grid is: ");
             obj.display(board, board.length);
         } else {
             System.out.println("There is no solution available.");
         }
     }
 }


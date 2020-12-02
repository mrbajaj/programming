import java.util.Arrays;

/**
 * 
 */
class Problem79{

    public static void main(String[] args) {
        Problem79 obj = new Problem79();

        char[][] board = new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        // System.out.println("Ans: " + obj.exist(board, "ABCCED") + "\n");

        System.out.println("Ans: " + obj.exist(board, "SEE") + "\n");

        // System.out.println("Ans: " + obj.exist(board, "ABCB") + "\n");

    }

    public boolean exist(char[][] board, String word) {
        for(int row=0; row < board.length; row++){
            for(int column=0; column < board[row].length; column++){
                if(existRecursive(board, 0, row, column, word) == true){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existRecursive(char[][] board, int index, int row, int column, String word) {
        if (index == word.length()){
            // found in previous call
            return true;
        }
        
        // All fail cases
        if (row < 0 || row >= board.length || 
            column < 0 || column >= board[row].length || 
            board[row][column] != word.charAt(index)) {
            return false;
        }

        char tmp = board[row][column];
        board[row][column] = ' ';

        boolean found = existRecursive(board, index + 1, row -1, column, word) || 
                existRecursive(board, index + 1, row + 1, column, word) || 
                existRecursive(board, index + 1, row , column-1, word) || 
                existRecursive(board, index + 1, row , column+1, word);

        // this.print2DArray(board);

        board[row][column] = tmp;

        return found;
    }

    public void print2DArray(char[][] board){
        for(int row=0; row < board.length; row++){
            System.out.println(Arrays.toString(board[row]));
        }
        System.out.println();
    }
}
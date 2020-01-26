class Problem832{

    public static void main(String[] args) {

        Problem832 obj = new Problem832();

        int[][] grid = new int[][]{{1,1,0},{1,0,1},{0,0,0},};
        int[][] fliped = obj.flipAndInvertImage(grid);
        obj.printMatrix(grid); System.out.println();
        obj.printMatrix(fliped);
        System.out.println("------------------------");

        int[][] grid2 = new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0},};
        int[][] fliped2 = obj.flipAndInvertImage(grid2);
        obj.printMatrix(grid2); System.out.println();
        obj.printMatrix(fliped2);
        
    }


    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        for(int i =0; i<m; i++){
            A[i] = this.reverse(A[i]);
        }

        for(int i =0; i<m; i++){
            for(int j = 0; j< n; j++){
                A[i][j] = (A[i][j] == 1) ? 0 : 1;
            }
        }
        return A;
        
    }

    public int[][] flipAndInvertImage_better(int[][] A) {
        int n = A[0].length;

        for(int i =0; i<A.length; i++){
            A[i] = this.reverse(A[i]);
            for(int j = 0; j< n; j++){
                A[i][j] = (A[i][j] == 1) ? 0 : 1;
            }
        }

        
        return A;
        
    }

    public int[] reverse(int[] row){
        
        int i = 0;
        int j = row.length -1;
        while(i <= j){
            int tmp = row[i];
            row[i] = row[j];
            row[j] = tmp;
            i++;
            j--;
        }

        return row;
    }

    public void printMatrix(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        for(int i =0; i<m; i++){
            for(int j = 0; j< n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
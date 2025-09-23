public class Table {
    private int[][] data;
    private int row;
    private int col;

    public Table(int row, int col){
        this.row = row;
        this.col = col;
        data = new int[row][col];
    }

    public int getValue(int row, int col){
        return data[row][col];
    }

    public void SetValue(int row, int col, int value){
        data[row][col] = value;
    }

    public int rows(){
        return row;
    }

    public int cols(){
        return col;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                str += data[i][j];
                if (j < col - 1){
                    str += " ";
                }
            }
            if (i < row - 1){
                str += "\n";
            }
        }
        return str;
    }

    public double average() {
        int sum = 0;
        int count = row * col;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += data[i][j];
            }
        }

        return (double) sum / count;
    }

}

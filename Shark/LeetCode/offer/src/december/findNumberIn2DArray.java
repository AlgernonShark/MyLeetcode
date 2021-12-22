package december;

public class findNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // matrix[i][j]初始位置：左下角。
        // matrix[i][j]的特点：比同一列的上面大，比同一行的右边小
        // i往上，j往右搜索
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
        }
}

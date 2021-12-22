package december;

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[]{};

        // 行数和列数
        int m = matrix.length, n = matrix[0].length;
        // 初始化遍历数组及其索引
        int[] order = new int[m * n];
        int index = 0;
        // 确定上下左右的遍历边界
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;

        // up -> right -> down -> left边界顺序进行遍历
        while(true){
            // left边界->right边界
            for (int i = left; i <= right; i++){
                // 加入遍历数组，并更新index
                order[index++] = matrix[up][i];
            }
            // up边界下移，如果越界则说明遍历结束
            if(++up > down) break;


            for (int i = up; i <= down; i++){
                order[index++] = matrix[i][right];
            }
            if(--right < left) break;

            for (int i = right; i >= left; i--){
                order[index++] = matrix[down][i];
            }
            if(--down < up) break;

            for (int i = down; i >= up; i--){
                order[index++] = matrix[i][left];
            }
            if(++left > right) break;
        }
        return order;
    }
}

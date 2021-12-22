package december;

import org.junit.Test;

public class GetLeastNumbers40 {

    @Test
    public void test(){
        int[] arr = new int[]{0,0,1,2,4,2,2,3,1,4};
        int k = 8;

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        quick_sort(arr,0,arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0){
            return new int[0];
        }
        int[] ans = new int[k];

        quick_sort(arr,0, arr.length - 1);

        int i = 0;
        while (i < k){
            ans[i++] = arr[i++];
        }

        return ans;
    }

    public void quick_sort(int[] q, int l, int r)
    {
        if (l >= r) return;

        int i = l - 1, j = r + 1, x = q[l + r >> 1];
        while (i < j)
        {
            do i ++ ; while (q[i] < x);
            do j -- ; while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q,j + 1, r);
    }

}

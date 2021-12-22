package december;

/*
 * 这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n))，看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。
 * 那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。
 * 这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定，因此需要分情况来讨论.
 * 对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。
 * 为了简化代码，不分情况讨论，我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。
 * 加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
 *
 * 这里我们需要定义一个函数来在两个有序数组中找到第K个元素，下面重点来看如何实现找到第K个元素。
 * 首先，为了避免产生新的数组从而增加时间复杂度，我们使用两个变量i和j分别来标记数组nums1和nums2的起始位置。
 *
 * 然后来处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，
 * 还有就是如果K=1的话，那么我们只要比较nums1和nums2的起始位置i和j上的数字就可以了。
 *
 * 难点就在于一般的情况怎么处理？因为我们需要在两个有序数组中找到第K个元素。
 * 为了加快搜索的速度，我们要使用二分法，对K二分，意思是我们需要分别在nums1和nums2中查找第K/2个元素。
 * 注意这里由于两个数组的长度不定，所以有可能某个数组没有第K/2个数字，所以我们需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，否则就赋值上一个整型最大值。
 * 如果某个数组没有第K/2个数字，那么我们就淘汰另一个数字的前K/2个数字即可。
 * 有没有可能两个数组都不存在第K/2个数字呢，这道题里是不可能的，因为我们的K不是任意给的，而是给的m+n的中间值，所以必定至少会有一个数组是存在第K/2个数字的。
 *
 * 最后就是二分法的核心啦，比较这两个数组的第K/2小的数字midVal1和midVal2的大小。
 * 如果第一个数组的第K/2个数字小的话，那么说明我们要找的数字肯定不在nums1中的前K/2个数字，所以我们可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。
 * 反之，我们淘汰nums2中的前K/2个数字，并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归即可。
 *
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //小trick:对于奇数来说，以下两个值是相等的~
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        //这里是每递归一次就有一个数组的前k/2个数被淘汰
        //一旦某个数组完全被淘汰，其起始位置i已经到达或越界该数组末位元素
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组

        //递归结束条件：k == 1，直接返回起始位置的元素
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }

        //检查是否越界，越界了就赋值Integer的最大值
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        /*
         * 赋予最大值的意思只是说如果一个数组的K/2不存在，则说明这个数组的长度小于K/2，那么另外一个数组的前K/2个我们是肯定会淘汰的。
         * 即使有极端情况，该数组合并入另一个较长数组后，全都在第K个元素左边，仍然有length + K/2 < K ，说明这K/2个元素必定不是中位数，故应该被淘汰。
         * 举个例子，加入第一个数组长度是2，第二个数组长度是12，则K为7，K/2为3，因为第一个数组长度小于3，则无法判断中位数是否在其中，而第二个数组的前3个肯定不是中位数！
         * 故当K/2不存在时，将其置为整数型最大值，这样就可以继续下一次循环。
         */


        //淘汰较小的中值及其左边的元素——总共k / 2个元素
        //为什么淘汰较小的中值？因为小于该中值的元素至多只有自身所在数组k / 2 + 另一个数组（ k / 2 - 1）个元素，显然不满足k个元素
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }
    }
}

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        // 中位数：假如两个数组的总长度为int len
        // 对len是偶数来说，为第len / 2 & len / 2 + 1个元素的均值 -> (len + 1) / 2 & (len + 2) / 2
        // 对len是奇数来说，为第len / 2 + 1个元素 -> 两个len / 2 + 1个元素的均值 -> (len + 1) / 2 & (len + 2) / 2
        // 因此可以总结为同一问题--求第(len + 1) / 2 & (len + 2) / 2个元素的均值

        if (nums1.length == 0 && nums2.length == 0) return 0;

        int len = nums1.length + nums2.length;
        //第left = (len + 1) / 2个数和第right = (len + 2) / 2个数
        int left = (len + 1) / 2, right = (len + 2) / 2;

        //求均值
        return (findKth(nums1,nums2,0,0,left) + findKth(nums1,nums2,0,0,right)) / 2.0;
    }

    public int findKth(int nums1[], int nums2[], int start1, int start2, int k){
        // 如果某个数组为空或者已经被全部淘汰，则直接在另一个数组中寻找相应的k值
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];

        // 递归结束条件：k == 1
        if (k == 1) return Math.min(nums1[start1],nums2[start2]);

        // 在两个数组中分别找第k/2大的数 -> 下标为start + k / 2 - 1
        // 如果下标越界，则赋值最大值 -> 说明另一个数组的前k / 2个数应该全被淘汰
        int midVal1 = (start1 + k / 2 - 1 < nums1.length) ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (start2 + k / 2 - 1 < nums2.length) ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        /*
         * 赋予最大值的意思只是说如果一个数组的K/2不存在，则说明这个数组的长度小于K/2，那么另外一个数组的前K/2个我们是肯定会淘汰的。
         * 即使有极端情况，该数组合并入另一个较长数组后，全都在第K个元素左边，仍然有length + K/2 < K ，说明这K/2个元素必定不是中位数，故应该被淘汰。
         * 举个例子，加入第一个数组长度是2，第二个数组长度是12，则K为7，K/2为3，因为第一个数组长度小于3，则无法判断中位数是否在其中，而第二个数组的前3个肯定不是中位数！
         * 故当K/2不存在时，将其置为整数型最大值，这样就可以继续下一次循环。
         */

        //淘汰较小的中值所在数组的前k / 2个数
        if (midVal1 < midVal2) {
            return findKth(nums1, nums2, start1 + k / 2, start2, k - k / 2);
        }
        else return findKth(nums1, nums2, start1, start2 + k/2, k - k / 2);

    }

}

//归并排序的时间复杂度不符合要求！
class Find{
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if (nums1.length == 0 && nums2.length == 0) return 0;

        int length = nums1.length + nums2.length;

        return (findKth(nums1, nums2, 0, 0, (length + 1) / 2) + findKth(nums1, nums2, 0, 0, (length + 2)/ 2) )/ 2.0;

    }

    public int findKth(int[] nums1, int[] nums2, int start1, int start2, int k){
        if (start1 > nums1.length - 1) return nums2[start2 + k - 1];
        if (start2 > nums2.length - 1) return nums1[start1 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int midVal1 = start1 + k / 2 - 1 > nums1.length - 1 ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
        int midVal2 = start2 + k / 2 - 1 > nums2.length - 1 ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];

        if (midVal1 < midVal2) return findKth(nums1, nums2, start1 + k / 2, start2, k - k / 2);
        else return findKth(nums1, nums2, start1, start2 + k / 2, k - k / 2);
    }

}
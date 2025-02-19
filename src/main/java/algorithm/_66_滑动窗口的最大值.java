package algorithm;

/*
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。



 */
public class _66_滑动窗口的最大值 {
    public  int[] maxSlidingWindow(int[] nums,int k){
//        int winArr=new int(nums.length-k+1);
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int []winArr=new int[nums.length-k+1];
        for (int i = 0; i <winArr.length ; i++) {
            int max= Integer.MIN_VALUE;
            for (int j = i; j <i+k ; j++) {
//            for (int j = 0; j <k ; j++) {
                max=Math.max(max,nums[j]);
            }
            winArr[i]=max;
        }
        return winArr;
    }




    public  int[] maxSlidingWindow2(int[] nums,int k){
//        int winArr=new int(nums.length-k+1);
        if(nums==null || nums.length==0){
            return new int[0];
        }
        int []winArr=new int[nums.length-k+1];
        for (int i = 0; i <winArr.length ; i++) {
            int max= Integer.MIN_VALUE;
            for (int j = 0; j < k ; j++) {
//            for (int j  0; j <k ; j++) {
                max=Math.max(max,nums[i+j]);
            }
            winArr[i]=max;
        }
        return winArr;
    }



}

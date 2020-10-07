package algorithm;


import java.util.ArrayList;

/*
1.和为S的连续正数序列

2.
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

3.
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

剖析： 有一个数学问题 给n个连续的数，求他们的sum
示例  2 3 4 5  那么他们的sum是多少呢 14=(5+2)*(5-2+1)/2=(7*4)/2
 */
public class _41_和为S的连续整数序列 {

    public static void main(String[] args) {
        /* 是连续正数序列
        [
            [9, 10, 11, 12, 13, 14, 15, 16], [18, 19, 20, 21, 22]
        ]
         */
        System.out.println(FindContinuousSequence(15));
    }
    /*
    方法论
    两个指针 plow phigh 当满足plow < phigh 一直跑
    比较当前求和cur 和 要求sum的大小
    == 把序列取出 plow++
    < phigh++ 为了得打更大的phigh，从而得到更大的cur
    > plow ++

    拓展
    如果是连续整数序列求乘积也是这个思路
    tcp滑动窗口
    两个窗口都是从左边出发，不是两边夹逼。
    双指针技术，就是相当于有一个窗口，窗口的左右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。
    非常牛逼的思路，虽然双指针或者所谓的滑动窗口技巧还是蛮常见的，但是这一题还真想不到这个思路。
     */
    //  tcp滑动窗口的思想  滑动窗口就保证了high的最大值不会越过（sum+1）/2的值。
    // 举例 可以拿 1 2 3 4 5 6 7 8 9  求和得到 15 来计算
    //  _41_和为S的连续整数序列
    public  static  ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 0,phigh = 1;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下,为了得打更大的phigh，从而得到更大的cur
            }else if(cur < sum){
                phigh++;
            }else{      // 其实就是 cur > sum
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下；为了得打更小的plow，从而得到更大的cur
                plow++;
            }
        }
        return result;
    }

}

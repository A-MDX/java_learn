package com.m2018.july;

import org.junit.Test;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 *
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *
 * 如果是，则返回最大元素的索引，否则返回-1。
 *
 * 示例 1:
 *
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 * 示例 2:
 *
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 * 提示:
 *
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 * Create by dxma at 2018-07-12 17:28
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/description/
 * 找最大，两倍大的，
 */
public class July12 {
    public int dominantIndex(int[] nums) {
        int length = nums.length;
        if (length == 0){
            return -1;
        }
        int max = nums[0];
        
        int secondMax = 0;
        int maxIndex = 0;
        
        for (int i = 1; i < nums.length; i++) {
            int now = nums[i];
            if (now > max){
                secondMax = max;
                max = now;
                maxIndex = i;
            }else if(secondMax < now){
                secondMax = now;
            }
        }
        
        if (secondMax != 0){
            if (max / secondMax >= 2){
                return maxIndex;
            }
            
        }else {
            if (max > 0){
                return maxIndex;
            }
        }
        return -1;
    }
    
    @Test
    public void test1(){
        int[] arr = {0,1};
        System.out.println(dominantIndex(arr));

    }
    
}


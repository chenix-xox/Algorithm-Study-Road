package leetcode;

/**
 * @author Chenix
 * @create_date 2024/4/13 23:30
 * @description
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class Hot100_5_盛最多水的容器 {
    public int maxArea(int[] height) {
        // 左右指针
        int left = 0, right = height.length - 1;
        int res = 0;
        int nowArea = 0;
        // 只要左右指针没贴在一起，就一直移动
        while (left < right) {
            // 取出小的那一边，作为高
            int minBorder = Math.min(height[left], height[right]);
            // 取左右的差值（宽度）
            int leftToRight = right - left;
            nowArea = minBorder * leftToRight;
            // 和已有的res比较，取最大值
            res = Math.max(nowArea, res);
            // 那边矮，移哪边
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Hot100_5_盛最多水的容器 h5 = new Hot100_5_盛最多水的容器();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(h5.maxArea(height));
    }
}

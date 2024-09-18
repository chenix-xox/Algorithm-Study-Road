package leetcode;

import model.TreeNode;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenix
 * @date 2024.08.29 00:14
 * @description 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * ------------------
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * ------------------
 * 输入：root = [1]
 * 输出：[1]
 */
public class Hot_100_94_二叉树的中序遍历 {

    public List<Integer> inorderTraversal_dsf(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 先把左边的全部加进来，再把其根节点也加进来，再加上其右节点
        // 前序：add current、enter left、enter right
        // 中序：enter left、add current、enter right
        // 后序：enter left、enter right、add current
        result.addAll(inorderTraversal(root.getLeft()));
        result.add(root.getVal());
        result.addAll(inorderTraversal(root.getRight()));
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            result.add(root.getVal());
            root = root.getRight();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Hot_100_94_二叉树的中序遍历()
                .inorderTraversal(new TreeNode(1,
                        null,
                        new TreeNode(2,
                                new TreeNode(3,
                                        null,
                                        null),
                                null)))));
    }
}

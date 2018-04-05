/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题32：之字形打印二叉树
 * // 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照
 * // 从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
package com.mousezhang.code;
import java.util.ArrayList;
import java.util.LinkedList;

public class Java32_03_ZigzagPrintTree {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (pRoot == null) {
			return result;
        }
		ArrayList<Integer> temp = new ArrayList<>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(pRoot);
		TreeNode node = null;
		TreeNode last = pRoot;
		TreeNode nlast = last;
		while (!queue.isEmpty()) {
			node = queue.poll();
			temp.add(node.val);
			if (node.left != null) {
			    queue.offer(node.left);
			    nlast = node.left;
			}
			if (node.right != null) {
			    queue.offer(node.right);
			    nlast = node.right;
			}
			if (node == last) {
				result.add(temp);
			    temp = new ArrayList<Integer>();
			    last = nlast;
			}
        }
		return result;
    }
}
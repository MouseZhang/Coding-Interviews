/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题32：分行从上往下打印二叉树
 * // 题目：从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
package com.mousezhang.code;
import java.util.ArrayList;
import java.util.LinkedList;

public class Java32_02_BranchPrintTree {
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
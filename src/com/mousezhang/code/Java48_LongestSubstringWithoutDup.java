/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题48：最长不含重复字符的子字符串
 * // 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
 * // 字符串的长度。假设字符串中只包含从'a'~'z'的字符。例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串
 * // 是"acfr"，长度为4。
 */
package com.mousezhang.code;
import java.util.ArrayList;

public class Java48_LongestSubstringWithoutDup {
	/** 其核心思想是：每一个丑数必然是由之前的某个丑数与2，3或5的乘积得到的，这样下一个丑数就用之前的
	丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，即为下一个要求的丑数。 */
	public int GetUglyNumber_Solution(int index) {
		if(index == 0) {
		    return 0;
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int i2 = 0, i3 = 0, i5 = 0;
		while(result.size() < index) {
		    int m2 = result.get(i2) * 2;
		    int m3 = result.get(i3) * 3;
		    int m5 = result.get(i5) * 5;
		    int min = Math.min(m2, Math.min(m3, m5));
		    result.add(min);
		    if(min == m2) {
		        i2++;
		    }
		    if(min == m3) {
		        i3++;
		    }
		    if(min == m5) {
		        i5++;
		    }
		}
		return result.get(result.size() - 1);
	}
}
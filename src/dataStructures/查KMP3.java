package dataStructures;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*

这里将大多数例题中的模式串换成常见的从0开始

 */
public class 查KMP3 {
	public static void main(String[] args) {
		final String patternString = "abaabcac", targetString = "abaaaabaabcacabaabaabcac";
//		final String patternString = "abaabcac", targetString = "abaabcac";
//		final String patternString = "aaaaa", targetString = "aaaaaaa";
		final char[] patternChar = patternString.toCharArray(), targetChar = targetString.toCharArray();
		int[] next = getNext(patternChar);
		final int patternLength = next.length, targetLength = targetString.length();
		List<Integer> answerList = new ArrayList<Integer>();
		int patternIndex = 0, targetIndex = 0;
		while (targetIndex < targetLength) {
			if (patternIndex == -1 || patternChar[patternIndex] == targetChar[targetIndex]) {
				targetIndex ++;	patternIndex ++;
			} else {
				patternIndex = next[patternIndex];
			}
			if (patternIndex == patternLength) {
				answerList.add(targetIndex - patternLength);
				patternIndex = -1;
				targetIndex -= patternLength;
			}
		}
		tools.IOUtils.print(answerList.listIterator());
	}
	static int[] getNext (char[] charArray) {
		final int len = charArray.length;
		int[] next = new int[len];
		next[0] = -1;
		int i = 0, j = -1;
		while (i < len - 1) {
			if (-1 == j || charArray[i] == charArray[j]) {
				i ++; j++;
				next[i] = j;
			} else
				j = next[j];
		}
		return next;
	}
	
	@Test
	public void test2 () {
//		final String patternString = "abaabcac", targetString = "abaaaabaabcacabaabaabcac";
//		final String patternString = "abaabcac", targetString = "abaabcac";
		final String patternString = "aaaaa", targetString = "aaaaaaa";
		final char[] patternChar = patternString.toCharArray(), targetChar = targetString.toCharArray();
		final int patternLength = patternChar.length, targetLength = targetChar.length;
		int[] next = getNext2 (patternChar);
		int patternIndex = 0, targetIndex = 0;
		List<Integer> answerList = new ArrayList<Integer>();
		while (targetIndex < targetLength) {
			if (-1 == patternIndex || patternChar[patternIndex] == targetChar[targetIndex]) {
				patternIndex ++;   targetIndex ++;
			} else 
				patternIndex = next[patternIndex];
			if (patternIndex == patternLength) {
				answerList.add(targetIndex - patternLength);
				targetIndex -= patternLength;
				patternIndex = -1;
			}
		}
		tools.IOUtils.print(answerList.iterator());
	}
	public int[] getNext2 (char[] targetChar) {
		final int targetLength = targetChar.length;
		int[] next = new int[targetLength];
		next[0] = -1;
		int preIndex = 0, posIndex = -1;
		while (preIndex < targetLength - 1) {
			if (posIndex == -1 || targetChar[preIndex] == targetChar[posIndex]) {
				preIndex ++;   posIndex ++;
				next[preIndex] = posIndex;
			} else 
				posIndex = next[posIndex];
		}
		return next;
	}
	
	@Test
	public void test3 () {
//		final String patternString = "abaabcac", targetString = "abaaaabaabcacabaabaabcac";
//		final String patternString = "abaabcac", targetString = "abaabcac";
		final String patternString = "aaaaa", targetString = "aaaaaaa";
		final char[] patternChar = patternString.toCharArray(), targetChar = targetString.toCharArray();
		final int patternLength = patternChar.length, targetLength = targetChar.length;
		int[] next = getNext3(patternChar);
		int patternIndex = 0, targetIndex = 0;
		List<Integer> answerList = new ArrayList<Integer>();
		while (targetIndex < targetLength) {
			if (patternIndex == -1 || patternChar[patternIndex] == targetChar[targetIndex]) {
				patternIndex ++;   targetIndex ++;
			} else 
				patternIndex = next[patternIndex];
			if (patternIndex == patternLength) {
				answerList.add(targetIndex - patternLength);
				targetIndex -= patternLength - 1;
				patternIndex = 0;
			}
		}
		tools.IOUtils.print(answerList.iterator());
	}
	public int[] getNext3 (char[] patternChar) {
		final int patternLength = patternChar.length;
		int[] next = new int[patternLength];
		next[0] = -1;
		int preIndex = 0, posIndex = -1;
		while (preIndex < patternLength - 1) {
			if (-1 == posIndex || patternChar[preIndex] == patternChar[posIndex]) {
				posIndex ++;   preIndex ++;
				next[preIndex] = posIndex;
			} else 
				posIndex = next[posIndex];
		}
		return next;
	}
	
	@Test
	public void test5 () {
//		final String patternString = "abaabcac", targetString = "abaaaabaabcacabaabaabcac";
//		final String patternString = "abaabcac", targetString = "abaabcac";
		final String patternString = "aaaaa", targetString = "aaaaaaa";
		final char[] patternChar = patternString.toCharArray(), targetChar = targetString.toCharArray();
		final int patternLength = patternChar.length, targetLength = targetChar.length;
		int[] next = getNext5(patternChar);
		int patternIndex = 0, targetIndex = 0;
		List<Integer> answerList = new ArrayList<Integer> ();
		while (targetIndex < targetLength) {
			if (patternIndex == -1 || patternChar[patternIndex] == targetChar[targetIndex]) {
				patternIndex ++;   targetIndex ++;
			} else {
				patternIndex = next[patternIndex];
			}
			if (patternIndex == patternLength) {
				answerList.add(targetIndex - patternLength);
				targetIndex -= patternLength - 1;
				patternIndex = 0;
			}
		}
		tools.IOUtils.print(answerList.iterator());
	}
	public int[] getNext5 (char[] patternChar) {
		final int patternLength = patternChar.length;
		int[] next = new int [patternLength];
		next[0] = -1;
		int preIndex = 0, posIndex = -1;
		while (preIndex < patternLength - 1) {
			if (-1 == posIndex || patternChar[preIndex] == patternChar[posIndex]) {
				preIndex ++;  posIndex ++;
				next[preIndex] = posIndex;
			} else {
				posIndex = next[posIndex];
			}
		}
		return next;
	}
	
	@Test
	public void test6 () {
		final String patternString = "abaabcac", targetString = "abaaaabaabcacabaabaabcac";
//		final String patternString = "abaabcac", targetString = "abaabcac";
//		final String patternString = "aaaaa", targetString = "aaaaaaa";
		final char[] patternChar = patternString.toCharArray(), targetChar = targetString.toCharArray();
		final int patternLength = patternChar.length, targetLength = targetChar.length;
		final int[] next = getNext6 (patternChar);
		int patternIndex = 0, targetIndex = 0;
		List<Integer> answerList = new ArrayList<Integer> ();
		while (targetIndex < targetLength) {
			if (-1 == patternIndex || patternChar[patternIndex] == targetChar[targetIndex]) {
				patternIndex ++;   targetIndex ++;
			} else {
				patternIndex = next[patternIndex];
			}
			if (patternIndex == patternLength) {
				answerList.add(targetIndex - patternLength);
				targetIndex -= patternLength - 1;
				patternIndex = 0;
			}
		}
		tools.IOUtils.print(answerList.iterator());
	}
	public int[] getNext6 (char[] patternChar) {
		final int patternLength = patternChar.length;
		int[] next = new int[patternLength];
		next[0] = -1;
		int preIndex = 0, posIndex = -1;
		while (preIndex < patternLength - 1) {
			if (-1 == posIndex || patternChar[preIndex] == patternChar[posIndex]) {
				posIndex ++;   preIndex ++;
				next[preIndex] = posIndex;
			} else {
				posIndex = next[posIndex];
			}
		}
		return next;
	}
	
	@Test
	public void test8 () {
		final String patternString = "abaabcac", targetString = "abaaaabaabcacabaabaabcac";
//		final String patternString = "abaabcac", targetString = "abaabcac";
//		final String patternString = "aaaaa", targetString = "aaaaaaa";
		final char[] patternChar = patternString.toCharArray(), targetChar = targetString.toCharArray();
		final int patternLength = patternChar.length, targetLength = targetChar.length;
		final int[] next = getNext8 (patternChar);
		int patternIndex = 0, targetIndex = 0;
		List<Integer> answerList = new ArrayList<Integer>();
		while (targetIndex < targetLength) {
			if (-1 == patternIndex || patternChar[patternIndex] == targetChar[targetIndex]) {
				patternIndex ++;   targetIndex ++;
			} else {
				patternIndex = next[patternIndex];
			}
			if (patternIndex == patternLength) {
				answerList.add(targetIndex - patternLength);
				patternIndex = 0;
				targetIndex -= patternLength - 1;
			}
		}
		tools.IOUtils.print(answerList.iterator());
	}
	public int[] getNext8 (char[] patternChar) {
		final int patternLength = patternChar.length;
		int[] next = new int[patternLength];
		next[0] = -1;
		int preIndex = 0, posIndex = -1;
		while (preIndex < patternLength - 1) {
			if (-1 == posIndex || patternChar[preIndex] == patternChar[posIndex]) {
				preIndex ++;   posIndex ++;
				next[preIndex] = posIndex;
			} else {
				posIndex = next[posIndex];
			}
		}
		return next;
	}
}
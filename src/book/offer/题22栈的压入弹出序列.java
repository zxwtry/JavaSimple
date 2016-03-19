package book.offer;

public class 题22栈的压入弹出序列 {
	public static void main(String[] args) {
//		int[] pushArray = {1,2,3,4}, popArray = {1,2,3,4};
//		int[] pushArray = {1,2,3,4}, popArray = {4,3,2,1};
//		int[] pushArray = {1,2,3,4}, popArray = {2,1,3,4};
//		int[] pushArray = {1,2,3,4}, popArray = {4,3,1,2};
//		int[] pushArray = {1,2,3,4}, popArray = {4};
		int[] pushArray = {1,2,3,4}, popArray = {1,2,4};
		System.out.println(isPopOrder(pushArray, popArray));
		System.out.println(isPopOrder2(pushArray, popArray));
		System.out.println(isPopOrder3(pushArray, popArray));
		System.out.println(isPopOrder4(pushArray, popArray));
		System.out.println(isPopOrder5(pushArray, popArray));
		System.out.println(isPopOrder6(pushArray, popArray));
	}
	private static boolean isPopOrder (int[] pushArray, int[] popArray) {
		if (pushArray == null || popArray == null)
			return false;
		boolean isSuccess = false;
		int pushNext = 0, popNext = 0;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		while (popNext < popArray.length) {
			while (stk.isEmpty() || stk.peek() != popArray[popNext]) {
				if (pushNext == popArray.length)
					break;
				stk.push(pushArray[pushNext]);
				pushNext ++;
			}
			if (stk.peek() != popArray[popNext])
				break;
			stk.pop();
			popNext ++;
		}
		if (stk.isEmpty() || popNext == popArray.length) {
			isSuccess = true;
		}
		return isSuccess;
	}
	private static boolean isPopOrder2 (int[] pushArray, int[] popArray) {
		if (pushArray == null || popArray == null)
			return false;
		boolean isSuccess = false;
		int pushIndex = 0, popIndex = 0;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		while (popIndex < popArray.length) {
			while (stk.isEmpty() || stk.peek() != popArray[popIndex]) {
				if (pushIndex == popArray.length)
					break;
				stk.push(pushArray[pushIndex]);
				pushIndex ++;
			}
			if (stk.isEmpty() || stk.peek() != popArray[popIndex]) {
				break;
			} else {
				stk.pop();
				popIndex ++;
			}
		}
		if (stk.isEmpty() || popIndex == popArray.length) {
			isSuccess = true;
		}
		return isSuccess;
	}
	private static boolean isPopOrder3 (int[] pushArray, int[] popArray) {
		if (pushArray == null || popArray == null)
			return false;
		boolean isSuccess = false;
		int pushIndex = 0, popIndex = 0;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		while (popIndex < popArray.length) {
			while (stk.isEmpty() || stk.peek() != popArray[popIndex]) {
				if (pushIndex == popArray.length)
					break;
				else
					stk.push(pushArray[pushIndex++]);
			}
			if (stk.isEmpty() || stk.peek() != popArray[popIndex])
				break;
			else {
				stk.pop();
				popIndex ++;
			}
		}
		if (stk.isEmpty() || popIndex == popArray.length)
			isSuccess = true;
		return isSuccess;
	}
	private static boolean isPopOrder4 (int[] pushArray, int[] popArray) {
		if (pushArray == null || popArray == null)
			return false;
		int pushIndex = 0, popIndex = 0;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		while (popIndex < popArray.length) {
			while (stk.isEmpty() || stk.peek() != popArray[popIndex]) {
				if (pushIndex == popArray.length)
					break;
				else
					stk.push(pushArray[pushIndex++]);
			}
			if (stk.isEmpty() || stk.peek() != popArray[popIndex])
				break;
			else {
				stk.pop();
				popIndex ++;
			}
		}
		if (stk.isEmpty() || popIndex == popArray.length)
			return true;
		else return false;
	}
	private static boolean isPopOrder5 (int[] pushArray, int[] popArray) {
		if (pushArray == null || popArray == null)
			return false;
		int pushIndex = 0, popIndex = 0;
		java.util.Stack<Integer>stk = new java.util.Stack<Integer>();
		while (popIndex < popArray.length) {
			while (stk.isEmpty() || stk.peek() != popArray[popIndex]) {
				if (pushIndex == pushArray.length)
					break;
				else
					stk.push(pushArray[pushIndex++]);
			}
			if (stk.isEmpty() || stk.peek() != popArray[popIndex])
				break;
			else {
				stk.pop();
				popIndex ++;
			}
		}
		if (stk.isEmpty() || popIndex == popArray.length) 
			return true;
		else 
			return false;
	}
	private static boolean isPopOrder6 (int[] pushArray, int[] popArray) {
		if (pushArray == null || popArray == null)
			return false;
		int pushIndex = 0, popIndex = 0;
		java.util.Stack<Integer> stk = new java.util.Stack<Integer>();
		while (popIndex < popArray.length) {
			while (stk.isEmpty() || stk.peek() != popArray[popIndex]) {
				if (pushIndex == pushArray.length)
					break;
				else 
					stk.push(pushArray[pushIndex++]);
			}
			if (stk.isEmpty() || stk.peek() != popArray[popIndex])
				break;
			else {
				stk.pop();
				popIndex ++;
			}
		}
		if (stk.isEmpty() || popIndex == popArray.length)
			return true;
		else return false;
	}
}











































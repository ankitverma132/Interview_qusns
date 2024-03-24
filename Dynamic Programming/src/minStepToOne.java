/*Given a positive integer 'n', find and return the minimum number of steps 
that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ). */

public class minStepToOne {
	public static int countStepsTo1(int n) {

		if (n == 1) {
			return 0;
		}
		if (n == 2 || n == 3) {
			return 1;
		}

		int count1 = countStepsTo1(n - 1);
		int count2 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			count2 = countStepsTo1(n / 2);
		}
		int count3 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			count3 = countStepsTo1(n / 3);
		}
		return 1 + Math.min(count1, Math.min(count2, count3));

	}

	// Using Memoization
	public static int countStepsTo1M(int n) {
		int storage[] = new int[n + 1];
		// by default entries are 0
		return countStepsTo1M(n, storage);
	}

	private static int countStepsTo1M(int n, int[] storage) {

		if (n == 1) {
			storage[n] = 0;
			return storage[n];
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		int op1 = countStepsTo1M(n - 1, storage);
		int minSteps = op1;
		if (n % 3 == 0) {
			int op2 = countStepsTo1M(n / 3, storage);
			if (op2 < minSteps) {
				minSteps = op2;
			}
		}
		if (n % 2 == 0) {
			int op3 = countStepsTo1M(n / 2, storage);
			if (op3 < minSteps) {
				minSteps = op3;
			}
		}
		storage[n] = 1 + minSteps;
		return storage[n];
	}

	public static int countStepsTo1UsingDP(int n) {
		int storage[] = new int[n + 1];
		storage[1] = 0;

		for (int i = 2; i <= n; i++) {
			int minSteps = storage[i - 1];
			if (i % 3 == 0) {
				if (minSteps > storage[i / 3]) {
					minSteps = storage[i / 3];
				}
			}
			if (i % 2 == 0) {
				if (minSteps > storage[i / 2]) {
					minSteps = storage[i / 2];
				}
			}
			storage[i] = 1 + minSteps;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		System.out.println(countStepsTo1UsingDP(15));
	}
}

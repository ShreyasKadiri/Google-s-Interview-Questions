class Solution {
	public static int findMinimum(int arr[], int n, int k){
		int result=0;
		for (int i=0; i<n; i++) {
			// Buy current candy
			result+=arr[i];
			// And take k candies for free from the last
			n=n-k;
		}
		return result;
	}

	public static int findMaximum(int arr[], int n, int k){
		int result=0;
		int index=0;

		for (int i=n-1; i>=index; i--) {
			// Buy candy with maximum amount
			result+=arr[i];

			// And get k candies for free from the starting
			index+=k;
		}
		return result;
	}
}

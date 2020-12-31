/*
Approach:

The idea is to use Greedy algorithm where at every step, settle all amounts of one person and recur for remaining n-1 persons.
How to pick the first person? To pick the first person, calculate the net amount for every person where net amount is obtained by subtracting all debts (amounts to pay)
from all credits (amounts to be paid). Once net amount for every person is evaluated, find two persons with maximum and minimum net amounts. These two persons are the most 
creditors and debtors. The person with minimum of two is our first person to be settled and removed from list. Let the minimum of two amounts be x. We pay ‘x’ amount from the
maximum debtor to maximum creditor and settle one person. If x is equal to the maximum debit, then maximum debtor is settled, else maximum creditor is settled.


The following is detailed algorithm.
Do following for every person Pi where i is from 0 to n-1.
1) Compute the net amount for every person. The net amount for person ‘i’ can be computed be subtracting sum of all debts from sum of all credits.
2) Find the two persons that are maximum creditor and maximum debtor. Let the maximum amount to be credited maximum creditor be maxCredit and maximum amount to be debited 
from maximum debtor be maxDebit. Let the maximum debtor be Pd and maximum creditor be Pc.
3) Find the minimum of maxDebit and maxCredit. Let minimum of two be x. Debit ‘x’ from Pd and credit this amount to Pc
4) If x is equal to maxCredit, then remove Pc from set of persons and recur for remaining (n-1) persons.
5) If x is equal to maxDebit, then remove Pd from set of persons and recur for remaining (n-1) persons

*/



class Solution{ 	
	public static int getMin(int arr[]) { 
		int minInd = 0; 
		for (int i = 1; i < N; i++) 
			if (arr[i] < arr[minInd]) 
				minInd = i; 
		return minInd; 
	} 
	
	
	public static int getMax(int arr[]) { 
		int maxInd = 0; 
		for (int i = 1; i < N; i++) 
			if (arr[i] > arr[maxInd]) 
				maxInd = i; 
		return maxInd; 
	} 
	
	public static int minOf2(int x, int y) { 
		return (x < y) ? x: y; 
	} 
 
	public static void minCashFlowRec(int amount[]) { 
		int mxCredit = getMax(amount);
    int mxDebit = getMin(amount); 

		if (amount[mxCredit] == 0 && amount[mxDebit] == 0) 
			return; 
	
		int min = minOf2(-amount[mxDebit], amount[mxCredit]); 
		amount[mxCredit] -= min; 
		amount[mxDebit] += min; 
	
		minCashFlowRec(amount); 
	} 
	

	public static void minCashFlow(int graph[][]) { 
		int amount[]=new int[N]; 
		for (int p = 0; p < N; p++) 
		for (int i = 0; i < N; i++) 
			amount[p] += (graph[i][p] - graph[p][i]); 
	
		minCashFlowRec(amount); 
	} 
	

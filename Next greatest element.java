public class Solution {

private void swap(int[] number, int i, int j){
int temp=number[i];
number[i]=number[j];
number[j]=temp;
}

private void sortSubarray(int[] number, int i, int j){
while (i<j){
swap(number, i, j);
i+= 1;
j-= 1;
  }
}

public void findNextGreaterNumber(int[] number){
int lastDigitSeen=number[number.length-1];

for (i=number.length-2; i>=0; i--){
if (lastDigitSeen>number[i])
break;
lastDigitSeen=number[i];
 }

if(i>=0){
for (j=number.length-1; j>i; j--){
if(number[j]>number[i])
break;
}
}
swap(number, i, j);
sortSubarray(number, i+1, number.length-1);
}
}

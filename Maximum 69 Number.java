class Solution {
   public int maximum69Number (int num) {
        int store=num;
         int index=-1;
         int i=0;
        while(store > 0){
            if(store%10 == 6) {
                index=i;
            }
            store/= 10;
            i++;
        }
        return (index==-1) ? num : (num + 3 * (int)Math.pow(10, index));
    }
}

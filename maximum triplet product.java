class MaximumTripletProduct{
    public int maximumTripletProduct(int a[]){
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;
        
        for(int i=0; i<a.length; i++){
         if(a[i] <min1){
             min2=min1;
             min1= a[i];
         }
         else if(a[i] < min2){
             min2=a[i];
         }
         
         if(a[i] >=max1){
             max3=max2;
             max2=max1;
             max1=a[i];
         }
            
        else if(a[i] >=max2){
            max3=max2;
            max2=a[i];
        }
        
        else if(a[i]>=max3){
            max3=a[i];
        }
        
            
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}

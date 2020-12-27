class Solution{
    public static int maximumNonContiguousSum(int a[]){
        if(arr.length==0){
            return -1;
        }
        
        int include=a[0];
        int exclude=0;
        int excludeNew=0;
        
        for(int i=1; i<n; i++){
            excludeNew =(include > exclude) ? include : exclude;
            include = a[i] + exclude;
            exclude = excludeNew;
        }
     
     return Math.max(include, exclude);   
    }
}

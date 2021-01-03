class Solution{
    public int[] threeWayPartitioning(int a[], int low, int high){
     if(a.length==0){
         return a;
     }
     
     int left=0;
     int right=a.length-1;
     
     for(int i=0; i<a.length; i++){
         if(a[i] >low){
             //swap a[i] and a[low]
             swap(a[i], a[left]);
             left+=1;
         }
         
         if(a[i] < high){
             //Swap a[i] and a[high]
             swap(a[i], a[high]);
             right-=1;
         }
     }
     
     return a;   
    }
    
    public void swap(int x, int y){
        int t=x;
        x=y;
        y=t;
    }
}

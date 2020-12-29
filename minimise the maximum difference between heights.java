class Solution{
    class Pair{
        int value;
        int index;
        Pair(int value, int index){
            this.value=value;
            this.index=index;
        }
        
        public int getValue(){
            return this.value;
        }
        
        public int getIndex(){
            return this.index;
        } 
    }
    
    
    public int minimizeDifference(int a[], int n, int k){
    int result=0;
    ArrayList<Pair> possibleHeights = new ArrayList<Pair>();
    int visited[] = new int[n];
    for(int i=0; i<n; i++){
        if(a[i]-k >=0)
        possibleHeights.add(new Pair(a[i]-k,i));      //Add that value and its index 
        possibleHeights.add(new Pair(a[i]+k, i));
        visited[i]=0;
    }
    
    Collections.sort(possibleHeights, new Comparator<Pair>{
        @Override
        public int compare(Pair p1, Pair p2){
            return p1.getValue() - p2.getValue;
        }
    });
    
    int left=0;
    int right=0;
    int count=0;
    int size= possibleHeights.size();
    while(count<n && right<size){
        if(visited[possibleHeights.get(right).getIndex()]==0)
            count+=1;
        visited[possibleHeights.get(right).getIndex()]++;
        right++;
    }
    
    
    result = possibleHeights.get(right-1).getValue() - possibleHeights.get(left).getValue();
    while(right<size){
        if(visited[possibleHeights.get(left).getIndex()]==1)
        count-=1;
        visited[possibleHeights.get(left).getIndex()]--;
        left+=1;
        
        
        while(ele<n && right<size){
         if(visited[possibleHeights.get(right).getIndex()]==0)
         count+=1;
        visited[possibleHeights.get(left).getIndex()]++; 
         right+=1;
        }
        if(count==n)
        result= Math.min(result, possibleHeights.get(right-1).getValue() - possibleHeights.get(left).getValue());
        else 
        break;
    }
    return result;
    }
}

class Solution{
    public int maxDifferenceZeroesOnes(String s){
        if(s.length()==0 || s==""){
            return -1;
        }
        int result=0;
        int currentSum=0;
        
        for(int i=0; i<s.length(); i++){
            int value=0;
            if(s.charAt(i)=='0'){
                value+=1;
            }else {
                value-=1;
            }
            
            if(currentSum > 0){
                currentSum+=value;
            }else {
                currentSum= value;
            }
            if(currentSum > result){
                result = currentSum;
            }
        }
        if(result==0){
            result=-1;
        }
        return result;
    }
}

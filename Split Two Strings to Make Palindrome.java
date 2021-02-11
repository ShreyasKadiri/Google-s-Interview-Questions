class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        boolean checkPalindrome = isPalindrome(s, 0, a.length()-1);
        if(checkPalindrome == true){
            return true;
        }
        checkPalindrome = isPalindrome(b, 0, b.length()-1);
        if(checkPalindrome == true){
            return true;
        }
        
        int high = b.length()-1;
        for(int i=0; i<a.length(); i++; high--){
            if(a.charAt(i)!=b.charAt(high)){
                break;
            }
        }
        
        if(high==-1){
            return true;
        }
        checkPalindrome = isPalindrome(b, i , high);
        if(checkPalindrome == true){
            return true;
        }
        
        checkPalindrome = isPalindrome(a, i , high);
        if(checkPalindrome == true){
            return true;
        }
        
        
        high = a.length()-1;
        for(int i=0; i<a.length(); i++; high--){
            if(a.charAt(i)!=b.charAt(high)){
                break;
            }
        }
        
        if(high==-1){
            return true;
        }
        checkPalindrome = isPalindrome(a, i , high);
        if(checkPalindrome == true){
            return true;
        }
        
        checkPalindrome = isPalindrome(b, i , high);
        if(checkPalindrome == true){
            return true;
        }
        return false;
    }
    
    
    public boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low)!= s.charAt(high)){
                return false;
            }else {
                low+=1;
                high-=1;
            }
        }
        return true;
    }
}

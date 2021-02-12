class Solution {
    public int totalMoney(int n) {
        int totalMoney = 0;
        int initialMoney=1;
        int startingDayOfWeek=1;
        
        for(int i=1; i<=n; i++){
            totalMoney+=initialMoney;
            initialMoney+=1;
            
            //Completiton of the week
            if(i%7==0){
                startingDayOfWeek+=1;
                //Again start with new monday(starting day of every week) of every week 
                initialMoney = startingDayOfWeek;
            }
        }
        return totalMoney;
    }
}

class Solution {
    public int numberOfMatches(int n) {
    int matchesPlayed=0;
    int matches=0;
    int teamsAdvance=0;
    int temp=n;
        while(n>=1){
            matches=(int)Math.floor(n/2);
            matchesPlayed+=matches;
            teamsAdvance = temp - matchesPlayed;
            temp = teamsAdvance;
        }
        
        return matchesPlayed;
    }
}

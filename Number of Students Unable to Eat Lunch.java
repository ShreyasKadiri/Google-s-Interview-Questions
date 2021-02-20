class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int sandwichesCount[] = new int[2];
        for(int i=0; i<students.length; i++){
            sandwichesCount[students[i]]++;
        }
        
        for(int i=0; i<sandwiches.length; i++){
            if(sandwichesCount[sandwiches[i]]>0){
                sandwichesCount[sandwiches[i]]--;
            }else {
                return sandwichesCount[0]+sandwichesCount[1];
            }
        }
        
        return 0;
    }
}

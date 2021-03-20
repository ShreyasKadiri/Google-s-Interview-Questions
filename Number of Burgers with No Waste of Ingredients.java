/*
Approach:
x = no. of Jumbo Burgers, y = no. of small Burgers

4x + 2y = tomato (t)

x + y = cheese (c)**

x = (t - 2y) / 4; ---- from (1)

x = c - y; ---- from (2)

x = (t - 2y) / 4;
4c - 4y = t - 2y; ( put the value of x from 4 )
y = (4c - t) / 2;         (````)

x = c - y;
x = c - (4c - t) / 2; ( put the value of y from 5 )
x = (t - 2c) / 2;        (!!!!!!)

Now few obsevation :

a)tomatoSlices can not be odd number because it always be the multipe of 4 or 2.
b)cheeseSlices can't be greater than tomatoSlices.
c)The value of x and y can't negetive.


*/

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> combination = new ArrayList<Integer>();
        if(cheeseSlices>tomatoSlices || tomatoSlices%2==1){
            return combination;
        }
        int x = (tomatoSlices - (2*cheeseSlices))/2;   //from (!!!!!!)
        int y = (4*cheeseSlices - tomatoSlices)/2;     //from (````)
        
        if(x<0 || y<0){
            return combination;
        }
        
        combination.add(x);
        combination.add(y);
        return combination;
    }
}

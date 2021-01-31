class Solution {
public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
   HashMap<Integer, Integer> states = new HashMap<>();
    HashMap<Integer, Integer> row = new HashMap<>();
    HashMap<Integer, Integer> column = new HashMap<>();
    HashMap<Integer, Integer> primaryDiagnol = new HashMap<>();
    HashMap<Integer, Integer> secondaryDiagnol = new HashMap<>();
	
		for (int i=0; i<lamps.length; i++) {
			int r= lamps[i][0];
			int c= lamps[i][1];
			int bulbIndex = (r*N) + c;
			states.put(bulbIndex, states.getOrDefault(bulbIndex, 0) + 1);
			row.put(r, row.getOrDefault(r, 0) + 1);
			column.put(c, column.getOrDefault(c, 0) + 1);
			primaryDiagnol.put(r+c, primaryDiagnol.getOrDefault(r+c, 0) + 1);
			secondaryDiagnol.put(r-c, secondaryDiagnol.getOrDefault(r-c, 0) + 1);
		}
		
    int[] result = new int[queries.length];
	int[][] directions = { {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0 }, {1,-1}, {0,-1}, {-1,-1} };
	
    for (int i=0; i<queries.length; i++) {
        int r = queries[i][0];
        int c = queries[i][1];
        int index = (r * N) + c;
if (row.getOrDefault(r,0)!=0 || column.getOrDefault(c,0)!=0 || primaryDiagnol.getOrDefault(r+c, 0)!=0
                || secondaryDiagnol.getOrDefault(r-c, 0)!=0) {
            result[i] = 1; // Update answer
    
            // update grid
				if (states.getOrDefault(index, 0) != 0) { // own check
					states.put(index, states.get(index) - 1);
					row.put(r, row.get(r) - 1);
					column.put(c, column.get(c) - 1);
					primaryDiagnol.put(r + c, primaryDiagnol.get(r + c) - 1);
					secondaryDiagnol.put(r - c, secondaryDiagnol.get(r - c) - 1);
				}
				
                //adjacent check
				for (int k=0; k<directions.length; k++) { 
                int nextRow = r + directions[k][0];
                int nextColumn = c + directions[k][1];
                int nextIndex = (nextRow * N) + nextColumn;
    if (nextRow>=0 && nextColumn>=0 && nextRow<N && nextColumn<N && states.getOrDefault(nextIndex,0)!=0) {
                    states.put(nextIndex, states.get(nextIndex) - 1);
                    row.put(nextRow, row.get(nextRow) - 1);
                    column.put(nextColumn, column.get(nextColumn) - 1);
                    primaryDiagnol.put(nextRow+nextColumn, primaryDiagnol.get(nextRow+nextColumn) - 1);
                    secondaryDiagnol.put(nextRow-nextColumn, secondaryDiagnol.get(nextRow-nextColumn) - 1);
                }
            }
        }
    }
    return result;
  }
}

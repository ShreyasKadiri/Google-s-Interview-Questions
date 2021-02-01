class Solution {
    public boolean isTransformable(String s, String t) {
        HashMap<Integer, List<Integer>> map= new HashMap<Integer, List<Integer>>();
        
        for (int i=0; i<s.length(); i++)
            map.computeIfAbsent((int)s.charAt(i), k->new LinkedList<>()).add(i);
        int i=0;
        int prev=-1;
        int position=-1;
        
        while (i<t.length()){
            int c = t.charAt(i++);
            
            if (!map.containsKey(c) || map.get(c).isEmpty()) {
                return false;    
            }
                
            if(prev<c){
                pos=map.get(c).remove(0);
            }else{
                int temp = map.get(c).remove(0);
                if (temp<pos) return false;
                pos=temp;
            }
            prev=c;
        }
        return true;
    }
}

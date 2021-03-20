class UndergroundSystem {
    private HashMap<Integer, Event> arrivals;
    private HashMap<String, Average> averages;
    private final String  DELIMITER = ",";
    
    public UndergroundSystem() {
        arrivals = new HashMap<>();
        averages = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        arrivals.put(id, new Event(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Event arrivalEvent =  arrivals.get(id);
        arrivals.remove(id);
        
        //Calculating the overall time 
        int timeDifference = t -  arrivalEvent.time;
        String key = arrivalEvent.stationName + DELIMITER + stationName;
        
        Average average = averages.containsKey(key) ? averages.get(key) : new Average();
        average.updateAverage(timeDifference);
        averages.put(key, average);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + DELIMITER + endStation;
        return averages.get(key).getAverage();
    }
    
    class Event{
        public int id;
        public String stationName;
        public int time;
        
        public Event(int id, String stationName, int time){
            this.id = id;
            this.stationName  = stationName;
            this.time = time;
        }
    }
    
    class Average{
        public double total = 0;
        public int count = 0;

    public void updateAverage(int difference){
        ++count;
        total+=difference;
    }
    
    public double getAverage(){
        return total / count;
    }
        
  }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

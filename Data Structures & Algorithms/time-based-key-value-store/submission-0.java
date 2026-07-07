class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        TreeMap<Integer, String> timeMap = map.get(key);
        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
        
        return entry == null ? "" : entry.getValue();
    }
}

class TimeMap {
    private Map<String, List<AbstractMap.SimpleEntry<Integer, String>>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new AbstractMap.SimpleEntry<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        List<AbstractMap.SimpleEntry<Integer, String>> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String result = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midTime = list.get(mid).getKey();
            
            if (midTime == timestamp) {
                return list.get(mid).getValue();
            } else if (midTime < timestamp) {
                result = list.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
}
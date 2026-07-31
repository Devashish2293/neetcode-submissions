class Twitter {

    Map<Integer,List<Integer>> followMap;
    List<Pair<Integer,Integer>> tweetList;

    public Twitter() {
        followMap = new HashMap();
        tweetList = new LinkedList();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetList.addFirst(new Pair<>(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> followees = followMap.containsKey(userId)?followMap.get(userId) : new ArrayList();
        List<Integer> newsFeed = new ArrayList();
      
        for (Pair<Integer, Integer> pair : tweetList) {
            if(followees.contains(pair.getKey()) || userId == pair.getKey())
                newsFeed.add(pair.getValue());
            if(newsFeed.size()==10)
                return newsFeed;
            }

         return newsFeed;           
    }
    
    public void follow(int followerId, int followeeId) {
         List<Integer> list = followMap.computeIfAbsent(followerId, k -> new ArrayList<>());
        if (!list.contains(followeeId)) {  
            list.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = followMap.get(followerId);
        if (list != null) {
            list.remove(Integer.valueOf(followeeId)); 
        }
    }
}

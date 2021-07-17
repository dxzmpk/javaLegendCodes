package com.company.collections;

import java.util.*;
import java.util.stream.Collectors;

public class FriendsMovies {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        Set<Integer> lowerFriends = new HashSet<>();

        Set<Integer> currentFriends = new HashSet<>();

        for (int i = 0; i < friends[id].length; i ++) {
            currentFriends.add(friends[id][i]);
            lowerFriends.add(friends[id][i]);
        }

        lowerFriends.add(id);

        level --;


        while (level > 0) {

            List<Integer> tempFriends = new ArrayList<>();

            for(Integer currentFriend: currentFriends){

                tempFriends.addAll( notInLowerToList(friends[currentFriend], lowerFriends) );

            }

            lowerFriends.addAll(tempFriends);

            currentFriends = new HashSet<>();

            currentFriends.addAll(tempFriends);

            System.out.println(tempFriends + " " + lowerFriends+" " + currentFriends);

            level --;

        }

        List<String> videos = new ArrayList<>();

        currentFriends.forEach((x) -> videos.addAll(watchedVideos.get(x)));


        // Map<String, Integer> countMap = videos.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<String, Integer> countMap = new HashMap<>();
        for (String video:videos){
            countMap.put(video, countMap.getOrDefault(video, 0) + 1);
        }

        List<String> results = new ArrayList<>();

        for (String video : countMap.keySet()){
            results.add(video);
        }

        Collections.sort(results, (v1, v2) -> {
            if ( countMap.get(v1) - countMap.get(v2) == 0 ) {
                return v1.compareTo(v2);
            }
            return countMap.get(v1) - countMap.get(v2);
        });

        return results;

    }

    public List<Integer> notInLowerToList(int[] temps, Set<Integer> lowerFriends){
        return Arrays.stream(temps).boxed().filter((x) -> !lowerFriends.contains(x)).collect(Collectors.toList());
    }



}

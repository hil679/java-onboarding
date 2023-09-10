package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = getNotFriendUserList(user, friends, visitors);
        return answer;
    }
    //해당 사용자(user)와 친구인 list 제작 및 사용자 중 친구가 아닌 사람 hashmap
    public static List<String> getNotFriendUserList(String user, List<List<String>> friends, List<String> visitors){
        HashMap<String, Integer> userList = new HashMap<>();
        List<String> userFriends = getFriends(user, friends);

        for(List<String> listRelationship: friends){
            if(!listRelationship.contains(user) && (!userFriends.contains(listRelationship.get(0)) || !userFriends.contains(listRelationship.get(1)))) { // 자신이 있는 relationship 또는 relationship list원소 모두 내 친구인 경우 패스

                if (userFriends.contains(listRelationship.stream().iterator().next())) {

                    String recommendFriend = userFriends.contains(listRelationship.get(0))? listRelationship.get(1) : listRelationship.get(0);
                    if (userList.containsKey(recommendFriend)) {
                        userList.put(recommendFriend, userList.get(recommendFriend) + 10);
                    } else {
                        userList.put(recommendFriend, 10);
                    }
                }
            }
        }

        for(String visitor: visitors){
            if(!userFriends.contains(visitor)) {
                if (!userList.containsKey(visitor)) {
                    userList.put(visitor, 1);
                } else {
                    userList.put(visitor, userList.get(visitor) + 1);
                }
            }
        }
        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer>>(userList.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2){
                if(o1.getValue().equals(o2.getValue())){
                    return (o1.getKey()).compareTo(o2.getKey());
                }
                System.out.println(o1.getValue() + " " + o2.getValue());
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        int elemNum = 0;
        for (Map.Entry<String, Integer> userInfo : list) {
            if(elemNum == 5 || userInfo.getValue() == 0)
                break;
            temp.put(userInfo.getKey(), userInfo.getValue());
            ++elemNum;
        }

        return temp.keySet().stream().collect(Collectors.toList());
    }

    public static List<String> getFriends(String user, List<List<String>> friends){
        List<String> userFriends = new ArrayList<>();

        for(List<String> listRelationship: friends) {
            if (listRelationship.contains(user)) {//지금 내 친구
                String friend = listRelationship.get(0) == user? listRelationship.get(1) : listRelationship.get(0);
                userFriends.add(friend);
            }
        }
        return userFriends;
    }
}

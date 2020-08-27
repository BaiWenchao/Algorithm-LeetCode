import java.util.*;

/**
 * #332. 重新安排行程：
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。*/

class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket: tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }

        dfs("JFK");
        Collections.reverse(itinerary);

        return itinerary;
    }

    public void dfs(String src) {
        while(map.containsKey(src) && map.get(src).size() != 0) {
            String dst = map.get(src).poll();
            dfs(dst);
        }
        itinerary.add(src);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

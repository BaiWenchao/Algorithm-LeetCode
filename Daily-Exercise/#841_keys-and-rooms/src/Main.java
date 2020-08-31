import java.util.*;

/**
 * #841. 钥匙和房间：
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，
 * 并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，
 * 其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。*/

class Solution {
    private Set<Integer> set = new HashSet<>();
    List<List<Integer>> globalRooms;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        set.add(0);
        globalRooms = rooms;
        dfs(globalRooms.get(0));
        return set.size() == rooms.size();
    }
    public void dfs(List<Integer> keys) {
        for (int i=0; i<keys.size(); i++) {
            int key = keys.get(i);
            if (set.contains(key)) continue;
            set.add(key);
            dfs(globalRooms.get(key));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> rooms = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1,3)),
                new ArrayList<>(Arrays.asList(1,4)),
                new ArrayList<>(Arrays.asList(2,3,2,4,1)),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(4,3,2))
        ));
        System.out.println(s.canVisitAllRooms(rooms));
    }
}

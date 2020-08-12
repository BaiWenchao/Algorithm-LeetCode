import java.util.*;

/**
 * #133. 克隆图
 * 给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
 * 途中的每个节点都包含它的值val(int)和其它邻居的列表(List[Node])
 *
 * 本题是广度优先遍历和深度优先遍历的基本应用
 * 图不同于树，存在回路，所以可能导致死循环或者无限递归
 * 因此需要使用map进行节点标记*/

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// 解法1：广度优先遍历
//class Solution {
//    // 由于无向图中相邻节点互为邻居，所以应该使用map对已访问节点进行标记，防止无限递归
//    private HashMap<Node, Node> visited = new HashMap<>();
//    public Node dfs(Node node, HashMap<Node, Node> visited) {
//        // 1. 退出条件：该节点已经被访问过（存在于哈希表中）
//        // 表中key为原先的node，value为对应原node拷贝的node
//        if (visited.containsKey(node)) {
//            // 直接返回key对应的node
//            return visited.get(node);
//        }
//
//        // 如果该结点没有被访问过，则new一个节点
//        // 由于新节点必须在递归前存入哈希表（避免无限递归），所以暂时将neighbours初始化为空list
//        Node cloneNode = new Node(node.val, new ArrayList<>());
//        // 将该节点存入哈希表
//        visited.put(node, cloneNode);
//
//        // 递归地写入节点的neighbours
//        for (Node neighbour : node.neighbors) {
//            cloneNode.neighbors.add(dfs(neighbour, visited));
//        }
//
//        // 返回节点
//        return cloneNode;
//    }
//
//    public Node cloneGraph(Node node) {
//        if (node == null) return null;
//        return dfs(node, visited);
//    }
//}


// 解法2：BFS
class Solution {
    private HashMap<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        // 当输入节点为空时：直接返回空
        if (node == null) return null;
        // 使用队列实现BFS
        Queue<Node> queue = new LinkedList<>();
        // 使用输入节点初始化队列以及哈希表
        queue.offer(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        while(!queue.isEmpty()) {
            Node outNode = queue.poll();
            // 对出队节点的neighbours进行赋值，同时更新队列及哈希表
            for (Node neighbour : outNode.neighbors) {
                // 确保该节点没被访问过，否则直接取出下一个neighbour
                if (!visited.containsKey(neighbour)) {
                    queue.offer(neighbour);
                    visited.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                }
                // 更新neighbour列表
                visited.get(outNode).neighbors.add(visited.get(neighbour));
            }
        }

        return cloneNode;
    }
}

public class Main {
    public static void main(String[] args) {
        // 构造图：
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors = new ArrayList<>(Arrays.asList(n2, n4));
        n2.neighbors = new ArrayList<>(Arrays.asList(n1, n3));
        n3.neighbors = new ArrayList<>(Arrays.asList(n2, n4));
        n4.neighbors = new ArrayList<>(Arrays.asList(n1, n3));

        Solution solution = new Solution();
        Node n_1 = solution.cloneGraph(n1);
        Node n_2 = n_1.neighbors.get(0);

        n_2.neighbors.forEach(item -> System.out.println(item.val));
    }
}

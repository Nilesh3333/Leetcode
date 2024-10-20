import java.util.*;

//Time - O(E log N)   Push and pop in PriorityQueue take log N times , Space - (E+N)
public class NetworkDelay743 {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }

    public static int networkDelayTime(int[][] times,int n,int k){
        int delay = 0;
        HashMap<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for(int[] time : times){
            int src = time[0];
            int des = time[1];
            int edge = time[2];
            adjacencyList.computeIfAbsent(src,key -> new ArrayList<>()).add(new int[]{des,edge});
        }
        // Priority queue for Dijkstra's algorithm (min-heap based on time)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k,0});
        HashSet<Integer> visited = new HashSet<>();

        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int src = arr[0];
            int time = arr[1];

            // Skip if the node has been visited
            if(!visited.add(src))
                continue;

            delay = Math.max(delay,time);

            List<int[]> neighbours = adjacencyList.getOrDefault(src,new ArrayList<>());
            for(int[] neighbour : neighbours){
                int neighbourNode = neighbour[0];
                int neighbourTime = neighbour[1];
                if(!visited.contains(neighbourNode))
                    pq.add(new int[]{neighbourNode,time+neighbourTime});      //adding the times!
            }
        }

        // Check if all nodes have been visited
        return visited.size() == n ? delay : -1;
    }
}

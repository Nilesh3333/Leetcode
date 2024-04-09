import java.util.LinkedList;

public class RecentCounter933 {
    private static LinkedList<Integer> queue;
    public static void main(String[] args) {
        RecentCounter933 obj = new RecentCounter933();
        int ans = obj.ping(200);
        System.out.println(ans);
    }
    public RecentCounter933() {
        queue = new LinkedList<>();
    }

    public static int ping(int t) {
        queue.add(t);
        while (queue.peek() < t-3000)
            queue.poll();
        return queue.size();
    }
}
